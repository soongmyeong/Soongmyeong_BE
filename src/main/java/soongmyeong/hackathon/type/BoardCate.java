package soongmyeong.hackathon.type;

public enum BoardCate {
    HOBBY(1),
    WORK(2),
    OTHER(3);

    private final int value;

    BoardCate(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
