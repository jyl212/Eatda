package restaurant.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import dto.RestDTO;

public class RestInfoButton extends JButton {
	
	private Image img;
	private RestDTO dto;
	
	

	public RestInfoButton(RestDTO dto) {
		super();
		this.dto = dto;
	}



	public RestInfoButton() {
		super();		
	}



	public RestDTO getDto() {
		return dto;
	}



	public void setDto(RestDTO dto) {
		this.dto = dto;
	}



	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (dto != null) {		
			try {
				img = ImageIO.read(new File(dto.getRestImg2()));
				ImageIcon imageIcon = new ImageIcon(img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
				g.drawImage(imageIcon.getImage(), 0, 0, this);
				
				g.setColor(new Color(255, 255, 255, 140));
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				
				g.setColor(Color.BLACK);
				Font font = g.getFont();
				FontMetrics metrics = g.getFontMetrics(font);
				int width = metrics.stringWidth(dto.getRestName());
				int height = font.getSize();
				g.drawString(dto.getRestName(), (this.getWidth()-width)/2, (this.getHeight()+height)/2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}



	@Override
	public String toString() {
		return "RestInfoButton [dto=" + dto + "]";
	}
	
	

}
