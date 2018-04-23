package restaurant.service;

import java.util.Vector;

import dto.RestDTO;
import restaurant.dao.RestDAO;
import restaurant.dao.RestDAOImpl;

public class RestServiceImpl implements RestService {

	@Override
	public Vector<RestDTO> restSelectAll() {
		
		return new RestDAOImpl().restSelectAll();
	}

	@Override
	public Vector<String> getRestTypeList() {

		return new RestDAOImpl().getRestTypeList();
	}

	@Override
	public Vector<String> getRestLocList() {

		return new RestDAOImpl().getRestLocList();
	}

	@Override
	public Vector<RestDTO> restSelectByCondition(String restName, String addr, String restType, int cost, boolean minmax) {
		
		return new RestDAOImpl().restSelectByCondition(restName, addr, restType,cost,minmax);
	}

	@Override
	public Vector<String> getOperationTime(String restID) {
		RestDAO dao = new RestDAOImpl();
		Vector<String> opTimes = null;
		Vector<String> timeRange = dao.getRestTime(restID);
		if (timeRange != null){
			String openTime = timeRange.get(0);
			String closeTime = timeRange.get(1);
			
			int _openTime = Integer.parseInt(openTime.split(":")[0]);
			int _closeTime = Integer.parseInt(closeTime.split(":")[0]);
			
			if (_closeTime < _openTime){
				_closeTime += 24;
			}
			
			opTimes = new Vector<String>();
			
			for (int i = _openTime; i < _closeTime-1; i++) {
				opTimes.addElement( (i < 24 ? i : (i-24))+":00 ~ "+((i < 24 ? i : (i-24))+2)+":00");
			}
		}
		
		return opTimes;
	}

	@Override
	public int restInsert(RestDTO restinfo) {
		RestDAO dao = new RestDAOImpl();
		int result = dao.restInsert(restinfo);
		return result;
	}

	@Override
	public String restIdCheack(String restid) {
		RestDAO dao = new RestDAOImpl();
		String restidlist = dao.restIdCheack(restid); 
		return restidlist;
	}

	@Override
	public Vector<String> getNameAndImg(String restId) {
		RestDAO dao = new RestDAOImpl();
		return dao.getNameAndImg(restId);
	}


	@Override
	public boolean TryRestLog(String restId, String restPw) {
		RestDAO dao = new RestDAOImpl();
//		System.out.println(dao);
		return dao.TryRestLog(restId, restPw);
		
	}
	public Vector<String> locGuSelect(String locsi) {
		RestDAO dao= new RestDAOImpl();
		Vector<String> locGulist = dao.locGuSelect(locsi);
		return locGulist;
	}

	@Override
	public RestDTO restselect(String restid) {
		RestDAO dao = new RestDAOImpl();
		RestDTO restinfo = dao.restselect(restid);
		return restinfo;
	}

	@Override
	public void restUpdate(RestDTO restUdList) {
		RestDAO dao = new RestDAOImpl();
		dao.restUpdate(restUdList);
	}

	@Override
	public String getRestName(String restID) {
		RestDAO dao = new RestDAOImpl();
		return dao.getRestName(restID);
	}

	@Override
	public String findID(String name, String email, String tel) {
		RestDAO dao = new RestDAOImpl();
		return dao.findID(name, email, tel);
	}

	@Override
	public boolean findPW(String id, String name, String email, String tel) {
		RestDAO dao = new RestDAOImpl();
		return dao.findPW( id,  name,  email,  tel);
	}

	@Override
	public int updatePW(String id, String pw) {
		RestDAO dao = new RestDAOImpl();
		return dao.updatePW( id, pw);
	}

}
