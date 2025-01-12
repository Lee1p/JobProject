package com.employment.signup;


import java.util.Scanner;

public class RegisterDisplay {
	
	public static void registerDisplay() {
		
		Scanner sc = new Scanner(System.in);
		
		boolean loop = true;
		
		while(loop) {
			
			System.out.println("========회원가입창입니다.========");
			System.out.print("아이디:");
			String idInput = sc.nextLine();
			System.out.print("비밀번호:");
			String passwordInput = sc.nextLine();
			
		}
		
	}
	
}
