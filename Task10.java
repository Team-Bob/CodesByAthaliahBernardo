/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cp1.payrollsystemformotorph;


//Imports for handling excel, input, date and time formatting
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

/**
 *
 * @author athaliah
 */

public class Task10 {
    
// Task 10 : Read Input from a Text File
// Automatic Employee Data Presentation    
// Need on MS 2 
// Collaborating here some of the Task 9 Codes    
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        
    // For User input
        System.out.print("Enter Employee Number: ");
        int employeeNumberInput = s.nextInt();

    // Asking for employee Desire week date
        System.out.print("Enter Date (MM-dd-yyyy) : ");    
        String dateInput = s.next();
        LocalDate inputDate = LocalDate.parse(dateInput,DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        
    // Inserting the Database
    
       String filePath = "src//MotorPH Employee Data .xlsx";
        Map<String, String[]> employeeData = getEmployeeDetails(filePath,employeeNumberInput);
        Map<String, Map<String,Double>> weeklyHours = getWorkHoursPerWeek(filePath, inputDate);
        displayEmployeeWorkHours(employeeData, weeklyHours, inputDate.with(DayOfWeek.MONDAY), inputDate.with(DayOfWeek.FRIDAY));
    }
        public static Map<String, String[]> getEmployeeDetails(String filePath, int employeeNumberInput) {
        Map<String,String[]> employeeData = new LinkedHashMap<>();
        try( FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(fis)) {


        //Get the sheet name "Employee Details"
            Sheet sheet = workbook.getSheet("Employee Details");
            
            //Check if the sheet exists
            if (sheet == null) {
                System.out.println("Sheet Not Found!");
                return employeeData;
}
            // Loop through each row in the sheet
            for (Row row: sheet) {
                if(row.getRowNum()== 0) continue; // just skipping the header
                
                //Get cells value
                Cell employeeNumberCell = row.getCell(0);
                    if (employeeNumberCell == null) continue; // Skip if no Employee Number
                    
                    int employeeNumber = (int)employeeNumberCell.getNumericCellValue();
                    if (employeeNumber != employeeNumberInput) continue;
                
                    
                // Get the other details
                Cell employeeFirstNameCell = row.getCell(2);
                Cell employeeLastNameCell = row.getCell(1);
                Cell employeeBirthdayCell = row.getCell(3);
                Cell employeePositionCell = row.getCell(11);
                Cell employeeStatusCell = row.getCell(10); 
                Cell basicSalaryCell = row.getCell(13);
                Cell hourlyRateCell = row.getCell(18);
                
            
            //Extract Employee Details
            String employeeFirstName = employeeFirstNameCell.getStringCellValue();
            String employeeLastName = employeeLastNameCell.getStringCellValue();
            String employeeBirthday = formatDateCell(employeeBirthdayCell);
            String employeePosition = employeePositionCell.getStringCellValue();
            String employeeStatus = employeeStatusCell.getStringCellValue();
            int basicSalary = (int)basicSalaryCell.getNumericCellValue();
            int hourlyRate = (int)hourlyRateCell.getNumericCellValue();

        // Displaying Employee Details  
                System.out.println("");
                System.out.println("===================================================");
                System.out.println("       Welcome to Motor PH Payroll System!         ");
                System.out.println("---------------------------------------------------");
                System.out.println("================ EMPLOYEE DETAILS =================");
                System.out.println("Employee Number      : " + employeeNumber);
                System.out.println("Employee Name        : " + employeeFirstName + " " + employeeLastName);
                System.out.println("Birthday             : " + employeeBirthday);
                System.out.println("---------------------------------------------------");
                System.out.println("Position             : " + employeePosition);
                System.out.println("Status               : " + employeeStatus);
                System.out.println("Hourly Rate          : ₱ " + hourlyRate);
                System.out.println("Basic Salary         : ₱ " + basicSalary);
                System.out.println("---------------------------------------------------\n");

            // Storing data for later use on the attendance records
            employeeData.put(String.valueOf(employeeNumber), new String[] {
            employeeFirstName,
            employeeLastName,
            employeeBirthday,
            employeePosition,
            employeeStatus,
            String.valueOf(basicSalary),
            String.valueOf(hourlyRate)
        });
    
            
    }
        }   catch (IOException e) {
                System.out.println("Error Reading File: " + e.getMessage());
            }
              return employeeData;
    }
         // Method to formate the date cells 
            private static String formatDateCell (Cell cell) {
                if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                SimpleDateFormat sdf = new SimpleDateFormat ("MM/dd/yyyy"); // Format the date
                return sdf.format(cell.getDateCellValue());
         } else if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue(); //Return as a string if not numeric
        } else { 
            return "Unknown Date Format";
        }
    }
        
    // Inserting the Database for the Attendance Record
        public static Map<String,Map<String, Double>> getWorkHoursPerWeek(String filePath, LocalDate inputDate) {
            Map<String,Map<String, Double>> weeklyHours = new HashMap<>();
           try(FileInputStream fis = new FileInputStream(new File(filePath));
                Workbook workbook = new XSSFWorkbook(fis)) {

                Sheet sheet = workbook.getSheet("Attendance Record");
                    if (sheet == null) {
                        System.out.println("Attendance Record Sheet not found!");
                        return weeklyHours;
                    }

            // Calculates the Start (Monday) to End (Friday)
            LocalDate weekStart = inputDate.with(DayOfWeek.MONDAY);
            LocalDate weekEnd = inputDate.with(DayOfWeek.FRIDAY);
            
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy",
            Locale.ENGLISH);
            

                for(Row row: sheet) {
                    if(row.getRowNum()== 0) continue; // Skip Header Row
                
                Cell employeeNumberCell = row.getCell(0);
                Cell dateCell = row.getCell(3);
                Cell logInCell = row.getCell (4);
                Cell logOutCell = row.getCell(5);
                
            if (employeeNumberCell == null || dateCell == null || logInCell == null || logOutCell == null) {
                continue;
            }

            String employeeNumber = getCellValueAsString(employeeNumberCell);
            LocalDate attendanceDate = getCellDateValue(dateCell);
            
            //Only process if date is present in the database
            if(attendanceDate.isBefore(weekStart)|| attendanceDate.isAfter(weekEnd)) continue;
            
            
                double hoursWorked = calculatedWorkHours(logInCell, logOutCell);
                String dayLabel = attendanceDate.format(dateFormatter); 
                
                weeklyHours.putIfAbsent(employeeNumber, new LinkedHashMap<>());
                weeklyHours.get(employeeNumber).merge(dayLabel, hoursWorked, Double::sum);
            }
                return weeklyHours;
        }
            catch(IOException e) {
                System.out.println("Error Reading Attendance Record: " + e. getMessage());
            }
            return weeklyHours;
        }
        
        

        public static void displayEmployeeWorkHours(Map<String, String[]> employeeData,
            Map <String,Map<String,Double>> weeklyHours, LocalDate weekStart, LocalDate weekEnd) {
                for (String employeeNumber: employeeData.keySet()) {
                    if ( weeklyHours.containsKey(employeeNumber)) {
                       
                    System.out.println("================ ATTENDANCE RECORD ================");
                    System.out.println("Weekly Attendance for " + weekStart + " to " + weekEnd);
                    System.out.println("");
                    
                        double totalHours = 0;
                        double totalOvertime = 0;
                        int totalLateDays = 0;
                        long totalLateMinutes = 0;
                        
                //Loop
                for(Map.Entry<String, Double> entry : weeklyHours.get(employeeNumber).entrySet()) {
                    String dayLabel = entry.getKey();
                    double workedHours = entry.getValue();
            
                    System.out.println("Date: " + dayLabel);
                    System.out.println("Total Worked Hours: " + String.format("%.2f", workedHours));
                            
                // Check login time
                LocalDate date = LocalDate.parse(dayLabel, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                LocalTime loginTime = getLoginTime(employeeNumber, date);
                    if (loginTime != null) {
                        LocalTime graceTime = LocalTime.of(8, 10);
                        if (loginTime.isAfter(graceTime)) {
                            long minutesLate = Duration.between(graceTime, loginTime).toMinutes();
                            totalLateDays++;
                            totalLateMinutes += minutesLate;
                            System.out.println("Late: YES (" + minutesLate + " minutes late)");
                        } else {
                            System.out.println("Late: NO");
                        }
                    } else {
                        System.out.println("Late: Time not available");
                    }            
                    
                    if (workedHours > 9) {
                    double overtime = workedHours - 9;
                    totalOvertime += overtime;
                    System.out.println("Overtime Hours: " + String.format("%.2f", overtime));
                    } else {
                        System.out.println("Overtime Hours: 0.00");
                    }

                    System.out.println("");
                    totalHours += workedHours;
                }

                         
                // Weekly summary
                   System.out.println("Total Hours Worked for the Week: " + String.format("%.2f", totalHours));
                   System.out.println("Total Overtime Hours: " + String.format("%.2f", totalOvertime));
                   System.out.println("Days Late: " + totalLateDays);
                   System.out.println("Total Late Minutes: " + totalLateMinutes);
                   System.out.println("===================================================");
                   System.out.println();

               } else {
                   System.out.println("No Attendance Records found for Employee Number: " + employeeNumber);
               }
           }
       }


                private static String getCellValueAsString(Cell cell) {
                    if (cell.getCellType() == CellType.NUMERIC){
                        return String.valueOf((int) cell.getNumericCellValue());
                    } else {
                        return cell.getStringCellValue();
                    }
                }
                    
                private static LocalDate getCellDateValue (Cell cell) {
                    if (cell.getCellType() == CellType.NUMERIC){
                        return cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault())
                                .toLocalDate();
                    } else {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyy");
                        return LocalDate.parse(cell.getStringCellValue(),formatter);
                    }
                }
                
                private static LocalTime getTimeAsLocalTime(Cell cell) {
                try {
                    // Check if the cell contains a date/time value
                    if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        // Convert the date to LocalTime (just using the time part)
                        return LocalTime.of(date.getHours(), date.getMinutes(), date.getSeconds());
                    } else {
                        throw new IllegalArgumentException("Cell does not contain a valid time.");
                    }
                } catch (Exception e) {
                    System.out.println("Error parsing cell time: " + e.getMessage());
                    return LocalTime.MIN; // Return the minimum time if parsing fails
                }
            }
                
                private static double calculatedWorkHours(Cell logInCell, Cell logOutCell) {
                    try {
     
                        LocalTime loginTime = getTimeAsLocalTime(logInCell);
                        LocalTime logoutTime = getTimeAsLocalTime(logOutCell);
                        
                        double hoursWorked = (logoutTime.toSecondOfDay() - loginTime.toSecondOfDay()) / 3600.0;
                        
                    // Calculate overtime if logout is after official working hours
                          double overtimeHours = 0;
                          if (logoutTime.isAfter(LocalTime.of(17, 0))) {
                              Duration overtimeDuration = Duration.between(LocalTime.of(17, 0), logoutTime);
                              overtimeHours = overtimeDuration.toMinutes() / 60.0;
                          }

                          return hoursWorked + overtimeHours;

                        } catch (Exception e) {
                            System.out.println("Error pasing work hours." + e.getMessage());
                            return 0;
                        }
                    }
                
                private static double getTimeAsNumeric (Cell cell) {
                 try {
                    if (cell .getCellType()== CellType.NUMERIC){
                        return cell.getNumericCellValue();
                    } else {
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                        Date date = sdf.parse(cell.getStringCellValue());
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(date);
                        return(cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) / 60.0 +  cal.get(Calendar.SECOND)/ 3600.0) / 24.0;
                    }
                } catch (Exception e ) {
                     System.out.println("Error pasing time :"  + e.getMessage());
                     return 0;
        }
    }
            private static LocalTime getLoginTime(String employeeNumber, LocalDate date) {
                String filePath = "src//MotorPH Employee Data .xlsx";
                try (FileInputStream fis = new FileInputStream(new File(filePath));
                     Workbook workbook = new XSSFWorkbook(fis)) {

                    Sheet sheet = workbook.getSheet("Attendance Record");
                    if (sheet == null) {
                        return null;
                    }

                    for (Row row : sheet) {
                        if (row.getRowNum() == 0) continue;

                        Cell empNumberCell = row.getCell(0);
                        Cell dateCell = row.getCell(3);
                        Cell loginCell = row.getCell(4);

                        if (empNumberCell == null || dateCell == null || loginCell == null) continue;

                        String empNum = getCellValueAsString(empNumberCell);
                        LocalDate attendanceDate = getCellDateValue(dateCell);

                        if (empNum.equals(employeeNumber) && attendanceDate.equals(date)) {
                            return getTimeAsLocalTime(loginCell);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading login time: " + e.getMessage());
                }

                return null;
            }

                
                
                
}
            

            
    













  
 



            

       
