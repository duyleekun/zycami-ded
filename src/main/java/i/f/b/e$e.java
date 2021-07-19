/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package i.f.b;

import android.util.Log;
import i.f.b.e;
import i.f.b.e$b;
import i.f.b.e$c;
import i.f.b.e$d;
import org.opencv.core.Mat;

public class e$e
implements e$c {
    private int a = 1;
    private e$d b;
    public final /* synthetic */ e c;

    public e$e(e e10, e$d e$d) {
        this.c = e10;
        this.b = e$d;
    }

    public void a() {
        this.b.a();
    }

    public void b(int n10, int n11) {
        this.b.b(n10, n11);
    }

    public Mat c(e$b object) {
        int n10 = this.a;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                String string2 = "Invalid frame format! Only RGBA and Gray Scale are supported!";
                Log.e((String)"CameraBridge", (String)string2);
                object = null;
            } else {
                e$d e$d = this.b;
                object = object.a();
                object = e$d.c((Mat)object);
            }
        } else {
            e$d e$d = this.b;
            object = object.b();
            object = e$d.c((Mat)object);
        }
        return object;
    }

    public void d(int n10) {
        this.a = n10;
    }
}

