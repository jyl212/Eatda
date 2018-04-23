package board.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import board.veiw.NoticeBoardPage;

public class NBMListener implements ActionListener,MouseListener {
//	NoticeBoardMain mainView;
//	
//	public NBMListener(NoticeBoardMain mainView) {
//		super();
//		this.mainView = mainView;
//	}
	NoticeBoardPage mainView;
	
	public NBMListener(NoticeBoardPage mainView) {
		super();
		this.mainView = mainView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mainView.btn1 ||
				e.getSource() == mainView.noticeContent.btnNewButton ||
				e.getSource() == mainView.write.btnCancle ||
				e.getSource() == mainView.write.btnOk) {
//			System.out.println("이벤트 발생! btn1");
			mainView.card.show(mainView.listpanel, "page1" );
		}else if(e.getSource()==mainView.btn2){
//			System.out.println("이벤트 발생! btn2");
			mainView.card.show(mainView.listpanel, "page2");
		}else if(e.getSource()==mainView.btn3){
//			System.out.println("이벤트 발생! btn3");
			mainView.card.show(mainView.listpanel, "page3");
		}else if(e.getSource()==mainView.btn4){
//			System.out.println("이벤트 발생! btn4");
			mainView.card.show(mainView.listpanel, "page4");
		}else if (e.getSource() == mainView.faq.btnNewButton){
			mainView.card.show(mainView.listpanel, "noticeContent");
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == mainView.notice.table){
			mainView.card.show(mainView.listpanel, "noticeContent");
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
