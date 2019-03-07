package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void nullaryConstructorTest(){
        //given
        Classroom classroom = new Classroom();
        Integer expectedClassSize = 30;
        //when
        Integer actualClassSize = classroom.getClassroomSize();
        //then
        Assert.assertEquals(expectedClassSize,actualClassSize);
    }

    @Test
    public void constructorWithArrayInputTest(){
        //given
        Integer expectedClassSize = 25;
        Classroom classroom = new Classroom(expectedClassSize);
        //when
        Integer actualClassSize = classroom.getClassroomSize();
        //then
        Assert.assertEquals(expectedClassSize,actualClassSize);
    }

    @Test
    public void constructorWithIntInput(){
        //given
        Integer expectedClassSize = 9;
        Classroom classroom = new Classroom(new Student[]{
                new Student(),new Student(),new Student(),
                new Student(),new Student(),new Student(),
                new Student(),new Student(),new Student()
        });
        //when
        Integer actualClassSize = classroom.getClassroomSize();
        //then
        Assert.assertEquals(expectedClassSize,actualClassSize);
    }

    @Test
    public void getStudentsTest(){
        //given
        Student[] students = new Student[]{
                new Student("M","B", new Double[]{100.0, 97.0,}),
                new Student("D","P", new Double[]{88.5, 67.0,}),
                new Student("C", "W", new Double[]{78.9, 97.5,84.2,67.8})
        };
        //when
        Classroom classroom = new Classroom(students);
        Student[] actualStudents = classroom.getStudents();
        //then
        Assert.assertEquals(students,actualStudents);
    }

    @Test
    public void getStudentsTestWithNull(){
        //given
        Student[] students = new Student[]{null, null, null, null,null};
        //when
        Classroom classroom = new Classroom(students);
        Student[] actualStudents = classroom.getStudents();
        //then
        Assert.assertEquals(students,actualStudents);
    }

    @Test
    public void getAllPointsTest(){
        //given
        Double expectedNumberOfPoints = 680.9;
        Student[] students = new Student[]{
                new Student("M","B", new Double[]{100.0, 97.0,}),
                new Student("D","P", new Double[]{88.5, 67.0,}),
                new Student("C", "W", new Double[]{78.9, 97.5, 84.2, 67.8})
        };
        //when
        Classroom classroom = new Classroom(students);
        Double actualNumberOfPoints = classroom.getAllPoints();
        //then
        Assert.assertEquals(expectedNumberOfPoints,actualNumberOfPoints);
    }

    @Test
    public void getNumberOfAllTestsTest(){
        //given
        Integer expectedNumberOfTest = 8;
        Student[] students = new Student[]{
                new Student("M","B", new Double[]{100.0, 97.0,}),
                new Student("D","P", new Double[]{88.5, 67.0,}),
                new Student("C", "W", new Double[]{78.9, 97.5, 84.2, 67.8})
        };
        //when
        Classroom classroom = new Classroom(students);
        Integer actualNumberOfTest = classroom.getNumberOfTests();
        //then
        Assert.assertEquals(expectedNumberOfTest,actualNumberOfTest);
    }

    @Test
    public void getAverageTestScore(){
        //given
        Double expectedNumberOfTest = 85.11;
        Student[] students = new Student[]{
                new Student("M","B", new Double[]{100.0, 97.0,}),
                new Student("D","P", new Double[]{88.5, 67.0,}),
                new Student("C", "W", new Double[]{78.9, 97.5, 84.2, 67.8})
        };
        //when
        Classroom classroom = new Classroom(students);
        Double actualNumberOfTest = classroom.getAverageExamScore();
        //then
        Assert.assertEquals(expectedNumberOfTest,actualNumberOfTest);
    }

    @Test
    public void getAverageTestScoreWhenNoTestsTest(){
        //given
        Double expectedAverage = 0.0;
        Student[] students = new Student[]{
                new Student("M","B", new Double[0]),
                new Student("D","P", new Double[0]),
                new Student("C", "W", new Double[0])
        };
        //when
        Classroom classroom = new Classroom(students);
        Double actualNumberOfTest = classroom.getAverageExamScore();
        //then
        Assert.assertEquals(expectedAverage,actualNumberOfTest);
    }


    @Test
    public void addStudent(){
        // Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        classroom.add(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        Assert.assertEquals(student,postEnrollment[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addStudentNotEnoughSpace() {
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        classroom.add(student);
        classroom.add(student);
    }

    @Test
    public void addStudent3(){
        // Given
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        Double[] examScores2 = { 120.0, 100.0, 150.0, 98.0 };
        Student student2 = new Student("Marci", "Brahma", examScores2);
        Classroom classroom = new Classroom(new Student[]{student, student2});
        // When
        classroom.remove("Leon","Hunter");
        classroom.add(student2);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        Assert.assertEquals(student2,postEnrollment[1]);
    }

    @Test
    public void removeStudent(){
        // Given
        int maxNumberOfStudents = 1;
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        Classroom classroom = new Classroom(new Student[]{student});
        // When
        classroom.remove("Leon", "Hunter");
        Student[] postEnrollment = classroom.getStudents();

        // Then
        Assert.assertNull(postEnrollment[0]);
    }

    @Test
    public void removeStudent2(){
        // Given
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        Double[] examScores2 = { 120.0, 100.0, 150.0, 98.0 };
        Student student2 = new Student("Marci", "Brahma", examScores2);

        Classroom classroom = new Classroom(new Student[]{student,student2});
        // When
        classroom.remove("Leon", "Hunter");
        Student[] postEnrollment = classroom.getStudents();

        // Then
        Assert.assertNull(postEnrollment[1]);
    }

    @Test
    public void sortStudents(){
        //given
        Student s1 = new Student("M","B", new Double[]{100.0, 150.0, 250.0, 0.0 });
        Student s2 = new Student("D","P", new Double[]{120.0, 200.0, 150.0, 198.0});
        Student s3 = new Student("C", "W", new Double[]{0.0, 100.0, 250.0, 40.0});

        Student[] expected = new Student[]{s2,s1,s3};
        //when
        Classroom classroom = new Classroom(new Student[]{s3,s1,s2});
        Arrays.sort(classroom.getStudents(), new StudentComparator());
        Student[] actual = classroom.getStudents();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sortStudentsWithSameGrade(){
        //given
        Student s1 = new Student("M","B", new Double[]{100.0, 150.0, 250.0, 0.0 });
        Student s2 = new Student("D","P", new Double[]{100.0, 150.0, 250.0, 0.0 });
        Student s3 = new Student("C", "W", new Double[]{100.0, 150.0, 250.0, 0.0});

        Student[] expected = new Student[]{s3,s2,s1};
        //when
        Classroom classroom = new Classroom(new Student[]{s3,s1,s2});
        Arrays.sort(classroom.getStudents(), new StudentComparator());
        Student[] actual = classroom.getStudents();
        //then
        Assert.assertEquals(expected,actual);
    }


}
