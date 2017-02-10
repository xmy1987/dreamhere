CREATE TABLE `user` (
`id` bigint NOT NULL,
`login_name` varchar(50) NULL COMMENT '登录名',
`login_pwd` varchar(255) NOT NULL COMMENT '登录密码',
`nick_name` varchar(50) NOT NULL COMMENT '昵称',
`email` varchar(50) NULL COMMENT '邮箱',
`mobile_num` varchar(11) NULL COMMENT '手机号',
`source` tinyint NOT NULL COMMENT '来源，是个枚举类型',
`create_time` datetime NOT NULL COMMENT '创建时间',
PRIMARY KEY (`id`) 
);

CREATE TABLE `book` (
`id` bigint NOT NULL,
`owner` bigint NULL,
`name` varchar(100) NULL,
`auther` varchar(50) NULL,
`price` decimal(10,2) NULL,
`cover` varchar(255) NULL COMMENT '图书封面',
`desc` varchar(255) NULL,
`create_time` datetime NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `book_order` (
`id` bigint NOT NULL,
`book_id` bigint NOT NULL COMMENT '图书信息',
`book_owner` bigint NOT NULL COMMENT '图书拥有者',
`book_borrower` bigint NOT NULL COMMENT '借书人',
`free` bit NULL DEFAULT b'0' COMMENT '是否免费借书：0：否，1是',
`order_total_price` decimal(10,2) NULL COMMENT '借出天数总价格',
`deposit` decimal(10,2) NULL COMMENT '押金',
`borrow_start_time` datetime NULL COMMENT '借出时间',
`borrow_return_time
` datetime NULL,
`order_unit_price` decimal(10,2) NOT NULL COMMENT '借出每天单价',
`create_time` datetime NULL COMMENT '订单创建时间',
PRIMARY KEY (`id`) 
);

