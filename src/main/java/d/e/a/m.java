/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.e.a;

import android.text.TextUtils;
import d.e.a.j;
import d.e.a.m$a;
import java.io.File;

public abstract class m
implements Runnable {
    public static final int c = 10001;
    public static final int d = 10002;
    private j a;
    private m$a b;

    public void a() {
        m$a m$a = this.b;
        if (m$a != null) {
            int n10 = 10002;
            m$a.a(n10);
        }
    }

    public abstract void b(File var1);

    public void c(m$a m$a) {
        this.b = m$a;
    }

    public void d(j j10) {
        this.a = j10;
    }

    public void run() {
        boolean bl2;
        Object object = this.a;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((j)object).b)))) {
            object = this.a.c;
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                this.a();
                return;
            }
            String string2 = this.a.c;
            object = new File(string2);
            this.b((File)object);
            return;
        }
        this.a();
    }
}

