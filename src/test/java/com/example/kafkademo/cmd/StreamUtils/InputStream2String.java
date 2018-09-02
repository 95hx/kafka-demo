package com.example.kafkademo.cmd.StreamUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStream2String {
	public static String parse(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuffer sb = new StringBuffer();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			return sb.toString();
		} catch (IOException e) {
			return "catch exception";
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				System.out.println("catch is.close() exception");
			}
		}
	}
}
