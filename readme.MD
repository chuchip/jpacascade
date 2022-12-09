# Pruebas con JPA

## Cascada
En primer lugar se inserta en cascada las lineas de fra, al insertar la cabecera de la fáctura.

## Join 

Se realiza una relación entre ariticulo y precios de articulo, mostrando el ultimo precio del articulo. 

    @ManyToOne()
    @JoinFormula("(SELECT p.id_price_article FROM price_article p WHERE p.article_id = id_article ORDER BY p.posted_at DESC LIMIT 1)")
    PriceArticle currentPriceArticule;
