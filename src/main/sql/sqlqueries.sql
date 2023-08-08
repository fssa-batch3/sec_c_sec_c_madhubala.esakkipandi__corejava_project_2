
Create database Glossy_Blends_Artist;

USE Glossy_Blends_Artist;

CREATE TABLE artists (
    artist_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    years_of_experience INT NOT NULL,
    is_available BOOLEAN NOT NULL,
    location VARCHAR(100) NOT NULL,
    languages_spoken VARCHAR(100) NOT NULL,
    genderOfArtist ENUM('FEMALE', 'MALE', 'TRANSGENDER'),
    averageRating DECIMAL(5, 2)
);






CREATE TABLE artist_schedule (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artist_id INT,
    event_date DATE,
    event_name VARCHAR(100),
    event_time DATETIME,
    FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
);

USE Glossy_Blends_Artist;

Select * from artist_schedule;


CREATE TABLE artist_posts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artist_id INT,
    post_id VARCHAR(50),
    title VARCHAR(100),
    description VARCHAR(255),
    post_url VARCHAR(255),
    FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
);



CREATE TABLE artist_services (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artist_id INT,
    category ENUM('HAIR_STYLE', 'SAREE_DRAPPING', 'MAKEUP', 'MEHANDI', 'OTHERS'),
    name VARCHAR(100),
    cost DECIMAL(10, 2),
    sample_image VARCHAR(255),
    FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
);


USE Glossy_Blends_Artist;

Select * from artist_services;

CREATE TABLE artist_reviews (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artist_id INT,
    review TEXT,
    FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
);

CREATE TABLE social_media_links (
    linkId INTEGER PRIMARY KEY AUTO_INCREMENT,
    artistId INTEGER,
    socialMediaLink TEXT NOT NULL,
    FOREIGN KEY (artistId) REFERENCES artists (artist_id)
);


USE Glossy_Blends_Artist;

Select * from artists ;

USE Glossy_Blends_Artist;
 Select * from  artist_posts;
 
USE Glossy_Blends_Artist;
DELETE FROM artists WHERE artist_id > 0;
DELETE FROM artists WHERE artist_id > 0;



USE Glossy_Blends_Artist;

SELECT * FROM artist_posts 









