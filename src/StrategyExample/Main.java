package StrategyExample;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] numbers = {5, 2, 9, 1, 5, 6};

    SortContext context = new SortContext(new BubbleSort());
    int[] numbersCopy = numbers.clone();
    context.executeSort(numbersCopy);
    System.out.println(Arrays.toString(numbersCopy));

    context.setStrategy(new QuickSort());
    numbersCopy = numbers.clone();
    context.executeSort(numbersCopy);
    System.out.println(Arrays.toString(numbersCopy));
  }
}
