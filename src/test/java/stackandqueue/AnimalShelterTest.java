package stackandqueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stackandqueue.model.Cat;
import stackandqueue.model.Dog;

class AnimalShelterTest {

    @Test
    public void enqueueOneItemEachAnimal() {
        AnimalShelter animalShelter = new AnimalShelter();
        Cat cat = new Cat("Jessyz");
        Dog dog = new Dog("ahmad");
        animalShelter.enqueue(cat);
        animalShelter.enqueue(dog);
    }

    @Test
    public void dequeueOneAnimalFirstAnimalIsCat() {
        AnimalShelter animalShelter = new AnimalShelter();
        Cat cat = new Cat("Jessyz");
        Dog dog = new Dog("ahmad");
        animalShelter.enqueue(cat);
        animalShelter.enqueue(dog);
        Assertions.assertEquals(cat, animalShelter.dequeueAny());
    }

    @Test
    public void dequeueOneAnimalFirstAnimalIsDog() {
        AnimalShelter animalShelter = new AnimalShelter();
        Cat cat = new Cat("Jessyz");
        Dog dog = new Dog("ahmad");
        animalShelter.enqueue(dog);
        animalShelter.enqueue(cat);
        Assertions.assertEquals(dog, animalShelter.dequeueAny());
    }

    @Test
    public void dequeueDog() {
        AnimalShelter animalShelter = new AnimalShelter();
        Dog dog1 = new Dog("Jessyz");
        Dog dog2 = new Dog("ahmad");
        animalShelter.enqueue(dog1);
        animalShelter.enqueue(dog2);
        Assertions.assertEquals(dog1, animalShelter.dequeueDog());
    }

    @Test
    public void dequeueCat() {
        AnimalShelter animalShelter = new AnimalShelter();
        Cat cat1 = new Cat("Jessyz");
        Cat cat2 = new Cat("ahmad");
        animalShelter.enqueue(cat1);
        animalShelter.enqueue(cat2);
        Assertions.assertEquals(cat1, animalShelter.dequeueCat());
    }
}