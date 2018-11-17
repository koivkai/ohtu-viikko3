package ohtu;

import java.util.ArrayList;

public class Student {
    
    private ArrayList<Submission> submissions;
    private String studentNumber;

    public Student(String studentNumber) {
        this.studentNumber = studentNumber;
        submissions = new ArrayList<Submission>();
    }
    
    
    public void AddSubmission(Submission sub) {
        submissions.add(sub);
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
    
    
}
