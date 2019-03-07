package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    @Test
    public void nullaryConstructorTest(){
        //given
        String firstName = "Marshilla";
        String lastName = "Brahma";
        Integer numberOfExams = 0;
        //when
        Student newStudent = new Student();
        String actualFirst = newStudent.getFirstName();
        String actualLast = newStudent.getLastName();
        Integer actualNumberoFExams = newStudent.getNumberOfExamsTaken();
        //then
        Assert.assertEquals(firstName,actualFirst);
        Assert.assertEquals(lastName,actualLast);
        Assert.assertEquals(numberOfExams,actualNumberoFExams);
    }

    @Test
    public void constructorTest(){
        //given
        String firstName = "Marci";
        String lastName = "B";
        Integer numberOfExams = 3;
        //when
        Student newStudent = new Student(firstName,lastName,new Double[]{97.8, 92.0, 76.9});
        String actualFirst = newStudent.getFirstName();
        String actualLast = newStudent.getLastName();
        Integer actualNumberOfExams = newStudent.getNumberOfExamsTaken();
        //then
        Assert.assertEquals(firstName,actualFirst);
        Assert.assertEquals(lastName,actualLast);
        Assert.assertEquals(numberOfExams,actualNumberOfExams);
    }

    @Test
    public void getExamScoresTestWithNoScores(){
        //given
        String firstName = "Marci";
        String lastName = "B";
        String expectedExamScores = "Exam Scores:\n";
        //when
        Student newStudent = new Student(firstName,lastName,new Double[0]);
        String actualExamScoresString = newStudent.getExamScores();

        //then
        Assert.assertEquals(expectedExamScores,actualExamScoresString);
    }

    @Test
    public void getExamScoresTestWithNull(){
        //given
        String firstName = "Marci";
        String lastName = "B";
        String expectedExamScores = "Exam Scores:\n" +
                "       Exam 1 -> null\n" +
                "       Exam 2 -> 92.00\n" +
                "       Exam 3 -> null\n";
        //when
        Student newStudent = new Student(firstName,lastName,new Double[]{null, 92.0,null});
        String actualExamScoresString = newStudent.getExamScores();

        //then
        Assert.assertEquals(expectedExamScores,actualExamScoresString);
    }

    @Test
    public void setGetFirstNameTest(){
        //given
        String firstName = "Marci";
        Student newStudent = new Student();
        //when
        newStudent.setFirstName(firstName);
        String actualFirst = newStudent.getFirstName();

        //then
        Assert.assertEquals(firstName,actualFirst);
    }

    @Test
    public void setGetLastNameTest(){
        //given
        String lastName = "B-hama";
        Student newStudent = new Student();
        //when
        newStudent.setLastName(lastName);
        String actualFirst = newStudent.getLastName();

        //then
        Assert.assertEquals(lastName,actualFirst);
    }

    @Test
    public void addExamScoreToEmptyListCheckStringTest(){
        //given
        String firstName = "Marci";
        String lastName = "B";
        String expectedExamScores = "Exam Scores:\n" +
                "       Exam 1 -> 97.80\n";
        //when
        Student newStudent = new Student(firstName,lastName,new Double[0]);
        newStudent.addExamScore(97.80);
        String actualExamScoresString = newStudent.getExamScores();

        //then
        Assert.assertEquals(expectedExamScores,actualExamScoresString);
    }

    @Test
    public void addExamScoreToFilledLitCheckString(){
        //given
        String firstName = "Marci";
        String lastName = "B";
        String expectedExamScores = "Exam Scores:\n" +
                "       Exam 1 -> 97.80\n" +
                "       Exam 2 -> 92.00\n" +
                "       Exam 3 -> 76.90\n" +
                "       Exam 4 -> 100.00\n";;
        //when
        Student newStudent = new Student(firstName,lastName,new Double[]{97.8, 92.0, 76.9});
        newStudent.addExamScore(100.0);
        String actualExamScoresString = newStudent.getExamScores();

        //then
        Assert.assertEquals(expectedExamScores,actualExamScoresString);
    }

    @Test
    public void addExamScoreTestCheckIndex(){
        //given
        String firstName = "Marci";
        String lastName = "B";
        Double expectedExamScores = 100.0;
        //when
        Student newStudent = new Student(firstName,lastName,new Double[]{97.8, 92.0, 76.9});
        newStudent.addExamScore(expectedExamScores);
        Double actualExamScores = newStudent.getExamScore(4);

        //then
        Assert.assertEquals(expectedExamScores,actualExamScores);
    }

    @Test
    public void addExamScoreTestWithNull(){
        //given
        String firstName = "Marci";
        String lastName = "B";
        List<Double> expectedExamList = new ArrayList<>();
        expectedExamList.add(null);
        expectedExamList.add(92.0);
        expectedExamList.add(null);
        String expectedExamScores = "Exam Scores:\n" +
                "       Exam 1 -> null\n" +
                "       Exam 2 -> 92.00\n" +
                "       Exam 3 -> null\n"+
                "       Exam 4 -> null\n";
        //when
        Student newStudent = new Student(firstName,lastName,new Double[]{null, 92.0,null});
        newStudent.addExamScore(null);
        String actualExamScoresString = newStudent.getExamScores();

        //then
        Assert.assertEquals(expectedExamScores,actualExamScoresString);
    }

    @Test
    public void setExamScoreTest(){
        //given
        String firstName = "Marci";
        String lastName = "B";
        String expectedExamScores = "Exam Scores:\n" +
                "       Exam 1 -> 99.00\n" +
                "       Exam 2 -> 92.00\n" +
                "       Exam 3 -> null\n";
        //when
        Student newStudent = new Student(firstName,lastName,new Double[]{null, 92.0,null});
        newStudent.setExamScore(1,99.0);
        String actualExamScoresString = newStudent.getExamScores();

        //then
        Assert.assertEquals(expectedExamScores,actualExamScoresString);
    }

    @Test
    public void getAverageExamScore(){
        //given
        Double expectedAverage = 89.0;
        Student newStudent = new Student("","",new Double[]{97.8, 92.0, 76.9});
        //when
        Double actual = newStudent.getAverageExamScore();
        //then
        Assert.assertEquals(expectedAverage,actual);
    }

    @Test
    public void getAverageExamScoreWhen0(){
        //given
        Student newStudent = new Student();
        Double expectedAverage = 0.0;
        //when
        Double actual = newStudent.getAverageExamScore();
        //then
        Assert.assertEquals(expectedAverage, actual);

    }

    @Test
    public void toStringEmptyStudentTest(){
        //given
        Student newStudent = new Student();
        String expectedToString = "Student Name: Marshilla Brahma\n>Average Score: 0.0\n>Exam Scores:\n";
        //when
        String actualToString = newStudent.toString();
        //then
        Assert.assertEquals(expectedToString,actualToString);
    }

    @Test
    public void toStringStudentWithNoExamsTest(){
        //given
        Student newStudent = new Student("Marci", "Brahma",new Double[0]);
        String expectedToString = "Student Name: Marci Brahma\n>Average Score: 0.0\n>Exam Scores:\n";
        //when
        String actualToString = newStudent.toString();
        //then
        Assert.assertEquals(expectedToString,actualToString);
    }

    @Test
    public void toStringStudentWithExamsTest(){
        Student newStudent = new Student("Marci", "Brahma",new Double[]{100.0, 74.5});
        String expectedToString = "Student Name: Marci Brahma\n>Average Score: 87.0\n>Exam Scores:\n"+
                "       Exam 1 -> 100.00\n" +
                "       Exam 2 -> 74.50\n";
        //when
        String actualToString = newStudent.toString();
        //then
        Assert.assertEquals(expectedToString,actualToString);
    }


}