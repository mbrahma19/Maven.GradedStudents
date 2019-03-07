package io.zipcoder;

import java.util.*;

public class Classroom {

    private Student[] studentList;
    private int maxNumberOfStudents;
    private Map<Student,String> gradebook;

    public Classroom() {
        studentList = new Student[30];
        this.maxNumberOfStudents = 30;
        this.gradebook = new HashMap<>();
    }

    public Classroom(int maxNumberOfStudents) {
        studentList = new Student[maxNumberOfStudents];
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.gradebook = new HashMap<>();
    }

    public Classroom(Student[] students) {
        studentList = students;
        maxNumberOfStudents = students.length;
        this.gradebook = new HashMap<>();
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

    public Map<Student,String> gradeBook(){
        return gradebook;
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

    public String getGradebook(){
        Arrays.sort(studentList, new StudentComparator());
        returnBPercentile(0.0, .1, "A");
        returnBPercentile(0.1, .3, "B");
        returnBPercentile(0.3, .5, "C");
        returnBPercentile(0.5, .9, "D");
        returnBPercentile(0.9, 1.0, "F");
        return printGradeMap();
    }

    private String printGradeMap(){
        String result = "GradeBook\n";
        for(Map.Entry<Student,String> entry : gradebook.entrySet()){
            result += String.format("\t%s %s: %s\n",entry.getKey().getFirstName(),entry.getKey().getLastName(),entry.getValue());
        }
        return result;
    }

    public void returnBPercentile(Double start, Double stop, String grade){
        Integer stopPos = (int) (studentList.length * stop);
        Integer startPos = (int) (studentList.length * start);
        for(int i = startPos; i < stopPos ;i++){
            Student currStudent = studentList[i];
            gradebook.put(currStudent,grade);
        }

    }
}

