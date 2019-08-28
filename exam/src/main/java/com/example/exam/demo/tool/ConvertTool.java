package com.example.exam.demo.tool;


import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.*;


public class ConvertTool {
    public static void convertFileToJson(File file) {
        String str = readFile(file);
        String json = JSON.toJSONString(convertStringToMap(str));
        writeFile(json, file.getName().substring(0, file.getName().indexOf(".")) + ".json");
    }

    private static void writeFile(String json, String fileName) {
        File file = new File(fileName);

        Writer out = null;
        try {
            out = new FileWriter(file);
            out.write(json);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(File file) {

        StringBuffer sb = new StringBuffer();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String str = "";
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static List<Map<String, String>> convertStringToMap(String str) {
        System.out.println(str);
        List<Map<String, String>> resultList = new ArrayList<>();
        String[] strings = str.split("[$][$][$][$]");
        Arrays.stream(strings).forEach(s -> resultList.add(convertSingleData(s)));
        return resultList;
    }

    private static Map<String, String> convertSingleData(String str) {
        Map<String, String> map = new HashMap<>();
        String[] strings = str.split(">");
        map.put("Structure", strings[0]);
        for (int i = 1; i < strings.length; i = i + 2) {
            String key = strings[i].replace("<", "").trim();
            String value = strings[i + 1].trim();
            map.put(key, value);
        }
        return map;
    }
}
