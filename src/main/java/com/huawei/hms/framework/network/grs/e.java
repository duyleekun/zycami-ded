/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
    private static Map a;
    private static final Object b;

    static {
        Object object = new ConcurrentHashMap(16);
        a = object;
        b = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d a(GrsBaseInfo object, Context object2) {
        Object object3 = b;
        synchronized (object3) {
            int n10 = ((GrsBaseInfo)object).uniqueCode();
            Object object4 = a;
            Object object5 = new StringBuilder();
            String string2 = object2.getPackageName();
            ((StringBuilder)object5).append(string2);
            ((StringBuilder)object5).append(n10);
            object5 = ((StringBuilder)object5).toString();
            object4 = object4.get(object5);
            object4 = (d)object4;
            if (object4 == null) {
                object4 = new d((Context)object2, (GrsBaseInfo)object);
                object = a;
                object5 = new StringBuilder();
                object2 = object2.getPackageName();
                ((StringBuilder)object5).append((String)object2);
                ((StringBuilder)object5).append(n10);
                object2 = ((StringBuilder)object5).toString();
                object.put(object2, object4);
                return object4;
            }
            object5 = new d((GrsBaseInfo)object);
            boolean bl2 = ((d)object4).a(object5);
            if (bl2) {
                return object4;
            }
            object4 = new d((Context)object2, (GrsBaseInfo)object);
            object = a;
            object5 = new StringBuilder();
            object2 = object2.getPackageName();
            ((StringBuilder)object5).append((String)object2);
            ((StringBuilder)object5).append(n10);
            object2 = ((StringBuilder)object5).toString();
            object.put(object2, object4);
            return object4;
        }
    }
}

