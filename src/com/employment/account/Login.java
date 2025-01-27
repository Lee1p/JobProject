package com.employment.account;

import java.io.IOException;
import java.util.Scanner;

import com.employment.signup.UserLogin;
import com.employment.util.Util;

public class Login {

    public static String processLoginForm() {

        System.out.println("========로그인========");

        boolean loop = true;
        Scanner sc = new Scanner(System.in);

        while (loop) {

            System.out.print("아이디: ");
            String idInput = sc.nextLine();

            System.out.print("비밀번호:");
            String passwordInput = sc.nextLine();

            try {
                // 아이디와 비밀번호를 확인
                if (Util.isDuplicateId(idInput) && Util.isDuplicatePassword(passwordInput)) {
                    // 아이디와 비밀번호가 일치하면 유저 이름 반환
                    String userName = Util.getUserNameById(idInput); // 유저 이름을 가져오는 메서드 호출
                    UserLogin.userlogin(userName); // 유저 이름을 전달
                    return userName; // 성공 시 이름 반환
                } else {
                    System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
                }
            } catch (IOException e) {
                System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                return null; // 예외 발생 시 null 반환
            }
        }

        return null; // 루프 종료 후에도 성공하지 못하면 null 반환
    }
}
