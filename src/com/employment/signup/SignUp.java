package com.employment.signup;

import java.util.Scanner;

public class SignUp {
	
	private String id; // 아이디
	private String password; // 비밀번호
	private String name; //이름
	private String birthDate; // 생년월일
	private String email; // 이메일
	private String phoneNumber; // 휴대폰 번호
	
	// 회원가입 생성자 
	public SignUp(String id, String password, String name, String birthDate, String email, String phoneNumber) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return "SignUp [id=" + id + ", password=" + password + ", name=" + name + ", birthDate=" + birthDate
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	// 아이디 중복검사 메서드 추가
    public boolean idVerification(String idInput) {
        // 여기에 실제로 아이디 중복검사 로직을 구현해야 합니다.
        // 예를 들어, 파일에서 기존 아이디 목록을 읽고, 중복된 아이디가 있는지 확인
        return !id.equals(idInput); // 임시로 아이디가 동일하지 않으면 중복이 아님
    }
	


}