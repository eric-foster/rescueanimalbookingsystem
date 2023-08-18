import java.util.ArrayList;
import java.util.Scanner;
/**
 * The Driver class is the heart of the program. Designed to do the following:
 * Prompts the user a main menu so they can select a desired path
 * Intakes new monkeys and dogs
 * Allows the user to reserve animals that are available to reserve
 * Shows users the desired list of dogs, monkeys, available animals, and in service animals based on selected path in main menu
 */
public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String options;

        initializeDogList();
        initializeMonkeyList();

        /**
         * This while loop is the heart of the program and defines the main menu and all logic pertaining to the main menu. 
         */
        while (true) {
            displayMenu();
            options = scnr.nextLine().trim().toLowerCase();

            if (options.equals("1")) {
                intakeNewDog(scnr);
            } else if (options.equals("2")) {
                intakeNewMonkey(scnr);
            } else if (options.equals("3")) {
                reserveAnimal(scnr);
            } else if (options.equals("4") || options.equals("5") || options.equals("6") || options.equals("7")) {
                printAnimals(options);
            } else if (options.equals("q")) {
                System.out.println("Exiting the program.");
                System.exit(0);
            } else {
                System.out.println("Wrong Input. Please select one of the options in the menu.");
                System.out.println("Returning to the menu.");
            }
        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[7] Print a list of all animals that are reserved and in service");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    /**
     * The initializeMonkeyList initializes three test cases of monkey submissions to have a starting point in the monkeyList Array.
     */
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Nerra", "Squirrel monkey", 55, 40, 11, "female", "6", "80.3", "03-18-2017", "United States", "intake", false, "United States");
        Monkey monkey2 = new Monkey("Leo", "Tamarin", 45, 46, 8, "male", "4", "65.4", "10-08-2021", "United States", "Phase I", false, "United States");
        Monkey monkey3 = new Monkey("Mary", "Macaque", 43, 48, 10, "female", "5", "70.0", "5-23-2022", "Canada", "in service", true, "Canada");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }


    /**
     * The intakeNewDog method is designed to cover all details regarding new dogs being added to the system.
     * @param scanner
     */
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Inizializes each variable with user inputs
        Dog newDog = new Dog();
        System.out.println("What breed is " + name + "?");
        String dogBreed = scanner.nextLine();
        System.out.println("What gender is " + name + "?");
        String gender = scanner.nextLine();
        System.out.println("How old is " + name + "?");
        String age = scanner.nextLine();
        System.out.println("What is the weight of " + name + "?");
        String weight = scanner.nextLine();
        System.out.println("What is the Date? Example: 05-10-2021");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Where are they from?");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("What is the training status?");
        String trainingStatus = scanner.nextLine();
        System.out.println("true or false: Is " + name + " reserved?");
        boolean reserved = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Where are they stationed?");
        String inServiceCountry = scanner.nextLine();

        newDog.setName(name);
        newDog.setBreed(dogBreed);
        newDog.setGender(gender);
        newDog.setAge(age);
        newDog.setWeight(weight);
        newDog.setAcquisitionDate(acquisitionDate);
        newDog.setAcquisitionLocation(acquisitionCountry);
        newDog.setTrainingStatus(trainingStatus);
        newDog.setReserved(reserved);
        newDog.setInServiceCountry(inServiceCountry);

        dogList.add(newDog);

        System.out.print("Successfully Added " + name + ". Returning to main menu.");
        return;
    }


    /**
     * The intakeNewMonkey method is designed to cover all details regarding new monkeys being added to the system.
     * @param scanner
     */
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            for(Monkey monkey: monkeyList) { // verifies the monkey being added is not already in the system.
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                }
            }

            // Inizializes each variable with user inputs
            Monkey newMonkey = new Monkey();
            System.out.println("What is the Species of " + name + "?");
            String monkeySpecies = scanner.nextLine();
            System.out.println("What is the length of the body?");
            int lengthOfBody = scanner.nextInt();
            System.out.println("What is the height of " + name + "?");
            int heightOfMonkey = scanner.nextInt();
            System.out.println("What is the length of the tail?");
            int lengthOfTail = scanner.nextInt();
            scanner.nextLine();
            System.out.println("What is the gender?");
            String gender = scanner.nextLine();
            System.out.println("What is the age?");
            String age = scanner.nextLine();
            System.out.println("What is the weight?");
            String weight = scanner.nextLine();
            System.out.println("What is the Date? Example: 05-10-2021");
            String acquisitionDate = scanner.nextLine();
            System.out.println("Where are they from?");
            String acquisitionCountry = scanner.nextLine();
            System.out.println("What is the training status?");
            String trainingStatus = scanner.nextLine();
            System.out.println("true or false: Is " + name + " reserved?");
            boolean reserved = scanner.nextBoolean();
            scanner.nextLine();
            System.out.println("Where are they stationed?");
            String inServiceCountry = scanner.nextLine();

            // Sets all user inputs from above to the corresponding methods called.
            newMonkey.setName(name);
            newMonkey.setSpecies(monkeySpecies);
            newMonkey.setBodyLength(lengthOfBody);
            newMonkey.setHeight(heightOfMonkey);
            newMonkey.setTailLength(lengthOfTail);
            newMonkey.setGender(gender);
            newMonkey.setAge(age);
            newMonkey.setWeight(weight);
            newMonkey.setAcquisitionDate(acquisitionDate);
            newMonkey.setAcquisitionLocation(acquisitionCountry);
            newMonkey.setTrainingStatus(trainingStatus);
            newMonkey.setReserved(reserved);
            newMonkey.setInServiceCountry(inServiceCountry);

            monkeyList.add(newMonkey); // Adds the new monkey to the list.

            System.out.print("Successfully Added " + name + ". Returning to main menu.");
            return;
        }

        /**
         * The reserveAnimal method is used to reserve an animal that fits the proper specification.
         * @param scanner
         * Those specifications are as follows:
         * Checks for if animal type is a dog or a monkey
         * Checks for the in-service country of desire
         * 
         */
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("Enter the animal type (dog or monkey):");
            String animalType = scanner.nextLine().toLowerCase();
            
            if (animalType.equals("dog")) {
                System.out.println("Enter the in-service country:");
                String inServiceCountry = scanner.nextLine();
                
                for (Dog dog : dogList) {
                    if (dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry) && !dog.getReserved()) {
                        dog.setReserved(true);
                        System.out.println(dog.getName() + " has been reserved.");
                        return;
                    }
                }
            } else if (animalType.equals("monkey")) {
                System.out.println("Enter the in-service country:");
                String inServiceCountry = scanner.nextLine();
                
                for (Monkey monkey : monkeyList) {
                    if (monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry) && !monkey.getReserved()) {
                        monkey.setReserved(true);
                        System.out.println(monkey.getName() + " has been reserved.");
                        return;
                    }
                }
            } else {
                System.out.println("Invalid animal type. Please enter 'dog' or 'monkey'.");
            }
        
            System.out.println("No available animal of the specified type and country found.");
        }

    /**
     * The printAnimals method is used to show a user the list they selected during the main menu prompt.
     * @param option Gets the user input that was gathered from the main menu
     */
    public static void printAnimals(String option) {
    
        switch (option) {
            case "4": // If option 4 is selected by the user, this block runs
                System.out.println("List of Dogs:");
                for (Dog dog : dogList) {
                    System.out.println("Name: " + dog.getName());
                    System.out.println("Status: " + dog.getTrainingStatus());
                    System.out.println("Acquisition Country: " + dog.getAcquisitionLocation());
                    System.out.println("Reserved: " + (dog.getReserved() ? "Yes" : "No"));
                    System.out.println();
                }
                break;
            case "5": // If option 5 is selected by the user, this block runs
                System.out.println("List of Monkeys:");
                for (Monkey monkey : monkeyList) {
                    System.out.println("Name: " + monkey.getName());
                    System.out.println("Status: " + monkey.getTrainingStatus());
                    System.out.println("Acquisition Country: " + monkey.getAcquisitionLocation());
                    System.out.println("Reserved: " + (monkey.getReserved() ? "Yes" : "No"));
                    System.out.println();
                }
                break;
            case "6": // If option 6 is selected by the user, this block runs
                System.out.println("List of Available Animals:");
                for (Dog dog : dogList) {
                    if (dog.getTrainingStatus() != "in service" && !dog.getReserved()) {
                        System.out.println("Name: " + dog.getName());
                        System.out.println("Type: Dog");
                        System.out.println("Status: " + dog.getTrainingStatus());
                        System.out.println("Acquisition Country: " + dog.getAcquisitionLocation());
                        System.out.println("Reserved: No");
                        System.out.println();
                    }
                }
                for (Monkey monkey : monkeyList) {
                    if (monkey.getTrainingStatus() != "in service" && !monkey.getReserved()) {
                        System.out.println("Name: " + monkey.getName());
                        System.out.println("Type: Monkey");
                        System.out.println("Status: " + monkey.getTrainingStatus());
                        System.out.println("Acquisition Country: " + monkey.getAcquisitionLocation());
                        System.out.println("Reserved: No");
                        System.out.println();
                    }
                }
                break;
            case "7": // If option 7 is selected by the user, this block runs
                System.out.println("List of In Service Animals:");
                for (Dog dog : dogList) {
                    if (dog.getTrainingStatus() == "in service" && dog.getReserved() == true) {
                        System.out.println("Name: " + dog.getName());
                        System.out.println("Type: Dog");
                        System.out.println("Status: " + dog.getTrainingStatus());
                        System.out.println("Acquisition Country: " + dog.getAcquisitionLocation());
                        System.out.println("Reserved: Yes");
                        System.out.println();
                    }
                }
                for (Monkey monkey : monkeyList) {
                    if (monkey.getTrainingStatus() == "in service" && !monkey.getReserved() == true) {
                        System.out.println("Name: " + monkey.getName());
                        System.out.println("Type: Monkey");
                        System.out.println("Status: " + monkey.getTrainingStatus());
                        System.out.println("Acquisition Country: " + monkey.getAcquisitionLocation());
                        System.out.println("Reserved: Yes");
                        System.out.println();
                    }
                }
                break;
            default:
                System.out.println("Invalid list type. Please choose 'dog', 'monkey', or 'available'.");
                break;
        }
    }    
}

