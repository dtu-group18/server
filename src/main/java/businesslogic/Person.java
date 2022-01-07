package businesslogic;
import lombok.NoArgsConstructor;

/**
 * Simple class representing a person
 */
@NoArgsConstructor
public class Person {

   private String name, address;

    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    public void setAddress(String address) {this.address = address;}

    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}

    public String getName() {return name;}
}
