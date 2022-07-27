package aop;

import proxy.Html;
import proxy.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;


    public AopBrowser(String url,Runnable before, Runnable after){
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {
        before.run();   //check time

        if (html == null){
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from: "+url);
            try {
                Thread.sleep(1500); //make html to take 1500 millisec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        after.run();
        System.out.println("AopBrowser html cache: "+url);
        return html;

    }
}
