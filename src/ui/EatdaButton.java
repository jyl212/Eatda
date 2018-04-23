package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EatdaButton extends JButton {
	public EatdaButton() {
		super();
		setBackground(Color.WHITE);
		setBorderPainted(false);
		Map<TextAttribute, Object> map = (Map<TextAttribute, Object>) getFont().getAttributes();
		map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//		map.put(TextAttribute.FOREGROUND, Color.BLUE);
		setFont(new Font(map));
		setContentAreaFilled(false);
	//	setFocusPainted(false);
	}
	
	public EatdaButton(String text){
		this();
		//setIcon(new ImageIcon(url));
		setText(text);
	}

	public EatdaButton(ImageIcon imageIcon) {
		this();
		setIcon(imageIcon);
	}

}
