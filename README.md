# sec_c_sec_c_madhubala.esakkipandi__corejava_project_2

Table : Artist details

| Column Name        | Data Type           | Description                                      |
|-------------------|--------------------|--------------------------------------------------|
| artist_id          | INT (Primary Key)  | Unique identifier for each artist               |
| username           | VARCHAR(50)        | Username of the artist                          |
| password           | VARCHAR(100)       | Password for the artist's account               |
| email              | VARCHAR(100)       | Email address of the artist                     |
| phone_number       | VARCHAR(20)        | Phone number of the artist                      |
| years_of_experience| INT                | Years of experience of the artist               |
| is_available       | BOOLEAN            | Availability status of the artist               |
| location           | VARCHAR(100)       | Location of the artist                         |
| languages_spoken   | VARCHAR(100)       | Languages spoken by the artist                  |
| genderOfArtist     | ENUM('FEMALE', 'MALE', 'TRANSGENDER') | Gender of the artist |




Table : Unavailability list of artist

| Column Name | Data Type       | Description                               |
|-------------|----------------|-------------------------------------------|
| id          | INT (Primary Key) | Unique identifier for each schedule event |
| artist_id   | INT            | Foreign key referencing artists table    |
| event_date  | DATE           | Date of the event                        |
| event_name  | VARCHAR(100)   | Name of the event                        |
| event_time  | DATETIME       | Date and time of the event               |


Table : Post of the artist


| Column Name  | Data Type       | Description                                   |
|--------------|-----------------|-----------------------------------------------|
| id           | INT (Primary Key) | Unique identifier for each artist post       |
| artist_id    | INT             | Foreign key referencing artists table       |
| post_id      | VARCHAR(50)     | Identifier for the artist's post             |
| title        | VARCHAR(100)    | Title of the artist's post                   |
| description  | VARCHAR(255)    | Description of the artist's post             |
| post_url     | VARCHAR(255)    | URL of the artist's post                     |




Table : Services providing by artist 


| Column Name   | Data Type         | Description                                   |
|---------------|-------------------|-----------------------------------------------|
| id            | INT (Primary Key) | Unique identifier for each service offered   |
| artist_id     | INT               | Foreign key referencing artists table       |
| category      | ENUM              | Category of the service                      |
| name          | VARCHAR(100)      | Name of the service                          |
| cost          | DECIMAL(10, 2)    | Cost of the service                          |
| sample_image  | VARCHAR(255)      | URL of a sample image for the service        |

