package k1oud.career.wholecareer.singletons;

/**
 * 懒汉式+同步方法
 *
 * 可以保证单例，但是由于synchronized天生的排他性，所以性能不佳
 */

public final class ThirdSingleton {

    private static ThirdSingleton instance = null;

    private ThirdSingleton(){

    }

    public static synchronized ThirdSingleton getInstance(){
        if(null == instance){
            return  new ThirdSingleton();
        }
        return instance;
    }
}
