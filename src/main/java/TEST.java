import java.lang.reflect.Method;

public class TEST {

    static {

        int X= 100;
    }
    static int X,Y;

    public static void main(String[] args) {
        X--;
        Method();
        System.out.println(X + Y++ +X);
        System.out.println(TEST.X);
    }
    public static void Method(){
        Y = X++ + ++X;
    }
    ///sdfsdfsdfsdf
}
