-- Create the Glossy_Blends_Artist database
CREATE DATABASE IF NOT EXISTS Glossy_Blends_Artist;

-- Switch to the Glossy_Blends_Artist database
USE Glossy_Blends_Artist;

-- Create the artists table to store artist information
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

-- Create the artist_schedule table to store artist event schedules
CREATE TABLE artist_schedule (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artist_id INT,
    event_date DATE,
    event_name VARCHAR(100),
    event_time DATETIME,
    FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
);

-- Display the contents of the artist_schedule table
SELECT * FROM artist_schedule;

-- Create the artist_posts table to store artist posts
CREATE TABLE artist_posts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artist_id INT,
    post_id VARCHAR(50),
    title VARCHAR(100),
    description VARCHAR(255),
    post_url VARCHAR(255),
    FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
);

-- Create the artist_services table to store artist services
CREATE TABLE artist_services (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artist_id INT,
    category ENUM('HAIR_STYLE', 'SAREE_DRAPPING', 'MAKEUP', 'MEHANDI', 'OTHERS'),
    name VARCHAR(100),
    cost DECIMAL(10, 2),
    sample_image VARCHAR(255),
    FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
);

-- Display the contents of the artist_services table
SELECT * FROM artist_services;

-- Create the artist_reviews table to store artist reviews
CREATE TABLE artist_reviews (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artist_id INT,
    review TEXT,
    FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
);


-- Create the social_media_links table to store social media links for artists
CREATE TABLE social_media_links (
    linkId INTEGER PRIMARY KEY AUTO_INCREMENT,
    artistId INTEGER,
    socialMediaLink TEXT NOT NULL,
    FOREIGN KEY (artistId) REFERENCES artists(artist_id)
);
