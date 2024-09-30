class Lab3Exception extends Exception{
    public String message;

    public Lab3Exception(String input){
        this.message = input;
    }
}