INSERT INTO RESTAURANTS (ID,NAME) VALUES (0,'McDonalds'), (1,'Шаляпин'), (2,'Васаби1'),(3,'Васаби2'),(4,'Васаби3'),(5,'Васаби4'),(6,'Васаби5');

INSERT INTO MENU (ID, MENU_DATE, RESTAURANT_ID) VALUES(1, current_date, 1), (2, current_date, 2),(3, current_date, 3), (4, current_date, 4),(5, current_date, 5), (6, current_date, 6);

INSERT INTO LUNCH(id,name,menu_id) VALUES (1,'гумбургер1',1),(2,'гумбургер1',2),(3,'гумбургер1',3),(4,'гумбургер1',4);

INSERT INTO users(id, name) VALUES (1,'Sergey');

INSERT INTO votes(id, vote_date, menu_id, user_id) VALUES (0,current_date,1,1);


