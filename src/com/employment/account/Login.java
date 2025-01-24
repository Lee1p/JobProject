package com.employment.account;

import java.io.IOException;
import java.util.Scanner;

import com.employment.dao.RegisterDAO;

public class Login {

	public static void processLoginForm() {

		System.out.println("========로그인========");

		boolean loop = true;
		Scanner sc = new Scanner(System.in);

		while (loop) {

			System.out.print("아이디: ");
			String idInput = sc.nextLine();

			System.out.print("비밀번호:");
			String passwordInput = sc.nextLine();
			
			
			loop = false;

		} // Scanner 객체는 메서드가 종료될 때 닫는 것이 좋습니다.
	} // 다만, sc.close()는 processLoginForm() 메서드가 종료될 때 호출해야 하기 때문에, MainDisplay 클래스에서
		// 전체적으로 관리하는 것이 좋습니다.
}
