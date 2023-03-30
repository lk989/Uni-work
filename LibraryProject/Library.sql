
CREATE SCHEMA Library;

CREATE TABLE Branch (
ZipCode			INT(5) NOT NULL,
City			VARCHAR(20) NOT NULL,
Street			VARCHAR(20)NOT NULL,
PhoneNo			INT(10) UNIQUE,
WorkingHours 	INT,

constraint Branch_PK PRIMARY KEY (ZipCode, City, Street)
);


 CREATE TABLE Customer (
 CustEmail 	VARCHAR(40) NOT NULL,
 CusPhoneNo INT (10) NOT NULL,
 CustFName 	VARCHAR(20),
 CustLName 	VARCHAR(20),
 
 constraint Customer_PK PRIMARY KEY (CustEmail, CusPhoneNo)
 );
 
 
 CREATE TABLE MemberShip (
 MemID 			INT(10) NOT NULL,
 MemshipType 	VARCHAR(10),
 CustEmail 		VARCHAR(40),
 CusPhoneNo 	INT(10),
 
 constraint MemberShip_PK PRIMARY KEY (MemID),
 constraint MemberShip_FK FOREIGN KEY (CustEmail, CusPhoneNo) REFERENCES Customer(CustEmail, CusPhoneNo) ON DELETE CASCADE
 );
 
CREATE TABLE Employee(
EmpID		INT(10),
EmpPhoneNo 	INT(10),
EmpFName 	VARCHAR(20),
EmpLName 	VARCHAR (20),
EmpSex 		VARCHAR(6),
EmpSalary 	INT,
ZipCode 	INT(5),
City 		VARCHAR (20),
Street 		VARCHAR (20),

CONSTRAINT Emplyee_PK PRIMARY KEY (EmpID),
CONSTRAINT Employee_FK FOREIGN KEY (ZipCode, City, Street) REFERENCES Branch(ZipCode, City, Street) ON DELETE SET NULL
);

CREATE TABLE Book(
BookID 			INT(5) NOT NULL,
BookPrice 		FLOAT,
BookName 		VARCHAR(40),
BookAuther 		VARCHAR(20),
BookPublisher 	VARCHAR(20),
BookPages 		INT,
BookType 		VARCHAR(20),
ZipCode 		INT(5),
City 			VARCHAR (20),
Street 			VARCHAR (20),

CONSTRAINT Book_PK PRIMARY KEY (BookID),
CONSTRAINT Book_FK FOREIGN KEY (ZipCode, City, Street) REFERENCES Branch(ZipCode, City, Street) ON DELETE SET NULL
);

CREATE TABLE BookBorrowed(
BooKID			INT(5) NOT NULL,
MemID 			INT(10) NOT NULL,
DateBorrowed 	DATE,
ReturnDueDate 	DATE,

CONSTRAINT BookBorrowed_PK PRIMARY KEY (BooKID, MemID),
CONSTRAINT BookBorrowed_FK1 FOREIGN KEY (BooKID) REFERENCES Book(BookID) ON DELETE CASCADE,
CONSTRAINT BookBorrowed_FK2 FOREIGN KEY (MemID) REFERENCES Membership(MemID) ON DELETE CASCADE
);

CREATE TABLE BookLanguages(
BookID 			INT(5) NOT NULL,
BookLanguages 	VARCHAR(15),

CONSTRAINT BookLanguages_PK PRIMARY KEY (BookID, BookLanguages),
CONSTRAINT BookLanguages_FK1 FOREIGN KEY (BookID) REFERENCES Book(BookID) ON DELETE CASCADE
);

CREATE TABLE BookSold(
BookID 		INT(5) NOT NULL,
EmpID 		INT(10) NOT NULL,
CustEmail 	VARCHAR(40) NOT NULL,
CustPhoneNo INT(10) NOT NULL,
OrderType 	VARCHAR(15),
OrederBill 	INT,
CONSTRAINT BookSold_PK  PRIMARY KEY (BookID, EmpID, CustEmail, CustPhoneNo),
CONSTRAINT BookSold_FK1 FOREIGN KEY (BookID) REFERENCES Book(BookID) ON DELETE CASCADE,
CONSTRAINT BookSold_FK2 FOREIGN KEY (EmpID) REFERENCES Employee(EmpID) ON DELETE CASCADE,
CONSTRAINT BookSold_FK3 FOREIGN KEY (CustEmail,CustPhoneNo) REFERENCES Customer(CustEmail,CusPhoneNo) ON DELETE CASCADE
);



-- insertion process. 
INSERT INTO branch 
VALUES  (24356 , 'Mecca'  	, 'Alhajj'    , 0540244317 , 12),
		(43678 , 'Riyadh' 	, 'Alwaha'    , 0537376224 , 12),
        (54372 , 'Jeddah' 	, 'Alrawadha' , 0537674387 , 8 ),
        (47382 , 'Tabuk'  	, 'Almoruoj'  , 0548737895 , 6 ),
        (34598 , 'Khobar' 	, 'Alhamraa'  , 0567839638 , 12),
        (28391 , 'Baha'   	, 'Alrabwah'  , 0537295224 , 8 ),
        (40281 , 'Taif'		, 'Alwesam'	  , 0519274387 , 8 );

INSERT INTO customer
VALUES  ('meeemoo2010@hotmail.com' , 0548577637 , 'Lamiaa' , 'Alharbi'  ),
		('Ranomo@gmail.com'        , 0548776663 , 'Ranim'  , 'Alharbi'  ),
		('talaa.b556@outlook.com‏'  , 0568342759 , 'Tala'   , 'Bukhari'  ),
        ('lele16@hotmail.com'      , 0504525520 , 'Layan'  , 'komo'     ),
        ('ghadamss01@gmail.com'    , 0588739820 , 'GHada'  , 'Alsharif' ),
        ('looola11@gmail.com'      , 0577833934 , 'Lujain' , 'Alamri'   ),
        ('ahmed.kh@gmail.com'      , 0543789245 , 'Ahmed'  , 'Aljabry'  ),
        ('ahmads@gmail.com'        , 0503346589 , 'Ahmed'  , 'alusaimi' ),
        ('faaatooo@hotmail.com'	   , 0503513949 , 'Fatima' , 'Yahya'    ),
		('Ghadoosh@gmail.com'      , 0542397463 , 'Ghayda' , 'Felimban' ),
		('talena.girl@outlook.com‏' , 0559936759 , 'Taleen' , 'Alqurashi'),
        ('sahora1990@hotmail.com'  , 0504445930 , 'Sahar'  , 'Alqasim'  ),
        ('ssk19978@gmail.com'      , 0588339850 , 'Sara'   , 'Qadah'    ),
        ('jejeAhmed@gmail.com'     , 0545892634 , 'Jeyan'  , 'Almasri'  ),
        ('boush.16@gmail.com'      , 0547704745 , 'Ruba'   , 'Assiri'   ),
        ('DanooBG@gmail.com'       , 0544539850 , 'Daniah' , 'Bugnah'   ),
        ('Faresooo89@Hotmail.com'  , 0584492634 , 'Fares'  , 'Alsehli'  ),
        ('memeshoo@gmail.com'      , 0542844745 , 'Maha'   , 'Shweieer' ),
        ('NoonaAs@gmail.com'       , 0500084589 , 'Nouf'   , 'alamin'   );
        
INSERT INTO membership
VALUES  (384811245 , 'Diamond' , 'Ranomo@gmail.com'       , 0548776663),
		(465890328 , 'Bronze'  , 'talaa.b556@outlook.com‏' , 0568342759),
        (756890487 , 'Gold'    , 'ahmed.kh@gmail.com'     , 0543789245),
        (657483920 , 'Bronze'  , 'lele16@hotmail.com'     , 0504525520),
        (422704028 , 'Diamond' , 'jejeAhmed@gmail.com' 	  , 0545892634),
        (113690487 , 'Gold'    , 'ssk19978@gmail.com'     , 0588339850),
        (992183920 , 'Bronze'  , 'faaatooo@hotmail.com'   , 0503513949),
        (476511395 , 'Gold'    , 'looola11@gmail.com' 	  , 0577833934);

INSERT INTO employee
VALUES  (112998745 , 0506383734 , 'Renad' 	 , 'Alsadun'   	, 'Female' , 11000 , 24356 , 'Mecca'  , 'Alhajj'   ),
        (536653678 , 0542187024 , 'Lama'  	 , 'Bugis'      , 'Female' , 13000 , 24356 , 'Mecca'  , 'Alhajj'   ),
        (102865829 , 0548476886 , 'Mawdah'	 , 'Alghuraybi'	, 'Female' , 12000 , 24356 , 'Mecca'  , 'Alhajj'   ),
        (287465936 , 0547783643 , 'Asmaa' 	 , 'Alsuraihi' 	, 'Female' , 15000 , 24356 , 'Mecca'  , 'Alhajj'   ),
        (264911462 , 0542187024 , 'Ghada'  	 , 'Alsharif'   , 'Female' , 13000 , 43678 , 'Riyadh' , 'Alwaha'   ),
		(490302313 , 0506390530 , 'Raneem' 	 , 'Alharbi'   	, 'Female' , 15000 , 43678 , 'Riyadh' , 'Alwaha'   ),
        (119044689 , 0593503553 , 'Turki' 	 , 'Salh'      	, 'Male'   , 11000 , 43678 , 'Riyadh' , 'Alwaha'   ),
        (220395729 , 0529035092 , 'Ahmed'	 , 'Alhazmi'	, 'Male'   , 8000  , 54372 , 'Jeddah' , 'Alrawadha'),
        (288493729 , 0545908322 , 'Raghad'   , 'Albadr' 	, 'Female' , 10000 , 54372 , 'Jeddah' , 'Alrawadha'), 
        (859308721 , 0590395303 , 'Sultan'   , 'Yahya'     	, 'Male'   , 9000  , 54372 , 'Jeddah' , 'Alrawadha'),
		(234742923 , 0509302094 , 'Nouf' 	 , 'Assiri'   	, 'Female' , 11000 , 54372 , 'Jeddah' , 'Alrawadha'),
        (114209202 , 0548350980 , 'Remas'    , 'Felimban'	, 'Female' , 9000  , 47382 , 'Tabuk'  , 'Almoruoj' ),
        (921038742 , 0545987922 , 'Anmar'    , 'Beigar' 	, 'Male'   , 15000 , 47382 , 'Tabuk'  , 'Almoruoj' ),
        (918479873 , 0561984391 , 'Dalal'    , 'Alotaibi'   , 'Female' , 13000 , 34598 , 'Khobar' , 'Alhamraa' ),
		(392709857 , 0501498782 , 'Shahad'   , 'Albarakati' , 'Female' , 9000  , 34598 , 'Khobar' , 'Alhamraa' ),
        (407402380 , 0592538922 , 'Hussam'   , 'Alwafi'     , 'Male'   , 8000  , 34598 , 'Khobar' , 'Alhamraa' ),
        (348023982 , 0545893403 , 'Adnan'    , 'Alshehri'	, 'Male'   , 10000 , 28391 , 'Baha'   , 'Alrabwah' ),
        (184792833 , 0547764094 , 'Assal'    , 'Alhazmi' 	, 'Female' , 15000 , 28391 , 'Baha'   , 'Alrabwah' ),
        (214897233 , 0548320925 , 'Muhannad' , 'Hawsawi'	, 'Male'   , 9000  , 40281 , 'Taif'	  , 'Alwesam'  ),
        (478298892 , 0544509030 , 'Rinad'    , 'Khayat'     , 'Female' , 12000 , 40281 , 'Taif'	  , 'Alwesam'  );
        


INSERT INTO book
VALUES  (87648, 85, 'The fault in our stars'                  , 'John Green'        , 'Penguin'        		 , 89  , 'Romance' , 24356 , 'Mecca'  , 'Alhajj'   ),
		(68452, 45, 'Harry Potter and the Prisoner of Azkaban', 'J.K Rowling'       , 'BloomSbury'           , 461 , 'Fantasy' , 24356 , 'Mecca'  , 'Alhajj'   ),
        (72474, 49, 'Holding Up The Universe'                 , 'Jennifer Niven'    , 'Penguin'              , 423 , 'Drama'   , 24356 , 'Mecca'  , 'Alhajj'   ),
        (97804, 60, 'Little Women'                            , 'Louisa May Alcott' , 'New American Library' , 507 , 'drama'   , 24356 , 'Mecca'  , 'Alhajj'   ),
        (82416, 39, 'All the Bright Places'                   , 'Jennifer Niven'    , 'Penguin'              , 452 , 'Drama'   , 24356 , 'Mecca'  , 'Alhajj'   ),
        (68450, 45, 'Harry Potter and the Philosopher Stone ' , 'J.K Rowling'       , 'BloomSbury'           , 461 , 'Fantasy' , 24356 , 'Mecca'  , 'Alhajj'   ),
        (92341, 85, 'Outlander'                               , 'Diana Gabaldon'    , 'New American Library' , 627 , 'History' , 43678 , 'Riyadh' , 'Alwaha'   ),
        (83451, 55, 'Eleanor Oliphant is Completely Fine'     , 'Jennifer Gail'		, 'Penguin'              , 385 , 'Drama'   , 43678 , 'Riyadh' , 'Alwaha'   ),
        (73913, 55, 'A Very Large Expanse of Sea'             , 'Tahereh Mafi'      , 'BloomSbury'           , 295 , 'Romance' , 43678 , 'Riyadh' , 'Alwaha'   ),
        (89685, 35, 'And Then There Were None'                , 'Agatha Christie'   , 'Jarir'       		 , 341 , 'Crime'   , 54372 , 'Jeddah' , 'Alrawadha'),
		(98274, 59, 'Ringer'								  , 'Lauren Oliver'     , 'BloomSbury'           , 513 , 'Action'  , 54372 , 'Jeddah' , 'Alrawadha'),
        (92874, 49, 'Harry Potter and the Chamber of Secrets' , 'J.K Rowling'       , 'BloomSbury'           , 398 , 'Fantasy' , 54372 , 'Jeddah' , 'Alrawadha'),
        (86848, 45, 'The Lightning Thief'                     , 'Rick Riordan'   	, 'Jarir'				 , 377 , 'Fantasy' , 54372 , 'Jeddah' , 'Alrawadha'),
        (90726, 39, 'The Seven Dials'                   	  , 'Agatha Christie'   , 'Jarir'             	 , 379 , 'Crime'   , 54372 , 'Jeddah' , 'Alrawadha'),
        (87698, 49, 'The Titans Curse'                        , 'Rick Riordan'      , 'Jarir'		 		 , 423 , 'Fantasy' , 47382 , 'Tabuk'  , 'Almoruoj' ),
        (98600, 55, 'Everything Everything'     			  , 'Nicola Yoon'		, 'Penguin'              , 431 , 'Drama'   , 47382 , 'Tabuk'  , 'Almoruoj' ),
        (97609, 65, 'Harry Potter and the Goblet of Fire ' 	  , 'J.K Rowling'       , 'BloomSbury'           , 524 , 'Fantasy' , 47382 , 'Tabuk'  , 'Almoruoj' ),
        (98706, 45, 'Why Did not They Ask Enans?'             , 'Agatha Christie'   , 'Jarir'          		 , 572 , 'Crime'   , 47382 , 'Tabuk'  , 'Almoruoj' ),
        (76396, 35, 'The Sun is Also a Star'                  , 'Nicola Yoon'       , 'Penguin'       		 , 624 , 'Romance' , 34598 , 'Khobar' , 'Alhamraa' ),
		(96960, 45, 'The Battle of the Labyrinth'			  , 'Rick Riordan'      , 'Jarir'          		 , 397 , 'Fantasy' , 34598 , 'Khobar' , 'Alhamraa' ),
        (78047, 49, 'The Mystery of the Blue Train'           , 'Agatha Christie'   , 'Jarir'             	 , 497 , 'Crime'   , 34598 , 'Khobar' , 'Alhamraa' ),
        (69506, 50, 'Cinder'		                          , 'Marissa Meyer'   	, 'Square Fish'			 , 387 , 'Fantasy' , 28391 , 'Baha'   , 'Alrabwah' ),
        (87596, 39, 'The Murder on the Links'                 , 'Agatha Christie'   , 'Jarir'             	 , 322 , 'Crime'   , 28391 , 'Baha'   , 'Alrabwah' ),
        (97439, 45, 'Wonder'     							  , 'R. J. Palacio'		, 'Knopf'             	 , 341 , 'Drama'   , 28391 , 'Baha'   , 'Alrabwah' ),
        (75959, 20, 'A Little Princess' 					  , 'Frances Hodgson'   , 'Puffin Classics'      , 293 , 'Drama'   , 40281 , 'Taif'	  , 'Alwesam'  );
        
INSERT INTO bookborrowed
VALUES  (87648 , 384811245 , '2022-10-25' , '2023-01-25'),
		(68452 , 465890328 , '2022-04-12' , '2022-06-10'),
        (72474 , 756890487 , '2022-02-11' , '2022-02-27'),
        (97804 , 657483920 , '2022-07-09' , '2022-08-05'),
        (92341 , 384811245 , '2022-11-05' , '2023-03-15'),
        (98706 , 992183920 , '2022-10-25' , '2023-01-25'),
		(96960 , 992183920 , '2022-04-12' , '2022-06-10'),
        (97439 , 476511395 , '2022-02-11' , '2022-02-27'),
        (87698 , 476511395 , '2022-07-09' , '2022-08-05'),
        (75959 , 476511395 , '2022-11-05' , '2023-03-15');


INSERT INTO booklanguages
VALUES  (87648 , 'English'), (87648 , 'Arabic'),
        (68452 , 'English'), (68452 , 'Arabic'), (68452 , 'France'),
        (72474 , 'English'),
        (97804 , 'English'), (97804 , 'Arabic'), (97804 , 'France'), (97804 , 'Spanish'),
        (82416 , 'English'), (82416 , 'Arabic'),
        (68450 , 'English'), (68450 , 'Arabic'), (68450 , 'France'),
        (92341 , 'English'),
        (83451 , 'English'),
        (73913 , 'English'),
        (89685 , 'English'), (89685 , 'Arabic'), (89685 , 'France'), (89685 , 'Spanish'),
        (98274 , 'English'),
        (92874 , 'English'), (92874 , 'Arabic'), (92874 , 'France'),
        (86848 , 'English'), (86848 , 'Arabic'), (86848 , 'France'), (86848 , 'Spanish'),
        (90726 , 'English'), (90726 , 'Arabic'), (90726 , 'France'), (90726 , 'Spanish'),
        (87698 , 'English'), (87698 , 'Arabic'), (87698 , 'France'), (87698 , 'Spanish'),
        (98600 , 'English'), (98600 , 'Arabic'),
        (97609 , 'English'), (97609 , 'Arabic'), (97609 , 'France'),
        (98706 , 'English'), (98706 , 'Arabic'), (98706 , 'France'), (98706 , 'Spanish'),
        (76396 , 'English'), (76396 , 'Arabic'),
        (96960 , 'English'), (96960 , 'Arabic'), (96960 , 'France'), (96960 , 'Spanish'),
        (78047 , 'English'), (78047 , 'Arabic'), (78047 , 'France'), (78047 , 'Spanish'),
        (69506 , 'English'),
        (87596 , 'English'), (87596 , 'Arabic'), (87596 , 'France'), (87596 , 'Spanish'),
        (97439 , 'English'),
        (75959 , 'English'), (75959 , 'Arabic');


INSERT INTO booksold 
VALUES  (87648 , 264911462 , 'meeemoo2010@hotmail.com' , 0548577637 , 'Online'    , 90),
		(72474 , 112998745 , 'Ranomo@gmail.com'        , 0548776663 , 'Online'    , 55),
        (68452 , 536653678 , 'ghadamss01@gmail.com'    , 0588739820 , 'Hard Copy' , 50),
        (73913 , 287465936 , 'ahmed.kh@gmail.com'      , 0543789245 , 'Online'    , 65),
        (97804 , 102865829 , 'Ranomo@gmail.com'        , 0548776663 , 'Hard Copy' , 65),
        (89685 , 859308721 , 'Ghadoosh@gmail.com'      , 0542397463 , 'Online'    , 35),
		(90726 , 220395729 , 'NoonaAs@gmail.com'       , 0500084589 , 'Online'    , 39),
        (92874 , 918479873 , 'ssk19978@gmail.com'      , 0588339850 , 'Hard Copy' , 49);


-- -- -- -- SELECT STATEMENTS -- -- -- --

-- 1. All of Agatha Christies books. 
SELECT BookName,BookID
FROM Book
WHERE BookAuther = 'Agatha Christie';

-- 2.All the costumers who bought books published by Penguin. 
SELECT CustFName,CustlName
FROM customer 
WHERE CustEmail IN (SELECT CustEmail
					FROM booksold
                    WHERE bookid IN (SELECT bookid
									 FROM book
									 WHERE bookpublisher ='Penguin'));


-- 3.All data about memberships in a specific order 
SELECT *
FROM MemberShip
ORDER BY  MemshipType, CustEmail, CusPhoneNo DESC;


-- 4. The number of employees at each city/branch and the sum of thier salary
SELECT City, COUNT(EmpID) AS countEMP, SUM(EmpSalary) AS SumSalary
FROM Employee
GROUP BY City
ORDER BY City;

-- 5. All the books from cheapest to most expensive in alphabatical order. 
SELECT BookName AS "NAME", BookPrice AS 'PRICE'
FROM book
ORDER BY BookName, BookPrice;


-- 6.All the books by thier languages 
SELECT b.BookID, BookName, BookLanguages
FROM Book b, BookLanguages l 
WHERE b.BookID = l.BookID 
ORDER BY BookName;

-- 7. The number of books in each language. 
SELECT BookLanguages, COUNT(BookID)
FROM  BookLanguages 
GROUP BY BookLanguages;


 -- 8. The branches that has less than 4 books. 
 select city ,count(bookid) AS 'number of books'
 from book
 group by city
 having count(bookid)<4;

-- 9. The books that are available in 4 languages. 
select bookname AS 'Books that are in 4 languages'
from Book
where bookid in(select bookid
				from BookLanguages
                group by bookid
                having count(BookLanguages)=4);


-- 10. All employees' names and salaries 
select EmpFName,EmpLName,empsalary
from Employee;

-- 11. All the orders and their types
select bookid,ordertype
from booksold
order by ordertype;

-- 12. 	All the employees' names who has salary between 8000 and 1000 
select EmpFName,EmpLName,empsalary
from Employee
where empsalary BETWEEN 8000 AND 10000;


-- -- -- -- UPDATE -- -- -- --

-- increase salary by 5% to all the employees who work more than 8 hours. 
UPDATE Employee
SET EmpSalary  = EmpSalary * 1.05 
WHERE ZipCode IN ( SELECT ZipCode 
				   FROM branch 
				   WHERE WorkingHours > 8 );

select *
from employee;	
 
-- Discount to all of Agatha Christies books!.
UPDATE book
SET bookPrice = bookprice*0.80
WHERE bookauther ='Agatha Christie';

SELECT *
FROM book;	
 
-- -- -- -- DELETE -- -- -- -- 
-- Deleting All of John Greens books. 
DELETE FROM book
WHERE  BookAuther = 'John Green';

SELECT *  
FROM book;