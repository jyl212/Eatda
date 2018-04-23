package reservation.service;

import java.sql.Date;
import java.util.Vector;

import dto.MenuDTO;
import dto.ReservationDTO;
import reservation.dao.ReservationDAO;
import reservation.dao.ReservationDAOImpl;

public class ReservationServiceImpl implements ReservationService {

	//예약 하기
	@Override
	public int reservationInsert(ReservationDTO dto) {
		ReservationDAO dao = new ReservationDAOImpl();
		return dao.reservationInsert(dto);
	}

	@Override
	public Vector<ReservationDTO> reservationSelectDaily(String restID, Date reserDate) {
		ReservationDAO dao = new ReservationDAOImpl();
		return dao.reservationSelectDaily(restID, reserDate);
	}

	@Override
	public Vector<ReservationDTO> reservationSelectMemID(String memID) {
		ReservationDAO dao = new ReservationDAOImpl();
		return dao.reservationSelectMemID(memID);
	}

	@Override
	public Vector<ReservationDTO> reservationSelectRestID(String restID) {
		ReservationDAO dao = new ReservationDAOImpl();
		return dao.reservationSelectRestID(restID);
	}

	@Override
	public int reservationDelete(int reserNo) {
		ReservationDAO dao = new ReservationDAOImpl();
		return dao.reservationDelete(reserNo);
	}

	@Override
	public int reservationUpdate(ReservationDTO dto) {
		ReservationDAO dao = new ReservationDAOImpl();
		return dao.reservationUpdate(dto);
	}
	
	/****************************************************************************************/
	@Override
	public int countMenuType(String restId) {
		ReservationDAO dao=new ReservationDAOImpl();
		int count=dao.countMenuType(restId);
		return count;
	}

	@Override
	public Vector<MenuDTO> select(String restId,String menuType) {
		ReservationDAO dao=new ReservationDAOImpl();
		Vector<MenuDTO> v=dao.select(restId,menuType);
		return v;
	}
	@Override
	public Vector<String> selectMenuType(String restId) {
		ReservationDAO dao=new ReservationDAOImpl();
		Vector<String> v=dao.selectMenuType(restId);
		return v;
	}

	@Override
	public int countMenuDetail(String restId, String menuType) {
		ReservationDAO dao=new ReservationDAOImpl();
		int count=dao.countMenuDetail(restId,menuType);
		return count;
	}

	@Override
	public void insertMenu(int reserno,int menuId, int count) {
		ReservationDAO dao=new ReservationDAOImpl();
		dao.insertMenu(reserno,menuId, count);
	}

	@Override
	public int menuNoSelect(String restId, String menuName) {
		ReservationDAO dao=new ReservationDAOImpl();
		int menuid=dao.menuNoSelect(restId, menuName);
		return menuid;
	}

	@Override
	public Vector<Vector<String>> selectTableInfo(String restId) {
		ReservationDAO dao=new ReservationDAOImpl();
		Vector<Vector<String>> vvs=dao.selectTableInfo(restId);
		return vvs;
	}

	@Override
	public int reservationSelect() {
		ReservationDAO dao=new ReservationDAOImpl();
		int reserno=dao.reservationSelect();
		return reserno;
	}

}
