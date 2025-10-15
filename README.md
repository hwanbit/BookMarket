# 📖 온라인 서점 'BookMarket'

Spring Boot를 사용하여 개발한 온라인 서점 웹 애플리케이션입니다. "스프링부트 완전정복" 책을 참고하여 E-Commerce 서비스의 핵심 원리를 학습하고 구현하는 것을 목표로 합니다.

## 🌟 주요 기능

현재까지 구현된 주요 기능은 다음과 같습니다.

### 📚 도서 관리
- **도서 등록**: 새로운 도서 정보와 이미지를 업로드하여 등록할 수 있습니다.
- **도서 목록 조회**: 등록된 모든 도서의 목록을 확인하고 재고를 관리할 수 있습니다.
- **도서 상세 정보**: 각 도서의 상세 페이지를 조회할 수 있습니다.
- **도서 정보 수정**: 기존에 등록된 도서의 정보를 수정합니다.

### 🛒 장바구니
- **장바구니 추가**: 도서 상세 페이지에서 원하는 도서를 장바구니에 담을 수 있습니다.
- **장바구니 조회/삭제**: 장바구니에 담긴 도서 목록을 확인하고, 원하는 상품을 삭제할 수 있습니다.
- **세션 기반 관리**: `HttpSession`을 이용하여 사용자별 장바구니 정보를 유지합니다.

### 💳 주문 (구현 중)
- **주문 프로세스**: 장바구니의 상품들을 기반으로 주문을 시작합니다.
- **배송 정보 입력**: 주문자의 정보와 배송지 정보를 입력받습니다.
- **주문 완료**: 최종 주문 내역을 확인하고 주문을 완료합니다.

## 🛠️ 사용 기술

### Backend
- **Java**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Spring Security**

### Frontend
- **Thymeleaf** (템플릿 엔진)
- **HTML5**
- **CSS**
- **JavaScript**

### Database
- **MySQL**

### Build Tool
- **Gradle**

### 기타
- **Lombok** (코드 간소화)
- **Spring Boot DevTools** (개발 편의성)

## 📂 프로젝트 구조

```
BookMarket/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/bookmarket/
│   │   │       ├── controller/     # 컨트롤러 (MVC)
│   │   │       ├── domain/         # 엔티티 (도서, 사용자 등)
│   │   │       ├── repository/     # JPA Repository
│   │   │       ├── service/        # 비즈니스 로직
│   │   │       ├── config/         # Spring Security 등 설정
│   │   │       ├── validator/      # 유효성 검증
│   │   │       └── exception/      # 예외 처리
│   │   └── resources/
│   │       ├── templates/          # Thymeleaf 템플릿
│   │       ├── static/             # CSS, JS, 이미지
│   │       └── application.properties  # 설정 파일
│   └── test/
└── build.gradle                    # Gradle 빌드 설정
```

## 🚀 시작하기

### 사전 준비

- **JDK 17** 설치
- **MySQL** 설치
- **IDE**: IntelliJ IDEA 또는 Eclipse (권장)

### 1. 레포지토리 클론

```bash
git clone <https://github.com/hwanbit/BookMarket.git>
cd BookMarket
```

### 2. 데이터베이스 설정

#### MySQL 사용

`src/main/resources/application.properties` 파일을 수정합니다:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookmarket
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. 프로젝트 빌드 및 실행

```bash
# Gradle을 통한 빌드
./gradlew build

# 애플리케이션 실행
./gradlew bootRun
```

또는 IDE에서 `Application.java` 파일을 직접 실행할 수 있습니다.

### 4. 웹 브라우저에서 접속

```
http://localhost:8080
```

## 📝 학습 내용

이 프로젝트를 통해 학습한 주요 내용:

- **Spring MVC 패턴**: 컨트롤러, 서비스, 리포지토리 계층 구조
- **Spring Data JPA**: 엔티티 매핑 및 데이터베이스 연동
- **Thymeleaf**: 서버 사이드 템플릿 엔진 활용
- **Spring Security**: 인증 및 권한 관리
- **세션 관리**: HttpSession을 이용한 장바구니 구현
- **파일 업로드**: 도서 이미지 등록 기능

## 📚 참고 자료

- **교재**: 스프링부트 완전정복(길벗캠퍼스, 2024)
