This is a repository for DocAnalyzer application, The application keeps tracks of following things
1.The users who have not uploaded a particular document
2. If the document has been uploaded by a user then the the application will keep track of document name. Number of Words in the document/Date and Time the Document is uploaded
3. Application has a controller and service which returns inactive users(Users who have not uploaded the documents requested)
4. Controller and service that returns word frequency.
5.  Controller and Service that makes a call to Google Gemini and returns a synonyms for the logest word.

Below are the SQL scripts for setting up a DB.
//User Table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    registration_date DATE NOT NULL
);

//Team Table
CREATE TABLE teams (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

//User-Team Relationship table
CREATE TABLE user_teams (
    user_id BIGINT NOT NULL,
    team_id BIGINT NOT NULL,
    PRIMARY KEY(user_id, team_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (team_id) REFERENCES teams(id)
);

//Document Table
CREATE TABLE documents (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    word_count INT NOT NULL,
    upload_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
