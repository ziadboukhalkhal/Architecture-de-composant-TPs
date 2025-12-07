# TP2: REST API with Spring Boot

## Description
API REST pour la gestion d'articles avec CRUD complet, validation, et support JSON/XML.

## Technologies
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- Lombok
- Bean Validation

## Démarrage
```bash
mvn spring-boot:run
```
Application: **http://localhost:7777**

## Endpoints Principaux
- `GET /api/articles/all` - Liste des articles
- `GET /api/articles/id/{id}` - Article par ID
- `POST /api/articles/create` - Créer un article
- `PUT /api/articles/update/{id}` - Modifier un article
- `DELETE /api/articles/delete/{id}` - Supprimer un article

## Console H2
- URL: http://localhost:7777/h2
- JDBC: `jdbc:h2:mem:testdb`
- User: `sa` / Password: (vide)

## Exemple de Requête
```bash
curl -X POST http://localhost:7777/api/articles/create \
  -H "Content-Type: application/json" \
  -d '{
    "description": "Test Article",
    "price": 1500.0,
    "quantity": 10.0,
    "categorieId": 1
  }'
```

## Tests
```bash
mvn test
```