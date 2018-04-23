package order.service;

import java.util.ArrayList;
import java.util.Vector;

import dto.OrderDetailDTO;
import dto.RestOrderDTO;
import menu.service.MenuServiceImpl;
import order.dao.OrderDAO;
import order.dao.OrderDAOImpl;
import order.detail.dao.OrderDetailDAO;
import order.detail.dao.OrderDetailDAOImpl;
import table.view.TableButton;

public class OrderServiceImpl implements OrderService{

	@Override
	public int OrderInsert(TableButton tableButton, String restID) {
		int rowNum = 0;
		RestOrderDTO orderDTO;
		ArrayList<OrderDetailDTO> orderDetailDTOs = new ArrayList<OrderDetailDTO>();
		int total = 0;
		Vector<Vector<String>> menuList = tableButton.getMenuList();
		Vector<Vector<String>> menuInfo = new MenuServiceImpl().getNameANDNo(restID);
		//name,no
		int listLen = menuList.size();
		int infoLen = menuInfo.size();
		Vector<String> menu;
		Vector<String> info;
		String menuName;
		int count;
		int price;
		int menuNo = 0;
		
		for (int i = 0; i < listLen; i++) {
			menu = menuList.get(i);
			menuName = menu.get(0);
			count = Integer.parseInt(menu.get(1));
			price = Integer.parseInt(menu.get(2));
			
			for (int j = 0; j < infoLen; j++) {
				info = menuInfo.get(j);
				if(menuName.equals(info.get(0))){
					menuNo = Integer.parseInt(info.get(1));
					break;
				}
			}
			
			orderDetailDTOs.add(new OrderDetailDTO(0, menuNo, count));
			total+= count*price;
		}
		
		orderDTO = new RestOrderDTO(0, restID, tableButton.table.getIdNumber(), null, total);
		OrderDAO dao = new OrderDAOImpl();
		OrderDetailDAO detailDAO = new OrderDetailDAOImpl();

		int orderNum = getLastOrderSequenceNum();
		int dtoLen = orderDetailDTOs.size();
		OrderDetailDTO dto;
		
		dao.OrderInsert(orderDTO);
		for (int i = 0; i < dtoLen; i++) {
			dto = orderDetailDTOs.get(i);
			dto.setOrderNo(orderNum);
			detailDAO.OderDetailInsert(dto);
		}
		

		return rowNum;
	}

	@Override
	public int getLastOrderSequenceNum() {
		OrderDAO dao = new OrderDAOImpl();
		return dao.getLastOrderSequenceNum();	
	}

}
