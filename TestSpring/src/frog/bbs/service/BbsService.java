package frog.bbs.service;

import java.util.ArrayList;

import frog.bbs.domain.Bbs;

public interface BbsService {
	
	// �α���
	public Bbs login(Bbs bbs);

	// �Խñ� ����Ʈ ��� Interface
	public ArrayList bbsList();
	
	// �Խñ� �� ���� Interface
	public Bbs bbsView(String seq);
	
	// �۾��� Interface
	public void bbsWrite(Bbs bbsWrite);
	
	// ��� ��ȣ üũ Interface
	public int bbsPasswordCheck(Bbs bbs);
	
	// �� ���� Interface
	public void bbsModify(Bbs bbs);
	
	// �� ���� Interface
	public void bbsDelete(Bbs bbs);
	
	// �亯 ���� Interface
	public void bbsReply(Bbs bbs);
}
