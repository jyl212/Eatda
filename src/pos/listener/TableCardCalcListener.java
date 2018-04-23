package pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import dto.ReservationDTO;
import order.service.OrderService;
import order.service.OrderServiceImpl;
import pos.service.TableCardCalcService;
import pos.service.TableCardCalcServiceImple;
import pos.veiw.POSMain;
import table.view.TableButton;

public class TableCardCalcListener implements ActionListener {
	POSMain mainView;

	public TableCardCalcListener(POSMain mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.cardcalc) {
			int tableNo = 158;
			tableNo = mainView.selectedtablenumber;
			
			ArrayList<TableButton> buttons = mainView.frame.posMain.panel.tableButtons;
			int size = buttons.size();
			TableButton button = null;

			for (int i = 0; i < size; i++) {
				button = buttons.get(i);
				if (button.table.getIdNumber() == tableNo) {
					break;
				}
			}
			Vector<Vector<String>> paylist = button.getMenuList();
			
			int len = paylist.size();
			int total = 0;
			for (int j = 0; j < len; j++) {
				Vector<String> info = paylist.get(j);
				total += Integer.parseInt(info.get(1))*Integer.parseInt(info.get(2));
			}
			TableCardCalcService service = new TableCardCalcServiceImple();
			OrderService orderService = new OrderServiceImpl();
			ReservationDTO dto = button.dto;
			String memID = "ºñÈ¸¿ø";
			int orderNo = orderService.getLastOrderSequenceNum();
			int reserNo = 0;
			if (dto != null){
				memID = dto.getMemId();
				reserNo = dto.getReserNo();
			}
			orderService.OrderInsert(button, mainView.frame.ID);
			service.insert(memID, orderNo, reserNo, total);
			
			button.guestOut();
			button.setMenuList(new Vector<Vector<String>>());
			button.doClick();
		}
	}
}
