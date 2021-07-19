/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.w0.id;

public class jd
extends id {
    private static final ViewDataBinding$IncludedLayouts e;
    private static final SparseIntArray f;
    private final FrameLayout c;
    private long d;

    static {
        SparseIntArray sparseIntArray;
        f = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362653, 1);
        sparseIntArray.put(2131362654, 2);
    }

    public jd(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = e;
        SparseIntArray sparseIntArray = f;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private jd(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[2];
        object3 = (ImageView)object;
        super(dataBindingComponent, view, 0, (ImageView)object2, (ImageView)object3);
        this.d = -1;
        dataBindingComponent = (FrameLayout)objectArray[0];
        this.c = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        synchronized (this) {
            long l10;
            this.d = l10 = 0L;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.d;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false) return false;
            return (boolean)((long)1);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void invalidateAll() {
        synchronized (this) {
            long l10;
            this.d = l10 = 1L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        return true;
    }
}

