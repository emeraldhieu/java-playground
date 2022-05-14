-- Copy and paste these SQLs into http://sqlfiddle.com to see how it works

CREATE TABLE merchant(
    merchantId INTEGER,
    merchantName VARCHAR(200),
    PRIMARY KEY (merchantId)
);

INSERT INTO merchant VALUES(1, 'Coffee Shop LLC');
INSERT INTO merchant VALUES(2, 'Cooking Lesson LLC');
INSERT INTO merchant VALUES(3, 'Watch Shop INC');

CREATE TABLE `transaction`(
    transactionId INTEGER,
    merchantId INTEGER,
    description TEXT,
    quantity INTEGER,
    currencyId INTEGER,
    hashedShopperReference TEXT,
    riskScore INTEGER,
    PRIMARY KEY (transactionId),
    FOREIGN KEY (merchantId) REFERENCES merchant(merchantId)
);

INSERT INTO `transaction` VALUES(1, 1, '', 2, 1, 'aaa', 4200);
INSERT INTO `transaction` VALUES(2, 1, '', 6, 1, 'bbb', 22);
INSERT INTO `transaction` VALUES(3, 1, '', 9, 1, 'ccc', 42);
INSERT INTO `transaction` VALUES(4, 1, '', 0, 1, 'ddd', 666);

INSERT INTO `transaction` VALUES(5, 1, '', 5, 1, 'aaa', 500);
INSERT INTO `transaction` VALUES(6, 1, '', 5, 1, 'aaa', 200);
INSERT INTO `transaction` VALUES(7, 2, '', 6, 1, 'bbb', 0);
INSERT INTO `transaction` VALUES(8, 2, '', 3, 1, 'aaa', 99);

INSERT INTO `transaction` VALUES(9, 2, '', 7, 1, 'aaa', 77);
INSERT INTO `transaction` VALUES(10, 2, '', 9, 1, 'aaa', 87);
INSERT INTO `transaction` VALUES(11, 3, '', 2, 1, 'ddd', 55);
INSERT INTO `transaction` VALUES(12, 3, '', 1, 1, 'ccc', 42);

SELECT merchantName, hashedShopperReference, 
ROUND(AVG(riskScore), 2) AS averageRiskScore, 
COUNT(t.merchantId) AS totalNumberOfTransactions
FROM `transaction` t INNER JOIN merchant m ON t.merchantId = m.merchantId
GROUP BY merchantName, hashedShopperReference
HAVING ROUND(AVG(riskScore), 2) >= 100.00
ORDER BY merchantName ASC, averageRiskScore DESC;