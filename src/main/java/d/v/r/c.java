/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.util.Log
 */
package d.v.r;

import android.graphics.Bitmap;
import android.util.Log;
import d.v.r.d;
import java.util.LinkedList;
import java.util.List;

public class c
extends Thread {
    public static final String c = "BmpProducer";
    public d a;
    public List b;

    public c() {
        LinkedList linkedList;
        this.b = linkedList = new LinkedList();
        this.start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(Bitmap bitmap) {
        List list = this.b;
        synchronized (list) {
            List list2 = this.b;
            int n10 = list2.size();
            int n11 = 2;
            if (n10 >= n11) {
                list2 = this.b;
                n11 = 0;
                list2.remove(0);
                list2 = this.b;
                list2.add(bitmap);
                return false;
            }
            list2 = this.b;
            list2.add(bitmap);
            return true;
        }
    }

    public void b(d d10) {
        this.a = d10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        super.run();
        while (true) {
            Object object;
            Object object2;
            if ((object2 = this.b) == null || (object = this.a) == null) {
                continue;
            }
            synchronized (object2) {
                object = this.b;
            }
            int n10 = object.size();
            if (n10 == 0) continue;
            Object object3 = "Writing frame";
            Log.d((String)c, (String)object3);
            n10 = 0;
            object2 = (Bitmap)object.get(0);
            this.a.a((Bitmap)object2);
            object = this.b;
            synchronized (object) {
                object3 = this.b;
                object3.remove(object2);
            }
            long l10 = 10;
            try {
                Thread.sleep(l10);
                continue;
            }
            catch (Exception exception) {
                object = c;
                object2 = exception.toString();
                Log.d((String)object, (String)object2);
                continue;
            }
            break;
        }
    }
}

