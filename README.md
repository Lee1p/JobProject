##  2025-01-16

1. SignUp 회원가입 설계도 클래스 생성

2. RegisterDisplay 클래스에서  SignUp 클래스에 실제 회원 객체를 생성 (아이디 , 비밀번호, 이름, 생년월일, 이메일, 휴대폰 번호)
    
3. RegisterDAO 클래스에서 생성된 회원 객체를 전달받아 파일입출력 txt에 저장


## 📝 2025-01-17 해야될일 

1. ~~SignUp 회원 객체 생성할때 각각의 유효성 메서드 작성 ( ex 아이디 중복 및 영문으로만)~~ 👉 <span style='background-color:#dcffe4'>유효성 작성 완료(아이디 중복검사o)</span>
2. ~~RegisterDAO 클래스에서 회원의 맨 앞에 index 번호에 고유번호를 생성해준다. (PK값)~~  아이디 자체가 고유번호 즉 , pk 해결 
3. 회원가입완료시 로그인 클래스에서 로그인 구현 / 관리자 로그인도 만들어야된다. -- 회원가입 완성후 추가할 작업

## 2025-01-23 작업

1. 회원가입에서 각 입력값에 대한 유효성 검증 코드 작성 후 테스트 성공.
2. ~~비밀번호 입력후 비밀번호 확인 넣기.~~ 👉 비밀번호 확인 ok 
3. 이메일, 폰 중복검사 로직 추가 (1개의 계정만 생성 할 수있음 .)
   &rarr; 설계할때 회원가입에서 아이디, 이메일 ,폰번호는 1개씩만 만들 수 있게함 ( 중복 X )

## 2025-01-27 작업

1. 로그인,회원가입에 대한 유효성 검사 로직 전부 완성 테스트 통과.
2. 초기화면 설계 전부 완성


## 2025-02-18 작업

1. 예외 처리 → 파일 경로가 없거나 잘못된 경우 파일을 새로 생성하거나 사용자에게 경고 메시지를 출력
2. 메인화면에 아이디 찾기와 비밀번호 찾기 구현
3. 아이디 및 비밀번호 찾기는 이메일 인증 휴대폰 인증 선택하여 사용자가 입력한 정보를 기반으로 인증을 진행.
4. 입력한 정보와 일치할 경우 일치된 내용의 아이디 및 비밀번호를 화면에 출력


