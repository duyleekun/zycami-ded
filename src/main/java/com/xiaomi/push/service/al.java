/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.ad;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hv;
import com.xiaomi.push.hx;
import com.xiaomi.push.ij;
import com.xiaomi.push.ik;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.am;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class al {
    public static int a(ak ak2, hs hs2) {
        String string2 = al.a(hs2);
        int[] nArray = am.a;
        int n10 = hs2.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 0;
            nArray = null;
        }
        return ak2.a.getInt(string2, n11);
    }

    private static String a(hs hs2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("oc_version_");
        int n10 = hs2.a();
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    private static List a(List object, boolean bl2) {
        boolean bl3;
        boolean bl4 = ad.a((Collection)((Object)object));
        if (bl4) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl3 = object.hasNext()) {
            Integer n10;
            int n11;
            Object object2 = (hx)object.next();
            int n12 = ((hx)object2).a();
            int n13 = ((hx)object2).b();
            ht ht2 = ht.a(n13);
            if (ht2 == null) continue;
            if (bl2 && (n11 = ((hx)object2).a) != 0) {
                n10 = n12;
                object2 = new Pair((Object)n10, null);
                arrayList.add(object2);
                continue;
            }
            int[] nArray = am.b;
            n13 = ht2.ordinal();
            n11 = 1;
            if ((n13 = nArray[n13]) != n11) {
                n11 = 2;
                if (n13 != n11) {
                    n11 = 3;
                    if (n13 != n11) {
                        n11 = 4;
                        if (n13 != n11) {
                            n13 = 0;
                            ht2 = null;
                        } else {
                            n10 = n12;
                            bl3 = ((hx)object2).g();
                            object2 = bl3;
                            ht2 = new Pair((Object)n10, object2);
                        }
                    } else {
                        n10 = n12;
                        object2 = ((hx)object2).a();
                        ht2 = new Pair((Object)n10, object2);
                    }
                } else {
                    n10 = n12;
                    long l10 = ((hx)object2).a();
                    object2 = l10;
                    ht2 = new Pair((Object)n10, object2);
                }
            } else {
                n10 = n12;
                bl3 = ((hx)object2).c();
                object2 = (int)(bl3 ? 1 : 0);
                ht2 = new Pair((Object)n10, object2);
            }
            arrayList.add((Object)ht2);
        }
        return arrayList;
    }

    public static void a(ak ak2, hs object, int n10) {
        object = al.a(object);
        ak2.a.edit().putInt((String)object, n10).commit();
    }

    public static void a(ak ak2, ij object) {
        object = al.a(((ij)object).a(), true);
        ak2.b((List)object);
        ak2.b();
    }

    public static void a(ak ak2, ik object) {
        boolean bl2;
        object = ((ik)object).a().iterator();
        while (bl2 = object.hasNext()) {
            hs hs2;
            int n10;
            Object object2 = (hv)object.next();
            int n11 = ((hv)object2).a();
            if (n11 <= (n10 = al.a(ak2, hs2 = ((hv)object2).a()))) continue;
            hs hs3 = ((hv)object2).a();
            n10 = ((hv)object2).a();
            al.a(ak2, hs3, n10);
            object2 = ((hv)object2).a;
            n11 = 0;
            hs3 = null;
            object2 = al.a((List)object2, false);
            ak2.a((List)object2);
        }
        ak2.b();
    }
}

