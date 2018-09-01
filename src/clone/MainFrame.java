package clone;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame {
	private JFrame mainFrame;
	private JTabbedPane tabbedPane;
	
	public MainFrame() {
		makeFrame();
		makeTabbedPane();
		mainFrame.setVisible(true);
	}

	private void makeTabbedPane() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setFont(new Font("Sherif",Font.PLAIN,20));
		tabbedPane.addTab("Eight_Puzzle", new Panel());

		mainFrame.getContentPane().setLayout(new BorderLayout());
		mainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		mainFrame.pack();
	}

	private void makeFrame() {
		mainFrame = new JFrame("Eight_Puzzle");
		mainFrame.setFont(new Font("Vrinda",Font.PLAIN,40));
		mainFrame.setLayout(null);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setMinimumSize(new Dimension(700, 500));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MainFrame();
	}
}
