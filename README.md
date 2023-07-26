# toyproject3
게시판 제작하기

## 🕰️ 기간

- 23.06.26 ~ 23.06.30 (5일)

## ⚙️ 개발 환경

- Java 20
- gradle
- lombok
- Spring Boot 3.1.1
- Spring JPA
- Spring Security 6
- MyBatis
- MySQL

## ✅ 프로젝트 체크리스트

1. 😀 게시판 기능 명세서
    1. 회원가입
        - [x]  [회원가입 페이지] 회원가입 구현 (id, username, password, email, nickName, role, createdAt, updatedAt) - role은 새싹 회원과 우수회원으로 구분 (디폴트 : 새싹회원, 게시글 수 10 개 이상 우수 회원)
    2. 로그인
        - [x]  [로그인 페이지] 로그인 구현 (username, password)
    3. 유저네임 중복체크
        - [x]  [회원가입 페이지] 동일 username 중복체크하기
    4. 회원정보보기
        - [ ]  [회원정보 페이지] username, email, role, createdAt 확인
    5. 회원정보 수정하기
        - [ ]  [회원정보 수정페이지] email, nickName 변경가능
    6. 비밀번호 수정하기
        - [ ]  [비밀번호 수정 페이지] 비밀번호 수정 구현
    7. 게시글 카테고리
        - [x]  새싹회원 게시판, 우수회원 게시판 구현 (게시판은 2개이지만 하나의 화면을 공유해서 사용하고 카테고리로 구분함)
    8. 게시글 쓰기
        - [x]  [게시글 쓰기 페이지] - 권한(새싹, 우수)에 따라 다른 게시판에 글이 적어짐 (썸머노트 적용)
            
    9. 게시글 목록보기
        - [x]  [게시글 목록보기 페이지] 게시글 목록보기 (id, title, content, thumbnail, user의 nickName 화면에 보여야 함, content내용을 화면에 2줄이 넘어가면 Ellipsis(...)으로 스타일 변경, 정렬은 id순 Desc
    10. 게시글 페이징
        - [x]  [게시글 목록보기 페이지] 페이지당 6개 게시글 보여야 함, 게시글은 Grid 형식으로 3개씩 카드(Card) 배치
    11. 게시글 검색
        - [x]  [게시글 목록보기 페이지] 작성자(nickName), 제목(title), 내용(content)로 검색가능해야 함.
    12. 게시글 상세보기
        - [ ]  [게시글 상세보기 페이지] id, title, content, nickName, 댓글의 comment 리스트(id, comment, 댓글의 작성자 nickName) 이 화면에 보여야 함. 게시글 삭제버튼과 수정버튼 보여야 함(본인이 적은 글에 대해서만), 댓글 삭제버튼이 보여야함(본인이 적은 댓글에 대해서만)
            
            - 삭제, 수정 권한체크 미적용
            
            - 댓글, 대댓글 조회 미적용
            
    13. 게시글 삭제하기
        - [ ]  [게시글 상세보기 페이지] 본인이 적은 게시글만 삭제가능
            
            - 권한체크 미적용
            
    14. 게시글 수정하기
        - [ ]  [게시글 수정하기 페이지] title, content 수정 가능
            
            - 권한체크 미적용
            
    15. 게시글 신고
        - [ ]  [게시글 상세보기 페이지] 게시글 신고가능 (형태 : 욕설, 음란, 비방)
    16. 댓글 쓰기
        - [ ]  [게시글 상세보기 페이지] 댓글 쓰기 50자이내! , 댓글에 댓글을 작성할 수 있음. 대댓글 기능 구현 (depth 1까지)
    17. 댓글 삭제
        - [ ]  [게시글 상세보기 페이지] 댓글 삭제가능 (댓글은 수정은 없음)
    18. 스케쥴러 등록
        - [x]  @Schedule 을 사용하여, 1분에 한번씩 게시글 수가 10개인데, 우수회원이 아닌 새싹회원 등급 자동 변경
2. 관리자 기능 명세서
    1. 관리자 회원 권한 관리
        - [ ]  회원의 role 변경 가능해야 함
    2. 관리자 회원 Email 전송 관리
        - [ ]  회원에게 email 전송 가능해야 함
        
        레퍼런스 : https://ajdahrdl.tistory.com/236
        
    3. 관리자 게시글 CRUD 관리
        - [ ]  게시글 목록보기, 삭제하기, 숨기기/보이기, 블랙리스트(욕설) 등록 가능해야 함 (수정,
        상세보기는 구현할 필요 없음)
    4. 관리자 게시글 통계 관리
        - [ ]  유저의 게시글 수, 댓글 수를 볼 수 있고, 댓글수가 많은 유저 순, 게시글수가 많은 유저
        순으로 정렬가능해야 함
    5. 관리자 블랙리스트 고객 등록/해제
        - [ ]  게시글 신고목록 페이지 구현, 해당 페이지에서 블랙리스트 고객 등록 및 해제 가능
    
    ## 🗄️ DB
    
    `member_tb` (회원 테이블)
    
    ```sql
    CREATE TABLE member_tb (
       mid int primary key NOT NULL,
       username varchar(50) unique NOT NULL,
       password varchar(200) NOT NULL,
       nickname varchar(50) NOT NULL,
       email varchar(50) NOT NULL,
       member_role varchar(10) NOT NULL,
       created_at timestamp NOT NULL,
    	 updated_at timestamp
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
    ```
    
    `post_tb` (게시글 테이블)
    
    ```sql
    create table post_tb(
    	id bigint auto_increment primary key,
    	title varchar(30) not null,
    	content varchar(2000) not null,
    	thumbnail varchar(200),
    	category varchar(10) not null,
    	status varchar(10) not null,
    	member_id bigint not null,
    	created_at timestamp not null,
    	updated_at timestamp not null,
    	foreign key(member_id) references member_tb(mid)
    )Engine=InnoDB default charset=utf8mb4;
    ```
    
    `reply_tb` (댓글 테이블)
    
    ```sql
    create table reply_tb(
    	id bigint auto_increment primary key,
      comment varchar(50) not null,
      parent_id bigint,
      step int not null default(0),
      post_id bigint not null,
      member_id bigint not null,
      created_at timestamp not null,
      updated_at timestamp not null,
      foreign key(post_id) references post_tb(id),
      foreign key(member_id) references member_tb(mid)
    )Engine=InnoDB default charset=utf8mb4;
    ```
    
    `declaration_tb` (게시글 신고 테이블)
    
    ```sql
    create table declaration_tb(
    	id bigint auto_increment primary key,
      reason varchar(10) not null,
      comment varchar(100),
      reason_image blob,
      post_id bigint not null,
    	created_at timestamp not null,
      foreign key(post_id) references post_tb(id)
    )Engine=InnoDB default charset=utf8mb4;
    ```
    
    ## API
    
    | 구분 | 메서드 | uri | 설명 |
    | --- | --- | --- | --- |
    | 예) 로그인 등 | 예) GET, POST 등 | 예) /boards | 예) 게시판 목록 조회 |
    | 게시판 | GET | /boards | 게시판 목록 페이지 |
    | 게시판 | GET | /boards/{id} | 게시글 상세 조회 페이지 |
    | 게시판 | GET | /boards/search?gubun={gubun}&keyword={keyword}
    keyword : 검색 키워드 |
    | 게시판 | GET | /board/save | 게시글 작성 페이지 |
    | 게시판 | POST | /api/board/save | 게시글 등록 요청 |
    | 게시판 | GET | /boards/{id}/edit | 게시글 수정 페이지 |
    | 게시판 | PUT | /api/boards/{id}/update | 게시글 수정 요청 |
    | 게시판 | DELETE | /api/boards/{id}/delete | 게시글 삭제 요청 |
    | 댓글 | POST | /reply/save | 댓글 등록 요청 |
    | 댓글 | DELETE | /reply/{id}/delete | 댓글 삭제 요청 |

### 역할 배분
|팀원| 기능 | 브랜치|
|:---:|:---:|:---:|
|윤현진|회원가입/로그인|[hyeonjinyun](https://github.com/freshh17/toyproject3/tree/hyeonjinyun)|
|이성민|회원가입/로그인|[Seongmin](https://github.com/freshh17/toyproject3/tree/Seongmin)|
|박성현|프로젝트 셋팅, DB 설계, 게시글 목록보기, 게시글 페이징, 게시글 검색, 게시글 작성, Exception Handler |[seonghye0n](https://github.com/freshh17/toyproject3/tree/seonghye0n)|
|김희현|관리자 기능|[hhyun](https://github.com/freshh17/toyproject3/tree/hhyun)|
