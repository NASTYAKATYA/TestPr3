package ru.mirea;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows_1;
        int columns_1;
        int rows_2;
        int columns_2;
        int[][] matrix_1;
        int[][] matrix_2;
        int[][] values_1;
        int[][] values_2;
        System.out.println("enter number of rows in first matrix");
        rows_1 = in.nextInt();
        String operator;
        System.out.println("enter number of columns in first matrix");
        columns_1 = in.nextInt();
        System.out.println("enter number of rows in second matrix");
        rows_2 = in.nextInt();
        System.out.println("enter number of columns in second matrix");
        columns_2 = in.nextInt();
        matrix_1 = createMatrix(rows_1, columns_1);
        matrix_2 = createMatrix(rows_2, columns_2);
        values_1 = setValues(matrix_1,1);
        values_2 = setValues(matrix_2, 2);


        System.out.println("select an operation \n type in '+' for addition, '-' for subtraction or '*' for multiplication:");
        operator = in.next();
        switch(operator){
            case "*":
                multMatrices(matrix_1, matrix_2);
                break;
            case "+":
                addMatrices(matrix_1, matrix_2);
                break;
            case "-":
                subtractMatrices(matrix_1, matrix_2);
                break;
            default:
                System.out.println("error - invalid operator inputs");
                break;
        }

    }

    public static int[][] setValues(int[][] matrix, int number){
        Scanner in = new Scanner(System.in);
        int value;
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.println("Enter value of "+number+" matrix ["+(i+1)+"]["+(j+1)+"]");
                value = in.nextInt();
                matrix[i][j] = value;
            }
        }
        return matrix;
    }

    public static int[][] createMatrix(int rows, int columns){
        return new int[rows][columns];
    }

    public static int[][] multMatrices(int[][] matrix_1, int[][] matrix_2){
        boolean status = checkForMult(matrix_1, matrix_2);
        int[][] result = null;
        if(status){
            result = createMatrix(matrix_1.length, matrix_2[0].length);
            for(int i=0; i<matrix_1.length; i++){
                for(int j = 0; j<matrix_2[0].length; j++){
                    int total = 0;
                    for(int k = 0; k<matrix_1.length; k++){
                    int num_1 = matrix_1[i][k];
                    int num_2 = matrix_2[k][j];
                    int sum = num_1*num_2;
                    total += sum;
                    result[i][j]+=sum;
                    }
                    System.out.print(total+" ");
                }
                System.out.println();
            }
        }else
        {
            System.out.println("invalid input");
        }
        return result;
    }
    public static int[][] addMatrices(int[][] matrix_1, int[][] matrix_2){
        boolean status = checkForAddSub(matrix_1, matrix_2);
        int[][] result = null;
        if(status){
            result = createMatrix(matrix_1.length, matrix_2[0].length);
            for(int i = 0; i < matrix_1.length; i++){
                for(int j = 0; j < matrix_1[0].length; j++){
                    int value_1 = matrix_1[i][j];
                    int value_2 = matrix_2[i][j];
                    int sum = value_1 + value_2;
                    result[i][j]=sum;
                    System.out.print(sum+" ");
                }
                System.out.println();
            }
        }else{
            System.out.println("invalid input");
        }
        return result;
    }
    public static int[][] subtractMatrices(int[][] matrix_1, int[][] matrix_2){
        boolean status = checkForAddSub(matrix_1, matrix_2);
        int[][] result = null;
        if(status){
            result = createMatrix(matrix_1.length, matrix_2[0].length);
            for(int i = 0; i < matrix_1.length; i++){
                for(int j = 0; j < matrix_1[0].length; j++){
                    int value_1 = matrix_1[i][j];
                    int value_2 = matrix_2[i][j];
                    int res = value_1 - value_2;
                    result[i][j]=res;
                    System.out.print(res+ " ");
                }
                System.out.println();
            }
        }else{
            System.out.println("invalid input");
        }
        return result;
    }

    public static boolean checkForAddSub(int[][] matrix_1, int[][] matrix_2){
        boolean status;
        int rows_1 = matrix_1.length;
        int columns_1 = matrix_1[0].length;
        int rows_2 = matrix_2.length;
        int columns_2 = matrix_2[0].length;
        if(rows_1 == rows_2 && columns_1 == columns_2){
            status = true;
        }else
        {
            status = false;
        }
        return status;
    }
    public static boolean checkForMult(int[][] matrix_1, int[][] matrix_2){
        boolean status;
        int columns = matrix_1[0].length;
        int rows = matrix_2.length;
        if( columns == rows){
            status = true;
        }else
        {
            status = false;
        }
        return status;
    }

}
