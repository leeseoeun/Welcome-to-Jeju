# 1128 회의<br>
1. model.exerd 정리<br>

*1-1. user 테이블*<br>
- 이모지 번호 not null<br>
- 신고 수, 경고 수 삭제<br>

*1-2. theme 테이블*<br>
- 이모지 번호 not null<br>
- 신고 수 삭제<br>
- 테마 제목 유니크 키 삭제<br>
- 공유 여부 기본 값 추가<br>
- 카테고리, 해시태그 관계<br>

*1-3. board 테이블*<br>
- 제목, 내용, 조회수, 등록일 추가<br>
*· 첨부 파일 유무*<br>

*1-4. board_comment 테이블*<br>
- 내용, 작성일 추가<br>

*1-5. liked_user 테이블*<br>
- 논리 이름 수정<br>

<br>

2. Domain 정리<br>
3. Dao 정리<br>

<hr>

## 서은<br>
**1. 자유 게시판**<br>
1-1. add<br>
1-2. list<br>

<br>

**2. 참여 테마**<br>
2-1. detail<br>
2-2. update<br>
2-3. delete<br>

<br>

**3. UserDao.xml 정리**<br>

<hr>

## 혜연<br>
**1. 자유 게시판**<br>
1-1. detail<br>
1-2. update<br>
1-3. delete<br>

<br>

**2. 참여 테마**<br>
2-1. add<br>
2-2. list<br>

<br>

**3. PlaceDao.xml 정리**<br>