package table.view;

import java.awt.geom.Rectangle2D.Float;

public class Table extends Float {

	public final static int WIDTH = 50;
	public final static int HEIGHT = 75;
	public final static int SOL_HEIGHT = 35;
	
	private int seat;
	private String name;
	private String comment;
	private int idNumber;
	

	public Table(int x, int y, int w, int h, int seat, String name, String comment, int number) {
		super(x, y, w, h);
		this.seat = seat;
		this.name = name;
		this.comment = comment;
		this.idNumber = number;
	}

	public Table(int x, int y, int width, int height, int seat, String name, String comment) {
		super(x,y,width,height);
		this.seat = seat;
		this.name = name;
		this.comment = comment;
		this.idNumber = 0;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	@Override
	public String toString() {
		return "Table [seat=" + seat + ", name=" + name + ", comment=" + comment + ", idNumber=" + idNumber + "]";
	}
	

}
