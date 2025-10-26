package racingcar.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomNumbersTest {

    @RepeatedTest(1000)
    void 주어진_범위와_사이즈만큼의_숫자를_생성한다() {
        RandomNumbers rn = new RandomNumbers();

        List<Integer> result = rn.generateRandomNumbers(1000);

        assertThat(result).allMatch(n -> n >= 0 && n <= 9);
        assertThat(result).hasSize(1000);
    }

    @Test
    void 사이즈가_0이_들어올경우_빈리스트를_반환한다() {
        RandomNumbers rn = new RandomNumbers();

        List<Integer> result = rn.generateRandomNumbers(0);

        assertThat(result).isEmpty();
    }

    @Test
    void 사이즈가_0보다_작은_수가_들어올경우_예외발생한다() {
        RandomNumbers rn = new RandomNumbers();

        assertThatIllegalArgumentException().isThrownBy(() -> rn.generateRandomNumbers(-1));
    }
}