package com.thirdageopen.api;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenStore {

	private int tokenCount;
	private ArrayList<String> wholeString;

	public TokenStore(int t, ArrayList<String> w) {
		tokenCount = t;
		wholeString = w;
	}

	public void printFormat() {
		for (int i = 0; i < wholeString.size(); i++){
			if(i % tokenCount == 0) {
				System.out.println();
			}
			System.out.print(wholeString.get(i) + " ");
		}
	}

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		String t;

		System.out.println("Enter number of words to display per line:");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter lines of text (Return twice to end.):");

		do {
			t = scan.nextLine();
			StringTokenizer st = new StringTokenizer(t);
			while (st.hasMoreTokens()) {
				String temp = st.nextToken();
				if (temp != "\n") {
					words.add(temp);
				}
			}
		} while (t.length() > 0);
		
		scan.close();

		TokenStore formattedWords = new TokenStore(num, words);
		formattedWords.printFormat();
	}
}
