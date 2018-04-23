package table.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;

import table.listener.TableInsertPanelListener;

public class TableInsertPanel extends JPanel {

	private int check = 0;

	public ArrayList<Rectangle2D.Float>tables = new ArrayList<Rectangle2D.Float>();
	public ArrayList<Shape>checkBox = new ArrayList<Shape>();
	public Rectangle2D.Float checkShape;
	public ArrayList<Integer>deleteTableList  = null;
	public ArrayList<Integer>updateTableList  = null;

	boolean isDragged = false;

	float offX = 0;
	float offY = 0;

	private int seat;	
	private int objectType;

	public void setDragged(boolean isDragged) {
		this.isDragged = isDragged;
	}

	public TableInsertPanel() {
		super();
		//페널에 마우스 리스너 달기!!!!!!!!! *********************
		TableInsertPanelListener listener = new TableInsertPanelListener(this);
		addMouseListener(listener); 
		addMouseMotionListener(listener);
	}



	//Shape 도형안에 다른 도형이 겁치는지 확인하는 함수
	public boolean containXY(int x, int y){

		if(tables != null){
			for (Float shape : tables) {
				if (shape.contains(x, y)){
					return true;
				}
			}
		}


		return false;
	}

	//각 버튼에 맞는 도형을 추가
	public void drawGrahic(MouseEvent e) {
		Float shape = null;

		int isDraw = 0;
		/*
		 * 0 : 안그림
		 * 1 : 테이블
		 * 2 : 기타 사물들
		 */

		switch (seat) {
		case 1:
			shape = new Table(e.getX()-(Table.WIDTH/2), e.getY()-(Table.SOL_HEIGHT/2), Table.WIDTH, Table.SOL_HEIGHT, seat,tables.size()+"","1인석");
			isDraw = 1;
			break;
		case 2:
		case 4:
		case 6:
			shape = new Table(e.getX()-((Table.WIDTH * (seat/2))/2), e.getY()-(Table.HEIGHT/2), (Table.WIDTH * (seat/2)), Table.HEIGHT, seat,tables.size()+"",seat+"인석");
			isDraw = 1;
			break;
		default:			
			break;
		}
		
		switch (objectType) {
		case Objects.WINDOW:
		case Objects.DOOR:
		case Objects.PARTITION:
		case Objects.TOILET:
			shape = new Objects(e.getX(),e.getY(),objectType);
			isDraw = 2;			
			break;

		default:
			break;
		}

		//만약 겹친다면 안그릴꺼야!!!
		if(containXY(e.getX(), e.getY())){
			isDraw = 0;
		}
		
		//안겹친다면 Shape 배열에 추가하기
		if (isDraw == 1) {
			tables.add((Table) shape);
			seat = 0; // 재초기화
		} else if (isDraw == 2) {
			tables.add((Objects) shape);
			objectType = Objects.NOTOBJECT;
		}

		repaint();
	}

	//도형 안에 마우스 클릭 여부
	void clickShape(int x, int y){
		if (tables != null) {
			for (Float shape : tables) {
				if (shape.contains(x, y) && (seat == 0 || objectType == 0)){
					check = 1;
					checkShape = shape;
					return;
				}

			}

		}
		check = -1;
	}

	// 도형 선택시 checkbox 선택 및 해제
	public void drawBox(MouseEvent e) {
		Rectangle2D.Float shape1, shape2, shape3, shape4;
		clickShape(e.getX(), e.getY());
		switch (check) {
		case 1:
			checkBox.removeAll(checkBox); // 중복 체크를 방지하기 위해 전에 선택한  checkbox를 삭제

			Float r = checkShape;
			float x1 = r.x-2;
			float x2 = (float) (x1+r.getWidth());
			float y1 = r.y-2;
			float y2 = (float) (y1+r.getHeight());
			
			// a       b
			//
			//
			// c       d

			shape1 = new Rectangle2D.Float(x1, y1, 4, 4); //a
			shape2 = new Rectangle2D.Float(x2, y2, 4, 4); //d
			shape3 = new Rectangle2D.Float(x1, y2, 4, 4); //b 
			shape4 = new Rectangle2D.Float(x2, y1, 4, 4); //c

			checkBox.add(shape1);
			checkBox.add(shape2);
			checkBox.add(shape3);
			checkBox.add(shape4);

			repaint();

			check = 0;

			break;
		case -1:
			if(seat == 0)
				checkBox.removeAll(checkBox);
			check = 0;
			repaint();
			break;

		default:
			repaint();
			break;
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D graphics2d = (Graphics2D) g;

		for (Float shape : tables) { 
			if (shape instanceof Table) {
				graphics2d.setColor(Color.BLACK);
				graphics2d.draw(shape);	
				
				// 숫자 찍기
				Font font = graphics2d.getFont();
				FontMetrics metrics = graphics2d.getFontMetrics(font);
				int width = metrics.stringWidth(((Table) shape).getName());
				int height = font.getSize();
				graphics2d.drawString(((Table) shape).getName(), shape.x+(shape.width-width)/2, shape.y+(shape.height+height)/2);
				
			} else if (shape instanceof Objects) {
				graphics2d.setColor(((Objects) shape).getColor());
				graphics2d.fill(shape);					
			}
		} 
		
		graphics2d.setColor(Color.BLACK);
		for (Shape shape : checkBox) {
			graphics2d.draw(shape);
		}

	}

	public void dragStep1(MouseEvent e) {
		checkShape = null;
		clickShape(e.getX(), e.getY());
		
		if (checkShape != null){
			checkBox.removeAll(checkBox);

			Rectangle2D.Float r = checkShape;

			offX = e.getX() - r.x;
			offY = e.getY() - r.y;

			isDragged = true;
		}

	}

	public void dragStep2(MouseEvent e) {
		if (isDragged) {

			Rectangle2D.Float r = checkShape;

			r.x = e.getX() - offX;
			r.y = e.getY() - offY;
			
			if (updateTableList == null)
				updateTableList = new ArrayList<Integer>();
			
			int number = getNumber(checkShape);
			
			if (!updateTableList.contains(number))
				updateTableList.add(number);

			repaint();

		}

	}

	public void deleteGrahic(MouseEvent e) {
		checkShape = null;
		clickShape(e.getX(), e.getY());

		if (checkShape != null) {
			int index = tables.indexOf(checkShape);
			
			if (deleteTableList == null)
				deleteTableList = new ArrayList<Integer>();
			
			deleteTableList.add(getNumber(checkShape));
			
			tables.remove(index);
			repaint();
		}

		checkBox.removeAll(checkBox);

	}

	private Integer getNumber(Float checkShape2) {

		if (checkShape2 instanceof Objects)
			return ((Objects)checkShape2).getIdNumber();
		else if (checkShape2 instanceof Table)
			return ((Table)checkShape2).getIdNumber();

		return 0;
	}

	public void drawTableMode(int seat) {
		this.seat = seat;
		this.objectType = Objects.NOTOBJECT;

	}

	public void switchWH(MouseEvent e) {
		checkShape = null;
		clickShape(e.getX(), e.getY());

		if (checkShape != null && checkBox != null) {

			float temp = checkShape.height;
			checkShape.height = checkShape.width;
			checkShape.width = temp;

			repaint();
		}

	}

	public void drawObjectMode(int type) {
		this.objectType = type;
		this.seat = 0;
		
	}

	public Vector<Vector<String>> getTableNameAndComent(){
		Vector<Vector<String>> nameAndComentList = null;
		Vector<String> nameAndComent = null;
		
		int size = tables.size();
		
		for (int i = 0; i<size; i++) {
			Float obj = tables.get(i);
			if (obj instanceof Table) {
				Table table = (Table) obj;
				if (nameAndComentList == null) nameAndComentList = new Vector<Vector<String>>();
				
				nameAndComent = new Vector<String>();
				nameAndComent.add(table.getName());
				nameAndComent.add(table.getComment());
				
				nameAndComentList.add(nameAndComent);
			}
			
		}

		return nameAndComentList;
	}
	
	public void setTableNameAndComent(Vector<Vector<String>> nameAndComentList){
		Vector<String> nameAndComent = null;
		Float obj = null;
		int size = tables.size();
		int j = 0;
		
		for (int i = 0; i < size; i++) {
			obj = tables.get(i);
			if (obj instanceof Table) {
				Table table = (Table) obj;
				nameAndComent = nameAndComentList.get(j++);
				table.setName(nameAndComent.get(0));
				table.setComment(nameAndComent.get(1));
			}
		}
	}

}
