package application;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;

/*
Class: CMSC203 CRN 40398
Program: Assignment 5
Instructor: Farnaz Eivazi
Summary of Description: Calculate holiday bonus
Due Date: 07/24/2023 
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Shawn Parmhans
*/


public class TwoDimRaggedArrayUtility 
{
	private static final int MAX_ROWS = 10;
	private static final int MAX_COLUMNS = 10;
	/**
	 * Method readFile: take in a file and return a 2D ragged double array
	 * @param file: The file used for reading
	 * @return ragArray: The ragged array
	 * @throws FileNotFoundException: Exception used if file is not found
	 */
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		String[][] tempArray = new String[MAX_ROWS][MAX_COLUMNS];
		Scanner fileCheck = new Scanner(file);
		int rows = 0, cols1 = 0, cols2 = 0;
		//check how many rows
		while(fileCheck.hasNextLine() && rows < MAX_ROWS)
		{
			String line = fileCheck.nextLine().trim();
			if(!line.isEmpty())
			{
				String[] tokenArray = line.split(" ");
				cols1 = Math.min(tokenArray.length, MAX_COLUMNS);
				tempArray[rows] = new String[cols1];
				for(int i = 0; i < tokenArray.length && i < MAX_COLUMNS; i++)
					tempArray[rows][i] = tokenArray[i];
				rows++;
			}
		}
		fileCheck.close();
		//assign values to ragged array
		double[][] ragArray = new double[rows][];
		for(int i = 0; i < rows; i++)
		{
			cols2 = tempArray[i].length;
			ragArray[i] = new double[cols2];
			for(int j = 0; j < cols2; j++)
				ragArray[i][j] = Double.parseDouble(tempArray[i][j]);
		}
		return ragArray;
	}
	/**
	 * Method writeToFile: take in an array and file and write ragged array into the file
	 * @param data: the array used for input
	 * @param outputFile: The file used to write
	 * @throws FileNotFoundException: Exception for file not found
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		PrintWriter oFile = new PrintWriter(outputFile);
		
		for(double row[] : data)
		{
			for(int i = 0; i < row.length; i++)
			{
				oFile.print(row[i]);
				if(i < row.length - 1)
					oFile.print(" ");
			}
			oFile.println();
		}
		oFile.close();
	}
	/**
	 * Method getTotal: Get total of all elements of array and return it
	 * @param data: The array used to get the total
	 * @return total: The total of all elements added
	 */
	public static double getTotal(double[][] data)
	{
		double total = 0.0;
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i].length; j++)
			{
				total += data[i][j];
			}
		}
		return total;
	}
	/**
	 * Method getAverage: Get the average of all elements in the array and return it
	 * @param data: The array used to get the total
	 * @return average: The average of all elements
	 */
	public static double getAverage(double[][] data)
	{
		int elements = 0;
		for(int i = 0; i < data.length; i++)
			elements += data[i].length;
		
		double total = getTotal(data);
		double average = (total / elements);
		
		return average;
	}
	/**
	 * method getRowTotal: Get total of a specific row
	 * @param data: Array used for getting total
	 * @param row: variable used for rows
	 * @return total: total of the rows
	 */
	public static double getRowTotal(double[][] data, int row)
	{
		//delete below this later if works still
		if(row < 0 || row >= data.length)
			throw new IllegalArgumentException("invalid row");
		//delete above
		double total = 0.0;
		for(double val : data[row])
			total += val;
		
		return total;
	}
	/**
	 * method getColumnTotal: Get total of a specific column
	 * @param data: Array used for getting column
	 * @param col: variable used for columns
	 * @return total: total of the columns
	 */
	public static double getColumnTotal(double[][] data, int col)
	{
		//delete below this later if works still
		if (col < 0)
			throw new IllegalArgumentException("invalid column");
		
		double total = 0.0;
		for(double[] val : data)
		{
			if(col < val.length)
				total += val[col];
		}
		
		return total;
	}
	/**
	 * method getHighestInRow: Get highest value of a specific row
	 * @param data: Array used for getting highest value
	 * @param row: variable used for rows
	 * @return highestInRow: highest of the rows
	 */
	public static double getHighestInRow(double[][] data, int row)
	{
		//delete below this later if works still
		if(row < 0 || row >= data.length)
			throw new IllegalArgumentException("invalid highest row");
		//delete above
		double highestInRow = -999999.9;
		for(double val : data[row])
		{
			if(val > highestInRow)
				highestInRow = val;
		}
		return highestInRow;
	}
	/**
	 * method getHighestInRowIndex: Get highest index value of a specific row
	 * @param data: Array used for getting highest value
	 * @param row: variable used for rows
	 * @return highestIndex: highest index of the rows
	 */
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		//delete below this later if works still
		if(row < 0 || row >= data.length)
			throw new IllegalArgumentException("invalid row index");
		//delete above
		int highestIndex = 0;
		double highestArray = data[row][0];
		
		for(int i = 0; i < data[row].length; i++)
		{
			if(data[row][i] > highestArray)
			{
				highestArray = data[row][i];
				highestIndex = i;
			}
		}
		return highestIndex;
	}
	/**
	 * method getLowestInRow: Get lowest value of a specific row
	 * @param data: Array used for getting lowest value
	 * @param row: variable used for rows
	 * @return lowest: lowest of the rows
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		//delete below this later if works still
		if(row < 0 || row >= data.length)
			throw new IllegalArgumentException("invalid row index");
		//delete above
		double lowest = data[row][0];
		for (double val : data[row]) {
	        if (val < lowest) {
	            lowest = val;
	        }
	    }
	    return lowest;
	}
	/**
	 * method getLowestInRowIndex: Get lowest index value of a specific row
	 * @param data: Array used for getting lowest value
	 * @param row: variable used for rows
	 * @return lowestRowIndex: lowest index of the rows
	 */
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		//delete below this later if works still
		if(row < 0 || row >= data.length)
			throw new IllegalArgumentException("invalid row index");
		//delete above
	    int lowestRowIndex = 0;
	    double lowestValue = data[row][0];
	    for (int i = 0; i < data[row].length; i++) {
	        if (data[row][i] < lowestValue) {
	            lowestValue = data[row][i];
	            lowestRowIndex = i;
	        }
	    }
	    return lowestRowIndex;
	}
	/**
	 * method getHighestInColumn: Get highest value of a specific column
	 * @param data: Array used for getting highest value
	 * @param col: variable used for columns
	 * @return highestCol: highest of the columns
	 */
	public static double getHighestInColumn(double[][] data, int col)
	{
		   double highestCol = -999999.9;
		    for (double[] row : data) 
		    {
		        if (col < row.length && row[col] > highestCol) 
		        {
		            highestCol = row[col];
		        }
		    }
		    return highestCol;
	}
	/**
	 * method getHighestInColumnIndex: Get highest index value of a specific column
	 * @param data: Array used for getting highest value
	 * @param col: variable used for columns
	 * @return highestIndex: highest index of the columns
	 */
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
	    double highestValue = -99999.9;
	    int highestIndex = 0;
	    for (int i = 0; i < data.length; i++)
	    {
	        if (col < data[i].length && data[i][col] > highestValue) 
	        {
	            highestValue = data[i][col];
	            highestIndex = i;
	        }
	    }
	    return highestIndex;
	}
	/**
	 * method getLowestInColumn: Get lowest value of a specific column
	 * @param data: Array used for getting lowest value
	 * @param col: variable used for columns
	 * @return lowestVal: lowest of the columns
	 */
	public static double getLowestInColumn(double[][] data, int col)
	{
		double lowestVal = 9999999.9;
	    for (int i = 0; i < data.length; i++) 
	    {
	        if (col < data[i].length && data[i][col] < lowestVal) 
	        {
	            lowestVal = data[i][col];
	        }
	    }
	    return lowestVal;
	}
	/**
	 * method getLowestInColumnIndex: Get lowest index value of a specific column
	 * @param data: Array used for getting lowest value
	 * @param col: variable used for columns
	 * @return lowestIndex: lowest index of the columns
	 */
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
	    int lowestIndex = -1;
	    double lowestValue = 99999999.9;
	    for (int i = 0; i < data.length; i++) 
	    {
	        if (col < data[i].length && data[i][col] < lowestValue) 
	        {
	            lowestValue = data[i][col];
	            lowestIndex = i;
	        }
	    }
	    return lowestIndex;
	}
	/**
	 * method getHighestInArray: Get highest element in array
	 * @param data: Array used for getting the highest element
	 * @return highest: highest element in array
	 */
	public static double getHighestInArray(double[][] data)
	{
		double highest = -99999.9;
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i].length; j++)
			{
				if(data[i][j] > highest)
					highest = data[i][j];
			}
		}
		return highest;
	}
	/**
	 * method getLowestInArray: Get lowest element in array
	 * @param data: Array used for getting the highest element
	 * @return lowest: lowest element in array
	 */
	public static double getLowestInArray(double[][] data)
	{
		double lowest = -99999.9;
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i].length; j++)
			{
				if(data[i][j] < lowest)
					lowest = data[i][j];
			}
		}
		return lowest;
	}
}
