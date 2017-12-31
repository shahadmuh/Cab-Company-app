import java.util.* ;

public class CabCompany 
{

 static Scanner read = new Scanner (System.in) ;
 private int reservations_size ;
 private static Trip[] Trips = new Trip[20] ;

 public static void main (String [] args)
 {
  int choice ;

  do
  {
   System.out.println("What do you want to do (Enter a number) \n 1. Add a new trip. \n 2. Find a trip by reservation code. \n 3. List all trips. \n 4. List all trips for given customer. \n 5. Display number of reservations for a given car type. \n 6. Display the total number of trips. \n 7. Exit.");
   choice = read.nextInt() ;

   switch (choice) 
   {

    case 1: 
    {
    

     System.out.println("Enter Your Name: (customer name) ");
     read.nextLine();
     String customerName = read.nextLine() ;
     
     System.out.println("Enter Your Mobile Number: ");
     String mobileNo = read.next() ;

     System.out.println("Enter The Day: (day of the week)");
     String day = read.next() ;

     System.out.println("Enter The Date: in the format (DD/MM/YYYY)");
     String date = read.next() ;

     System.out.println("Enter The Time: in the format (HH:MM)pm or am");
     String time = read.next() ;

     System.out.println("Enter The Distance: ");
     double distance = read.nextDouble() ;

     System.out.println("Enter The Car Type: Economy(small car) or Premium(large car)");
     read.nextLine();
     String carType = read.nextLine() ;
      carType =carType.toLowerCase() ;

     boolean check =addTrip(customerName, mobileNo, day, date, time, distance, carType);

     if (check)
     {System.out.println(" The trip is added successfully ") ;
     Trip.totalReservations++;
     System.out.println();}
     else
     System.out.println(" The trip is not added ") ;
     System.out.println();
     
     break ;
    }// End Case1
    
    case 2:
    {
     System.out.println ("Enter the reservation code :");
     //read.nextLine();
     String reservationCode = read.next();
     int index = findTrip(reservationCode);
     
     if(index!=-1)
     {
     Trips[index].printTripInfo();
     }
     else
     System.out.println("Trip is not a part of trips list") ;
     
     break ;
    }// End case2
    
    case 3:
    {
     printAll() ;
     
     break ;
    }// End case3
    
    case 4:
    {
     System.out.println("Enter the mobile number:") ;
     read.nextLine() ;
     String moblieNo = read.nextLine() ;
     
     printAll(moblieNo) ;
     
     break;
    }// End case4
    
    case 5:
    {
     System.out.println ("Enter the car type:");
     read.nextLine();
     String carType = read.nextLine();
    int trips = carTrips(carType);

     System.out.println ("The number of trips for " + carType + " car type : " +trips);
     System.out.println();
               
     break;
    } //end case 5
    
    case 6:
    {
     System.out.println("The total number of trips : " + Trip.totalReservations) ;
     System.out.println();
     break ;
    }// End case 6
   }// End switch
  }// End do
  while (choice != 7) ;
 }// End main 

public static boolean addTrip(String customerName, String mobileNo, String day, String date, String time, Double distance, String carType) 
{
 boolean checkingMobile ;
 boolean checkingDate ;
 boolean checkingTime ;


 // checking mobile number
 if (mobileNo.length()==10 ) 
 checkingMobile = true;

 else 
 {
  checkingMobile = false; 
  System.out.println("Mobile number is not in a correct format");
 }

 // checking date 
 if ( (date.length()==10) && date.charAt(2)=='/' && date.charAt(5)=='/' )
 checkingDate = true; 

 else 
 {
  checkingDate = false; 
  System.out.println("Date is not in a correct format") ;
 }

 // checking time
 if ( time.length() == 5 && time.charAt(2) == ':' ) 
 checkingTime = true; 

 else 
 {
  checkingTime = false; 
  System.out.println("Time is not in a correct format");
 }

 // add a new trip
 if (checkingMobile && checkingDate && checkingTime)
 
 {
 Trip newTrip = new Trip (customerName, mobileNo, day, date, time, distance, carType); 
        newTrip.calculateCharge();
         Trips[Trip.totalReservations] = newTrip;
         //Trip.totalReservations++ ;
         return true ;
         }
         else
      return false ;
}// End addTrip

public static int findTrip(String reservationsCode)
{ 
for (int i=0;i<Trip.totalReservations;i++)
{
if (Trips[i].getReservationCode().equals(reservationsCode))
return i ;
 }// End for loop
 
 return -1 ;

}// End findTrip

public static void printAll()
{
  int i;
  for (i=0; i<Trip.totalReservations; i++)
  Trips[i].printTripInfo();
  }// End printAll

public static void printAll(String mobileNo)
{
int i;
 for(i=0; i<Trip.totalReservations; i++)
 if (Trips[i].getMobileNo().equals(mobileNo))
 Trips[i].printTripInfo();



}// End printAll

public static int carTrips(String carType)
{//open carTrips

 int i , Type=0 ;
 for (i=0;i<Trip.totalReservations;i++)
 {
 if (Trips[i].getCarType().equals(carType) )
   Type++ ;
 
}
return Type;
      
}// End carTrips   
                                                                 
}// End class
