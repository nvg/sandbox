package sandbox.stacks;

import java.util.LinkedList;

import lombok.Data;

public class AnimalQueue {

	private LinkedList<Dog> dogs = new LinkedList<>();
	private LinkedList<Cat> cats = new LinkedList<>();
	private int order = 0;

	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;

		if (a instanceof Dog) {
			dogs.add((Dog) a);
		} else {
			cats.add((Cat) a);
		}
	}

	public Animal dequeAny() {
		if (dogs.isEmpty()) {
			return dequeCats();
		} else if (cats.isEmpty()) {
			return dequeDogs();
		}

		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) {
			return dequeDogs();
		} else {
			return dequeCats();
		}
	}

	public Animal dequeDogs() {
		return dogs.poll();
	}

	public Animal dequeCats() {
		return cats.poll();
	}

	@Data
	public static abstract class Animal {
		private int order;
		protected String name;

		public Animal(String name) {
			this.name = name;
		}

		public boolean isOlderThan(Animal a) {
			return this.getOrder() < a.getOrder();
		}
	}

	public static class Dog extends Animal {
		public Dog(String name) {
			super(name);
		}
	}

	public static class Cat extends Animal {
		public Cat(String name) {
			super(name);
		}
	}

}
