
# Library Management System (LMS)

## Author
- **Name**: Carlos Campos
- **Course**: Software Development
- **Date**: October 31, 2024

## Overview
The Library Management System (LMS) is a software application designed to manage a collection of books in a library. The system allows users to add, remove, check out, and check in books, as well as display the current collection.

## Features
- **Book Management**: Add, remove, and view books.
- **Check Out/In**: Check out and check in books with automatic due dates.
- **File Loading**: Load books from a text file.
- **User Interface**: Simple GUI for interaction.

## Components
### Book Class
Represents a book in the library, storing information such as:
- `id`: Unique identifier for the book.
- `title`: Title of the book.
- `author`: Author of the book.
- `barcode`: Barcode for the book.
- `status`: Current status (checked in or checked out).
- `dueDate`: Due date for checked-out books.

**Methods**:
- Getters and setters for each property.
- `toString()`: Returns a formatted string of the book's details.

### Library Class
Manages a collection of `Book` objects. Provides functionalities such as:
- Adding books from a text file.
- Removing books by ID, title, or barcode.
- Checking in or checking out books.
- Listing all books in the collection.

**Methods**:
- `addBooksFromFile(String filePath)`: Reads books from a specified file.
- `removeBookById(int id)`: Removes a book by its ID.
- `removeBookByTitle(String title)`: Removes a book by its title.
- `removeBookByBarcode(String barcode)`: Removes a book by its barcode.
- `checkOutBook(String title)`: Checks out a book.
- `checkInBook(String title)`: Checks in a book.
- `listBooks()`: Displays all books in the collection.
- `displayBooks()`: Returns a formatted string of all books.

### LibraryGUI Class
Provides a graphical user interface for the Library Management System, allowing users to interact with the library functionalities through buttons and input fields.

**Main Components**:
- Input field for user commands.
- Buttons to load books, display books, remove books, check out, and check in.
- Text area to display output messages.

## Usage
1. Run the `LibraryGUI` class.
2. Use the provided buttons to load books from a file, display books, check out or check in books, and remove books by title or barcode.

## Requirements
- Java Development Kit (JDK)
- Swing for GUI components
