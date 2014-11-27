package javasports;


import java.util.ArrayList;

public class calender {

    int year;
    int month;
    int date;
    String [] message = new String[100];

    calender() {
        this.year = year;
        this.month = month;
        this.date = date;
    }
    
    

    void printMonth(int year, int month) {

        printMonthTitle(year, month);

        printMonthBody(year, month);
    }

    
    void printMonthTitle(int year, int month) {

        System.out.println("         " + getMonthName(month)+ " " + year);
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

    }

    String getMonthName(int month) {
        String monthName = null;
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
        }
        return monthName;
    }

   
    void printMonthBody(int year, int month) {

        int startDay = getStartDay(year, month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        int i;
        for (i = 0; i < startDay; i++) {
            System.out.print("    ");
        }
        for (i = 1; i <= numberOfDaysInMonth; i++) {
            if (i < 10) {
                System.out.print("   " + i);
            } else {
                System.out.print("  " + i);
            }
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    
    int getStartDay(int year, int month) {
        
        int startDay1800 = 3;
        int totalNumberOfDays = getTotalNumberOfDays(year, month);

        return (totalNumberOfDays + startDay1800) % 7;
    }
    
    
    int getTotalNumberOfDays(int year, int month) {
        int total = 0;

        
        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i)) {
                total = total + 366;
            } else {
                total = total + 365;
            }
        }
        for (int i = 1; i < month; i++) {
            total = total + getNumberOfDaysInMonth(year, i);
        }
        return total;
    }

    int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) {
            return 31;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }

        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }

        return 0;
    }

    boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }


    void setReminder(int search,String newmessage) {
        String msg = newmessage;
        message[search] = msg;
    }
    
    
   void getReminder(){
         
      
         
    }  
}
