package OOP;

public class Wall  {

    private final String name;
    private final int height = (int) (Math.random()*10+10);

    public Wall(String name) {
        this.name = name;
    }

    public int getHeight(){
        return height;
    }



    protected boolean moving(Actions actions) {
        System.out.println("The  " + this.name + " height: " + this.height);

        actions.jump();

        if (getHeight() <= actions.getJumpHeight()) {
            System.out.println("jump !SUCCESS!");
            return true;

        } else {

            System.out.println("jump !unsuccessfully!");

            return false;
        }
    }
}
