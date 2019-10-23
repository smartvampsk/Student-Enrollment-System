package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	private JButton insertBtn, retrieveBtn, updateBtn;
	private JLabel lblMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 370);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Student Enrollment System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container con = frame.getContentPane();
		con.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 484, 332);
		panel.setLayout(null);
		con.add(panel);

		menu();

	}

	private void menu() {

		lblMenu = new JLabel("Enrollment Main Menu");
		lblMenu.setFont(new Font("Narkisim", Font.BOLD, 26));
		lblMenu.setBounds(107, 30, 260, 60);
		panel.add(lblMenu);

		insertBtn = new JButton("Insert");
		insertBtn.setBounds(45, 180, 90, 41);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);

		retrieveBtn = new JButton("Retrieve");
		retrieveBtn.setBounds(180, 180, 90, 40);
		retrieveBtn.addActionListener(this);
		panel.add(retrieveBtn);

		updateBtn = new JButton("Update");
		updateBtn.setBounds(315, 180, 90, 40);
		updateBtn.addActionListener(this);
		panel.add(updateBtn);
	}

	//Button Functions
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		//When user presses insert button
		if (source == insertBtn) {
			Insert.main(null);
			frame.dispose();
		}
		//When user presses retrieve button
		if (source == retrieveBtn) {
			Retrieve.main(null);
			frame.dispose();
		}
		//When user presses update button
		if (source == updateBtn) {
			Retrieve.main(null);
			frame.dispose();
		}
	}

}
