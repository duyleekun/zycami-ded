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
import d.v.c.w0.if;
import l.a.q.g0.u;

public class jf
extends if {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final ConstraintLayout i;
    private final View j;
    private long k;

    static {
        SparseIntArray sparseIntArray;
        m = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362609, 4);
        sparseIntArray.put(2131362678, 5);
        sparseIntArray.put(2131362670, 6);
    }

    public jf(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private jf(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[4];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[6];
        object4 = (ImageView)object2;
        Object object5 = object2 = objectArray[5];
        object5 = (ImageView)object2;
        Object object6 = object2 = objectArray[2];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[3];
        object7 = (TextView)object2;
        super(object, view, 0, (ImageView)object3, (ImageView)object4, (ImageView)object5, (TextView)object6, (TextView)object7);
        this.k = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.i = object;
        object.setTag(null);
        object = (View)objectArray[1];
        this.j = object;
        object.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(String string2) {
        this.f = string2;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 2;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(96);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(int n10) {
        this.h = n10;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 1L;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(String string2) {
        this.g = string2;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 4;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(140);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        TextView textView;
        View view;
        long l10;
        long l11;
        long l12;
        long l13;
        synchronized (this) {
            l13 = this.k;
            this.k = l12 = 0L;
        }
        int n10 = this.h;
        String string2 = this.f;
        String string3 = this.g;
        long l14 = 9;
        long l15 = l13 & l14;
        long l16 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1);
        int n11 = 0;
        if (l16 != false) {
            n10 = n10 == 0 ? 1 : 0;
            if (l16 != false) {
                l11 = n10 != 0 ? (long)32 : (long)16;
                l13 |= l11;
            }
            if (n10 != 0) {
                n11 = n10 = 4;
            }
        }
        n10 = (int)((l10 = ((long)10 & l13) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1));
        l11 = (long)12 & l13;
        l16 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        long l17 = (l13 &= l14) - l12;
        Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object != false) {
            view = this.j;
            view.setVisibility(n11);
        }
        object = 0;
        view = null;
        if (n10 != 0) {
            textView = this.d;
            u.n(textView, string2, null, null);
        }
        if (l16 != false) {
            textView = this.e;
            u.n(textView, string3, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.k;
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
            this.k = l10 = (long)8;
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
        int n11 = 101;
        if (n11 == n10) {
            object = (Integer)object;
            n10 = (Integer)object;
            this.B(n10);
            return 1 != 0;
        } else {
            n11 = 96;
            if (n11 == n10) {
                object = (String)object;
                this.A((String)object);
                return 1 != 0;
            } else {
                n11 = 140;
                if (n11 != n10) return 0 != 0;
                object = (String)object;
                this.C((String)object);
            }
        }
        return 1 != 0;
    }
}

