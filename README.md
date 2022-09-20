Здравствуйте. Мой результат тестового задания ШИФТЛАБ.
Язык Java, Фреймворк SpringBoot, в качестве базы данных выбрана H2, используется JDBC.

Создается 5 таблиц: products, laptops, monitors, hard_disks, desktops

#### В таблице products описываются основые поля, другие таблицы связываются с products по id.

#### Записи laptops, monitors, hard_disks, desktops имеют каскадное удаление.

#### Поле p_type таблицы products:
1 = ноутбук
2 = монитор
3 = жесткий диск
4 = настольные компьютеры

#### Столбец diagonal таблицы laptops имеет значения:
1 = 13 дюймов,
2 = 14 дюймов,
3 = 15 дюймов,
4 = 17 дюймов;

#### Столбец form_factor таблицы desktops имеет значения:
1 - десктопы,
2 - неттопы,
3 - моноблоки;

Схему создания таблицы можно посмотреть в src/main/resources/schema.sql


http://localhost:8080/api/
### 1)POST-запросы:
#### Добавление товара 
1. add-desktop
2. add-hard-disk
3. add-laptop
4. add-monitor

#### 2)Редактирование товара
1. set-serial-num-by-id
2. set-manufacturer-by-id
3. set-price-by-id
4. set-units-by-id
5. desktops/set-form-factor
6. hard-disks/set-capacity
7. laptops/set-diagonal
8. monitors/set-diagonal

#### 3)Удаление товара
1. delete-by-id


### GET-запросы:
#### 4) Просмотр товара по идентификатору
1. get-all-desktops
2. get-all-monitors
3. get-all-laptops
4. get-all-hard-disks

#### 4) Просмотр товара по идентификатору
1. get-product-by-id