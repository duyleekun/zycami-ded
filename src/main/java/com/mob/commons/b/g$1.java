/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.mob.commons.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mob.commons.b.g;
import com.mob.commons.b.g$a;
import com.mob.commons.k;
import java.util.ArrayList;

public class g$1
extends BroadcastReceiver {
    public final /* synthetic */ g a;

    public g$1(g g10) {
        this.a = g10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onReceive(Context object, Intent object2) {
        if (object == null) return;
        if (object2 == null) return;
        int n10 = 127;
        try {
            Object object3 = k.a(n10);
            boolean bl2 = false;
            n10 = object2.getIntExtra((String)object3, 0);
            int n11 = 2;
            if (n10 == n11) {
                n10 = 128;
                object3 = k.a(n10);
                if ((object3 = object2.getStringArrayListExtra((String)object3)) != null) {
                    object = object.getPackageName();
                    bl2 = ((ArrayList)object3).contains(object);
                }
            }
            if (!bl2) return;
            int n12 = 129;
            object = k.a(n12);
            if ((object = object2.getStringExtra((String)object)) == null) return;
            int n13 = 71;
            String string2 = k.a(n13);
            n13 = (int)(((String)object).equals(string2) ? 1 : 0);
            long l10 = 0L;
            if (n13 != 0) {
                object = this.a;
                object = g.a((g)object);
                ((g$a)object).a(l10);
                return;
            }
            n13 = 69;
            String string3 = k.a(n13);
            if ((n13 = (int)(((String)object).equals(string3) ? 1 : 0)) != 0) {
                object = this.a;
                object = g.b((g)object);
                ((g$a)object).a(l10);
                return;
            }
            n13 = 70;
            String string4 = k.a(n13);
            if ((n13 = (int)(((String)object).equals(string4) ? 1 : 0)) != 0) {
                object = this.a;
                object = g.c((g)object);
                ((g$a)object).a(l10);
                return;
            }
            n13 = 75;
            String string5 = k.a(n13);
            n12 = (int)(((String)object).equals(string5) ? 1 : 0);
            if (n12 == 0) return;
            object = this.a;
            object = g.d((g)object);
            ((g$a)object).a(l10);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }
}

