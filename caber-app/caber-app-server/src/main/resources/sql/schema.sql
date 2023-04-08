CREATE TABLE `caber`.`person`  (
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

CREATE TABLE `caber`.`account`  (
                                     `id` varchar(20) NOT NULL,
                                     `account` varchar(20) NOT NULL,
                                     `password` varchar(50) NOT NULL,
                                     `name` varchar(20) NOT NULL DEFAULT '',
                                     `phone_number` varchar(15) NOT NULL DEFAULT '' AFTER `name`,
                                     `email` varchar(50) NOT NULL DEFAULT '' AFTER `phone_number`,
                                     `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
                                     `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
                                     `operator_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                                     PRIMARY KEY (`id`)
);