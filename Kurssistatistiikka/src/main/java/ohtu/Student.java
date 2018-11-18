package ohtu;

import java.util.ArrayList;
import java.util.Collections;

public class Student {
    
    private ArrayList<Submission> submissions;
    private String studentNumber;

    public Student(String studentNumber) {
        this.studentNumber = studentNumber;
        submissions = new ArrayList<Submission>();
    }
    
    
    public void AddSubmission(Submission sub) {
        submissions.add(sub);
        Collections.sort(submissions);
    }
    
    private int getTotalWeeks (){
        int summa = 0;
        for (Submission sub:submissions) {
            summa += sub.getWeek();
        }
        
        return summa;
    }
    
    private int getTotalHours (){
        int summa = 0;
        for (Submission sub:submissions) {
            summa += sub.getHours();
        }
        
        return summa;
    }
    
    private int getTotalExercises (){
        int summa = 0;
        for (Submission sub:submissions) {
            summa += sub.getNumberOfExercises();
        }
        
        return summa;
    }

    @Override
    public String toString() {
        String s = "Studentnumber: " + studentNumber + '\n' + "" + '\n';
        for (Submission sub:submissions) {
            s += sub.toString() + '\n';
        }
        s += "" + '\n';
        s += "Total exercises done: "+ getTotalExercises() + "Total hours: " + getTotalHours();
        return s;
    }
    
    public void PrintStats(CourseDirectory dir) {
        System.out.println("Studentnumber: " + studentNumber);
        
        String currentCourse = "";
        int exercisesDoneForCourse = 0;
        int hoursUsedForCourse = 0;
        for (Submission sub:submissions) {
            if(currentCourse.equals(sub.getCourse())) {
                System.out.println(sub);
                exercisesDoneForCourse += sub.getNumberOfExercises();
                hoursUsedForCourse += sub.getHours();
            } else {
                String fullCourseName = dir.FindFullCourseName(sub.getCourse());
                
                System.out.println("exercises done: " +exercisesDoneForCourse + "/"+ dir.GetTotalExercisesInCourse(sub.getCourse()) + " hours used: " + hoursUsedForCourse);
                
                exercisesDoneForCourse = 0;
                hoursUsedForCourse = 0;
                
                System.out.println("");
                System.out.println(fullCourseName);
                System.out.println("");
                System.out.println(sub);
                currentCourse = sub.getCourse();
                exercisesDoneForCourse += sub.getNumberOfExercises();
                hoursUsedForCourse += sub.getHours();
            }
        }
        System.out.println("exercises done: " +exercisesDoneForCourse + "/"+ dir.GetTotalExercisesInCourse(currentCourse) + " hours used: " + hoursUsedForCourse);

    }
    
    
}
