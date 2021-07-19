/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.av;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class au
extends Observable {
    private final ArrayList a;

    public au() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public void a() {
        boolean bl2;
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            av av2 = (av)iterator2.next();
            av2.a();
        }
    }

    public void a(av av2) {
        synchronized (this) {
            block8: {
                if (av2 != null) {
                    ArrayList arrayList = this.a;
                    boolean bl2 = arrayList.contains(av2);
                    if (bl2) break block8;
                    arrayList = this.a;
                    arrayList.add(av2);
                }
            }
            return;
        }
    }

    public void a(String string2, String string3) {
        boolean bl2;
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            av av2 = (av)iterator2.next();
            av2.a(string2, string3);
        }
    }

    public void a(boolean bl2, String string2) {
        boolean bl3;
        Iterator iterator2 = this.a.iterator();
        while (bl3 = iterator2.hasNext()) {
            av av2 = (av)iterator2.next();
            av2.a(bl2, string2);
        }
    }

    public void b() {
        boolean bl2;
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            av av2 = (av)iterator2.next();
            av2.b();
        }
    }
}

