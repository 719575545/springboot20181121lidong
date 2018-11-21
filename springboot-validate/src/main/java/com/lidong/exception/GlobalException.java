package com.lidong.exception;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

//@ControllerAdvice
@Configuration
public class GlobalException implements HandlerExceptionResolver{
	//第五种异常处理方式
	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		ModelAndView mv=new ModelAndView();
		if(arg3 instanceof NullPointerException) {
			mv.setViewName("error1");
		}
		//if可以写多个进行判断，根据需求跳到不同的处理页面
		mv.addObject("exception", arg3.toString());//第一个参数 页面取异常信息的key值
		return mv;
	}
	/**
	 * 次异常处理方式是创建一个异常处理的全局类，只要抛出异常会自动处理，@ControllerAdvice 与 @Exceptionhander联合使用
	 */
	
	
//	/**
//	 * 异常处理方式一 自定义错误页面
//	 * springboot 有自己的一套异常处理机制，当出现异常的时候，会自动访问/error这一路径，并搜集到异常信息，显示到页面，我们若想自定义异常页面，就需要在templates
//	 * 下新写一个页面，命名为error.html,当出现异常的以后访问到的是我们自定义的页面，
//	 */
//	@RequestMapping("/exceone")
//	public String exceone() {
//		String ss=null;
//		ss.length();
//		return "adduser";
//	}
//	/**
//	 * 异常处理方式二 exceptionhander
//	 */
//	@ExceptionHandler(value= {java.lang.NullPointerException.class})
//	public ModelAndView excetwo(Exception e) {
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("error", e.toString());
//		mv.setViewName("error1");
//		return mv;
//	}
	//以上注释部分是 @ControllerAdvice的使用方式 第四种异常处理方式
//	@Bean
//	public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver() {
//		SimpleMappingExceptionResolver simpleMappingExceptionResolver=new SimpleMappingExceptionResolver();
//		Properties mappings=new Properties();
//		mappings.put("java.lang.NullPointerException", "error1");//第一个参数 异常名  第二个参数 需要跳转的页面
//		simpleMappingExceptionResolver.setExceptionMappings(mappings);
//		return simpleMappingExceptionResolver;
//	}
}
