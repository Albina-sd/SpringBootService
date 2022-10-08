INSERT INTO public.sweets_types(
    name)
VALUES
('вафли'),
('конфеты'),
('мармелад'),
('печенье'),
('шоколад');

INSERT INTO public.manufacturers(
    name, phone, address, city, country)
VALUES
('Мишаня', '', '109235, г. Москва, Проектируемый проезд, д.15', 'Moscow', 'Russia'),
('Собакен', '78125748899', '197375, г. Санкт-Петербург, Суздальское шоссе, д. 75', 'Saint-petersburg', 'Russia'),
('Мартыха', '74657896525', '620137, г. Екатеринбург, Шефская улица, д. 5А', 'Ekaterinburg', 'Russia'),
('Мишаня', '', '109235, г. Казань, Проектируемая улица, д.15', 'Kazan', 'Russia');

INSERT INTO public.manufacturers_storehouses(
    storehouses_id, manufacturers_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(1, 2),
(2, 1);

INSERT INTO public.storehouses(
    name, address, city, country)
VALUES
('MSK-1', '109235, г. Москва, Проектируемый проезд 4386, д.8', 'Moscow', 'Russia'),
('SPB-1', '197375, г. Санкт-Петербург, Суздальское шоссе, д. 26', 'Saint-petersburg', 'Russia'),
('EKB-1', '620137, г. Екатеринбург, Шефская улица, д. 1А', 'Ekaterinburg', 'Russia'),
('EKB-2', '620137, г. Екатеринбург, Шефская улица, д. 2А', 'Ekaterinburg', 'Russia');

INSERT INTO public.sweets(
    sweets_types_id, name, cost, weight, manufacturer_id, with_sugar, requires_freezing, production_date, expiration_date)
VALUES
(1, 'Мильтик', '100', '200',1, false, false, '2022-05-03', '2022-05-15'),
(2, 'Микус', '150', '300', 1 , true, true, '2022-04-03', '2022-05-03'),
(3, 'Миви', '110', '100', 1 , true, false, '2022-03-03', '2022-04-14'),
(4, 'Ми', '120', '200', 1, false, true, '2022-03-04', '2022-04-04'),
(5, 'Миса', '145', '570', 1, true, false, '2021-03-03', '2021-12-03'),
(1, 'Сольтик', '115', '200', 2 , false, false, '2022-05-03', '2022-05-15'),
(2, 'Сокус', '155', '300', 2 , true, true, '2022-03-03', '2022-05-03'),
(3, 'Сови', '117', '500', 2 , true, false, '2022-03-03', '2022-04-14'),
(4, 'Со', '129', '250', 2, false, true, '2022-03-04', '2022-04-04'),
(5, 'Сор', '148', '500', 2, true, false, '2021-02-03', '2021-12-03'),
(1, 'Мальтик', '210', '200', 3 , false, false, '2022-05-03', '2022-05-15'),
(2, 'Макус', '350', '300', 3 , true, true, '2022-01-03', '2022-05-03');
