/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.os.Looper
 */
package d.m.a.g;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.meishe.cafconvertor.webpcoder.WebpImageView$b;
import d.m.a.g.b;
import d.m.a.g.c;
import d.m.a.g.e$a;
import d.m.a.g.e$b;
import java.io.InputStream;

public class e
implements WebpImageView$b {
    private static final String d = "e";
    private static e e;
    private Context a;
    public int b = -1;
    private e$b c;

    private e(Context context) {
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static e e(Context context) {
        Object object = e;
        if (object != null) return e;
        object = e.class;
        synchronized (object) {
            e e10 = e;
            if (e10 != null) return e;
            e = e10 = new e(context);
            return e;
        }
    }

    public void a(int n10, Bitmap bitmap, long l10) {
        e$b e$b = this.c;
        if (e$b != null) {
            e$b.a(n10, bitmap, l10);
        }
    }

    public void b(InputStream inputStream) {
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = new e$a(this, inputStream);
        handler.postDelayed((Runnable)object, 1000L);
    }

    public void c(InputStream object) {
        c c10 = d.m.a.g.b.a;
        if (c10 != null) {
            int n10;
            c10.c((InputStream)object);
            object = d.m.a.g.b.a;
            this.b = n10 = ((c)((Object)object)).d();
        }
    }

    public void d() {
        c c10 = d.m.a.g.b.a;
        if (c10 != null) {
            c10.finish();
        }
    }

    public void f(e$b e$b) {
        this.c = e$b;
    }

    public void g(InputStream inputStream) {
        Context context = this.a;
        Intent intent = new Intent(context, c.class);
        this.a.startActivity(intent);
        this.b(inputStream);
    }
}

