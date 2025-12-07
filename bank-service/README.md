# TP4: GraphQL Banking Service

## Description
Service bancaire avec GraphQL - gestion de clients, comptes, et transactions.

## Technologies
- Spring Boot 3.4.x
- Spring for GraphQL
- H2 Database
- ModelMapper
- Lombok

## Démarrage
```bash
mvn spring-boot:run
```
Application: **http://localhost:8080**

## Accès
- **GraphiQL:** http://localhost:8080/graphiql?path=/graphql
- **H2 Console:** http://localhost:8080/h2
  - JDBC: `jdbc:h2:mem:testdb`
  - User: `sa` / Password: (vide)

## Queries Principales

### Liste des clients
```graphql
query {
  customers {
    id username firstname lastname identityRef
  }
}
```

### Client par identité
```graphql
query {
  customerByIdentity(identity: "A100") {
    username firstname lastname
  }
}
```

### Comptes bancaires
```graphql
query {
  bankAccounts {
    rib amount accountStatus
    customer { username }
  }
}
```

## Mutations Principales

### Créer un client
```graphql
mutation {
  createCustomer(request: {
    username: "newuser"
    firstname: "John"
    lastname: "Doe"
    identityRef: "A999"
  }) {
    id username identityRef
  }
}
```

### Ajouter un compte
```graphql
mutation {
  addBankAccount(request: {
    amount: 5000
    customerId: 1
  }) {
    rib amount accountStatus
  }
}
```

### Virement
```graphql
mutation {
  addWirerTransfer(request: {
    amount: 500
    ribSource: "RIB_1"
    ribDestination: "RIB_2"
  }) {
    transactionType amount
  }
}
```

## Règles Métier
- ✅ Identité et username uniques
- ✅ Pas de transactions sur comptes CLOSED/BLOCKED
- ✅ Virement nécessite solde suffisant
- ✅ Virement crée 2 transactions (DEBIT + CREDIT)

## Structure
```
src/main/java/ma/formation/
├── entities/           # User, Customer, BankAccount, Transaction
├── repositories/       # JPA Repositories
├── services/          # Business logic
├── dto/               # Request/Response DTOs
├── controllers/       # GraphQL Controllers
└── exceptions/        # Exception handling
```

## Données de Test
Au démarrage:
- 4 clients (A100 à A400)
- Plusieurs comptes bancaires
- Transactions d'exemple