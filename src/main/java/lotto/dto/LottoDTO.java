package lotto.dto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoDTO {
    private final List<Integer> numbers;

    private LottoDTO(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoDTO from(List<Integer> numbers) {
        return new LottoDTO(numbers);
    }

    public List<Integer> getNumbers() {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        copyNumbers.sort(Comparator.naturalOrder());
        return copyNumbers;
    }
}