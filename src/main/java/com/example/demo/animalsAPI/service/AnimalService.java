package com.example.demo.animalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.animalsAPI.repository.AnimalRepository;
import com.example.demo.sampleAPI.data.Animals;

@Service
public class AnimalService {
	//フィールド変数=================
	private final AnimalRepository animalRepository;

	//コンストラクタ=================
	public AnimalService(AnimalRepository animalRepository) {
		super();
		this.animalRepository = animalRepository;
	}

	//メソッド=================
	public List<Animals> getAnimalsList() throws IOException {

		Animals[] animalsList = animalRepository.getAnimalsList();

		//asListメソッドで引数で指定した配列をリストとして返す
		return Arrays.asList(animalsList);

	}

	//メソッド=================
	public List<Animals> getAnimal(int animalId) throws IOException {

		Animals[] animalList = animalRepository.getAnimal(animalId);

		return Arrays.asList(animalList);
	}

}
