/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.w0.ag;

public class bg
extends ag {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final ConstraintLayout f;
    private long g;

    static {
        SparseIntArray sparseIntArray;
        i = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362182, 1);
        sparseIntArray.put(2131362651, 2);
        sparseIntArray.put(2131363683, 3);
        sparseIntArray.put(2131362743, 4);
        sparseIntArray.put(2131362642, 5);
    }

    public bg(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private bg(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (ConstraintLayout)((Object)object2);
        Object object4 = object2 = objectArray[5];
        object4 = (ImageView)object2;
        Object object5 = object2 = objectArray[2];
        object5 = (ImageView)object2;
        Object object6 = object2 = objectArray[4];
        object6 = (ImageView)object2;
        Object object7 = object2 = objectArray[3];
        object7 = (View)object2;
        super(object, view, 0, (ConstraintLayout)((Object)object3), (ImageView)object4, (ImageView)object5, (ImageView)object6, (View)object7);
        this.g = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
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
            this.g = l10 = 0L;
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
            long l10 = this.g;
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
            this.g = l10 = 1L;
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

