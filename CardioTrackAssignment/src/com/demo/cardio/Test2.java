package com.demo.cardio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Here we just have to provide folder name, it will read all files and classify them accordingly
public class Test2 {

	static Map<String, List<String>> map = new HashMap<>();

	static List<String> earthList = new ArrayList<>();

	static List<String> waterList = new ArrayList<>();

	static List<String> spaceList = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		// System.out.println("Please provide file name in format 'file1.txt'");
		File dir = new File("D:\\Text\\");
		File[] files = dir.listFiles();
		for (File f : files) {
			System.out.println(f);
		}

		// Fetching all the files
		for (File file : files) {
			if (file.isFile()) {
				BufferedReader br = null;
				String line;
				try {
					br = new BufferedReader(new FileReader(file));
					String str = "";

					line = br.readLine();
					while (line != null) {
						str = str + line;
						
						if (str.toLowerCase().contains("earth")) {
							if (!earthList.contains(file.getName())) {
								earthList.add(file.getName());
								map.put("Earth", earthList);
							}

						}
						if (str.toLowerCase().contains("water")) {
							if (!waterList.contains(file.getName())) {
								waterList.add(file.getName());
								map.put("Water", waterList);
							}

						}
						if (str.toLowerCase().contains("space")) {
							if (!spaceList.contains(file.getName())) {
								spaceList.add(file.getName());
								map.put("Space", spaceList);
							}
						}

						System.out.println("-----------------------");
						line = br.readLine();
					}
					System.out.println(str);
					map.forEach((k, v) -> System.out.println(k + " : " + v));
				} catch (IOException e) {
					System.out.println(e);
				} finally {
					if (br != null) {
						br.close();
					}
				}

			}

		}

	}

}
