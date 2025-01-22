package com.employment.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.employment.signup.SignUp;

public class RegisterDAO {
	
	// 회원 정보를 저장할 ArrayList
	private static ArrayList<SignUp> userList = new ArrayList<SignUp>();
	
	
	// 회원 정보를 저장하는 메소드
	public static void save(SignUp user) throws IOException {
		
		
		// 1. 회원 정보를 userList에 추가
		userList.add(user);
		
		// 2. 파일에 회원 정보 저장
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			// 파일을 열거나 새로 생성
			File file = new File("EmployMentData/register.txt");
			fw = new FileWriter(file, true); 
			bw = new BufferedWriter(fw);
			
			// 3. userList에 저장된 모든 회원 정보를 파일에 기록
			for (SignUp user1 : userList) {
				bw.write(user1.getId() + "," + user1.getPassword() + "," + user1.getName() + ","
						+ user1.getBirthDate() + "," + user1.getEmail() + "," + user1.getPhoneNumber());
				bw.newLine();  // 한 줄을 띄워서 기록
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일 저장에 실패했습니다: " + e.getMessage());
		} finally {
			// 파일을 닫기
			if (bw != null) {
				bw.close();
			}
			if (fw != null) {
				fw.close();
			} //finally
		}// finally
	} // save
	
	
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

	
} // registerDao
