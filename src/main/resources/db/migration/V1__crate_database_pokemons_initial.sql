CREATE TABLE pokemon (
	id serial4 NOT NULL,
	evolution int4 NULL,
	hp float8 NULL,
	agility int4 NULL,
	defense int4 NULL,
	"level" float8 NULL,
	"name" varchar(255) NULL,
	linkurl varchar(2048) NULL,
	xp float8 NULL,
	CONSTRAINT pokemon_pkey PRIMARY KEY (id)
);

create table attack (
       id int4 not null,
        description varchar(255),
        name_attack varchar(255),
        category varchar(255),
        strength float8,
        id_pokemon int4,
        primary key (id)
);

create table battles (
       id  serial not null,
       data timestamp,
       name_battle varchar(255),
       play1 int4,
       play2 int4,
       primary key (id)
);

CREATE TABLE "types" (
	pokemon_id int4 NOT NULL,
	"types" int4 NULL,
	CONSTRAINT fkgpsx06ehq2itswadmtnx363qq FOREIGN KEY (pokemon_id) REFERENCES pokemon(id)
);

--Insert Attacks
Insert into attack (id, name_attack, category, strength, description) values (1, 'Bubble', 'Normal', 40, 'Um spray de bolhas incontáveis é lançado no Pokémon adversário. Isso também pode diminuir suas estatísticas de velocidade.');
Insert into attack (id, name_attack, category, strength, description) values (2, 'Bubble Beam', 'Especial', 65, 'Um spray de bolhas é lançado com força no alvo. Isso também pode diminuir sua estatística de velocidade.');
Insert into attack (id, name_attack, category, strength, description) values (3, 'Clamp', 'Normal', 35, 'O alvo é preso e apertado pela concha muito espessa e robusta do usuário por quatro a cinco turnos.');
Insert into attack (id, name_attack, category, strength, description) values (4, 'Crabhammer', 'Fisico', 90, 'O alvo é martelado com uma grande pinça. Ataques críticos acertam mais facilmente.');
Insert into attack (id, name_attack, category, strength, description) values (5, 'Hydro Pump', 'Especial', 95, 'O alvo é atingido por um grande volume de água lançado sob grande pressão.');
Insert into attack (id, name_attack, category, strength, description) values (6, 'Surf', 'Especial', 90 , 'O usuário ataca tudo ao seu redor inundando seus arredores com uma onda gigante.');
Insert into attack (id, name_attack, category, strength, description) values (7, 'Water Gun', 'Normal', 40,	'O alvo é atingido com um forte tiro de água.');
Insert into attack (id, name_attack, category, strength, description) values (8, 'Withdraw', 'Fisico', 40,	'O usuário retira seu corpo em sua concha dura, aumentando sua estatística de Defesa.');
Insert into attack (id, name_attack, category, strength, description) values (9, 'Waterfall', 'Fisico',	80,	'O usuário ataca o alvo e pode fazê-lo recuar.');
Insert into attack (id, name_attack, category, strength, description) values (10, 'Rain Dance', 'Normal', 5, 'O usuário invoca uma forte chuva que cai por cinco turnos, aumentando o poder dos movimentos do tipo Água. Reduz o poder dos movimentos do tipo Fogo.');
Insert into attack (id, name_attack, category, strength, description) values (11, 'Whirlpool', 'Especial', 35, 'O usuário aprisiona o alvo em um redemoinho violento por quatro a cinco voltas.');
Insert into attack (id, name_attack, category, strength, description) values (12, 'Dive', 'Físico', 80, 'Mergulhando no primeiro turno, o usuário flutua e ataca no próximo turno.');
Insert into attack (id, name_attack, category, strength, description) values (13, 'Hydro Cannon', 'Especial', 98, 'O alvo é atingido por uma rajada aquosa. O usuário não pode se mover no próximo turno.');
Insert into attack (id, name_attack, category, strength, description) values (14, 'Muddy Water', 'Especial', 90, 'O usuário ataca atirando água lamacenta no Pokémon adversário. Isso também pode diminuir sua precisão.');
Insert into attack (id, name_attack, category, strength, description) values (15, 'Water Pulse', 'Especial', 60, 'O usuário ataca o alvo com um jato de água pulsante. Isso também pode confundir o alvo.');
Insert into attack (id, name_attack, category, strength, description) values (16, 'Water Sport', 'Especial', 10, 'O usuário encharca o campo de batalha com água. Isso enfraquece movimentos do tipo Fogo por cinco turnos.');
Insert into attack (id, name_attack, category, strength, description) values (17, 'Water Spout', 'Especial',	90, 'O usuário jorra água para causar dano ao Pokémon adversário. Quanto menor for o HP do usuário, menor será a potência do movimento.');
Insert into attack (id, name_attack, category, strength, description) values (18, 'Aqua Jet','Físico', 60, 'O usuário ataca o alvo a uma velocidade que o torna quase invisível. Esse movimento sempre vai primeiro.');
Insert into attack (id, name_attack, category, strength, description) values (29, 'Aqua Tail', 'Físico',	90,	'O usuário ataca balançando a cauda como se fosse uma onda violenta em uma tempestade violenta.');
Insert into attack (id, name_attack, category, strength, description) values (20, 'Brine', 'Super Especial', 85, 'Se o HP do alvo estiver pela metade ou menos, este ataque acertará com o dobro da força.');

--pokemons
Insert into pokemon (id, name)values (001,'Bulbasaur');
Insert into pokemon (id, name)values (002,'Ivysaur');
Insert into pokemon (id, name)values (003,'Venusaur');
Insert into pokemon (id, name)values (004,'Charmander');
Insert into pokemon (id, name)values (005,'Charmeleon');
Insert into pokemon (id, name)values (006,'Charizard');
Insert into pokemon (id, name)values (007,'Squirtle');
Insert into pokemon (id, name)values (008,'Wartortle');
Insert into pokemon (id, name)values (009,'Blastoise');
Insert into pokemon (id, name)values (010,'Caterpie');
Insert into pokemon (id, name)values (011,'Metapod');
Insert into pokemon (id, name)values (012,'Butterfree');
Insert into pokemon (id, name)values (013,'Weedle');
Insert into pokemon (id, name)values (014,'Kakuna');
Insert into pokemon (id, name)values (015,'Beedrill');
Insert into pokemon (id, name)values (016,'Pidgey');
Insert into pokemon (id, name)values (017,'Pidgeotto');
Insert into pokemon (id, name)values (018,'Pidgeot');
Insert into pokemon (id, name)values (019,'Rattata');
Insert into pokemon (id, name)values (020,'Raticate');
Insert into pokemon (id, name)values (021,'Spearow');
Insert into pokemon (id, name)values (022,'Fearow');
Insert into pokemon (id, name)values (023,'Ekans');
Insert into pokemon (id, name)values (024,'Arbok');
Insert into pokemon (id, name)values (025,'Pikachu');
Insert into pokemon (id, name)values (026,'Raichu');
Insert into pokemon (id, name)values (027,'Sandshrew');
Insert into pokemon (id, name)values (028,'Sandslash');
Insert into pokemon (id, name)values (029,'Nidoran');
Insert into pokemon (id, name)values (030,'Nidorina');
Insert into pokemon (id, name)values (031,'Nidoqueen');
Insert into pokemon (id, name)values (032,'Nidoran');
Insert into pokemon (id, name)values (033,'Nidorino');
Insert into pokemon (id, name)values (034,'Nidoking');
Insert into pokemon (id, name)values (035,'Clefairy');
Insert into pokemon (id, name)values (036,'Clefable');
Insert into pokemon (id, name)values (037,'Vulpix');
Insert into pokemon (id, name)values (038,'Ninetales');
Insert into pokemon (id, name)values (039,'Jigglypuff');
Insert into pokemon (id, name)values (040,'Wigglytuff');
Insert into pokemon (id, name)values (041,'Zubat');
Insert into pokemon (id, name)values (042,'Golbat');
Insert into pokemon (id, name)values (043,'Oddish');
Insert into pokemon (id, name)values (044,'Gloom');
Insert into pokemon (id, name)values (045,'Vileplume');
Insert into pokemon (id, name)values (046,'Paras');
Insert into pokemon (id, name)values (047,'Parasect');
Insert into pokemon (id, name)values (048,'Venonat');
Insert into pokemon (id, name)values (049,'Venomoth');
Insert into pokemon (id, name)values (050,'Diglett');
Insert into pokemon (id, name)values (051,'Dugtrio');
Insert into pokemon (id, name)values (052,'Meowth');
Insert into pokemon (id, name)values (053,'Persian');
Insert into pokemon (id, name)values (054,'Psyduck');
Insert into pokemon (id, name)values (055,'Golduck');
Insert into pokemon (id, name)values (056,'Mankey');
Insert into pokemon (id, name)values (057,'Primeape');
Insert into pokemon (id, name)values (058,'Growlithe');
Insert into pokemon (id, name)values (059,'Arcanine');
Insert into pokemon (id, name)values (060,'Poliwag');
Insert into pokemon (id, name)values (061,'Poliwhirl');
Insert into pokemon (id, name)values (062,'Poliwrath');
Insert into pokemon (id, name)values (063,'Abra');
Insert into pokemon (id, name)values (064,'Kadabra');
Insert into pokemon (id, name)values (065,'Alakazam');
Insert into pokemon (id, name)values (066,'Machop');
Insert into pokemon (id, name)values (067,'Machoke');
Insert into pokemon (id, name)values (068,'Machamp');
Insert into pokemon (id, name)values (069,'Bellsprout');
Insert into pokemon (id, name)values (070,'Weepinbell');
Insert into pokemon (id, name)values (071,'Victreebel');
Insert into pokemon (id, name)values (072,'Tentacool');
Insert into pokemon (id, name)values (073,'Tentacruel');
Insert into pokemon (id, name)values (074,'Geodude');
Insert into pokemon (id, name)values (075,'Graveler');
Insert into pokemon (id, name)values (076,'Golem');
Insert into pokemon (id, name)values (077,'Ponyta');
Insert into pokemon (id, name)values (078,'Rapidash');
Insert into pokemon (id, name)values (079,'Slowpoke');
Insert into pokemon (id, name)values (080,'Slowbro');
Insert into pokemon (id, name)values (081,'Magnemite');
Insert into pokemon (id, name)values (082,'Magneton');
Insert into pokemon (id, name)values (083,'Farfetchd');
Insert into pokemon (id, name)values (084,'Doduo');
Insert into pokemon (id, name)values (085,'Dodrio');
Insert into pokemon (id, name)values (086,'Seel');
Insert into pokemon (id, name)values (087,'Dewgong');
Insert into pokemon (id, name)values (088,'Grimer');
Insert into pokemon (id, name)values (089,'Muk');
Insert into pokemon (id, name)values (090,'Shellder');
Insert into pokemon (id, name)values (091,'Cloyster');
Insert into pokemon (id, name)values (092,'Gastly');
Insert into pokemon (id, name)values (093,'Haunter');
Insert into pokemon (id, name)values (094,'Gengar');
Insert into pokemon (id, name)values (095,'Onix');
Insert into pokemon (id, name)values (096,'Drowzee');
Insert into pokemon (id, name)values (097,'Hypno');
Insert into pokemon (id, name)values (098,'Krabby');
Insert into pokemon (id, name)values (099,'Kingler');
Insert into pokemon (id, name)values (100,'Voltorb');
Insert into pokemon (id, name)values (101,'Electrode');
Insert into pokemon (id, name)values (102,'Exeggcute');
Insert into pokemon (id, name)values (103,'Exeggutor');
Insert into pokemon (id, name)values (104,'Cubone');
Insert into pokemon (id, name)values (105,'Marowak');
Insert into pokemon (id, name)values (106,'Hitmonlee');
Insert into pokemon (id, name)values (107,'Hitmonchan');
Insert into pokemon (id, name)values (108,'Lickitung');
Insert into pokemon (id, name)values (109,'Koffing');
Insert into pokemon (id, name)values (110,'Weezing');
Insert into pokemon (id, name)values (111,'Rhyhorn');
Insert into pokemon (id, name)values (112,'Rhydon');
Insert into pokemon (id, name)values (113,'Chansey');
Insert into pokemon (id, name)values (114,'Tangela');
Insert into pokemon (id, name)values (115,'Kangaskhan');
Insert into pokemon (id, name)values (116,'Horsea');
Insert into pokemon (id, name)values (117,'Seadra');
Insert into pokemon (id, name)values (118,'Goldeen');
Insert into pokemon (id, name)values (119,'Seaking');
Insert into pokemon (id, name)values (120,'Staryu');
Insert into pokemon (id, name)values (121,'Starmie');
Insert into pokemon (id, name)values (122,'Mr. Mime');
Insert into pokemon (id, name)values (123,'Scyther');
Insert into pokemon (id, name)values (124,'Jynx');
Insert into pokemon (id, name)values (125,'Electabuzz');
Insert into pokemon (id, name)values (126,'Magmar');
Insert into pokemon (id, name)values (127,'Pinsir');
Insert into pokemon (id, name)values (128,'Tauros');
Insert into pokemon (id, name)values (129,'Magikarp');
Insert into pokemon (id, name)values (130,'Gyarados');
Insert into pokemon (id, name)values (131,'Lapras');
Insert into pokemon (id, name)values (132,'Ditto');
Insert into pokemon (id, name)values (133,'Eevee');
Insert into pokemon (id, name)values (134,'Vaporeon');
Insert into pokemon (id, name)values (135,'Jolteon');
Insert into pokemon (id, name)values (136,'Flareon');
Insert into pokemon (id, name)values (137,'Porygon');
Insert into pokemon (id, name)values (138,'Omanyte');
Insert into pokemon (id, name)values (139,'Omastar');
Insert into pokemon (id, name)values (140,'Kabuto');
Insert into pokemon (id, name)values (141,'Kabutops');
Insert into pokemon (id, name)values (142,'Aerodactyl');
Insert into pokemon (id, name)values (143,'Snorlax');
Insert into pokemon (id, name)values (144,'Articuno');
Insert into pokemon (id, name)values (145,'Zapdos');
Insert into pokemon (id, name)values (146,'Moltres');
Insert into pokemon (id, name)values (147,'Dratini');
Insert into pokemon (id, name)values (148,'Dragonair');
Insert into pokemon (id, name)values (149,'Dragonite');
Insert into pokemon (id, name)values (150,'Mewtwo');
Insert into pokemon (id, name)values (151,'Mew');
