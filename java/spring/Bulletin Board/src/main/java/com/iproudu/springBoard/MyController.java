package com.iproudu.springBoard;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ComponentScan("com.iproudu.springBoard")
public class MyController 
{
	Command command = new Command();
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) 
	{
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")
	public String list(Model model) 
	{
		System.out.println("list()");		
		command.list(model);
		
		return "list";
	}
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) 
	{
		System.out.println("content_view()");		
		
		model.addAttribute("request", request);
		command.contentView(model);
		
		return "content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) 
	{
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command.modify(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) 
	{
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command.write(model);		
		
		return "redirect:list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) 
	{
		System.out.println("write_view()");
		
		return "write_view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) 
	{
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command.delete(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) 
	{
		System.out.println("reply()");
		
		model.addAttribute("request", request);
		command.reply(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		command.replyView(model);
		
		return "reply_view";
	}
	
	
}
