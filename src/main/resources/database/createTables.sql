create table if not exists cities(
	id SERIAL NOT NULL PRIMARY KEY,
	name varchar(100)
	);

create table if not exists streets(
	id SERIAL NOT NULL PRIMARY KEY,
	name varchar(100) NOT NULL,
	city_id INTEGER NOT NULL,
	FOREIGN KEY (city_id) REFERENCES cities(id)
	);
	
create table if not exists houses(
	id SERIAL NOT NULL PRIMARY KEY,
	number varchar(50) NOT NULL,
	street_id INTEGER NOT NULL,
	FOREIGN KEY (street_id) REFERENCES streets(id)
	);
	
create table if not exists apartments(
	id SERIAL NOT NULL PRIMARY KEY,
	area numeric(15, 2) NOT NULL,
	house_id INTEGER NOT NULL,
	FOREIGN KEY (house_id) REFERENCES houses(id)
	);