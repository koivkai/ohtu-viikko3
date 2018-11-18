/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Kaius
 */
public class CourseDirectory {
    ArrayList<Course> courses;

    public CourseDirectory() {
        courses = new ArrayList<Course>();
    }
    
    public Course FindCourse(String name) {
        Course found = null;
        for (Course c:courses) {
            if(c.getName() == name) {
                found = c;
            }
        }
        return found;
    }
    
    public String FindFullCourseName(String name) {
        Course found = null;
        for (Course c:courses) {
            if(c.getName().equals(name)) {
                found = c;
            }
        }
        if(found == null) {
            return "Course not found";
        }
        return found.getFullName();
    }
    
    public void addCourse(Course c) {
        courses.add(c);     
    }
    
    public void PrintCourses() {
        for(Course c:courses) {
            System.out.println(c);
        }
    }
    
    public int GetTotalExercisesInCourse (String courseName) {
        Course found = null;
        for (Course c:courses) {
            if(c.getName().equals(courseName)) {
                found = c;
            }
        }
        if(found == null) {
            return 0;
        }
        return found.getNumberOfExercises();
    }
}
