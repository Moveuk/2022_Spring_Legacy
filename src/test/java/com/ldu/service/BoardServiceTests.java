package com.ldu.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ldu.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {

	private static final Logger log = LoggerFactory.getLogger(BoardServiceTests.class);

	@Autowired
	private BoardService service; // mapper가 아닌 service를 통한 테스트

	@Test
	public void testEnroll() {

		BoardVO vo = new BoardVO();

		vo.setTitle("service test");
		vo.setContent("service test");
		vo.setWriter("service test");

		service.enroll(vo);

	}

//    /* 게시판 목록 테스트 */
//    @Test
//    public void testGetList() {
//        
//        service.getList().forEach(board -> log.info("" + board));        
//        
//    }

//    /*게시판 조회*/
//    @Test
//    public void testGETPage() {
//        
//        int bno = 8;
//        
//        log.info("" + service.getPage(bno));
//        
//    }

	/* 게시판 수정 */
//	@Test
//	public void testModify() {
//
//		BoardVO board = new BoardVO();
//		board.setBno(9);
//		board.setTitle("Service Test - 수정 제목");
//		board.setContent("Service Test - 수정 내용");
//
//		int result = service.modify(board);
//		log.info("result : " + result);
//
//	}

	/* 게시판 삭제 */
	@Test
	public void testDelete() {

		int result = service.delete(11);
		log.info("result : " + result);

	}
}
