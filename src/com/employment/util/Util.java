package com.employment.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Util {
	// 중복 아이디를 확인하는 메소드
	public static boolean isDuplicateId(String id) throws IOException {
		File file = new File("EmployMentData/register.txt");

		// 파일이 존재하지 않으면 중복될 일이 없으므로 false 반환
		if (!file.exists()) {
			return false;
		}

		// 파일 읽기
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				// 파일에서 한 줄씩 읽어서 쉼표(,)로 분리
				String[] userData = line.split(",");
				if (userData.length > 0 && userData[0].equals(id)) { // 첫 번째 요소는 아이디
					return true; // 중복된 아이디 발견
				}
			}
		}
		return false; // 중복된 아이디 없음
	}

	public static boolean isDuplicateemail(String email) throws IOException {
		File file = new File("EmployMentData/register.txt");

		// 파일이 존재하지 않으면 중복될 일이 없으므로 false 반환
		if (!file.exists()) {
			return false;
		}

		// 파일 읽기
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				// 파일에서 한 줄씩 읽어서 쉼표(,)로 분리
				String[] userData = line.split(",");
				if (userData.length > 0 && userData[4].equals(email)) {
					return true; // 중복된 이메일 발견
				}
			}
		}
		return false; // 중복된 이메일 없음
	}

	public static boolean isDuplicatePhoneNumber(String phonenumber) throws IOException {
		File file = new File("EmployMentData/register.txt");

		// 파일이 존재하지 않으면 중복될 일이 없으므로 false 반환
		if (!file.exists()) {
			return false;
		}

		// 파일 읽기
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				// 파일에서 한 줄씩 읽어서 쉼표(,)로 분리
				String[] userData = line.split(",");
				if (userData.length > 0 && userData[5].equals(phonenumber)) {
					return true; // 중복된 폰번호 발견
				}
			}
		}
		return false; // 중복된 폰번호 발견
	}

	// login 클래스 비밀번호 일치하는지 확인!
	public static boolean isDuplicatePassword(String password) throws IOException {
		File file = new File("EmployMentData/register.txt");

		// 파일이 존재하지 않으면 중복될 일이 없으므로 false 반환
		if (!file.exists()) {
			return false;
		}

		// 파일 읽기
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				// 파일에서 한 줄씩 읽어서 쉼표(,)로 분리
				String[] userData = line.split(",");
				if (userData.length > 0 && userData[1].equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
	// 이름과, 이메일로 아이디를 찾는 방법
	public void getIdNameByEmail(String name, String email) {
		File file = new File("EmployMentData/register.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			boolean found = false;

			while ((line = br.readLine()) != null) {
				String[] userData = line.split(",");
				String id = userData[0];
				String name1 = userData[2];
				String email1 = userData[4];

				// 입력된 회원 이름, email 이랑 일치하는 id 출력
				if (name1.equalsIgnoreCase(name) && email1.equalsIgnoreCase(email)) {
					System.out.printf("가입하신 아이디는: \"%s\" 입니다.\n", id);
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("없는 아이디입니다.");
			}
		} catch (IOException e) {
			System.out.println("파일 읽기 중 오류가 발생했습니다.");
			e.printStackTrace();
		}

	}
	
	
	// 아이디,이름, 이메일로 비밀번호를 찾는 방법
		public void getPasswordNameByEmail(String id, String name ,String email) {
			File file = new File("EmployMentData/register.txt");

			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String line;
				boolean found = false;

				while ((line = br.readLine()) != null) {
					String[] userData = line.split(",");
					String id1 = userData[0];
					String name1 = userData[2];
					String email1 = userData[4];
					String password = userData[1];

					// 입력된 회원 이름, email 이랑 일치하는 id 출력
					if (id1.equalsIgnoreCase(id) && name1.equalsIgnoreCase(name) && email1.equalsIgnoreCase(email)) {
						System.out.printf("%s 님의 비밀번호는: \"%s\" 입니다.\n", id1, password);
						found = true;
						break;
					}
				}

				if (!found) {
					System.out.println("비밀번호를 찾을수없습니다.");
				}
			} catch (IOException e) {
				System.out.println("파일 읽기 중 오류가 발생했습니다.");
				e.printStackTrace();
			}

		}
		
		// 아이디,이름, 폰번호로 비밀번호를 찾는 방법
				public void getPasswordNameByphone(String id, String name ,String phonenumber) {
					String phoneNumberWithoutHyphen = phonenumber.replace("-", "");
					File file = new File("EmployMentData/register.txt");

					try (BufferedReader br = new BufferedReader(new FileReader(file))) {
						String line;
						boolean found = false;

						while ((line = br.readLine()) != null) {
							String[] userData = line.split(",");
							String id1 = userData[0];
							String name1 = userData[2];
							String phonenumber1 = userData[5];
							String password = userData[1];
							
							// 하이픈을 포함한 번호에서 하이픈을 제외한 번호로 비교
				            String phoneNumber1WithoutHyphen = phonenumber1.replace("-", "");

							// 입력된 회원 이름, email 이랑 일치하는 id 출력
							if (id1.equalsIgnoreCase(id) && name1.equalsIgnoreCase(name) && phoneNumber1WithoutHyphen.equals(phoneNumberWithoutHyphen)) {
								System.out.printf("%s 님의 비밀번호는: \"%s\" 입니다.\n", id1, password);
								found = true;
								break;
							}
						}

						if (!found) {
							System.out.println("비밀번호를 찾을수없습니다.");
						}
					} catch (IOException e) {
						System.out.println("파일 읽기 중 오류가 발생했습니다.");
						e.printStackTrace();
					}

				}
	
	
	// 이름과 휴대폰 번호로 아이디를 찾는 방법 
	public void getIdNameByPhone(String name, String phoneNumber) {
	    // 하이픈 제거 (입력된 휴대폰 번호에서 하이픈 '-'을 제거)
	    String phoneNumberWithoutHyphen = phoneNumber.replace("-", "");

	    File file = new File("EmployMentData/register.txt");

	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line;
	        boolean found = false;

	        while ((line = br.readLine()) != null) {
	            String[] userData = line.split(",");
	            String id = userData[0];
	            String name1 = userData[2];
	            String phoneNumber1 = userData[5];

	            // 하이픈을 포함한 번호에서 하이픈을 제외한 번호로 비교
	            String phoneNumber1WithoutHyphen = phoneNumber1.replace("-", "");

	            // 입력된 회원 이름, 휴대폰 번호가 일치하는지 확인
	            if (name1.equalsIgnoreCase(name) && phoneNumber1WithoutHyphen.equals(phoneNumberWithoutHyphen)) {
	                System.out.printf("가입하신 아이디는: \"%s\" 입니다.\n", id);
	                found = true;
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("없는 아이디입니다.");
	        }
	    } catch (IOException e) {
	        System.out.println("파일 읽기 중 오류가 발생했습니다.");
	        e.printStackTrace();
	    }
	}
	public static String getUserNameById(String id) throws IOException {
        File file = new File("EmployMentData/register.txt");

        if (!file.exists()) {
            System.out.println("회원 데이터 파일이 없습니다.");
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length > 2) {
                    String userId = userData[0];
                    String userName = userData[2];

                    if (userId.equals(id)) {
                        return userName; // 아이디가 일치하는 유저 이름 반환
                    }
                }
            }
        }

        return null; // 아이디가 없으면 null 반환
    }



}
