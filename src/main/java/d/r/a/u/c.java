/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.u;

import android.content.Context;
import d.r.a.u.n;
import d.r.a.u.s;
import java.lang.reflect.Method;

public class c {
    private static final String d = "ContextDelegate";
    private static c e;
    private Method a;
    private Method b;
    private Boolean c = null;

    private c() {
    }

    public static Context c(Context context) {
        c c10 = d.r.a.u.c.d();
        boolean bl2 = c10.e();
        if (!bl2) {
            return context;
        }
        return d.r.a.u.c.d().b(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c d() {
        Object object = e;
        if (object != null) return e;
        object = c.class;
        synchronized (object) {
            c c10 = e;
            if (c10 != null) return e;
            e = c10 = new c();
            return e;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Context a(Context context) {
        try {
            Object object = this.b;
            Object[] objectArray = null;
            if (object == null) {
                object = Context.class;
                String string2 = "createCredentialProtectedStorageContext";
                Class[] classArray = new Class[]{};
                this.b = object = ((Class)object).getMethod(string2, classArray);
            }
            object = this.b;
            objectArray = new Object[]{};
            object = ((Method)object).invoke(context, objectArray);
            return (Context)object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return context;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Context b(Context context) {
        try {
            Object object = this.a;
            Object[] objectArray = null;
            if (object == null) {
                object = Context.class;
                String string2 = "createDeviceProtectedStorageContext";
                Class[] classArray = new Class[]{};
                this.a = object = ((Class)object).getMethod(string2, classArray);
            }
            object = this.a;
            objectArray = new Object[]{};
            object = ((Method)object).invoke(context, objectArray);
            return (Context)object;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return context;
        }
    }

    public boolean e() {
        Object object = this.c;
        if (object == null) {
            object = n.c("ro.crypto.type", "unknow");
            boolean bl2 = "file".equals(object);
            this.c = object = Boolean.valueOf(bl2);
            object = new StringBuilder("mIsFbeProj = ");
            String string2 = this.c.toString();
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            string2 = d;
            s.h(string2, (String)object);
        }
        if ((object = this.c) == null) {
            return false;
        }
        return (Boolean)object;
    }
}

