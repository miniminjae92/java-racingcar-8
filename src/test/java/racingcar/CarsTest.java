package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class CarsTest {

    @Test
    void 중복된_이름을_가지면_예외를_발생시킨다() {
        List<String> carNames = List.of("x", "x");

        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(carNames));
    }

}