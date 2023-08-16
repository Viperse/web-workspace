package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class ItemDAO implements ItemDAOTemplate{
	
	private static ItemDAO dao = new ItemDAO();
	private ItemDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static ItemDAO getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement st, Connection conn) throws SQLException {	
		st.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement st, Connection conn) throws SQLException {
		
		rs.close();
		closeAll(st, conn);
		
	}

	@Override
	public ArrayList<Item> getAllItem() throws SQLException {
		
		ArrayList<Item> list = new ArrayList<>();
		Connection conn = getConnection();
		String query = "SELECT * FROM ITEM";
		PreparedStatement st = conn.prepareStatement(query);
		
		ResultSet rs = st.executeQuery();
		
		Item item = null;
		while(rs.next()) {
			int item_id = Integer.parseInt(rs.getString("item_id"));
			String item_name = rs.getString("item_name");
			int price = Integer.parseInt(rs.getString("price"));
			String des = rs.getString("DESCRIPTION");
			String pic_url = rs.getString("PICTURE_URL");
			int count = Integer.parseInt(rs.getString("COUNT"));
			
			item = new Item(item_id, item_name, price, des, pic_url, count);
			list.add(item);
		}
		closeAll(rs, st, conn);
		
		return list;
	}

	@Override
	public Item getItem(int itemId) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM ITEM WHERE ITEM_ID = ?";
		PreparedStatement st = conn.prepareStatement(query);
		st.setInt(1, itemId);
		ResultSet rs = st.executeQuery();
		
		Item item = null;
		if(rs.next()) {
			int item_id = Integer.parseInt(rs.getString("item_id"));
			String item_name = rs.getString("item_name");
			int price = Integer.parseInt(rs.getString("price"));
			String des = rs.getString("DESCRIPTION");
			String pic_url = rs.getString("PICTURE_URL");
			int count = Integer.parseInt(rs.getString("COUNT"));
			
			item = new Item(item_id, item_name, price, des, pic_url, count);
		}
		return item;
	}

	@Override
	public boolean updateRecordCount(int itemId) throws SQLException {
		Connection conn = getConnection();
		String query = "UPDATE ITEM SET COUNT = ? WHERE ITEM_ID = ?";
		PreparedStatement st = conn.prepareStatement(query);
		
		int count = getItem(itemId).getCount();
		
		st.setInt(1, ++count);
		st.setInt(2, itemId);
		
		int result = st.executeUpdate();
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
}
