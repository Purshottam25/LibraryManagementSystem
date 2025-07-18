package LibraryManagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    
    public boolean addBook(Book book) {
        String query = "INSERT INTO library.books (title, author, publisher, year, available_copies) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getPublisher());
            stmt.setInt(4, book.getYear());
            stmt.setInt(5, book.getAvailableCopies());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM library.books";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int bookId = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int year = rs.getInt("year");
                int availableCopies = rs.getInt("available_copies");
                books.add(new Book(bookId, title, author, publisher, year, availableCopies));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public boolean updateBook(Book book) {
        String query = "UPDATE library.books SET title = ?, author = ?, publisher = ?, year = ?, available_copies = ? WHERE book_id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getPublisher());
            stmt.setInt(4, book.getYear());
            stmt.setInt(5, book.getAvailableCopies());
            stmt.setInt(6, book.getBookId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBook(int bookId) {
        String query = "DELETE FROM library.books WHERE book_id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

