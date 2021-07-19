/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.t;
import java.lang.reflect.Method;

public class s {
    public static String a(String object, String string2) {
        int n10;
        String string3;
        Object object2 = String.class;
        Object[] objectArray = "android.os.SystemProperties";
        try {
            objectArray = t.a(null, (String)objectArray);
            string3 = "get";
            n10 = 2;
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("SystemProperties.get: ");
            ((StringBuilder)object2).append(exception);
            b.a(((StringBuilder)object2).toString());
            return string2;
        }
        Class[] classArray = new Class[n10];
        classArray[0] = object2;
        int n11 = 1;
        classArray[n11] = object2;
        object2 = objectArray.getMethod(string3, classArray);
        objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[n11] = string2;
        object = ((Method)object2).invoke(null, objectArray);
        return (String)object;
    }
}

