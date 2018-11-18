/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author Kaius
 */
public class Course {
    
    private String name;
    
    private String fullName;
    
    private int[] exercises;

    public Course() {
        name = "";
        fullName = "";
        exercises = new int[100];
    }

    public Course(String name, String fullName, int[] exercises) {
        this.name = name;
        this.fullName = fullName;
        this.exercises = exercises;
    }

    
    
    public int[] getExercises() {
        return exercises;
    }
    
    public int getNumberOfExercises() {
        int exercisesInCourse = 0;
        
        for(int i = 0; i < exercises.length; i++) {
            exercisesInCourse += exercises[i];
        }
        
        return exercisesInCourse;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" + "name=" + name + ", fullName=" + fullName + ", exercises=" + exercises + '}';
    }
    
    

}
