/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.GnssNavigationMessage
 */
package com.baidu.location.b;

import android.location.GnssNavigationMessage;
import com.baidu.location.b.ab$a;
import com.baidu.location.b.ab$b;
import com.baidu.location.b.r;
import java.util.ArrayList;
import java.util.Iterator;

public class ab {
    private ab$b a;
    private long b;
    private long c;

    public ab() {
        long l10;
        this.b = l10 = 0L;
        this.c = l10;
    }

    public static ab a() {
        return ab$a.a();
    }

    public void a(GnssNavigationMessage gnssNavigationMessage, long l10) {
        long l11;
        r.a().a(gnssNavigationMessage, l10);
        this.b = l11 = System.currentTimeMillis();
        this.c = l10;
    }

    public void b() {
        long l10 = this.b;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l10 = System.currentTimeMillis();
            l11 = this.b;
            long l13 = (l10 = Math.abs(l10 - l11)) - (l11 = 20000L);
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object < 0) {
                int n10;
                Object object2 = this.a;
                if (object2 == null) {
                    object2 = new ab$b(this);
                    this.a = object2;
                }
                if ((object2 = this.a) != null && (object = (Object)((ab$b)object2).a()) == false && (object2 = r.a().b()) != null && (n10 = ((ArrayList)object2).size()) > 0) {
                    int n11;
                    CharSequence charSequence = new StringBuffer();
                    int n12 = 0;
                    Iterator iterator2 = ((ArrayList)object2).iterator();
                    while ((n11 = iterator2.hasNext()) != 0) {
                        String string2 = (String)iterator2.next();
                        ((StringBuffer)charSequence).append(string2);
                        n11 = ((ArrayList)object2).size();
                        if (++n12 == n11) continue;
                        string2 = ";";
                        ((StringBuffer)charSequence).append(string2);
                    }
                    object2 = this.a;
                    charSequence = ((StringBuffer)charSequence).toString();
                    l11 = this.c;
                    ((ab$b)object2).a((String)charSequence, l11);
                }
            }
        }
    }
}

