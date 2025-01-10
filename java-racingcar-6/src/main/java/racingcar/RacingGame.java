package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int trialCount;

    public RacingGame(List<String> carNames, int trialCount) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.trialCount = trialCount;
    }

    public void start() {
        for (int i = 0; i < trialCount; i++) {
            playOneRound();
            printProgress();
        }
    }

    public void playOneRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    public void printProgress() {
        for (Car car : cars) {
            System.out.println(car.displayProgress());
        }
    }
}
