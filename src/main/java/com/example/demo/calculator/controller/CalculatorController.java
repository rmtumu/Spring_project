package com.example.demo.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

//アノテーションは必須
@Controller
public class CalculatorController {
	//フィールド変数=================
	private final CalculatorService calculatorService;

	//コンストラクタ=================
	public CalculatorController(CalculatorService calculatorService) {
		super();
		this.calculatorService = calculatorService;
	}

	//html表示メソッド
	@GetMapping("calculator")
	public String showCalculatorForm() {
		return "calculator.html";
	}

	//パラメータを受け取り計算結果を出力するメソッド
	@GetMapping("calculatorRegister")
	public String calculateAndDisplay(@RequestParam("leftSidenumber") int leftSide,
			@RequestParam("symbol") String symbol,
			@RequestParam("rightSidenumber") int rightSide,
			Model model) {

		//それぞれの値代入用の変数宣言
		String calculatorResult = "";

		try {
			calculatorResult = String.valueOf(calculatorService.calculator(leftSide, symbol, rightSide));

		} catch (ArithmeticException e) {
			calculatorResult = "ゼロ除算はできません。";

		} catch (NumberFormatException e) {
			calculatorResult = "値を確認してください。";
		}

		model.addAttribute("calculatorResult", calculatorResult);//属性名："result"、 属性値：result

		return "calculator.html";
	}

}
