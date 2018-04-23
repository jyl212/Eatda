package table.view;

import java.awt.Color;
import java.awt.geom.Rectangle2D.Float;

public class Objects extends Float {
	public static final int NOTOBJECT = 0;
	public static final int WINDOW = 1;
	public static final int DOOR = 2;
	public static final int PARTITION = 3;
	public static final int TOILET = 4;

	private int objectType;
	private Color color = null;
	private int idNumber;
	
	public Objects(int x, int y, int w, int h, int objectType,  int idNumber) {
		super(x, y, w, h);
		this.objectType = objectType;
		this.idNumber = idNumber;
		setColor();
	}

	public Objects(int i, int j, int objectType) {
		super(i, j, 0, 0);
		this.objectType = objectType;
		this.idNumber = 0;
		setColor();
		setWH();
	}

	private void setWH() {
		switch (objectType) {
		case WINDOW:
			width = 100;
			height = 20;
			break;
		case DOOR:
			width = 100;
			height = 40;
			break;
		case PARTITION:
			width = 20;
			height = 100;
			break;
		case TOILET:
			width = 50;
			height = 40;
			break;
		default:
			break;
		}
		
		
	}

	private void setColor() {
		switch (objectType) {
		case WINDOW:
			color = Color.CYAN;
			break;
		case DOOR:
			color = Color.DARK_GRAY;
			break;
		case PARTITION:
			color = Color.LIGHT_GRAY;
			break;
		case TOILET:
			color = Color.BLUE;
			break;

		default:
			break;
		}
		
	}

	public Color getColor() {
		return color;
	}

	public int getObjectType() {
		return objectType;
	}

	public void setObjectType(int objectType) {
		this.objectType = objectType;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

}
