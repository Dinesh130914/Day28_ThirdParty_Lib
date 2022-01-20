package com.addressbook;
import com.google.gson.*;
public class ObjtoGson {
	public static void main(String[] args) {
		Contact cont1 = new Contact("Dinesh", "Thiyagarajan", "Virudhunagar", "Tamilnadu", "8608894623", "626119",
				"dinesh@gmail.com");
		
		Gson gson = new Gson();
		String json= gson.toJson(cont1);
		System.out.println(json);
	}
}
