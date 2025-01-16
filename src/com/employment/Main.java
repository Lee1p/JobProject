package com.employment;


import java.io.IOException;

import com.employment.dao.RegisterDAO;
import com.employment.signup.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 파일 존재 여부 확인
//        RegisterDAO.registerLoad();
    		RegisterDisplay.registerDisplay();
    		
    }
}