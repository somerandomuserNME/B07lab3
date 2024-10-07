package lab3;
import java.util.Objects;

public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber>{
    public int numerator;
    public int denominator;

    public RationalNumber(int num, int den) throws Lab3Exception{
        if(den == 0){
            throw new Lab3Exception("Denominator cannot be zero");
        }

        this.numerator = num;
        this.denominator = den;
    }

    @Override
    public int compareTo(RationalNumber num) {
        int num1 = this.numerator * num.denominator;
        int num2 = this.denominator * num.numerator;

        return Integer.compare(num1, num2);
    }

    @Override
    public boolean equals(Object r){
        if(!(r instanceof RationalNumber)){
            return false;
        }

        return this == r || this.compareTo((RationalNumber) r) == 0;
    }

    @Override
    public int hashCode(){
        return Objects.hash(numerator, denominator);
    }

    public SpecialNumber add(SpecialNumber num) throws Lab3Exception{
        if(!(num instanceof RationalNumber)){
            throw new Lab3Exception("Cannot add an incompatible type");
        }

        RationalNumber newNum = (RationalNumber) num;

        int newNumerator = (this.numerator * newNum.denominator) + (newNum.numerator * this.denominator);
        int newDenominator = this.denominator * newNum.denominator;

        RationalNumber finalNum = new RationalNumber(newNumerator, newDenominator);
        
        return finalNum;
    }

    public SpecialNumber divideByInt(int divisor) throws Lab3Exception{
        if(divisor == 0){
            throw new Lab3Exception("Cannot divide by 0");
        }

        RationalNumber newThing = new RationalNumber(1, divisor);

        int newNumerator = this.numerator * newThing.numerator;
        int newDenominator = this.denominator * newThing.denominator;

        RationalNumber finalNum = new RationalNumber(newNumerator, newDenominator);

        return finalNum;
    }
}
