/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.chad.library.adapter.base.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider$clickViewIds$2;
import com.chad.library.adapter.base.provider.BaseItemProvider$longClickViewIds$2;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.s.a;
import f.h2.t.f0;
import f.t;
import f.w;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;

public abstract class BaseItemProvider {
    private final t clickViewIds$delegate;
    public Context context;
    private final t longClickViewIds$delegate;
    private WeakReference weakAdapter;

    public BaseItemProvider() {
        Object object = LazyThreadSafetyMode.NONE;
        Object object2 = BaseItemProvider$clickViewIds$2.INSTANCE;
        this.clickViewIds$delegate = object2 = w.b(object, (a)object2);
        object2 = BaseItemProvider$longClickViewIds$2.INSTANCE;
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
        f0.q(baseViewHolder, "helper");
        f0.q(list, "payloads");
    }

    public BaseProviderMultiAdapter getAdapter() {
        Object object = this.weakAdapter;
        object = object != null ? (BaseProviderMultiAdapter)((Reference)object).get() : null;
        return object;
    }

    public final ArrayList getChildClickViewIds() {
        return this.getClickViewIds();
    }

    public final ArrayList getChildLongClickViewIds() {
        return this.getLongClickViewIds();
    }

    public final Context getContext() {
        Context context = this.context;
        if (context == null) {
            String string2 = "context";
            f0.S(string2);
        }
        return context;
    }

    public abstract int getItemViewType();

    public abstract int getLayoutId();

    public void onChildClick(BaseViewHolder baseViewHolder, View view, Object object, int n10) {
        f0.q(baseViewHolder, "helper");
        f0.q(view, "view");
    }

    public boolean onChildLongClick(BaseViewHolder baseViewHolder, View view, Object object, int n10) {
        f0.q(baseViewHolder, "helper");
        f0.q(view, "view");
        return false;
    }

    public void onClick(BaseViewHolder baseViewHolder, View view, Object object, int n10) {
        f0.q(baseViewHolder, "helper");
        f0.q(view, "view");
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int n10) {
        f0.q(viewGroup, "parent");
        int n11 = this.getLayoutId();
        viewGroup = AdapterUtilsKt.getItemView(viewGroup, n11);
        BaseViewHolder baseViewHolder = new BaseViewHolder((View)viewGroup);
        return baseViewHolder;
    }

    public boolean onLongClick(BaseViewHolder baseViewHolder, View view, Object object, int n10) {
        f0.q(baseViewHolder, "helper");
        f0.q(view, "view");
        return false;
    }

    public void onViewAttachedToWindow(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
    }

    public void onViewDetachedFromWindow(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
    }

    public void onViewHolderCreated(BaseViewHolder baseViewHolder, int n10) {
        f0.q(baseViewHolder, "viewHolder");
    }

    public final void setAdapter$com_github_CymChad_brvah(BaseProviderMultiAdapter baseProviderMultiAdapter) {
        WeakReference<BaseProviderMultiAdapter> weakReference;
        f0.q(baseProviderMultiAdapter, "adapter");
        this.weakAdapter = weakReference = new WeakReference<BaseProviderMultiAdapter>(baseProviderMultiAdapter);
    }

    public final void setContext(Context context) {
        f0.q(context, "<set-?>");
        this.context = context;
    }
}

