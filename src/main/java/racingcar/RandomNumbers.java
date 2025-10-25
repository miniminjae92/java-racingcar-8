package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

public class RandomNumbers {

    public List<Integer> generateRandomNumbers(int size) {
        return Stream.generate(()->Randoms.pickNumberInRange(0, 9))
                .limit(size)
                .toList();
    }
}
