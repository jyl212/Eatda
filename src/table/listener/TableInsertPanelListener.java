package table.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import table.view.TableInsertPanel;

public class TableInsertPanelListener implements MouseListener, MouseMotionListener{
	TableInsertPanel mainView;
	
	public TableInsertPanelListener(TableInsertPanel mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
			if (e.getClickCount() == 2) {
				mainView.switchWH(e);
			}
			//������ �׷��� ����
			//drawBox�� ���� �����ؾ� Checkbox�� ������� ���ÿ� �׷����� ���� ���� �� �� �ִ�.
			mainView.drawBox(e);
			mainView.drawGrahic(e);
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			mainView.deleteGrahic(e);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		mainView.dragStep1(e);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mainView.setDragged(false);

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		mainView.dragStep2(arg0);
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
