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
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.chad.library.adapter.base.BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$1;
import com.chad.library.adapter.base.BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$2;
import com.chad.library.adapter.base.BaseBinderAdapter$bindClick$1;
import com.chad.library.adapter.base.BaseBinderAdapter$bindClick$2;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;
import f.h2.t.u;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;

public class BaseBinderAdapter
extends BaseQuickAdapter {
    private final HashMap classDiffMap;
    private final SparseArray mBinderArray;
    private final HashMap mTypeMap;

    public BaseBinderAdapter() {
        this(null, 1, null);
    }

    public BaseBinderAdapter(List object) {
        super(0, (List)object);
        this.classDiffMap = object = new HashMap();
        this.mTypeMap = object = new HashMap();
        this.mBinderArray = object = new SparseArray();
        super(this);
        this.setDiffCallback((DiffUtil$ItemCallback)object);
    }

    public /* synthetic */ BaseBinderAdapter(List list, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            list = null;
        }
        this(list);
    }

    public static final /* synthetic */ HashMap access$getClassDiffMap$p(BaseBinderAdapter baseBinderAdapter) {
        return baseBinderAdapter.classDiffMap;
    }

    public static /* synthetic */ BaseBinderAdapter addItemBinder$default(BaseBinderAdapter object, BaseItemBinder baseItemBinder, DiffUtil$ItemCallback diffUtil$ItemCallback, int n10, Object object2) {
        if (object2 == null) {
            if ((n10 &= 2) != 0) {
                diffUtil$ItemCallback = null;
            }
            f0.q(baseItemBinder, "baseItemBinder");
            f0.y(4, "T");
            ((BaseBinderAdapter)object).addItemBinder(Object.class, baseItemBinder, diffUtil$ItemCallback);
            return object;
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
        throw object;
    }

    public static /* synthetic */ BaseBinderAdapter addItemBinder$default(BaseBinderAdapter object, Class clazz, BaseItemBinder baseItemBinder, DiffUtil$ItemCallback diffUtil$ItemCallback, int n10, Object object2) {
        if (object2 == null) {
            if ((n10 &= 4) != 0) {
                diffUtil$ItemCallback = null;
            }
            return ((BaseBinderAdapter)object).addItemBinder(clazz, baseItemBinder, diffUtil$ItemCallback);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
        throw object;
    }

    public final /* synthetic */ BaseBinderAdapter addItemBinder(BaseItemBinder baseItemBinder, DiffUtil$ItemCallback diffUtil$ItemCallback) {
        f0.q(baseItemBinder, "baseItemBinder");
        f0.y(4, "T");
        this.addItemBinder(Object.class, baseItemBinder, diffUtil$ItemCallback);
        return this;
    }

    public final BaseBinderAdapter addItemBinder(Class clazz, BaseItemBinder baseItemBinder) {
        return BaseBinderAdapter.addItemBinder$default(this, clazz, baseItemBinder, null, 4, null);
    }

    public final BaseBinderAdapter addItemBinder(Class serializable, BaseItemBinder object, DiffUtil$ItemCallback diffUtil$ItemCallback) {
        f0.q(serializable, "clazz");
        f0.q(object, "baseItemBinder");
        HashMap hashMap = this.mTypeMap;
        int n10 = hashMap.size() + 1;
        HashMap hashMap2 = this.mTypeMap;
        Integer n11 = n10;
        hashMap2.put(serializable, n11);
        hashMap2 = this.mBinderArray;
        hashMap2.append(n10, object);
        ((BaseItemBinder)object).set_adapter$com_github_CymChad_brvah(this);
        if (diffUtil$ItemCallback != null) {
            object = this.classDiffMap;
            if (diffUtil$ItemCallback != null) {
                object.put(serializable, diffUtil$ItemCallback);
            } else {
                serializable = new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.DiffUtil.ItemCallback<kotlin.Any>");
                throw serializable;
            }
        }
        return this;
    }

    public void bindChildClick(BaseViewHolder baseViewHolder, int n10) {
        Object object;
        int n11;
        View view;
        f0.q(baseViewHolder, "viewHolder");
        Iterator iterator2 = this.getOnItemChildClickListener();
        boolean bl2 = true;
        if (iterator2 == null) {
            iterator2 = this.getItemBinder(n10);
            view = ((BaseItemBinder)((Object)iterator2)).getChildClickViewIds().iterator();
            while ((n11 = view.hasNext()) != 0) {
                Object object2 = baseViewHolder.itemView;
                n11 = ((Number)view.next()).intValue();
                object = object2.findViewById(n11);
                if (object == null) continue;
                boolean bl3 = object.isClickable();
                if (!bl3) {
                    object.setClickable(bl2);
                }
                object2 = new BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$1(this, baseViewHolder, (BaseItemBinder)((Object)iterator2));
                object.setOnClickListener((View.OnClickListener)object2);
            }
        }
        if ((iterator2 = this.getOnItemChildLongClickListener()) == null) {
            int n12;
            BaseItemBinder baseItemBinder = this.getItemBinder(n10);
            iterator2 = baseItemBinder.getChildLongClickViewIds().iterator();
            while ((n12 = iterator2.hasNext()) != 0) {
                object = baseViewHolder.itemView;
                n12 = ((Number)iterator2.next()).intValue();
                view = object.findViewById(n12);
                if (view == null) continue;
                n11 = (int)(view.isLongClickable() ? 1 : 0);
                if (n11 == 0) {
                    view.setLongClickable(bl2);
                }
                object = new BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$2(this, baseViewHolder, baseItemBinder);
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
            object = new BaseBinderAdapter$bindClick$1(this, baseViewHolder);
            object2.setOnClickListener((View.OnClickListener)object);
        }
        if ((object2 = this.getOnItemLongClickListener()) == null) {
            object2 = baseViewHolder.itemView;
            object = new BaseBinderAdapter$bindClick$2(this, baseViewHolder);
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
        f0.q(object, "item");
        int n10 = baseViewHolder.getItemViewType();
        this.getItemBinder(n10).convert(baseViewHolder, object);
    }

    public void convert(BaseViewHolder baseViewHolder, Object object, List list) {
        f0.q(baseViewHolder, "holder");
        f0.q(object, "item");
        f0.q(list, "payloads");
        int n10 = baseViewHolder.getItemViewType();
        this.getItemBinder(n10).convert(baseViewHolder, object, list);
    }

    public final int findViewType(Class object) {
        f0.q(object, "clazz");
        Serializable serializable = (Integer)this.mTypeMap.get(object);
        if (serializable != null) {
            return serializable;
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("findViewType: ViewType: ");
        ((StringBuilder)serializable).append(object);
        ((StringBuilder)serializable).append(" Not Find!");
        object = ((StringBuilder)serializable).toString();
        object = object.toString();
        serializable = new IllegalStateException((String)object);
        throw serializable;
    }

    public int getDefItemViewType(int n10) {
        Class<?> clazz = this.getData().get(n10).getClass();
        return this.findViewType(clazz);
    }

    public BaseItemBinder getItemBinder(int n10) {
        Object object = (BaseItemBinder)this.mBinderArray.get(n10);
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("getItemBinder: viewType '");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("' no such Binder found\uff0cplease use addItemBinder() first!");
        String string2 = ((StringBuilder)object).toString();
        string2 = string2.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public BaseItemBinder getItemBinderOrNull(int n10) {
        SparseArray sparseArray = this.mBinderArray;
        BaseItemBinder baseItemBinder = (BaseItemBinder)sparseArray.get(n10);
        boolean bl2 = baseItemBinder instanceof BaseItemBinder;
        if (!bl2) {
            n10 = 0;
            baseItemBinder = null;
        }
        return baseItemBinder;
    }

    public BaseViewHolder onCreateDefViewHolder(ViewGroup viewGroup, int n10) {
        f0.q(viewGroup, "parent");
        BaseItemBinder baseItemBinder = this.getItemBinder(n10);
        Context context = this.getContext();
        baseItemBinder.set_context$com_github_CymChad_brvah(context);
        return baseItemBinder.onCreateViewHolder(viewGroup, n10);
    }

    public boolean onFailedToRecycleView(BaseViewHolder baseViewHolder) {
        boolean bl2;
        f0.q(baseViewHolder, "holder");
        int n10 = baseViewHolder.getItemViewType();
        BaseItemBinder baseItemBinder = this.getItemBinderOrNull(n10);
        if (baseItemBinder != null) {
            bl2 = baseItemBinder.onFailedToRecycleView(baseViewHolder);
        } else {
            bl2 = false;
            baseViewHolder = null;
        }
        return bl2;
    }

    public void onViewAttachedToWindow(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
        super.onViewAttachedToWindow(baseViewHolder);
        int n10 = baseViewHolder.getItemViewType();
        BaseItemBinder baseItemBinder = this.getItemBinderOrNull(n10);
        if (baseItemBinder != null) {
            baseItemBinder.onViewAttachedToWindow(baseViewHolder);
        }
    }

    public void onViewDetachedFromWindow(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "holder");
        super.onViewDetachedFromWindow(baseViewHolder);
        int n10 = baseViewHolder.getItemViewType();
        BaseItemBinder baseItemBinder = this.getItemBinderOrNull(n10);
        if (baseItemBinder != null) {
            baseItemBinder.onViewDetachedFromWindow(baseViewHolder);
        }
    }
}

