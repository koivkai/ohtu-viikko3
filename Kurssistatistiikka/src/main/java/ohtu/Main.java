package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String studentStatsUrl = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";
        String studentInfoBodyText = Request.Get(studentStatsUrl).execute().returnContent().asString();
        
        String coursesUrl = "https://studies.cs.helsinki.fi/courses/courseinfo";
        String courseInfoBodytext = Request.Get(coursesUrl).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println(studentInfoBodyText );
        
        System.out.println("courses json date");
        System.out.println(courseInfoBodytext);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(studentInfoBodyText, Submission[].class);
        Course[] courses = mapper.fromJson(courseInfoBodytext, Course[].class);
        
        System.out.println("Oliot:");
        for (Submission submission : subs) {
            System.out.println(submission);
        }
        
        System.out.println("");
        
        Student s = new Student(studentNr); 
        for (Submission submission : subs) {
            s.AddSubmission(submission);
        }
        
        System.out.println(s);
        
        CourseDirectory dir = new CourseDirectory();
        for (Course c : courses) {
            dir.addCourse(c);
        }
        
        s.PrintStats(dir);
        
        

    }
}