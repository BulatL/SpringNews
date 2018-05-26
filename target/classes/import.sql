INSERT INTO user (name, username, password) VALUES ('Marko' ,'Marko', '123');
INSERT INTO user (name, username, password) VALUES ('Milos' ,'Milos', '123');
INSERT INTO user (name, username, password) VALUES ('Igor' ,'Igor', '123');

INSERT INTO tag (name) VALUES ('tag');
INSERT INTO tag (name) VALUES ('new tag');
INSERT INTO tag (name) VALUES ('bad tag');


INSERT INTO post(title,description,date,likes,dislikes,latitude,longitude,author_id)VALUES ('Avengers infinity war','New and best movie','2018-4-16',20,4,147.55,17.21,1);
INSERT INTO post(title,description,date,likes,dislikes,latitude,longitude,author_id)VALUES ('Deadpool 2','New deadpool movie','2018-2-1',20,4,15.8,14.4,2);

INSERT INTO comment(title,description,date,likes,dislikes,post_id,author_id)VALUES ('My comments','This is the best movie ever','2018-4-3',4,0,1,2);
INSERT INTO comment(title,description,date,likes,dislikes,post_id,author_id)VALUES ('Best','This is awesome','2018-4-3',4,0,2,1);



INSERT INTO tags_post (tag_id, post_id) VALUES (1,1);
INSERT INTO tags_post (tag_id, post_id) VALUES (2,1);
INSERT INTO tags_post (tag_id, post_id) VALUES (3,1);
INSERT INTO tags_post (tag_id, post_id) VALUES (1,2);
INSERT INTO tags_post (tag_id, post_id) VALUES (2,2);
INSERT INTO tags_post (tag_id, post_id) VALUES (3,3);