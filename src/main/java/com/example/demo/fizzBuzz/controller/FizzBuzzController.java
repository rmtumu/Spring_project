package com.example.demo.fizzBuzz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.fizzBuzz.service.FizzBuzzService;

@Controller
public class FizzBuzzController {
	//フィールド変数=================
	private final FizzBuzzService fizzBuzzService;

	//コンストラクタ=================
	public FizzBuzzController(FizzBuzzService fizzBuzzService) {
		super();
		this.fizzBuzzService = fizzBuzzService;
	}

	//結果をHTMLに表示するメソッド=================
	@GetMapping("fizzBuzz")
	public String multi(Model model) {

		List<String> result;

		result = fizzBuzzService.fizzBuzz();

		model.addAttribute("fizzBuzzNumbers", result);

		return "fizzBuzz.html";
	}

}
