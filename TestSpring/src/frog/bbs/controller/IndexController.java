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
	// 로그인
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
	
	// 글 리스트 출력
	public ModelAndView bbsList(HttpServletRequest request, HttpServletResponse response){
		
		ArrayList bbsList = bbsService.bbsList();
		
		// 로그인 체크
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
	
	// 글 상세 보기
	public ModelAndView bbsView(HttpServletRequest request, HttpServletResponse response){
		
		Bbs bbsView = null;
		
		// 로그인 체크
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
	// 글 쓰기  폼로드
	public ModelAndView bbsWriteForm(HttpServletRequest request, HttpServletResponse response){
		
		// 로그인 체크
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bbsWrite");
		return mav;
	}
	// 글 쓰기
	public ModelAndView bbsWrite(HttpServletRequest request, HttpServletResponse response){
		
		// 로그인 체크
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
	
	// 글 수정 폼 로드
	public ModelAndView bbsModifyForm(HttpServletRequest request, HttpServletResponse response){
		
		// 로그인 체크
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		Bbs bbsModifyForm = null;
		// 글번호
		String seq = request.getParameter("seq");
		// value : modify(수정), delete(삭제)
		//String condition = request.getParameter("condition");
		System.out.println("seq start:"+seq);
		bbsModifyForm = bbsService.bbsView(seq);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("bbsModifyForm",bbsModifyForm);
		mav.addObject("condition","modify");
		mav.setViewName("bbsWrite");
		
		return mav;
	}
	
	// 글 수정 완료
	public ModelAndView bbsModify(HttpServletRequest request, HttpServletResponse response){
		
		// 로그인 체크
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		Bbs bbs = new Bbs();
		
		// 글 수정 전 비밀번호를 먼저 체크한 뒤 맞지 않을경우 Update를 처리하지 않고 Return
		/*
		bbs.setSeq(new Integer(request.getParameter("seq")));
		bbs.setPassword(request.getParameter("password"));
		
		// 0일 경우 비밀번호 오류 Return , 1일 경우 처리
		int passCon = bbsService.bbsPasswordCheck(bbs);
		
		ModelAndView mav = new ModelAndView();
		
		if(passCon == 0){
			System.out.println("실패");			
			mav.addObject("seq", bbs.getSeq());
			mav.setViewName("passwordFail");
			
			return mav;
		}else if(passCon == 1){
			System.out.println("성공");
			
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
	
	// 글 삭제 폼 로드
	public ModelAndView bbsDeleteForm(HttpServletRequest request, HttpServletResponse response){
		
		// 로그인 체크
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
	
	// 글 삭제
	public ModelAndView bbsDelete(HttpServletRequest request, HttpServletResponse response){
		
		// 로그인 체크
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		Bbs bbs = new Bbs();
		
		// 글 삭제 전 비밀번호를 먼저 체크한 뒤 맞지 않을경우 Delete를 처리하지 않고 Return
		bbs.setSeq(new Integer(request.getParameter("seq")));
		//bbs.setPassword(request.getParameter("password"));
		
		// 0일 경우 비밀번호 오류 Return , 1일 경우 처리
		//int passCon = bbsService.bbsPasswordCheck(bbs);
		
		ModelAndView mav = new ModelAndView();
		/*
		if(passCon == 0){
			System.out.println("실패");			
			mav.addObject("seq", bbs.getSeq());
			mav.setViewName("passwordFail");
			
			return mav;
		}else if(passCon == 1){
		*/
			System.out.println("성공");
			
			bbsService.bbsDelete(bbs);

			return new ModelAndView(new RedirectView("/TestSpring/bbsList.frog"));
		//}
		//return null;
	}
	
	// 답변 달기 폼 로드
	public ModelAndView bbsReplyForm(HttpServletRequest request, HttpServletResponse response){
		
		// 로그인 체크
		if(WebUtils.getSessionAttribute(request, "user")!= null){
			WebUtils.getSessionAttribute(request, "user");
		}else{
			return new ModelAndView(new RedirectView("/TestSpring/login.frog"));
		}
		
		Bbs bbsReply = new Bbs();
		
		//Root 글 내용을 가져온다.
		bbsReply = bbsService.bbsView(request.getParameter("seq"));
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("bbsReplyForm", bbsReply);
		mav.addObject("condition","reply");
		mav.setViewName("bbsWrite");
		
		return mav;
	}
	
	// 답변 달기
	public ModelAndView bbsReply(HttpServletRequest request, HttpServletResponse response){
		
		// 로그인 체크
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
