package com.example.kafkademo.cmd.CmdUtils;

import com.example.kafkademo.cmd.StreamUtils.InputStream2String2;

public class RunCmd {

	public static String parse(String command) {
		try {
			
			Process process = Runtime.getRuntime().exec(command);
			return InputStream2String2.parse(process.getInputStream());
		} catch (Exception e) {
			return "catch exception";
		}
	}
	
}
