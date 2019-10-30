package k1oud.career.wholecareer.singletons;

/**
 * 第七种单例：枚举类型单例，effective java作者推荐
 * 与holder模式区别在于，不能懒加载，不过针对这点同样可以优化。
 */

public enum SeventhSingleton {

    INSTANCE;

    SeventhSingleton(){

    }

    public static void anyMethod(){
        //只要调用这个方法，即使不需要单例也会产生instance实例，不是懒加载。
    }

    public static SeventhSingleton getInstance(){
        return INSTANCE;
    }
}
