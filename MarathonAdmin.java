import java.util.*;
import java.io.*;
import ou.*;
/**
 * The MarathonAdmin class has an instance variable runners that references 
 * a list of Runner objects. It has methods that read data about runners 
 * from a file runners.txt and create maps juniorResults, standardResults
 * and seniorResults who fell into the categories:
 * junior (under 18), senior (55 and over) and standard (other entrants).
 * 
 * 
 * @author Irmina Janvier 
 * @version 27 April 2017
 */
public class MarathonAdmin
{
   // instance variables 
   private List<Runner> runners;
   private SortedMap<String, Integer> juniorResults;
   private SortedMap<String, Integer> standardResults;
   private SortedMap<String, Integer> seniorResults;

   /**
    * Constructor for objects of class MarathonAdmin
    */
   public MarathonAdmin()
   {
      super();
      this.runners = new ArrayList<>();
      this.juniorResults = new TreeMap<>();
      this.standardResults = new TreeMap<>();
      this.seniorResults = new TreeMap<>();
   }

   /**
    * Prompts the user to select the file runners.txt. 
    * Reads runners names and ages from the file and creates
    * a new Runner object. Its instance variables name is set
    * using the value from the file. The instance variable ageGroup 
    * is calculated from the runner's age - runners 
    * under 18 are in 'junior' category, runners tha are 55 or older
    * are in 'senior' category. All other runners remain in 'standard' category.
    * The instance of Runner is added to the list referenced 
    * by the instance variable runners. 
    * Takes no arguments. Returns no value.
    */
   public void readInRunners()
   {
      String pathName = OUFileChooser.getFilename();
      File aFile = new File(pathName);
      Scanner bufferedScanner = null;
      try
      {
         String runnerName;
         int runnerAge;
         String runnerAgeGroup;
         Scanner lineScanner;
         String currentLine;
         bufferedScanner = new Scanner(new BufferedReader(new FileReader(aFile)));
         
         while(bufferedScanner.hasNextLine())
         {
            currentLine = bufferedScanner.nextLine();
            lineScanner = new Scanner(currentLine);
            lineScanner.useDelimiter(",");
            runnerName = lineScanner.next();
            runnerAge = lineScanner.nextInt();     
            if(runnerAge < 18)
            {
               runnerAgeGroup = "junior";
            }
            else if(runnerAge >= 55)
            {
               runnerAgeGroup = "senior";
            }
            else
            {
               runnerAgeGroup = "standard";
            }
            Runner newRunner = new Runner();
            newRunner.setName(runnerName);
            newRunner.setAgeGroup(runnerAgeGroup);
            runners.add(newRunner);
         }
      }
      catch(Exception anException)
      {
         System.out.println("Error: " + anException);
      }
      finally
      {
         try
         {
            bufferedScanner.close();
         }
         catch(Exception anException)
         {
            System.out.println("Error: " + anException);
         }
      }
   }
   
   /**
    * Iterates over runners and generates a random number
    * between 90 and 180 inclusive. The number is then used to set 
    * the time (in minutes) for each runner.
    * Takes no arguments and returns no value.
    */
   public void runMarathon()
   {
      Random numberGenerator = new Random();
      
      for(Runner aRunner : runners)
      {
         int randomNumber = numberGenerator.nextInt(91) + 90;
         aRunner.setTime(randomNumber); 
      }
   }
   
   /**
    * Sorts the receiver's runners list by the time of each runner
    * in ascending order so that the fastest runner is first
    * in the list and the next fastest is second and so on.
    * Takes no arguments and returns no value.
    */
   public void sortRunnerList()
   {
      Collections.sort(runners);
   }
   
   /** 
    * Populates the maps juniorResults, standardResults and seniorResults 
    * with the names and times of runners in the correct category.
    * Takes no arguments and returns no value.
    */
   public void categorise()
   {
       for(Runner aRunner : runners)
       {
          String anAgeGroup = aRunner.getAgeGroup();
          int aTime = aRunner.getTime();
          String aName = aRunner.getName();
          if(anAgeGroup == "senior")
          {
             seniorResults.put(aName, aTime);
          }
          else if (anAgeGroup == "junior")
          {
             juniorResults.put(aName, aTime);
          }
          else
          {
            standardResults.put(aName, aTime);
          }
       }
   }
}
            
  