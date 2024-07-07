package com.example.demo.animalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalsAPI.service.AnimalService;
import com.example.demo.sampleAPI.data.Animals;

@Controller
public class AnimalController {
	//フィールド変数=================
	private final AnimalService animalService;

	//コンストラクタ=================
	public AnimalController(AnimalService animalService) {
		super();
		this.animalService = animalService;
	}

	//html表示メソッド=================
	@GetMapping("animal-search") //http://localhost:8080/animal-searchでローカル表示
	public String showAnimalSearchForm(Model model) throws IOException {

		List<Animals> animalsList = animalService.getAnimalsList();

		model.addAttribute("animalsList", animalsList);

		return "animal-search.html";
	}

	//パラメータを受け取り詳細を出力するメソッド=================
	@GetMapping("animal-detail")
	public String animalDetailView(@RequestParam("animalId") int animalId, Model model) throws IOException {

		List<Animals> animalList = animalService.getAnimal(animalId);

		model.addAttribute("animalList", animalList);

		return "animal-detail.html";

	}
}
