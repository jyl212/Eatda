package restaurant.dao;

import java.util.Vector;

import dto.RestDTO;

public interface RestDAO {

/*          REST
 REST_ID		NOT NULL VARCHAR2(40)
 REST_PW		NOT NULL VARCHAR2(20)
 REST_NAME		NOT NULL VARCHAR2(60)
 ORNER_NAME		NOT NULL VARCHAR2(20)
 ORNER_NUM		NOT NULL VARCHAR2(40)
 ADDR			NOT NULL VARCHAR2(100)
 REST_X			NOT NULL VARCHAR2(20)
 REST_Y			NOT NULL VARCHAR2(20)
 REST_TEL		NOT NULL VARCHAR2(20)
 REST_EMAIL		NOT NULL VARCHAR2(40)
 OPEN_TIME		NOT NULL VARCHAR2(20)
 CLOSE_TIME		NOT NULL VARCHAR2(20)
 REST_TYPE		NOT NULL VARCHAR2(30)
 REST_DETAIL	NOT NULL VARCHAR2(250)
 REST_IMG1		NOT NULL VARCHAR2(50)
 REST_IMG2		NOT NULL VARCHAR2(50)
*/
	Vector<RestDTO> restSelectAll();
	Vector<RestDTO> restSelectByCondition(String restName, String addr, String restType, int cost, boolean minmax);
	Vector<String> getRestTypeList();
	Vector<String> getRestLocList();
	Vector<String> getRestTime(String restID);
	int restInsert(RestDTO restinfo);//레스토랑 회원가입
	String restIdCheack(String restid);
	Vector<String> getNameAndImg(String restId);
	 boolean TryRestLog (String restId, String restPw);
	 Vector<String> locGuSelect(String locsi);
	 RestDTO restselect(String restid);
	 void restUpdate(RestDTO restUdList);
	String getRestName(String restID);
	String findID(String name, String email, String tel);
	boolean findPW(String id, String name, String email, String tel);
	int updatePW(String id, String pw);
}
