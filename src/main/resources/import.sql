-- user@yandex.ru : password
-- admin@gmail.com: admin

create table UserConnection (
  userId varchar(64) not null,
  providerId varchar(64) not null,
  providerUserId varchar(255),
  rank int not null,
  displayName varchar(255),
  profileUrl varchar(512),
  imageUrl varchar(512),
  accessToken varchar(512) not null,
  secret varchar(512),
  refreshToken varchar(512),
  expireTime bigint,
  primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);

create table UserProfile (
  userId varchar(64) not null,
  email varchar(255),
  firstName varchar(64),
  lastName varchar(64),
  name  varchar(64),
  username varchar(64),
  imageUrl varchar(512),
  primary key (userId));
create unique index UserProfilePK on UserProfile(userId);


INSERT INTO USERS (ID, EMAIL, NAME, PASSWORD) VALUES
  (0, 'user@yandex.ru', 'User', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni'),
  (1, 'admin@gmail.com', 'Admin', '$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju');

INSERT INTO USER_ROLES (ROLE, USER_ID) VALUES ('ROLE_USER', 0), ('ROLE_ADMIN', 1);

INSERT INTO restaurants (ID,NAME) VALUES (0,'McDonalds'), (1,'Шаляпин'), (2,'Васаби');

INSERT INTO MENU (ID, MENU_DATE, RESTAURANT_ID) VALUES
  (0, TODAY(), 0), (1, '2015-11-19', 0),
  (2, TODAY(), 1), (3, '2015-11-19', 1),
  (4, TODAY(), 2), (5, '2015-11-19', 2);

INSERT INTO LUNCH (NAME, MENU_ID) VALUES
  ('Гамбургер', 0), ('Фри', 1),
  ('Вчерашний Гамбургер', 2), ('Вчерашнее Фри', 3),
  ('Суп', 2), ('Второе', 2),
  ('Вчерашний Суп', 3), ('Вчерашнее Второе', 3),
  ('Суши', 4), ('Лосось', 4),
  ('Вчерашний Суши', 5), ('Вчерашний Лосось', 5);
