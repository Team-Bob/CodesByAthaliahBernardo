/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motorphpayroll;

//Imports
import java.time.LocalTime;
import java.time.Duration;
import java.util.Scanner;
import java.text.DecimalFormat;


/**
 *
 * @author athaliah
 */
public class Payroll {
    
    public static void main(String[] args) {
        
         // Decimal format for currency (e.g., ₱ 10,500.00)
        DecimalFormat currencyFormat = new DecimalFormat("₱#,##0.00");
        
        //Inserting Variables
        long employeeNumber;
        String employeeName;
        String employeeBirthday;
        double workHours;
        double overtimeHours = 0;
        double hourlyRate;
        double overtimeRate;
        float grossWeeklySalary;
        float netWeeklySalary;
        float overtimeSalary;
        float totalDeductions;
        double taxDeductions;
        double sssDeductions;
        double philHealthDeductions;
        double pagIbigDeductions;
        
        
          Scanner s = new Scanner(System.in);
        
       // Work Hours
        LocalTime officialWorkingHour = LocalTime.of(8, 0);
        LocalTime officialEnd = LocalTime.of(17, 0);
        Duration gracePeriod = Duration.ofMinutes(10);
        
        // Clock-in and Clock-out
        System.out.print("Clock-in Time (HH:mm): ");
        String clockIn = s.nextLine();
        System.out.print("Clock-out Time (HH:mm): ");
        String clockOut = s.nextLine();
        
         // Convert String to LocalTime
        LocalTime employeeClockIn = LocalTime.parse(clockIn);
        LocalTime employeeClockOut = LocalTime.parse(clockOut);
        
        // Applying the 10-minute grace period
        if (employeeClockIn.isAfter(officialWorkingHour) && 
            employeeClockIn.isBefore(officialWorkingHour.plus(gracePeriod))) {
            employeeClockIn = officialWorkingHour;
        }
        
        // Calculate total work hours
        Duration workDuration = Duration.between(employeeClockIn, employeeClockOut);
        workHours = workDuration.toMinutes() / 60.0;
        
        // Overtime Calculation (Fixed)
       overtimeHours = 0;
        if (employeeClockOut.isAfter(officialEnd)) { 
            overtimeHours = Duration.between(officialEnd, employeeClockOut).toMinutes() / 60.0;
        }
        //Calculate Salary Based on Hours Worked
        
        // Calculate Regular Pay
        double regularPay = workHours * hourlyRate;
        
        // Calculate Overtime Pay
        double overtimePay = overtimeHours * overtimeRate;
        
        // Calculate Gross Salary
        grossWeeklySalary = (float) (regularPay + overtimePay);
            
        // Generic Deductions (Fixed Percentages)
        double taxDeduction = grossWeeklySalary * 0.10;      // 10% Tax
        double sssDeduction = grossWeeklySalary * 0.05;      // 5% SSS Contribution
        double philHealthDeduction = grossWeeklySalary * 0.02; // 2% PhilHealth
        double pagIbigDeduction = grossWeeklySalary * 0.01;    // 1% Pag-IBIG
        
        // Calculate Total Deductions
        totalDeductions = (float) (sssDeductions + philHealthDeductions + taxDeductions + pagIbigDeductions);
        
        // Calculate Net Salary
        netWeeklySalary = grossWeeklySalary - totalDeductions;

        
        
        // Display results
        System.out.println("\n========== Employee Payroll Summary ==========");
        System.out.println("Employee Number: " + employeeNumber);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Birthday: " + employeeBirthday );
        System.out.println("---------------------------------------------");
        System.out.println("Total Hours Worked: " + workHours);
        System.out.println("Hourly Rate: ₱" + String.format("%.2f", hourlyRate));
        System.out.println("Gross Weekly Salary: ₱" + String.format("%.2f", grossWeeklySalary));
        System.out.println("---------------------------------------------");
        System.out.println("Tax Deduction (10%): ₱" + String.format("%.2f", taxDeduction));
        System.out.println("SSS Deduction (5%): ₱" + String.format("%.2f", sssDeduction));
        System.out.println("PhilHealth Deduction (2%): ₱" + String.format("%.2f", philHealthDeduction));
        System.out.println("Pag-IBIG Deduction (1%): ₱" + String.format("%.2f", pagIbigDeduction));
        System.out.println("Total Deductions: ₱" + String.format("%.2f", totalDeductions));
        System.out.println("---------------------------------------------");
        System.out.println("Net Weekly Salary: ₱" + String.format("%.2f", netWeeklySalary));
        System.out.println("=============================================");

        s.close();
        
               
        
         // Work Hours
        LocalTime officialWorkingHour = LocalTime.of(8, 0);
        LocalTime officialEnd = LocalTime.of(17, 0);
        Duration gracePeriod = Duration.ofMinutes(10);
        
              
       System.out.print("Clock-in Time for Day" + i + " (HH:mm): ");
        String clockIn = s.nextLine();
       System.out.print("Clock-out Time for Day" + i + " (HH:mm): ");
        String clockOut = s.nextLine();
       System.out.println(""); 
      
    }
}
