12/25 1차 완료했습니다.


# 2022WinterDevCampPersonalProject - URL Shortener

<br>

## 실행 방법
### 데이터베이스 생성
```
CREATE SCHEMA IF NOT EXISTS `devcamp` DEFAULT CHARACTER SET utf8 ;
USE `devcamp` ;

CREATE TABLE IF NOT EXISTS `devcamp`.`url` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `origin_url` MEDIUMTEXT NOT NULL,
  PRIMARY KEY (`id`));

ALTER TABLE `url` AUTO_INCREMENT=10000;
```

### 실행
`./gradlew clean bootRun` 실행 후, `http://localhost:8080/` 접속

<br>


## 기술 스택
 - SPRING
 - MySQL
 - THYMELEAF
