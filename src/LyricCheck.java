import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class LyricCheck extends JPanel {
	protected SongFileReader sfreader;
	protected JTextField titleEntry;
	protected JTextField artistEntry;
	protected JButton check;
	protected JLabel result;
	protected JPanel searchPanel;
	protected JPanel resultPanel;
	protected SongTable table;

	private static final String CLEAN_MSG = "This song is OKAY to play on air.";
	private static final String EXPL_MSG = "This song is NOT SAFE for radio.";
	private static final String DNE_ERR_MSG = "This song is not in the database.";

	public LyricCheck() {
		super();
		setLayout(new BorderLayout());
		table = new SongTable();
		sfreader = new SongFileReader(table);
		result = new JLabel();
		titleEntry = new JTextField("Song Title", 20);
		artistEntry = new JTextField("Song Artist", 15);
		check = new JButton("Check Song");
		searchPanel = new JPanel();
		resultPanel = new JPanel();

		addSearchPanel();
		addResultPanel();
	}

	private void addSearchPanel() {
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = titleEntry.getText();
				String artist = artistEntry.getText();
				if (table.hasSong(title, artist)) {
					boolean isClean = table.getSong(title, artist);
					if (isClean) {
						result.setText(CLEAN_MSG);
					} else {
						result.setText(EXPL_MSG);
					}
				} else {
					result.setText(DNE_ERR_MSG);
				}
				validate();
			}
		});

		searchPanel.add(titleEntry);
		searchPanel.add(artistEntry);
		searchPanel.add(check);
		add(searchPanel, BorderLayout.NORTH);
	}

	private void addResultPanel() {
		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.X_AXIS));
		result.setFont(new Font(result.getFont().getName(), Font.PLAIN, 20));
		resultPanel.add(Box.createHorizontalGlue());
		resultPanel.add(result);
		resultPanel.add(Box.createHorizontalGlue());

		add(resultPanel, BorderLayout.CENTER);
	}
}
