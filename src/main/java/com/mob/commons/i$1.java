/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons;

import com.mob.commons.b;
import com.mob.commons.c;
import com.mob.commons.d;
import com.mob.commons.e;
import java.util.HashMap;

public final class i$1
extends Thread {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = e.a;
        synchronized (object) {
            int n10 = 3;
            try {
                Object object2 = d.a();
                int n11 = 11;
                ((d)object2).a(n11);
                object.wait();
                object2 = b.ap();
                object2 = (HashMap)object2;
                if (object2 != null && (n11 = ((HashMap)object2).size()) > 0) {
                    Object object3 = d.a();
                    int n12 = 12;
                    ((d)object3).a(n12);
                    object3 = "h";
                    object3 = ((HashMap)object2).get(object3);
                    String string2 = "k";
                    string2 = ((HashMap)object2).get(string2);
                    String string3 = "b";
                    string3 = ((HashMap)object2).get(string3);
                    String string4 = "s";
                    string4 = ((HashMap)object2).get(string4);
                    String string5 = "cn";
                    string5 = ((HashMap)object2).get(string5);
                    String string6 = "fn";
                    string6 = ((HashMap)object2).get(string6);
                    ((HashMap)object2).clear();
                    object2 = c.a();
                    int n13 = 6;
                    Object[] objectArray = new Object[n13];
                    objectArray[0] = object3;
                    n11 = 1;
                    objectArray[n11] = string2;
                    n11 = 2;
                    objectArray[n11] = string3;
                    objectArray[n10] = string4;
                    n11 = 4;
                    objectArray[n11] = string5;
                    n11 = 5;
                    objectArray[n11] = string6;
                    ((c)object2).a(objectArray);
                }
            }
            catch (Throwable throwable) {
                d d10 = d.a();
                d10.a(n10, throwable);
            }
            return;
        }
    }
}

