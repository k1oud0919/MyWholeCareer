package k1oud.career.wholecareer.concurrency.hashMap;

/**
 * 测试重写子类方法权限问题
 *
 * ========>子类方法权限要比父类大
 */

public class LittleDemo {

    protected void hello(){

    }
}

class Sub extends LittleDemo{

    public void hello(){

    }

   /* private void hello(){

    }*/

}
