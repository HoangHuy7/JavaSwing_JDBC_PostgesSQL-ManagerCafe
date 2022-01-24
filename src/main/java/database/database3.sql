
CREATE SEQUENCE users_id_seq;
CREATE TABLE users(
	id bigint PRIMARY KEY DEFAULT nextval('users_id_seq'),
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    fullname VARCHAR(255) NOT NULL,
    roleid bigint NOT NULL,
	status int NOT NULL,
	createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) null,
    modifiedby varchar(255) null
);
alter sequence users_id_seq resTART with 100000;

CREATE SEQUENCE roles_id_seq;
CREATE Table roles(
	id bigint PRIMARY KEY DEFAULT nextval('roles_id_seq'),
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
	createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) null,
    modifiedby varchar(255) null
);
alter sequence roles_id_seq resTART with 1;

alter table users add constraint fk_user_role foreign key (roleid) references roles(id);

CREATE SEQUENCE product_id_seq;
CREATE Table product(
	id bigint NOT NULL PRIMARY KEY DEFAULT nextval('product_id_seq'),
    name VARCHAR(255) NOT NULL,
	price bigint not null,
	size int not null,
	type varchar(100) not null,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) null,
    modifiedby varchar(255) null
);
alter sequence product_id_seq resTART with 1000000;

CREATE TABLE typeproduct(
	name VARCHAR(100) PRIMARY KEY ,
	createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) null,
    modifiedby varchar(255) null
);

alter table product add constraint fk_product_typeproduct foreign key (type) references typeproduct(name);

CREATE SEQUENCE bill_id_seq;
CREATE Table bill(
	id bigint NOT NULL PRIMARY KEY DEFAULT nextval('bill_id_seq'),
	userid bigint not null,
total bigint Not null,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) null,
    modifiedby varchar(255) null
);
alter TABLE bill add constraint fk_bill_user FOREIGN key(userid) REFERENCES users(id);
alter sequence bill_id_seq resTART with 1;
CREATE Table detailbill(
	idbill bigint NOT NULL ,
    productid bigint NOT NULL,
	quantity int Not Null,
	price bigint Not null,
	
	discount bigint null,
    createddate TIMESTAMP NULL,
    modifieddate TIMESTAMP NULL,
    createdby VARCHAR(255) null,
    modifiedby varchar(255) null
);

alter TABLE detailbill add constraint fk_detailbill_bill FOREIGN key(idbill) REFERENCES bill(id);

ALTER TABLE detailbill ADD constraint fk_detailbill_product FOREIGN key(productid) REFERENCES product(id);

insert into roles(name,code) values('Admin','admin'); 
insert into roles(name,code) values('Manager','manager'); 
insert into roles(name,code) values('Staff','staff'); 
insert into users(username,"password",fullname,roleid,status,createddate,createdby) values('Admin','Admin','Admin',1,1,'2022-01-20 01:11:13.704','100001');


<-- get revenue 1-->
select  bill.id as idbill, bill.userid, users.fullname ,bill.total,   detailbill.productid, 
product.name as nameproduct,detailbill.quantity, detailbill.price as totalproduct, product.price,product.size,product.type,bill.createddate
from bill inner join detailbill ON detailbill.idbill = bill.id 
INNER join product ON product.id = detailbill.productid
INNER join users ON users.id = bill.userid
where bill.id = ?

