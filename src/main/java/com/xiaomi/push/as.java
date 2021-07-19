/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ar;
import com.xiaomi.push.t;
import java.lang.reflect.Method;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class as
implements ar {
    private Context a;
    private Class a;
    private Object a;
    private Method a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    public as(Context context) {
        this.a = context;
        this.a(context);
    }

    private String a(Context object, Method object2) {
        block6: {
            Object object3 = this.a;
            if (object3 != null && object2 != null) {
                int n10 = 1;
                Object[] objectArray = new Object[n10];
                objectArray[0] = object;
                object = ((Method)object2).invoke(object3, objectArray);
                if (object == null) break block6;
                try {
                    return (String)object;
                }
                catch (Exception exception) {
                    object2 = "miui invoke error";
                    com.xiaomi.channel.commonutils.logger.b.a((String)object2, (Throwable)exception);
                }
            }
        }
        return null;
    }

    private void a(Context object) {
        String string2 = "com.android.id.impl.IdProviderImpl";
        object = t.a((Context)object, string2);
        this.a = object;
        object = ((Class)object).newInstance();
        object = this.a = object;
        string2 = "getUDID";
        int n10 = 1;
        Object object2 = new Class[n10];
        Class<Context> clazz = Context.class;
        object2[0] = clazz;
        object = ((Class)object).getMethod(string2, (Class<?>)object2);
        object = this.a = object;
        string2 = "getOAID";
        object2 = new Class[n10];
        clazz = Context.class;
        object2[0] = clazz;
        object = ((Class)object).getMethod(string2, (Class<?>)object2);
        this.b = object;
        object = this.a;
        string2 = "getVAID";
        object2 = new Class[n10];
        clazz = Context.class;
        object2[0] = clazz;
        object = ((Class)object).getMethod(string2, (Class<?>)object2);
        this.c = object;
        object = this.a;
        string2 = "getAAID";
        Class[] classArray = new Class[n10];
        object2 = Context.class;
        classArray[0] = object2;
        object = ((Class)object).getMethod(string2, classArray);
        try {
            this.d = object;
        }
        catch (Exception exception) {
            string2 = "miui load class error";
            com.xiaomi.channel.commonutils.logger.b.a(string2, (Throwable)exception);
        }
    }

    public static boolean a(Context object) {
        object = object.getPackageName();
        return "com.xiaomi.xmsf".equals(object);
    }

    public String a() {
        Context context = this.a;
        Method method = this.a;
        return this.a(context, method);
    }

    public boolean a() {
        boolean bl2;
        Object object = this.a;
        if (object != null && (object = this.a) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public String b() {
        Context context = this.a;
        Method method = this.b;
        return this.a(context, method);
    }

    public String c() {
        Context context = this.a;
        Method method = this.c;
        return this.a(context, method);
    }

    public String d() {
        Context context = this.a;
        Method method = this.d;
        return this.a(context, method);
    }
}

