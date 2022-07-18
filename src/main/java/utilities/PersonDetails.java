package utilities;

import java.util.Random;
import utilities.StringUtils;

public class PersonDetails {

  String [] city;
  String [] phonenumber;
       // ,lastName, city , county , addressline1 , addresslin2 ,
         // addressline3, zipcode ;

  public PersonDetails() {
    city= new String[]{ "Somerset", "Northamptonshire",
                    "Antrim",
                    "Durham",
                    "Dorset",
                    "Hertfordshire",
                    "Derbyshire",
                    "Sussex"
                  };
    phonenumber = new String [] {
                  "01455 841153","01455 941153","03455 841153",
                  "01455 845153","01455 946653","03455 541153",
                  };

  }
  public String getCity() {
    Random generator = new Random();
    int randomNumber = generator.nextInt(city.length);
    return city[randomNumber];
  }

  public String getPhoneNumber() {
    Random generator = new Random();
    int randomNumber = generator.nextInt(phonenumber.length);
    return phonenumber[randomNumber];
  }

}
