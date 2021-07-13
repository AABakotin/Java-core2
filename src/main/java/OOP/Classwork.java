package OOP;

public class Classwork {
    public static void main(String[] args) {

        //Создаем подопытных
        Actions[] actions = new Actions[3];
        actions[0] = new Human("Rambo");
        actions[1] = new Robot("Bender");
        actions[2] = new Cat("Garfield");

        //Стены
        Wall [] walls = {
                new Wall("Wall first"),
                new Wall("Wall second"),
                new Wall("Wall finally"),
        };
        //Дороги
        Road [] roads = {
                new Road("Road first"),
                new Road("Road second"),
                new Road("Road finally"),
        };

        //Полоса припятсвий
        for (Actions action : actions) {
            boolean result = true;
            for (Wall wall : walls) {
                result = wall.moving(action);
                if (!result)
                    break;
            }
            for (Road road : roads) {
                result = road.moving(action);
                if (!result)
                    break;
            }
            if (result) {
                System.out.println("***** Congratulation!!! *****");
            } else {
                System.out.println("---> GameOver <---");

            }
        }
    }
}




