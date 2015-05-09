package com.pigai.service;

import com.pigai.entity.Courseware;
import com.pigai.util.PageModel;


public interface CoursewareService extends BaseService<Courseware>{
	
public PageModel getPageModel(PageModel pageModel);

}
