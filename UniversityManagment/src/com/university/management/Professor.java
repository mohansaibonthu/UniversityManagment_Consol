package com.university.management;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	private String name;
	private List<Course>assignedCourses;
	
	
	public Professor(String name) {
		this.name = name;
		this.assignedCourses=new ArrayList<>();
	}
	
	 public void assignCourse(Course course) {
	        // Check if the course is not already in the list of assigned courses
	        if (!assignedCourses.contains(course)) {
	            assignedCourses.add(course); // Add the course to the list if not already present
	        }
	    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Course> getAssignedCourses() {
		return assignedCourses;
	}


	public void setAssignedCourses(List<Course> assignedCourses) {
		this.assignedCourses = assignedCourses;
	}


	@Override
	public String toString() {
		return "Professor : "+name ;
	}
	
	
	
	

}
