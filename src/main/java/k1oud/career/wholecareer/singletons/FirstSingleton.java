package k1oud.career.wholecareer.singletons;

/**
 * 7种单例模式第一：饿汉式
 */

public final class FirstSingleton {

    private static FirstSingleton instance = new FirstSingleton();

    private FirstSingleton(){

    }

    public static FirstSingleton getInstance(){
        return instance;
    }

}
