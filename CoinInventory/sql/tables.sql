CREATE TABLE coin (
  id int(11) NOT NULL,
  Type varchar(45) DEFAULT NULL,
  storageLocation varchar(45) DEFAULT NULL,
  contidion varchar(45) DEFAULT NULL,
  dateOnCoin date DEFAULT NULL,
  PRIMARY KEY (id),
 CONSTRAINT coin_ibfk_1 FOREIGN KEY (id) REFERENCES transaction (id)
);
CREATE TABLE transaction(
  id int(11) NOT NULL,
  tranTypeID int(11) NOT NULL,
  price varchar(45) DEFAULT NULL,
  dealer varchar(45) DEFAULT NULL,
  tranDate date DEFAULT NULL,
  PRIMARY KEY (id),
 
);
CREATE TABLE transactionType(
  id int(11) NOT NULL,
  TranType varchar(45) DEFAULT NULL,
  PRIMARY KEY (id),
 CONSTRAINT transactionType_ibfk_1 FOREIGN KEY (tranTypeID) REFERENCES transaction (tranTypeID)
);
