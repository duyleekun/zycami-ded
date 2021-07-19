/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssNavigationMessage
 */
package com.baidu.location.b;

import android.location.GnssNavigationMessage;
import com.baidu.location.b.r$a;
import com.baidu.location.b.r$c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class r {
    private static final double[] a;
    private HashMap b;
    private HashMap c;

    static {
        double[] dArray;
        double[] dArray2 = dArray = new double[6];
        double[] dArray3 = dArray;
        dArray2[0] = 1999.0;
        dArray3[1] = 8.0;
        dArray2[2] = 22.0;
        dArray3[3] = 0.0;
        dArray2[4] = 0.0;
        dArray3[5] = 0.0;
        a = dArray;
    }

    public r() {
        HashMap hashMap;
        this.b = hashMap = new HashMap();
        this.c = hashMap = new HashMap();
    }

    public static r a() {
        return r$a.a();
    }

    public static /* synthetic */ double[] c() {
        return a;
    }

    public void a(GnssNavigationMessage gnssNavigationMessage, long l10) {
        int n10 = gnssNavigationMessage.getSvid();
        int n11 = gnssNavigationMessage.getType();
        int n12 = 257;
        Object object = "none";
        Object object2 = n11 != n12 ? (n11 != (n12 = 769) ? (n11 != (n12 = 1537) ? (n11 != (n12 = 1281) ? (n11 != (n12 = 1282) ? object : "CT") : "CO") : "E") : "R") : "G";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object2);
        stringBuilder.append(n10);
        object2 = stringBuilder.toString();
        boolean bl2 = ((String)object2).contains((CharSequence)object);
        if (bl2) {
            return;
        }
        object = this.b;
        if (object == null) {
            return;
        }
        bl2 = ((HashMap)object).containsKey(object2);
        if (!bl2) {
            object = new r$c(this, n10, n11);
            HashMap hashMap = this.b;
            hashMap.put(object2, object);
        }
        r$c.a((r$c)this.b.get(object2), gnssNavigationMessage, l10);
    }

    public ArrayList b() {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator2 = this.b.entrySet().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            int n11;
            int n12;
            Object object = iterator2.next();
            String string2 = (String)object.getKey();
            String string3 = r$c.a((r$c)(object = (r$c)object.getValue()));
            if (string3 == null || (n12 = string3.length()) == 0 || (n12 = r$c.b((r$c)object)) == (n11 = 257) || (n10 = r$c.b((r$c)object)) == (n12 = 769)) continue;
            object = this.c;
            n10 = (int)(((HashMap)object).containsKey(string2) ? 1 : 0);
            if (n10 == 0) {
                object = this.c;
                ((HashMap)object).put(string2, string3);
            } else {
                object = (String)this.c.get(string2);
                n10 = (int)(string3.equals(object) ? 1 : 0);
                if (n10 != 0) continue;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            char c10 = '|';
            ((StringBuilder)object).append(c10);
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            arrayList.add(object);
        }
        return arrayList;
    }
}

