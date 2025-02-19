#StringCalculator 문자열 사칙연산 계산기

기능 요구사항

1. 사용자가 입력한 문자열 값에 따라 사칙연산을 수행하는 계산기 구현
2. 입력 문자열의 숫자와 사칙 연산 기호 사이에는 공백이 포함되어야 한다.
3. 숫자는 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달 할 경우 구분자를 기준으로 분리한 각 숫자와, 마지 막에 하나의 공백을 가지고 전달된 연산자의 계산 결과를 반환. (아래 입출력예시 참고)
4. 연산자의 경우 하나만 입력 받는다.
5. 사칙 연산만 포함한다.
6. 소숫점의 경우 0.1, 0.2 와 같이 소숫점 첫째짜리까지 표시
7. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생 시킨다.

프로그래밍 요구사항 
1. 각 메소드는 하나의 일만 진행한다
2. 입력 값이 빈 문자열이거나, null인경우 IllegalArgumentException을 발생하고, 어떤 예외인지 알 수 있도록 에러 메시지 포함
3. 사칙연산 기호가 아닌경우 IllegalArgumentException을 발생하고, 에러 메시지 포함
4. 그 외 다양한 예외 케이스에 대해서는 본인이 생각해서 구현진행
5. 각 메소드의 depth는 2 depth 까지만 허용

입력 예시

1:2,3:4 +
6:10,2:3 *
7,2:3 -
4:2,5 /
출력 예시

1+2+3+4 = 10
6102*3 = 360
7-2-3 = 2
4/2/5 = 0.4

클래스 구조 설계 
├── src
│   ├── Main.java
│   ├── calculator
│   │   └── Calculator.java
│   ├── exception
│   │   └── ErrorMessage.java
│   ├── io
│   │   ├── Input.java
│   │   └── Output.java
│   ├── operator
│   │   ├── Operation.java
│   │   ├── OperatorHandler.java
│   │   └── OperatorParser.java
│   ├── separator
│   │   └── Separator.java
│   └── validation
│       └── InputValidation.java
├── test
│   ├── calculator
│   │   └── CalculatorTest.java
│   ├── io
│   │   └── InputTest.java
│   └── operator
│       └── OperatorTest.java
└── 디렉토리.txt


예외 처리

1. 입력 값이 빈 문자열이거나, null인 경우 IllegalArgumentException 발생
2. 입력 값에 잘못된 구분자가 들어간 경우 IllegalArgumentException 발생
3. 입력 값 마지막 문자가 정해진 사칙연산이 아닌 경우 IllegalArgumentException 발생
4. 입력 값에서 0으로 나눌려고 시도할 경우 IllegalArgumentException 발생
5. 입력 값에서 숫자를 추출할 때 잘못된 추출을 시도하면 IllegalArgumentException 발생
6. 입력 값에 연속된 구분자가 존재하면 IllegalArgumentException 발생
7. 입력 값에 사칙연산 앞 문자가 공백이 아니면 IllegalArgumentException 발생
8. 입력 값에 공백이 존재하면 IllegalArgumentException 발생
