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

package application;

public class HolidayBonus {
	private static final double highestSalesBonus = 5000.00;
	private static final double lowestSalesBonus = 1000.00;
	private static final double otherBonus = 2000.00;
	/**
	 * method calculateHolidayBonus: Calculate holiday bonus of stores
	 * @param data: Array of data used as input for bonus calculation
	 * @return bonusAmount: The amount of bonus a store receives
	 */
    public static double[] calculateHolidayBonus(double[][] data) 
    {
        double[] bonuses = new double[data.length];

        for (int i = 0; i < data.length; i++) 
        {
            double highestSales = TwoDimRaggedArrayUtility.getHighestInRow(data, i);
            double lowestSales = TwoDimRaggedArrayUtility.getLowestInRow(data, i);
            int eligibleCategories = 0;
            double storeBonus = 0.0;

            for (int j = 0; j < data[i].length; j++) 
            {
                double sales = data[i][j];

                if (sales >= 0) 
                {
                    eligibleCategories++;
                    if (sales == highestSales) 
                        storeBonus += 5000;
                    else if (sales == lowestSales) 
                        storeBonus += 1000;
                    else
                        storeBonus += 2000;
                }
            }

            if (eligibleCategories == 1)
                storeBonus = 5000;

            bonuses[i] = storeBonus;
        }

        return bonuses;
    }
	/**
	 * method calculateTotalHolidayBonus: Calculate total holiday bonus of stores
	 * @param data: Array of data used as input for bonus calculation
	 * @return total: The total amount of bonuses
	 */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double total = 0.0;
        double[] storeBonuses = calculateHolidayBonus(data);

        for (double bonus : storeBonuses) {
            total += bonus;
        }

        return total;
    }
}
