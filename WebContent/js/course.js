function delCourse(id){
	deleteData(basePath()+"/course/delete/"+id);
}

function toCoursewares(id){
	goWithUrl(basePath()+"/course/ware/"+id);
}

