<h2>Social Login Install Module</h2>
<pre>
소셜로그인 모듈을 쉽게 사용하기 위한 Install Module 입니다.
- 아래와 같은 정보를 Install 합니다.
  - DB TABLE CREATE
  - DB DATA INSERT
    - CLIENT ID
      - ex) 64088******-**************
    - CALLBACK URL
      - ex) http://sso.server.go.kr:8080/sso/google/oidc/auth
    - CLIENT SECRET
      - ex) GOCSPX****************
    - LOGIN LINK
      - https://accounts.google.com/o/oauth2/v2/auth
    - ACCESS URL
      - https://oauth2.googleapis.com/token
    - RESPONSE TYPE
      - code
    - RETURN TYPE
      - email
- 히스토리
  - 2025.02.10 : ORACLE DB 데이터 삽입 가능하며 추 후 다른 디비 개발 예정
- 
</pre>
