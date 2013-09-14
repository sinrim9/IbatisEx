package frog.bbs.persistence;

import java.util.List;

import frog.bbs.domain.Bbs;

public interface BbsDao {
	
	// �α��� Dao Interface
	public Bbs login(Bbs bbs);
	
	// �Խñ� ����Ʈ ���� Dao Interface
	public List bbsList();
	
	// �Խñ� �� ���� Dao Interface
	public Bbs bbsView(String seq);
	
	// �۾��� Dao Interface
	public void bbsWrite(Bbs bbsWrite);
	
	// ��� ��ȣ üũ Dao Interface
	public int bbsPasswordCheck(Bbs bbs);
	
	// �� ���� Dao Interface
	public void bbsModify(Bbs bbs);
	
	// �� ���� Dao Interface
	public void bbsDelete(Bbs bbs);
	
	// �亯 �ޱ� Dao Interface
	public void bbsReply(Bbs bbs);

}
