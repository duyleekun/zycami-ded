/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.hms.hatool.c;
import com.huawei.hms.hatool.p0;
import com.huawei.hms.hatool.q;
import com.huawei.hms.hatool.u;
import com.huawei.hms.hatool.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class t {
    public List a;
    public String b;
    public String c;
    public String d;

    public t(List list, String string2, String string3, String string4) {
        this.a = list;
        this.b = string2;
        this.c = string3;
        this.d = string4;
    }

    public void a() {
        String string2 = "_default_config_tag";
        Object object = this.c;
        boolean bl2 = string2.equals(object);
        if (bl2) {
            String string3;
            String string4;
            String string5;
            String string6;
            object = new Object();
            ArrayList<q> arrayList = new ArrayList<q>();
            ArrayList<q> arrayList2 = new ArrayList<q>();
            ArrayList<q> arrayList3 = new ArrayList<q>();
            Iterator iterator2 = this.a.iterator();
            while (true) {
                boolean bl3;
                boolean bl4 = iterator2.hasNext();
                string6 = "diffprivacy";
                string5 = "preins";
                string4 = "maint";
                string3 = "oper";
                if (!bl4) break;
                q q10 = (q)iterator2.next();
                String string7 = q10.c();
                boolean bl5 = TextUtils.isEmpty((CharSequence)string7);
                if (!bl5 && !(bl3 = string3.equals(string7))) {
                    boolean bl6 = string4.equals(string7);
                    if (bl6) {
                        object.add(q10);
                        continue;
                    }
                    boolean bl7 = string5.equals(string7);
                    if (bl7) {
                        arrayList.add(q10);
                        continue;
                    }
                    boolean bl8 = string6.equals(string7);
                    if (!bl8) continue;
                    arrayList2.add(q10);
                    continue;
                }
                arrayList3.add(q10);
            }
            this.a(arrayList3, string3, string2);
            this.a((List)object, string4, string2);
            this.a(arrayList, string5, string2);
            this.a(arrayList2, string6, string2);
        } else {
            object = this.a;
            string2 = this.c;
            String string8 = this.b;
            this.a((List)object, string2, string8);
        }
    }

    public final void a(List list, String string2, String string3) {
        int n10 = list.isEmpty();
        if (n10 != 0) {
            return;
        }
        n10 = list.size() / 500 + 1;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string4;
            Object object;
            boolean bl2;
            int n11 = i10 * 500;
            int n12 = list.size();
            int n13 = n11 + 500;
            n12 = Math.min(n12, n13);
            Object object2 = list.subList(n11, n12);
            String string5 = UUID.randomUUID().toString();
            String string6 = "-";
            String string7 = "";
            String string8 = string5.replace(string6, string7);
            long l10 = System.currentTimeMillis();
            int n14 = com.huawei.hms.hatool.c.b(string3, string2);
            long l11 = n14;
            long l12 = 86400000L;
            l11 *= l12;
            ArrayList<Object> arrayList = new ArrayList<Object>();
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                object = (q)object2.next();
                string4 = ((q)object).b();
                boolean bl3 = p0.a(string4, l10, l11);
                if (bl3) continue;
                arrayList.add(object);
            }
            n11 = arrayList.size();
            if (n11 > 0) {
                String string9 = this.d;
                object = string3;
                string4 = string2;
                object2 = new u(string3, string2, string9, arrayList, string8);
                ((u)object2).a();
                continue;
            }
            object2 = "hmsSdk";
            string5 = "No data to report handler";
            y.e((String)object2, string5);
        }
    }
}

