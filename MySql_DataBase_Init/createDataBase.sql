CREATE SCHEMA `private_schema` ;

--Project DataJPA begin;
INSERT INTO `private_schema`.`t_userinfo` (`userid`, `password`, `username`) VALUES ('1', '11', 'username1');
INSERT INTO `private_schema`.`t_userinfo` (`userid`, `password`, `username`) VALUES ('2', '22', 'username2');
INSERT INTO `private_schema`.`t_userinfo` (`userid`, `password`, `username`) VALUES ('3', '33', 'username3');

INSERT INTO `private_schema`.`t_accountinfo` (`accountId`, `balance`, `userinfo_id`) VALUES ('1', '100', '1');
INSERT INTO `private_schema`.`t_accountinfo` (`accountId`, `balance`, `userinfo_id`) VALUES ('2', '200', '2');
INSERT INTO `private_schema`.`t_accountinfo` (`accountId`, `balance`, `userinfo_id`) VALUES ('3', '300', '3');

--Project DataJPA end;