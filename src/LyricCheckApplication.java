import javax.swing.JFrame;

public class LyricCheckApplication {
	/**
	 * Sets the width of the frame to 550 pixels
	 */
	public static int FRAME_WIDTH = 550;

	/**
	 * Sets the height of the frame to 300 pixels
	 */
	public static int FRAME_HEIGHT = 300;
	
	public static void main(String[] args) {
		JFrame checker = new JFrame("Is this song FCC safe?");
		// Adds checker to the window.
		checker.add(new LyricCheck());
		checker.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		checker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checker.setVisible(true);
	}

}
