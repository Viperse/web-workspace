package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class MemberDAO implements MemberDAOTemplate {
	
	public static void main(String[] args) {
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO("마마마", 3, "바바바");
		try {
			System.out.println(dao.findByNameMember("김예진"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public MemberDAO() {
		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success...!");
		} catch (ClassNotFoundException e) {
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
		// 2. 데이터베이스와 연결
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connection...!");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {		
		// 5. close 닫기
		ps.close();
		conn.close();		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);	
	}

	@Override
	public void insertMember(MemberVO vo) throws SQLException {
		
		String query = "INSERT INTO MEMBER(NAME, AGE, ADDR) VALUES(?, ?, ?)";
		
		// 3. Statement 객체 생성
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getAge());
		ps.setString(3, vo.getAddr());
		
		// 4. 쿼리문 실행
		System.out.println(ps.executeUpdate() + "명 가입!");
		
		closeAll(ps, conn);
		
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		
		ArrayList<MemberVO> list = new ArrayList<>();
		
		String query = "SELECT * FROM MEMBER";
		
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			MemberVO vo = new MemberVO();
			vo.setName(rs.getString("name"));
			vo.setAge(rs.getInt("age"));
			vo.setAddr(rs.getString("addr"));
			
			list.add(vo);
		}
		
		closeAll(rs, ps, conn);
		
		return list;
	}

	@Override
	public MemberVO findByNameMember(String name) throws SQLException {
		
		String query = "SELECT * FROM MEMBER WHERE NAME = ?";
		
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			MemberVO vo = new MemberVO();
			vo.setName(rs.getString("name"));
			vo.setAge(rs.getInt("age"));
			vo.setAddr(rs.getString("addr"));
			
			closeAll(rs, ps, conn);
			return vo;
		}
		return null;
	}	

}
