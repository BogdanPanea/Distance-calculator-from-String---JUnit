package ro.bogdanpanea.calculator;

public class DistanceFromExpressionException extends Exception {

    private String errCode;

    DistanceFromExpressionException(String message, String err) {

        super(message);
        this.errCode = err;
    }

    public String getErrCode() {
        return errCode;
    }

}

