INSERT INTO user (name, surname, username, password) VALUES ("Jonas", "Jonaitis", "Jonis", "$2a$12$hjXN7cqULMyBtxJ7LNpS4.1nWZcdb7PfdrMSkWtnYVfnrTL8NYbmy");
INSERT INTO user (name, surname, username, password) VALUES ("Petras", "Petraitis", "Petris", "$2a$12$3FU3rclh4.xrCk08N873CedTD5SnxlpCZoR3LvzkH1JsZLfSCpGjq");
INSERT INTO user (name, surname, username, password) VALUES ("Monika", "Monkytė", "Monke", "$2a$12$3FU3rclh4.xrCk08N873CedTD5SnxlpCZoR3LvzkH1JsZLfSCpGjq");
INSERT INTO user (name, surname, username, password) VALUES ("Edita", "Editaitė", "Edė", "$2a$12$3FU3rclh4.xrCk08N873CedTD5SnxlpCZoR3LvzkH1JsZLfSCpGjq");
INSERT INTO user (name, surname, username, password) VALUES ("Gintras", "Gintaraitis", "Gintis", "$2a$12$3FU3rclh4.xrCk08N873CedTD5SnxlpCZoR3LvzkH1JsZLfSCpGjq");
INSERT INTO user (name, surname, username, password) VALUES ("Berta", "Bertaitė", "Berte", "$2a$12$3FU3rclh4.xrCk08N873CedTD5SnxlpCZoR3LvzkH1JsZLfSCpGjq");
INSERT INTO user (name, surname, username, password) VALUES ("Ieva", "Ievutė", "Eve", "$2a$12$3FU3rclh4.xrCk08N873CedTD5SnxlpCZoR3LvzkH1JsZLfSCpGjq");
INSERT INTO user (name, surname, username, password) VALUES ("Benas", "Benaitis", "Benis", "$2a$12$3FU3rclh4.xrCk08N873CedTD5SnxlpCZoR3LvzkH1JsZLfSCpGjq");

INSERT INTO post (header, text, date_time, user_id) VALUES ("Joninės", "Jõninės, Kùpolės, Rãsos, vasaros saulėgrįžos šventė. Švenčiama birželio 24 dieną, krikščionių šalyse sutampa su Šv. Jono Krikštytojo diena. Baltų kraštuose ši šventė (Latvijoje vadinama Lyguo) žinoma nuo 14 amžiaus (1372 minima Varmės vyskupo Henriko II rašte, 1573 – Wolfenbüttelio postilėje, 1595 – C. Hennenbergerio, 1690 – M. Pretorijaus, 1702 – J. A. von Brando veikaluose), iki krikščionybės įvedimo buvo vadinamos Kupolėmis, arba Rasomis, ir buvo švenčiamos visą trečiąją birželio dekadą. Po krikščionybės įvedimo Kupolės buvo sutapatintos su Jono Krikštytojo diena, o šventines apeigas imta atlikinėti jos išvakarėse (birželio 23 dieną); K. G. Milkaus (1800) ir F. Kuršaičio (1883) žodynuose šventė vadinama Joninėmis, o kupolės tapatinamos su jonažolėmis (Hypericum perforatum).", CURRENT_TIMESTAMP, 1);
INSERT INTO post (header, text, date_time, user_id) VALUES ("Bitės", "Bitės – plėviasparnių (Hymenoptera) būrio vabzdžiai, priklausantys nesistematinei sekcijai Anthophila. Bitės yra vapsvoms ir skruzdėlėms giminiški gyvūnai, priklausantys tam pačiam smaugtapilvių (Apocrita) pobūriui.", CURRENT_TIMESTAMP, 2);
INSERT INTO post (header, text, date_time, user_id) VALUES ("Skruzdėlės", "Skruzdėlės (Formicidae) – plėviasparniai vabzdžiai, priklausantys smaugtapilvių Apocrita pobūriui. Pasižymi ryškiu polimorfizmu ir bendruomeniniu gyvenimo būdu. Tai vieni iš labiausiai paplitusių vabzdžių. Mokslas apie skruzdėles vadinamas mirmekologija.", CURRENT_TIMESTAMP, 2);
INSERT INTO post (header, text, date_time, user_id) VALUES ("Gintaras", "Gintaras – fosiliniai sakai. Tai organinės kilmės mineralas, susidaręs sustingus spygliuočių augalų sakams.", CURRENT_TIMESTAMP, 4);
INSERT INTO post (header, text, date_time, user_id) VALUES ("Anglis", "Anglis (Carbonium) – cheminis periodinės elementų lentelės elementas, žymimas C, eilės numeris 6.", CURRENT_TIMESTAMP, 4);
INSERT INTO post (header, text, date_time, user_id) VALUES ("Australija", "Australijos Sandrauga – šešta pagal dydį (geografiškai) pasaulio šalis, užimanti Australijos žemyną ir aplinkines salas, iš kurių didžiausia Tasmanija.", CURRENT_TIMESTAMP, 6);

INSERT INTO comment (text, date_time, post_id, user_id) VALUES ("Gera šventė", CURRENT_TIMESTAMP, 1, 1);
INSERT INTO comment (text, date_time, post_id, user_id) VALUES ("Ir vardas geras", CURRENT_TIMESTAMP, 1, 1);
INSERT INTO comment (text, date_time, post_id, user_id) VALUES ("Cool", CURRENT_TIMESTAMP, 2, 1);
INSERT INTO comment (text, date_time, post_id, user_id) VALUES ("Nice", CURRENT_TIMESTAMP, 2, 8);
INSERT INTO comment (text, date_time, post_id, user_id) VALUES ("įdomu", CURRENT_TIMESTAMP, 3, 7);
INSERT INTO comment (text, date_time, post_id, user_id) VALUES (":)", CURRENT_TIMESTAMP, 4, 5);
INSERT INTO comment (text, date_time, post_id, user_id) VALUES ("viskas?", CURRENT_TIMESTAMP, 5, 8);
INSERT INTO comment (text, date_time, post_id, user_id) VALUES ("AC/DC!!!", CURRENT_TIMESTAMP, 6, 3);
INSERT INTO comment (text, date_time, post_id, user_id) VALUES ("Gal kas žinote, kaip išnaikinti?", CURRENT_TIMESTAMP, 3, 5);
INSERT INTO comment (text, date_time, post_id, user_id) VALUES ("Parduodu 1 kg gabalą", CURRENT_TIMESTAMP, 4, 3);
INSERT INTO comment (text, date_time, post_id, user_id) VALUES ("Oooooooo", CURRENT_TIMESTAMP, 5, 7);
INSERT INTO comment (text, date_time, post_id, user_id) VALUES ("reikia rašyti CCCCCCC :)", CURRENT_TIMESTAMP, 5, 8);

INSERT INTO roles(role) VALUES ("USER");
INSERT INTO roles(role) VALUES ("ADMIN");

INSERT INTO user_roles(user_id, roles_id) VALUES (1,2);
INSERT INTO user_roles(user_id, roles_id) VALUES (2,1);
INSERT INTO user_roles(user_id, roles_id) VALUES (3,1);
INSERT INTO user_roles(user_id, roles_id) VALUES (4,1);
INSERT INTO user_roles(user_id, roles_id) VALUES (5,1);
INSERT INTO user_roles(user_id, roles_id) VALUES (6,1);
INSERT INTO user_roles(user_id, roles_id) VALUES (7,1);
INSERT INTO user_roles(user_id, roles_id) VALUES (8,1);


--SELECT * FROM comment;