/*STYLE*/
INSERT INTO product.style (id, code, name) VALUES (DEFAULT, '3ZW5C5342','MLB 모자');
INSERT INTO product.style (id, code, name) VALUES (DEFAULT, '4845S621B','MLB 신발');
INSERT INTO product.style (id, code, name) VALUES (DEFAULT, '4845S943B','MLB 다운점퍼');
INSERT INTO product.style (id, code, name) VALUES (DEFAULT, '4EE950J5B','MLB 티셔츠');
INSERT INTO product.style (id, code, name) VALUES (DEFAULT, '4OC750Y70','MLB 트레이닝복');

/*SIZE*/
INSERT INTO product.size (id, code) VALUES (DEFAULT, 'S');
INSERT INTO product.size (id, code) VALUES (DEFAULT, 'M');
INSERT INTO product.size (id, code) VALUES (DEFAULT, 'L');
INSERT INTO product.size (id, code) VALUES (DEFAULT, 'XL');
INSERT INTO product.size (id, code) VALUES (DEFAULT, 'SS');

/*COLOR*/
INSERT INTO product.color (id, code) VALUES (DEFAULT, 'BK');
INSERT INTO product.color (id, code) VALUES (DEFAULT, 'WH');
INSERT INTO product.color (id, code) VALUES (DEFAULT, 'GY');
INSERT INTO product.color (id, code) VALUES (DEFAULT, 'RD');
INSERT INTO product.color (id, code) VALUES (DEFAULT, 'BL');

/*SCS*/
INSERT INTO product.scs(id, style_id, color_id, size_id, tag_price) VALUES (DEFAULT, 1, 1, 1, 150000);
INSERT INTO product.scs(id, style_id, color_id, size_id, tag_price) VALUES (DEFAULT, 1, 2, 1, 150000);
INSERT INTO product.scs(id, style_id, color_id, size_id, tag_price) VALUES (DEFAULT, 1, 3, 1, 150000);
INSERT INTO product.scs(id, style_id, color_id, size_id, tag_price) VALUES (DEFAULT, 2, 1, 1, 200000);
INSERT INTO product.scs(id, style_id, color_id, size_id, tag_price) VALUES (DEFAULT, 2, 2, 1, 200000);

/*SHOP*/
INSERT INTO shop.shop(id, code, name) VALUES (DEFAULT, 'S001','MLB 가로수길');
INSERT INTO shop.shop(id, code, name) VALUES (DEFAULT, 'S002','MLB 역삼');
INSERT INTO shop.shop(id, code, name) VALUES (DEFAULT, 'S003','MLB 신촌');
INSERT INTO shop.shop(id, code, name) VALUES (DEFAULT, 'M001','MLB 온라인몰');
INSERT INTO shop.shop(id, code, name) VALUES (DEFAULT, 'M002','MLB 홍대');
/*RFID*/

INSERT INTO rfid.rfid(id, code, scs_id,  location_code, status_code) VALUES (DEFAULT, '306F48284650F04005F624632344D200',1,1,35);
INSERT INTO rfid.rfid(id, code, scs_id,  location_code, status_code) VALUES (DEFAULT, '306F48284650F04005F624632344D201',1,1,35);
INSERT INTO rfid.rfid(id, code, scs_id, location_code, status_code) VALUES (DEFAULT, '306F48284650F04005F624632344D202',2,1,35);
INSERT INTO rfid.rfid(id, code, scs_id, location_code, status_code) VALUES (DEFAULT, '305F48284650F04005F624D12344D200',3,1,35);
INSERT INTO rfid.rfid(id, code, scs_id ,location_code ,status_code) VALUES (DEFAULT, '304F48284650F04005F624D12344D200',4,1,35);

/*MEMBER*/
INSERT INTO member.member(id, user_id, user_name,uuid) VALUES (DEFAULT, 'test1', '홍길동1','2b681744-8687-11ed-a1eb-0242ac120002');
INSERT INTO member.member(id, user_id, user_name,uuid) VALUES (DEFAULT, 'test2', '홍길동2', '2b681a50-8687-11ed-a1eb-0242ac120002');
INSERT INTO member.member(id, user_id, user_name,uuid) VALUES (DEFAULT, 'test3', '홍길동3', '2b681c08-8687-11ed-a1eb-0242ac120002');
INSERT INTO member.member(id, user_id, user_name,uuid) VALUES (DEFAULT, 'test4', '홍길동4', '2b681d3e-8687-11ed-a1eb-0242ac120002');
INSERT INTO member.member(id, user_id, user_name,uuid) VALUES (DEFAULT, 'test5', '홍길동5', '2b681e6a-8687-11ed-a1eb-0242ac120002');

/*MEMBER_MIELAGE*/
INSERT INTO member.member_mileage(id, member_id,get_mileage,use_mileage) VALUES (DEFAULT, 1 ,0,0);
INSERT INTO member.member_mileage(id, member_id,get_mileage,use_mileage) VALUES (DEFAULT, 2 ,0,0);
INSERT INTO member.member_mileage(id, member_id,get_mileage,use_mileage) VALUES (DEFAULT, 3 ,0,0);
INSERT INTO member.member_mileage(id, member_id,get_mileage,use_mileage) VALUES (DEFAULT, 4 ,0,0);
INSERT INTO member.member_mileage(id, member_id,get_mileage,use_mileage) VALUES (DEFAULT, 5 ,0,0);








