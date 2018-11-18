package ohtu;

import java.util.Arrays;
import java.util.Objects;

public class Submission implements Comparable{
    private int week;
    private int hours;
    private String course;
    private int[] exercises;

    public int[] getExercises() {
        return exercises;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }

    

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }
    
    public int getNumberOfExercises() {
        return exercises.length;
    }
    
    private String exercisesString() {
        String s = "[";
        for (int i = 0; i<exercises.length;i++) {
            s += exercises[i];
            if (!(i == exercises.length - 1)) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }

    @Override
    public String toString() {
        return"Course: " +course + " Week: "+week+  " hours used:" + hours + "Exercises done: " + exercisesString();
        //return "weeks "+week + " hours " + hours + " course " +course + exercisesString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.week;
        hash = 37 * hash + this.hours;
        hash = 37 * hash + Objects.hashCode(this.course);
        hash = 37 * hash + Arrays.hashCode(this.exercises);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Submission other = (Submission) obj;
        if (this.week != other.week) {
            return false;
        }
        if (this.hours != other.hours) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Arrays.equals(this.exercises, other.exercises)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        Submission s = (Submission) o;
        
        int jarjestys = this.course.compareTo(s.getCourse());
        
        if (jarjestys == 0) {
            return Integer.compare(week, s.getWeek());
        }
        
        return jarjestys;
    }
    
}