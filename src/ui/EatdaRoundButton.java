package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JButton;

public class EatdaRoundButton extends JButton{
	
	String msg ; 
	
	public EatdaRoundButton() {
		super();
		setBorderPainted(false);
		setContentAreaFilled(false);
		setForeground(Color.WHITE);
	}
	public EatdaRoundButton(String string) {
		this();
		msg = string;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(new Color(243, 50, 11));
		g.fillOval(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.WHITE);
		if(msg != null){
			Font font = g.getFont();
			FontMetrics metrics = g.getFontMetrics(font);
			int width = metrics.stringWidth(msg);
			int height = font.getSize();
			g.drawString(msg, (this.getWidth()-width)/2, (this.getHeight()+height)/2);
		}
	}
}