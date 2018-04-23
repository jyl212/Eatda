select * from rest; 

delete from rest where rest_id = "sdfs";  

select * from MEMBER;

 
update rest set ADDR = '서울 구로구 디지털로 288 1802호' where REST_ID = 'aaaa003';
 aaaa001 1234          미즈컨테이너 강남 이스트        김동혁        113-86-69236      서울 강남구 강남대로102길 13-3     37.502144 127.026768 070-8885-5199 kmk870630@gmail.com  12:00     22:30      이탈리아 레스토랑 단체석, 남/녀 화장실 구분,주차불가        src/image/miz_view1.jpg      src/image/miz_view2.jpg

delete from rest LIKE JAVA%; 

	update rest SET REST_IMG1 = 'src/image/8ble_view1.jpg', REST_IMG2 = 'src/image/8ble_view2.jpg' where REST_ID = 'aaaa021';
	update rest SET REST_IMG1 = 'src/image/lee_view1.jpg', REST_IMG2 = 'src/image/lee_view2.jpg' where REST_ID = 'aaaa022';
	update rest SET REST_IMG1 = 'src/image/buuack_view1.jpg', REST_IMG2 = 'src/image/buuack_view2.jpg' where REST_ID = 'aaaa023';
	update rest SET REST_IMG1 = 'src/image/lingko_view1.JPG', REST_IMG2 = 'src/image/lingko_view2.JPG' where REST_ID = 'aaaa024';
	update rest SET REST_IMG1 = 'src/image/pasmin_view1.JPG', REST_IMG2 = 'src/image/pasmin_view2.JPG' where REST_ID = 'aaaa025';
	update rest SET REST_IMG1 = 'src/image/kiss_view1.jpg', REST_IMG2 = 'src/image/kiss_view2.jpg' where REST_ID = 'aaaa026';
	
	select * from REST_TABLE
	
	select * from RESERVATION
	
	
	select * from menu m ,reservation_detail d, RESERVATION r  where m.menu_no = d.menu_no and d.reser_no = r.reser_no;
	
	alter sequence eatda.order_sequence nocache;
	
	alter sequence eatda.RESER_SEQUENCE nocache;