/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.chad.library.adapter.base.binder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseBinderAdapter;
import com.chad.library.adapter.base.binder.BaseItemBinder$clickViewIds$2;
import com.chad.library.adapter.base.binder.BaseItemBinder$longClickViewIds$2;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.s.a;
import f.h2.t.f0;
import f.t;
import f.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;

public abstract class BaseItemBinder {
    private BaseBinderAdapter _adapter;
    private Context _context;
    private final t clickViewIds$delegate;
    private final t longClickViewIds$delegate;

    public BaseItemBinder() {
        Object object = LazyThreadSafetyMode.NONE;
        Object object2 = BaseItemBinder$clickViewIds$2.INSTANCE;
        this.clickViewIds$delegate = object2 = w.b(object, (a)object2);
        object2 = BaseItemBinder$longClickViewIds$2.INSTANCE;
        object = w.b(object, (a)object2);
        this.longClickViewIds$delegate = object;
    }

    private final ArrayList getClickViewIds() {
        return (ArrayList)this.clickViewIds$delegate.getValue();
    }

    private final ArrayList getLongClickViewIds() {
        return (ArrayList)this.longClickViewIds$delegate.getValue();
    }

    public final void addChildClickViewIds(int ... nArray) {
        String string2 = "ids";
        f0.q(nArray, string2);
        for (int n10 : nArray) {
            ArrayList arrayList = this.getClickViewIds();
            Integer n11 = n10;
            arrayList.add(n11);
        }
    }

    public final void addChildLongClickViewIds(int ... nArray) {
        String string2 = "ids";
        f0.q(nArray, string2);
        for (int n10 : nArray) {
            ArrayList arrayList = this.getLongClickViewIds();
            Integer n11 = n10;
            arrayList.add(n11);
        }
    }

    public abstract void convert(BaseViewHolder var1, Object var2);

    public void convert(BaseViewHolder baseViewHolder, Object object, List list) {
        f0.q(baseViewHolder, "holder");
        f0.q(list, "payloads");
    }

    public final BaseBinderAdapter getAdapter() {
        Object object = this._adapter;
        if (object != null) {
            if (object == null) {
                f0.L();
            }
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("This ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" has not been attached to BaseBinderAdapter yet.\n                    You should not call the method before addItemBinder().");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public final ArrayList getChildClickViewIds() {
        return this.getClickViewIds();
    }

    public final ArrayList getChildLongClickViewIds() {
        return this.getLongClickViewIds();
    }

    public final Context getContext() {
        Object object = this._context;
        if (object != null) {
            if (object == null) {
                f0.L();
            }
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("This ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" has not been attached to BaseBinderAdapter yet.\n                    You should not call the method before onCreateViewHolder().");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public final List getData() {
        return this.getAdapter().getData();
    }

    public final BaseBinderAdapter get_adapter$com_github_CymChad_brvah() {
        return this._adapter;
    }

    public final Context get_context$com_github_CymChad_brvah() {
        return this._context;
    }

    public void onChildClick(BaseViewHolder baseViewHolder, View view, Object object, int n10) {
        f0.q(baseViewHolder, "holder");
        f0.q(view, "view");
    }

    public boolean onChildLongClick(BaseViewHolder baseViewHolder, View view, Object object, int n10) {
        f0.q(baseViewHolder, "holder");
        f0.q(view, "view");
        return false;
    }

    public void onClick(BaseViewHolder baseViewHolder, View view, Object object, int n10) {
        f0.q(baseViewHolder, "holder");
        f0.q(view, "view");
    }

    public abstract BaseViewHolder onCreateViewHolder(ViewGroup var1, int var2);

    public boolean onFailedToRecycleView(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
        return false;
    }

    public boolean onLongClick(BaseViewHolder baseViewHolder, View view, Object object, int n10) {
        f0.q(baseViewHolder, "holder");
        f0.q(view, "view");
        return false;
    }

    public void onViewAttachedToWindow(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
    }

    public void onViewDetachedFromWindow(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
    }

    public final void set_adapter$com_github_CymChad_brvah(BaseBinderAdapter baseBinderAdapter) {
        this._adapter = baseBinderAdapter;
    }

    public final void set_context$com_github_CymChad_brvah(Context context) {
        this._context = context;
    }
}

