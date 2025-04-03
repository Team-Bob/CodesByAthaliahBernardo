// Official Working Hours
        LocalTime officialWorkingHour = LocalTime.of(8, 0);
        LocalTime officialEnd = LocalTime.of(17, 0);
        Duration gracePeriod = Duration.ofMinutes(10);

       System.out.println("");
   
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
        
        System.out.println("=====================================");
        System.out.println(" Welcome to Motor PH Payroll System! ");
        System.out.println("-------------------------------------");
        System.out.println("Employee Number      : " + employeeNumbers[index]);
        System.out.println("Employee Name        : " + employeeFirstNames [index] +" "+ employeeLastNames[index]);
        System.out.println("Birthday             : " + employeeBirthday [index]);
        System.out.println("-------------------------------------");
        System.out.println("Position             : " + employeePosition [index]);
        System.out.println("Satatus              : " + employeeStatus[index]);
        System.out.println("Hourly Rate          : " + hourlyRate [index]);
        System.out.println("Basic Salary         : " + basicSalaries[index]);
   
     //Calculate Work Hours
        
        // Varibles for Weekly tracking
            double totalWorkHours = 0;
            double totalOvertimeHours = 0;
        
        // Loop through Monday to Friday
        for(int day = 1; day <= 5; day++){
            System.out.println("\nDay" + day + ":");
        
        // Get the clock - in and clock - out time
        System.out.print("Clock-in Time (HH:mm): ");
            String clockInStr = s.nextLine();
        System.out.print("Clock-out Time (HH:mm): ");
            String clockOutStr = s.nextLine();
            
         // Convert String to LocalTime
        try {
          LocalTime employeeClockIn = LocalTime.parse(clockInStr);
          LocalTime employeeClockOut = LocalTime.parse(clockOutStr);
          
        
        // Applying grace period
        if (employeeClockIn.isAfter(officialWorkingHour) && 
            employeeClockIn.isBefore(officialWorkingHour.plus(gracePeriod))) {
            employeeClockIn = officialWorkingHour;
        }  
        //Calculate Daily work duration
         Duration workDuration = Duration.between(employeeClockIn, employeeClockOut);
        double workHours = workDuration.toMinutes() / 60.0;
        // Overtime Calculation (Fixed)
        double overtimeRate = hourlyRate[index] * 1.25; // 25% extra for overtime
        double overtimeHours = 0;
        if (employeeClockOut.isAfter(officialEnd)) { 
            overtimeHours = Duration.between(officialEnd,employeeClockOut).toMinutes() / 60.0;
        }
        
        // Weekly Totals
        totalWorkHours += dailyWorkHours;
        totalOvertimeHours += dailyOvertime;
       
        } catch (Exception e) {
            System.out.println("Invalid Time Format. Please use HH:mm (24-hour format).");
            day--; //Repeat the day 
        }

            
    //Calculate Salary Based on Hours Worked
      double overtimePay = overtimeHours * overtimeRate;
      double grossWeeklySalary = (workHours * hourlyRate[index])+ overtimePay;
        
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
      
        
    // Diplaying Output
        System.out.println("=====================================");
        System.out.println(" Welcome to Motor PH Payroll System! ");
        System.out.println("-------------------------------------");
        System.out.println("Employee Number      : " + employeeNumbers[index]);
        System.out.println("Employee Name        : " + employeeFirstNames [index] +" "+ employeeLastNames[index]);
        System.out.println("Birthday             : " + employeeBirthday [index]);
        System.out.println("-------------------------------------");
        System.out.println("Position             : " + employeePosition [index]);
        System.out.println("Satatus              : " + employeeStatus[index]);
        System.out.println("Hourly Rate          : " + hourlyRate [index]);
        System.out.println("Basic Salary         : " + basicSalaries[index]);
        System.out.println("-------------------------------------");
        System.out.println("Hours Worked         : " + totalWorkHours);
        System.out.println("Overtime Hours       : " + totalOvertimeHours);
        System.out.println("Overtime Pay         : " + df.format (overtimePay));
        System.out.println("-------------------------------------");
        System.out.println("Gross Weekly Salary  : " + df.format(grossWeeklySalary));
        System.out.println("-------------------------------------");
        System.out.println("SSS Deduction        : " + df.format(weeklySssDeduction));
        System.out.println("PhilHealth Deduction : " + df.format(weeklySssDeduction));
        System.out.println("Pag-Ibig Deduction   : " + df.format(weeklySssDeduction));
        System.out.println("Total Deductions     : "+  df.format (totalDeductions));
        System.out.println("-------------------------------------");
        System.out.println("Net Weekly Salary    : " + df.format (netWeeklySalary ));
        System.out.println("");
    
    }
}