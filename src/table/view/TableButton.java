package table.view;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JButton;

import dto.ReservationDTO;

public class TableButton extends JButton {
	public Table table;
	private Vector<Vector<String>> menuList;
	private boolean resevated;
	private boolean using;
	public ReservationDTO dto;
	
	public TableButton(Table table) {
		super();
		this.table = table;
		setBounds((int)table.x, (int)table.y, (int)table.width, (int)table.height);
		setText(table.getName());
		setBackground(new Color(243, 50, 11));
		setForeground(Color.WHITE);
		setBorderPainted(false);	
		setFocusPainted(false);
		resevated = false;
		using = false;
		menuList = new Vector<Vector<String>>();
	}

	public boolean isResevated() {
		return resevated;
	}

	
	public boolean isUsing() {
		return using;
	}

	public void resevatedTable(){
		setBackground(new Color(127, 127, 127));
		setForeground(Color.WHITE);
		resevated = true;
		using = false;
	}
	
	public void setToolTipText(){
		if (resevated) {
			super.setToolTipText("이미 예약된 자리 입니다.");
		} else {
			super.setToolTipText(table.getComment());
		}
	}

	public Vector<Vector<String>> getMenuList() {
		return menuList;
	}

	public void setMenuList(Vector<Vector<String>> menuList) {
		this.menuList = menuList;
	}

	public void nonReservated() {
		setBackground(new Color(243, 50, 11));
		setForeground(Color.WHITE);
		resevated = false;
		using = false;
	
	}

	public void guestIn() {
		setBackground(new Color(243, 132, 11));
		setForeground(Color.WHITE);
		resevated = false;
		using = true;
	}

	public void guestOut() {
		setBackground(new Color(243, 50, 11));
		setForeground(Color.WHITE);
		resevated = false;
		using = false;
	}

}
