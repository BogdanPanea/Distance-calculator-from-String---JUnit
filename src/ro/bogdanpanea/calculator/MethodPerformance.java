package ro.bogdanpanea.calculator;

public class MethodPerformance {

    private String methodType;
    private String input;
    private long executinTime;

    public MethodPerformance(String functionName, String input, long time) {
        this.methodType = functionName;
        this.input = input;
        this.executinTime = time;
    }

    @Override
    public String toString() {
        return "MethodPerformance{" +
                "methodType='" + methodType + '\'' +
                ", input='" + input + '\'' +
                ", executinTime=" + executinTime +
                '}';
    }
}
