/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.camera.widget.CheckedGroup;
import d.v.c.w0.f2;

public class g2
extends f2 {
    private static final ViewDataBinding$IncludedLayouts d;
    private static final SparseIntArray e;
    private final CardView b;
    private long c;

    static {
        SparseIntArray sparseIntArray;
        e = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362160, 1);
    }

    public g2(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = d;
        SparseIntArray sparseIntArray = e;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 2, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private g2(DataBindingComponent object, View view, Object[] objectArray) {
        CheckedGroup checkedGroup = (CheckedGroup)((Object)objectArray[1]);
        super(object, view, 0, checkedGroup);
        this.c = -1;
        object = (CardView)((Object)objectArray[0]);
        this.b = object;
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
            this.c = l10 = 0L;
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
            long l10 = this.c;
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
            this.c = l10 = 1L;
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

