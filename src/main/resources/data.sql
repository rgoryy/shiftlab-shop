--product1 laptops
insert into products(serial_num, manufacturer, price, units, p_type) values ('CNC00620ZJ', 'HP', 350.00, 1, 1);
insert into laptops values (1, 1);

--product2 laptops
insert into products(serial_num, manufacturer, price, units, p_type) VALUES ('C02J604AF5H9', 'Apple Inc', 1299.00, 1, 1);
insert into laptops(laptop_id, diagonal) values (2, 3);

--product3
insert into products(serial_num, manufacturer, price, units, p_type) VALUES ('H324905325', 'Samsung', 300.00, 1, 2);
insert into monitors(monitor_id, diagonal) values (3, 24.5);

--product4 monitors
insert into products(serial_num, manufacturer, price, units, p_type) VALUES ('HG3H4L2H34', 'Hewlett-Packard (HP)', 50.00, 1, 3);
insert into hard_disks(hard_disk_id, capacity_gb) values (4, 1000);

--product5
insert into products(serial_num, manufacturer, price, units, p_type) VALUES ('JFJDFH23OG', 'HP', 500.00, 1, 4);
insert into desktops(desktop_id, form_factor) values (5, 1);