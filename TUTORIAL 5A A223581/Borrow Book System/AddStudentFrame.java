import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddStudentFrame extends JFrame implements ActionListener {
    private JTextField txtName, txtMatric;
    private JButton btnAdd, btnList;
    private JTextArea area;
    private ArrayList<Student> students;

    public AddStudentFrame(ArrayList<Student> students) {
        this.students = students;
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        txtName = new JTextField(15);
        txtMatric = new JTextField(15);
        btnAdd = new JButton("Add");
        btnList = new JButton("List");
        area = new JTextArea(5, 30);

        JPanel top = new JPanel(new GridLayout(2, 2));
        top.add(new JLabel("Name:"));
        top.add(txtName);
        top.add(new JLabel("Matric:"));
        top.add(txtMatric);

        JPanel mid = new JPanel();
        mid.add(btnAdd);
        mid.add(btnList);

        JPanel north = new JPanel(new BorderLayout());
        north.add(top, BorderLayout.NORTH);
        north.add(mid, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(new JLabel("Students:"), BorderLayout.NORTH);
        bottom.add(new JScrollPane(area), BorderLayout.CENTER);

        pane.add(north, BorderLayout.NORTH);
        pane.add(bottom, BorderLayout.CENTER);

        btnAdd.addActionListener(this);
        btnList.addActionListener(this);

        setTitle("Add Student Info");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            students.add(new Student(txtName.getText(), txtMatric.getText()));
            txtName.setText("");
            txtMatric.setText("");
        } else {
            area.setText("");
            for (Student s : students)
                area.append(s.toString() + "\n");
        }
    }
}