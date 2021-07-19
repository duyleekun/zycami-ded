/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.network.grs.d;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.d.d$a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {
    private static Map a;

    static {
        ConcurrentHashMap concurrentHashMap;
        a = concurrentHashMap = new ConcurrentHashMap(16);
    }

    public static d$a a(String object) {
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("map size of get is before:");
        int n10 = a.size();
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        String string2 = "RequestUtil";
        Logger.v(string2, charSequence);
        object = (d$a)a.get(object);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("map size of get is after:");
        int n11 = a.size();
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        Logger.v(string2, charSequence);
        return object;
    }

    public static void a(String charSequence, d$a d$a) {
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append("map size of put is before:");
        int n10 = a.size();
        charSequence2.append(n10);
        charSequence2 = charSequence2.toString();
        String string2 = "RequestUtil";
        Logger.v(string2, charSequence2);
        a.put(charSequence, d$a);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("map size of put is after:");
        int n11 = a.size();
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        Logger.v(string2, charSequence);
    }
}

