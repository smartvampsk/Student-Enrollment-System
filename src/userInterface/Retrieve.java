package userInterface;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;

import database.Database;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Retrieve implements ActionListener {
	private JPanel panel;
	private JFrame frame;
	private JLabel lblStudentId, lblSubjectCode, lblResult, lblDetail;
	private JTextField tfStudentId, tfSubjectCode, tfResult;
	private JButton retrieveBtn, updateBtn, cancelBtn;
	private JTextArea textArea;
	
	Database db = new Database();
	private JScrollPane scrollPane;

	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Retrieve window = new Retrieve();
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
	public Retrieve() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 370);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Student Enrollment System - View/Update");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = frame.getContentPane();
		con.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 484, 332);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Retrieve/Update Enrollment");
		lblNewLabel.setBounds(88, 11, 320, 60);
		lblNewLabel.setFont(new Font("Narkisim", Font.BOLD, 26));
		panel.add(lblNewLabel);
		
		lblStudentId = new JLabel("Student Id");
		lblStudentId.setBounds(10, 79, 60, 20);
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblStudentId);
		
		tfStudentId = new JTextField();
		tfStudentId.setBounds(75, 79, 75, 20);
		panel.add(tfStudentId);
		tfStudentId.setColumns(10);
		
		lblSubjectCode = new JLabel("Subject Code");
		lblSubjectCode.setBounds(160, 79, 75, 20);
		lblSubjectCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblSubjectCode);
		
		tfSubjectCode = new JTextField();
		tfSubjectCode.setBounds(240, 79, 75, 20);
		tfSubjectCode.setColumns(10);
		panel.add(tfSubjectCode);
		
		lblResult = new JLabel("Result");
		lblResult.setBounds(335, 79, 38, 20);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblResult);
		
		tfResult = new JTextField();
		tfResult.setBounds(375, 79, 75, 20);
		tfResult.setColumns(10);
		panel.add(tfResult);
		
		lblDetail = new JLabel("Enrollment Detail");
		lblDetail.setBounds(170, 114, 140, 20);
		lblDetail.setFont(new Font("Narkisim", Font.BOLD | Font.ITALIC, 16));
		panel.add(lblDetail);
		
		retrieveBtn = new JButton("Retrieve");
		retrieveBtn.setBounds(101, 280, 90, 41);
		retrieveBtn.addActionListener(this);
		panel.add(retrieveBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(217, 280, 90, 41);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
		
		cancelBtn = new JButton("Back");
		cancelBtn.setBounds(331, 280, 90, 41);
		cancelBtn.addActionListener(this);
		panel.add(cancelBtn);
		
		textArea = new JTextArea();
		textArea.setBounds(1, 1, 45, 26);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textArea.setEditable(false);
		panel.add(textArea);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		scrollPane.setBounds(20, 135, 440, 138);
		panel.add(scrollPane);

	}

	//Button Functions
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		//When user presses the retrieve button
		if(source == retrieveBtn) {
			if (!tfStudentId.getText().isEmpty()) {
				String reslt = Database.retrieve(tfStudentId.getText());
				textArea.setText(reslt);
				if (reslt.isEmpty()) {
					textArea.setText("Record Not Found");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Please Enter Student ID");
			}
		}
		//When user presses the update button
		if (source == updateBtn) {
			if (!tfStudentId.getText().isEmpty()||!tfSubjectCode.getText().isEmpty()||!tfResult.getText().isEmpty()) {
				String status = Database.update(tfStudentId.getText(), tfSubjectCode.getText(), tfResult.getText());
				JOptionPane.showMessageDialog(null, status);
			
			}
			else {
				JOptionPane.showMessageDialog(null, "All three fields are necessary to update the marks. ");
			}
		}
		//When user presses the back button
		if (source == cancelBtn) {
			Main.main(null);
			frame.dispose();
		}
		
	}
}
