package tb.soft;

import java.awt.Graphics2D;

/**
 * @author tb
 *
 */
public class Pilka extends Sprajt {
	
	private final int w=40,
			h=20;

	/**
	 * @param x - horizontal
	 * @param y - vertical
	 */
	public Pilka(int x, int y) {
		super(x, y);
	}

	/* (non-Javadoc)
	 * @see panel.Sprajt#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics2D g2d) {
		g2d.fillOval(x-Math.round(w/2), y-Math.round(h/2), w, h);
	}

}
