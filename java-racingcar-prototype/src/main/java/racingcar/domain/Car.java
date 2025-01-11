package racingcar.domain;

public class Car {
    private final String name;
    private int progress;

    public Car(String name) {
        this.name = name;
        this.progress = 0;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    // 전진 조건에 따라 이동
    public void move(int randomValue){
        if (randomValue >= 4) {
            progress++;
        }
    }

    // 현재 위치 출력
    public String displayProgress(){
        return name + " : " + "-".repeat(progress);
    }
}
