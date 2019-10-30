package k1oud.career.wholecareer.singletons;

/**
 * //第二种：懒汉式单例
 * //final 不允许继承
 *
 * 这种方法不能保证真的是单例，假设两个线程同时读取到instance为null，都会创建instance
 */


public final class SecondSingleton {

    private static SecondSingleton instance = null;

    private SecondSingleton(){

    }

    public static SecondSingleton getInstance(){
        if(instance == null){
            return new SecondSingleton();
        }
        return instance;
    }
}
