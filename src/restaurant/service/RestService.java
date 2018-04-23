package restaurant.service;

import java.util.Vector;

import dto.RestDTO;

public interface RestService {
	Vector<RestDTO> restSelectAll();
	Vector<RestDTO> restSelectByCondition(String restName, String addr, String restType, int cost, boolean minmax);
	Vector<String> getRestTypeList();
	Vector<String> getRestLocList();
	Vector<String> getOperationTime(String restID);
	int restInsert(RestDTO restinfo);
	String restIdCheack(String restid);
	Vector<String> getNameAndImg(String restId);
	boolean TryRestLog(String restId, String restPw);
	Vector<String> locGuSelect(String locsi);
	RestDTO restselect(String restid);
	void restUpdate(RestDTO restUdList);
	String getRestName(String restID);
	String findID(String name, String email, String tel);
	boolean findPW(String id, String name, String email, String tel);
	int updatePW(String id, String pw);

}
