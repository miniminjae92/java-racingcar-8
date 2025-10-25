package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

// 5자 이하의 이름을 가진다.
// 이름은 영어/한글/숫자만 허용한다고 가정
// 전진 또는 정지 기능이 있다, 위치를 가진다.
public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"test", "test1", "1", "a", "한글", "한글a1"})
    void 올바른_이름을_가진다(String carName) {
        Car car = new Car(carName);

        assertThat(carName).isEqualTo(car.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"testtt", "", "        ", "         test", "!", "test@"})
    void 유효하지않은_이름을_가진다(String carName) {
        assertThatIllegalArgumentException().isThrownBy(()->new Car(carName));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진_이동한다(int num) {
        Car car = new Car("test");
        car.move(num);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 1, 2, 3, 10})
    void 정지한다(int num) {
        Car car = new Car("test");
        car.move(num);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
