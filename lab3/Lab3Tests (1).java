package lab3;

import java.util.List;
import java.util.ArrayList;

class Lab3Tests {

    public static void main(String[] args) throws Exception {
        Lab3Tests tests = new Lab3Tests();
        tests.testException1();
        tests.testException2();
        tests.testException3();
        tests.testHashCode();
        tests.testEquals();
        tests.testAverageRationalNumber();
        tests.testAverageComplexNumber();
        tests.testSort();
    }

    void testException1() {
        try {
            RationalNumber r = new RationalNumber(1, 0);
            System.out.println("testException1 failed: No exception thrown");
        } catch (Lab3Exception ex) {
            if ("Denominator cannot be zero".equals(ex.message)) {
                System.out.println("testException1 passed");
            } else {
                System.out.println("testException1 failed: Wrong message " + ex.message);
            }
        }
    }

    void testException2() {
        try {
            SpecialNumber.computeAverage(null);
            System.out.println("testException2 failed: No exception thrown");
        } catch (Lab3Exception ex) {
            if ("List cannot be empty".equals(ex.message)) {
                System.out.println("testException2 passed");
            } else {
                System.out.println("testException2 failed: Wrong message " + ex.message);
            }
        }
    }

    void testException3() {
        try {
            RationalNumber r = new RationalNumber(1, 1);
            r.add(new ComplexNumber(1, 1));
            System.out.println("testException3 failed: No exception thrown");
        } catch (Lab3Exception ex) {
            if ("Cannot add an incompatible type".equals(ex.message)) {
                System.out.println("testException3 passed");
            } else {
                System.out.println("testException3 failed: Wrong message " + ex.message);
            }
        }
    }

    void testHashCode() throws Exception {
        RationalNumber r1 = new RationalNumber(1, 2);
        RationalNumber r2 = new RationalNumber(2, 4);
        if (r1.hashCode() == r2.hashCode()) {
            System.out.println("testHashCode passed");
        } else {
            System.out.println("testHashCode failed");
        }
    }

    void testEquals() throws Exception {
        RationalNumber r1 = new RationalNumber(1, 2);
        RationalNumber r2 = new RationalNumber(2, 4);
        if (r1.equals(r2)) {
            System.out.println("testEquals passed");
        } else {
            System.out.println("testEquals failed");
        }
    }

    void testAverageRationalNumber() throws Exception {
        List<SpecialNumber> A = new ArrayList<>();
        A.add(new RationalNumber(3, 2));
        A.add(new RationalNumber(1, 1));
        A.add(new RationalNumber(1, 4));
        if (SpecialNumber.computeAverage(A).equals(new RationalNumber(11, 12))) {
            System.out.println("testAverageRationalNumber passed");
        } else {
            System.out.println("testAverageRationalNumber failed");
        }
    }

    void testAverageComplexNumber() throws Exception {
        List<SpecialNumber> A = new ArrayList<>();
        A.add(new ComplexNumber(3, 2));
        A.add(new ComplexNumber(1, 1));
        A.add(new ComplexNumber(1, 4));
        A.add(new ComplexNumber(5, 1));
        if (SpecialNumber.computeAverage(A).equals(new ComplexNumber(2.5, 2))) {
            System.out.println("testAverageComplexNumber passed");
        } else {
            System.out.println("testAverageComplexNumber failed");
        }
    }

    void testSort() throws Exception {
        RationalNumber a = new RationalNumber(3, 2);
        RationalNumber b = new RationalNumber(1, 1);
        RationalNumber c = new RationalNumber(1, 4);

        List<SpecialNumber> L1 = new ArrayList<>();
        L1.add(a);
        L1.add(b);
        L1.add(c);

        List<SpecialNumber> L2 = new ArrayList<>();
        L2.add(c);
        L2.add(b);
        L2.add(a);

        L1.sort(null); // Sorting L1

        if (L1.equals(L2)) {
            System.out.println("testSort passed");
        } else {
            System.out.println("testSort failed");
        }
    }
}
