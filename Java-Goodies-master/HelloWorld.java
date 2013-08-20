/**
 * Created by IntelliJ IDEA.
 * User: kb9agt
 * Date: Apr 27, 2012
 * Time: 4:14:05 PM
 * File: HelloWorld.java
 */
public class HelloWorld {

    public static String Constructor_message;
    public static String setter_getter_message;

    public HelloWorld(String text) {
        Constructor_message = text;
    }

    public static String getSetter_getter_message() {
        return setter_getter_message;
    }

    public static void setSetter_getter_message(String text) {
        HelloWorld.setter_getter_message = text;
    }

    public static void main(String s[]){

        // Create the message text string.
        String text = "Hello World! I got here from the Constructor.";

        // Use the constructor and set the text string.
        HelloWorld name = new HelloWorld(text);

        // Output the message to the console.
        System.out.println(name.Constructor_message);

        // Create a new message for setter method.
        String text1 = "Hello World! I got here from the set and get methods.";
        name. setSetter_getter_message(text1);

        // Output the message to the console.
        System.out.println(name.setter_getter_message);
    }
}
