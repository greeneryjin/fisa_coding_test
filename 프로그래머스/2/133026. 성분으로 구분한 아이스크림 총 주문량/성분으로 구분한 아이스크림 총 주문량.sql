-- 코드를 입력하세요
SELECT I.INGREDIENT_TYPE, SUM(TOTAL_ORDER)
FROM FIRST_HALF F
JOIN ICECREAM_INFO I ON I.FLAVOR = F.FLAVOR
GROUP BY INGREDIENT_TYPE
ORDER BY TOTAL_ORDER ASC;
