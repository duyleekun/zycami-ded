/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.v.b0.c.c;

import android.util.Log;
import d.v.b0.c.c.d$a;
import d.v.b0.c.c.d$b;
import d.v.b0.c.c.d$c;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class d
extends Thread {
    private final String a;
    private ExecutorService b;
    private LinkedBlockingQueue c;
    private boolean d;
    private String e;
    private d$c f;

    public d() {
        this.a = "TempDataFactory";
        LinkedBlockingQueue linkedBlockingQueue = Executors.newFixedThreadPool(2);
        this.b = linkedBlockingQueue;
        this.c = linkedBlockingQueue = new LinkedBlockingQueue();
        this.d = true;
        this.e = "";
        this.f = null;
    }

    public static /* synthetic */ String a(d d10) {
        return d10.e;
    }

    public static /* synthetic */ d$c b(d d10) {
        return d10.f;
    }

    private void c(File fileArray) {
        int n10;
        if (fileArray != null && (n10 = fileArray.exists()) != 0) {
            n10 = fileArray.isFile();
            if (n10 != 0) {
                fileArray.delete();
                return;
            }
            n10 = fileArray.isDirectory();
            if (n10 != 0) {
                for (File file : fileArray.listFiles()) {
                    this.c(file);
                }
            }
        }
    }

    private void d() {
        String string2 = this.e;
        File file = new File(string2);
        this.c(file);
    }

    public void e(String string2) {
        this.e = string2;
    }

    public void f(d$c d$c) {
        this.f = d$c;
    }

    public void g() {
        this.d = false;
    }

    public void h(String string2, byte[] byArray) {
        d$b d$b = new d$b(this);
        d$b.a = byArray;
        d$b.b = string2;
        this.c.put(d$b);
    }

    public void run() {
        boolean bl2;
        super.run();
        while (bl2 = this.d) {
            d$a d$a;
            Object object;
            Object object2 = this.c;
            object2 = ((LinkedBlockingQueue)object2).take();
            try {
                object2 = (d$b)object2;
                object = this.b;
                d$a = new d$a(this, (d$b)object2);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
                object2 = "TempDataFactory";
                object = "";
                Log.e((String)object2, (String)object);
                break;
            }
            object.execute(d$a);
        }
        this.d();
        this.c.clear();
        this.b.shutdown();
    }
}

