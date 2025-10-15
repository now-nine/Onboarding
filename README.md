# 📚 Spring Boot Project (with Security & SNS Login)

## 🚀 프로젝트 개요
Spring Boot 기반의 웹 애플리케이션으로,
기본적인 회원 관리와 보안 기능(Spring Security),  
그리고 SNS 로그인(Google, Kakao, Naver 등)을 통합한 프로젝트입니다.

---

## ⚙️ 기술 스택
| 구분 | 기술 |
|------|------|
| Backend | Spring Boot 3.x |
| Security | Spring Security, OAuth2 Client |
| Database | MySQL / JPA |
| Build | Maven or Gradle |
| Language | Java 17+ |

---

## 🔐 주요 기능
- 일반 로그인 (폼 기반)
- SNS 로그인 (Google, Kakao, Naver)
- 인증/인가 설정
- 사용자별 접근 권한 제어
- 로그인 성공/실패 시 처리 로직
- CSRF 비활성화 (개발용)

---

## 📁 프로젝트 구조
src
└── main
├── java/com/example/demo
│ ├── config/SecurityConfig.java
│ ├── controller/LoginController.java
│ ├── service/CustomOAuth2UserService.java
│ └── domain/User.java
└── resources
├── templates/login.html
└── application.yml

yaml
코드 복사

---

## ⚙️ 설정 방법
1. `application.yml`에 SNS 로그인 정보 추가
2. `mvn clean install` or `gradle build`
3. `java -jar build/libs/demo.jar` 실행
4. 브라우저에서 `http://localhost:8080` 접속

---

## 🔑 SNS 로그인 설정
| 플랫폼 | 등록 주소 | 리디렉션 URI 예시 |
|----------|------------|----------------|
| Google | [https://console.cloud.google.com/](https://console.cloud.google.com/) | `http://localhost:8080/login/oauth2/code/google` |
| Kakao | [https://developers.kakao.com/](https://developers.kakao.com/) | `http://localhost:8080/login/oauth2/code/kakao` |
| Naver | [https://developers.naver.com/](https://developers.naver.com/) | `http://localhost:8080/login/oauth2/code/naver` |

---

## 📸 미리보기
> 로그인 페이지 / SNS 로그인 버튼 UI (추후 이미지 추가 예정)

---

## 🧩 향후 추가 예정
- JWT 기반 토큰 인증
- Refresh Token / Logout 기능
- Redis 세션 관리
- 사용자 Role별 접근제어 강화

---

## 📄 라이선스
MIT License © 2025

---

## ✍️ 작성자
이재구 ([@username](https://github.com/now-nine))