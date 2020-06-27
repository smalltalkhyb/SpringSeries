package com.smalltalk.content.center;

import java.io.*;
import java.util.Scanner;

/**
 * @author: ybhu
 * @create: 2020/05/26 14:01
 */
public class ScanXan {
    public static void main(String[] args) {
        FileInputStream fstream = null;
        String dir = "F:\\kkb-enterprise-wechat-log\\";
        String template = dir + "kkb-enterprise-wechat-%s";
        String fileName = "55c55955c7-2k4lk";
        try {
            fstream = new FileInputStream(String.format(template, fileName));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            int i = 1;
            /* read log line by line */
            while ((strLine = br.readLine()) != null) {
                processLine(strLine);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (fstream != null) {
                try {
                    fstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private  static void processLine(String strLine) {

    }
}
