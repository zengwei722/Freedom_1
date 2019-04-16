public class singletone {
    private singletone(){}
    private static singletone single = new singletone();
    public static singletone getSingle(){
        return single;
    }
}
