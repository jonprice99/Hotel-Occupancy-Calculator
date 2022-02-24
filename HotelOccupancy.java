/* Program: HotelOccupancy
   Date: March 6, 2018
   Author: Jonathan Price
   
   This program is designed to calculate the occupancy
   rate for each floor of a hotel. When run, this
   program will ask the user to enter the number of
   floors the hotel has, how many rooms are on each
   floor, and how many of the rooms are occupied, then
   use that information to calculate the occupancy rate
   for the hotel before displaying the total hotel rooms,
   the total of occupied rooms, the total of vacant rooms,
   and the occupancy rate to the user. After being executed,
   this program needs the user to enter the number of floors
   in the hotel, the amount of rooms on each floor, and the
   amount of occupied rooms.
   
*/

import java.util.Scanner;  //Needed for the Scanner class

public class HotelOccupancy
{
   public static void main(String[] args)
   {
      //Read the user's keyboard input
      Scanner keyboard = new Scanner(System.in);
      
      int total_floors = 0; //Holds the total amount of floors
      int total_rooms = 0;  //Holds the total amount of rooms
      int total_occupied = 0;  //Holds the total amount of occupied rooms
      int total_vacant = 0; //Holds the total amount of vacant rooms
      double occupancy_rate;  //Holds the occupancy rate
      
      //Get the number of floors in the hotel
      System.out.print("How many floors does the hotel have? ");
      total_floors = keyboard.nextInt();
      
      //Ensure that a number less than 1 cannot be entered for floors
      while (total_floors < 1)
      {
         System.out.print("\nThat is an invalid number! " +
                          "\nPlease enter a number greater than zero. ");
         total_floors = keyboard.nextInt();
      }
      
      //Get the number of rooms on each floor
      for (int floor = 1; floor <= total_floors; floor++)
      {
         System.out.print("\nHow many rooms are on floor " + floor + "? ");
         int rooms_on_floor;  //Holds the number of rooms on a single floor
         rooms_on_floor = keyboard.nextInt();
         
         //Ensure that the number of rooms cannot be less than 10
         while (rooms_on_floor < 10)
         {
            System.out.print("\nYou cannot enter a number " +
                             "that is less than 10. " +
                             "\nPlease enter a number that is " +
                             "greater than 9.");
            rooms_on_floor = keyboard.nextInt();
         }
         
         //Calculate the total amount of rooms
         total_rooms = total_rooms + rooms_on_floor;
         
         //Get the number of occupied rooms
         System.out.print("\nHow many of these rooms are occupied? ");
         int occupied;  //Holds the amount of occupied rooms on a single floor
         occupied = keyboard.nextInt();
         
         //Ensure that occupied rooms cannot not be greater
         //than the amount of rooms on that floor
         while (occupied > rooms_on_floor || occupied < 0)
         {
            System.out.print("\nThere cannot be more/less rooms occupied " +
                             "on a floor than there are rooms! " +
                             "\nPlease enter a number between 0 and " +
                             rooms_on_floor + "! ");
            occupied = keyboard.nextInt();
         }
         
         //Calculate the total amount of occupied rooms
         total_occupied = total_occupied + occupied;
      }
      
      //Calculate the total number of vacant rooms
      total_vacant = total_rooms - total_occupied;
      
      //Calculate the occupancy rate
      occupancy_rate = (double)total_occupied / (double)total_rooms;
      
      //Display the total amount of rooms
      System.out.print("\nThere are " + total_rooms + " rooms in this hotel.");
      
      //Display the total amount of occupied rooms
      System.out.print("\nThere are " + total_occupied + 
                       " occupied rooms in this hotel.");
      
      //Display the total amount of vacant rooms
      System.out.print("\nThere are " + total_vacant + 
                       " vacant rooms in this hotel.");
      
      //Display the occupancy rate
      System.out.printf("\nThe occupancy rate of this hotel " +
      "is %,.2f.", occupancy_rate);
   }
}