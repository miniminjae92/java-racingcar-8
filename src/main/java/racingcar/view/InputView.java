package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public static final String PROMPT_FOR_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String PROMPT_FOR_ROUNDS = "시도할 횟수는 몇 회인가요?";

    public List<String> readCarNames() {
        System.out.println(PROMPT_FOR_CAR_NAME);
        return separateComma(validateString(Console.readLine()));
    }

    public int readRoundCounts() {
        System.out.println(PROMPT_FOR_ROUNDS);
        return validateCounts(Console.readLine());
    }

    private String validateString(String input) {
       if (input.isEmpty()) {
           throw new IllegalArgumentException("입력은 null이 될 수 없습니다.");
       }
       return input;
    }

    private List<String> separateComma(String input) {
        List<String> seperated = List.of(input.split(","));
        return seperated.stream().map(String::trim).toList();
    }

    private int validateCounts(String input) {
       int count = Integer.parseInt(input);
       if (count <= 0) {
          throw new IllegalArgumentException("시도할 횟수는 0보다 커야합니다.");
       }
       return count;
    }
}
