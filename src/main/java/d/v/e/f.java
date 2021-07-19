/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package d.v.e;

import android.app.Application;
import android.content.Context;
import com.zhiyun.common.AppContextProvider;

public class f {
    private static volatile f b;
    private Context a;

    private f(Context context) {
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static f a() {
        Object object = b;
        if (object != null) return b;
        object = f.class;
        synchronized (object) {
            Object object2 = b;
            if (object2 != null) return b;
            object2 = AppContextProvider.a;
            if (object2 != null) {
                f f10;
                b = f10 = new f((Context)object2);
                return b;
            }
            String string2 = "context == null";
            object2 = new IllegalStateException(string2);
            throw object2;
        }
    }

    public static void d(Context context) {
        f.a().a = context;
    }

    public Application b() {
        return (Application)this.a.getApplicationContext();
    }

    public Context c() {
        return this.a;
    }
}

