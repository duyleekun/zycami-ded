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
import d.v.c.w0.gf;

public class hf
extends gf {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final RelativeLayout g;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362901, 1);
        sparseIntArray.put(2131362900, 2);
        sparseIntArray.put(2131362899, 3);
        sparseIntArray.put(2131362278, 4);
        sparseIntArray.put(2131362898, 5);
        sparseIntArray.put(2131362897, 6);
    }

    public hf(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private hf(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[4];
        object2 = (View)object;
        Object object3 = object = objectArray[6];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[5];
        object4 = (TextView)object;
        Object object5 = object = objectArray[3];
        object5 = (TextView)object;
        Object object6 = object = objectArray[2];
        object6 = (TextView)object;
        Object object7 = object = objectArray[1];
        object7 = (TextView)object;
        super(dataBindingComponent, view, 0, (View)object2, (ImageView)object3, (TextView)object4, (TextView)object5, (TextView)object6, (TextView)object7);
        this.h = -1;
        dataBindingComponent = (RelativeLayout)objectArray[0];
        this.g = dataBindingComponent;
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
            this.h = l10 = 0L;
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
            long l10 = this.h;
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
            this.h = l10 = 1L;
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

