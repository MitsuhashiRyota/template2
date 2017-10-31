DROP DATABASE if exists komozon;

CREATE DATABASE if not exists komozon;
USE komozon;

DROP TABLE if exists user_info;

CREATE TABLE user_info(
id int PRIMARY KEY NOT NULL auto_increment,
user_id varchar(255) NOT NULL UNIQUE,
password varchar(8) NOT NULL,
first_name varchar(255) NOT NULL,
family_name varchar(255) NOT NULL,
first_name_kana varchar(255),
family_name_kana varchar(255),
email varchar(255) UNIQUE,
status tinyint(1) DEFAULT 0 NOT NULL,
logined tinyint(1) DEFAULT 0 NOT NULL,
user_type tinyint(1) DEFAULT 0 NOT NULL,
insert_date datetime NOT NULL,
update_date datetime
);

DROP TABLE if exists item_info;

CREATE TABLE item_info(
id int PRIMARY KEY NOT NULL,
item_id int NOT NULL UNIQUE,
item_name varchar(255) UNIQUE,
item_name_kana varchar(255) UNIQUE,
item_description varchar(255),
category_id int,
price int,
stock int,
image_file_path varchar(255),
image_file_name varchar(255),
release_date datetime,
release_company varchar(255),
user_rating int DEFAULT 0,
status tinyint(1) DEFAULT 0 NOT NULL,
insert_date datetime,
update_date datetime
);

DROP TABLE if exists cart_info;

CREATE TABLE cart_info(
id int primary key NOT NULL auto_increment,
user_id varchar(255) NOT NULL,
item_id int NOT NULL,
quantity int,
payment tinyint(1) DEFAULT 0 NOT NULL,
insert_date datetime,
update_date datetime
);

DROP TABLE if exists purchase_history_info;

CREATE TABLE purchase_history_info(
id int primary key NOT NULL auto_increment,
user_id varchar(255) NOT NULL,
item_id int NOT NULL,
quantity int,
payment tinyint(1) DEFAULT 0  NOT NULL,
insert_date datetime,
update_date datetime
);

DROP TABLE if exists m_category;

CREATE TABLE m_category(
id int PRIMARY KEY NOT NULL,
category_id int,
category_name varchar(255) UNIQUE,
category_description varchar(255) UNIQUE,
insert_date datetime,
update_date datetime
);

INSERT INTO m_category(id, category_id, category_name, category_description)
VALUES
(1, 1, "本・参考書", "技術に関する参考をまとめたカテゴリになります。"),
(2, 2, "家電・パソコン", "一般家庭で使われている電化製品をまとめたカテゴリとなります。");

INSERT INTO item_info(id, item_id, item_name, item_name_kana, item_description,
category_id, price, stock, image_file_path, image_file_name, release_date, release_company,
user_rating, status)
VALUES
(1, 1, "Java参考書", "じゃばさんこうしょ", "インターノウス株式会社から出版されたJavaの基礎が学べる参考書です。"
, 1, 1500, 30, "./img/java_book.jpg", "java_book.jpg", "2017/10/29", "インターノウス株式会社", 0, 1),
(2, 2, "PHP参考書", "ぴーえいちぴーこうしょ", "インターノウス株式会社から出版されたPHPの基礎が学べる参考書です。"
, 1, 2500, 30, "./img/php_book.jpg", "php_book.jpg", "2017/10/30", "インターノウス株式会社", 2, 1),
(3, 3, "Python参考書", "ぱいそんさんこうしょ", "インターノウス株式会社から出版されたPythonの基礎が学べる参考書です。"
, 1, 2800, 30, "./img/python_book.jpg", "python_book.jpg", "2017/09/29", "インターノウス株式会社", 3, 1),
(4, 4, "Ruby参考書", "るぼーさんこうしょ", "インターノウス株式会社から出版されたRubyの基礎が学べる参考書です。"
, 1, 1000, 30, "./img/ruby_book.jpg", "ruby_book.jpg", "2017/08/29", "インターノウス株式会社", 4, 1),
(5, 5, "JSP参考書", "じぇーえすぴーさんこうしょ", "インターノウス株式会社から出版されたJSPの基礎が学べる参考書です。"
, 1, 1800, 20, "./img/jsp_book.jpg", "jsp_book.jpg", "2017/07/29", "インターノウス株式会社", 2, 1),
(6, 6, "JavaSE7参考書", "じゃばえすいーせぶんさんこうしょ", "インターノウス株式会社から出版されたJavaSE7の基礎が学べる参考書です。"
, 1, 2200, 30, "./img/javaSE_7_book.jpg", "javaSE_7_book.jpg", "2016/07/29", "インターノウス株式会社", 3, 1),
(7, 7, "JavaSE8参考書", "じゃばえすいーえいとさんこうしょ", "インターノウス株式会社から出版されたJavaSE8の基礎が学べる参考書です。"
, 1, 2200, 22, "./img/javaSE_8_book.jpg", "javaSE_8_book.jpg", "2017/08/29", "インターノウス株式会社", 4, 1),
(8, 8, "JavaEE7参考書", "じゃばいーいーえせぶんさんこうしょ", "インターノウス株式会社から出版されたJavaEE7の基礎が学べる参考書です。"
, 1, 1600, 25, "./img/javaEE7_book.jpg", "javaEE7_book.jpg", "2016/05/19", "インターノウス株式会社", 2, 1),
(9, 9, "JavaEE8参考書", "じゃばいーいーえいとさんこうしょ", "インターノウス株式会社から出版されたJavaEE8の基礎が学べる参考書です。"
, 1, 1800, 15, "./img/javaEE_book.jpg", "javaEE_book.jpg", "2017/05/12", "インターノウス株式会社", 3, 1),
(10, 10, "Java8参考書", "じゃばえいとさんこうしょ", "インターノウス株式会社から出版されたJava8の基礎が学べる参考書です。"
, 1, 2900, 10, "./img/java_8_book.jpg", "java_8_book.jpg", "2016/02/22", "インターノウス株式会社", 2, 1),
(11, 11, "Java8ラムダ式参考書", "じゃばえいとらむだしきさんこうしょ", "インターノウス株式会社から出版されたJava8ラムダ式の基礎が学べる参考書です。"
, 1, 2200, 30, "./img/java_8_lambda_book.jpg", "java_8_lambda_book.jpg", "2016/10/29", "インターノウス株式会社", 3, 1),
(12, 12, "SQL参考書", "えすきゅーえるさんこうしょ", "インターノウス株式会社から出版されたSQLの基礎が学べる参考書です。"
, 1, 1200, 20, "./img/sql_book.jpg", "sql_book.jpg", "2014/10/29", "インターノウス株式会社", 4, 1),
(13, 13, "SpringBoot参考書", "すぷりんぐぶうとさんこうしょ", "インターノウス株式会社から出版されたSpringBootの基礎が学べる参考書です。"
, 1, 3800, 30, "./img/springBoot_book.jpg", "springBoot_book.jpg", "2017/08/29", "インターノウス株式会社", 5, 1),
(14, 14, "Maven参考書", "めいべんさんこうしょ", "インターノウス株式会社から出版されたMavenの基礎が学べる参考書です。"
, 1, 2900, 40, "./img/maven_book.jpg", "maven_book.jpg", "2017/05/11", "インターノウス株式会社", 4, 1);

INSERT INTO user_info(user_id, password, first_name, family_name, status, logined, user_type, insert_date)
VALUES
("test", "test", "ABC", "DFG", 1, 0, 0, "2017/10/29");