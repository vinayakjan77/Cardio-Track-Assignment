package com.demo.cardio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//In this program, we have to provide file names that we want to be classified
public class Test {
	//first comm
	static Map<String, List<String>> map = new HashMap<>();

	static List<String> earthList = new ArrayList<>();

	static List<String> waterList = new ArrayList<>();

	static List<String> spaceList = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		// System.out.println("Please provide file name in format 'file1.txt'");
		boolean flag = true;
		while (flag) {
			System.out.println("Enter 1 for continue...");
			System.out.println("Enter 2 for exit");
			System.out.println("----------------------------");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Please give file name: ");

				// Scanner sc = new Scanner(System.in);
				String userInput = sc.next();

				String input = "D:\\Text\\" + userInput;
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(input));
					String str ="";
					
					String line = br.readLine();
					while (line != null){
					    str +=line;
					    line = br.readLine();
					}
					
					System.out.println(str);

					System.out.println("---------------------");
//
					if (str.toLowerCase().contains("earth")) {
						earthList.add(userInput);
						map.put("Earth", earthList);
					}
					if (str.toLowerCase().contains("water")) {
						waterList.add(userInput);
						map.put("Water", waterList);
					}
					if (str.toLowerCase().contains("space")) {
						spaceList.add(userInput);
						map.put("Space", spaceList);
					}
				} catch (IOException e) {
					System.out.println(e.toString());
					System.out.println("File not found");
				} finally {
					if(br != null) {
						br.close();
					}					
				}

				map.forEach((k, v) -> System.out.println(k + " : " + v));

				System.out.println("-----------------------");
				break;

			case 2:
				flag = false;
				break;

			default:
				System.out.println("Please give correct input");

			}

		}

	}

}
