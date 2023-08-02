package com.thejoeun.team2.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

	//BOARD 이하 B
	//인덱스번호
	private int num;
	//게시글아이디
	private int  BoardId;
	//*맴버아이디*
	private String memberID;
	//게시글제목
	private String BTitle;
	//게시글 내용
	private String BContent;
	//게시글 날자
	private String BDate;
//	private String delete_yn;
	
	@Override
	public String toString() {
		return "Board [num=" + num + ", board_id=" + BoardId + ", member_id=" + memberID + ", board_title="
				+ BTitle + ", board_content=" + BContent + ", board_date=" + BDate + "]";
	}
}
