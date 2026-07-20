# Relational Database — Basic Interview Questions

General concepts that apply across all relational databases (MySQL, PostgreSQL, Oracle, SQL Server, etc.).

## 1. What is a relational database?
A database that stores data in tables (rows and columns) where relationships between tables are defined using keys (primary key, foreign key). Data integrity is enforced through constraints, and data is queried using SQL.

## 2. What is a primary key?
A column (or set of columns) that uniquely identifies each row in a table. It cannot be NULL and must be unique.

## 3. What is a foreign key?
A column that references the primary key of another table, used to enforce referential integrity between two tables.

## 4. What is normalization? Explain 1NF, 2NF, 3NF.
Normalization is the process of organizing data to reduce redundancy and improve integrity.
- **1NF**: Each column holds atomic (indivisible) values; no repeating groups.
- **2NF**: 1NF + no partial dependency (non-key columns depend on the whole primary key, not part of it).
- **3NF**: 2NF + no transitive dependency (non-key columns depend only on the primary key, not on other non-key columns).

## 5. What is denormalization and when would you use it?
Intentionally introducing redundancy (merging tables, duplicating data) to improve read performance, typically in reporting/analytics systems where read speed matters more than write efficiency.

## 6. What are the different types of SQL joins?
- **INNER JOIN**: rows matching in both tables.
- **LEFT JOIN**: all rows from the left table + matching rows from the right (NULLs if no match).
- **RIGHT JOIN**: all rows from the right table + matching rows from the left.
- **FULL OUTER JOIN**: all rows from both tables, matched where possible.
- **CROSS JOIN**: cartesian product of both tables.
- **SELF JOIN**: a table joined with itself.

## 7. What is the difference between WHERE and HAVING?
`WHERE` filters rows before grouping/aggregation. `HAVING` filters groups after `GROUP BY` has been applied.

## 8. What is an index and why does it matter?
A data structure (commonly a B-Tree) that speeds up row lookups at the cost of extra storage and slower writes (inserts/updates need to update the index too).

## 9. What is a transaction? What are the ACID properties?
A transaction is a unit of work executed as a single logical operation.
- **Atomicity**: all or nothing.
- **Consistency**: brings the DB from one valid state to another.
- **Isolation**: concurrent transactions don't interfere with each other.
- **Durability**: once committed, changes survive crashes.

## 10. What are the transaction isolation levels?
Read Uncommitted, Read Committed, Repeatable Read, Serializable — each trades off consistency guarantees against concurrency/performance. Higher isolation prevents more anomalies (dirty reads, non-repeatable reads, phantom reads) but reduces concurrency.

## 11. What is a deadlock? How can it be avoided?
Two or more transactions waiting on locks held by each other, none able to proceed. Avoided by acquiring locks in a consistent order, keeping transactions short, and using timeouts/deadlock detection.

## 12. What's the difference between a clustered and non-clustered index?
A **clustered index** determines the physical storage order of table data (only one per table). A **non-clustered index** is a separate structure with pointers back to the actual rows (a table can have many).

## 13. What is a stored procedure? What is a trigger?
A **stored procedure** is precompiled SQL logic stored in the database, callable by name. A **trigger** is code that automatically executes in response to an event (INSERT/UPDATE/DELETE) on a table.

## 14. What is the difference between DELETE, TRUNCATE, and DROP?
- **DELETE**: removes rows (can filter with WHERE), logged, can be rolled back, triggers fire.
- **TRUNCATE**: removes all rows quickly, minimal logging, resets identity, generally can't be rolled back (DB-dependent).
- **DROP**: removes the entire table structure and data.

## 15. What is a view?
A virtual table defined by a stored SQL query. It doesn't store data itself (unless materialized) but simplifies complex queries and can restrict access to specific columns/rows.

## 16. How would you optimize a slow SQL query?
Check the execution plan (`EXPLAIN`), ensure proper indexes exist on filtered/joined columns, avoid `SELECT *`, avoid functions on indexed columns in WHERE clauses, reduce joins where possible, and consider query rewriting or denormalization.

## 17. What is the N+1 query problem?
A performance issue common in ORMs where fetching a list of N parent records triggers N additional queries to fetch related child records, instead of one batched query (e.g., a JOIN or `IN` clause).

## 18. What is a composite key?
A primary key made up of two or more columns whose combination is unique, used when no single column uniquely identifies a row.

## 19. What's the difference between UNION and UNION ALL?
`UNION` combines result sets and removes duplicates (slower, involves a sort/distinct step). `UNION ALL` combines result sets keeping duplicates (faster).

## 20. What is a constraint? Name common types.
Rules enforced on table columns: `NOT NULL`, `UNIQUE`, `PRIMARY KEY`, `FOREIGN KEY`, `CHECK`, `DEFAULT`.
