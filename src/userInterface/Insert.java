package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import database.Database;
import models.Subjects;

public class Insert {
	private JFrame frame;
	private JPanel panel;
	private JLabel lblTitle, lblStudent, lblSurname, lblFirstname, lblYear, lblRStatus, lblStatus;
	private JTextField tfStudent, tfSurname, tfFirstname, tfYear;
	private JButton btnInsert, btnCancel;

	Database db = new Database();
	Subjects sub = new Subjects();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert window = new Insert();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Insert() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 370);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Student Enrollment System - Insert Enrollment");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container con = frame.getContentPane();
		con.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 484, 332);
		panel.setLayout(null);
		con.add(panel);

		lblTitle = new JLabel("Insert Enrollment Menu");
		lblTitle.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblTitle.setBounds(107, 30, 270, 60);
		panel.add(lblTitle);

		lblStudent = new JLabel("Student Id");
		lblStudent.setFont(new Font("Narkisim", Font.PLAIN, 15));
		lblStudent.setBounds(31, 106, 70, 20);
		panel.add(lblStudent);

		tfStudent = new JTextField();
		tfStudent.setColumns(10);
		tfStudent.setBounds(141, 106, 130, 20);
		panel.add(tfStudent);

		lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Narkisim", Font.PLAIN, 15));
		lblSurname.setBounds(31, 141, 70, 20);
		panel.add(lblSurname);

		tfSurname = new JTextField();
		tfSurname.setColumns(10);
		tfSurname.setBounds(141, 141, 130, 20);
		panel.add(tfSurname);

		lblFirstname = new JLabel("First Name");
		lblFirstname.setFont(new Font("Narkisim", Font.PLAIN, 15));
		lblFirstname.setBounds(31, 176, 70, 20);
		panel.add(lblFirstname);

		tfFirstname = new JTextField();
		tfFirstname.setColumns(10);
		tfFirstname.setBounds(141, 176, 130, 20);
		panel.add(tfFirstname);

		lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Narkisim", Font.PLAIN, 15));
		lblYear.setBounds(31, 211, 70, 20);
		panel.add(lblYear);

		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(141, 211, 130, 20);
		panel.add(tfYear);

		lblRStatus = new JLabel("<html><u>Request Status</u></html>");
		lblRStatus.setForeground(new Color(0, 0, 0));
		lblRStatus.setFont(new Font("Narkisim", Font.BOLD, 18));
		lblRStatus.setBounds(344, 140, 120, 20);
		lblRStatus.setVisible(false);
		panel.add(lblRStatus);

		lblStatus = new JLabel("");
		lblStatus.setForeground(new Color(127, 255, 0));
		lblStatus.setFont(new Font("Narkisim", Font.ITALIC, 16));
		lblStatus.setBounds(344, 171, 113, 60);
		lblStatus.setVisible(false);
		panel.add(lblStatus);

		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblRStatus.setVisible(true);
				lblStatus.setVisible(true);
				String status = "";
				//Inserting student for all the subjects
				for (int i = 0; i < sub.getSubjectCode().length; i++) {
					status = db.insert(tfStudent.getText(), tfSurname.getText(), tfFirstname.getText(),
							sub.getSubjectCode()[i], sub.getSubjectName()[i], tfYear.getText(), sub.getSemester()[i], "");
				}
				lblStatus.setText(status);

				//Clearing input fields
				tfStudent.setText("");
				tfSurname.setText("");
				tfFirstname.setText("");
				tfYear.setText("");

			}
		});
		btnInsert.setBounds(107, 270, 90, 40);
		panel.add(btnInsert);

		//This button takes user to the home frame
		btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.main(null);
				frame.dispose();
			}
		});
		btnCancel.setBounds(240, 270, 90, 40);
		panel.add(btnCancel);

	}

}
