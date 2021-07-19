/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.heytap.mcssdk.f;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.d;
import com.heytap.mcssdk.f.c;
import com.heytap.mcssdk.f.g;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class e {
    private static final String a = "type";
    private static final String b = "count";
    private static final String c = "list";
    private static final int d = 1017;

    public static void a(Context context, d.i.a.a.c.d d10) {
        LinkedList<d.i.a.a.c.d> linkedList = new LinkedList<d.i.a.a.c.d>();
        linkedList.add(d10);
        e.a(context, linkedList);
    }

    public static void a(Context context, List object) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(object);
        object = new StringBuilder();
        ((StringBuilder)object).append("isSupportStatisticByMcs:");
        int n10 = e.a(context);
        ((StringBuilder)object).append(n10 != 0);
        String string2 = ",list size:";
        ((StringBuilder)object).append(string2);
        n10 = linkedList.size();
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        com.heytap.mcssdk.f.c.b((String)object);
        int n11 = linkedList.size();
        if (n11 > 0 && (n11 = (int)(e.a(context) ? 1 : 0)) != 0) {
            e.b(context, linkedList);
        }
    }

    private static boolean a(Context context) {
        int n10;
        int n11;
        String string2 = com.heytap.mcssdk.d.k().l();
        boolean bl2 = g.a(context, string2);
        if (bl2 && (n11 = g.b(context, string2)) >= (n10 = 1017)) {
            n11 = 1;
        } else {
            n11 = 0;
            context = null;
        }
        return n11 != 0;
    }

    private static void b(Context context, List object) {
        Object object2 = new Intent();
        ArrayList<Object> arrayList = com.heytap.mcssdk.d.k();
        arrayList = ((d)((Object)arrayList)).m();
        object2.setAction((String)((Object)arrayList));
        arrayList = com.heytap.mcssdk.d.k();
        arrayList = ((d)((Object)arrayList)).l();
        object2.setPackage((String)((Object)arrayList));
        arrayList = "appPackage";
        Object object3 = context.getPackageName();
        object2.putExtra((String)((Object)arrayList), (String)object3);
        arrayList = a;
        int n10 = 12291;
        object2.putExtra((String)((Object)arrayList), n10);
        arrayList = b;
        n10 = object.size();
        object2.putExtra((String)((Object)arrayList), n10);
        arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (true) {
            n10 = (int)(object.hasNext() ? 1 : 0);
            if (n10 == 0) break;
            object3 = object.next();
            object3 = (d.i.a.a.c.d)object3;
            object3 = ((d.i.a.a.c.d)object3).q();
            arrayList.add(object3);
            continue;
            break;
        }
        object = c;
        object2.putStringArrayListExtra((String)object, arrayList);
        try {
            context.startService(object2);
        }
        catch (Exception exception) {
            object = new StringBuilder();
            object2 = "statisticMessage--Exception";
            ((StringBuilder)object).append((String)object2);
            String string2 = exception.getMessage();
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            com.heytap.mcssdk.f.c.e(string2);
        }
    }
}

