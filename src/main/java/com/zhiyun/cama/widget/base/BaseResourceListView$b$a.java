/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.widget.base;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import d.v.c.b2.w.a;

public class BaseResourceListView$b$a
extends DiffUtil$ItemCallback {
    public final /* synthetic */ BaseResourceListView a;

    public BaseResourceListView$b$a(BaseResourceListView baseResourceListView) {
        this.a = baseResourceListView;
    }

    public boolean a(a a10, a a11) {
        int n10;
        int n11 = a10.t();
        if (n11 == (n10 = a11.t())) {
            n11 = 1;
        } else {
            n11 = 0;
            a10 = null;
        }
        return n11 != 0;
    }

    public boolean b(a a10, a a11) {
        long l10;
        long l11 = a10.x();
        long l12 = l11 - (l10 = a11.x());
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            a10 = null;
        }
        return (boolean)object;
    }
}

