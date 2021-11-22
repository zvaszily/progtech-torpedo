create table Users(
	Name varchar(255) not null primary key,
	Started int,
	Won int,
	UserShipsTable varchar(255),
	UserHitsTable varchar(255),
	MachineShipsTable varchar(255),
	MachineHitssTable varchar(255)
);