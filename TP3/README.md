# TP3: Spring Data REST

## Description
Application e-commerce avec Spring Data REST - endpoints auto-générés, HATEOAS, projections.

## Technologies
- Spring Boot 3.x
- Spring Data REST
- H2 Database
- HAL Format

## Démarrage
```bash
mvn spring-boot:run
```
Application: **http://localhost:8080**

## Endpoints Principaux
- `GET /` - Root endpoint (HAL)
- `GET /ecommerce` - Liste des articles
- `GET /ecommerce?projection=articleDTO` - Avec projection
- `GET /ecommerce/search` - Méthodes de recherche
- `GET /ecommerce/search/byCategorie?categorie=CATEGORIE_1` - Recherche
- `GET /categories` - Liste des catégories
- `POST /ecommerce` - Créer un article
- `PUT /ecommerce/{id}` - Remplacer un article
- `PATCH /ecommerce/{id}` - Modifier partiellement
- `DELETE /ecommerce/{id}` - Supprimer

## Console H2
- URL: http://localhost:8081/h2
- JDBC: `jdbc:h2:mem:testdb`
- User: `sa` / Password: (vide)

## Exemple de Requête
```bash
curl -X GET http://localhost:8081/ecommerce?projection=articleDTO
```

## Fonctionnalités Clés
- ✅ CRUD automatique sans code
- ✅ HATEOAS (hypermedia links)
- ✅ Pagination et tri automatiques
- ✅ Projections personnalisées
- ✅ Recherches personnalisées