package frog.bbs.service;

import java.util.ArrayList;

import frog.bbs.domain.Bbs;
import frog.bbs.persistence.BbsDao;


public class BbsServiceImpl implements BbsService{
	
	
	private Bbs bbs; //Domain Setter Getter
	private BbsDao bbsDao;
	
	public void setBbsDao(BbsDao bbsDao) {		this.bbsDao = bbsDao;	}
	public void setBbs(Bbs bbs) {		this.bbs = bbs;	}
	public Bbs getBbs() {		return bbs;	}
	
	// 로그인
	public Bbs login(Bbs bbs){
		
		Bbs login = null;
		
		try{
			
			login = bbsDao.login(bbs);
			
			return login;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	// 게시글 리스트 출력
	public ArrayList bbsList(){
		
		ArrayList bbsList = null;
		
		try{
			
			bbsList = (ArrayList)bbsDao.bbsList(); 
			
			return bbsList;
			
		}catch(Exception e ){
			e.printStackTrace();
		}		
		return null;
	}
	
	// 게시글 상세 보기
	public Bbs bbsView(String seq){
		
		Bbs bbsView = null;
		
		try{
		
			bbsView = bbsDao.bbsView(seq);
			
			return bbsView;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	// 글쓰기
	public void bbsWrite(Bbs bbsWrite){
		
		try{
			bbsDao.bbsWrite(bbsWrite);
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	// 비밀 번호 체크
	public int bbsPasswordCheck(Bbs bbs){	
		
		try{
			int passCon = bbsDao.bbsPasswordCheck(bbs);
			return passCon;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
		
	}
	
	// 글 수정
	public void bbsModify(Bbs bbs){
		try{
			bbsDao.bbsModify(bbs);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// 글 삭제
	public void bbsDelete(Bbs bbs){
		try{
			bbsDao.bbsDelete(bbs);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// 답변 쓰기
	public void bbsReply(Bbs bbs){
		try{
			bbsDao.bbsReply(bbs);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
}
