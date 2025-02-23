package exception;

public enum ErrorMessage {

    INPUT_NOT_NULL("입력 문자열이 Null 이면 안 됩니다."),
    INPUT_NOT_EMPTY("입력 문자열이 비어있으면 안 됩니다."),
    INPUT_NOT_BLANK("입력 문자열에 공백이 존재하면 안 됩니다."),
    INPUT_EMPTY_OPERATOR("마지막 문자가 유효한 연산자가 아닙니다."),
    OPERATOR_MUST_HAVE_PRECEDING_SPACE("입력 문자열의 사칙연산 앞에는 공백이 존재해야 합니다."),
    OPERATOR_MUST_LAST_INDEX("입력 문자열의 사칙연산은 마지막 인덱스에 존재해야 합니다."),
    CONTINUOUS_SEPARATOR("입력 문자열에 연속된 구분자가 존재하면 안 됩니다."),
    SEPARATOR_NOT_FOUND("존재하지 않는 구분자입니다."),
    MUST_CHANGE_NUMBER("숫자로 변환 가능해야합니다."),
    CANNOT_DIVIDE_BY_ZERO("0으로 나눌 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}