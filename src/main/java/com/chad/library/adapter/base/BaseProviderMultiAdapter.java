/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 */
package com.chad.library.adapter.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$1;
import com.chad.library.adapter.base.BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$2;
import com.chad.library.adapter.base.BaseProviderMultiAdapter$bindClick$1;
import com.chad.library.adapter.base.BaseProviderMultiAdapter$bindClick$2;
import com.chad.library.adapter.base.BaseProviderMultiAdapter$mItemProviders$2;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;
import f.h2.t.u;
import f.t;
import f.w;
import java.util.List;
import kotlin.LazyThreadSafetyMode;

public abstract class BaseProviderMultiAdapter
extends BaseQuickAdapter {
    private final t mItemProviders$delegate;

    public BaseProviderMultiAdapter() {
        this(null, 1, null);
    }

    public BaseProviderMultiAdapter(List object) {
        super(0, (List)object);
        object = LazyThreadSafetyMode.NONE;
        BaseProviderMultiAdapter$mItemProviders$2 baseProviderMultiAdapter$mItemProviders$2 = BaseProviderMultiAdapter$mItemProviders$2.INSTANCE;
        object = w.b((LazyThreadSafetyMode)((Object)object), baseProviderMultiAdapter$mItemProviders$2);
        this.mItemProviders$delegate = object;
    }

    public /* synthetic */ BaseProviderMultiAdapter(List list, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            list = null;
        }
        this(list);
    }

    public static final /* synthetic */ SparseArray access$getMItemProviders$p(BaseProviderMultiAdapter baseProviderMultiAdapter) {
        return baseProviderMultiAdapter.getMItemProviders();
    }

    private final SparseArray getMItemProviders() {
        return (SparseArray)this.mItemProviders$delegate.getValue();
    }

    public void addItemProvider(BaseItemProvider baseItemProvider) {
        f0.q(baseItemProvider, "provider");
        baseItemProvider.setAdapter$com_github_CymChad_brvah(this);
        SparseArray sparseArray = this.getMItemProviders();
        int n10 = baseItemProvider.getItemViewType();
        sparseArray.put(n10, (Object)baseItemProvider);
    }

    public void bindChildClick(BaseViewHolder baseViewHolder, int n10) {
        BaseItemProvider baseItemProvider;
        Object object;
        int n11;
        View view;
        f0.q(baseViewHolder, "viewHolder");
        Object object2 = this.getOnItemChildClickListener();
        boolean bl2 = true;
        if (object2 == null) {
            object2 = this.getItemProvider(n10);
            if (object2 != null) {
                view = ((BaseItemProvider)object2).getChildClickViewIds().iterator();
                while ((n11 = view.hasNext()) != 0) {
                    Object object3 = baseViewHolder.itemView;
                    n11 = ((Number)view.next()).intValue();
                    object = object3.findViewById(n11);
                    if (object == null) continue;
                    boolean bl3 = object.isClickable();
                    if (!bl3) {
                        object.setClickable(bl2);
                    }
                    object3 = new BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$1(this, baseViewHolder, (BaseItemProvider)object2);
                    object.setOnClickListener((View.OnClickListener)object3);
                }
            } else {
                return;
            }
        }
        if ((object2 = this.getOnItemChildLongClickListener()) == null && (baseItemProvider = this.getItemProvider(n10)) != null) {
            int n12;
            object2 = baseItemProvider.getChildLongClickViewIds().iterator();
            while ((n12 = object2.hasNext()) != 0) {
                object = baseViewHolder.itemView;
                n12 = ((Number)object2.next()).intValue();
                view = object.findViewById(n12);
                if (view == null) continue;
                n11 = (int)(view.isLongClickable() ? 1 : 0);
                if (n11 == 0) {
                    view.setLongClickable(bl2);
                }
                object = new BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$2(this, baseViewHolder, baseItemProvider);
                view.setOnLongClickListener((View.OnLongClickListener)object);
            }
        }
    }

    public void bindClick(BaseViewHolder baseViewHolder) {
        Object object;
        f0.q(baseViewHolder, "viewHolder");
        Object object2 = this.getOnItemClickListener();
        if (object2 == null) {
            object2 = baseViewHolder.itemView;
            object = new BaseProviderMultiAdapter$bindClick$1(this, baseViewHolder);
            object2.setOnClickListener((View.OnClickListener)object);
        }
        if ((object2 = this.getOnItemLongClickListener()) == null) {
            object2 = baseViewHolder.itemView;
            object = new BaseProviderMultiAdapter$bindClick$2(this, baseViewHolder);
            object2.setOnLongClickListener((View.OnLongClickListener)object);
        }
    }

    public void bindViewClickListener(BaseViewHolder baseViewHolder, int n10) {
        f0.q(baseViewHolder, "viewHolder");
        super.bindViewClickListener(baseViewHolder, n10);
        this.bindClick(baseViewHolder);
        this.bindChildClick(baseViewHolder, n10);
    }

    public void convert(BaseViewHolder baseViewHolder, Object object) {
        f0.q(baseViewHolder, "holder");
        int n10 = baseViewHolder.getItemViewType();
        BaseItemProvider baseItemProvider = this.getItemProvider(n10);
        if (baseItemProvider == null) {
            f0.L();
        }
        baseItemProvider.convert(baseViewHolder, object);
    }

    public void convert(BaseViewHolder baseViewHolder, Object object, List list) {
        f0.q(baseViewHolder, "holder");
        f0.q(list, "payloads");
        int n10 = baseViewHolder.getItemViewType();
        BaseItemProvider baseItemProvider = this.getItemProvider(n10);
        if (baseItemProvider == null) {
            f0.L();
        }
        baseItemProvider.convert(baseViewHolder, object, list);
    }

    public int getDefItemViewType(int n10) {
        List list = this.getData();
        return this.getItemType(list, n10);
    }

    public BaseItemProvider getItemProvider(int n10) {
        return (BaseItemProvider)this.getMItemProviders().get(n10);
    }

    public abstract int getItemType(List var1, int var2);

    public BaseViewHolder onCreateDefViewHolder(ViewGroup object, int n10) {
        f0.q(object, "parent");
        BaseItemProvider baseItemProvider = this.getItemProvider(n10);
        if (baseItemProvider != null) {
            Context context = object.getContext();
            f0.h(context, "parent.context");
            baseItemProvider.setContext(context);
            object = baseItemProvider.onCreateViewHolder((ViewGroup)object, n10);
            baseItemProvider.onViewHolderCreated((BaseViewHolder)object, n10);
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("ViewType: ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" no such provider found\uff0cplease use addItemProvider() first!");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public void onViewAttachedToWindow(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
        super.onViewAttachedToWindow(baseViewHolder);
        int n10 = baseViewHolder.getItemViewType();
        BaseItemProvider baseItemProvider = this.getItemProvider(n10);
        if (baseItemProvider != null) {
            baseItemProvider.onViewAttachedToWindow(baseViewHolder);
        }
    }

    public void onViewDetachedFromWindow(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
        super.onViewDetachedFromWindow(baseViewHolder);
        int n10 = baseViewHolder.getItemViewType();
        BaseItemProvider baseItemProvider = this.getItemProvider(n10);
        if (baseItemProvider != null) {
            baseItemProvider.onViewDetachedFromWindow(baseViewHolder);
        }
    }
}

