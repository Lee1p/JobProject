package com.employment.signup;

public class UserLogin {

    // userlogin 메서드에 유저 이름을 매개변수로 받도록 수정
    public static void userlogin(String userName) {

        // 유저 이름이 null이 아니면 환영 메시지 출력
        if (userName != null) {
            System.out.printf("=======%s님 반갑습니다.=======\n", userName);
        } else {
            // 유저 이름이 null이면 로그인 실패 메시지 출력
            System.out.println("로그인에 실패했습니다.");
        }
    }
}
