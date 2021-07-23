INSERT INTO `user` (id, username, password, role)
              VALUES (1,'miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','ADMIN');
INSERT INTO `user` (id, username, password, role)
              VALUES (2,'tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','KORISNIK');
INSERT INTO `user` (id, username, password, role)
              VALUES (3,'petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','KORISNIK');
              
              
              
              
INSERT INTO drzava (id, naziv, oznaka) VALUES (1, 'drzava1', 'SRB');
INSERT INTO drzava (id, naziv, oznaka) VALUES (2, 'drzava2', 'USA');
INSERT INTO drzava (id, naziv, oznaka) VALUES (3, 'drzava3', 'RUS');



INSERT INTO takmicar (id, ime_prezime, datum_rodjenja, broj_medalja, drzava_id) VALUES (1, 'ime1', '2020-06-21 14:12', 5, 1);
INSERT INTO takmicar (id, ime_prezime, datum_rodjenja, broj_medalja, drzava_id) VALUES (2, 'ime2', '2020-06-22 14:13', 6, 1);
INSERT INTO takmicar (id, ime_prezime, datum_rodjenja, broj_medalja, drzava_id) VALUES (3, 'ime3', '2020-06-23 14:14', 7, 2);
INSERT INTO takmicar (id, ime_prezime, datum_rodjenja, broj_medalja, drzava_id) VALUES (4, 'ime4', '2020-06-24 14:15', 8, 3);           



INSERT INTO prijava (id, datum_prijave, disciplina, takmicar_id) VALUES (1, '2024-06-21', 'disciplina1', 1);
INSERT INTO prijava (id, datum_prijave, disciplina, takmicar_id) VALUES (2, '2024-06-22', 'disciplina2', 2);
INSERT INTO prijava (id, datum_prijave, disciplina, takmicar_id) VALUES (3, '2024-06-23', 'disciplina3', 3);