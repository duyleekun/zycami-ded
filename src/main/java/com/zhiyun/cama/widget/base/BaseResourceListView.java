/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.widget.base;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.widget.base.BaseResourceListView$ResourceType;
import com.zhiyun.cama.widget.base.BaseResourceListView$a;
import com.zhiyun.cama.widget.base.BaseResourceListView$b;
import d.v.c.b2.v.c;
import d.v.c.e1.s;
import d.v.c.v1.n;
import d.v.c.x0.b.r;
import d.v.c.x0.c.d.k;
import d.v.c.x0.c.f.i;
import d.v.f.d.b;
import java.util.List;

public class BaseResourceListView
extends RecyclerView {
    private BaseResourceListView$b a;
    private c b;

    public BaseResourceListView(Context context) {
        this(context, null);
    }

    public BaseResourceListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseResourceListView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.c();
    }

    public static /* synthetic */ c a(BaseResourceListView baseResourceListView) {
        return baseResourceListView.b;
    }

    private void c() {
        Context context = this.getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.setLayoutManager(linearLayoutManager);
    }

    public void b(LifecycleOwner lifecycleOwner, d.v.c.b2.v.b b10) {
        BaseResourceListView$b baseResourceListView$b;
        this.a = baseResourceListView$b = new BaseResourceListView$b(this, lifecycleOwner, b10);
        this.setAdapter(baseResourceListView$b);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a = null;
    }

    public void setData(List object) {
        Object object2 = this.a;
        if (object2 != null) {
            object2 = new Object(object);
            object = this.a;
            ((b)object).m((List)object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setResourceType(BaseResourceListView$ResourceType object) {
        int[] nArray = BaseResourceListView$a.a;
        int n10 = ((Enum)object).ordinal();
        int n11 = nArray[n10];
        if (n11 == (n10 = 1)) {
            k k10 = new k();
            this.b = k10;
            return;
        }
        n10 = 2;
        if (n11 == n10) {
            r r10 = new r();
            this.b = r10;
            return;
        }
        n10 = 3;
        if (n11 == n10) {
            i i10 = new i();
            this.b = i10;
            return;
        }
        n10 = 4;
        if (n11 == n10) {
            n n12 = new n();
            this.b = n12;
            return;
        }
        n10 = 5;
        if (n11 == n10) {
            s s10 = new s();
            this.b = s10;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\u4e0d\u652f\u6301\u7684\u53d8\u91cf\u7c7b\u578b:");
        stringBuilder.append(object);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }
}

