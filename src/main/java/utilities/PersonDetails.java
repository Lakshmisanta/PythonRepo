package utilities;

import java.util.Random;
import utilities.StringUtils;

public class PersonDetails {

  String [] city;
      // , firstName ,lastName, city , county , addressline1 , addresslin2 ,
         // addressline3, zipcode ;

  public PersonDetails() {
    city= new String[]{ "Somerset", "Northamptonshire",
                    "Antrim",
                    "Durham",
                    "Dorset",
                    "Hertfordshire",
                    "Derbyshire",
                    "Sussex"
                   }
  }
  public getCity() {
    Random generator = new Random();
    int randomNumber = generator.nextInt(city.length);
    System.out.println(city[randomNumber]);
    return city[randomNumber];
  }

  public static void main (String [] args) {
      this.getCity();
  }
}
