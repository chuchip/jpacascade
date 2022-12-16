# Diferentes pruebas con joins.

## En rama 'main':
Insert en facturas incluyendo lineas usando cascada.
Busqueda del ultimo precio de un articulo usando JoinFormula

    @ManyToOne()
    @JoinFormula("(SELECT p.id_price_article FROM price_article p WHERE p.article_id = id ORDER BY p.posted_at DESC LIMIT 1)")
    PriceArticle currentPriceArticule;


## En la rama joinDicitionary
Ejemplo de una union entre la tabla article tabla que tiene un campo 'word' y en el  dicionario para cada word esta la traduccion en diferentes idiomas.
Gracias a un OneToMany se muestran todas las traducciones en al buscar un registro del articulo.