package com.thejoeun.team2.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Covid19Controller {

	@Autowired
	private EntityManager entityManager;

	@GetMapping("/thejoeun/covid19")
	public String covid19Inspect(Model model) {
		Query query = entityManager.createQuery("SELECT day, people FROM Covid19Data ORDER BY id ASC");
		List<Object[]> results = query.getResultList();

		JSONArray inspectArray = new JSONArray();
		for (Object[] result : results) {
			String day = (String) result[0];
			int people = (int) result[1];

			JSONObject root = new JSONObject();
			root.put("day", day);
			root.put("people", people);
			inspectArray.add(root);

		}
		model.addAttribute("covid19", inspectArray);

		return "thejoeun/covid19";
	}
}