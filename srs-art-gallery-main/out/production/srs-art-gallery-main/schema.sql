CREATE TABLE IF NOT EXISTS Artists (
    ArtistID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Biography TEXT,
    Portfolio TEXT,
    ContactInfo VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Artworks (
    ArtworkID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(255),
    ArtistID INT,
    Medium VARCHAR(100),
    Dimensions VARCHAR(50),
    CreationDate DATE,
    Price DECIMAL(10, 2),
    ImagePath VARCHAR(255),
    FOREIGN KEY (ArtistID) REFERENCES Artists(ArtistID)
);

CREATE TABLE IF NOT EXISTS Exhibitions (
    ExhibitionID INT PRIMARY KEY,
    Title VARCHAR(255),
    StartDate DATE,
    EndDate DATE
);

CREATE TABLE IF NOT EXISTS Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(32) UNIQUE,
    Password VARCHAR(255),
    Role VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Transactions (
    TransactionID INT PRIMARY KEY,
    UserID INT,
    ArtworkID INT,
    TransactionDate DATE,
    TransactionAmount DECIMAL(10, 2),
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (ArtworkID) REFERENCES Artworks(ArtworkID)
);
