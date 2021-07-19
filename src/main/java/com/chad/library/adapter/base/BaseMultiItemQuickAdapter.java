/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.ViewGroup
 */
package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter$layouts$2;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;
import f.h2.t.u;
import f.t;
import f.w;
import java.util.List;
import kotlin.LazyThreadSafetyMode;

public abstract class BaseMultiItemQuickAdapter
extends BaseQuickAdapter {
    private final t layouts$delegate;

    public BaseMultiItemQuickAdapter() {
        this(null, 1, null);
    }

    public BaseMultiItemQuickAdapter(List object) {
        super(0, (List)object);
        object = LazyThreadSafetyMode.NONE;
        BaseMultiItemQuickAdapter$layouts$2 baseMultiItemQuickAdapter$layouts$2 = BaseMultiItemQuickAdapter$layouts$2.INSTANCE;
        object = w.b((LazyThreadSafetyMode)((Object)object), baseMultiItemQuickAdapter$layouts$2);
        this.layouts$delegate = object;
    }

    public /* synthetic */ BaseMultiItemQuickAdapter(List list, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            list = null;
        }
        this(list);
    }

    private final SparseIntArray getLayouts() {
        return (SparseIntArray)this.layouts$delegate.getValue();
    }

    public final void addItemType(int n10, int n11) {
        this.getLayouts().put(n10, n11);
    }

    public int getDefItemViewType(int n10) {
        return ((MultiItemEntity)this.getData().get(n10)).getItemType();
    }

    public BaseViewHolder onCreateDefViewHolder(ViewGroup object, int n10) {
        f0.q(object, "parent");
        SparseIntArray sparseIntArray = this.getLayouts();
        int n11 = sparseIntArray.get(n10);
        boolean bl2 = n11 != 0;
        if (bl2) {
            return this.createBaseViewHolder((ViewGroup)object, n11);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("ViewType: ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" found layoutResId\uff0cplease use addItemType() first!");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

