SELECT Product,SUM(Sales) FROM financial_sample GROUP BY Product;
SELECT Country,SUM(Sales) FROM financial_sample GROUP BY Country ORDER BY SUM(Sales) DESC;
SELECT Date,Sales FROM financial_sample WHERE Sales=(SELECT MAX(Sales) FROM financial_sample);