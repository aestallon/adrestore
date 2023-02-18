CREATE TABLE ADDRESS (
  address_id INT PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE PERSON (
  person_id INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  temporary_address_id INT,
  permanent_address_id INT,
  FOREIGN KEY (temporary_address_id) REFERENCES ADDRESS(address_id),
  FOREIGN KEY (permanent_address_id) REFERENCES ADDRESS(address_id)
);

CREATE TABLE ADDRESS_ITEM (
  address_item_id INT PRIMARY KEY AUTO_INCREMENT,
  address_id INT,
  kind VARCHAR(255),
  item_value VARCHAR(255),
  FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id)
);