package table.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JPanel;

import dto.ReservationDTO;
import reservation.service.ReservationService;
import reservation.service.ReservationServiceImpl;
import table.service.TableService;
import table.service.TableServiceImpl;

public class TableShowPanel extends JPanel {

	public ArrayList<Rectangle2D.Float> getTables = null;
	public ArrayList<TableButton> tableButtons = null;
	Vector<ReservationDTO> reserList = null;
	ReservationService service;

	public TableShowPanel(String restID) {
		super();
		getTables(restID);
		setButtons();
	}

	/**
	 * @wbp.parser.constructor
	 */
	public TableShowPanel(String restID, Date reserDate, String reserTime) {
		this(restID);
		service = new ReservationServiceImpl();
		reserList = service.reservationSelectDaily(restID, reserDate);
		if (reserList != null)
			setReservatedTables(reserTime);
	}

	public TableShowPanel(String restID, String reserTime) {
		this(restID);
		service = new ReservationServiceImpl();
		reserList = service.reservationSelectDaily(restID, new Date(Calendar.getInstance().getTimeInMillis()));
		if (reserList != null)
			setReservatedTablesToPOS(Integer.parseInt(reserTime));
	}

	private void setReservatedTables(String reserTime) {
		int time = Integer.parseInt(reserTime.split(":")[0]);
		setReservatedTables(time);

	}

	private void setReservatedTables(int time) {
		ArrayList<Integer> reservatedTable = getReservatedTableListFromList(time);

		if (reservatedTable != null) {
			for (int i = 0; i < reservatedTable.size(); i++) {
				int j = reservatedTable.get(i);
				for (int j2 = 0; j2 < tableButtons.size(); j2++) {
					TableButton tableButton = tableButtons.get(j2);
					if (j == tableButton.table.getIdNumber()) {
						tableButton.resevatedTable();
					}
				}
			}
		}

	}

	public void setReservatedTablesToPOS(int time) {
		ArrayList<Integer> reservatedTable = getReservatedTableListFromListToPOS(time);

		if (reservatedTable != null) {
			for (int i = 0; i < reservatedTable.size(); i++) {
				int j = reservatedTable.get(i);
				for (int j2 = 0; j2 < tableButtons.size(); j2++) {
					TableButton tableButton = tableButtons.get(j2);
					if (j == tableButton.table.getIdNumber()) {
						tableButton.resevatedTable();
					}
				}
			}
		}

	}

	private ArrayList<Integer> getReservatedTableListFromListToPOS(int time) {
		ArrayList<Integer> reservatedTable = null;
		ReservationDTO dto = null;
		int reserTime = 0;

		for (int i = 0; i < reserList.size(); i++) {
			dto = reserList.get(i);
			reserTime = Integer.parseInt(dto.getReserTime().split(":")[0]);

			if (time == reserTime || time + 1 == reserTime) {

				if (reservatedTable == null)
					reservatedTable = new ArrayList<Integer>();

				reservatedTable.add(dto.getTableNo());

				String strTemp = dto.getReserMisc();

				if (strTemp.indexOf("/**/") >= 0) {
					String[] tableIdxs = strTemp.split("/\\*\\*/");

					for (int j = 1; j < tableIdxs.length; j++) {
						reservatedTable.add(Integer.parseInt(tableIdxs[j]));
					}
				}

			}
		}

		return reservatedTable;
	}

	private ArrayList<Integer> getReservatedTableListFromList(int time) {
		ArrayList<Integer> reservatedTable = null;
		ReservationDTO dto = null;
		int reserTime = 0;

		for (int i = 0; i < reserList.size(); i++) {
			dto = reserList.get(i);
			reserTime = Integer.parseInt(dto.getReserTime().split(":")[0]);

			if (time == reserTime || time - 1 == reserTime) {

				if (reservatedTable == null)
					reservatedTable = new ArrayList<Integer>();

				reservatedTable.add(dto.getTableNo());

				String strTemp = dto.getReserMisc();

				if (strTemp.indexOf("/**/") >= 0) {
					String[] tableIdxs = strTemp.split("/\\*\\*/");

					for (int j = 1; j < tableIdxs.length; j++) {
						reservatedTable.add(Integer.parseInt(tableIdxs[j]));
					}
				}

			}
		}

		return reservatedTable;
	}

	private void setButtons() {
		for (TableButton button : tableButtons) {
			add(button);
		}

	}

	private void getTables(String restID) {

		TableService service = new TableServiceImpl();
		getTables = service.findTablesByRestID(restID);

		tableButtons = new ArrayList<TableButton>();
		for (Float table : getTables) {
			if (table instanceof Table) {
				TableButton button = new TableButton((Table) table);
				tableButtons.add(button);
			}
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (getTables != null) {

			Graphics2D graphics2d = (Graphics2D) g;

			for (Float shape : getTables) {
				if (shape instanceof Objects) {
					graphics2d.setColor(((Objects) shape).getColor());
					graphics2d.fill(shape);
				}
			}
		}
	}

}
