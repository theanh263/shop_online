use shoponline;

CREATE TABLE role(
  id bigint NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(255) NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
);

CREATE TABLE user (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  username VARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL,
  fullname VARCHAR(150) NULL,
  status int NOT NULL,
  roleid bigint NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
);

ALTER TABLE user ADD CONSTRAINT fk_user_role FOREIGN KEY (roleid) REFERENCES role(id);

CREATE TABLE product (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  title VARCHAR(255) NULL,
  thumbnail VARCHAR(255) NULL,
  shortdescription TEXT NULL,
  price bigint NULL,
  originalprice bigint NULL,
  stock bigint NULL,
  categoryid bigint NOT NULL,
  categorycode text,
  producer text,
  description text,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL,
  constraint fk_product_category FOREIGN KEY (categoryid) references category(id)
);

CREATE TABLE category (
  id bigint NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(255) NOT NULL,
  code VARCHAR(255) NOT NULL,
  createddate TIMESTAMP NULL,
  modifieddate TIMESTAMP NULL,
  createdby VARCHAR(255) NULL,
  modifiedby VARCHAR(255) NULL
);

create table orderdetail(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    productId bigint not null,
    quantity bigint not null,
    userId bigint not null,
	userName text,
    productName text,
	createddate TIMESTAMP NULL,
	modifieddate TIMESTAMP NULL,
	createdby VARCHAR(255) NULL,
	modifiedby VARCHAR(255) NULL,
    constraint fk_product_order FOREIGN KEY (productId) references product(id),
    constraint fk_user_order FOREIGN KEY (userId) references user(id)
);

create table productimage(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    productId bigint not null,
    imagePath text not null,
    caption text,
    fileSize Long,
    constraint fk_product_productimage FOREIGN KEY (productId) references product(id)
)