package com.ananth;

import java.awt.*;
import java.awt.geom.AffineTransform;
//import java.awt.Toolkit;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.JButton;
//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Main extends JPanel {
	JFrame frame;
	static keyControl keyControl, keyControl2;
	Players p1, p2;
	public ArrayList<Shot> shots, shots2;
	public ArrayList shotsb, shots2b;
	HitBox box;
	double health1, health2;
	int p1W, p2W;
	int[] trix1, trix2, triy1, triy2, cx1, cx2, cy1, cy2;
	String[] good;
	String user;

	public Main(JFrame jf) {
		frame = jf;
	}

	public void init(int x, int y) throws IOException {
	
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		p1 = new Players(50, 340);

		p2 = new Players(1050, 340);
		shots = new ArrayList();
		shots2 = new ArrayList();
		shotsb = new ArrayList();
		shots2b = new ArrayList();
		keyControl = new keyControl(x, y, p1, p2, shots, shots2);
		box = new HitBox();
		health1 = 100;
		health2 = 100;
		p1W = 0;
		p2W = 0;
		trix1 = new int[3];
		trix2 = new int[3];
		triy1 = new int[3];
		triy2 = new int[3];
		trix1[0] = p1.getX();
		trix1[1] = p1.getX() + 30;
		trix1[2] = p1.getX() + 60;

		trix2[0] = p2.getX();
		trix2[1] = p2.getX() + 30;
		trix2[2] = p2.getX() + 60;

		triy1[0] = p1.getY();
		triy1[1] = p1.getY() - 60;
		triy1[2] = p1.getY();

		triy2[0] = p2.getY();
		triy2[1] = p2.getY() - 60;
		triy2[2] = p2.getY();

		cx1 = new int[3];
		cy1 = new int[3];
		cx2 = new int[3];
		cy2 = new int[3];
		cx1[0] = p1.getX();
		cx1[1] = p1.getX() + 30;
		cx1[2] = p1.getX();

		cy1[0] = p1.getY();
		cy1[1] = p1.getY();
		cy1[2] = p1.getY() + 60;

		cx2[0] = p2.getX() + 30;
		cx2[1] = p2.getX() + 60;
		cx2[2] = p2.getX() + 60;

		cy2[0] = p2.getY();
		cy2[1] = p2.getY();
		cy2[2] = p2.getY() + 60;
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}

		}, "Blink");

	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		setBackground(new Color(57,139,62));
		g.setFont(new Font("TimesRoman", Font.BOLD, 25));
		g.setColor(Color.white);
		g.drawString("P1: " + (int) health1 + "health and " + p1W + " points", 50, 50);
		g.setColor(Color.black);
		g.drawString("P2: " + (int) health2 + "health and " + p2W + " points", getWidth() - 400, 50);
		g.setColor(Color.white);
		g.fillRect(p1.getX(), p1.getY(), 60, 60);
		g.setColor(Color.black);
		g.fillRect(p2.getX(), p2.getY(), 60, 60);
		trix1[0] = p1.getX();
		trix1[1] = p1.getX() + 30;
		trix1[2] = p1.getX() + 60;

		trix2[0] = p2.getX();
		trix2[1] = p2.getX() + 30;
		trix2[2] = p2.getX() + 60;

		triy1[0] = p1.getY();
		triy1[1] = p1.getY() - 60;
		triy1[2] = p1.getY();

		triy2[0] = p2.getY();
		triy2[1] = p2.getY() - 60;
		triy2[2] = p2.getY();

		if (p1.getX() < p2.getX()) {
			cx1[0] = p1.getX();
			cx1[1] = p1.getX() + 30;
			cx1[2] = p1.getX();

			cy1[0] = p1.getY();
			cy1[1] = p1.getY();
			cy1[2] = p1.getY() + 60;

			cx2[0] = p2.getX() + 30;
			cx2[1] = p2.getX() + 60;
			cx2[2] = p2.getX() + 60;

			cy2[0] = p2.getY();
			cy2[1] = p2.getY();
			cy2[2] = p2.getY() + 60;
		} else {
			cx1[0] = p1.getX() + 30;
			cx1[1] = p1.getX() + 60;
			cx1[2] = p1.getX() + 60;

			cy1[0] = p1.getY();
			cy1[1] = p1.getY();
			cy1[2] = p1.getY() + 60;

			cx2[0] = p2.getX();
			cx2[1] = p2.getX() + 30;
			cx2[2] = p2.getX();

			cy2[0] = p2.getY();
			cy2[1] = p2.getY();
			cy2[2] = p2.getY() + 60;

		}
		if (System.currentTimeMillis() / 1000 % 2 == 0 && p1W > p2W)
			g.setColor(Color.yellow);
		else
			g.setColor(Color.blue);
		g.fillPolygon(trix1, triy1, 3);
		g.fillPolygon(cx1, cy1, 3);

		if (System.currentTimeMillis() / 1000 % 2 == 0 && p1W < p2W)
			g.setColor(Color.yellow);
		else
			g.setColor(Color.blue);
		g.fillPolygon(cx2, cy2, 3);
		g.fillPolygon(trix2, triy2, 3);

		if (p1.getX() < p2.getX()) {
			g.setColor(Color.black);
			g.fillOval(p1.getX() + 40, p1.getY() + 15, 10, 10);
			g.drawLine(p1.getX() + 60, p1.getY() + 45, p1.getX() + 40, p1.getY() + 45);
			g.setColor(Color.white);
			g.fillOval(p2.getX() + 15, p2.getY() + 15, 10, 10);
			g.drawLine(p2.getX(), p2.getY() + 45, p2.getX() + 20, p2.getY() + 45);
		} else {
			g.setColor(Color.black);
			g.fillOval(p1.getX() + 15, p1.getY() + 15, 10, 10);
			g.drawLine(p1.getX(), p1.getY() + 45, p1.getX() + 20, p1.getY() + 45);
			g.setColor(Color.white);
			g.fillOval(p2.getX() + 40, p2.getY() + 15, 10, 10);
			g.drawLine(p2.getX() + 60, p2.getY() + 45, p2.getX() + 40, p2.getY() + 45);
		}
		if (health1 <= 0) {
			shots.clear();
			shots2.clear();
			health1 = 100;
			health2 = 100;
			p2W++;
			p1.setX(50);
			p1.setY(340);
			p2.setX(1050);
			p2.setY(340);
		}
		if (health2 <= 0) {
			shots.clear();
			shots2.clear();
			health1 = 100;
			health2 = 100;
			p1W++;
			p1.setX(50);
			p1.setY(340);
			p2.setX(1050);
			p2.setY(340);
		}
		if (shots.size() > 0) {
			int max = shots.size();
			for (int i = 0; i < max; i++) {
				max = shots.size();
				g.setColor(Color.white);
				g.fillRect(shots.get(i).getX(), shots.get(i).getY(), 10, 5);
				shots.get(i).move();

				if (box.collision(p2.getX(), p2.getY(), shots.get(i).getX(), shots.get(i).getY()) && i < max) {
					health2 -= 2;
					shots.remove(i);
					max = shots.size();
				}
				if (i < max) {
					if (shots.get(i).getX() > getWidth() || shots.get(i).getX() < 0) {
						shots.remove(i);
						max = shots.size();
					}
				}
				if (shots2.size() > 0 && shots.size() > 0 && i < max) {
					for (int j = 0; j < shots2.size(); j++) {
						if (shots.size() > 0 && shots2.size() > 0 && i < max) {
							if (box.collision2(shots.get(i).getX(), shots.get(i).getY(), shots2.get(j).getX(),
									shots2.get(j).getY())) {
								g.setColor(Color.red);
								g.fillRect(shots.get(i).getX(), shots.get(i).getY(), 10, 5);
								//g.fillOval(shots2.get(i).getX(), shots2.get(i).getY()-2, 10, 10);
								shots.remove(i);
								shots2.remove(j);
								max = shots.size();
								
							}
						}
					}
				}

			}
		}

		if (shots2.size() > 0) {
			int max = shots2.size();

			for (int i = 0; i < max; i++) {
				max = shots2.size();
				g.setColor(Color.black);
				g.fillRect(shots2.get(i).getX(), shots2.get(i).getY(), 10, 5);
				shots2.get(i).move();
				if (box.collision(p1.getX(), p1.getY(), shots2.get(i).getX(), shots2.get(i).getY()) && i < max) {
					health1 -= 2;
					shots2.remove(i);
					max = shots2.size();
				}
				if (i < max) {
					if (shots2.get(i).getX() > getWidth() || shots2.get(i).getX() < 0) {
						shots2.remove(i);
						max = shots2.size();
					}
				}
				break2: if (shots2.size() > 0 && shots.size() > 0 && i < max) {
					for (int j = 0; j < shots.size(); j++) {
						if (shots.size() > 0 && shots2.size() > 0 && i < max) {
							if (box.collision2(shots.get(j).getX(), shots.get(j).getY(), shots2.get(i).getX(),
									shots2.get(i).getY())) {
								g.setColor(Color.red);
								g.fillRect(shots2.get(i).getX(), shots2.get(i).getY(), 10, 5);
								//g.fillOval(shots2.get(i).getX(), shots2.get(i).getY()-2, 10, 10);
								shots.remove(j);
								shots2.remove(i);
								max = shots2.size();
								
							}
						}
					}
				}

			}
		}

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		JFrame frame = new JFrame("Wizard Space Battle");
		final Main game = new Main(frame);
		game.init(1200, 800);

		keyControl.addKeyListener(keyControl);
		keyControl.setFocusable(true);
		frame.add(keyControl);

		frame.add(game);
		frame.setSize(1200, 800);
		frame.setResizable(false);
		frame.setVisible(true);

		frame.setBackground(Color.black);

		while (true) {

			keyControl.tick();

			game.repaint();
			Thread.sleep(20);
		}

	}

}
