package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Classroom {

    private Student[] studentList;
    private int maxNumberOfStudents;

    public Classroom() {
        studentList = new Student[30];
        this.maxNumberOfStudents = 30;
    }

    public Classroom(int maxNumberOfStudents) {
        studentList = new Student[maxNumberOfStudents];
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Classroom(Student[] students) {
        studentList = students;
        maxNumberOfStudents = students.length;
    }

    public Integer getClassroomSize() {
        return studentList.length;
    }

    public Student[] getStudents() {
        return this.studentList;
    }

    public Double getAverageExamScore() {
        return (getAllPoints() == 0) ? 0.0 : Math.round((getAllPoints() / getNumberOfTests()) * 100) / 100.0;
    }

    public Double getAllPoints() {
        Double result = 0.0;
        for (Student s : studentList) {
            result += s.getTotalScore();
        }
        return Math.round(result * 100) / 100.0;
    }

    public Integer getNumberOfTests() {
        Integer result = 0;
        for (Student s : studentList) {
            result += s.getNumberOfExamsTaken();
        }
        return result;
    }

    public void add(Student s) throws IllegalArgumentException {
        ArrayList<Student> newArrayList = new ArrayList(Arrays.asList(studentList));
        if (!newArrayList.contains(null) && newArrayList.size() == maxNumberOfStudents) {
            throw new IllegalArgumentException("Error: Not enough space");
        } else if (newArrayList.contains(null)) {
            newArrayList.remove(null);
            newArrayList.add(s);
        }
        studentList = newArrayList.toArray(new Student[newArrayList.size()]);
    }


    public void remove(String firstName, String lastName) {
        ArrayList<Student> newArrayList = new ArrayList(Arrays.asList(studentList));
        Student sToRemove = null;
        for (Student s : newArrayList) {
            if (s.getLastName().equals(lastName) && s.getFirstName().equals(firstName)) {
                sToRemove = s;
            }
        }
        newArrayList.remove(sToRemove);
        newArrayList.add(null);
        studentList = newArrayList.toArray(new Student[newArrayList.size()]);
    }
}

