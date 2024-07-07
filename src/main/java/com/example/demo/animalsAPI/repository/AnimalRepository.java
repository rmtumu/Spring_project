package com.example.demo.animalsAPI.repository;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.sampleAPI.data.Animals;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class AnimalRepository {

	////フィールド変数 定数にURLを代入して管理 =================
	private final String url = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI";

	//メソッド=================
	public Animals[] getAnimalsList() throws IOException {

		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(url, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		Animals[] animalsList = mapper.readValue(json, Animals[].class);

		return animalsList;
	}

	//メソッド=================
	public Animals[] getAnimal(int animalId) throws IOException {

		// 注意！　"?id =" この記述(idと=の間にスペースがあると)だとすべての動物の一覧が表示されてしまう。ここに気づくのに5時間ほどかかった。=================
		String detailurl = url + "?id=" + animalId;

		RestTemplate rest = new RestTemplate();

		ResponseEntity<String> response = rest.getForEntity(detailurl, String.class);

		String json = response.getBody();

		ObjectMapper mapper = new ObjectMapper();

		Animals[] animalList = mapper.readValue(json, Animals[].class);

		return animalList;
	}
}
