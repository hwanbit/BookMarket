-- USE BOOKMARKETDB;

CREATE TABLE IF NOT EXISTS book(
                                   b_bookId VARCHAR(10) NOT NULL,
    b_name VARCHAR(30),
    b_unitPrice  INTEGER,
    b_author VARCHAR(50),
    b_description TEXT,
    b_publisher VARCHAR(20),
    b_category VARCHAR(20),
    b_unitsInStock LONG,
    b_releaseDate VARCHAR(20),
    b_condition VARCHAR(20),
    b_fileName  VARCHAR(20),
    PRIMARY KEY (b_bookId)
    )DEFAULT CHARSET=utf8;

-- DELETE FROM book;
INSERT INTO book VALUES('isbn0001', 'SpringBoot', 35000,'Miyoung Song', 'All about Spring Boot!','gilbut','Framework', 1000,'2024/12/31','new','isbn0001.png');
INSERT INTO book VALUES('isbn0002', 'Java', 26000, 'Sehong Park', 'Everyone needs Java~','Hanbit','Language',500, '2021/10/29','Used', 'isbn0002.png');
INSERT INTO book VALUES('isbn0003', 'Android Studio', 34000, 'Jaenam Woo', 'Android Studio = Android Programming', 'Hanbit', 'Framework', 700, '2024/01/19', 'new','isbn0003.png');