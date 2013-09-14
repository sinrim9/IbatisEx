package frog.bbs.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.WebUtils;

import frog.bbs.domain.Bbs;
import frog.bbs.service.BbsService;

public class IndexController extends MultiActionController{
	
	private BbsService bbsService;
	private String successView;
	public void setBbsService(BbsService bbsService) {
		this.bbsService = bbsService;
	}

	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}
	// �α���
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		
		Bbs bbs = new Bbs();
		
		ModelAndView mav = new ModelAndView();
		
		if(request.getParameter("userId")!=null){
			bbs.setUserId(request.getParameter("userId"));
			bbs.setPassword(request.getParameter("password"));
			
			bbs = bbsService.login(bbs);
			
			if(bbs != null){
				
				System.out.println("session:"+WebUtils.getSessionAttribute(request, "user"));
				System.out.println("bbs1:"+bbs);
				System.out.println("bbs2:"+bbs.getUserId());
				System.out.println("bbs3:"+bbs.getPassword());
				
				
				WebUtils.setSessionAttribute(request, "user", bbs);
				
				//HttpSession session = request.getSession();
				//session.setAttribute("userId", bbs.getUserId());
				
				//System.out.println("userId:"+session.getAttribute("userId"));
				
				//return new ModelAndView(new RedirectView("/test/bbsList.frog"),"user",bbs);
				return new ModelAndView(new RedirectView("/TestSpring/bbsList.frog"));
				
			}
			
			mav.setViewName("login");
			
			return mav;
		}		
		
		
		
		mav.setViewName("login");
		
		return mav;
	}
	
	// �� ����Ʈ ���
	public ModelAndView bbsList(HttpServletRequest request, HttpServletResponse response){
		
		ArrayList bbsList = bbsService.bbsList();
		
		// �α��� üũ
		/*if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}*/
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("bbsList", bbsList);
		mav.setViewName("bbsList");
		
		return mav;
	}
	
	// �� �� ����
	public ModelAndView bbsView(HttpServletRequest request, HttpServletResponse response){
		
		Bbs bbsView = null;
		
		// �α��� üũ
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		bbsView = bbsService.bbsView(request.getParameter("seq"));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bbsView",bbsView);
		mav.setViewName("bbsView");
		
		return mav;
	}
	// �� ����  ���ε�
	public ModelAndView bbsWriteForm(HttpServletRequest request, HttpServletResponse response){
		
		// �α��� üũ
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bbsWrite");
		return mav;
	}
	// �� ����
	public ModelAndView bbsWrite(HttpServletRequest request, HttpServletResponse response){
		
		// �α��� üũ
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		Bbs bbsWrite = new Bbs();		
		
		bbsWrite.setName(request.getParameter("name"));		
		bbsWrite.setTitle(request.getParameter("title"));
		bbsWrite.setDescription(request.getParameter("description"));
		bbsWrite.setUserId(request.getParameter("userId"));
		
		//bbsWrite.setPassword(request.getParameter("password"));
		
		bbsService.bbsWrite(bbsWrite);
		
		return new ModelAndView(new RedirectView("/TestSpring/bbsList.frog"));
		 
	}
	
	// �� ���� �� �ε�
	public ModelAndView bbsModifyForm(HttpServletRequest request, HttpServletResponse response){
		
		// �α��� üũ
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		Bbs bbsModifyForm = null;
		// �۹�ȣ
		String seq = request.getParameter("seq");
		// value : modify(����), delete(����)
		//String condition = request.getParameter("condition");
		System.out.println("seq start:"+seq);
		bbsModifyForm = bbsService.bbsView(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bbsModifyForm",bbsModifyForm);
		mav.addObject("condition","modify");
		mav.setViewName("bbsWrite");
		
		return mav;
	}
	
	// �� ���� �Ϸ�
	public ModelAndView bbsModify(HttpServletRequest request, HttpServletResponse response){
		
		// �α��� üũ
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		Bbs bbs = new Bbs();
		
		// �� ���� �� ��й�ȣ�� ���� üũ�� �� ���� ������� Update�� ó������ �ʰ� Return
		/*
		bbs.setSeq(new Integer(request.getParameter("seq")));
		bbs.setPassword(request.getParameter("password"));
		
		// 0�� ��� ��й�ȣ ���� Return , 1�� ��� ó��
		int passCon = bbsService.bbsPasswordCheck(bbs);
		
		ModelAndView mav = new ModelAndView();
		
		if(passCon == 0){
			System.out.println("����");			
			mav.addObject("seq", bbs.getSeq());
			mav.setViewName("passwordFail");
			
			return mav;
		}else if(passCon == 1){
			System.out.println("����");
			
			bbs.setTitle(request.getParameter("title"));
			bbs.setDescription(request.getParameter("description"));
			
			bbsService.bbsModify(bbs);

			return new ModelAndView(new RedirectView("/test/bbsView.frog?seq="+bbs.getSeq()));
		}
		*/
		bbs.setSeq(new Integer(request.getParameter("seq")));
		bbs.setTitle(request.getParameter("title"));
		bbs.setDescription(request.getParameter("description"));
		
		bbsService.bbsModify(bbs);
		
		return new ModelAndView(new RedirectView("/TestSpring/bbsView.frog?seq="+bbs.getSeq()));
	}
	
	// �� ���� �� �ε�
	public ModelAndView bbsDeleteForm(HttpServletRequest request, HttpServletResponse response){
		
		// �α��� üũ
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("bbsDeleteForm",request.getParameter("seq"));
		mav.setViewName("bbsDelete");
		
		return mav;
		
	}
	
	// �� ����
	public ModelAndView bbsDelete(HttpServletRequest request, HttpServletResponse response){
		
		// �α��� üũ
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		Bbs bbs = new Bbs();
		
		// �� ���� �� ��й�ȣ�� ���� üũ�� �� ���� ������� Delete�� ó������ �ʰ� Return
		bbs.setSeq(new Integer(request.getParameter("seq")));
		//bbs.setPassword(request.getParameter("password"));
		
		// 0�� ��� ��й�ȣ ���� Return , 1�� ��� ó��
		//int passCon = bbsService.bbsPasswordCheck(bbs);
		
		ModelAndView mav = new ModelAndView();
		/*
		if(passCon == 0){
			System.out.println("����");			
			mav.addObject("seq", bbs.getSeq());
			mav.setViewName("passwordFail");
			
			return mav;
		}else if(passCon == 1){
		*/
			System.out.println("����");
			
			bbsService.bbsDelete(bbs);

			return new ModelAndView(new RedirectView("/TestSpring/bbsList.frog"));
		//}
		//return null;
	}
	
	// �亯 �ޱ� �� �ε�
	public ModelAndView bbsReplyForm(HttpServletRequest request, HttpServletResponse response){
		
		// �α��� üũ
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		Bbs bbsReply = new Bbs();
		
		//Root �� ������ �����´�.
		bbsReply = bbsService.bbsView(request.getParameter("seq"));
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("bbsReplyForm", bbsReply);
		mav.addObject("condition","reply");
		mav.setViewName("bbsWrite");
		
		return mav;
	}
	
	// �亯 �ޱ�
	public ModelAndView bbsReply(HttpServletRequest request, HttpServletResponse response){
		
		// �α��� üũ
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		Bbs bbsReply = new Bbs();
		
		bbsReply.setSeq(new Integer(request.getParameter("seq")));
		bbsReply.setName(request.getParameter("name"));
		bbsReply.setTitle(request.getParameter("title"));
		bbsReply.setDescription(request.getParameter("description"));
		//bbsReply.setPassword(request.getParameter("password"));
		bbsReply.setUserId(request.getParameter("userId"));
		
		bbsService.bbsReply(bbsReply);
		
		return new ModelAndView(new RedirectView("/TestSpring/bbsList.frog"));
		
	}
	
	

}
