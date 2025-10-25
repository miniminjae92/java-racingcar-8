package racingcar.domain;

import java.util.regex.Pattern;

public class Car {

    public static final int MAX_NAME_LENGTH = 5;
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9가-힣]{1,5}$");
    private final String name;
    private int position;

    public Car(String name) {
        this.name=validateCarName(name);
    }

    public void move(int num) {
        if (isMove(num)) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private Boolean isMove(int num) {
        return num >= 4 && num <= 9;
    }

    private String validateCarName(String name) {
        checkBlank(name);
        checkLength(name);
        checkPattern(name);
        return name;
    }

    private void checkBlank(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null일 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Invalid name: " + name + ": 이름에 공백은 불가합니다.");
        }
    }

    private void checkLength(String name) {
       if (name.length() > MAX_NAME_LENGTH) {
           throw new IllegalArgumentException("Invalid name: " + name + ": 5자 이하의 이름만 가능합니다.");
       }
    }

    private void checkPattern(String name) {
        if (!NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException("유효하지 않은 닉네임입니다.");
        }
    }

}
