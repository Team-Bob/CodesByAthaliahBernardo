/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
public class MotorPhPayroll {

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
            
            if (!clockIn.isBefore(shiftStart.plusMinutes(10))) {
                System.out.println("Late clock-in recorded.");
            } else {
                clockIn = shiftStart;
            }
        
            System.out.println("---------------------------------------------------");
       
            Duration workDuration = Duration.between(clockIn, clockOut);
            double hoursWorked = workDuration.toMinutes() / 60.0;
                totalHoursWorked += hoursWorked;
        }
            System.out.println("Total Weekly Hours Worked: " + totalHoursWorked + "hours");
            System.out.println("");
    
    //Salary Calculator
        
        //Overtime
             double overtimeHours = (totalHoursWorked > 40 )?(totalHoursWorked - 40) : 0;
             double overtimeRate = hourlyRate[index] * 1.5;

        //Calculate Salary Based on Hours Worked
             double overtimePay = overtimeHours * overtimeRate;
             double grossWeeklySalary = (totalHoursWorked * hourlyRate[index])+ overtimePay;
        
        // Convert the Gross Weekly Salary to Monthly Salary
            double grossMonthlySalary = grossWeeklySalary * 4;
            double taxDeduction = 0;
            double philHealthDeduction = 0;
            double sssDeduction = 0;
            double pagIbigDeduction= 0;
      
        //SSS Deduction
            if (grossMonthlySalary  < 3250){
                sssDeduction = 135.00; // Fixed 135 php for 3,250 below
            } else if ( grossMonthlySalary <= 3750) {
                sssDeduction = 157.50; // Fixed for 3,250 to 3,750
            } else if ( grossMonthlySalary <= 4250) {
                sssDeduction = 180.00; // Fixed for 3,750 to 4,250 
            } else if ( grossMonthlySalary <= 5250) {
                sssDeduction = 225.00; // Fixed for 4,750 to 5,250
            } else if ( grossMonthlySalary <= 5750) {
                sssDeduction = 247.50; // Fixed for 5,250 to 5,750
            } else if ( grossMonthlySalary <= 6250) {
                sssDeduction = 270.00; // Fixed for 5,750 to 6,250 
            } else if ( grossMonthlySalary <= 6750) {
                sssDeduction = 292.50; // Fixed for 6,250 to 6,750
            } else if ( grossMonthlySalary <= 7250) {
                sssDeduction = 315.00; // Fixed for 6,750 to 7,250
            } else if ( grossMonthlySalary <= 7750) {
                sssDeduction = 337.50; // Fixed for 7,250 to 7,750 
            } else if ( grossMonthlySalary <= 8250) {
                sssDeduction = 360.00; // Fixed for 7,750 to 8,250
            } else if ( grossMonthlySalary <= 8750) {
                sssDeduction = 382.50; // Fixed for 8,250 to 8,750
            } else if ( grossMonthlySalary <= 9250) {
                sssDeduction = 405.00; // Fixed for 8,750 to 9,250 
            } else if ( grossMonthlySalary <= 9750) {
                sssDeduction = 427.50; // Fixed for 9,250 to 9,750
            } else if ( grossMonthlySalary <= 10250) {
                sssDeduction = 450.00; // Fixed for 9,750 to 10,250 
            } else if ( grossMonthlySalary <= 10750) {
                sssDeduction = 472.50; // Fixed for 10,250 to 10,750
            } else if ( grossMonthlySalary <= 11250) {
                sssDeduction = 495.00; // Fixed for 10,750 to 11,250
            } else if ( grossMonthlySalary <= 11750) {
                sssDeduction = 517.50; // Fixed for 11,250 to 11,750
            } else if ( grossMonthlySalary <= 12250) {
                sssDeduction = 540.00; // Fixed for 11,750 to 12,250
            } else if ( grossMonthlySalary <= 12750) {
                sssDeduction = 562.50; // Fixed for 12,250 to 12,750
            } else if ( grossMonthlySalary <= 13250) {
                sssDeduction = 585.00; // Fixed for 12,750 to 13,250 
            } else if ( grossMonthlySalary <= 13750) {
                sssDeduction = 607.50; // Fixed for 13,250 to 13,750
            } else if ( grossMonthlySalary <= 14250) {
                sssDeduction = 630.00; // Fixed for 13,750 to 14,250
            } else if ( grossMonthlySalary <= 14750) {
                sssDeduction = 652.50; // Fixed for 14,250 to 14,750
            } else if ( grossMonthlySalary <= 15250) {
                sssDeduction = 675.00; // Fixed for 14,750 to 15,250
            } else if ( grossMonthlySalary <= 15750) {
                sssDeduction = 697.50; // Fixed for 15,250 to 15,750
            } else if ( grossMonthlySalary <= 16250) {
                sssDeduction = 720.00; // Fixed for 15,750 to 16,250
            } else if ( grossMonthlySalary <= 16750) {
                sssDeduction = 742.50; // Fixed for 16,250 to 16,750
            } else if ( grossMonthlySalary <= 17250) {
                sssDeduction = 765.00; // Fixed for 16,750 to 17,250
            } else if ( grossMonthlySalary <= 17750) {
                sssDeduction = 787.50; // Fixed for 17,250 to 17,750
            } else if ( grossMonthlySalary <= 18250) {
                sssDeduction = 810.00; // Fixed for 17,750 to 18,250
            } else if ( grossMonthlySalary <= 18750) {
                sssDeduction = 832.50; // Fixed for 18,250 to 18,750
            } else if ( grossMonthlySalary <= 19250) {
                sssDeduction = 855.00; // Fixed for 18,750 to 19,250
            } else if ( grossMonthlySalary <= 19750) {
                sssDeduction = 877.50; // Fixed for 19,250 to 19,750
            } else if ( grossMonthlySalary <= 20250) {
                sssDeduction = 900.00; // Fixed for 19,750 to 20,250
            } else if ( grossMonthlySalary <= 20750) {
                sssDeduction = 922.50; // Fixed for 20,250 to 20,750
            } else if ( grossMonthlySalary <= 21250) {
                sssDeduction = 945.00; // Fixed for 20,750 to 21,250
            } else if ( grossMonthlySalary <= 21750) {
                sssDeduction = 967.50; // Fixed for 21,250 to 21,750
            } else if ( grossMonthlySalary <= 22250) {
                sssDeduction = 990.00; // Fixed for 21,750 to 22,250
            } else if ( grossMonthlySalary <= 22750) {
                sssDeduction = 1012.50; // Fixed for 22,250 to 22,750
            } else if ( grossMonthlySalary <= 23250) {
                sssDeduction = 1035.00; // Fixed for 22,750 to 23,250
            } else if ( grossMonthlySalary <= 23750) {
                sssDeduction = 1057.50; // Fixed for 23,250 to 23,750
            } else if ( grossMonthlySalary <= 24250) {
                sssDeduction = 1080.00; // Fixed for 23,750 to 24,250
            } else if ( grossMonthlySalary <= 24750) {
                sssDeduction = 1102.50; // Fixed for 24,250 to 24,750
            } else {
                sssDeduction = 1125.00; // Fixed for 24,740 and above
            }

        // Covert to Weekly SSS Deduction 
        double weeklySssDeduction = sssDeduction / 4;
      
        //Philhealth Deduction
            if (grossMonthlySalary == 10000) {
                philHealthDeduction = 300; //  Fixed 300 php deduction
            } else if (grossMonthlySalary >= 59999.99) {
                philHealthDeduction = (grossMonthlySalary * 0.03);
                if (philHealthDeduction > 1800) { // Cap at 1800
                    philHealthDeduction = 1800;
                } 
            } else {
                philHealthDeduction = 1800; // Fixed 1,800 php deduction for 60,000 and above
            }

         // Convert to Weekly PhilHealth Deduction
             double weeklyPhilHealthDeduction = philHealthDeduction / 4;
     
        //Pag- Ibig Deduction
            if (grossMonthlySalary >= 1000 && grossMonthlySalary <= 1500) {
                pagIbigDeduction = grossMonthlySalary * 0.01; // 1% of the Salary
            }else if (grossMonthlySalary > 1500){
                pagIbigDeduction = grossMonthlySalary * 0.02; // 2% of the Salary
            }
      
        // Convert to Weekly Pag-Ibig Deduction
             double weeklyPagIbigDeduction = pagIbigDeduction / 4; 
      
        //Total Deduction
            double totalDeductions = weeklySssDeduction + weeklyPhilHealthDeduction + weeklyPagIbigDeduction;
     
        //Taxable Income ( Salary - Total Deductions )
            double taxableSalary = grossWeeklySalary - totalDeductions;
            // Tax Brackets
            if (taxableSalary <= 20832){
                taxDeduction = 0; // No withholding Tax 
            } else if ( taxableSalary <= 33333){
                taxDeduction = ( taxableSalary - 20832) * 0.20; // 20% in excess of 20,833
            } else if ( taxableSalary <= 66667){
                taxDeduction = ( taxableSalary - 33333) * 0.25 + 2500; // 2,500 plus 25% in excess of 33,333
            } else if ( taxableSalary <= 166667){
                taxDeduction = ( taxableSalary - 66667) * 0.30 + 10833; // 10,833 plus 30% in excess of 66,667 
            } else if ( taxableSalary <= 666667){
                taxDeduction = ( taxableSalary - 166667) * 0.32 + 40833.33; // 40,833.33 plus 32% in excess over 166,667
            }else if ( taxableSalary >= 666667){
                taxDeduction = ( taxableSalary - 166667) * 0.35 + 200833.33; // 200,833.33 plus 35% in excess of 666,667
            }
        
        // Net Wage Calculation
             double netWeeklySalary = taxableSalary - taxDeduction;  
             
        // Displaying Salary Summary     
            System.out.println("-----------        SALARY SUMMARY        ----------");
            System.out.println("Overtime Pay         : " + df.format (overtimePay));
            System.out.println("-------------------------------------");
            System.out.println("Gross Weekly Salary  : " + df.format(grossWeeklySalary));
            System.out.println("-------------------------------------");
            System.out.println("SSS Deduction        : " + df.format(weeklySssDeduction));
            System.out.println("PhilHealth Deduction : " + df.format(weeklySssDeduction));
            System.out.println("Pag-Ibig Deduction   : " + df.format(weeklySssDeduction));
            System.out.println("-------------------------------------");
            System.out.println("Total Deductions     : "+  df.format (totalDeductions));
            System.out.println("-------------------------------------");
            System.out.println("Net Weekly Salary    : " + df.format (netWeeklySalary ));
            System.out.println("");
            System.out.println("---------------------------------------------------");
           
            
    }
}