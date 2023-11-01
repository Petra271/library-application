# Library Backend

A simple Spring Boot application that serves as a backend for storing and managing books and authors.

- [API Endpoints](#api-endpoints)
- [Data Models](#data-models)

## API Endpoints

### Books

- **GET /api/books**: Get a list of all books.
- **GET /api/books/{isbn}**: Get details of a specific book by ISBN.
- **PUT /api/books/{isbn}**: Create/Update a book.
- **PATCH /api/books/{isbn}**: Partially update an existing book.
- **DELETE /api/books/{isbn}**: Delete a book.

### Authors

- **GET /api/authors**: Get a list of all authors.
- **GET /api/authors/{id}**: Get details of a specific author by ID.
- **POST /api/authors**: Create a new author.
- **PUT /api/authors/{id}**: Update an existing author.
- **PATCH /api/authors/{id}**: Partially update an existing author.
- **DELETE /api/authors/{id}**: Delete an author.

## Data Models

### Book

- **ISBN:** The International Standard Book Number for the book
- **Title:** The title of the book
- **Author:** A reference to the author of the book

### Author

- **ID:** (Generated automatically)
- **Name:** The name of the author
- **Age:** The age of the author
