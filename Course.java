package software;
/*   
Author: Chan In Kou
Purpose: A course has a course identifier (ex: CS-120) and a course title (Intro to Computer Science).
*/
public class Course {
	private String courseId;
	private String courseTitle;
	
	Course(String courseIdln, String courseTitleln){
		courseId = courseIdln;
		courseTitle = courseTitleln;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	
	public String toString(){
		return "Course Identifier: " + courseId + ", Course Title: "+ courseTitle;
	}
	

}
