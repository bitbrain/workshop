CREATE TABLE IF NOT EXISTS `user` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `email` VARCHAR(100) NOT NULL,
    `first_name` VARCHAR(50),
    `last_name` VARCHAR(50),
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `modified_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS `workshop` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `description` TEXT,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `modified_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS `participant` (
    `workshop_id` INT,
    `user_id` INT,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `modified_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`workshop_id`, `user_id`),
    FOREIGN KEY (`workshop_id`) REFERENCES `workshop`(`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
);

CREATE TABLE IF NOT EXISTS `organizer` (
    `workshop_id` INT,
    `user_id` INT,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `modified_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`workshop_id`, `user_id`),
    FOREIGN KEY (`workshop_id`) REFERENCES `workshop`(`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
);

# Inserting some data
INSERT INTO `user` VALUES(1, "hans@gmx.de", "Hansi", "Hinterseer", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `user` VALUES(2, "chris@gmx.de", "Christian", "Wolfstadter", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `user` VALUES(3, "anna@gmx.de", "Anna", "Kleingruber", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `workshop` VALUES(1, "Craftbeer Fundamentals", "Dive with us into the world of Craft Beers!", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `participant` VALUES(1, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `participant` VALUES(1, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `organizer` VALUES(1, 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());