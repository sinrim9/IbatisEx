package frog.bbs.service;

import java.util.ArrayList;

import frog.bbs.domain.Bbs;

public interface BbsService {
	
	// 로그인
	public Bbs login(Bbs bbs);

	// 게시글 리스트 출력 Interface
	public ArrayList bbsList();
	
	// 게시글 상세 보기 Interface
	public Bbs bbsView(String seq);
	
	// 글쓰기 Interface
	public void bbsWrite(Bbs bbsWrite);
	
	// 비밀 번호 체크 Interface
	public int bbsPasswordCheck(Bbs bbs);
	
	// 글 수정 Interface
	public void bbsModify(Bbs bbs);
	
	// 글 삭제 Interface
	public void bbsDelete(Bbs bbs);
	
	// 답변 쓰기 Interface
	public void bbsReply(Bbs bbs);
}
