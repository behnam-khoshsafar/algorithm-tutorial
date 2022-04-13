package stackandqueue;

import stackandqueue.model.Animal;
import stackandqueue.model.Cat;
import stackandqueue.model.Dog;

import java.util.LinkedList;

public class AnimalShelter {
    private final LinkedList<Cat> cats;
    private final LinkedList<Dog> dogs;
    private int order;

    public AnimalShelter() {
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        order++;
        animal.setOrder(order);
        if (animal instanceof Cat)
            cats.add((Cat) animal);
        else
            dogs.add((Dog) animal);
    }

    public Animal dequeueAny() {
        if (cats.size() == 0)
            return dequeueDog();
        else if (dogs.size() == 0)
            return dequeueCat();

        Cat cat = cats.peek();
        Dog dog = dogs.peek();
        if (cat.getOrder() < dog.getOrder())
            return dequeueCat();
        else
            return dequeueDog();
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }
}
