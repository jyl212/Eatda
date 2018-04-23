package pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import payment.service.PaymentService;
import payment.service.PaymentServiceImpl;
import pos.veiw.ChartClass;
import pos.veiw.SalesView;

public class SalesViewListener implements ActionListener, ItemListener 	{

	SalesView mainView;

	public SalesViewListener(SalesView mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainView.calc_close) {
			mainView.frame.mainCardLayout.show(mainView.frame.mainPanel, "posMain");
		} else if (e.getSource() == mainView.btnSelect || e.getSource() == mainView.calroot) {
			showData();
		}

	}

	private void showData() {

		int cash = 0;
		int credit = 0;
		int sum = 0;
		int man = 0;
		int woman = 0;

		boolean bMan = false;
		boolean bWoman = false;
		Date startDate = null;
		Date endDate = null;
		String type = null;

		PaymentService paymentService = new PaymentServiceImpl();
		Vector<Vector<String>> dataList = null;

		type = (String) mainView.calroot.getSelectedItem();
		if (type.equals(mainView.calroot.getItemAt(0))) {
			type = null;
		}

		java.util.Date date = mainView.dtcStart.getDate();
		if (date != null) {
			startDate = new Date(date.getTime());
		}

		date = mainView.dtcEnd.getDate();
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 1);
			endDate = new Date(calendar.getTime().getTime());

			if (endDate.getTime() < startDate.getTime()) {
				calendar.setTime(startDate);
				mainView.dtcEnd.setCalendar(calendar);
				endDate = startDate;
			}
		}

		if (mainView.all.isSelected() && startDate == null && endDate == null && type == null) {
			dataList = paymentService.getAllData(mainView.frame.ID);
		} else {
			if (mainView.man.isSelected()) {
				bMan = true;
				bWoman = false;
			} else if (mainView.woman.isSelected()) {
				bMan = false;
				bWoman = true;
			}
			dataList = paymentService.getDataByCondition(mainView.frame.ID, bMan, bWoman, startDate, endDate, type);
		}

		if (dataList != null) {
			DefaultTableModel defaultTableModel = new DefaultTableModel(dataList, mainView.colName);
			mainView.calctable.setModel(defaultTableModel);
			for (int i = 0; i < dataList.size(); i++) {
				sum += Integer.parseInt(dataList.get(i).get(1));
				if (dataList.get(i).get(3).equals("카드")) {
					credit += Integer.parseInt(dataList.get(i).get(1));
				} else {
					cash += Integer.parseInt(dataList.get(i).get(1));
				}
				String _gender = dataList.get(i).get(4);
				if (_gender != null) {
					if (_gender.equals("여")) {
						woman++;
					} else if (_gender.equals("남")) {
						man++;
					}
				}
			}
			mainView.tfCard.setText(credit + "");
			mainView.tfCash.setText(cash + "");
			mainView.tfTotal.setText(sum + "");

			showChart(cash, credit, woman, man);
		}

	}

	public void showChart(int card, int cash, int woman, int man) {
		mainView.panel.removeAll();
		ChartClass classchart = new ChartClass();
		JFreeChart chart = classchart.showBarChart(card, cash);
		ChartPanel frame1 = new ChartPanel(chart);
		mainView.panel.add(frame1);
		JFreeChart chart2 = classchart.showPieChart(man,woman);
		ChartPanel frame2 = new ChartPanel(chart2);
		mainView.panel.add(frame2);
		mainView.panel.revalidate();
		mainView.panel.repaint();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
        	showData();
        }
	}

}
