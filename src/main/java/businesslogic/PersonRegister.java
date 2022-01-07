package businesslogic;

/**
 * class that represents a register of multiple person objects
 */
public class PersonRegister {


    //--------Singleton pattern-----------------------------
    private static PersonRegister register = new PersonRegister();
    private PersonRegister(){}
    //-----------------------------------------------------

    //ArrayList<Person> people = new ArrayList<>();

    //simple example where i just create an instance of 1 person as a class member
    Person p = new Person("karsten", "Mjølnerparken 8");


    /**
     * method for getting the instance of the class
     * @return the instance of the class
     */
    public static PersonRegister getRegister(){return register;}


    /**
     * method for getting the person class member
     * @return the person class member
     */
    public Person getPerson(){return this.p;}




    //can be implemented if we want a list of persons---------------
    /**
     * Method for adding a person to the list (register)
     * @param xiJinping the person to add
     */
    //public void addPerson(Person xiJinping){people.add(xiJinping);}
    //------------------------------------------------------------



}
