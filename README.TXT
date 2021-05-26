A program to set up and maintain information about runners in the marathon. 
It sets up a list of runners, categorise them according to names, 
ages and runners time groups and produce lists of results.


Tests
// creates instances of Runner to test if the number instance variables
   increments by 1 as each runner is being added

Runner firstRunner = new Runner();
Runner secondRunner = new Runner();
Runner thirdRunner = new Runner();
Runner fourthRunner = new Runner();
Runner fifthRunner = new Runner();

MarathonAdmin ma = new MarathonAdmin(); // creates a new instance of MarathodAdmin

ma.readInRunners();                     // checks that the instance variable runners references 
                                        // a list of the runners. Tests if the names and age groups
                                        // have been read correctly from the runners.txt file

ma.runMarathon();                       // checks that the runners representing the instance variable runners 
                                        // have the time set to random values between 90 and 180 inclusive

ma.sortRunnerList();                    // checks if the runners list have been sorted by the time of each runner
                                        // in ascending order   
                                           
ma.categorise();                        // check that juniorResults, standardResults and seniorResults have been 
                                        // populated correctly with correct names and times of runners                                         