/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.chad.library.adapter.base.BaseBinderAdapter;
import f.h2.t.f0;
import java.util.HashMap;

public final class BaseBinderAdapter$ItemCallback
extends DiffUtil$ItemCallback {
    public final /* synthetic */ BaseBinderAdapter this$0;

    public BaseBinderAdapter$ItemCallback(BaseBinderAdapter baseBinderAdapter) {
        this.this$0 = baseBinderAdapter;
    }

    public boolean areContentsTheSame(Object object, Object object2) {
        f0.q(object, "oldItem");
        f0.q(object2, "newItem");
        Object object3 = object.getClass();
        Class<?> clazz = object2.getClass();
        boolean bl2 = f0.g(object3, clazz);
        if (bl2) {
            object3 = BaseBinderAdapter.access$getClassDiffMap$p(this.this$0);
            clazz = object.getClass();
            if ((object3 = (DiffUtil$ItemCallback)((HashMap)object3).get(clazz)) != null) {
                return ((DiffUtil$ItemCallback)object3).areContentsTheSame(object, object2);
            }
        }
        return true;
    }

    public boolean areItemsTheSame(Object object, Object object2) {
        f0.q(object, "oldItem");
        f0.q(object2, "newItem");
        Object object3 = object.getClass();
        Class<?> clazz = object2.getClass();
        boolean bl2 = f0.g(object3, clazz);
        if (bl2) {
            object3 = BaseBinderAdapter.access$getClassDiffMap$p(this.this$0);
            clazz = object.getClass();
            if ((object3 = (DiffUtil$ItemCallback)((HashMap)object3).get(clazz)) != null) {
                return ((DiffUtil$ItemCallback)object3).areItemsTheSame(object, object2);
            }
        }
        return f0.g(object, object2);
    }

    public Object getChangePayload(Object object, Object object2) {
        f0.q(object, "oldItem");
        f0.q(object2, "newItem");
        Object object3 = object.getClass();
        Object object4 = object2.getClass();
        boolean bl2 = f0.g(object3, object4);
        object4 = null;
        if (bl2) {
            object3 = BaseBinderAdapter.access$getClassDiffMap$p(this.this$0);
            Class<?> clazz = object.getClass();
            if ((object3 = (DiffUtil$ItemCallback)((HashMap)object3).get(clazz)) != null) {
                object4 = ((DiffUtil$ItemCallback)object3).getChangePayload(object, object2);
            }
        }
        return object4;
    }
}

