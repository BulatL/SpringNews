INSERT INTO user (name, username, password, role) VALUES ('Marko' ,'marko', '123', 'ADMIN');
INSERT INTO user (name, username, password, role) VALUES ('Milos' ,'milos', '123', 'ADMIN');
INSERT INTO user (name, username, password, role) VALUES ('Nikola' ,'nikola', '123', 'PUBLISHER');
INSERT INTO user (name, username, password, role) VALUES ('Nemanja' ,'nemanja', '123', 'PUBLISHER');
INSERT INTO user (name, username, password, role) VALUES ('Jovan' ,'jovan', '123', 'COMMENTATOR');
INSERT INTO user (name, username, password, role) VALUES ('Igor' ,'igor', '123', 'COMMENTATOR');

INSERT INTO tag (name) VALUES ('tag');
INSERT INTO tag (name) VALUES ('newtag');
INSERT INTO tag (name) VALUES ('badtag');


INSERT INTO post(title,description,date,likes,dislikes,latitude,longitude,author_id)VALUES ('Avengers infinity war','Avengers: Infinity War is a 2018 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012s','2018-1-16',20,4,45.2613,19.8336,1);
INSERT INTO post(title,description,date,likes,dislikes,latitude,longitude,author_id)VALUES ('Deadpool 2','Deadpool 2 is a 2018 American superhero film based on the Marvel Comics character Deadpool, distributed by 20th Century Fox. It is the eleventh installment in the X-Men film series, and a sequel to the 2016 film Deadpool. ','2018-2-1',20,47,45.2613,19.8336,2);
INSERT INTO post(title,description,date,likes,dislikes,latitude,longitude,author_id)VALUES ('Deadpool','Deadpool is a 2016 American superhero film based on the Marvel Comics character of the same name, distributed by 20th Century Fox. It is the eighth installment of the X-Men film series','2018-2-9',35,47,45.2613,19.8336,3);

INSERT INTO comment(title,description,date,likes,dislikes,post_id,author_id)VALUES ('My comments','This is the best movie ever','2018-4-3',4,0,1,2);
INSERT INTO comment(title,description,date,likes,dislikes,post_id,author_id)VALUES ('Best','This is awesome','2018-4-3',4,0,2,1);
INSERT INTO comment(title,description,date,likes,dislikes,post_id,author_id)VALUES ('Best','This is awesome movie','2018-4-3',4,0,1,1);
INSERT INTO comment(title,description,date,likes,dislikes,post_id,author_id)VALUES ('comment','I like this','2018-4-3',4,0,2,3);
INSERT INTO comment(title,description,date,likes,dislikes,post_id,author_id)VALUES ('comment','I dont like this','2018-4-3',4,0,1,3);


INSERT INTO tags_post (tag_id, post_id) VALUES (1,1);
INSERT INTO tags_post (tag_id, post_id) VALUES (2,1);
INSERT INTO tags_post (tag_id, post_id) VALUES (3,1);
INSERT INTO tags_post (tag_id, post_id) VALUES (1,2);
INSERT INTO tags_post (tag_id, post_id) VALUES (2,2);
INSERT INTO tags_post (tag_id, post_id) VALUES (3,3);