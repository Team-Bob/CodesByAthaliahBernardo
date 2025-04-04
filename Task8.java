/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cp1.payrollsystemformotorph;

//Imports
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author athaliah
 */

public class Task8 {
    
// Task 8 : Calculate Hours Worked and Calculate Salary Based on Hours Worked    
// Collaborating the Task 7 codes 
// Allowing Users to Enter their own weekly clock in and clock out 
// Inserting the 10 mins grace period
// Subtracting the Lunch hours ( 1 Hour ) 
    
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("₱#,##0.00");
        
        
    //Inserting Variables
        int[] employeeNumbers = {10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008, 10009, 10010, 
                                 10011, 10012, 10013, 10014, 10015, 10016, 10017, 10018, 10019, 10020, 
                                 10021, 10022, 10023, 10024, 10025, 10026, 10027, 10028, 10029, 10030, 
                                 10031, 10032, 10033, 10034};
        
        String[] employeeFirstNames = {"Manuel III", "Antonio", "Bianca Sofia", "Isabella", "Eduard", "Andrea Mae",
                               "Brad", "Alice", "Rosie", "Roderick", "Anthony", "Josie", "Martha", "Leila",
                               "Fredrick", "Christian", "Selena", "Allison", "Cydney", "Mark", "Darlene", 
                               "Kolby", "Vella", "Tomas", "Jacklyn", "Percival", "Garfield", "Lizeth", 
                               "Carol", "Emelia", "Delia", "John Rafael", "Carlos Ian", "Beatriz"};
        
        String[] employeeLastNames = {"Garcia", "Lim", "Aquino", "Reyes", "Hernandez", "Villanueva", "San Jose", 
                                "Romualdez", "Atienza", "Alvaro", "Salcedo", "Lopez", "Farala", "Martinez",
                                "Romualdez", "Mata", "De Leon", "San Jose", "Rosario", "Bautista", "Lazaro",
                                "Delos Santos", "Santos", "Del Rosario", "Tolentino", "Gutierrez", "Manalaysay",
                                "Villegas", "Ramos", "Maceda", "Aguilar", "Castro", "Martinez", "Santos"};
        
        String [] employeeBirthday = {"10/11/1983", "6/19/1988", "08/04/1989", "06/16/1994", "09/23/1989", "02/14/1988",
                                      "03/15/1996", "05/14/1992", "09/24/1948", "03/30/1988", "09/14/1993","01/14/1987",
                                      "01/11/1942", "07/11/1970", "03/10/1985", "10/21/1987", "02/20/1975","06/24/1986",
                                      "10/06/1996", "02/12/1991", "11/25/1985", "02/26/1980","12/31/1983", "12/18/1978",
                                      "05/19/1984", "12/18/1970", "08/28/1986", "12/12/1981", "08/20/1978", "04/14/1973",
                                      "01/27/1989", "02/09/1992", "11/16/1990", "08/07/1990" } ;

        String[] employeeStatus = {"Regular", "Regular", "Regular", "Regular", "Regular", "Regular","Regular", 
                                "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular",
                                 "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", 
                                 "Probationary", "Probationary", "Probationary", "Probationary","Probationary", 
                                 "Probationary", "Probationary", "Probationary", "Probationary", "Probationary", 
                                 "Probationary", "Regular", "Regular", "Regular",};
        
        String[] employeePosition = {"Chief Executive Officer", "Chief Operating Officer", "Chief Finance Officer",
                                "Chief Marketing Officer", "IT Operations and Systems", "HR Manager", 
                                "HR Team Leader", "HR Rank and File", "HR Rank and File", "Accounting Head",
                                "Payroll Manager", "Payroll Team Leader", "Payroll Rank and File", "Payroll Rank and File",
                                 "Account Manager", "Account Team Leader", "Account Team Leader", "Account Rank and File",
                                "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File",
                                "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File",
                                "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File",
                                "Account Rank and File", "Sales & Marketing", "Supply Chain and Logistics",
                                 "Customer Service and Relations"};
       
        int[] basicSalaries = { 90000, 60000, 60000, 60000, 52670, 52670, 42975, 22500, 22500, 
                               52670, 50825, 38475, 24000, 24000, 53500, 42975, 41850, 22500, 
                               22500, 23250, 23250, 24000, 22500, 22500, 24000, 24750, 24750, 
                               24000, 22500, 22500, 22500, 52670, 52670, 52670};

        double[] hourlyRate = { 535.71, 357.14, 357.14, 357.14, 313.51, 313.51, 255.80, 133.93, 133.93,
                            313.51, 302.53, 229.02, 142.86, 142.86, 318.45, 255.80, 249.11, 133.93,
                            133.93, 138.39, 138.39, 142.86, 133.93, 133.93, 142.86, 147.32, 147.32, 
                            142.86, 133.93, 133.93, 133.93, 313.51, 313.51, 313.51};
         

    // User Input : Employee Number
       System.out.print("Enter your Employee Number: ");
        int enteredEmployeeNumbers = s.nextInt();
        s.nextLine();
        
        System.out.println("");
        
        // Search for employee index
        int index = -1;
        for (int i = 0; i < employeeNumbers.length; i++) {
            if (employeeNumbers[i] == enteredEmployeeNumbers) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee number not found.");
            return; // Exit the Program
        }
        System.out.println("");
        System.out.println("===================================================");
        System.out.println(" Welcome to Motor PH Payroll System! ");
        System.out.println("---------------------------------------------------");
        System.out.println("Employee Number      : " + employeeNumbers[index]);
        System.out.println("Employee Name        : " + employeeFirstNames [index] +" "+ employeeLastNames[index]);
        System.out.println("Birthday             : " + employeeBirthday [index]);
        System.out.println("---------------------------------------------------");
        System.out.println("Position             : " + employeePosition [index]);
        System.out.println("Status               : " + employeeStatus[index]);
        System.out.println("Hourly Rate          : ₱ " + hourlyRate [index]);
        System.out.println("Basic Salary         : ₱ " + basicSalaries[index]);
        System.out.println("");
        
    //Work Hours
        System.out.println("------        WEEKLY CLOCK IN & CLOCK OUT        -----");
        double totalHoursWorked = 0;
            for (int day = 1; day <= 5; day++) {
                System.out.print("Enter clock-in time for Day " + day + " (HH:MM, 24-hour format): ");
                 String clockInStr = s.nextLine();
                
                System.out.print("Enter clock-out time for Day " + day + " (HH:MM, 24-hour format): ");
                  String clockOutStr = s.nextLine();
            
            System.out.println("");
            
            LocalTime clockIn = LocalTime.parse(clockInStr);
            LocalTime clockOut = LocalTime.parse(clockOutStr);
            LocalTime shiftStart = LocalTime.of(8, 0); // Shift starts at 8:00 AM
            
            LocalTime latePeriod = LocalTime.of(8,11); // Late if 8:11 onwards because of the 10 mins grace period
            if (clockIn.isAfter(latePeriod.minusMinutes(1))) {
                System.out.println("Late clock-in recorded.");
            } else {
                clockIn = shiftStart;
            }
        
            System.out.println("---------------------------------------------------");
       
            Duration workDuration = Duration.between(clockIn, clockOut);
            double hoursWorked = (workDuration.toMinutes() -60) / 60.0;
                totalHoursWorked += hoursWorked;
        }
            
            System.out.println("Total Weekly Hours Worked: " + totalHoursWorked + " hours");
            System.out.println("");
            
    //Salary Calculator
        
        //Overtime
             double overtimeHours = (totalHoursWorked > 40 )?(totalHoursWorked - 40) : 0;
             double overtimeRate = hourlyRate[index] * 1.5;

        //Calculate Salary Based on Hours Worked
             double overtimePay = overtimeHours * overtimeRate;
             double grossWeeklySalary = (totalHoursWorked * hourlyRate[index])+ overtimePay;
        
        // Displaying Salary Summary     
            System.out.println("-----------        SALARY SUMMARY        ----------");
            System.out.println("Overtime Pay         : " + df.format (overtimePay));
            System.out.println("-------------------------------------");
            System.out.println("Gross Weekly Salary  : " + df.format(grossWeeklySalary));
            System.out.println("-------------------------------------");
    }

}
