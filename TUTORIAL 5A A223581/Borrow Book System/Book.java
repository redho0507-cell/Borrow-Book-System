public class Book {
    private String title, author;
    private boolean borrowed = false;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public String borrowBy(Student s) {
        if (borrowed)
            return "This book has been borrowed.";
        if (s.hasBorrowed())
            return s.getName() + " has already borrowed a book.";
        borrowed = true;
        s.setBorrowed(true);
        return s.getName() + " with matric number " + s.getMatric()
             + " has borrow a book with title " + title + ".";
    }

    public String toString() {
        return "Book title : " + title + " (Author : " + author + ")";
    }
}