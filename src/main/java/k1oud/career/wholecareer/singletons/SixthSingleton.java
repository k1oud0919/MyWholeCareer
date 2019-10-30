package k1oud.career.wholecareer.singletons;

/**
 * 第六种，Holder单例模式
 *
 * 目前最完美的一种单例
 */

public final class SixthSingleton {

    private SixthSingleton(){

    }

    static class Holder{
        private static SixthSingleton instance = new SixthSingleton();
    }

    public static SixthSingleton getInstance(){
        return Holder.instance;
    }
}
