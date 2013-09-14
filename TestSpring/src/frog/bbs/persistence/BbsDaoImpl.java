package frog.bbs.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import frog.bbs.domain.Bbs;

public class BbsDaoImpl extends SqlMapClientDaoSupport implements BbsDao{

	@Override
	public List bbsList(){
		
		return getSqlMapClientTemplate().queryForList("bbsList", null);
	}
	
	@Override
	public Bbs bbsView(String seq){
		
		try{
			getSqlMapClientTemplate().update("bbsHit",seq);
			return (Bbs)getSqlMapClientTemplate().queryForObject("bbsView",seq);
			
		} catch(Exception e){
			return null;
		}		
	}	
	
	public void bbsWrite(Bbs bbsWrite){
		
		getSqlMapClientTemplate().insert("bbsWrite",bbsWrite);
	}
	
	public int bbsPasswordCheck(Bbs bbs){
		
		return (Integer)getSqlMapClientTemplate().queryForObject("bbsPasswordCheck", bbs);		
	}
	
	public void bbsModify(Bbs bbs){		
		
		getSqlMapClientTemplate().update("bbsModify",bbs);
	}
	
	public void bbsDelete(Bbs bbs){		
				
		getSqlMapClientTemplate().delete("bbsDelete",bbs);		
	}
	
	public void bbsReply(Bbs bbs){		
		
		getSqlMapClientTemplate().update("bbsReplySequence", bbs);		
		
		getSqlMapClientTemplate().update("bbsReply",bbs);
	}
	
	@Override
	public Bbs login(Bbs bbs){
		
		return (Bbs)getSqlMapClientTemplate().queryForObject("login", bbs);
	}
}
