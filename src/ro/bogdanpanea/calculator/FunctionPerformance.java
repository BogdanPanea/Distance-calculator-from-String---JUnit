package ro.bogdanpanea.calculator;

public class FunctionPerformance {

    private String functionName;
    private String input;
    private long executinTime;

    public FunctionPerformance(String functionName, String input, int time) {
        this.functionName = functionName;
        this.input = input;
        this.executinTime = time;
    }
}
