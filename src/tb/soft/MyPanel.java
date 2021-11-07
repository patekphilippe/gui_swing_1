package tb.soft;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MyPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MyPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		setBackground(Color.ORANGE);
		setLayout(null);
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	}
}
