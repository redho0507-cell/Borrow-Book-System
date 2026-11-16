import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddBookFrame extends JFrame implements ActionListener {
    private JTextField txtTitle, txtAuthor;
    private JButton btnAdd, btnList;
    private JTextArea area;
    private ArrayList<Book> books;

    public AddBookFrame(ArrayList<Book> books) {
        this.books = books;
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        txtTitle = new JTextField(15);
        txtAuthor = new JTextField(15);
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        area = new JTextArea(5, 30);

        JPanel top = new JPanel(new GridLayout(2, 2));
        top.add(new JLabel("Book Title:"));
        top.add(txtTitle);
        top.add(new JLabel("Author:"));
        top.add(txtAuthor);

        JPanel mid = new JPanel();
        mid.add(btnAdd);
        mid.add(btnList);

        JPanel north = new JPanel(new BorderLayout());
        north.add(top, BorderLayout.NORTH);
        north.add(mid, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(new JLabel("Books:"), BorderLayout.NORTH);
        bottom.add(new JScrollPane(area), BorderLayout.CENTER);

        pane.add(north, BorderLayout.NORTH);
        pane.add(bottom, BorderLayout.CENTER);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);

        setTitle("Add Book Info");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            books.add(new Book(txtTitle.getText(), txtAuthor.getText()));
            txtTitle.setText("");
            txtAuthor.setText("");
        } else {
            area.setText("");
            for (Book b : books)
                area.append(b.toString() + "\n");
        }
    }
}