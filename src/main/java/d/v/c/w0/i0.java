/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.LinearLayout
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.ui.ShadowSeekBar;
import d.v.c.w0.h0;

public class i0
extends h0 {
    private static final ViewDataBinding$IncludedLayouts f;
    private static final SparseIntArray g;
    private final LinearLayout d;
    private long e;

    static {
        SparseIntArray sparseIntArray;
        g = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363140, 1);
        sparseIntArray.put(2131362825, 2);
        sparseIntArray.put(2131363155, 3);
    }

    public i0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = f;
        SparseIntArray sparseIntArray = g;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private i0(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[2];
        object2 = (LinearLayout)object;
        Object object3 = object = objectArray[1];
        object3 = (RecyclerView)object;
        Object object4 = object = objectArray[3];
        object4 = (ShadowSeekBar)((Object)object);
        super(dataBindingComponent, view, 0, (LinearLayout)object2, (RecyclerView)object3, (ShadowSeekBar)((Object)object4));
        this.e = -1;
        dataBindingComponent = (LinearLayout)objectArray[0];
        this.d = dataBindingComponent;
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
            this.e = l10 = 0L;
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
            long l10 = this.e;
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
            this.e = l10 = 1L;
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

