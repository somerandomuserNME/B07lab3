import java.util.List;

abstract class SpecialNumber{
    abstract SpecialNumber add(SpecialNumber number) throws Lab3Exception;
    abstract SpecialNumber divideByInt(int divisor) throws Lab3Exception;

    public SpecialNumber computeAverage(List<SpecialNumber> l) throws Lab3Exception{
        if(l == null || l.isEmpty()){
            throw new Lab3Exception("List cannot be empty");
        }

        SpecialNumber sum = l.get(0);

        for(int i = 1; i < l.size(); i++){
            sum = sum.add(l.get(i));
        }

        return sum.divideByInt(l.size());
    }
}