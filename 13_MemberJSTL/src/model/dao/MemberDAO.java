package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import model.vo.MemberDTO;

public class MemberDAO implements MemberDAOTemplate {
	
	// 싱글톤 패턴 - 클래스의 객체가 항상 하나만 존재하도록
	/*
	 * DAO를 반복적으로 생성하고 해제하는 것은 비효율적
	 * 객체지향적 설계! 싱글톤 패턴은 객체지향적 설계 원칙 준수 -> 중앙에서 처리
	 * 주의할 점은 싱글톤은 전역 상태를 가질 수 있으므로 오남용하면 애플리케이션의 복잡성이 증가
	 * */
	
	private static MemberDAO dao = new MemberDAO();
	
	private MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
		}
	}
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
//	public MemberDAO() {
//		try {
//			Class.forName(ServerInfo.DRIVER_NAME);
//			System.out.println("Driver Loading Success...!");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

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
	public void registerMember(MemberDTO dto) throws SQLException {
		
		String query = "INSERT INTO MEMBER(ID, PASSWORD, NAME, ADDRESS) VALUES(?, ?, ?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement st = conn.prepareStatement(query);
		
		st.setString(1, dto.getId());
		st.setString(2, dto.getPassword());
		st.setString(3, dto.getName());
		st.setString(4, dto.getAddress());
		
		System.out.println(st.executeUpdate() + "명 가입!");
		closeAll(st, conn);
		
	}

	@Override
	public MemberDTO login(String id, String password) throws SQLException {
		
		String query = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
		Connection conn = getConnection();
		PreparedStatement st = conn.prepareStatement(query);
		
		st.setString(1, id);
		st.setString(2, password);
		
		ResultSet rs = st.executeQuery();
	 
		MemberDTO dto = new MemberDTO();
		
		if(rs.next()) {
			dto.setId(rs.getString("ID"));
			dto.setPassword(rs.getString("PASSWORD"));
			dto.setName(rs.getString("NAME"));
			dto.setAddress(rs.getString("ADDRESS"));
			
			closeAll(rs, st, conn);
			return dto;
		}
		return null;
	}

	@Override
	public MemberDTO findByIdName(String id) throws SQLException {	
		String query = "SELECT * FROM MEMBER WHERE ID = ?";
		Connection conn = getConnection();
		PreparedStatement st = conn.prepareStatement(query);	
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();	
		MemberDTO dto = new MemberDTO();
		
		if(rs.next()) {
			dto.setId(rs.getString("ID"));
			dto.setPassword(rs.getString("PASSWORD"));
			dto.setName(rs.getString("NAME"));
			dto.setAddress(rs.getString("ADDRESS"));
		}
		
		closeAll(rs, st, conn);	
		return dto;
	}

	@Override
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		
		ArrayList<MemberDTO> list = new ArrayList<>();
		String query = "SELECT * FROM MEMBER";
		Connection conn = getConnection();
		PreparedStatement st = conn.prepareStatement(query);
		
		ResultSet rs = st.executeQuery();	
		
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			
			dto.setId(rs.getString("id"));
			dto.setPassword(rs.getString("password"));
			dto.setName(rs.getString("name"));
			dto.setAddress(rs.getString("ADDRESS"));
			
			
			list.add(dto);
		}
		
		closeAll(rs, st, conn);
		
		return list;
	}
	@Override
	public void updateMember(MemberDTO dto) throws SQLException {
		
		Connection conn = getConnection();
		String query = "UPDATE MEMBER SET PASSWORD = ?, NAME = ?, ADDRESS = ? WHERE ID = ?";
		PreparedStatement st = conn.prepareStatement(query);
		
		st.setString(1, dto.getPassword());
		st.setString(2, dto.getName());
		st.setString(3, dto.getAddress());
		st.setString(4, dto.getId());
		
		System.out.println(st.executeUpdate() + "명 변경!");
		closeAll(st, conn);
	}

}
