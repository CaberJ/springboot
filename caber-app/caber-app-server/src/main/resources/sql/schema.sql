CREATE TABLE `caber`.`person`  (
                                     `id` varchar(10) NOT NULL,
                                     `name` varchar(10) NOT NULL DEFAULT '',
                                     `age` int NOT NULL DEFAULT 0,
                                     `address` varchar(50) NOT NULL DEFAULT '',
                                     `university` varchar(50) NOT NULL DEFAULT '',
                                     `graduate_time` datetime NULL,
                                     `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `graduate_time`,
                                     `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP AFTER `create_time`,
                                     `operator_id` varchar(10) NOT NULL AFTER `update_time`,
                                     PRIMARY KEY (`id`)
);