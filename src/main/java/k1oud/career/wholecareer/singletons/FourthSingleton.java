package k1oud.career.wholecareer.singletons;

import java.net.Socket;
import java.sql.Connection;

/**
 * 第四种单例，double-check
 *
 * 几乎完美，但是有小缺陷，可能会引发空指针异常。
 *
 * connection,socket,instance三者可能会出现指令重排序
 */

public final class FourthSingleton {

    private static FourthSingleton instance = null;

    Connection connection;
    Socket socket;

    private FourthSingleton(Connection connection,Socket socket){
        this.connection = connection;
        this.socket = socket;
    }

    public static FourthSingleton getInstance(){
        if(null == instance){
            synchronized (FourthSingleton.class){
                if(null == instance){
                    return new FourthSingleton(null,null);
                }
            }
        }
        return instance;
    }
}
