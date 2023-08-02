package com.thejoeun.team2.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.thejoeun.team2.model.Covid19Data;
import com.thejoeun.team2.repository.Covid19DataRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Covid19Service {
	
	private final Covid19DataRepository covid19DataRepository;
	
	@Scheduled(cron = "10,40 * * * * *", zone = "Asia/Seoul")		// test code
//	@Scheduled(cron = "0 0 5 * * ?", zone = "Asia/Seoul")
	@Async
	public void covid19(){
		
		LocalDate today = LocalDate.now();
		Long cnt = 1L;						// db update 에 사용
		for (int i = 7; i > 0; i--) {
			LocalDate periodDate = today.minusDays(i);
			String date = periodDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
			String result = "";
			String key = "XUVrJtmGedova%2Bdaukoe%2BZnZWoLyIFD5A3hHxLz2hrl5anGuVxjvKVgocTANwqJ6VeFlzmDW1VVNVZ7f2ho9jQ%3D%3D";
			try {
				URL url = new URL("http://apis.data.go.kr/1352000/ODMS_COVID_04/callCovid04Api?serviceKey="
						+ key
						+ "&pageNo=1&numOfRows=500&apiType=JSON"
						+ "&std_day=" + date //  2023-05-25"
						+ "&gubun=%EC%84%9C%EC%9A%B8");
				BufferedReader bf;
				bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				result = bf.readLine();
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
				String resultCode = (String) jsonObject.get("resultCode");
				
				if (!resultCode.equals("00")) {			return;			}

				JSONArray items = (JSONArray) jsonObject.get("items");
				JSONObject item = (JSONObject) items.get(0);
				
				String stdDay = (String) item.get("stdDay");
				String currentDate = stdDay.substring(8, 10) + " 일";
				int localOccCnt = Integer.parseInt((String) item.get("localOccCnt"));
				
				if (covid19DataRepository.count() != 7) {
					insertTimeTemp(currentDate, localOccCnt, LocalDateTime.now());   		// 초기 DB 셋팅을 위한 코드
					continue;
				} else {
					updateTimeTemp(currentDate, localOccCnt, LocalDateTime.now(), cnt++);				
				}
		
			}catch(Exception e) {	    	e.printStackTrace();	    }
		
		}
	
	}
	
	public void insertTimeTemp(String day, int people, LocalDateTime inputTime) {
		Covid19Data cd = new Covid19Data();
		cd.setDay(day);
		cd.setPeople(people);
		cd.setInputTime(inputTime);
		this.covid19DataRepository.save(cd);
	}

	private void updateTimeTemp(String day, int people, LocalDateTime inputTime, long cnt) {
		Optional<Covid19Data> oc = covid19DataRepository.findById(cnt);
		if (oc.isPresent()) {
			Covid19Data covid19Data = oc.get();
			
			covid19Data.setDay(day);
			covid19Data.setPeople(people);
			covid19Data.setInputTime(inputTime);
			
			covid19DataRepository.save(covid19Data);
		}
	}

}
