package com.example.demo.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.multi.service.MultiService;

@Controller
public class MultiController {
	//フィールド変数=================
	private final MultiService multiService;

	//コンストラクタ=================
	public MultiController(MultiService multiService) {
		super();
		this.multiService = multiService;
	}

	//結果をHTMLに表示するメソッド=================
	@GetMapping("multi")
	public String multi(Model model) {

		String result = "";

		result = String.valueOf(multiService.multi(5, 6));

		model.addAttribute("result", result);

		return "multi.html";
	}

}
