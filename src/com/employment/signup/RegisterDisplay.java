package com.employment.signup;

import java.io.IOException;
import java.util.Scanner;
import com.employment.dao.RegisterDAO;
import com.employment.util.Util;
import com.maindisplay.MainDisplay;

public class RegisterDisplay {

	// 회원가입 폼
	public static void registerDisplay() {
		Scanner sc = new Scanner(System.in);

		boolean loop = true;

		System.out.println("======== 회원가입창입니다. ========");

		while (loop) {
			System.out.print("아이디: ");
			String idInput = sc.nextLine();

			// 아이디 유효성 검사
			if (!idInput.matches("^[a-zA-Z][a-zA-Z0-9]{4,11}$")) {
				System.out.println("아이디는 5~12글자 사이, 첫 글자는 영어로 시작하며 영어와 숫자로만 구성되어야 합니다.");
				continue;
			}

			// 중복 검사
			try {
				if (Util.isDuplicateId(idInput)) {
					System.out.println("중복된 아이디입니다. 다른 아이디를 입력하세요.");
					continue; // 중복이면 다시 입력받음
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("아이디 중복 확인 중 오류가 발생했습니다.");
				continue;
			}

			System.out.println("사용 가능한 아이디입니다.");

			// 변수 선언을 외부에서 수행
			String passwordInput = null;
			String nameInput = null;
			String birthdateInput = null;
			String emailInput = null;
			String phoneInput = null;

			// 비밀번호 입력
			while (true) {

				System.out.print("비밀번호: ");
				passwordInput = sc.nextLine();

				// 비밀번호 유효성 검증
				if (!passwordInput.matches(".{5,15}")) {
					System.out.println("비밀번호는 5글자~15글자 사이로 입력해야 합니다.");
					continue; // 비밀번호를 다시 입력받음
				}
				break;
			}

			while (true) {

				String confirmpassword = null;

				System.out.print("비밀번호확인:");
				confirmpassword = sc.nextLine();

				if (!confirmpassword.contains(passwordInput)) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}

				System.out.println("★비밀번호가 일치합니다.★");
				break; // 비밀번호가 올바른 경우 반복문 종료
			}

			// 나머지 회원 정보 입력
			while (true) {
				System.out.print("이름: ");
				nameInput = sc.nextLine();

				// 이름 유효성 검증
				if (!nameInput.matches("^[가-힣]{2,4}$")) {
					System.out.println("이름은 한글 2~4글자로 입력해주세요.");
					continue; // 다시 이름 입력
				}

				System.out.println("사용 가능한 이름입니다.");
				break; // 유효한 이름 입력 시 반복문 종료
			}

			while (true) {
				System.out.print("생년월일(6자): ");
				birthdateInput = sc.nextLine();

				// 생년월일 기본 유효성 검증: 숫자 6자리
				if (!birthdateInput.matches("^[0-9]{6}$")) {
					System.out.println("생년월일은 6자리 숫자여야 합니다 (예: 001201).");
					continue;
				}

				// 월, 일 추출

				int month = Integer.parseInt(birthdateInput.substring(2, 4)); // 월 (중간 2자리)
				int day = Integer.parseInt(birthdateInput.substring(4, 6)); // 일 (마지막 2자리)

				// 월 범위 확인
				if (month < 1 || month > 12) {
					System.out.println("유효하지 않은 월입니다. 월은 01~12 사이여야 합니다.");
					continue;
				}

				// 일 범위 확인 (월별 일수 계산)
				int maxDays = getMaxDaysInMonth(month);
				if (day < 1 || day > maxDays) {
					System.out.println("유효하지 않은 일입니다. " + month + "월은 1일부터 " + maxDays + "일까지 가능합니다.");
					continue;
				}

				// 모든 검증 통과
				break; // 입력 반복 종료
			}

			while (true) {
				System.out.print("이메일: ");
				emailInput = sc.nextLine();

				// 이메일 유효성 검증
				if (!emailInput.matches("^[a-zA-Z][a-zA-Z0-9]{2,9}@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
					System.out.println("이메일 형식이 올바르지 않습니다. 예: abc123@example.com");
					continue; // 다시 이메일 입력받음
				}

				// 중복 검사
				try {
					if (Util.isDuplicateemail(emailInput)) {
						System.out.println("이미 사용하고있는 이메일입니다.");
						continue; // 중복이면 다시 입력받음
					}
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("이메일 중복 확인 중 오류가 발생했습니다.");
					continue;
				}

				System.out.println("사용 가능한 이메일입니다.");
				break;
			}

			// 휴대폰번호 입력 및 유효성 검사
			while (true) {
				System.out.print("휴대폰번호: ");
				phoneInput = sc.nextLine();

				// 휴대폰 번호 형식 유효성 검사 (010-1234-5678)
				String phonePattern = "^010-\\d{4}-\\d{4}$"; // 휴대폰 번호 형식
				if (!phoneInput.matches(phonePattern)) {
					System.out.println("잘못된 휴대폰 번호 형식입니다. 예: 010-1234-5678");
					continue; // 잘못된 형식이면 다시 입력받음
				}

				// 중복 검사
				try {
					if (Util.isDuplicatePhoneNumber(phoneInput)) {
						System.out.println("이미 회원가입한 폰번호입니다.");
						continue; // 중복이면 다시 입력받음
					}
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("폰번호 확인 중 오류가 발생했습니다.");
					continue;
				}
				break;
			}

			// 입력값으로 SignUp 객체 생성
			SignUp newUser = new SignUp(idInput, passwordInput, nameInput, birthdateInput, emailInput, phoneInput);

			System.out.println("회원가입이 완료되었습니다.");

			System.out.println("Enter를 누르시면 메인 페이지로 이동합니다.");
			sc.nextLine(); // 사용자 입력을 기다림
			
			loop = false; // 회원가입 완료 후 루프 종료
			
			// 회원 객체를 파일 입출력에 저장
			try {
				RegisterDAO.save(newUser);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("회원 정보를 저장하는 중 오류가 발생했습니다.");
			}
			
		} // while
		MainDisplay.employmentdisplay();
		sc.close();
	} // registerDisplay 메소드
	
	

	// 월별 최대 일수를 반환하는 메서드
	private static int getMaxDaysInMonth(int month) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31; // 31일까지 있는 달
		case 4:
		case 6:
		case 9:
		case 11:
			return 30; // 30일까지 있는 달
		case 2:
			return 28; // 2월은 28일 (윤년은 고려하지 않음)
		default:
			return 0; // 유효하지 않은 월
		}
	}

} // RegisterDisplay 클래스
