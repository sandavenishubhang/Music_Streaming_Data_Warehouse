

CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender CHAR(1) NOT NULL,
    DateOfBirth DATE NOT NULL,
    level VARCHAR(10) NOT NULL,
    location_name VARCHAR(100) NOT NULL,
    user_agent VARCHAR(10) NOT NULL
);
select * from "users";
INSERT INTO Users (user_id, first_name, last_name, gender, DateOfBirth, level, location_name, user_agent)
VALUES (555, 'John', 'Doe', 'M', '1995-06-15', 'free', 'New York,NY', 'Windows');
Update "users" set location_name='San Diego,CA' where user_id=170;
Update "users" set "level"='free' where "user_id"=116;

CREATE TABLE Artists (
    artist_id CHAR(8) PRIMARY KEY,
    artist_name VARCHAR(255) NOT NULL,
    location_name VARCHAR(100) NOT NULL,
    latitude DECIMAL(10,5) NOT NULL,
    longitude DECIMAL(10,5) NOT NULL,
	Country Varchar(255) NOT NULL
);

select * from "artists" where "artist_id"='ART000';
Update "artists" set "location_name" = 'New York,NY' where "artist_id" = 'ART00061';


select Distinct "location_name" from "artists";
select Distinct "location_name" from "artists" where "location_name" LIKE '%PA';
CREATE TABLE Songs (
    song_id INT PRIMARY KEY,
    song_title VARCHAR(255) NOT NULL,
    artist_id CHAR(8),
    song_duration DECIMAL(10,5) NOT NULL,
    song_release_year INT NOT NULL,
	CONSTRAINT FK_artist_id FOREIGN KEY (artist_id) REFERENCES Artists(artist_id)
);

select * from "songs";

CREATE TABLE Session (
    session_id CHAR(4),
    user_id INT NOT NULL,
    song_id INT NOT NULL,
    session_duration DECIMAL(10,5) NOT NULL,
    timestamp TIME(5) NOT NULL,
    date DATE NOT NULL,
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES Users(user_id),
    CONSTRAINT FK_song_id FOREIGN KEY (song_id) REFERENCES Songs(song_id)
);

select * from "session";

commit;

--Get the location_name from users that are not in artists
SELECT DISTINCT location_name
FROM users
WHERE location_name NOT IN (SELECT location_name FROM artists);

Create table citymap(
city varchar(255),
state_id varchar(255),
state_name varchar(255)
);




