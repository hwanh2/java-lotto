package lotto.generator;

import java.util.List;

public class FixNumberGenerator implements NumberGenerator {
    private final List<Integer> fixNumbers;

    public FixNumberGenerator(List<Integer> fixNumbers) {
        this.fixNumbers = fixNumbers;
    }

    @Override
    public List<Integer> generate() {
        return fixNumbers;
    }
}