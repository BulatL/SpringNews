DROP SCHEMA IF EXISTS osa_projekat;
CREATE SCHEMA osa_projekat DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE osa_projekat;

CREATE TABLE user (
	userId BIGINT AUTO_INCREMENT, 
	name VARCHAR(30) NOT NULL,
    userName VARCHAR(30) NOT NULL, 
	password VARCHAR(35) NOT NULL, 
    photo BLOB, 
    PRIMARY KEY(userId)
);

INSERT INTO user (name, userName, password)
VALUES ('Marko' ,'Marko', '123');
INSERT INTO user (name, userName, password)
VALUES ('Milos' ,'Milos', '123');
INSERT INTO user (name, userName, password)
VALUES ('Igor' ,'Igor', '123');


CREATE TABLE tag (
	tagId BIGINT AUTO_INCREMENT, 
	name VARCHAR(30) NOT NULL,
    PRIMARY KEY(tagId)
);

INSERT INTO tag (name) VALUES ('Super tag');
INSERT INTO tag (name) VALUES ('Grand');
INSERT INTO tag (name) VALUES ('Skandal');


CREATE TABLE post (
	postId BIGINT AUTO_INCREMENT, 
	title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    photo BLOB,
    authorId BIGINT NOT NULL,
	date dateTIME NOT NULL, 
    likes integer NOT NULL,
    dislikes integer NOT NULL,
    longitude FLOAT NOT NULL,
    latitude FLOAT NOT NULL,
    PRIMARY KEY(postId),
    FOREIGN KEY(authorId) REFERENCES User(userId) ON DELETE RESTRICT
);

INSERT INTO post (title, description, authorId, date, likes, dislikes, longitude, latitude)
VALUES ('Ovo je prvi post' ,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer felis tortor, egestas quis nisi ultricies, dignissim laoreet ipsum. Pellentesque malesuada elit posuere consequat ornare. Suspendisse eget nibh ligula. Nullam urna felis, porta eget neque eu, gravida efficitur lectus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque quis iaculis urna. Nam euismod suscipit magna, eget pulvinar lacus suscipit id. In gravida vitae nisi sit amet ultrices. Vestibulum pretium mi sed lacus ornare, a laoreet turpis maximus. Duis ac lorem tempus, ornare ex eget, blandit nisi. Cras sed dapibus neque, eu feugiat neque. In auctor rhoncus consequat.',1, '2018.01.18', 11,7,112.21,543.31);
INSERT INTO post (title, description, authorId, date, likes, dislikes, longitude, latitude)
VALUES ('Ovo je drugi post' ,'Donec ac lacinia ante. Fusce sed lectus tincuserIdnt velit tristique sodales vel ut dolor. Phasellus eget ex nec augue maximus blandit. Phasellus sed erat scelerisque, mattis est id, hendrerit justo. Maecenas eget imperdiet augue, vitae rhoncus diam. Nam auctor quis sem in varius. Duis tortor tortor, vestibulum dictum ex sed, tincuserIdnt gravida mi. Aenean eget eleifend justo. Nunc nec arcu a mi sollicitudin interdum ut vitae metus. Pellentesque ut mollis eros.',2, '2018.04.08', 54,3,112.21,543.31);
INSERT INTO post (title, description, authorId, date, likes, dislikes, longitude, latitude)
VALUES ('Ovo je treci post' ,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer felis tortor, egestas quis nisi ultricies, dignissim laoreet ipsum. Pellentesque malesuada elit posuere consequat ornare. Suspendisse eget nibh ligula. Nullam urna felis, porta eget neque eu, gravida efficitur lectus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque quis iaculis urna. Nam euismod suscipit magna, eget pulvinar lacus suscipit id. In gravida vitae nisi sit amet ultrices. Vestibulum pretium mi sed lacus ornare, a laoreet turpis maximus. Duis ac lorem tempus, ornare ex eget, blandit nisi. Cras sed dapibus neque, eu feugiat neque. In auctor rhoncus consequat.' ,3, '2018.03.29', 4,62,112.21,543.31);


CREATE TABLE comment (
	commentId BIGINT AUTO_INCREMENT, 
	title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL, 
	date dateTIME NOT NULL, 
    likes integer NOT NULL,
    dislikes integer NOT NULL,
    authorId BIGINT NOT NULL,
    postId BIGINT NOT NULL,
    PRIMARY KEY(commentId),
    FOREIGN KEY(authorId) REFERENCES User(userId) ON DELETE RESTRICT,
    FOREIGN KEY(postId) REFERENCES post(postId) ON DELETE RESTRICT
);

INSERT INTO comment (title, description, date, likes, dislikes, authorId, postId)
VALUES ( 'Neki title za komentar', 'Super komentar' , '2018.03.14',4,62,2,1);
INSERT INTO comment (title, description, date, likes, dislikes, authorId, postId)
VALUES ( 'Neki title za komentar', 'Super komentar4' , '2018.03.21',83,16,3,1);
INSERT INTO comment (title, description, date, likes, dislikes, authorId, postId)
VALUES ( 'Neki title za komentar', 'Super komentar2' , '2018.03.17',16,0,1,1);
INSERT INTO comment (title, description, date, likes, dislikes, authorId, postId)
VALUES ( 'Neki title za komentar', 'Super komentar' , '2018.03.14',4,12,1,2);
INSERT INTO comment (title, description, date, likes, dislikes, authorId, postId)
VALUES ( 'Neki title za komentar', 'Super komentar4' , '2018.03.21',83,62,3,2);
INSERT INTO comment (title, description, date, likes, dislikes, authorId, postId)
VALUES ( 'Neki title za komentar', 'Super komentar2' , '2018.03.17',64,0,2,2);
INSERT INTO comment (title, description, date, likes, dislikes, authorId, postId)
VALUES ( 'Neki title za komentar', 'Super komentar' , '2018.03.14',4,32,1,3);
INSERT INTO comment (title, description, date, likes, dislikes, authorId, postId)
VALUES ( 'Neki title za komentar', 'Super komentar4' , '2018.03.21',83,17,3,3);
INSERT INTO comment (title, description, date, likes, dislikes, authorId, postId)
VALUES ( 'Neki title za komentar', 'Super komentar2' , '2018.03.17',16,0,2,3);

CREATE TABLE tags_post (
	tagId BIGINT NOT NULL,
    postId BIGINT NOT NULL, 
    PRIMARY KEY(tagId, postId)
);

INSERT INTO tags_post (tagId, postId) VALUES (1,1);
INSERT INTO tags_post (tagId, postId) VALUES (2,1);
INSERT INTO tags_post (tagId, postId) VALUES (3,1);
INSERT INTO tags_post (tagId, postId) VALUES (1,2);
INSERT INTO tags_post (tagId, postId) VALUES (2,2);
INSERT INTO tags_post (tagId, postId) VALUES (3,3);