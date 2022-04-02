package lesson9;


import java.util.*;

public class App_lesson9 {
    public static void main(String[] args) {
        List<Student> studentsList = createStudentsList();

        System.out.println("***************--1--***************");

        //Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты
        var courses = getCourseList(studentsList);
        courses.stream().map(c->c.getCourseName()).forEach(System.out::println);

        System.out.println("***************--2--***************");

        //Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов)
        var std = get3Students(studentsList);
        std.stream().map(s->s.getName()).forEach(System.out::println);

        System.out.println("***************--3--***************");

        //Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс
        var stdCourse = getStdCourse(studentsList,MATH);
        stdCourse.stream().map(s->s.getName()).forEach(System.out::println);
    }

    private static List<Course> getCourseList(List<Student> students) {
        return new ArrayList<>(
                students.stream()
                        .map(s -> new HashSet<>(s.getAllCourses()))
                        .reduce((courses1, courses2) -> {
                            HashSet<Course> list = new HashSet<>(courses1);
                            list.addAll(courses2);
                            return list;
                        }).get()
        );
    }

    private  static List<Student> get3Students(List<Student> students){
        return students.stream()
                        .sorted(Comparator.comparingInt(o -> -o.getAllCourses().size()))
                .limit(3)
                .toList();
    }

    private static List<Student> getStdCourse(List<Student> students, Course course){
        return
                students.stream()
                        .filter(s->s.getAllCourses().contains(course))
                        .toList();

    }


    public static final Course BIOLOGY = new CourseImpl("BIOLOGY");
    public static final Course DRAWING = new CourseImpl("DRAWING");
    public static final Course CHEMISTRY = new CourseImpl("CHEMISTRY");
    public static final Course GEOMETRY = new CourseImpl("GEOMETRY");
    public static final Course HISTORY = new CourseImpl("HISTORY");
    public static final Course LITERATURE = new CourseImpl("LITERATURE");
    public static final Course PHYSICS = new CourseImpl("PHYSICS");
    public static final Course MATH = new CourseImpl("MATH");
    public static final Course SOCIOLOGY = new CourseImpl("SOCIOLOGY");
    public static final Course MUSIC = new CourseImpl("MUSIC");

    public static List<Student> createStudentsList(){
        return new ArrayList<Student>(Arrays.asList(
                new StudentImpl("Rudolf Schenker", new ArrayList<>(Arrays.asList(BIOLOGY, DRAWING, LITERATURE)) ),
                new StudentImpl("Klaus Meine",new ArrayList<>(Arrays.asList(MATH,GEOMETRY,DRAWING, HISTORY, BIOLOGY, SOCIOLOGY))),
                new StudentImpl("Matthias Jabs",new ArrayList<>(Arrays.asList(CHEMISTRY, HISTORY,MATH,PHYSICS, GEOMETRY))),
                new StudentImpl("Paweł Mąciwoda",new ArrayList<>(Arrays.asList(SOCIOLOGY, MATH))),
                new StudentImpl("Mikkey Dee",new ArrayList<>(Arrays.asList(DRAWING, HISTORY, CHEMISTRY))),
                new StudentImpl("Freddie Mercury",new ArrayList<>(Arrays.asList(SOCIOLOGY, PHYSICS,LITERATURE, HISTORY))),
                new StudentImpl("Brian May",new ArrayList<>(Arrays.asList(BIOLOGY, DRAWING, CHEMISTRY, GEOMETRY, HISTORY, LITERATURE, PHYSICS, MATH, SOCIOLOGY))),
                new StudentImpl("Roger Taylor",new ArrayList<>(Arrays.asList(GEOMETRY, HISTORY, LITERATURE, PHYSICS))),
                new StudentImpl("John Deacon",new ArrayList<>(Arrays.asList(MATH, GEOMETRY, PHYSICS)))
        )
        );
    }
}
