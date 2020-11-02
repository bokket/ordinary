import java.util.HashMap;
class Pet {}
class Dog extends Pet {}
class Pug extends Dog {}
class Cat extends Pet {}
class Rodent extends Pet {}
class Gerbil extends Rodent {}
class Hamster extends Rodent {}

class Main {
    static HashMap<Integer, Class<? extends Pet>> map = new HashMap<Integer, Class<? extends Pet>>();
    static {
        map.put(Pet.class.getName().length(), Pet.class);
        map.put(Dog.class.getName().length(), Dog.class);
        map.put(Pug.class.getName().length(), Pug.class);
        map.put(Cat.class.getName().length(), Cat.class);
        map.put(Rodent.class.getName().length(), Rodent.class);
        map.put(Gerbil.class.getName().length(), Gerbil.class);
        map.put(Hamster.class.getName().length(), Hamster.class);
    }
    public static void main(String[] args) {
        for ( Integer i : map.keySet() )
            System.out.println(map.get(i).getName());
    }
}