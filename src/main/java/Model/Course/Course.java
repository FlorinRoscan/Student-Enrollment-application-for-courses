package Model.Course;

import java.time.LocalDate;
import java.util.Objects;

public class Course {
    private int courseId;
    private String courseName;
    private double priceCourse;
    private LocalDate startDate;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getPriceCourse() {
        return priceCourse;
    }

    public void setPriceCourse(double priceCourse) {
        this.priceCourse = priceCourse;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Course(int courseId, String courseName, double priceCourse, LocalDate startDate) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.priceCourse = priceCourse;
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return getCourseId() == course.getCourseId() && Double.compare(course.getPriceCourse(), getPriceCourse()) == 0 && Objects.equals(getCourseName(), course.getCourseName()) && Objects.equals(getStartDate(), course.getStartDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseId(), getCourseName(), getPriceCourse(), getStartDate());
    }

    @Override
    public String toString() {
        return courseId + "," + courseName + "," + priceCourse + "," + startDate;
    }

}

