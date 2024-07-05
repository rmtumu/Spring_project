package com.example.demo.minus.service;

import org.springframework.stereotype.Service;

//アノテーションは必須
@Service
public class MinusService {
	//引き算メソッド=================
	public int Minus(int leftSidenumber, int rightSidenumber) {

		return leftSidenumber - rightSidenumber;

	}

}
