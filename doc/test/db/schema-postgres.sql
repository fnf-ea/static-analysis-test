-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- COLOR Table Create SQL
-- 테이블 생성 SQL - product.COLOR

CREATE TABLE product.COLOR
(
    id      BIGSERIAL      NOT NULL,
    code    VARCHAR(50)    NOT NULL,
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - product.COLOR
COMMENT ON TABLE product.COLOR IS '컬러 테이블';

-- 컬럼 Comment 설정 SQL - product.COLOR.id
COMMENT ON COLUMN product.COLOR.id IS '컬러 ID';

-- 컬럼 Comment 설정 SQL - product.COLOR.code
COMMENT ON COLUMN product.COLOR.code IS '컬러 코드';


-- SIZE Table Create SQL
-- 테이블 생성 SQL - product.SIZE
CREATE TABLE product.SIZE
(
    id      BIGSERIAL      NOT NULL,
    code    VARCHAR(50)    NOT NULL,
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - product.SIZE
COMMENT ON TABLE product.SIZE IS '사이즈 테이블';

-- 컬럼 Comment 설정 SQL - product.SIZE.id
COMMENT ON COLUMN product.SIZE.id IS '사이즈 ID';

-- 컬럼 Comment 설정 SQL - product.SIZE.code
COMMENT ON COLUMN product.SIZE.code IS '사이즈 코드';


-- STYLE Table Create SQL
-- 테이블 생성 SQL - product.STYLE
CREATE TABLE product.STYLE
(
    id      BIGSERIAL       NOT NULL,
    code    VARCHAR(50)     NOT NULL,
    name    VARCHAR(150)    NOT NULL,
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - product.STYLE
COMMENT ON TABLE product.STYLE IS '상품 테이블';

-- 컬럼 Comment 설정 SQL - product.STYLE.id
COMMENT ON COLUMN product.STYLE.id IS '스타일 ID';

-- 컬럼 Comment 설정 SQL - product.STYLE.code
COMMENT ON COLUMN product.STYLE.code IS '스타일 CODE';

-- 컬럼 Comment 설정 SQL - product.STYLE.name
COMMENT ON COLUMN product.STYLE.name IS '스타일 이름';


-- SCS Table Create SQL
-- 테이블 생성 SQL - product.SCS
CREATE TABLE product.SCS
(
    id           BIGSERIAL    NOT NULL,
    style_id     bigint       NOT NULL,
    color_id     bigint       NOT NULL,
    size_id      bigint       NOT NULL,
    tag_price    bigint       NOT NULL,
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - product.SCS
COMMENT ON TABLE product.SCS IS '상품 SCS 테이블';

-- 컬럼 Comment 설정 SQL - product.SCS.id
COMMENT ON COLUMN product.SCS.id IS '상품 SCS ID';

-- 컬럼 Comment 설정 SQL - product.SCS.style_id
COMMENT ON COLUMN product.SCS.style_id IS '스타일 ID';

-- 컬럼 Comment 설정 SQL - product.SCS.color_id
COMMENT ON COLUMN product.SCS.color_id IS '컬러 ID';

-- 컬럼 Comment 설정 SQL - product.SCS.size_id
COMMENT ON COLUMN product.SCS.size_id IS '사이즈 ID';

-- 컬럼 Comment 설정 SQL - product.SCS.tag_price
COMMENT ON COLUMN product.SCS.tag_price IS '택가';

-- Unique Index 설정 SQL - product.SCS(style_id, color_id, size_id)
CREATE UNIQUE INDEX
    ON product.SCS(style_id, color_id, size_id);

-- Foreign Key 설정 SQL - product.SCS(style_id) -> product.STYLE(id)
ALTER TABLE product.SCS
    ADD CONSTRAINT FK_SCS_style_id_STYLE_id FOREIGN KEY (style_id)
        REFERENCES product.STYLE (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - product.SCS(style_id)
-- ALTER TABLE product.SCS
-- DROP CONSTRAINT FK_SCS_style_id_STYLE_id;

-- Foreign Key 설정 SQL - product.SCS(color_id) -> product.COLOR(id)
ALTER TABLE product.SCS
    ADD CONSTRAINT FK_SCS_color_id_COLOR_id FOREIGN KEY (color_id)
        REFERENCES product.COLOR (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - product.SCS(color_id)
-- ALTER TABLE product.SCS
-- DROP CONSTRAINT FK_SCS_color_id_COLOR_id;

-- Foreign Key 설정 SQL - product.SCS(size_id) -> product.SIZE(id)
ALTER TABLE product.SCS
    ADD CONSTRAINT FK_SCS_size_id_SIZE_id FOREIGN KEY (size_id)
        REFERENCES product.SIZE (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - product.SCS(size_id)
-- ALTER TABLE product.SCS
-- DROP CONSTRAINT FK_SCS_size_id_SIZE_id;


-- SHOP Table Create SQL
-- 테이블 생성 SQL - shop.SHOP
CREATE TABLE shop.SHOP
(
    id      BIGSERIAL       NOT NULL,
    code    VARCHAR(50)     NOT NULL,
    name    VARCHAR(150)    NOT NULL,
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - shop.SHOP
COMMENT ON TABLE shop.SHOP IS '매장 테이블';

-- 컬럼 Comment 설정 SQL - shop.SHOP.id
COMMENT ON COLUMN shop.SHOP.id IS '매장 ID';

-- 컬럼 Comment 설정 SQL - shop.SHOP.code
COMMENT ON COLUMN shop.SHOP.code IS '매장 코드';

-- 컬럼 Comment 설정 SQL - shop.SHOP.name
COMMENT ON COLUMN shop.SHOP.name IS '매장 이름';


-- RFID Table Create SQL
-- 테이블 생성 SQL - rfid.RFID
CREATE TABLE rfid.RFID
(
    id               BIGSERIAL       NOT NULL,
    code             varchar(255)    NOT NULL,
    scs_id           bigint          NOT NULL,
    location_code    VARCHAR(50)     NOT NULL,
    status_code      VARCHAR(3)      NOT NULL,
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - rfid.RFID
COMMENT ON TABLE rfid.RFID IS 'RFID 테이블';

-- 컬럼 Comment 설정 SQL - rfid.RFID.id
COMMENT ON COLUMN rfid.RFID.id IS 'RFID ID';

-- 컬럼 Comment 설정 SQL - rfid.RFID.code
COMMENT ON COLUMN rfid.RFID.code IS 'RFID 코드';

-- 컬럼 Comment 설정 SQL - rfid.RFID.scs_id
COMMENT ON COLUMN rfid.RFID.scs_id IS '상품 SCS ID';

-- 컬럼 Comment 설정 SQL - rfid.RFID.location_code
COMMENT ON COLUMN rfid.RFID.location_code IS '위치 코드';

-- 컬럼 Comment 설정 SQL - rfid.RFID.status_code
COMMENT ON COLUMN rfid.RFID.status_code IS '상태 코드';

-- Foreign Key 설정 SQL - rfid.RFID(scs_id) -> product.SCS(id)
ALTER TABLE rfid.RFID
    ADD CONSTRAINT FK_RFID_scs_id_SCS_id FOREIGN KEY (scs_id)
        REFERENCES product.SCS (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - rfid.RFID(scs_id)
-- ALTER TABLE rfid.RFID
-- DROP CONSTRAINT FK_RFID_scs_id_SCS_id;


-- MEMBER Table Create SQL
-- 테이블 생성 SQL - member.MEMBER
CREATE TABLE member.MEMBER
(
    id           BIGSERIAL      NOT NULL,
    user_id      VARCHAR(50)    NOT NULL,
    user_name    VARCHAR(50)    NOT NULL,
    uuid         uuid           NOT NULL,
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - member.MEMBER
COMMENT ON TABLE member.MEMBER IS '회원 테이블';

-- 컬럼 Comment 설정 SQL - member.MEMBER.id
COMMENT ON COLUMN member.MEMBER.id IS '회원 ID';

-- 컬럼 Comment 설정 SQL - member.MEMBER.user_id
COMMENT ON COLUMN member.MEMBER.user_id IS '회원 아이디';

-- 컬럼 Comment 설정 SQL - member.MEMBER.user_name
COMMENT ON COLUMN member.MEMBER.user_name IS '회원 이름';

-- 컬럼 Comment 설정 SQL - member.MEMBER.uuid
COMMENT ON COLUMN member.MEMBER.uuid IS '회원 UUID';

-- MEMBER_MILEAGE Table Create SQL
-- 테이블 생성 SQL - member.MEMBER_MILEAGE
CREATE TABLE member.MEMBER_MILEAGE
(
    id             BIGSERIAL    NOT NULL,
    member_id      bigint       NOT NULL,
    get_mileage    bigint       NOT NULL,
    use_mileage    bigint       NOT NULL,
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - member.MEMBER_MILEAGE
COMMENT ON TABLE member.MEMBER_MILEAGE IS '회원 마일리지 테이블';

-- 컬럼 Comment 설정 SQL - member.MEMBER_MILEAGE.id
COMMENT ON COLUMN member.MEMBER_MILEAGE.id IS '회원 마일리지 ID';

-- 컬럼 Comment 설정 SQL - member.MEMBER_MILEAGE.member_id
COMMENT ON COLUMN member.MEMBER_MILEAGE.member_id IS '회원 ID';

-- 컬럼 Comment 설정 SQL - member.MEMBER_MILEAGE.get_mileage
COMMENT ON COLUMN member.MEMBER_MILEAGE.get_mileage IS '누적 적립 마일리지';

-- 컬럼 Comment 설정 SQL - member.MEMBER_MILEAGE.use_mileage
COMMENT ON COLUMN member.MEMBER_MILEAGE.use_mileage IS '누적 사용 마일리지';

-- Foreign Key 설정 SQL - member.MEMBER_MILEAGE(member_id) -> member.MEMBER(id)
ALTER TABLE member.MEMBER_MILEAGE
    ADD CONSTRAINT FK_MEMBER_MILEAGE_member_id_MEMBER_id FOREIGN KEY (member_id)
        REFERENCES member.MEMBER (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - member.MEMBER_MILEAGE(member_id)
-- ALTER TABLE member.MEMBER_MILEAGE
-- DROP CONSTRAINT FK_MEMBER_MILEAGE_member_id_MEMBER_id;


-- SALE Table Create SQL
-- 테이블 생성 SQL - sale.SALE
CREATE TABLE sale.SALE
(
    id              BIGSERIAL    NOT NULL,
    rfid_id         bigint       NOT NULL,
    shop_id         bigint       NOT NULL,
    scs_id          bigint       NOT NULL,
    member_id       bigint       NULL,
    sale_date       date         NOT NULL,
    actual_price    bigint       NOT NULL,
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - sale.SALE
COMMENT ON TABLE sale.SALE IS '판매 테이블';

-- 컬럼 Comment 설정 SQL - sale.SALE.id
COMMENT ON COLUMN sale.SALE.id IS '판매 ID';

-- 컬럼 Comment 설정 SQL - sale.SALE.rfid_id
COMMENT ON COLUMN sale.SALE.rfid_id IS 'RFID ID';

-- 컬럼 Comment 설정 SQL - sale.SALE.shop_id
COMMENT ON COLUMN sale.SALE.shop_id IS '매장 ID';

-- 컬럼 Comment 설정 SQL - sale.SALE.scs_id
COMMENT ON COLUMN sale.SALE.scs_id IS '상품 SCS ID';

-- 컬럼 Comment 설정 SQL - sale.SALE.member_id
COMMENT ON COLUMN sale.SALE.member_id IS '회원 ID';

-- 컬럼 Comment 설정 SQL - sale.SALE.sale_date
COMMENT ON COLUMN sale.SALE.sale_date IS '판매 날짜';

-- 컬럼 Comment 설정 SQL - sale.SALE.actual_price
COMMENT ON COLUMN sale.SALE.actual_price IS '실판가';

-- Index 설정 SQL - sale.SALE(sale_date, shop_id)
CREATE INDEX
    ON sale.SALE(sale_date, shop_id);

-- Foreign Key 설정 SQL - sale.SALE(rfid_id) -> rfid.RFID(id)
ALTER TABLE sale.SALE
    ADD CONSTRAINT FK_SALE_rfid_id_RFID_id FOREIGN KEY (rfid_id)
        REFERENCES rfid.RFID (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - sale.SALE(rfid_id)
-- ALTER TABLE sale.SALE
-- DROP CONSTRAINT FK_SALE_rfid_id_RFID_id;

-- Foreign Key 설정 SQL - sale.SALE(shop_id) -> shop.SHOP(id)
ALTER TABLE sale.SALE
    ADD CONSTRAINT FK_SALE_shop_id_SHOP_id FOREIGN KEY (shop_id)
        REFERENCES shop.SHOP (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - sale.SALE(shop_id)
-- ALTER TABLE sale.SALE
-- DROP CONSTRAINT FK_SALE_shop_id_SHOP_id;

-- Foreign Key 설정 SQL - sale.SALE(scs_id) -> product.SCS(id)
ALTER TABLE sale.SALE
    ADD CONSTRAINT FK_SALE_scs_id_SCS_id FOREIGN KEY (scs_id)
        REFERENCES product.SCS (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - sale.SALE(scs_id)
-- ALTER TABLE sale.SALE
-- DROP CONSTRAINT FK_SALE_scs_id_SCS_id;

-- Foreign Key 설정 SQL - sale.SALE(member_id) -> member.MEMBER(id)
ALTER TABLE sale.SALE
    ADD CONSTRAINT FK_SALE_member_id_MEMBER_id FOREIGN KEY (member_id)
        REFERENCES member.MEMBER (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - sale.SALE(member_id)
-- ALTER TABLE sale.SALE
-- DROP CONSTRAINT FK_SALE_member_id_MEMBER_id;


-- SALE_QUEUE Table Create SQL
-- 테이블 생성 SQL - sale.SALE_QUEUE
CREATE TABLE sale.SALE_QUEUE
(
    id                 BIGSERIAL    NOT NULL,
    rfid_id            bigint       NOT NULL,
    shop_id            bigint       NOT NULL,
    scs_id             bigint       NOT NULL,
    sale_queue_date    date         NOT NULL,
    PRIMARY KEY (id)
);

-- 테이블 Comment 설정 SQL - sale.SALE_QUEUE
COMMENT ON TABLE sale.SALE_QUEUE IS '판매 대기 테이블';

-- 컬럼 Comment 설정 SQL - sale.SALE_QUEUE.id
COMMENT ON COLUMN sale.SALE_QUEUE.id IS '판매 대기 ID';

-- 컬럼 Comment 설정 SQL - sale.SALE_QUEUE.rfid_id
COMMENT ON COLUMN sale.SALE_QUEUE.rfid_id IS 'RFID ID';

-- 컬럼 Comment 설정 SQL - sale.SALE_QUEUE.shop_id
COMMENT ON COLUMN sale.SALE_QUEUE.shop_id IS '매장 ID';

-- 컬럼 Comment 설정 SQL - sale.SALE_QUEUE.scs_id
COMMENT ON COLUMN sale.SALE_QUEUE.scs_id IS '상품 SCS ID';

-- 컬럼 Comment 설정 SQL - sale.SALE_QUEUE.sale_queue_date
COMMENT ON COLUMN sale.SALE_QUEUE.sale_queue_date IS '대기열 등록일';

-- Index 설정 SQL - sale.SALE_QUEUE(sale_queue_date, shop_id)
CREATE INDEX
    ON sale.SALE_QUEUE(sale_queue_date, shop_id);

-- Foreign Key 설정 SQL - sale.SALE_QUEUE(rfid_id) -> rfid.RFID(id)
ALTER TABLE sale.SALE_QUEUE
    ADD CONSTRAINT FK_SALE_QUEUE_rfid_id_RFID_id FOREIGN KEY (rfid_id)
        REFERENCES rfid.RFID (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - sale.SALE_QUEUE(rfid_id)
-- ALTER TABLE sale.SALE_QUEUE
-- DROP CONSTRAINT FK_SALE_QUEUE_rfid_id_RFID_id;

-- Foreign Key 설정 SQL - sale.SALE_QUEUE(shop_id) -> shop.SHOP(id)
ALTER TABLE sale.SALE_QUEUE
    ADD CONSTRAINT FK_SALE_QUEUE_shop_id_SHOP_id FOREIGN KEY (shop_id)
        REFERENCES shop.SHOP (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - sale.SALE_QUEUE(shop_id)
-- ALTER TABLE sale.SALE_QUEUE
-- DROP CONSTRAINT FK_SALE_QUEUE_shop_id_SHOP_id;

-- Foreign Key 설정 SQL - sale.SALE_QUEUE(scs_id) -> product.SCS(id)
ALTER TABLE sale.SALE_QUEUE
    ADD CONSTRAINT FK_SALE_QUEUE_scs_id_SCS_id FOREIGN KEY (scs_id)
        REFERENCES product.SCS (id) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- Foreign Key 삭제 SQL - sale.SALE_QUEUE(scs_id)
-- ALTER TABLE sale.SALE_QUEUE
-- DROP CONSTRAINT FK_SALE_QUEUE_scs_id_SCS_id;



-- Foreign Key 삭제 SQL - sale.SALE_QUEUE(scs_id)
-- ALTER TABLE sale.SALE_QUEUE
-- DROP CONSTRAINT FK_SALE_QUEUE_scs_id_SCS_id;


