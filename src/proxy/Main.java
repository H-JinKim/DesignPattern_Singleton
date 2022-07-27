package proxy;

import aop.AopBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args){
        Browser browser = new Browser( "www.naver.com");
        browser.show(); //no cache -> bcreate everytime
        browser.show();
        browser.show();

        IBrowser browser1 = new BrowserProxy("www.google.com"); //cache
        browser1.show();
        browser1.show();
        browser1.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AopBrowser("www.yahoo.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());

                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now-start.get());
                }
                );

        aopBrowser.show();
        System.out.println("loading time: "+end.get());

        aopBrowser.show();                              //loading time = 0 as using cache
        System.out.println("loading time: "+end.get());



    }
}
