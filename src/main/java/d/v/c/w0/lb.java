/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.s0.d7.z;
import d.v.c.w0.kb;

public class lb
extends kb {
    private static final ViewDataBinding$IncludedLayouts f;
    private static final SparseIntArray g;
    private long e;

    static {
        SparseIntArray sparseIntArray;
        g = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363490, 1);
        sparseIntArray.put(2131362684, 2);
    }

    public lb(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = f;
        SparseIntArray sparseIntArray = g;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private lb(DataBindingComponent dataBindingComponent, View view, Object[] object) {
        Object object2;
        Object object3 = object2 = object[2];
        object3 = (ImageView)object2;
        Object object4 = object2 = object[0];
        object4 = (RelativeLayout)object2;
        object = object[1];
        TextView textView = object;
        textView = (TextView)object;
        super(dataBindingComponent, view, 0, (ImageView)object3, (RelativeLayout)object4, textView);
        this.e = -1;
        this.b.setTag(null);
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
            this.e = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 80;
        if (n11 == n10) {
            object = (z)object;
            this.z((z)object);
            n10 = 1;
        } else {
            n10 = 0;
        }
        return n10 != 0;
    }

    public void z(z z10) {
        this.d = z10;
    }
}

