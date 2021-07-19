/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.w0.ug;
import l.a.q.g0.u;

public class vg
extends ug {
    private static final ViewDataBinding$IncludedLayouts f;
    private static final SparseIntArray g;
    private final FrameLayout d;
    private long e;

    public vg(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = f;
        SparseIntArray sparseIntArray = g;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 2, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private vg(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        TextView textView = (TextView)objectArray[1];
        super(dataBindingComponent, view, 0, textView);
        this.e = -1;
        dataBindingComponent = (FrameLayout)objectArray[0];
        this.d = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.a.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(boolean bl2) {
        this.c = bl2;
        synchronized (this) {
            long l10 = this.e;
            long l11 = 1L;
            this.e = l10 |= l11;
        }
        this.notifyPropertyChanged(21);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(String string2) {
        this.b = string2;
        synchronized (this) {
            long l10 = this.e;
            long l11 = 2;
            this.e = l10 |= l11;
        }
        this.notifyPropertyChanged(119);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        TextView textView;
        long l10;
        long l11;
        synchronized (this) {
            l11 = this.e;
            this.e = l10 = 0L;
        }
        int n10 = 0;
        TextView textView2 = null;
        int n11 = this.c;
        String string2 = this.b;
        long l12 = 5;
        long l13 = l11 & l12;
        long l14 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
        if (l14 != false) {
            if (l14 != false) {
                l13 = n11 != 0 ? (long)16 : (long)8;
                l11 |= l13;
            }
            textView2 = this.a;
            n11 = n11 != 0 ? 2131099727 : 2131099739;
            n10 = ViewDataBinding.getColorFromResource((View)textView2, n11);
        }
        l13 = (long)6 & l11;
        n11 = (int)(l13 == l10 ? 0 : (l13 < l10 ? -1 : 1));
        long l15 = (l11 &= l12) - l10;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object != false) {
            textView = this.a;
            textView.setTextColor(n10);
        }
        if (n11 != 0) {
            textView = this.a;
            u.n(textView, string2, null, null);
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
            this.e = l10 = (long)4;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 21;
        if (n11 == n10) {
            object = (Boolean)object;
            n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
            this.A(n10 != 0);
            return 1 != 0;
        } else {
            n11 = 119;
            if (n11 != n10) return 0 != 0;
            object = (String)object;
            this.B((String)object);
        }
        return 1 != 0;
    }
}

