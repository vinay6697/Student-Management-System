package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentManagementGUi extends JFrame {

    JLabel lblId, lblName, lblAge, lblCourse, lblPercentage;

    JTextField txtId, txtName, txtAge, txtCourse, txtPercentage;

    JButton btnAdd, btnUpdate, btnDelete, btnSearch, btnClear;

    JPanel panel;

    public StudentManagementGUi() {

        setTitle("Student Management System");

        setSize(700, 500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();

        panel.setLayout(null);

        add(panel);

        lblId = new JLabel("Student ID");
        lblName = new JLabel("Name");
        lblAge = new JLabel("Age");
        lblCourse = new JLabel("Course");
        lblPercentage = new JLabel("Percentage");

        txtId = new JTextField();
        txtName = new JTextField();
        txtAge = new JTextField();
        txtCourse = new JTextField();
        txtPercentage = new JTextField();

        btnAdd = new JButton("ADD");
        btnUpdate = new JButton("UPDATE");
        btnDelete = new JButton("DELETE");
        btnSearch = new JButton("SEARCH");
        btnClear = new JButton("CLEAR");

        lblId.setBounds(50,40,100,30);
        txtId.setBounds(180,40,200,30);

        lblName.setBounds(50,90,100,30);
        txtName.setBounds(180,90,200,30);

        lblAge.setBounds(50,140,100,30);
        txtAge.setBounds(180,140,200,30);

        lblCourse.setBounds(50,190,100,30);
        txtCourse.setBounds(180,190,200,30);

        lblPercentage.setBounds(50,240,100,30);
        txtPercentage.setBounds(180,240,200,30);

        btnAdd.setBounds(450,40,150,35);
        btnUpdate.setBounds(450,90,150,35);
        btnDelete.setBounds(450,140,150,35);
        btnSearch.setBounds(450,190,150,35);
        btnClear.setBounds(450,240,150,35);

        panel.add(lblId);
        panel.add(txtId);

        panel.add(lblName);
        panel.add(txtName);

        panel.add(lblAge);
        panel.add(txtAge);

        panel.add(lblCourse);
        panel.add(txtCourse);

        panel.add(lblPercentage);
        panel.add(txtPercentage);

        panel.add(btnAdd);
        panel.add(btnUpdate);
        panel.add(btnDelete);
        panel.add(btnSearch);
        panel.add(btnClear);

        setVisible(true);
    }
}