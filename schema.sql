CREATE DATABASE library;

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(120) NOT NULL,
    pages INTEGER,
    available BOOLEAN DEFAULT TRUE
);

INSERT INTO books (title, author, pages) VALUES
    ('Clean Code', 'Robert C. Martin', 464),
    ('The Pragmatic Programmer', 'Andrew Hunt', 352),
    ('Head First Java', 'Kathy Sierra', 720),
    ('The Little Prince', 'Antoine de Saint-Exupery', 96);

SELECT * FROM books WHERE pages > 300;

SELECT title FROM books ORDER BY title ASC;
