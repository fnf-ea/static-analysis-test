CREATE SCHEMA IF NOT EXISTS product;

DROP TABLE IF EXISTS product.scs cascade;
DROP TABLE IF EXISTS product.style cascade;
DROP TABLE IF EXISTS product.color cascade;
DROP TABLE IF EXISTS product.size cascade;

CREATE SCHEMA IF NOT EXISTS shop;
DROP TABLE IF EXISTS shop.shop cascade;

CREATE SCHEMA IF NOT EXISTS member;
DROP TABLE IF EXISTS member.member_mileage cascade;
DROP TABLE IF EXISTS member.member cascade;

CREATE SCHEMA IF NOT EXISTS rfid;
DROP TABLE IF EXISTS rfid.rfid cascade;

CREATE SCHEMA IF NOT EXISTS sale;
DROP TABLE IF EXISTS sale.sale cascade;
DROP TABLE IF EXISTS sale.sale_queue cascade;