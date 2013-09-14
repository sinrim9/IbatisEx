package frog.bbs.persistence;

import java.util.List;

import frog.bbs.domain.Bbs;

public interface BbsDao {
	
	// 로그인 Dao Interface
	public Bbs login(Bbs bbs);
	
	// 게시글 리스트 보기 Dao Interface
	public List bbsList();
	
	// 게시글 상세 보기 Dao Interface
	public Bbs bbsView(String seq);
	
	// 글쓰기 Dao Interface
	public void bbsWrite(Bbs bbsWrite);
	
	// 비밀 번호 체크 Dao Interface
	public int bbsPasswordCheck(Bbs bbs);
	
	// 글 수정 Dao Interface
	public void bbsModify(Bbs bbs);
	
	// 글 삭제 Dao Interface
	public void bbsDelete(Bbs bbs);
	
	// 답변 달기 Dao Interface
	public void bbsReply(Bbs bbs);

}
