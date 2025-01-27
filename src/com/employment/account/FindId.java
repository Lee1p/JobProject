package com.employment.account;

import java.util.Scanner;

import com.employment.util.Util;
import com.maindisplay.MainDisplay;

public class FindId {

    public static void findid() {
        System.out.println("========아이디 찾기========");

        Scanner sc = new Scanner(System.in);
        boolean loop = true;

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
                System.out.print("이름: ");
                String name = sc.nextLine();
                System.out.print("이메일: ");
                String email = sc.nextLine();

                Util findid = new Util();
                findid.getIdNameByEmail(name, email);

                // 이메일 인증 후, 메인으로 이동할지 여부 물어보기
                if (!askToMoveToMain()) {
                    loop = true; // 'N'을 입력하면 인증 메뉴로 다시 돌아가도록 설정
                }
            }
            // 휴대폰 인증 선택
            else if (input.equals("2")) {
                System.out.println("=====휴대폰 인증=====");
                System.out.print("이름: ");
                String name = sc.nextLine();
                System.out.print("휴대폰 번호(-제외): ");
                String phone = sc.nextLine();

                Util findid = new Util();
                findid.getIdNameByPhone(name, phone);

                // 휴대폰 인증 후, 메인으로 이동할지 여부 물어보기
                if (!askToMoveToMain()) {
                    loop = true; // 'N'을 입력하면 인증 메뉴로 다시 돌아가도록 설정
                }
            }
        }

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
                MainDisplay.employmentdisplay();
                return true; // 'Y' 입력 시 계속 진행
            } else if (exitInput.equalsIgnoreCase("n")) {
                System.out.println("이메일 인증 또는 휴대폰 인증 폼으로 이동합니다.");
                return false; // 'N' 입력 시 인증 메뉴로 다시 돌아가도록 false 반환
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
        return false;
    }
}
