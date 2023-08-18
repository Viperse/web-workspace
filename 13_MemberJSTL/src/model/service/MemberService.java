package model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.MemberRepository;
import model.vo.MemberDTO;

public class MemberService {
	private MemberRepository repo = new MemberRepository();
	
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		return repo.showAllMember();
	}
}
