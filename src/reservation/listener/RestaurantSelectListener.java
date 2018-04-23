package reservation.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import dto.RestDTO;
import reservation.view.RestaurantSelect;
import restaurant.service.RestService;
import restaurant.service.RestServiceImpl;
import restaurant.view.RestInfoButton;
import restaurant.view.RestaurantDetailInfo;

public class RestaurantSelectListener implements ActionListener, ItemListener{

	RestaurantSelect mainView;
	
	String restName;
	String addr;
	String restType;
	String cost;
	boolean minmax = false;
	/* 
	 * false이면 최소값 기준 검색
	 * true이면 최대값 기준 검색
	 */
	
	
	public RestaurantSelectListener(RestaurantSelect mainView) {
		super();
		this.mainView = mainView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (mainView.btnResOfFindPages.contains(e.getSource())) {
			mainView.cardLayoutResOfFind.show(mainView.pResOfFind, e.getActionCommand());
		} else if (mainView.btnResOfFind.contains(e.getSource())){
			RestInfoButton infoButton = (RestInfoButton) e.getSource();
			
//			System.out.println(infoButton.getDto().getRestName());
			
			RestaurantDetailInfo restaurantDetailPage = new RestaurantDetailInfo(mainView.frame,infoButton.getDto());
			mainView.frame.mainPanel.add(restaurantDetailPage, "restaurantDetailPage");
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel,"restaurantDetailPage");
			
		} else if (e.getSource() == mainView.comCost ||
				e.getSource() == mainView.comLocation ||
				e.getSource() == mainView.comType ||
				e.getSource() == mainView.btnFindRestaurant) {
			
			changePanel();
		
		}
		

	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getStateChange() == ItemEvent.SELECTED) {
			changePanel();
		}

	}


	private void changePanel() {
		addr = (String) mainView.comLocation.getSelectedItem();
		restType = (String) mainView.comType.getSelectedItem();
		cost = (String) mainView.comCost.getSelectedItem();
		restName = mainView.txtFindRestaurant.getText();
		
		int _cost = -1;
		
		if (mainView.radioMaximun.isSelected())
			minmax = true;
		else if (mainView.radioMinimun.isSelected())
			minmax = false;
		
		if (addr.equals(mainView.comLocation.getItemAt(0)))
			addr = null;
		if (restType.equals(mainView.comType.getItemAt(0)))
			restType = null;
		if (cost.equals("금액")) {
			_cost = -1;
		} else if (cost.equals("1 만원 미만")) {
			_cost = 0;
		} else {
			_cost = cost.charAt(0) - '0';
		}
					
		RestService restService = new RestServiceImpl();
		Vector<RestDTO> dtos = null;
		
		if (restName == null &&
				addr == null &&
				restType == null &&
						_cost < 0)
			dtos = restService.restSelectAll();
		else
			dtos = restService.restSelectByCondition(restName, addr, restType, _cost, minmax);
		

		mainView.deleteAll();
		if (dtos != null)
			mainView.setFindResult(dtos);
		mainView.validate();
		mainView.repaint();
		
	}

}
