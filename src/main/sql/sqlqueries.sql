
Create database Glossy_Blends_Artist;

USE Glossy_Blends_Artist;
SELECT * FROM madhubala_esakkipandi_corejava_project.artists;

USE madhubala_esakkipandi_corejava_project;
CREATE TABLE artists (
    artist_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,  
    phone_number BIGINT NOT NULL,
    years_of_experience INT NOT NULL,
    is_available BOOLEAN NOT NULL,
    location VARCHAR(100) NOT NULL,
    languages_spoken VARCHAR(100) NOT NULL,
    genderOfArtist ENUM('FEMALE', 'MALE', 'TRANSGENDER')
);



CREATE TABLE artist_posts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artist_id INT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    post_url VARCHAR(255) NOT NULL,
    FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
);



CREATE TABLE artist_services (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artist_id INT,
    category ENUM('HAIR_STYLE', 'SAREE_DRAPPING', 'MAKEUP', 'MEHANDI', 'OTHERS'),
    name VARCHAR(100) NOT NULL,
    cost DECIMAL(10, 2) NOT NULL,
    sample_image VARCHAR(255) NOT NULL,
    FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
);



CREATE TABLE artist_schedule (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artist_id INT,
    event_date DATE NOT NULL,
    event_name VARCHAR(100) NOT NULL,
    event_time DATETIME NOT NULL,
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









