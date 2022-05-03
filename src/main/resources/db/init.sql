CREATE TABLE IF NOT EXISTS dbblog.post(
id INT AUTO_INCREMENT PRIMARY KEY,
header VARCHAR(255) NOT NULL,
text VARCHAR(1000) NOT NULL,
date_time DATETIME,
user_id INT
);

CREATE TABLE IF NOT EXISTS dbblog.user(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS dbblog.comment(
id INT AUTO_INCREMENT PRIMARY KEY,
text VARCHAR(1000) NOT NULL,
date_time DATETIME,
post_id INT,
user_id INT
);