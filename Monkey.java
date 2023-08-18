/**
 * The Monkey class designed below describes different details regarding a monkey, detailing things such as species, height, body length, etc.
 */

public class Monkey extends RescueAnimal {
    private String species;
    private int bodyLength;
    private int height;
    private int tailLength;

    /**
     * The base Contructor to initialize the following:
     * species is initialized to an empty string.
     * bodyLength, height, and tailLength all are initiallized to 0.0.
     */
    public Monkey() {
        species = "";
        bodyLength = 0;
        height = 0;
        tailLength = 0;
    }

    /**
     * This constuctor is designed to allow for developing test cases for the Monkey class. All params below are included for initiallizing test cases.
     * @param name
     * @param species
     * @param bodyLength
     * @param height
     * @param tailLength
     * @param gender
     * @param age
     * @param weight
     * @param acquisitionDate
     * @param acquisitionCountry
     * @param trainingStatus
     * @param reserved
     * @param inServiceCountry
     */
    public Monkey(String name, String species, int bodyLength, int height, int tailLength,
    String gender, String age, String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setSpecies(species);
        setBodyLength(bodyLength);
        setHeight(height);
        setTailLength(tailLength);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
    }

    /**
     * Monkey Species Accessor and Mutator
     */
    // Accessor Method
    public String getSpecies() {
        return species;
    }

    // Mutator Method
    public void setSpecies(String monkeySpecies) {
        species = monkeySpecies;
    }

    /**
     * Body Length Accessor and Mutator
     */
    // Accessor Method
    public int getBodyLength() {
        return bodyLength;
    }

    // Mutator Method
    public void setBodyLength(int lengthOfBody) {
        bodyLength = lengthOfBody;
    }

    /**
     * Height Accessor and Mutator
     */
    // Accessor Method
    public int getHeight() {
        return height;
    }

    // Mutator Method
    public void setHeight(int heightOfMonkey) {
        height = heightOfMonkey;
    }

    /**
     * Tail Length Accessor and Mutator
     */
    // Accessor Method
    public int getTailLength() {
        return tailLength;
    }

    // Mutator Method
    public void setTailLength(int lengthOfTail) {
        tailLength = lengthOfTail;
    }
}
