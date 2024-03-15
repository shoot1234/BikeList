-- バイクのデータ
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt)
VALUES (1, 'GB350', 800, 1, '空冷', 550000, 'エンジンのトコトコ音がいい。', '01', 1, now(), null);
INSERT INTO m_motorcycle (moto_no, moto_name, seat_height, cylinder, cooling, price, comment, brand_id, version, ins_dt, upd_dt)
VALUES (2, 'Z900RS', 800, 4, '水冷', 1260000, 'エンジン音が低く紳士的。', '02', 1, now(), null);

-- バイクメーカーのデータ
INSERT INTO m_brand (brand_id, brand_name) VALUES ('01', 'Honda');
INSERT INTO m_brand (brand_id, brand_name) VALUES ('02', 'Kawasaki');
INSERT INTO m_brand (brand_id, brand_name) VALUES ('03', 'Yamaha');
INSERT INTO m_brand (brand_id, brand_name) VALUES ('04', 'Suzuki');
INSERT INTO m_brand (brand_id, brand_name) VALUES ('05', 'moto guzzi');