package zip.service;

import java.util.Vector;

import zip.dao.ZipDAO;
import zip.dao.ZipDAOImpl;

public class ZipServiceImpl implements ZipService{

	@Override
	public Vector<String> getSIDO() {
		ZipDAO dao = new ZipDAOImpl();
		return dao.getSIDO();
	}

	@Override
	public Vector<String> getGUGUN(String sido) {
		ZipDAO dao = new ZipDAOImpl();
		return dao.getGUGUN(sido);
	}

}
