CREATE TABLE `person`  (
                                     `id` varchar(20) NOT NULL,
                                     `name` varchar(10) NOT NULL DEFAULT '',
                                     `age` int NOT NULL DEFAULT 0,
                                     `address` varchar(50) NOT NULL DEFAULT '',
                                     `university` varchar(50) NOT NULL DEFAULT '',
                                     `graduate_time` datetime NULL,
                                     `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `graduate_time`,
                                     `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP AFTER `create_time`,
                                     `operator_id` varchar(20) NOT NULL AFTER `update_time`,
                                     PRIMARY KEY (`id`)
);

CREATE TABLE `account` (
                           `id` varchar(20) NOT NULL,
                           `account_number` varchar(20) NOT NULL,
                           `password` varchar(50) NOT NULL,
                           `name` varchar(20) NOT NULL DEFAULT '',
                           `phone_number` varchar(15) NOT NULL DEFAULT '',
                           `email` varchar(50) NOT NULL DEFAULT '',
                           `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           `operator_id` varchar(20) NOT NULL,
                           `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '账户状态： 1-正常，2-注销；',
                           PRIMARY KEY (`id`)
)