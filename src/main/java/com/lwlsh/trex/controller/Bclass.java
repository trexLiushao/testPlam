package com.lwlsh.trex.controller;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

public class Bclass {

	public static void main(String[] args) {
		Connection connection=Jsoup.connect("http://localhost:8080/SSMiframe/userInfo");
		connection.data("userName","12");
		connection.data("password","123456");
		//connection.data(header);
		connection.timeout(3000);
		connection.method(Method.POST);
		connection.ignoreContentType(true);
		Response response = null;
		try {
			response = connection.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response.statusCode());
		System.out.println(response.body());
		Map<String, String> cookies=response.cookies();
	}
}
