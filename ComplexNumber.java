import java.util.Objects;

public class ComplexNumber extends SpecialNumber implements Comparable<ComplexNumber>{
    public double real;
    public double imaginary;

    public ComplexNumber(double r, double i){
        this.real = r;
        this.imaginary = i;
    }

    @Override
    public int compareTo(ComplexNumber num) {
        double real1 = this.real;
        double real2 = num.real;
        
        double imaginary1 = this.imaginary;
        double imaginary2 = num.imaginary;

        double magnitude1 = Math.sqrt((Math.pow(real1, 2)) + Math.pow(imaginary1, 2));
        double magnitude2 = Math.sqrt((Math.pow(real2, 2)) + Math.pow(imaginary2, 2));

        return Double.compare(magnitude1, magnitude2);
    }

    @Override
    public boolean equals(Object c){
        if(!(c instanceof ComplexNumber)){
            return false;
        }

        return this == c || this.compareTo((ComplexNumber) c) == 0;
    }

    @Override
    public int hashCode(){
        return Objects.hash(real, imaginary);
    }

    public SpecialNumber add(SpecialNumber num) throws Lab3Exception{
        if(!(num instanceof ComplexNumber)){
            throw new Lab3Exception("Cannot add an incompatible type");
        }

        ComplexNumber comNum = (ComplexNumber) num;

        double newReal = comNum.real + this.real;
        double newImaginary = comNum.imaginary + this.imaginary;

        ComplexNumber newNum = new ComplexNumber(newReal, newImaginary);
        return newNum;
    }

    public SpecialNumber divideByInt(int divisor) throws Lab3Exception{
        if(divisor == 0){
            throw new Lab3Exception("Cannot divide by zero");
        }

        double newReal = this.real / divisor;
        double newImaginary = this.imaginary / divisor;

        ComplexNumber newNum = new ComplexNumber(newReal, newImaginary);
        return newNum;
    }
}
