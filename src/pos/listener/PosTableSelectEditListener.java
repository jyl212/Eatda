package pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import pos.veiw.OrderEdit;
import pos.veiw.POSMain;
import table.view.TableShowPanel;

public class PosTableSelectEditListener implements ActionListener {
	TableShowPanel mainView;
	POSMain postable;
	OrderEdit orderedit;


	public PosTableSelectEditListener(TableShowPanel mainView, POSMain postable, OrderEdit orderedit) {
		super();
		this.mainView = mainView;
		this.postable = postable;
		this.orderedit = orderedit;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == postable.orderEdit) {
			postable.frame.pos_2.tablename.setText(postable.tfTableName.getText());
			DefaultTableModel model = (DefaultTableModel)postable.MainPostable.getModel();
			postable.frame.pos_2.menudata = model.getDataVector();

			((DefaultTableModel)postable.frame.pos_2.resarOdertable.getModel()).setDataVector(model.getDataVector(),
								getColumn());
			postable.frame.pos_2.totalPrice.setText(postable.tfTotalPrice.getText());
		    postable.frame.mainCardLayout.show(postable.frame.mainPanel, "pos_2");
		}
		
		
		
	}


	public Vector<String> getColumn() {
		Vector<String> colNames = new Vector<String>();
		colNames.addElement("메뉴");
		colNames.addElement("수량");
		colNames.addElement("가격");		
		return colNames;
	}
}
