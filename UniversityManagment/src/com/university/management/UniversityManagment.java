package com.university.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.university.Exception.CourseNotFoundException;
import com.university.Exception.ProfessorNotFoundException;
import com.university.Exception.StubentNotFoundException;

public class UniversityManagment {
		private List<Student> students;
		private List<Professor>professor;
		private List<Course>course;
		
	public UniversityManagment() {
			students= new ArrayList<>();
			professor=new ArrayList<>();
			course=new ArrayList<>();
			
	}
			
	public void addStubdent(String name) {
		students.add(new Student(name));
	}
	public void addProfessor(String name) {
		professor.add(new Professor(name));
	}
	public void addCrouse(String title) {
		course.add(new Course(title));
	}
	
	public void enrollStudentInCourse(String studentName, String courseTitle) throws StubentNotFoundException, CourseNotFoundException {
	    Student student = findStudentByName(studentName);
	    Course course = findCourseByTitle(courseTitle);

	    if (student == null) {
	        throw new StubentNotFoundException("Student " + studentName + " not found.");
	    }
	    if (course == null) {
	        throw new CourseNotFoundException("Course " + courseTitle + " not found.");
	    }

	    // Add the course to the student's enrolled courses
	    student.getEnrolledCourses().add(course);
	    System.out.println("Enrolled " + studentName + " in course " + courseTitle);
	}

	public void assignCourseToProfessor(String professorName, String courseTitle) throws ProfessorNotFoundException, CourseNotFoundException {
	    Professor professor = findProfessorByName(professorName);
	    Course course = findCourseByTitle(courseTitle);

	    if (professor == null) {
	        throw new ProfessorNotFoundException("Professor " + professorName + " Not Found");
	    }
	    if (course == null) {
	        throw new CourseNotFoundException("Course " + courseTitle + " Not Found");
	    }

	    // Assign the course to the professor
	    professor.assignCourse(course);
	    System.out.println("Assigned course " + courseTitle + " to professor " + professorName);
	}

	public void ListStudent() {
		if(students.isEmpty()){
			System.out.println("No Student are Avalible");
		}else {
			System.out.println("List of Student");
			for(Student student:students) {
				System.out.println(student);
			}
		}
	}
	public void ListProfessor() {
		if(professor.isEmpty()) {
			System.out.println(" Not Professor is Found");
		
		}else {
			System.out.println("List Of Professor");
			for(Professor professor:professor) {
				System.out.println(professor);
			}
		}
	}
	public void ListCouse() {
		if(course.isEmpty()) {
			System.out.println(" Not course is Found");
		
		}else {
			System.out.println("List Of course");
			for(Course course : course) {
				System.out.println(course);
			}
		}
	}
	
	public void displayStudentCourse(String studentName)throws StubentNotFoundException{
		Student student=findStudentByName(studentName);
		
		if(student==null) {
			throw new StubentNotFoundException("Student"+studentName+"Not found");
		}
		System.out.println("Course for Student:"+studentName);
		for(Course course : student.getEnrolledCourses()) {
			System.out.println(course);
		}
		
	}
	public void displayProfessorCourse(String professorName)throws ProfessorNotFoundException{
		Professor professor=findProfessorByName(professorName);
		
		if(professor==null) {
			throw new ProfessorNotFoundException("professor"+professorName+"Not found");
		}
		System.out.println("Course for aaigned for Professor:"+professorName);
		for(Course course : professor.getAssignedCourses()) {
			System.out.println(course);
		}
		
	}
	public Student findStudentByName(String name) {
		for (Student student:students) {
			if(student.getName().equalsIgnoreCase(name)) {
				return student;
			}
		}
		return null;
	}
	public Professor findProfessorByName(String name) {
		for (Professor professor:professor) {
			if(professor.getName().equalsIgnoreCase(name)) {
				return professor;
			}
		}
		return null;
	}
	public Course findCourseByTitle(String title) {
		for (Course course:course) {
			if(course.getTitle().equalsIgnoreCase(title)) {
				return course;
			}
		}
		return null;
	}
	
	
	
	public static void main (String [] args) {
		
		UniversityManagment managment=new UniversityManagment();
		Scanner scan=new Scanner(System.in);
		boolean running=true;
		
		while(running) {
			System.out.println("||==================================================||");
			System.out.println("||       ---University Managment System---          ||");
			System.out.println("||==================================================||");
			System.out.println("||             1.Add Student                        ||");
			System.out.println("||             2.Add Professor                      ||");
			System.out.println("||             3.Add Courses                        ||");
			System.out.println("||             4.Enroll Student in Courses          ||");
			System.out.println("||             5.Assign Course to Professor         ||");
			System.out.println("||             6.List of Student                    ||");
			System.out.println("||             7.List o Professopr                  ||");
			System.out.println("||             8.List of Course                     ||");
			System.out.println("||             9.Display Student Course             ||");
			System.out.println("||             10.Display Professor Course          ||");
			System.out.println("||             11.Exist                             ||");
			System.out.println("||==================================================||");
			int choise = scan.nextInt();
			scan.nextLine();
			
			try {
				switch(choise) {
				case 1:
				System.out.print("Enter Student Name: ");
				String studentName=scan.nextLine();
				managment.addStubdent(studentName);
				break;
				
				case 2:
					System.out.print("Enter Professor Name:  ");
					String professorName=scan.nextLine();
					managment.addProfessor(professorName);
					break;
				case 3:
					System.out.print("Enter Course Title : ");
					String courseTitle=scan.nextLine();
					managment.addCrouse(courseTitle);
					break;
				case 4:
					System.out.print("Enter student name: ");
					String enrollStudent = scan.nextLine();
					System.out.print("Enter course title: ");
					String enrollCourse = scan.nextLine();
					try {
						managment.enrollStudentInCourse(enrollStudent, enrollCourse); 
					} catch (StubentNotFoundException | CourseNotFoundException e) {
						System.out.println(e.getMessage()); 
					}
					break;
				case 5:
					System.out.print("Enter professor name: ");
					String assignProfessor = scan.nextLine();
					System.out.print("Enter course title: ");
					String assignCourse = scan.nextLine();
					try {
						managment.assignCourseToProfessor(assignProfessor, assignCourse); 
					} catch (ProfessorNotFoundException | CourseNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 6:
					managment.ListStudent();
					break;
				case 7:
					managment.ListProfessor();
					break;
				case 8:
					managment.ListCouse();
					break;
				case 9:
					System.out.print("Enter student name: ");
					String displayStudent = scan.nextLine();
					try {
						managment.displayStudentCourse(displayStudent); // Display courses for a student
					} catch (StubentNotFoundException e) {
						System.out.println(e.getMessage()); // Handle exception
					}
					break;

				case 10:
					System.out.print("Enter Professor Name  : ");
					String displayProfessor=scan.nextLine();
					try {
						managment.displayProfessorCourse(displayProfessor);
					}catch(ProfessorNotFoundException e) {
						e.printStackTrace();
					}
					break;
				case 11:
					running = false; 
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 11."); 
																								
					break;		
				}
			}catch(Exception e) {
				System.out.println("An unexpected error occurred: " + e.getMessage());
			}

			}
		}
	}


			
			
			
		
		
		
			



	


