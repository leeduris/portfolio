package com.iproudu.springBoard;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class Command
{	
	public void list(Model model) 
	{		
		Dao dao = new Dao();
		ArrayList<Dto>dtos = dao.list();
		
		model.addAttribute("list", dtos);		
	}
	
	public void contentView(Model model) 
	{
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
		Dao dao = new Dao();
		Dto dto = dao.contentView(bId);
		
		model.addAttribute("content_view", dto);		
	}
	
	public void modify(Model model) 
	{		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		Dao dao = new Dao();
		dao.modify(bId, bName, bTitle, bContent);		
	}
	
	public void write(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		Dao dao = new Dao();
		dao.write(bName, bTitle, bContent);		
	}
	
	public void delete(Model model) 
	{		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bid = request.getParameter("bId");
		Dao dao = new Dao();
		dao.delete(bid);		
	}
	
	public void reply(Model model) 
	{
		Map<String , Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent= request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		
		Dao dao = new Dao();
		dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);		
	}
	
	public void replyView(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
		Dao dao = new Dao();
		Dto dto = dao.replyView(bId);
		
		model.addAttribute("reply_view", dto);
		
	}
	
	
	
}
