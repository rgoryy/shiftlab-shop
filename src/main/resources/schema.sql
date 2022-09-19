create table products (
      id bigint not null auto_increment primary key,
      serial_num varchar(20) not null,
      manufacturer varchar(200) not null,
      price numeric not null,
      units integer not null,
      p_type integer not null
);

create table laptops(
      laptop_id bigint not null,
      diagonal tinyint not null
                    check (diagonal in (1, 2, 3, 4)), -- 1 = 13,
                                                      -- 2 = 14,
                                                      -- 3 = 15,
                                                      -- 4 = 17
      foreign key(laptop_id) references products(id) on delete cascade
);

alter table laptops
    add constraint unique_laptop_id
        unique (laptop_id);


create table monitors(
      monitor_id bigint not null,
      diagonal numeric not null,
      foreign key(monitor_id) references products(id) on delete cascade
);

alter table monitors
    add constraint unique_monitor_id
        unique (monitor_id);


create table hard_disks(
     hard_disk_id bigint not null,
     capacity_gb integer not null,
     foreign key(hard_disk_id) references products(id) on delete cascade
);

alter table hard_disks
    add constraint unique_hard_disk_id
        unique (hard_disk_id);


create table desktops(
     desktop_id bigint not null,
     form_factor tinyint not null
                     check (form_factor in (1, 2, 3)),-- 1 = десктопы,
                                                      -- 2 = неттопы,
                                                      -- 3 = моноблоки
     foreign key(desktop_id) references products(id) on delete cascade
);

alter table desktops
    add constraint unique_desktop_id
        unique (desktop_id);

-- 1 = ноутбук
-- 2 = монитор
-- 3 = жесткий диск
-- 4 = настольные компьютеры