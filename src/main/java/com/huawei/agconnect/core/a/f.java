/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ServiceInfo
 *  android.os.Bundle
 *  android.util.Log
 */
package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.a.f$a;
import d.j.a.g.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class f {
    private Context a;

    public f(Context context) {
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private c a(String object) {
        String string2;
        String string3;
        block5: {
            StringBuilder stringBuilder;
            CharSequence charSequence = "instantiate service class exception ";
            string3 = "ServiceRegistrarParser";
            try {
                Object object2 = Class.forName((String)object);
                Class<c> clazz = c.class;
                boolean bl2 = clazz.isAssignableFrom((Class<?>)object2);
                if (!bl2) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(object2);
                    object2 = " must extends from ServiceRegistrar.";
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                    Log.e((String)string3, (String)object);
                    return null;
                }
                object = Class.forName((String)object);
                object = ((Class)object).newInstance();
                return (c)object;
            }
            catch (IllegalAccessException illegalAccessException) {
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence);
                string2 = illegalAccessException.getLocalizedMessage();
            }
            catch (InstantiationException instantiationException) {
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence);
                string2 = instantiationException.getLocalizedMessage();
            }
            catch (ClassNotFoundException classNotFoundException) {
                charSequence = new StringBuilder();
                String string4 = "Can not found service class, ";
                ((StringBuilder)charSequence).append(string4);
                string2 = classNotFoundException.getMessage();
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                break block5;
            }
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        Log.e((String)string3, (String)string2);
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Bundle c() {
        String string2 = "ServiceRegistrarParser";
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        Context context = this.a;
        Class<ServiceDiscovery> clazz = ServiceDiscovery.class;
        Object object = new ComponentName(context, clazz);
        int n10 = 128;
        ServiceInfo serviceInfo = packageManager.getServiceInfo((ComponentName)object, n10);
        if (serviceInfo != null) return serviceInfo.metaData;
        String string3 = "Can not found ServiceDiscovery service.";
        try {
            Log.e((String)string2, (String)string3);
            return null;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = new StringBuilder();
            String string4 = "get ServiceDiscovery exception.";
            ((StringBuilder)object).append(string4);
            String string5 = nameNotFoundException.getLocalizedMessage();
            ((StringBuilder)object).append(string5);
            String string6 = ((StringBuilder)object).toString();
            Log.e((String)string2, (String)string6);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private List d() {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = this.c();
        if (object == null) {
            return arrayList;
        }
        int n10 = 10;
        Object object2 = new HashMap(n10);
        Iterator iterator2 = object.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = "com.huawei.agconnect.core.ServiceRegistrar";
            String string3 = (String)iterator2.next();
            Object object3 = object.getString(string3);
            int n11 = string2.equals(object3);
            if (n11 == 0) continue;
            object3 = string3.split(":");
            int n12 = ((String[])object3).length;
            int n13 = 2;
            String string4 = "ServiceRegistrarParser";
            int n14 = 1;
            if (n12 == n13) {
                try {
                    string3 = object3[0];
                    object3 = object3[n14];
                    object3 = Integer.valueOf((String)object3);
                    object2.put(string3, object3);
                    continue;
                }
                catch (NumberFormatException numberFormatException) {
                    object3 = new StringBuilder();
                    string2 = "registrar configuration format error:";
                    ((StringBuilder)object3).append(string2);
                    string3 = numberFormatException.getMessage();
                }
            } else {
                n12 = ((String[])object3).length;
                if (n12 == n14) {
                    string3 = object3[0];
                    n11 = 1000;
                    object3 = n11;
                    object2.put(string3, object3);
                    continue;
                }
                object3 = new StringBuilder();
                string2 = "registrar configuration error, ";
                ((StringBuilder)object3).append(string2);
            }
            ((StringBuilder)object3).append(string3);
            string3 = ((StringBuilder)object3).toString();
            Log.e((String)string4, (String)string3);
        }
        object2 = object2.entrySet();
        object = new ArrayList(object2);
        n10 = 0;
        iterator2 = null;
        object2 = new f$a(null);
        Collections.sort(object, object2);
        object = object.iterator();
        boolean bl3;
        while (bl3 = object.hasNext()) {
            object2 = ((Map.Entry)object.next()).getKey();
            arrayList.add(object2);
        }
        return arrayList;
    }

    public List b() {
        Object object;
        boolean bl2;
        String string2 = "ServiceRegistrarParser";
        Log.i((String)string2, (String)"getServices");
        Object object2 = this.d();
        ArrayList arrayList = new ArrayList();
        object2 = object2.iterator();
        while (bl2 = object2.hasNext()) {
            object = (String)object2.next();
            if ((object = this.a((String)object)) == null) continue;
            Context context = this.a;
            object.b(context);
            context = this.a;
            if ((object = object.a(context)) == null) continue;
            arrayList.addAll(object);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("services:");
        object = arrayList.size();
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        Log.i((String)string2, (String)object2);
        return arrayList;
    }
}

