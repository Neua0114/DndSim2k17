
public class Roll {
    public static int Roller (int size) {
        double random= (int) (Math.random()*50);
        random=random +1;
        int i= (int) random;
        i = i % size;
        return i+1;
    }
}
