-- Active: 1653986677042@@127.0.0.1@3306@elm
CREATE DATABASE elm;

USE elm;

CREATE Table IF NOT EXISTS business(
    businessId      INT             NOT NULL    PRIMARY KEY AUTO_INCREMENT,
    businessName    VARCHAR(40)     NOT NULL,
    businessAddress VARCHAR(50),
    businessExplain VARCHAR(40),
    businessImg     MEDIUMINT       NOT NULL,
    orderTypeId     INT             NOT NULL,
    startPrice      decimal(5, 2)   DEFAULT(0.00),
    deliveryPrice   decimal(5, 2)   DEFAULT(0.00),
    remark          VARCHAR(40)
);

CREATE Table IF NOT EXISTS food(
    foodId          INT             NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '食品编号',
    foodName        VARCHAR(30)     NOT NULL COMMENT '食品名称',
    foodExplain     VARCHAR(30)     COMMENT '食品介绍',
    foodImg         MEDIUMINT       NOT NULL,
    foodPrice       DECIMAL(5, 2)   NOT NULL COMMENT '食品价格',
    businessId      INT             NOT NULL COMMENT '所属商家编号',
    remark          VARCHAR(40),
    FOREIGN KEY(businessId) REFERENCES business(businessId)
);

CREATE TABLE IF NOT EXISTS user(
    userId      VARCHAR(20)     NOT NULL PRIMARY KEY,
    password    VARCHAR(20)     NOT NULL,
    userName    VARCHAR(20)     NOT NULL,
    userSex     INT             NOT NULL DEFAULT(1),
    userImg     MEDIUMINT,
    delTag      INT             NOT NULL DEFAULT(1)
);

CREATE TABLE IF NOT EXISTS cart(
    cartId      INT             PRIMARY KEY AUTO_INCREMENT NOT NULL,
    foodId      INT             NOT NULL,
    businessId  INT             NOT NULL,
    userId      VARCHAR(20)     NOT NULL,
    quantity    INT             NOT NULL,
    FOREIGN KEY(foodId) REFERENCES food(foodId),
    FOREIGN KEY(businessId) REFERENCES business(businessId),
    FOREIGN KEY(userId) REFERENCES user(userId)
);

CREATE TABLE IF NOT EXISTS deliveryaddress(
    daId        INT             NOT NULL PRIMARY KEY AUTO_INCREMENT,
    contactName VARCHAR(20)     NOt NULL COMMENT '食品编号',
    contactSex  INT             NOT NULL COMMENT '联系人性别',
    contactTel  VARCHAR(20)     NOT NULL,
    address     VARCHAR(100)    NOT NULL,
    userId      VARCHAR(20)     NOT NULL,
    FOREIGN KEY(userId) REFERENCES user(userID)
);

CREATE TABLE IF NOT EXISTS orders(
    orderId     INT             NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userId      VARCHAR(20)     NOT NULL,
    businessId  INT             NOT NULL,
    orderDate   VARCHAR(20)     NOT NULL,
    orderTotal  DECIMAL(7, 2)   NOT NULL DEFAULT(0.00),
    daId        INT             NOT NULL,
    orderState  INT             NOT NULL DEFAULT(0),
    FOREIGN KEY(userID) REFERENCES user(userID),
    FOREIGN KEY(businessId) REFERENCES business(businessId),
    FOREIGN KEY(daId) REFERENCES deliveryaddress(daId)
);

CREATE TABLE IF NOT EXISTS orderdetailet(
    odId        INT             NOT NULL PRIMARY KEY AUTO_INCREMENT,
    orderId     INT             NOT NULL,
    foodId      INT             NOT NULL,
    quantity    INT             NOT NULL,
    FOREIGN KEY(orderId) REFERENCES orders(orderId),
    FOREIGN KEY(foodId) REFERENCES food(foodId)
);