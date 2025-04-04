/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cp1.payrollsystemformotorph;


//Imports 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

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

        
    // Inserting the Database
    
       String filePath = "src//MotorPH Employee Data .xlsx";
        readEmployeeDetails(filePath, employeeNumberInput);
    }
    public static void readEmployeeDetails(String filePath, int employeeNumberInput) {
        try(FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(fis)) {
         
            //Get the sheet name "Employee Details"
            Sheet sheet = workbook.getSheet("Employee Details");
            
            if (sheet == null) {
                System.out.println("Sheet Not Found!");
                return;
            }
            
    
            // Loop through each row in the sheet
            boolean found = false;
            for (Row row: sheet) {
                if(row.getRowNum()== 0) continue; // just skipping the header
                
                //Get cells value
                Cell employeeNumberCell = row.getCell(0);
                    if (employeeNumberCell == null) continue; // Skip if no Employee Number
                    
                    int employeeNumber = (int)employeeNumberCell.getNumericCellValue();
                
                // If the employee number matches
                if (employeeNumber == employeeNumberInput) {
                    found = true;
                    
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
        System.out.println(" Welcome to Motor PH Payroll System! ");
        System.out.println("---------------------------------------------------");
        System.out.println("Employee Number      : " + employeeNumber);
        System.out.println("Employee Name        : " + employeeFirstName+" "+ employeeLastName);
        System.out.println("Birthday             : " + employeeBirthday);
        System.out.println("---------------------------------------------------");
        System.out.println("Position             : " + employeePosition);
        System.out.println("Status               : " + employeeStatus);
        System.out.println("Hourly Rate          : ₱ " + hourlyRate);
        System.out.println("Basic Salary         : ₱ " + basicSalary);
        System.out.println("");
        
        break; // EmployeeFound, break the loop
        
            }
        }
        // If no employe is found
        if (!found){
            System.out.println("Employee with number" + employeeNumberInput + " not found");
        }
        
        } catch (IOException e){
            System.out.println("Error Reading File: " + e.getMessage());
        }  
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
    }
 