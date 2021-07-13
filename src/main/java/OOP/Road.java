package OOP;

public class Road {


    private final String name;
    private final int length = (int) (Math.random()*10+5);


    public Road(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }


    protected boolean moving(Actions actions) {
        System.out.println("The " + this.name + " length: " + this.length);

        actions.run();

        if (getLength() <= actions.getRunDistance()) {
            System.out.println("Run !SUCCESS!");

            return true;
        } else {
            System.out.println("Run !unsuccessfully!");

            return false;
        }
    }
}
