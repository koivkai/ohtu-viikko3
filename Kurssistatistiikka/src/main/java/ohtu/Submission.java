package ohtu;

public class Submission {
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
    
}