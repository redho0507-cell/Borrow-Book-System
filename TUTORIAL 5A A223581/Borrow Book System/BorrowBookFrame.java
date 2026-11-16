import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BorrowBookFrame extends JFrame implements ActionListener {
    private JComboBox<String> cmbStudent, cmbBook;
    private JButton btnBorrow;
    private JLabel lblResult;
    private ArrayList<Student> students;
    private ArrayList<Book> books;

    public BorrowBookFrame(ArrayList<Student> students, ArrayList<Book> books) {
        this.students = students;
        this.books = books;
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        cmbStudent = new JComboBox<>();
        cmbBook = new JComboBox<>();
        for (Student s : students)
            cmbStudent.addItem(s.getName() + " (" + s.getMatric() + ")");
        for (Book b : books)
            cmbBook.addItem(b.getTitle() + " (" + b.getAuthor() + ")");
        btnBorrow = new JButton("Borrow");
        lblResult = new JLabel(" ");

        JPanel top = new JPanel(new GridLayout(2, 2));
        top.add(new JLabel("Student Name & Matric:"));
        top.add(cmbStudent);
        top.add(new JLabel("Book Title & Author:"));
        top.add(cmbBook);

        JPanel mid = new JPanel();
        mid.add(btnBorrow);

        JPanel north = new JPanel(new BorderLayout());
        north.add(top, BorderLayout.NORTH);
        north.add(mid, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new GridLayout(2, 1));
        bottom.add(new JLabel("Borrow Information :"));
        bottom.add(lblResult);

        pane.add(north, BorderLayout.NORTH);
        pane.add(bottom, BorderLayout.SOUTH);

        btnBorrow.addActionListener(this);

        setTitle("Borrow Book");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int s = cmbStudent.getSelectedIndex();
        int b = cmbBook.getSelectedIndex();
        if (s == -1 || b == -1) {
            lblResult.setText("Please add student and book first.");
        } else {
            lblResult.setText(books.get(b).borrowBy(students.get(s)));
        }
    }
}