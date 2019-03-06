package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    /**
     * Fields in the Student class
     *
     */
    private String firstName;
    private String lastName;
    private List<Double> examScores;

    /**
     * Nullary constructor which sets the default values
     */
    public Student(){
        this("Marshilla","Brahma", new Double[0]);
    }

    /**
     * Constructor which takes in 3 parameters
     * @param firstName
     * @param lastName
     * @param examScores
     */

    public Student(String firstName, String lastName, Double[] examScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList(Arrays.asList(examScores));
    }

    /**
     * Method to retrieve String first name
     * @return firstName
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     *  Method to set String first name
     * @param firstName
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *  Method to retrieve String last name
     * @return lastName
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * Method to set String last name
     * @param lastName
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method returns the number of exams taken by the Student
     * @return
     */

    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }

    /**
     * Adds an exam score to the existing exam score list
     * @param examScore
     */

    public void addExamScore(Double examScore){examScores.add(examScore);}

    /**
     * Retrieves the exam score at the specified index
     * @param index
     * @return
     */

    public Double getExamScore(Integer index){return examScores.get(index);}

    /**
     *  Sets the exam score at the specified index with the new exam score provided
     * @param examIndex
     * @param newExamScore
     */

    public void setExamScore(int examIndex, double newExamScore){
        examScores.remove(examIndex);
        examScores.add(examIndex,newExamScore);
    }

    /**
     * Returns the average score which the student has from the existing list of exam scores
     * @return
     */
    public Double getAverageExamScore(){
        return (examScores.size() == 0) ? 0.0 : Math.round(getTotalScore()/examScores.size());
    }

    /**
     * Returns the total amount of points the student has accumalated. Calculated by adding all the exam scores.
     * @return
     */
    private Double getTotalScore(){
        Double result = 0.0;
        for(Double d : examScores){
            result += d;
        }
        return result;
    }

    /**
     * Returns the string format of the Student object
     * @return
     */
    @Override
    public String toString() {
        return String.format("Student Name: %s %s\n>Average Score: %.1f\n>%s",firstName, lastName,getAverageExamScore(),getExamScores());
    }

    /**
     * Returns the string format of the exam scores
     * @return
     */
    //TODO : reduce the number lines of code
    public String getExamScores() {
        String result = "Exam Scores:\n";
        int i = 1;
        for(Double d : examScores){
            if(d == null){
                result += String.format("       Exam %d -> null\n", i);
                i++;
            }else {
                result += String.format("       Exam %d -> %.2f\n", i, d);
                i++;
            }
        }
        return result;
    }


}
