package com.example.kafkademo.cmd.StreamUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStream2String2 {
    public static String parse(InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            return baos.toString();
        } catch (IOException e) {
            return "catch exception";
        } finally {
            try {
                baos.close();
                is.close();
            } catch (IOException e) {
                System.out.println("catch baos.close() exception");
            }
        }
    }
}
