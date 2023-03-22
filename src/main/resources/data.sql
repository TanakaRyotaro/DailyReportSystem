INSERT INTO employee(name, created_at, updated_at, delete_flag) VALUES ("煌木　太郎", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);
INSERT INTO employee(name, created_at, updated_at, delete_flag) VALUES ("田中　太郎", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);
INSERT INTO authentication(code, password, role, employee_id)
VALUES ("A001", "$2a$08$clh9XaYYznpX9WDqySgiCuUu4znpSeu2oJi5l2Q00UJs42Llrbd7S", "管理者", 1);
INSERT INTO authentication(code, password, role, employee_id)
VALUES ("0123", "$2a$10$F1k.2HZtkRpoSDymdZCTnuI7eVdoKP.Yb8gtiWmVTKejp53Htlm56", "一般",  2);

INSERT INTO employee(name, created_at, updated_at, delete_flag) VALUES ("斉藤　博", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);
INSERT INTO employee(name, created_at, updated_at, delete_flag) VALUES ("黒木　蓮", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);
INSERT INTO authentication(code, password, role, employee_id)
VALUES ("ktaro","$2a$08$clh9XaYYznpX9WDqySgiCuUu4znpSeu2oJi5l2Q00UJs42Llrbd7S","管理者", 3);
INSERT INTO authentication(code, password, role, employee_id)
VALUES ("ttaro","$2a$08$mHD4bywlc7kvdWGTGZ1gVOmVU.CGtHeSnOGk.j2UsZAvEiw61wdUG","一般", 4);

INSERT INTO reports(report_date, title, content, created_at, updated_at ,employee_id) VALUES (CURRENT_TIMESTAMP,"新規タイトル", "日報新規内容", CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 4);