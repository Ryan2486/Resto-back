DELETE FROM CONTENIR;
DELETE FROM COMMANDE;
DELETE FROM MENU;
DELETE FROM RESERVER;
DELETE FROM _table;

INSERT INTO MENU (idplat, nomplat, pu) VALUES 
('CURR-001', 'Poulet au curry', 20000),
('JIAO-002', 'Jiaozi', 15000),
('CLQ-003', 'Canard laqué', 50000),
('NOUD-004', 'Nouilles sautées', 15000),
('LHEA-005', 'Lion s head', 20000),
('SOUP-006', 'Soupe aigre-piquante', 18000),
('TOFU-007', 'Tofu mapo', 16000),
('POIS-008', 'Poisson entier à la vapeur', 55000),
('CREV-009', 'Crevettes sauce aux haricots noirs', 30000),
('CARA-010', 'Poulet au caramel', 35000);

-- Insertion des données dans la table _TABLE (TableModel)
INSERT INTO "_table" (idtable, "designation", "nbr_place") VALUES 
('T001', 'Table de l Oliveraie', 4),
('T002', 'Table de la Vigne', 8),
('T003', 'Table du Jardin', 6),
('T004', 'Table des Saveurs', 6),
('T005', 'Table de l Océan', 6),
('T006', 'Table de l Horizon', 4),
('T007', 'Table des Saisons', 4),
('T008', 'Table du Marché', 4),
('T009', 'Table de la Montagne', 8),
('T010', 'Table des Épices', 4),
('T011', 'Table de la Cascade', 6),
('T012', 'Table de l Aurore', 4),
('T013', 'Table du Crépuscule', 6),
('T014', 'Table de la Brise', 4),
('T015', 'Table de la Clairière', 8),
('T016', 'Table de la Lueur', 4);

-- Insertion des données dans la table COMMANDE (CommandeModel)
INSERT INTO COMMANDE (idcom, nomcli, typecom, datecom, idtable) VALUES 
('COM001', 'John Doe', 'Sur place', '2024-05-15', 'T001'),
('COM002', 'Jane Smith', 'Sur place', '2024-04-16', 'T002'),
('COM003', 'Robert Johnson', 'Emporter', '2024-03-14', NULL),
('COM004', 'Michael Williams', 'Emporter', '2024-02-13', NULL),
('COM005', 'Mary Brown', 'Sur place', '2024-01-12', 'T005'),
('COM006', 'James Jones', 'Emporter', '2023-12-11', NULL),
('COM007', 'Patricia Garcia', 'Emporter', '2023-11-10', NULL),
('COM008', 'Jennifer Martinez', 'Sur place', '2023-10-09', 'T008'),
('COM009', 'William Rodriguez', 'Emporter', '2023-09-08', NULL),
('COM010', 'Linda Davis', 'Emporter', '2023-08-07', NULL),
('COM011', 'Elizabeth Taylor', 'Sur place', '2023-07-06', 'T011'),
('COM012', 'David Wilson', 'Emporter', '2023-06-05', NULL),
('COM013', 'Barbara Moore', 'Emporter', '2023-05-04', NULL),
('COM014', 'Richard Anderson', 'Sur place', '2023-04-03', 'T014'),
('COM015', 'Susan Thomas', 'Emporter', '2023-03-02', NULL),
('COM016', 'Joseph Jackson', 'Emporter', '2023-02-01', NULL);

-- Insertion des données dans la table RESERVER (ReserverModel)
INSERT INTO RESERVER (idreserv, date_de_reserv, date_reserve, nomcli, idtable) VALUES 
('RES001', '2023-12-01', '2024-06-17', 'John Doe', 'T001'),
('RES002', '2023-11-02', '2024-06-18', 'Jane Smith', 'T002'),
('RES003', '2023-10-03', '2024-06-19', 'Robert Johnson', 'T003'),
('RES004', '2023-09-04', '2024-06-20', 'Michael Williams', 'T004'),
('RES005', '2023-08-05', '2024-06-21', 'Mary Brown', 'T005'),
('RES006', '2023-07-06', '2024-06-22', 'James Jones', 'T006'),
('RES007', '2023-06-07', '2024-06-23', 'Patricia Garcia', 'T007'),
('RES008', '2023-05-08', '2024-06-24', 'Jennifer Martinez', 'T008'),
('RES009', '2023-04-09', '2024-06-25', 'William Rodriguez', 'T009'),
('RES010', '2023-03-10', '2024-06-26', 'Linda Davis', 'T010');

-- Insertion des données dans la table CONTENIR (ContenueModel)
INSERT INTO CONTENIR (idcontenir, qte, idplat, idcom) VALUES 
('1', '2', 'CURR-001', 'COM001'),
('2', '3', 'JIAO-002', 'COM002'),
('3', '1', 'CLQ-003', 'COM003'),
('4', '2', 'NOUD-004', 'COM004'),
('5', '2', 'LHEA-005', 'COM005'),
('6', '1', 'SOUP-006', 'COM006'),
('7', '2', 'TOFU-007', 'COM007'),
('8', '1', 'POIS-008', 'COM008'),
('9', '1', 'CREV-009', 'COM009'),
('10', '2', 'CARA-010', 'COM010'),
('11', '3', 'CURR-001', 'COM011'),
('12', '1', 'JIAO-002', 'COM012'),
('13', '2', 'CLQ-003', 'COM013'),
('14', '2', 'NOUD-004', 'COM014'),
('15', '1', 'LHEA-005', 'COM015'),
('16', '1', 'SOUP-006', 'COM016'),
('17', '2', 'TOFU-007', 'COM001'),
('18', '1', 'POIS-008', 'COM002'),
('19', '1', 'CREV-009', 'COM003'),
('20', '3', 'CARA-010', 'COM004');
