package hexlet.code;

public final class Difference {
    private final String key;
    private final String result;
    private final Object value1;
    private final Object value2;

    public String getKey() {
        return key;
    }

    public String getResult() {
        return result;
    }

    public Object getValue1() {
        return value1;
    }

    public Object getValue2() {
        return value2;
    }

    public Difference(String key, String result, Object value1, Object value2) {
        this.key = key;
        this.result = result;
        this.value1 = value1;
        this.value2 = value2;
    }
}
