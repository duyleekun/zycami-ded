/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.util.Log
 */
package d.c.a.q;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import d.c.a.q.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public final class e {
    private static final String b = "ManifestParser";
    private static final String c = "GlideModule";
    private final Context a;

    public e(Context context) {
        this.a = context;
    }

    private static c b(String object) {
        Object[] objectArray;
        String string2;
        try {
            object = Class.forName((String)object);
            string2 = null;
            objectArray = null;
        }
        catch (ClassNotFoundException classNotFoundException) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to find GlideModule implementation", classNotFoundException);
            throw illegalArgumentException;
        }
        Object object2 = new Class[]{};
        object2 = ((Class)object).getDeclaredConstructor((Class<?>)object2);
        objectArray = new Object[]{};
        try {
            string2 = (String)((Constructor)object2).newInstance(objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            e.c((Class)object, invocationTargetException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            e.c((Class)object, noSuchMethodException);
        }
        catch (IllegalAccessException illegalAccessException) {
            e.c((Class)object, illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            e.c((Class)object, instantiationException);
        }
        boolean bl2 = string2 instanceof c;
        if (bl2) {
            return (c)((Object)string2);
        }
        objectArray = new StringBuilder();
        objectArray.append("Expected instanceof GlideModule, but found: ");
        objectArray.append((Object)string2);
        string2 = objectArray.toString();
        object = new RuntimeException(string2);
        throw object;
    }

    private static void c(Class object, Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to instantiate GlideModule implementation for ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        RuntimeException runtimeException = new RuntimeException((String)object, exception);
        throw runtimeException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List a() {
        ArrayList<Object> arrayList;
        String string2 = b;
        int n10 = 3;
        boolean bl2 = Log.isLoggable((String)string2, (int)n10);
        if (bl2) {
            arrayList = "Loading Glide modules";
            Log.d((String)string2, arrayList);
        }
        arrayList = new ArrayList<Object>();
        try {
            Context context = this.a;
            context = context.getPackageManager();
            Object object = this.a;
            object = object.getPackageName();
            int n11 = 128;
            context = context.getApplicationInfo((String)object, n11);
            object = context.metaData;
            if (object == null) {
                if ((n10 = (int)(Log.isLoggable((String)string2, (int)n10) ? 1 : 0)) != 0) {
                    String string3 = "Got null app info metadata";
                    Log.d((String)string2, (String)string3);
                }
                return arrayList;
            }
            int n12 = 2;
            if ((n12 = (int)(Log.isLoggable((String)string2, (int)n12) ? 1 : 0)) != 0) {
                object = new StringBuilder();
                String string4 = "Got app info metadata: ";
                ((StringBuilder)object).append(string4);
                Bundle bundle = context.metaData;
                ((StringBuilder)object).append(bundle);
                object = ((StringBuilder)object).toString();
                Log.v((String)string2, (String)object);
            }
            object = context.metaData;
            object = object.keySet();
            object = object.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Object object2 = c;
                Bundle bundle = context.metaData;
                Object e10 = object.next();
                String string5 = (String)e10;
                Object object3 = bundle.get(string5);
                boolean bl3 = ((String)object2).equals(object3);
                if (!bl3) continue;
                object2 = e.b(string5);
                arrayList.add(object2);
                bl3 = Log.isLoggable((String)string2, (int)n10);
                if (!bl3) continue;
                object2 = new StringBuilder();
                String string6 = "Loaded Glide module: ";
                ((StringBuilder)object2).append(string6);
                ((StringBuilder)object2).append(string5);
                String string7 = ((StringBuilder)object2).toString();
                Log.d((String)string2, (String)string7);
            }
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            RuntimeException runtimeException = new RuntimeException("Unable to find metadata to parse GlideModules", nameNotFoundException);
            throw runtimeException;
        }
        if ((n10 = (int)(Log.isLoggable((String)string2, (int)n10) ? 1 : 0)) != 0) {
            String string8 = "Finished loading Glide modules";
            Log.d((String)string2, (String)string8);
        }
        return arrayList;
    }
}

