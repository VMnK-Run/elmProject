-- Active: 1653986677042@@127.0.0.1@3306@employees
CREATE DATABASE elm_admin;

USE elm_admin;

CREATE Table IF NOT EXISTS business(
    businessId      INT             NOT NULL    PRIMARY KEY AUTO_INCREMENT,
    password        VARCHAR(20)     NOT NULL,
    businessName    VARCHAR(40)     NOT NULL,
    businessAddress VARCHAR(40),
    businessExplain VARCHAR(40),
    startPrice       decimal(5, 2)   DEFAULT(0.00),
    deliveryPrice   decimal(5, 2)   DEFAULT(0.00)
);

CREATE Table IF NOT EXISTS food(
    foodId          INT             NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '食品编号',
    foodName        VARCHAR(30)     NOT NULL COMMENT '食品名称',
    foodExplain     VARCHAR(30)     COMMENT '食品介绍',
    foodPrice       DECIMAL(5, 2)   NOT NULL COMMENT '食品价格',
    businessId      INT             COMMENT '所属商家编号',
    FOREIGN KEY(businessId) REFERENCES business(businessId)
);

CREATE TABLE IF NOT EXISTS admin(
    adminId INt NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '管理员编号',
    adminName VARCHAR(20) NOT NULL UNIQUE COMMENT '管理员名称',
    password VARCHAR(20) NOT NULL COMMENT '密码'
);

INSERT INTO admin 
(adminId, adminName, password)
VALUES
(1, 'admin1', '123');

INSERT INTO business
(password, businessName, businessAddress, businessExplain, startPrice, deliveryPrice)
VALUES
('123', '学一食堂', '天津大学', '天大的一个食堂', 1.00, 5.00);