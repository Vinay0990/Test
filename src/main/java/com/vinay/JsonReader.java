package com.vinay;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader  {
	public File file;
	public ObjectMapper mapper;
	
	public JsonReader() {
		super();
		this.file = new File("src/main/resources/addresses.json");
		this.mapper =  new ObjectMapper();
	}

	public List<Address> readJsonFile() {
		List<Address> addresses = new ArrayList<>();
		try {
			Root[] arr = mapper.readValue(this.file, Root[].class);
			addresses = Arrays.stream(arr).map(r -> JsonReaderUtils.convertRootToAddress(r)).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addresses;
	}

}
