# O que é

Um padrão de projeto da família dos comportamentais, que basicamente pega uma família de algoritmos para semelhantes, coloca-os em classes distintas e torna estas classes intercambiáveis, parece complicado, mas será bem simples de entender com os exemplos abaixo.

## Problemas

Vamos supor que eu esteja fazendo um sistema de ordenação de diferente tipos de dados, em diferentes quantidades, para melhorar a performance, eu implemento diversos algoritmos de ordenação, e deixo para escolher qual irei usar ao executar o meu sistema, em uma aplicação que não aplique o Strategy, eu teria uma classe chamada de Algoritmos, e um método cheio de `if...else` ou `switch...case` para determinar qual algoritmo irei usar, isso ao longo do tempo, pode ficar difícil de manter, então é um excelente caso para se usar o Strategy.

## Solução

O Strategy usa dois conceitos, o próprio `Strategy` que pode ser simplificado para uma interface ou classe abstrata a ser usado como estratégia para uma determinada ação, e o `Context` a classe responsável por decidir qual estratégia seguir, no exemplo do sistema de ordenação, poderíamos ter uma interface com um único método `sort`, e diversas classes implementando esta interface, desta forma cada algoritmo fica encapsulado em sua classe, e podemos decidir em tempo de execução qual usar, só mudando a estratégia usada pelo contexto.

# Código

Neste exemplo, implementamos poucos algoritmos para não aumentar a complexidade, mas quanto mais algoritmos usados, melhor seria o motivo para se usar o Strategy:

- Interface Strategy, que será implementado por outras classes:

```java
package StrategyExample;

public interface SortStrategy {
	public void sort(int[] array);
}
```

- Classe de Contexto, usada para definir qual estratégia usar:

```java
package StrategyExample;

public class SortContext {
	private SortStrategy strategy;

	public SortContext(SortStrategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(SortStrategy strategy) {
		this.strategy = strategy;
	}

	public void executeSort(int[] array) {
		strategy.sort(array);
	}
}
```

- Classes que implementam a interface do Strategy, neste caso temos o `BubbleSort` e o `QuickSort`:

```java
package StrategyExample;

public class BubbleSort implements SortStrategy {
	@Override
	public void sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	System.out.print("Sorted using BubbleSort: ");
	}
}
```

```java
package StrategyExample;

public class QuickSort implements SortStrategy {
	@Override
	public void sort(int[] array) {
		quickSort(array, 0, array.length - 1);
		System.out.print("Sorted using QuickSort: ");
	}

	private void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);
			quickSort(array, low, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, high);
		}
	}

	private int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return i + 1;
	}
}
```

- Main Class:

```java
package StrategyExample;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] numbers = {5, 2, 9, 1, 5, 6};

		// Usando a estratégia de BubbleSort
		SortContext context = new SortContext(new BubbleSort());
		int[] numbersCopy = numbers.clone();
		context.executeSort(numbersCopy);
		System.out.println(Arrays.toString(numbersCopy));

		// Usando a estratégia de QuickSort
		context.setStrategy(new QuickSort());
		numbersCopy = numbers.clone();
		context.executeSort(numbersCopy);
		System.out.println(Arrays.toString(numbersCopy));
	}
}
```