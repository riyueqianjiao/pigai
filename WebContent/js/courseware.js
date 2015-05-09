function delCourseware(id){
	deleteData(basePath()+"/courseware/delete/"+id);
}

function toCoursewares(id){
	goWithUrl(basePath()+"/courseware/"+id);
}

