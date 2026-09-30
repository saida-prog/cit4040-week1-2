# Reflection — Task 4.6

My `Book` class and my `books` table describe the same thing: each field of the class
(title, author, pages, available) matches a column in the table, and each `Book` object
in memory corresponds to one row. The table can do things the class cannot: it stores
the data permanently so it survives after the program stops, it can be searched and
sorted with queries like `WHERE pages > 300` and `ORDER BY title`, and it can
automatically generate a unique `id` for every row with `SERIAL`. It also enforces
rules such as `NOT NULL` for every program that uses the database, not just mine. The
class, on the other hand, can contain behaviour: methods like `describe()` and the
`setPages` validation that throws an exception for zero or negative pages are logic
that a plain table does not have.
