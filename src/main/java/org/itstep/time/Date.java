package org.itstep.time;

import java.util.Objects;

public class Date {
    private final int day;
    private final int month;
    private final int year;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return  day + "/" + month + "/" + year;
    }

}
