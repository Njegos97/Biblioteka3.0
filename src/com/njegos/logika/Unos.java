package com.njegos.logika;

public class Unos {
	static java.util.Scanner input = new java.util.Scanner(System.in);
	public static int unosIntegera() {
		int result = 0;
		
		while (true) {
			try {
			 result = input.nextInt();
			 return result;
			 
			}catch(Exception e) {
				System.out.println("Pokusaj ponovo, morate unijeti broj");
				input.nextLine();
			}
			
		}
		
		
	}
}
