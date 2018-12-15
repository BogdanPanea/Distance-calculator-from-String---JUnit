package ro.bogdanpanea.calculator;

public class SumStringFromExpressionException extends Exception {

    private String errCode;

    SumStringFromExpressionException(String message, String errCode) {

        super( message );
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }

}

