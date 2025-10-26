package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class CarsTest {

    private Cars cars;

    @BeforeEach
    void setup() {
        this.cars = new Cars(List.of("a", "b", "c"));
    }

    @Test
    void 중복된_이름을_가지면_예외를_발생시킨다() {
        List<String> carNames = List.of("x", "x");

        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(carNames));
    }

    @Test
    void 모든_자동차가_주어진_값에_따라_올바르게_움직인다() {
        List<Integer> random = List.of(4, 3, 9);

        cars.moveAll(random);

        List<Car> carList = new ArrayList<>();
        cars.iterator().forEachRemaining(carList::add);

        assertThat(carList.get(0).getPosition()).isEqualTo(1);
        assertThat(carList.get(1).getPosition()).isEqualTo(0);
        assertThat(carList.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void 최대_위치를_가진_우승자를_정확히_반환한다() {
        List<Integer> random = List.of(0, 9, 4);

        cars.moveAll(random);
        cars.moveAll(random);
        List<String> winnerNames = cars.getWinnerNames();

        assertThat(winnerNames).containsExactlyInAnyOrder("c", "b");

        List<Car> carList = new ArrayList<>();
        cars.iterator().forEachRemaining(carList::add);

        assertThat(carList.get(0).getPosition()).isEqualTo(0);
        assertThat(carList.get(1).getPosition()).isEqualTo(2);
        assertThat(carList.get(2).getPosition()).isEqualTo(2);
    }
}