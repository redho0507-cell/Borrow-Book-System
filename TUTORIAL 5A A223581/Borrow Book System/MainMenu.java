import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenu extends JFrame implements ActionListener {
    private JButton btnStudent, btnBook, btnBorrow;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();

    public MainMenu() {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 1, 5, 5));

        btnStudent = new JButton("Add Student Info");
        btnBook = new JButton("Add Book Info");
        btnBorrow = new JButton("Borrow Book");

        pane.add(new JLabel("~~ BORROW BOOK SYSTEM ~~", JLabel.CENTER));
        pane.add(btnStudent);
        pane.add(btnBook);
        pane.add(btnBorrow);

        btnStudent.addActionListener(this);
        btnBook.addActionListener(this);
        btnBorrow.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStudent)
            new AddStudentFrame(students);
        else if (e.getSource() == btnBook)
            new AddBookFrame(books);
        else
            new BorrowBookFrame(students, books);
    }

    public static void main(String[] args) {
        MainMenu frame = new MainMenu();
        frame.setTitle("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setVisible(true);
    }
}