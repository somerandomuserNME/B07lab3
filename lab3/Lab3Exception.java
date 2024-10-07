package lab3;

public class Lab3Exception extends Exception{
    public String message;

    public Lab3Exception(String input){
        super(input);
        this.message = input;
    }
}