package lab3;
import java.util.Objects;

/**
 * The RationalNumber class represents a rational number, which is the ratio of two integers
 * It contains the same properties of operations of rational numbers and comparing rational numbers
 */
public class RationalNumber extends SpecialNumber implements Comparable<RationalNumber>{
    /** Numerator of the rational number */
    public int numerator;

    /** Denominator of the rational number */
    public int denominator;

    /**
     * Constructs a RationalNumber given a numerator num and denominator den
     * @param num the numerator of the rational number
     * @param den the denominator of the rational number
     * @throws Lab3Exception throws exception if the denominator given equals 0
     */
    public RationalNumber(int num, int den) throws Lab3Exception{
        if(den == 0){
            throw new Lab3Exception("Denominator cannot be zero");
        }

        this.numerator = num;
        this.denominator = den;
    }

    @Override
    /**
     * Compares two elements of type RationalNumber
     * @param num the number to compare to
     * @return an integer representing the equivalence of the two rational numbers
     */
    public int compareTo(RationalNumber num) {
        int num1 = this.numerator * num.denominator;
        int num2 = this.denominator * num.numerator;

        return Integer.compare(num1, num2);
    }

    @Override
    /**
     * Checks to see if two elements of type RationalNumber are equal
     * @param r is of type Object but the method checks if it's an instance of RationalNumber
     * @return returns a boolean representing the equivalence of the rational number calling the method and r
     */
    public boolean equals(Object r){
        if(!(r instanceof RationalNumber)){
            return false;
        }

        return this == r || this.compareTo((RationalNumber) r) == 0;
    }

    @Override
    /**
     * Assigns an integer value to equivalent rational numbers
     * @return returns and integer representing the hash code for the specific rational number
     */
    public int hashCode(){
        return Objects.hash(numerator, denominator);
    }

    /**
     * Computes the sum of two elements of type SpecialNumber (In this case of type RationalNumber)
     * @param num an element of type SpecialNumber to be added to the variable that called the method
     * @throws Lab3Exception if num is not an instance of RationalNumber
     * @return returns the sum, of type RationalNumber, of the two rational numbers
     */
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

    /**
     * Computes the quotient of a rational number being divided by an integer
     * @param divisor is of type int that divides the rational number
     * @throws Lab3Exception if the divisor equals 0
     * @return returns the quotient, of type RationalNumber, of the rational number being divided by the divisor
     */
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
