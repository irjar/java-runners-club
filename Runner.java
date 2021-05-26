
/**
 * Class Runner - Simulates a runner in a Marathon.
 * 
 * @author Irmina Janvier 
 * @version 27 April 2017
 */
public class Runner implements Comparable<Runner>
{
/* static variables */
   private static int nextNumber = 1;

/* instance variables */
     
   private int number;       // runner's number
   private String name;      // runner's name
   private String ageGroup;  // standard, junior or senior
   private int time;         // runner's marathon time in minutes
 
   
   /**
    * Default constructor for objects of class Runner.
    */
   public Runner()
   {
      super();
      this.name = "";
      this.ageGroup = "standard";
      this.time = 0;
      
      this.number = Runner.nextNumber;
      Runner.nextNumber = Runner.nextNumber + 1;
    
   }

/* instance methods */

    //Only those accessor methods that you will need have been included
        
   /**
    * Returns the receiver's number.
    */
   public int getNumber()
   {
      return this.number;
   }
   
   
   /**
    * Sets the receiver's name.
    */
   public void setName(String aName)
   {
      this.name = aName;
   }
   
   
   /**
    * Returns the receiver's name.
    */
   public String getName()
   {
      return this.name;
   }
   
   
   /**
    * Sets the receiver's ageGroup.
    */
   public void setAgeGroup(String group)
   {
      this.ageGroup = group;
   }

   /**
    * Returns the receiver's ageGroup.
    */
   public String getAgeGroup()
   {
      return this.ageGroup;
   }
    
   
   /**
    * Sets the receiver's time.
    */
   public void setTime(int aTime)
   {
      this.time = aTime;
   }
   
   
   /**
    * Returns the receiver's time.
    */
   public int getTime()
   {
      return this.time;
   }
   
   /**
    * Compares the receiver with the argument and returns:
    * 
    * a negative result if the receiver's time was faster than
    * the time given in the argument. 
    * a positive result if the receiver's time was slower than 
    * the time given in the argument.
    * zero if the two times are the same.
    */
   public int compareTo(Runner anotherRunner)
   {
      return (this.getTime() - anotherRunner.getTime());
   }
   
}
