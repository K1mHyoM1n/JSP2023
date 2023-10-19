package cs.dit.board;

import java.io.InputStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class BoardDao {
	
	private static SqlSessionFactory sqlMapper = null;
	
	public static SqlSessionFactoru getInstance() {
		if(sqlMapper==null) {
			try {
				InputStream inputStream = Resource.getResourceAsStream("cs/dit/board/board-config.xml");
				sqlMapper = new SqlSessionFactoryBuilder().build(inputStream);
				inputStream.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return sqlMapper;
	}

	public BoardDto selectOne(intbcode) {
		sqlMapper = getInstance();
		SqlSession = sqlMapper.openSession();
		try {
			return session.selectOne("cs.dit.board.selectOne", bcode);
		}finally {
			session.close();
		}
	}
			
	public List<BoardDto> list(int page, int numOfRecords){
		sqlMapper = getInstance();
		
		SqlSession session = sqlMapper.openSession();
		Map<String, Object> param = new HashMap<>();
		param.put("page", (page-1)*numOfRecords);
		param.put("numOfRecords", numOfRecords);
		
		System.out.println("sqlMapper 사용!!!");
		try (
			return session.selectList("cs.dit.board.selectAll", param);	
		)finally {
			session.close();
		}
	}
	public int recordCount() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		try {
			return session.selectOne("cs.dit.board.recordCount");
		}finally {
			session.close();
		}
	}
		
	public void Insert (BoardDto dto) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		try {
			session.insert("cs.dit.board.insert", dto);
			session.comit();
		}finally {
			session.close();
		}
	}

	public void update(BoardDto dto) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		try {
			session.update("cs.dit.board.update", dto);
			session.comit();
			System.out.println("dao의 update");
		}finally {
			session.close();
		}
		
	}
	public void delete(int bcode) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		try {
			session.delete("cs.dit.board.delete" bcode);
			session.comit();
		}finally {
			session.close();
		}
		
	}