/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 */
package com.chad.library.adapter.base;

import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;
import f.h2.t.u;
import java.util.List;

public abstract class BaseDelegateMultiAdapter
extends BaseQuickAdapter {
    private BaseMultiTypeDelegate mMultiTypeDelegate;

    public BaseDelegateMultiAdapter() {
        this(null, 1, null);
    }

    public BaseDelegateMultiAdapter(List list) {
        super(0, list);
    }

    public /* synthetic */ BaseDelegateMultiAdapter(List list, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            list = null;
        }
        this(list);
    }

    public int getDefItemViewType(int n10) {
        Object object = this.getMultiTypeDelegate();
        if (object != null) {
            List list = this.getData();
            return ((BaseMultiTypeDelegate)object).getItemType(list, n10);
        }
        object = "Please use setMultiTypeDelegate first!".toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public final BaseMultiTypeDelegate getMultiTypeDelegate() {
        return this.mMultiTypeDelegate;
    }

    public BaseViewHolder onCreateDefViewHolder(ViewGroup object, int n10) {
        f0.q(object, "parent");
        BaseMultiTypeDelegate baseMultiTypeDelegate = this.getMultiTypeDelegate();
        if (baseMultiTypeDelegate != null) {
            n10 = baseMultiTypeDelegate.getLayoutId(n10);
            return this.createBaseViewHolder((ViewGroup)object, n10);
        }
        String string2 = "Please use setMultiTypeDelegate first!".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public final void setMultiTypeDelegate(BaseMultiTypeDelegate baseMultiTypeDelegate) {
        f0.q(baseMultiTypeDelegate, "multiTypeDelegate");
        this.mMultiTypeDelegate = baseMultiTypeDelegate;
    }
}

