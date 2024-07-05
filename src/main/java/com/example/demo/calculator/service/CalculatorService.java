package com.example.demo.calculator.service;

import org.springframework.stereotype.Service;

//つけることでインスタンス化できる。つけ忘れるとparameter 0 of constructor in required a bean of type that could not be found.というエラーが発生
@Service
public class CalculatorService {
	//四則演算メソッド=================
	public int calculator(int leftSide, String symbol, int rightSide) throws ArithmeticException {
		//結果を代入する変数宣言
		int result = 0;

		switch (symbol) {
		case "+":
			result = leftSide + rightSide;
			break;//ここで breakを忘れない。忘れると次の caseの処理が行われる

		case "-":
			result = leftSide - rightSide;
			break;

		case "×":
			result = leftSide * rightSide;
			break;

		case "÷":
			result = leftSide / rightSide;
			break;
		}
		return result;
	}
}
