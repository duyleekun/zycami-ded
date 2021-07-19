/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.w0.ib;

public class jb
extends ib {
    private static final ViewDataBinding$IncludedLayouts f;
    private static final SparseIntArray g;
    private long e;

    static {
        SparseIntArray sparseIntArray;
        g = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362719, 1);
        sparseIntArray.put(2131363534, 2);
        sparseIntArray.put(2131362724, 3);
    }

    public jb(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = f;
        SparseIntArray sparseIntArray = g;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private jb(DataBindingComponent dataBindingComponent, View view, Object[] object) {
        Object object2;
        Object object3 = object2 = object[1];
        object3 = (ImageView)object2;
        Object object4 = object2 = object[3];
        object4 = (ImageView)object2;
        Object object5 = object2 = object[0];
        object5 = (ConstraintLayout)((Object)object2);
        object = object[2];
        TextView textView = object;
        textView = (TextView)object;
        super(dataBindingComponent, view, 0, (ImageView)object3, (ImageView)object4, (ConstraintLayout)((Object)object5), textView);
        this.e = -1;
        this.c.setTag(null);
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

