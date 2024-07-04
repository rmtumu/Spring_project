package com.example.demo.fizzBuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {
	//FizzBuzzメソッド=================
	public List<String> fizzBuzz() {

		//ArrayListオブジェクト生成
		List<String> fizzBuzzlist = new ArrayList<>();

		for (int i = 1; i <= 100; i++) {
			if (i % 15 == 0) {
				fizzBuzzlist.add("FizzBuzz");//addメソッドを用いて Listに文字列格納
			} else if (i % 5 == 0) {
				fizzBuzzlist.add("Buzz");
			} else if (i % 3 == 0) {
				fizzBuzzlist.add("Fizz");
			} else {
				fizzBuzzlist.add(Integer.toString(i));//int型の i を String型に変換
			}
		}

		return fizzBuzzlist;

	}

}
