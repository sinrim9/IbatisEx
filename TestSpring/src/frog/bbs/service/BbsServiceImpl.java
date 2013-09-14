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
	
	// �α���
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
	
	// �Խñ� ����Ʈ ���
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
	
	// �Խñ� �� ����
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
	
	// �۾���
	public void bbsWrite(Bbs bbsWrite){
		
		try{
			bbsDao.bbsWrite(bbsWrite);
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	// ��� ��ȣ üũ
	public int bbsPasswordCheck(Bbs bbs){	
		
		try{
			int passCon = bbsDao.bbsPasswordCheck(bbs);
			return passCon;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
		
	}
	
	// �� ����
	public void bbsModify(Bbs bbs){
		try{
			bbsDao.bbsModify(bbs);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// �� ����
	public void bbsDelete(Bbs bbs){
		try{
			bbsDao.bbsDelete(bbs);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// �亯 ����
	public void bbsReply(Bbs bbs){
		try{
			bbsDao.bbsReply(bbs);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
}
