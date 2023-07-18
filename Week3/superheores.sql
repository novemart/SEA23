create table heroes ( id int AUTO_INCREMENT PRIMARY KEY,    name varchar(50) not null,    alias varchar(50) not null,    superPower varchar(70) not null,    teamID int not null,
foreign key(teamID) references team(team_id));

create table team( team_id  int auto_incremenet primary key, name varchar(15) not null), objective varchar(120) not null);

insert into heroes  (name, alias, superPower, teamID)values    ('Bruce Wayne', 'Batman', 'Martial Arts', 1),    ('Clark Kent', 'Superman', 'Flight', 1),    ('Jay Garrick', 'The Flash', 'Super-speed', 2),    ('Alan Scott', 'Green Lantern', 'Ring Creation', 2),    ('Helena Bertenelli', 'The Huntress', 'Crossbow Archery', 3),    ('Dr. Harleen Quinzel', 'Harley Quinn', 'Hammer-fighting', 3),    ('Floyd Lawton', 'Deadshot', 'Marksmaship', 4),    ('Cecil Adams', 'Count Vertigo', 'Drug-dealing', 4),    ('Damian Wayne', 'Robin', 'Swordsmanship', 5),    ('Dick Grayson', 'Nightwing', 'Acrobatics', 5);
insert into team(name, objective) values ('JLA', 'Fight crime'), ('JSA', 'Save the world'),('Birds of Prey', 'Help people'), ('Doom Patrol', 'Investigation'), ('Avengers','Mightiest heroes');
