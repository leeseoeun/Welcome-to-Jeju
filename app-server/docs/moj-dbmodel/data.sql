-- 이모지
insert into emoji(emoji_no, emoji)
values(1, '&#127749;');
insert into emoji(emoji_no, emoji)
values(2, '&#127796;');
insert into emoji(emoji_no, emoji)
values(3, '&#127818;');
insert into emoji(emoji_no, emoji)
values(4, '&#128674;');
insert into emoji(emoji_no, emoji)
values(5, '&#127754;');
insert into emoji(emoji_no, emoji)
values(6, '&#129372;');
insert into emoji(emoji_no, emoji)
values(7, '&#128757;');
insert into emoji(emoji_no, emoji)
values(8, '&#128031;');
insert into emoji(emoji_no, emoji)
values(9, '&#128511;');
insert into emoji(emoji_no, emoji)
values(10, '&#127776;');

-- 유저
insert into jeju_user(user_no, email, password, nickname, emoji)
values(1, 'aaa@test.com', password('1111'), '감귤밭떼기', '&#127749;');
insert into jeju_user(user_no, email, password, nickname, emoji)
values(2, 'bbb@test.com', password('1111'), '서은', '&#127796;');
insert into jeju_user(user_no, email, password, nickname, emoji)
values(3, 'ccc@test.com', password('1111'), '한라봉농장', '&#127818;');
insert into jeju_user(user_no, email, password, nickname, emoji)
values(4, 'ddd@test.com', password('1111'), '혜연', '&#128674;');
insert into jeju_user(user_no, email, password, nickname, emoji)
values(5, 'eee@test.com', password('1111'), '제주정승', '&#127754;');
insert into jeju_user(user_no, email, password, nickname, emoji)
values(6, 'fff@test.com', password('1111'), '땅콩막걸리', '&#129372;');
insert into jeju_user(user_no, email, password, nickname, emoji)
values(7, 'ggg@test.com', password('1111'), '킹콩', '&#128757;');
insert into jeju_user(user_no, email, password, nickname, emoji)
values(8, 'hhh@test.com', password('1111'), '말뚝', '&#128031;');
insert into jeju_user(user_no, email, password, nickname, emoji)
values(9, 'iii@test.com', password('1111'), '깔깔거리', '&#128511;');
insert into jeju_user(user_no, email, password, nickname, emoji)
values(10, 'jjj@test.com', password('1111'), '닉네임을입력핫', '&#127776;');

-- 카테고리
insert into jeju_theme_category(category_no, name) values(1, '식당');
insert into jeju_theme_category(category_no, name) values(2, '카페');
insert into jeju_theme_category(category_no, name) values(3, '관광지');
insert into jeju_theme_category(category_no, name) values(4, '기타');

-- 테마
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(1, 1, '애월에 가면', 0, 1, 3, 20210621, '&#127749;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(2, 1, '제주도 향토 음식', 0, 1, 1, 20210628, '&#127796;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(3, 1, '서귀포 숙소 추천', 0, 1, 4, 20210701, '&#127818;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(20, 1, '커피가 정말 맛있는 카페', 1, 1, 2, 20211030, '&#128511;');

insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(4, 2, '바람을 벗삼아 떠나 보자', 0, 1, 3, 20210731, '&#128674;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(5, 2, '자연광이 좋은 카페', 0, 1, 2, 20210801, '&#127754;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(6, 2, '제주의 봄', 0, 1, 4, 20210831, '&#129372;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(21, 2, '내가 본 제주', 1, 1, 4, 20210621, '&#127749;');

insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(7, 3, '바다가 사랑한 섬 우도', 0, 1, 3, 20210901, '&#128757;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(8, 3, '반려 동물과 함께 가기 좋은 카페', 0, 1, 1, 20210930, '&#128031;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(9, 3, '화장실 깨끗한 장소', 0, 1, 4, 20211001, '&#128511;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(22, 3, '고기가 두툼한 흑돼지 집', 1, 1, 1, 20210628, '&#127796;');

insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(10, 4, '제주 동부 투어', 0, 1, 3, 20211031, '&#127776;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(11, 4, '뷰가 좋아서 멍 때리기 좋은', 0, 1, 2, 20211101, '&#127749;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(12, 4, '해산물이 먹고 싶을 때', 0, 1, 1, 20211123, '&#127796;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(23, 4, '차 한잔 할래요?', 1, 1, 2, 20210701, '&#127818;');

insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(13, 5, '노을에 잠기는 바다', 0, 1, 3, 20210715, '&#127818;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(14, 5, '반려 동물과 함께 가기 좋은 카페', 0, 1, 2, 20210815, '&#128674;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(15, 5, '제주도민은 여기만 간다', 0, 1, 4, 20210915, '&#127754;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(24, 5, '제주 여행 버킷 리스트', 1, 1, 3, 20211030, '&#128511;');

insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(16, 6, '2020 제주', 0, 0, 4, 20211015, '&#129372;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(17, 6, '슬기로운 제주 생활', 0, 1, 4, 20211115, '&#128757;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(18, 6, '24시간 병원', 0, 1, 2, 20210721, '&#128031;');
insert into jeju_theme(theme_no, user_no, title, share, public, category_no, created_dt, emoji) values(19, 6, '미성년자도 달리자!', 0, 1, 1, 20211030, '&#128511;');

-- 장소
insert into jeju_place(place_id, place_name, place_address,x_coord,y_coord) values('1261877281', '로맨틱새우', '제주특별자치도 제주시 애월읍 곽지리 1584-5', 126.305303780014, 33.4481834855432);
insert into jeju_place(place_id, place_name, place_address,x_coord,y_coord) values('1641211499', '도치돌목장', '제주특별자치도 제주시 애월읍 납읍리 102', 126.365809643225, 33.4099556021011);
insert into jeju_place(place_id, place_name, place_address,x_coord,y_coord) values('269602057', '오션뷰제주 게스트하우스', '제주특별자치도 서귀포시 안덕면 창천리 785-2', 126.367031286534, 33.2322187489819);
insert into jeju_place(place_id, place_name, place_address,x_coord,y_coord) values('27525363', '깡촌흑돼지', '제주특별자치도 제주시 조천읍 함덕리 1001', 126.667135470078, 33.541274383213);

-- 좋아하는 유저
insert into jeju_liked_user(user_no, liked_user_no) values(1, 2);
insert into jeju_liked_user(user_no, liked_user_no) values(1, 6);
insert into jeju_liked_user(user_no, liked_user_no) values(2, 3);
insert into jeju_liked_user(user_no, liked_user_no) values(2, 7);
insert into jeju_liked_user(user_no, liked_user_no) values(3, 8);
insert into jeju_liked_user(user_no, liked_user_no) values(3, 4);
insert into jeju_liked_user(user_no, liked_user_no) values(4, 9);
insert into jeju_liked_user(user_no, liked_user_no) values(4, 5);
insert into jeju_liked_user(user_no, liked_user_no) values(5, 10);
insert into jeju_liked_user(user_no, liked_user_no) values(5, 1);

-- 좋아하는 테마
insert into jeju_liked_theme(user_no, theme_no) values(1, 4);
insert into jeju_liked_theme(user_no, theme_no) values(1, 7);
insert into jeju_liked_theme(user_no, theme_no) values(1, 10);
insert into jeju_liked_theme(user_no, theme_no) values(2, 8);
insert into jeju_liked_theme(user_no, theme_no) values(2, 11);
insert into jeju_liked_theme(user_no, theme_no) values(2, 14);
insert into jeju_liked_theme(user_no, theme_no) values(3, 12);
insert into jeju_liked_theme(user_no, theme_no) values(3, 15);
insert into jeju_liked_theme(user_no, theme_no) values(3, 18);
insert into jeju_liked_theme(user_no, theme_no) values(4, 1);
insert into jeju_liked_theme(user_no, theme_no) values(4, 5);
insert into jeju_liked_theme(user_no, theme_no) values(4, 9);
insert into jeju_liked_theme(user_no, theme_no) values(5, 2);
insert into jeju_liked_theme(user_no, theme_no) values(5, 6);
insert into jeju_liked_theme(user_no, theme_no) values(5, 16);

-- 장소 사진
insert into jeju_place_photo(place_photo_no, place_id, file_path, user_no) values(1, '1261877281',  '조개.gif', 1);
insert into jeju_place_photo(place_photo_no, place_id, file_path, user_no) values(2, '1641211499', '양.jpg', 1);

insert into jeju_place_photo(place_photo_no, place_id, file_path, user_no) values(3, '1261877281', '새우.jpg', 4);
insert into jeju_place_photo(place_photo_no, place_id, file_path, user_no) values(4, '269602057', '오션뷰.jpg', 4);

insert into jeju_place_photo(place_photo_no, place_id, file_path, user_no) values(5, '27525363', '돼지.jpg', 2);
insert into jeju_place_photo(place_photo_no, place_id, file_path, user_no) values(6, '27525363', '흑돼지.jpg', 5);
insert into jeju_place_photo(place_photo_no, place_id, file_path, user_no) values(7, '27525363', '삼겹살.gif', 3);

-- 장소 후기
insert into jeju_place_comment(place_comment_no, place_id, comment, user_no) values(1, '1261877281', '새우집인데 조개가 존맛 ㅠㅠ', 1);
insert into jeju_place_comment(place_comment_no, place_id, comment, user_no) values(2, '1641211499', '귀여운 양', 1);

insert into jeju_place_comment(place_comment_no, place_id, comment, user_no) values(3, '1261877281', '새우가 맛있음!!', 4);
insert into jeju_place_comment(place_comment_no, place_id, comment, user_no) values(4, '269602057', '분위기가 너무 좋다.', 4);
                               
insert into jeju_place_comment(place_comment_no, place_id, comment, user_no) values(5, '27525363', '흑돼지 존맛집!!', 2);
insert into jeju_place_comment(place_comment_no, place_id, comment, user_no) values(6, '27525363', '현지인들도 매일 가는 맛집', 5);
insert into jeju_place_comment(place_comment_no, place_id, comment, user_no) values(7, '27525363', '주차장이 넓은 삼겹살맛집', 3);

-- 장소_유저_테마
insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('1261877281', 1, 8);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('1261877281', 2, 15);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('1261877281', 3, 12);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('1261877281', 4, 2);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('1641211499', 3, 1);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('1641211499', 6, 15);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('27525363', 3, 15);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('1641211499', 2, 4);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('269602057', 4, 1);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('269602057', 2, 3);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('269602057', 5, 10);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('269602057', 1, 16);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('27525363', 6, 16);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('27525363', 5, 10);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('27525363', 3, 5);

insert into jeju_place_user_theme(place_id, user_no, theme_no) 
values('27525363', 4, 9);

-- 게시판
insert into jeju_board(board_no,title,content,user_no) 
values(1,'제목1', '내용1', 1);
insert into jeju_board(board_no,title,content,user_no) 
values(2,'제목2', '내용2', 2);
insert into jeju_board(board_no,title,content,user_no) 
values(3,'제목3', '내용3', 3);
insert into jeju_board(board_no,title,content,user_no) 
values(4,'제목4', '내용4', 4);
insert into jeju_board(board_no,title,content,user_no) 
values(5,'제목5', '내용5', 5);
insert into jeju_board(board_no,title,content,user_no) 
values(6,'제목6', '내용6', 6);

-- 게시판 댓글
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(1,1,1,'댓글1-1',20210621);
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(2,1,12,'댓글1-2',20210622);
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(3,1,2,'댓글1-3',20210622);

insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(4,2,2,'댓글2-1',20210723);
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(5,2,11,'댓글2-2',20210724);
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(6,2,3,'댓글2-3',20210731);

insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(7,3,3,'댓글3-1',20210825);
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(8,3,10,'댓글3-2',20210826);
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(9,3,4,'댓글3-3',20210925);

insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(10,4,4,'댓글4-1',20210927);
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(11,4,9,'댓글4-2',20210928);
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(12,4,5,'댓글4-3',202101001);

insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(13,5,5,'댓글5-1',20211029);
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(14,5,8,'댓글5-2',20211030);
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(15,5,6,'댓글5-3',20211115);

insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(16,6,6,'댓글6-1',20211122);
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(17,6,7,'댓글6-2',20211123);
insert into jeju_board_comment(board_comment_no,board_no,user_no,content,created_dt)
values(18,6,1,'댓글6-3',20211123);