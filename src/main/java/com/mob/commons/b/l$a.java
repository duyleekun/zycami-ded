/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 */
package com.mob.commons.b;

import android.database.ContentObserver;
import com.mob.commons.b.l;

public class l$a
extends ContentObserver {
    private int a;
    private l b;

    public l$a(l l10, int n10) {
        super(null);
        this.a = n10;
        this.b = l10;
    }

    public void onChange(boolean bl2) {
        l l10 = this.b;
        if (l10 != null) {
            int n10 = this.a;
            l.a(l10, bl2, n10);
        }
    }
}

