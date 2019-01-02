package practice.tutorials.daysofcode;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Day4ClassVsInstance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int age = sc.nextInt();
            Person p = new Person(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
            System.out.println();
        }
        sc.close();
    }

    @Test
    public void whenInstanceCreateWithNegativeAge_thenInstanceSetAgeToZero() {
        int initialAge = -1;
        Person p = new Person(initialAge);

        assertEquals(0, p.getAge());
    }

    @Test
    public void whenInstanceCreatedWithPositiveAge_thenInstanceSetAgeToInitialAge() {
        int initialAge = 15;
        Person p = new Person(initialAge);

        assertEquals(initialAge, p.getAge());
    }

    @Test
    public void whenPersonUnder13AsksOld_thenReturnYoung() {
        int youngAge = 10;
        Person p = new Person(youngAge);

        assertEquals(Person.YOU_ARE_YOUNG, p.amIOldInner());
    }

    @Test
    public void whenPersonBetween13And18AsksOld_thenReturnTeenager() {
        int youngAge = 15;
        Person p = new Person(youngAge);

        assertEquals("You are a teenager...", p.amIOldInner());
    }

    @Test
    public void whenPersonGreaterThan18AsksOld_thenReturnOld() {
        int youngAge = 20;
        Person p = new Person(youngAge);

        assertEquals("You are old...", p.amIOldInner());
    }

    @Test
    public void yearPassTest() {
        int youngAge = 20;
        Person p = new Person(youngAge);

        p.yearPasses();

        assertEquals(++youngAge, p.getAge());
    }
}

class Person {
    public static final String YOU_ARE_YOUNG = "You are young.";
    public static final String YOU_ARE_A_TEENAGER = "You are a teenager.";
    public static final String YOU_ARE_OLD = "You are old.";
    private int age;

    public Person(int initialAge) {
        // Add some more code to run some checks on initialAge
        if(initialAge < 0) {
            System.out.println("Age is not valid, setting age to 0.");
            this.age = 0;
        } else {
            this.age = initialAge;
        }
    }

    public String amIOldInner() {
        if(this.age < 13) {
            return YOU_ARE_YOUNG;
        } else if (this.age >= 18) {
            return YOU_ARE_OLD;
        }
        return YOU_ARE_A_TEENAGER;
    }

    public void amIOld() {
        System.out.println(this.amIOldInner());
    }

    public void yearPasses() {
        // Increment this person's age.
        this.age++;
    }

    public int getAge() {
        return this.age;
    }
}