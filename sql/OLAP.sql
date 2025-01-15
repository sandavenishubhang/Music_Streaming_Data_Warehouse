-- Create LocationDim table
CREATE TABLE CountryDim (
    CountryKey SERIAL PRIMARY KEY,
    Country VARCHAR(255) NOT NULL
);

ALTER TABLE public.CountryDim
    ALTER COLUMN CountryKey SET DEFAULT nextval('public."countrydim_countrykey_sequence"');
	
SELECT * FROM public.CountryDim;

CREATE TABLE StateDim (
    StateKey INT PRIMARY KEY,
	StateName VARCHAR(255),
    StateCode VARCHAR(255) UNIQUE,
    CountryKey INT NOT NULL,
    CONSTRAINT fk_country FOREIGN KEY (CountryKey) REFERENCES CountryDim(CountryKey)
);

ALTER TABLE public.StateDim
    ALTER COLUMN StateKey SET DEFAULT nextval('public."statedim_statekey_sequence"');

ALTER TABLE public.StateDim
ADD CONSTRAINT unique_state_name UNIQUE (StateName);

select * from public.StateDim;

ALTER TABLE "statedim" ALTER COLUMN "statecode" ADD NOT NULL;

truncate table "statedim";

drop table "statedim";
commit;

CREATE TABLE CityDim (
    CityKey INT PRIMARY KEY,
	CityName VARCHAR(255) UNIQUE,
    StateKey INT NOT NULL,
    CONSTRAINT fk_state FOREIGN KEY (StateKey) REFERENCES StateDim(StateKey)
);

ALTER TABLE public.StateDim
    ALTER COLUMN StateKey SET DEFAULT nextval('public."citydim_citykey_sequence"');

select * from public.CityDim;

truncate table "citydim";

CREATE TABLE ArtistsDim(
	ArtistKey INT PRIMARY KEY,
	ArtistID CHAR(8),
	ArtistName VARCHAR(255) NOT NULL,
	CityKey INT NOT NULL,
	CONSTRAINT fk_city FOREIGN KEY (CITYKEY) REFERENCES public.citydim(citykey)
);


ALTER TABLE public.StateDim
    ALTER COLUMN StateKey SET DEFAULT nextval('public."artistdim_artistkey_sequence"');
ALTER TABLE ArtistsDim ADD COLUMN StartDate DATE, ADD COLUMN EndDate DATE, ADD COLUMN Status_Flag VARCHAR(10);
SELECT * FROM public.ArtistsDim where "artistid" = 'ART00061';
DELETE FROM "artistsdim" where "artistid"='ART00061' AND "status_flag" = 'ACTIVE';
ALTER TABLE "artistsdim" DROP COLUMN "startdate";
ALTER TABLE "artistsdim" DROP COLUMN "enddate";
ALTER TABLE "artistsdim" DROP COLUMN "status_flag";
-- truncate table "artistsdim";

CREATE TABLE SongsDim(
	SongKey INT PRIMARY KEY,
	SongID INT,
	SongTitle VARCHAR(255) NOT NULL,
	SongDuration DECIMAL(10,5) NOT NULL,
	ReleaseYear INT NOT NULL,
	ArtistKey INT NOT NULL,
	CONSTRAINT fk_song FOREIGN KEY (ARTISTKEY) REFERENCES public.artistsdim(artistkey)
);

ALTER TABLE public.StateDim
    ALTER COLUMN StateKey SET DEFAULT nextval('public."songsdim_songkey_sequence"');

SELECT * FROM public.songsdim;

truncate table "songsdim";



CREATE TABLE UsersDim(
	UserKey INT PRIMARY KEY,
	UserID INT NOT NULL,
	First_Name VARCHAR(255),
	LAST_NAME VARCHAR(255),
	Gender VARCHAR(1),
	SubscriptionType VARCHAR(10),
	CityKey INT NOT NULL,
	CONSTRAINT fk_UserCity FOREIGN KEY (CITYKEY) REFERENCES public.citydim(citykey)
);
ALTER TABLE UsersDim
ALTER COLUMN SubscriptionType TYPE VARCHAR(10);
ALTER TABLE UsersDim
DROP COLUMN DateKey;

ALTER TABLE public.UsersDim
    ALTER COLUMN UserKey SET DEFAULT nextval('public."usersdim_userkey_sequence"');
INSERT INTO "usersdim" (UserID,First_Name,Last_Name,Gender,SubscriptionType,CityKey,StartDate,EndDate,status)
VALUES (549,'Harper','Simth','M','paid',910100,'2024-11-01',NULL,'ACTIVE');
ALTER TABLE UsersDim ADD COLUMN StartDate DATE, ADD COLUMN EndDate DATE, Status_Flag VARCHAR(10);
ALTER TABLE UsersDim ADD COLUMN Status VARCHAR(10);

SELECT * FROM public.UsersDim where "userid"=625;
UPDATE "usersdim" SET "status" = 'ACTIVE' WHERE "userid" = 625 and "subscriptiontype"='paid';

-- TRUNCATE TABLE "usersdim";
DELETE FROM "usersdim" WHERE "userid"=509 and "subscriptiontype"='paid';

CREATE TABLE YearDim(
	CalenderYear INT PRIMARY KEY,
	Year INT
);

ALTER TABLE YearDim
    RENAME COLUMN Year TO CalendarYear;


SELECT * FROM public.yeardim;
ALTER TABLE public.YearDim
    ALTER COLUMN YearKey SET DEFAULT nextval('public."yeardim_yearkey_sequence"');

CREATE TABLE MonthDim(
	MonthKey INT PRIMARY KEY,
	MonthName VARCHAR(255),
	YearKey INT NOT NULL,
	CONSTRAINT fk_month FOREIGN KEY (YEARKEY) REFERENCES public.yeardim(yearkey)
);
ALTER TABLE public.MonthDim
    ALTER COLUMN MonthKey SET DEFAULT nextval('public."monthdim_monthkey_sequence"');
SELECT * FROM public.monthdim;

CREATE TABLE WeekDim(
	WeekKey INT PRIMARY KEY,
	WeekNumber INT,
	MonthKey INT NOT NULL,
	CONSTRAINT fk_week FOREIGN KEY (MONTHKEY) REFERENCES public.monthdim(monthkey)
);
ALTER TABLE public.WeekDim
    ALTER COLUMN WeekKey SET DEFAULT nextval('public."weekdim_weekkey_sequence"');

select * from "weekdim";


CREATE TABLE DateDim(
	DateKey INT PRIMARY KEY,
	Date Date,
	WeekKey INT NOT NULL,
	CONSTRAINT fk_datedim FOREIGN KEY (WEEKKEY) REFERENCES public.weekdim(weekkey)
);

ALTER TABLE public.DateDim
    ALTER COLUMN fk_datekey SET DEFAULT nextval('public."datedim_datekey_sequence"');

SELECT * FROM public.datedim;




-- CREATE TABLE DayDim(
-- 	DayKey INT PRIMARY KEY,
-- 	DayName VARCHAR(255),
-- 	WeekKey INT NOT NULL,
-- 	CONSTRAINT fk_daydim FOREIGN KEY (WEEKKEY) REFERENCES public.weekdim(weekkey)
-- );

-- ALTER TABLE public.DayDim
--     ALTER COLUMN DayKey SET DEFAULT nextval('public."daydim_daykey_sequence"');

-- SELECT * FROM public.daydim;


CREATE Table TimeDim (
	Timekey INT PRIMARY KEY,
	Timestamp TIME
);

ALTER TABLE public.timedim
    ALTER COLUMN timeKey SET DEFAULT nextval('public."timedim_timekey_sequence"');

SELECT * FROM public.timedim;

CREATE TABLE SessionsDim (
	sessionkey INT PRIMARY KEY,
    session_id VARCHAR(255),
    userkey INT NOT NULL,
    songkey INT NOT NULL,
    session_duration DECIMAL(10,5) NOT NULL,
    timekey INT NOT NULL,
    datekey INT NOT NULL,
    CONSTRAINT FK_user_id FOREIGN KEY (userkey) REFERENCES UsersDim(userkey),
    CONSTRAINT FK_song_id FOREIGN KEY (songkey) REFERENCES SongsDim(songkey),
	CONSTRAINT FK_time FOREIGN KEY (timekey) REFERENCES TimeDim(timekey),
	CONSTRAINT FK_date FOREIGN KEY (datekey) REFERENCES DateDim(datekey)
);

ALTER TABLE public.SessionsDim
    ALTER COLUMN sessionkey SET DEFAULT nextval('public."sessionsdim_sessionkey_sequence"');
SELECT * FROM public.sessionsdim;

CREATE TABLE LISTENING_ACTIVITY(
	Listening_Activity_Key INT PRIMARY KEY,
	User_Key INT NOT NULL,
	Session_Key INT NOT NULL,
	Artist_Key INT NOT NULL,
	Song_Key INT NOT NULL,
	City_Key INT NOT NULL,
	Time_Key INT NOT NULL,
	Date_Key INT NOT NULL,
	Total_Sesssion_Duration DECIMAL(10,5) NOT NULL,
	Subscription_Type VARCHAR(10) NOT NULL,
	CONSTRAINT FK_userkey FOREIGN KEY (User_Key) REFERENCES UsersDim(userkey),
	CONSTRAINT FK_sessionkey FOREIGN KEY (Session_Key) REFERENCES SessionsDim(sessionkey),
	CONSTRAINT FK_artist FOREIGN KEY (Artist_Key) REFERENCES ArtistsDim(artistkey),
	CONSTRAINT FK_song FOREIGN KEY (Song_Key) REFERENCES SongsDim(songkey),
	CONSTRAINT FK_city FOREIGN KEY (City_Key) REFERENCES CityDim(citykey),
	CONSTRAINT FK_time FOREIGN KEY (Time_Key) REFERENCES TimeDim(timekey),
	CONSTRAINT FK_datek FOREIGN KEY (Date_Key) REFERENCES DateDim(datekey)
);

ALTER TABLE LISTENING_ACTIVITY
  ALTER COLUMN Subscription_Type TYPE INT USING Subscription_Type::INT;
-- Truncate table public.LISTENING_ACTIVITY;

ALTER TABLE public.LISTENING_ACTIVITY
    ALTER COLUMN Listening_Activity_Key SET DEFAULT nextval('public."ladim_lakey_sequence"');



SELECT * FROM public.LISTENING_ACTIVITY;

TRUNCATE TABLE public.LISTENING_ACTIVITY;
TRUNCATE TABLE public.BridgeActivity;



CREATE TABLE BridgeActivity (
    sessionkey INT NOT NULL,
    Listening_Activity_Key INT NOT NULL,
    FOREIGN KEY (sessionkey) REFERENCES SessionsDim(sessionkey),
    FOREIGN KEY (Listening_Activity_Key) REFERENCES LISTENING_ACTIVITY(LISTENING_ACTIVITY_KEY)
);
SELECT * FROM public.BridgeActivity;

-- DROP TABLE BridgeActivity;





