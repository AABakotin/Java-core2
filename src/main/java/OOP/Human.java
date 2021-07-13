package OOP;


public class Human implements Actions {
    private final String name;
    private final int runDistance;
    private final int jumpHeight;

    public Human(String name) {

        this.name = name;
        this.runDistance = (int) (Math.random()*30+5);
        this.jumpHeight = (int) (Math.random()*30+5);
    }

    @Override
    public void run() {
        System.out.println("Human " + this.name + " is running " + this.getRunDistance());
    }

    @Override
    public void jump() {
        System.out.println("Human " + this.name + " is jumping " + this.getJumpHeight());
    }

    @Override
    public int getRunDistance() {
        return this.runDistance;
    }

    @Override
    public int getJumpHeight() {
        return this.jumpHeight;
    }

}