public class gameObject
{
    protected int x, y;
    protected int width, height;

    // default constructor, sets all to zero

    public gameObject()
    {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
    }

    // four parameter constructor - call with super for each
    // new character


    public gameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void plusY(int t) {
        this.y += t;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean inScene()
    {
        return true;
    }

    // used to determine if two characters are in the same place
    public boolean areColliding(gameObject obj)
    {
        gameObject other = obj;
        if(getX()+getWidth()>=other.getX()&&
                getX()<=other.getX()+other.getWidth() &&
                getY()+getHeight() >=other.getY() &&
                getY() <= other.getY()+other.getHeight())
            return true;
        return false;
    }
}