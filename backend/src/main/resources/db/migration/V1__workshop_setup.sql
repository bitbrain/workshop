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
    `workshop_id` INT NOT NULL,
    `user_id` INT NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `modified_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`workshop_id`, `user_id`),
    FOREIGN KEY (`workshop_id`) REFERENCES `workshop`(`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
);

CREATE TABLE IF NOT EXISTS `organizer` (
    `workshop_id` INT NOT NULL,
    `user_id` INT NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `modified_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`workshop_id`, `user_id`),
    FOREIGN KEY (`workshop_id`) REFERENCES `workshop`(`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
);

CREATE TABLE IF NOT EXISTS `requirement` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `description` TEXT,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `modified_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS `workshop_requirement` (
    `workshop_id` INT NOT NULL,
    `requirement_id` INT NOT NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `modified_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`workshop_id`, `requirement_id`),
    FOREIGN KEY (`workshop_id`) REFERENCES `workshop`(`id`),
    FOREIGN KEY (`requirement_id`) REFERENCES `requirement`(`id`)
);

# adding new users
INSERT INTO `user` VALUES(1, "hans@gmx.de", "Hansi", "Hinterseer", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `user` VALUES(2, "chris@gmx.de", "Christian", "Wolfstadter", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `user` VALUES(3, "anna@gmx.de", "Anna", "Kleingruber", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

# let them participate in a workshop
INSERT INTO `workshop` VALUES(1, "Craftbeer Fundamentals", "Dive with us into the world of Craft Beers!", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `participant` VALUES(1, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `participant` VALUES(1, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
INSERT INTO `organizer` VALUES(1, 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

# let us also add requirements

INSERT INTO `requirement` VALUES(1, "Bring your own glass", "Due to health and safety, participants are being asked to bring their own drinking glasses.", CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
