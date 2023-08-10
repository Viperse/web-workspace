package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.vo.MemberVO;

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
	public void registerMember(MemberVO vo) throws SQLException {
		
		String query = "INSERT INTO MEMBER(ID, PASSWORD, NAME, ADDR) VALUES(?, ?, ?, ?)";
		
		Connection conn = getConnection();
		PreparedStatement st = conn.prepareStatement(query);
		
		st.setString(1, vo.getId());
		st.setString(2, vo.getPassword());
		st.setString(3, vo.getName());
		st.setString(4, vo.getAddress());
		
		System.out.println(st.executeUpdate() + "명 가입!");
		closeAll(st, conn);
		
	}

	@Override
	public MemberVO login(String id, String password) throws SQLException {
		
		String query = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
		Connection conn = getConnection();
		PreparedStatement st = conn.prepareStatement(query);
		
		st.setString(1, id);
		st.setString(2, password);
		
		ResultSet rs = st.executeQuery();
	 
		MemberVO vo = new MemberVO();
		
		if(rs.next()) {
			vo.setId(rs.getString("ID"));
			vo.setPassword(rs.getString("PASSWORD"));
			vo.setName(rs.getString("NAME"));
			vo.setAddress(rs.getString("ADDR"));
			
			closeAll(rs, st, conn);
			return vo;
		}
		return null;
	}

	@Override
	public MemberVO findByIdName(String id) throws SQLException {	
		String query = "SELECT * FROM MEMBER WHERE ID = ?";
		Connection conn = getConnection();
		PreparedStatement st = conn.prepareStatement(query);	
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();	
		MemberVO vo = new MemberVO();
		
		if(rs.next()) {
			vo.setId(rs.getString("ID"));
			vo.setPassword(rs.getString("PASSWORD"));
			vo.setName(rs.getString("NAME"));
			vo.setAddress(rs.getString("ADDR"));
		}
		
		closeAll(rs, st, conn);	
		return vo;
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		
		ArrayList<MemberVO> list = new ArrayList<>();
		String query = "SELECT * FROM MEMBER";
		Connection conn = getConnection();
		PreparedStatement st = conn.prepareStatement(query);
		
		ResultSet rs = st.executeQuery();	
		
		while(rs.next()) {
			MemberVO vo = new MemberVO();
			
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
			vo.setName(rs.getString("name"));
			vo.setAddress(rs.getString("ADDR"));
			
			
			list.add(vo);
		}
		
		closeAll(rs, st, conn);
		
		return list;
	}
	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		
		Connection conn = getConnection();
		String query = "UPDATE MEMBER SET PASSWORD = ?, NAME = ?, ADDR = ? WHERE ID = ?";
		PreparedStatement st = conn.prepareStatement(query);
		
		st.setString(1, vo.getPassword());
		st.setString(2, vo.getName());
		st.setString(3, vo.getAddress());
		st.setString(4, vo.getId());
		
		System.out.println(st.executeUpdate() + "명 변경!");
		closeAll(st, conn);
	}

}
