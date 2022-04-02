package lesson9;

public class CourseImpl implements Course {
    private String courseName;

    public CourseImpl(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }
}
