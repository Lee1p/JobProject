package com.maindisplay;

import java.util.Scanner;

import com.employment.account.Login;
import com.employment.signup.RegisterDisplay;

public class MainDisplay {

    public static void employmentdisplay() {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("========메인페이지(추후에이름바꿀예정)========");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 아이디/비번 찾기");
            System.out.println("4. 프로그램 종료");
            System.out.print("입력: ");

            int n = sc.nextInt();
            sc.nextLine(); // 입력 후 개행문자 처리

            switch (n) {
                case 1:
                    // 로그인 기능 구현
                    Login.processLoginForm(); // 로그인 화면으로 이동
                    break;
                case 2:
                    RegisterDisplay.registerDisplay(); // 회원가입 화면으로 이동
                    break;
                case 3:
                    System.out.println("아이디/비밀번호 찾기 기능은 아직 구현되지 않았습니다.");
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close(); // 프로그램 종료 시 Scanner 객체 닫기
                    return; // 프로그램 종료
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }
}
