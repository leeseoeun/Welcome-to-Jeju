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
values(8, '&#128044;');
insert into emoji(emoji_no, emoji)
values(9, '&#128511;');
insert into emoji(emoji_no, emoji)
values(10, '&#127801;');

-- 유저
insert into jeju_user(user_no,email,password,nickname,emoji)
values(1,'aaa@test.com',password('1111'),'감귤밭떼기','&#127749;');
insert into jeju_user(user_no,email,password,nickname,emoji)
values(2,'bbb@test.com',password('1111'),'서은','&#127796;');
insert into jeju_user(user_no,email,password,nickname,emoji)
values(3,'ccc@test.com',password('1111'),'한라봉농장','&#127818;');
insert into jeju_user(user_no,email,password,nickname,emoji)
values(4,'ddd@test.com',password('1111'),'혜연','&#128674;');
insert into jeju_user(user_no,email,password,nickname,emoji)
values(5,'eee@test.com',password('1111'),'제주정승','&#127754;');
insert into jeju_user(user_no,email,password,nickname,emoji)
values(6,'fff@test.com',password('1111'),'땅콩막걸리','&#129372;');
insert into jeju_user(user_no,email,password,nickname,emoji)
values(7,'ggg@test.com',password('1111'),'깔깔거리','&#128757;');
insert into jeju_user(user_no,email,password,nickname,emoji)
values(8,'hhh@test.com',password('1111'),'킹콩','&#128044;');
insert into jeju_user(user_no,email,password,nickname,emoji)
values(9,'iii@test.com',password('1111'),'말뚝','&#128511;');
insert into jeju_user(user_no,email,password,nickname,emoji)
values(10,'jjj@test.com',password('1111'),'닉네임을입력핫','&#127801;');

-- 카테고리
insert into jeju_theme_category(category_no,name) values(1,'식당');
insert into jeju_theme_category(category_no,name) values(2,'카페');
insert into jeju_theme_category(category_no,name) values(3,'관광지');
insert into jeju_theme_category(category_no,name) values(4,'기타');

-- 테마
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(1,1,'맛집이 왜 여기에서 나와?',1,1,1,'&#127749;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(2,1,'커피가 맛있는 카페',2,1,1,'&#127796;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(3,1,'바다가 사랑한 섬, 우도',3,1,0,'&#127818;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(4,1,'24시간! 병원 약국',4,1,0,'&#128674;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(25,1,'Welcome To Jeju!',4,0,0,'&#127754;');

insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(5,2,'혼(자)여(행) 혼(자)밥(먹)',1,1,0,'&#127754;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(6,2,'뷰가 좋아서 멍 때리기 좋은 카페',2,1,0,'&#129372;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(7,2,'바람을 벗삼아 떠나 보자',3,1,1,'&#128757;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(8,2,'영감이 떠오르는 장소',4,1,1,'&#128044;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(26,2,'2021 제주',4,0,0,'&#129372;');

insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(9, 3,'인스타 걤성 식당',1,1,1,'&#128511;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(10,3,'차茶 한잔 마실래요?',2,1,1,'&#127801;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(11,3,'제주의 오름',3,1,0,'&#127749;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(12,3,'뭐 할지 모르겠을 때',4,1,0,'&#127796;');

insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(13,4,'부모님 모시고 가기 좋은 식당',1,1,0,'&#127818;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(14,4,'반려 동물과 함께 가기 좋은 카페',2,1,0,'&#128674;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(15,4,'제주의 봄 만끽하기',3,1,1,'&#127754;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(16,4,'너를 위해서 준비했어! 선물 사기 좋은 장소',4,1,1,'&#129372;');

insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(17,5,'해산물이 먹고 싶을 때',1,1,1,'&#128757;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(18,5,'흡연자를 위한',2,1,10210715,'&#128044;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(19,5,'제주의 가을 속으로',3,1,0,'&#128511;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(20,5,'#숙소 #호텔 #에어비앤비',4,1,0,'&#127801;');

insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(21,6,'고기가 두꺼운 흑돼지',1,0,0,'&#127749;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(22,6,'감귤한라봉땅콩 그리고 디저트',2,1,0,'&#127796;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(23,6,'겨울 제주 체험하기',3,1,1,'&#127818;');
insert into jeju_theme(theme_no,user_no,title,category_no,public,share,emoji)
values(24,6,'화장실이 깨끗한 장소',4,1,1,'&#128674;');

-- 장소
-- 식당
insert into jeju_place(place_id,place_name,place_address,x_coord,y_coord)
values('17357777','청파식당횟집','제주특별자치도 제주시 구좌읍 세화리 3648-5',126.853660589285,33.5245265612905);
insert into jeju_place(place_id,place_name,place_address,x_coord,y_coord)
values('798042705','정직한돈 협재직영점','제주특별자치도 제주시 한림읍 협재리 1087',126.250351743321,33.3891116037616);
-- 카페
insert into jeju_place(place_id,place_name,place_address,x_coord,y_coord)
values('217787831','원앤온리','제주특별자치도 서귀포시 안덕면 사계리 86',126.319192490757,33.2392223486155);
insert into jeju_place(place_id,place_name,place_address,x_coord,y_coord)
values('26867476','델문도','제주특별자치도 제주시 조천읍 함덕리 1008-1',126.668723957376,33.5437093358268);
-- 관광지
insert into jeju_place(place_id,place_name,place_address,x_coord,y_coord)
values('11041974','검멀레해변','제주특별자치도 제주시 우도면 연평리',126.966902542993,33.4971710116198);
insert into jeju_place(place_id,place_name,place_address,x_coord,y_coord)
values('8389783','쇠머리오름','제주특별자치도 제주시 우도면 연평리 산 23',126.96359126250867,33.49209675088201);
-- 기타
insert into jeju_place(place_id,place_name,place_address,x_coord,y_coord)
values('8084305','제주한라병원','제주특별자치도 제주시 연동 1963-3',126.4850647711278,33.48990253484053);
insert into jeju_place(place_id,place_name,place_address,x_coord,y_coord)
values('10048087','현대약국','제주특별자치도 제주시 이도일동 1413-1',126.524426516657,33.511211194175);

-- 좋아하는 유저
insert into jeju_liked_user(user_no,liked_user_no) values(1,2);
insert into jeju_liked_user(user_no,liked_user_no) values(1,3);
insert into jeju_liked_user(user_no,liked_user_no) values(1,4);
insert into jeju_liked_user(user_no,liked_user_no) values(2,5);
insert into jeju_liked_user(user_no,liked_user_no) values(2,6);
insert into jeju_liked_user(user_no,liked_user_no) values(2,7);
insert into jeju_liked_user(user_no,liked_user_no) values(3,8);
insert into jeju_liked_user(user_no,liked_user_no) values(3,9);
insert into jeju_liked_user(user_no,liked_user_no) values(3,10);

-- 좋아하는 테마
insert into jeju_liked_theme(user_no,theme_no) values(1,5);
insert into jeju_liked_theme(user_no,theme_no) values(1,9);
insert into jeju_liked_theme(user_no,theme_no) values(1,13);
insert into jeju_liked_theme(user_no,theme_no) values(2,10);
insert into jeju_liked_theme(user_no,theme_no) values(2,14);
insert into jeju_liked_theme(user_no,theme_no) values(2,18);
insert into jeju_liked_theme(user_no,theme_no) values(3,15);
insert into jeju_liked_theme(user_no,theme_no) values(3,19);
insert into jeju_liked_theme(user_no,theme_no) values(3,23);

-- 장소 사진
insert into jeju_place_photo(place_photo_no,place_id,file_path,user_no)
values(1,'17357777','청파식당횟집1.gif',1);
insert into jeju_place_photo(place_photo_no,place_id,file_path,user_no)
values(2,'17357777','청파식당횟집2.jpg',2);

insert into jeju_place_photo(place_photo_no,place_id,file_path,user_no)
values(3,'217787831','원앤온리1.gif',3);
insert into jeju_place_photo(place_photo_no,place_id,file_path,user_no)
values(4,'217787831','원앤온리2.jpg',4);

insert into jeju_place_photo(place_photo_no,place_id,file_path,user_no)
values(5,'11041974','검멀레해변1.gif',5);
insert into jeju_place_photo(place_photo_no,place_id,file_path,user_no)
values(6,'11041974','검멀레해변2.jpg',6);

-- 장소 후기
insert into jeju_place_comment(place_comment_no,place_id,comment,user_no)
values(1,'17357777','세화 근처 고등어회 맛집',1);
insert into jeju_place_comment(place_comment_no,place_id,comment,user_no)
values(2,'17357777','포장 주문도 가능!',2);

insert into jeju_place_comment(place_comment_no,place_id,comment,user_no)
values(3,'217787831','서귀포시 카페 투어 with 원앤온리',3);
insert into jeju_place_comment(place_comment_no,place_id,comment,user_no)
values(4,'217787831','주차 공간이 넓음',4);
                               
insert into jeju_place_comment(place_comment_no,place_id,comment,user_no)
values(5,'11041974','검은 모레 해변과 절벽이 인상 깊은 장소',1);
insert into jeju_place_comment(place_comment_no,place_id,comment,user_no)
values(6,'11041974','ㅜㅜ 썰물 때만 동굴 입구를 찾을 수 있어요',3);
 
-- 장소_유저_테마
insert into jeju_place_user_theme(place_id,user_no,theme_no)
values('17357777',1,1);
insert into jeju_place_user_theme(place_id,user_no,theme_no)
values('17357777',2,17);

insert into jeju_place_user_theme(place_id,user_no,theme_no)
values('217787831',3,2);
insert into jeju_place_user_theme(place_id,user_no,theme_no)
values('217787831',4,10);

insert into jeju_place_user_theme(place_id,user_no,theme_no)
values('11041974',1,3);
insert into jeju_place_user_theme(place_id,user_no,theme_no)
values('11041974',3,12);
insert into jeju_place_user_theme(place_id,user_no,theme_no)
values('11041974',1,25);

-- 게시판
insert into jeju_board(board_no,title,content,user_no) values(1,'제목1','내용1',1);
insert into jeju_board(board_no,title,content,user_no) values(2,'제목2','내용2',2);
insert into jeju_board(board_no,title,content,user_no) values(3,'제목3','내용3',3);
insert into jeju_board(board_no,title,content,user_no) values(4,'제목4','내용4',4);
insert into jeju_board(board_no,title,content,user_no) values(5,'제목5','내용5',5);
insert into jeju_board(board_no,title,content,user_no) values(6,'제목6','내용6',6);

-- 게시판 댓글
insert into jeju_board_comment(board_comment_no,board_no,user_no,content)
values(1,1,1,'댓글1-1');
insert into jeju_board_comment(board_comment_no,board_no,user_no,content)
values(2,1,2,'댓글1-2');

insert into jeju_board_comment(board_comment_no,board_no,user_no,content)
values(3,2,3,'댓글2-1');
insert into jeju_board_comment(board_comment_no,board_no,user_no,content)
values(4,2,4,'댓글2-2');

insert into jeju_board_comment(board_comment_no,board_no,user_no,content)
values(5,3,5,'댓글3-1');
insert into jeju_board_comment(board_comment_no,board_no,user_no,content)
values(6,3,6,'댓글3-2');

insert into jeju_board_comment(board_comment_no,board_no,user_no,content)
values(7,4,7,'댓글4-1');
insert into jeju_board_comment(board_comment_no,board_no,user_no,content)
values(8,4,8,'댓글4-2');

insert into jeju_board_comment(board_comment_no,board_no,user_no,content)
values(9,5,9,'댓글5-1');
insert into jeju_board_comment(board_comment_no,board_no,user_no,content)
values(10,5,10,'댓글5-2');
