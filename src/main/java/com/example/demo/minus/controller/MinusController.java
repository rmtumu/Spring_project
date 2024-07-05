package com.example.demo.minus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.minus.service.MinusService;

//アノテーションは必須
@Controller
public class MinusController {
	//フィールド変数=================
	private final MinusService minusService;

	//コンストラクタ=================
	public MinusController(MinusService minusService) {
		super();
		this.minusService = minusService;
	}

	//html表示メソッド
	@GetMapping("minus")
	public String showMinusForm() {
		return "minus.html";
	}

	//パラメータを受け取り計算結果を出力するメソッド
	@GetMapping("minusRegister")
	public String minusAndDisplay(@RequestParam("leftSide") int leftSidenumber,
			@RequestParam("rightSide") int rightSidenumber,
			Model model) {

		int minusResult = minusService.Minus(leftSidenumber, rightSidenumber);

		model.addAttribute("minusResult", minusResult);

		return "minus.html";
	}
}
