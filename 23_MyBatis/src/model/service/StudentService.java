package model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.Template;
import model.dao.StudentDAO;
import model.vo.StudentVO;

public class StudentService {
	public List<StudentVO> showStudent(String search) {
		SqlSession session = Template.getSqlSession();
		List<StudentVO> list = StudentDAO.getInstance().showStudent(session, search);
		session.close();
		return list;
	}
}
