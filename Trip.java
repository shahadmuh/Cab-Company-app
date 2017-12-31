

public class Trip

{//open class 

   private String customerName;
   private String mobileNo;
   private String day;
   private String date;
   private String time;
   private double distance;
   private String carType;
   private double charge;
   private String reservationCode;
   public static int totalReservations;
//methods 
   public Trip()
   {
      customerName ="";
      mobileNo ="";
      day ="";
      date ="";
      time ="";
      distance =0;
      carType ="";
      totalReservations=0;
   
   }
   public Trip(String customerN,String mobileN,String dday,String ddate,String ttime,double dist,String carTyp)
   {
      customerName = customerN ;
      mobileNo = mobileN ;
      day = dday ;
      date = ddate ;
      time = ttime ;
      distance = dist ;
      carType = carTyp ;   
      //totalReservations++;
   }
   //open set methods 
   public void setCustomerName(String customerN)
   {
      customerName=customerN;
   }
   public void setMobileNo(String mobileN)
   {
      mobileNo=mobileN;
   }

   public void setDay(String dday)
   {
      day=dday;
   }
   public void setDate(String ddate)
   {
      date=ddate;
   }
   public void setTime(String ttime)
   {
      time=ttime;
   }
   public void setDistance(double dist)
   {
      distance=dist;
   }
   public void setCarType(String carTyp)
   {
      carType=carTyp;
   }
   //end set methods 

   //open get methods 
   public String getCustomerName()
   {
      return customerName;
   }
   public String getMobileNo()
   {
      return mobileNo;
   }
   public String getDay()
   {
      return day;
   }
   public String getDate()
   {
      return date;
   }
   public String getTime()
   {
      return time;
   }
   public double getDistance()
   {
      return distance;
   }
   public String getCarType()
   {
      return carType;
   }
   public String getReservationCode()
   {
      return reservationCode;
   }
   //end get methods 
   
   //open generateReservationCode method
   public void generateReservationCode()
   {
      int space = customerName.indexOf(' ');
      String  firstName =customerName.substring(0,space);
      String lastName =customerName.substring(space+1);
      char firstLtr =firstName.charAt(0);
      String secLtr =lastName.substring(0,2);
      String code=firstLtr+secLtr+'#'+(totalReservations+1);
      reservationCode = code.toUpperCase() ;
      //System.out.println("Your Reservation Code is : "+reservationCode);
   }
  //end generateReservationCode method
  
  public void calculateCharge()
{//Open calculateCharge method
String type=carType.toUpperCase();
String car="ECONOMY";
String car1="PREMIUM";
String date1=date.substring(3,5);
int dateA=Integer.parseInt(date1);
double charge1=0;

if (type.equals(car)==true)
{
charge1=(distance/3)*5;
}
if (type.equals(car1)==true)
{
charge1=(distance/3)*10;
}
String hours=time.substring(0,2);
String mins=time.substring(3,5);
String time1=hours.concat(mins);
int timeA=Integer.parseInt(time1);
String day1="FRIDAY";
String day2="SATERDAY";
String dayA=day.toUpperCase();

if ((type.equals(car)==true)||(type.equals(car1)==true))
{
if ((1000<=timeA)&&(timeA<=1259)&&(dayA.equals(day1)==false)&&(dayA.equals(day2)==false))
charge=charge1-(charge1*.1);
}

if (type.equals(car)==true)
{
if (dayA.equals(day1)==true)
charge=charge1-(distance/5);
}
if (type.equals(car1)==true)
{
if ((dateA==12)&&(1000<=timeA)&&(timeA<=1259))
if(charge==0)
charge=charge1-(charge1*.05);
else
charge=charge-(charge1*.05);

}
if(charge==0)
charge=charge1;
//System.out.println("Your Ride Charge Is: "+charge+" SR per kilometer (km)");
}//End calculateCharge method

   public  void printTripInfo()
   {   //open printTripInfo method
   
      System.out.print("Customer Name:" +customerName + "\nPhone Number:" +mobileNo
      +"\nDay:" +day+"\nDate:" +date+"\nTime:" +time
      +"\nCar Type:" +carType+"\nCharge:" +charge
      +"SR"+"\nReservation Code:" +reservationCode+ "\n");      
   }     //end printTripInfo method


}//end class
