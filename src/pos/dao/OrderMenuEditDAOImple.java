package pos.dao;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import pos.dao.*;
import dto.MenuDTO;
import static pos.query.PosQuery.*;


public class OrderMenuEditDAOImple implements OrderMenuEditDAO{
	@Override
	public int countMenuType(String restId) {
		int result=0;
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try{
			ptmt=con.prepareStatement(MENUTYPE_COUNT);
			ptmt.setString(1,restId);
			rs=ptmt.executeQuery();
			while(rs.next()){
				result=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return result;
	}
	@Override
	public Vector<MenuDTO> select(String restId,String menuType) {	
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		Vector<MenuDTO> v=new Vector<MenuDTO>();
		try{
			MenuDTO dto=null;
			ptmt=con.prepareStatement(MENU_SELECT);
			ptmt.setString(1,restId);
			ptmt.setString(2,menuType);
			rs=ptmt.executeQuery();
			while(rs.next()){
				dto=new MenuDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
				v.add(dto);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return v;
	}
	@Override
	public Vector<String> selectMenuType(String restId) {
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		Vector<String> v=new Vector<String>();
		try{
			ptmt=con.prepareStatement(MENUTYPE_SELECT);
			ptmt.setString(1,restId);
			rs=ptmt.executeQuery();
			while(rs.next()){
				v.add(rs.getString(1));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return v;
	}
	@Override
	public int countMenuDetail(String restId, String menuType) {
		int result=0;
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try{
			ptmt=con.prepareStatement(MENU_DETAIL_COUNT);
			ptmt.setString(1,restId);
			ptmt.setString(2,menuType);
			rs=ptmt.executeQuery();
			while(rs.next()){
				result=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return result;
	}
	@Override
	public void insertMenu(int menuId, int count){
		Connection con=null;
		PreparedStatement ptmt=null;
		try{
			con=getConnect();
			ptmt=con.prepareStatement(MENU_INSERT);
			ptmt.setInt(1,menuId);
			ptmt.setInt(2,count);
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(null, ptmt, con);
		}
	}
	@Override
	public int menuNoSelect(String restId, String menuName) {
		int result=0;
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try{
			ptmt=con.prepareStatement(MENU_NO_SELECT);
			ptmt.setString(1,restId);
			ptmt.setString(2,menuName);
			rs=ptmt.executeQuery();
			while(rs.next()){
				result=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return result;
	}
	@Override
	public Vector<Vector<String>> selectTableInfo(String restId) {
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try{
			ptmt=con.prepareStatement(TABLE_SELECT);
			ptmt.setString(1,restId);
			rs=ptmt.executeQuery();
			while(rs.next()){
				Vector<String> data=new Vector<String>();
				data.add(rs.getString(1));
				data.add(rs.getString(2));
				v.add(data);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return v;
	}
}

