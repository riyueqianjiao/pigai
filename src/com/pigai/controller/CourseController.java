package com.pigai.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pigai.service.CourseService;
import com.pigai.util.PageModel;
import com.pigai.vo.CourseCriteria;

@Controller
@RequestMapping(value = "/course")
public class CourseController extends BaseController {

	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;

	@RequestMapping()
	public String toIndex(PageModel pageModel, HttpServletRequest request,
			CourseCriteria criteria) {
		request.setAttribute("pageMoel",
				courseService.getPageModelByCriteria(pageModel, criteria));
		return "course/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toAdd() {
		return "course/add";
	}

}
