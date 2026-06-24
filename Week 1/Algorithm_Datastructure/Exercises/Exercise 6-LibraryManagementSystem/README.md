# Library Management System

## Description
This project demonstrates searching books in a library using Linear Search and Binary Search algorithms.

## Features
- Search books by title
- Linear Search implementation
- Binary Search implementation

## Classes
1. Book
    - bookId
    - title
    - author

2. BookSearchService
    - linearSearch()
    - binarySearch()

3. BookData
    - Stores sample book records

4. Main
    - Executes and tests search operations

## Algorithms Used

### Linear Search
- Searches each element one by one.
- Works on unsorted data.

Time Complexity:
- Best Case: O(1)
- Average Case: O(n)
- Worst Case: O(n)

### Binary Search
- Searches by repeatedly dividing the array into halves.
- Requires sorted data.

Time Complexity:
- Best Case: O(1)
- Average Case: O(log n)
- Worst Case: O(log n)

## Conclusion
- Linear Search is suitable for small or unsorted datasets.
- Binary Search is suitable for large sorted datasets and provides faster search performance.