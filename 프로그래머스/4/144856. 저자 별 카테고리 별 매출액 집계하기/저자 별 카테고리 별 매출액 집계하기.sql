-- BOOK_SALES & BOOK으로 1월에 판매 도서 나온 거 가지고 나머지 쿼리 수행 
    SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(S.SALES * B.PRICE) AS TOTAL_SALES
    FROM BOOK B
    JOIN BOOK_SALES S ON S.BOOK_ID = B.BOOK_ID
    JOIN AUTHOR A ON A.AUTHOR_ID = B.AUTHOR_ID
    WHERE S.SALES_DATE LIKE '2022-01%'
    GROUP BY A.AUTHOR_ID, B.CATEGORY
    ORDER BY A.AUTHOR_ID, B.CATEGORY DESC

