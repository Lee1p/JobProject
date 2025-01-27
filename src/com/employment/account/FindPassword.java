package com.employment.account;

import java.util.Scanner;

import com.employment.util.Util;
import com.maindisplay.MainDisplay;

public class FindPassword {

    public static void findPassword() {
        System.out.println("========비밀번호 찾기========");

        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        Util findpassword = new Util();

        while (loop) {
            System.out.println("1.이메일인증");
            System.out.println("2.휴대폰인증");
            System.out.print("입력: ");
            String input = sc.nextLine();

            // 잘못된 입력에 대한 처리
            if (!input.equals("1") && !input.equals("2")) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }

            // 이메일 인증 선택
            else if (input.equals("1")) {
                System.out.println("=====이메일 인증=====");
                System.out.print("아이디:");
                String id = sc.nextLine();
                System.out.print("이름: ");
                String name = sc.nextLine();
                System.out.print("이메일: ");
                String email = sc.nextLine();

                findpassword.getPasswordNameByEmail(id, name, email);

                // 이메일 인증 후, 메인으로 이동할지 여부 물어보기
                if (!askToMoveToMain()) {
                    loop = true; // 'N'을 입력하면 인증 메뉴로 다시 돌아가도록 설정
                }
            }

            // 휴대폰 인증 선택
            else if (input.equals("2")) {
                System.out.println("=====휴대폰 인증=====");
                System.out.print("아이디:");
                String id = sc.nextLine();
                System.out.print("이름: ");
                String name = sc.nextLine();
                System.out.print("휴대폰번호(-제외): ");
                String phonenumber = sc.nextLine();

                findpassword.getPasswordNameByphone(id, name, phonenumber);
                // 휴대폰 인증 후, 메인으로 이동할지 여부 물어보기
                if (!askToMoveToMain()) {
                    loop = true; // 'N'을 입력하면 인증 메뉴로 다시 돌아가도록 설정
                }
            }
        } // while 문
    }

    // 메인으로 이동할지 여부를 묻는 메서드
    public static boolean askToMoveToMain() {
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            System.out.print("메인으로 이동하시겠습니까?(Y/N): ");
            String exitInput = sc.nextLine();

            // 소문자 y 또는 대문자 Y 입력 시 true 반환 (계속 진행)
            if (exitInput.equalsIgnoreCase("y")) {
                // 메인 화면으로 이동
                System.out.println("메인으로 이동합니다.");
                MainDisplay.employmentdisplay();
            } else if (exitInput.equalsIgnoreCase("n")) {
                // 인증 메뉴로 돌아감
                System.out.println("이메일 인증 또는 휴대폰 인증 폼으로 이동합니다.");
                return false; // 'N' 입력 시 인증 메뉴로 돌아가도록 false 반환
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
        return false;
    }
}
