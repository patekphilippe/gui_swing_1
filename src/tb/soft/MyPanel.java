package tb.soft;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MyPanel extends JPanel {
	private boolean rysuj = true;
	Sprajt sp = null;

	/**
	 * @return if painting is active
	 */
	public boolean isRysuj() {
		return rysuj;
	}

	/**
	 * @param rysuj to paint or not to paint
	 */
	public void setRysuj(boolean rysuj) {
		this.rysuj = rysuj;
	}

	/**
	 * @return if a sprite is added
	 */
	public boolean hasSprajt() {
		return sp != null;
	}

	/**
	 * @param spr sprite to be added
	 */
	public void addSprajt(Sprajt spr) {
		this.sp = spr;
	}

	/**
	 * Create the panel.
	 */
	public MyPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		setBackground(Color.ORANGE);
		setLayout(null);

	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		try {
			if(! isRysuj()) return;
			if(sp == null) return;
			g2d.setColor(Color.BLUE);
			sp.draw(g2d);
		} finally {
			g2d.dispose();
		}
	}
}
