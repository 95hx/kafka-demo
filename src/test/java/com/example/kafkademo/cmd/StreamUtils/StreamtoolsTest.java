package com.example.kafkademo.cmd.StreamUtils;

import com.example.kafkademo.cmd.CmdUtils.RunCmd;

public class StreamtoolsTest {

	public static void main(String[] args) {
		String command="C:\\Users\\hx\\Pictures\\kafka\\bin\\windows\\zookeeper-server-start.bat C:\\Users\\hx\\Pictures\\kafka\\config\\zookeeper.properties\n";
		String result = RunCmd.parse(command);
		System.out.println("result:"+result);
	}

}
