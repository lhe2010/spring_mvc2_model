package com.spring.boardEx01.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.spring.boardEx01.dto.BoardDTO;

@Repository		// DAO(Data Access Object, 데이터접근객체)는 Repository 어노테이션을 명시하여야함. 
				// 현재 클래스를 DAO bean으로 등록시킨다. 
public class BoardDAOImpl implements BoardDAO {

	@Inject							// DI(Dependency Injection) 의존관계 주입 
	private SqlSession session;		// Sqlsession 객체를 스프링에서 생성하여 주입시켜준다. 
	
	@Override
	public List<BoardDTO> getAllBoard() throws Exception {
		return session.selectList("com.spring.mapper.BoardMapper.getAllBoard");
	}

	@Override
	public void insertBoard(BoardDTO bdto) throws Exception {
		session.insert("com.spring.mapper.BoardMapper.insertBoard", bdto);
	}

	@Override
	public BoardDTO getOneBoard(int num) throws Exception {
		// 하나만 가져오므로 selectOne()
		return session.selectOne("com.spring.mapper.BoardMapper.getOneBoard", num); 
	}

	@Override
	public void increaseReadCount(int num) throws Exception {
		session.update("com.spring.mapper.BoardMapper.increaseReadCount", num);
	}

	@Override
	public void updateBoard(BoardDTO bdto) throws Exception {
		session.update("com.spring.mapper.BoardMapper.updateBoard", bdto);
	}

	@Override
	public BoardDTO validateUserCheck(BoardDTO bdto) throws Exception {
		// 하나를 리턴하므로 selectOne
		return session.selectOne("com.spring.mapper.BoardMapper.validateUserCheck", bdto);
	}

}
