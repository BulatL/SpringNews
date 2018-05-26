INSERT INTO user (name, userName, password)
VALUES ('Marko' ,'Marko', '123');
INSERT INTO user (name, userName, password)
VALUES ('Milos' ,'Milos', '123');
INSERT INTO user (name, userName, password)
VALUES ('Igor' ,'Igor', '123');

INSERT INTO tag (name) VALUES ('Super tag');
INSERT INTO tag (name) VALUES ('Grand');
INSERT INTO tag (name) VALUES ('Skandal');

INSERT INTO post (title, description, author_id, date, likes, dislikes, longitude, latitude)
VALUES ('Ovo je prvi post' ,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In auctor rhoncus consequat.',1, '2018-1-8', 11,7,112.21,543.31);
INSERT INTO post (title, description, author_id, date, likes, dislikes, longitude, latitude)
VALUES ('Ovo je drugi post' ,'Donec ac lacinia ante. Fusce sed lectus tincuserIdnt velit tristique sodales vel ut dolor. Phasellus eget ex nec augue maximus blandit. 
Phasellus sed erat scelerisque, mattis est id, hendrerit justo.',2, '2018-4-8', 54,3,112.21,543.31);
INSERT INTO post (title, description, author_id, date, likes, dislikes, longitude, latitude)
VALUES ('Ovo je treci post' ,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer felis tortor, egestas quis nisi ultricies, dignissim laoreet ipsum. 
Pellentesque malesuada elit posuere consequat ornare. Suspendisse eget nibh ligula.' ,3, '2018-3-29', 4,62,112.21,543.31);


INSERT INTO comment (title, description, date, likes, dislikes, author_id, post_id)
VALUES ( 'Neki title za komentar', 'Super komentar' , '201-3-14',4,62,2,1);
INSERT INTO comment (title, description, date, likes, dislikes, author_id, post_id)
VALUES ( 'Neki title za komentar', 'Super komentar4' , '2018-3-21',83,16,3,1);
INSERT INTO comment (title, description, date, likes, dislikes, author_id, post_id)
VALUES ( 'Neki title za komentar', 'Super komentar2' , '2018-3-17',16,0,1,1);
INSERT INTO comment (title, description, date, likes, dislikes, author_id, post_id)
VALUES ( 'Neki title za komentar', 'Super komentar' , '2018-3-14',4,12,1,2);
INSERT INTO comment (title, description, date, likes, dislikes, author_id, post_id)
VALUES ( 'Neki title za komentar', 'Super komentar4' , '2018-3-21',83,62,3,2);
INSERT INTO comment (title, description, date, likes, dislikes, author_id, post_id)
VALUES ( 'Neki title za komentar', 'Super komentar2' , '2018-3-17',64,0,2,2);
INSERT INTO comment (title, description, date, likes, dislikes, author_id, post_id)
VALUES ( 'Neki title za komentar', 'Super komentar' , '2018-3-14',4,32,1,3);
INSERT INTO comment (title, description, date, likes, dislikes, author_id, post_id)
VALUES ( 'Neki title za komentar', 'Super komentar4' , '2018-3-21',83,17,3,3);
INSERT INTO comment (title, description, date, likes, dislikes, author_id, post_id)
VALUES ( 'Neki title za komentar', 'Super komentar2' , '2018-3-17',16,0,2,3);


INSERT INTO tags_post (tag_id, post_id) VALUES (1,1);
INSERT INTO tags_post (tag_id, post_id) VALUES (2,1);
INSERT INTO tags_post (tag_id, post_id) VALUES (3,1);
INSERT INTO tags_post (tag_id, post_id) VALUES (1,2);
INSERT INTO tags_post (tag_id, post_id) VALUES (2,2);
INSERT INTO tags_post (tag_id, post_id) VALUES (3,3);