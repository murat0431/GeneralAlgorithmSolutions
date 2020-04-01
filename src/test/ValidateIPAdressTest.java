package test;

public class ValidateIPAdressTest implements Test{
    @Override
    public <T> boolean test(T expected, T result) {
        return expected == result;
    }
}
