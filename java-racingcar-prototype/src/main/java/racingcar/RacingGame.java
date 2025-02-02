package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println("실행 결과");
        for (int i = 0; i < trialCount; i++) {
            playOneRound();
            OutputView.printRoundResults(cars);
        }
    }

    public void playOneRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    public List<String> findWinners() {
        int maxProgress = cars.stream()
                .mapToInt(Car::getProgress)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getProgress() == maxProgress)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
