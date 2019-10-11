package com.learning.understandingjvm.three;

/**
 * java8试验例子不成立,我们无法确定系统何时会执行finalize()命令
 * @author kian
 * @date 2019/7/5
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes,i am still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }


    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK=null;
        Thread.sleep(5000);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,I am dead.");
        }



        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK=null;
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no,I am dead.");
        }
    }


}
