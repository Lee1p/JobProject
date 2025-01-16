package com.employment.signup;



import java.io.IOException;
import java.util.Scanner;

import com.employment.dao.RegisterDAO;

public class RegisterDisplay {

    // 회원가입 폼
    public static void registerDisplay() {
        Scanner sc = new Scanner(System.in);
        
        boolean loop = true;
        
        while(loop) {
            System.out.println("========회원가입창입니다.========");
            System.out.print("아이디: ");
            String idInput = sc.nextLine();
            System.out.print("비밀번호: ");
            String passwordInput = sc.nextLine();
            System.out.print("이름: ");
            String nameInput = sc.nextLine();
            System.out.print("생년월일: ");
            String birthdateInput = sc.nextLine();
            System.out.print("이메일: ");
            String emailInput = sc.nextLine();
            System.out.print("휴대폰번호: ");
            String phoneInput = sc.nextLine();
            
            
            //입력값으로 SignUP 객체 생성            
            SignUp newUser = new SignUp(idInput, passwordInput, nameInput, birthdateInput, emailInput, phoneInput);
            
            
            System.out.println("회원가입이 완료되었습니다");
            
            loop = false;
            
            // 회원 객체를 파일입출력에 저장하기위해 RegisterDAO 클래스에 저장메소드 회원 객체를 넘겨준다. 
            try {
				RegisterDAO.save(newUser);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
        } // while
        
    } // registerDisplay 메소드
    
} // RegisterDisplay 클래스
