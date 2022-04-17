package com.ldu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ldu.model.BoardVO;
import com.ldu.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	/* 게시판 목록 페이지 접속 */
	@GetMapping("/list")
	// => @RequestMapping(value="list", method=RequestMethod.GET)
	public void boardListGET(Model model) {

		log.info("게시판 목록 페이지 진입");

		model.addAttribute("list", boardService.getList());

	}

	@GetMapping("/enroll")
	// => @RequestMapping(value="enroll", method=RequestMethod.GET)
	public void boardEnrollGET() {

		log.info("게시판 등록 페이지 진입");

	}

	@PostMapping("/enroll")
	public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
		// RedirectAttributes : '게시판 목록' 화면으로 이동시에 등록 성공 여부를 위한 파라미터

		log.info("BoardVO : " + board);

		boardService.enroll(board);

		rttr.addFlashAttribute("result", "enrol success"); // addFlashAttribute()을 사용한 이유는 일회성으로만 데이터를 전달하기 위함

		return "redirect:/board/list";
	}

	/* 게시판 조회 */
	@GetMapping("/get")
	public void boardGetPageGET(int bno, Model model) {

		model.addAttribute("pageInfo", boardService.getPage(bno));

	}

	/* 수정 페이지 이동 */
	@GetMapping("/modify")
	public void boardModifyGET(int bno, Model model) {

		model.addAttribute("pageInfo", boardService.getPage(bno));

	}

	/* 페이지 수정 */
	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {

		boardService.modify(board);

		rttr.addFlashAttribute("result", "modify success");

		return "redirect:/board/list";

	}

	/* 페이지 삭제 */
	@PostMapping("/delete")
	public String boardDeletePOST(int bno, RedirectAttributes rttr) {

		boardService.delete(bno);

		rttr.addFlashAttribute("result", "delete success");

		return "redirect:/board/list";
	}
}
