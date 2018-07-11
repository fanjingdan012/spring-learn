# Prepare
- create db according to application.properties
- create table:sql
```sql
CREATE TABLE `member` (
	`id` BIGINT(20) NULL DEFAULT NULL,
	`name` VARCHAR(255) NULL DEFAULT NULL,
	`password` VARCHAR(255) NULL DEFAULT NULL
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
```
- insert some data as you like
# Run it
- Run SSMApplication.java
- visit http://localhost:8080/login?name=shijie&password=145
- visit http://localhost:8080/members/shijie
- visit http://localhost:8080/hello
- visit http://localhost:8080/actuator/health