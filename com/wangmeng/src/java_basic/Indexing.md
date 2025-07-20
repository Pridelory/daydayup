# 📌 Why Use `cols` for 2D Coordinate Encoding in Grid Problems

## 🔍 Problem Context

In many grid-based algorithm problems (e.g. Leetcode 200 - Number of Islands), we often convert 2D grid coordinates `(i, j)` into a single integer for BFS/DFS purposes.

This is done using a formula:

```java
index = i * cols + j
```

But why do we use `cols` (number of columns) and not `rows`?

---

## 📐 Visualization

Imagine a 3x4 grid (3 rows, 4 columns):

```
grid[3][4] = {
    {a, b, c, d},
    {e, f, g, h},
    {i, j, k, l}
}
```

Flattened row by row, the 1D representation becomes:

```
[a, b, c, d, e, f, g, h, i, j, k, l]
```

### ✅ Correct Encoding using `cols`

Use: `index = i * cols + j`  
Where `cols = 4`.

| Coordinate (i, j) | Element | Encoded Index |
| ----------------- | ------- | ------------- |
| (0, 0)            | a       | 0             |
| (0, 1)            | b       | 1             |
| (1, 0)            | e       | 4             |
| (2, 3)            | l       | 11            |

And decoding:

```java
int row = index / cols;
int col = index % cols;
```

Works perfectly.

---

## ❌ Incorrect Encoding using `rows`

If you mistakenly use `index = i * rows + j` with `rows = 3`, you get:

| Coordinate (i, j) | Intended Index | Incorrect Index |
| ----------------- | -------------- | --------------- |
| (1, 0)            | 4              | 3 ❌             |
| (2, 3)            | 11             | 9 ❌             |

Decoding with:

```java
int row = index / rows;
int col = index % rows;
```

❗This results in **wrong positions** unless the grid is a square (rows == cols).

---

## ✅ Summary

| Concept                         | Use `cols` ✅                               | Use `rows` ❌                 |
| ------------------------------- | ------------------------------------------ | ---------------------------- |
| Encoding formula                | `index = i * cols + j`                     | `index = i * rows + j`       |
| Decoding formula                | `row = index / cols`, `col = index % cols` | ❌ Produces incorrect results |
| Works for any rectangular grid? | ✅ Yes                                      | ❌ No                         |
| Grid flattening direction       | Row-wise                                   | ❌ Not aligned                |

---

## 🧠 Pro Tip

Always think in terms of **how many items are in a row**, i.e., the **column count (`cols`)**, when converting 2D coordinates to 1D. This ensures accurate encoding and decoding in both BFS and DFS grid traversal problems.