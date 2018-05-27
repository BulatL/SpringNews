INSERT INTO user (name, username, password) VALUES ('Marko' ,'marko', '123');
INSERT INTO user (name, username, password) VALUES ('Milos' ,'milos', '123');
INSERT INTO user (name, username, password) VALUES ('Igor' ,'igor', '123');

INSERT INTO tag (name) VALUES ('tag');
INSERT INTO tag (name) VALUES ('new tag');
INSERT INTO tag (name) VALUES ('bad tag');


INSERT INTO post(title,description,date,likes,dislikes,latitude,longitude,author_id)VALUES ('Avengers infinity war','Avengers: Infinity War is a 2018 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012s','2018-4-16',20,4,147.55,17.21,1);
INSERT INTO post(title,description,date,likes,dislikes,latitude,longitude,author_id)VALUES ('Deadpool 2','Deadpool 2 is a 2018 American superhero film based on the Marvel Comics character Deadpool, distributed by 20th Century Fox. It is the eleventh installment in the X-Men film series, and a sequel to the 2016 film Deadpool. ','2018-2-1',20,4,15.8,14.4,2);

INSERT INTO comment(title,description,date,likes,dislikes,post_id,author_id)VALUES ('My comments','This is the best movie ever','2018-4-3',4,0,1,2);
INSERT INTO comment(title,description,date,likes,dislikes,post_id,author_id)VALUES ('Best','This is awesome','2018-4-3',4,0,2,1);
INSERT INTO comment(title,description,date,likes,dislikes,post_id,author_id)VALUES ('My comments','This is the best movie ever','2018-4-3',4,0,2,2);
INSERT INTO comment(title,description,date,likes,dislikes,post_id,author_id)VALUES ('Best','This is awesome','2018-4-3',4,0,1,1);



INSERT INTO tags_post (tag_id, post_id) VALUES (1,1);
INSERT INTO tags_post (tag_id, post_id) VALUES (2,1);
INSERT INTO tags_post (tag_id, post_id) VALUES (3,1);
INSERT INTO tags_post (tag_id, post_id) VALUES (1,2);
INSERT INTO tags_post (tag_id, post_id) VALUES (2,2);
INSERT INTO tags_post (tag_id, post_id) VALUES (3,3);