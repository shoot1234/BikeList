-- バイクのデータ
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (1, 'GB350', 800, 1, '空冷', 550000, 'エンジンのトコトコ音がいい。', '01', 1, now(), null);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (2, 'Z900RS', 800, 4, '水冷', 1260000, 'エンジン音が低く紳士的。', '02', 1, now(), null);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (3, 'W800 CAFE', 790, 2, '水冷', 110000, 'エンジンの音は思ったよりかっこいい。スポーツタイプで姿勢はしんどい。', '02', 1, now(), null);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (4, 'YZF-R1', 100, 4, '水冷', 150000, '見た目がかっこいい。いかにもスーパースポーツ。', '03', 1, now(), null);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (5, 'Rebel250', 690, 1, '水冷', 599500, '見た目はクルーザー音はめっちゃ軽い。単気筒のトコトコもない。', '01', 1, now(), null);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (6, 'Rebel500', 690, 2, '水冷', 799700, 'まだよくわからない。', '01', 1, now(), null);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (7, 'SR400 Final Edition', 790, 1, '空冷', 605000, 'エンジンのドコドコ感がいい。', '03', 1, now(), null);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (8, 'Z900RS CAFE', 820, 4, '水冷', 1290000, '見た目カッコイイけど後部シート小さい。', '02', 1, now(), null);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt) VALUES (9, 'V7 III Racer 10th ANNIVERSARY', 770, 2, '空冷', 1375000, '珍しい見た目。', '05', 1, now(), null);


-- バイクメーカーのデータ
INSERT INTO m_brand (brand_id, brand_name) VALUES ('01', 'Honda');
INSERT INTO m_brand (brand_id, brand_name) VALUES ('02', 'Kawasaki');
INSERT INTO m_brand (brand_id, brand_name) VALUES ('03', 'Yamaha');
INSERT INTO m_brand (brand_id, brand_name) VALUES ('04', 'Suzuki');
INSERT INTO m_brand (brand_id, brand_name) VALUES ('05', 'moto guzzi');

-- ユーザーのデータ
INSERT INTO m_user (username, password) VALUES ('test', '$2a$10$61CJ8pfDM6t.TAEcao/louay.ptdrNqE/ettqUo2vgi2nz23Pv.Iy');
INSERT INTO m_user (username, password) VALUES ('admin', '$2a$10$61CJ8pfDM6t.TAEcao/louay.ptdrNqE/ettqUo2vgi2nz23Pv.Iy');
