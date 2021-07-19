/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageButton
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.viewpager.widget.ViewPager;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.a1$a;
import d.v.c.w0.t0;

public class u0
extends t0
implements b$a {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final ConstraintLayout d;
    private final View.OnClickListener e;
    private long f;

    static {
        SparseIntArray sparseIntArray;
        h = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363739, 2);
    }

    public u0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private u0(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        int n10 = 1;
        Object object3 = object2 = objectArray[n10];
        object3 = (ImageButton)object2;
        Object object4 = object2 = objectArray[2];
        object4 = (ViewPager)((Object)object2);
        super(object, view, 0, (ImageButton)object3, (ViewPager)((Object)object4));
        this.f = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.d = object;
        object.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.e = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        a1$a a1$a = this.c;
        boolean bl2 = a1$a != null;
        if (bl2) {
            a1$a.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        synchronized (this) {
            long l11 = this.f;
            this.f = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            ImageButton imageButton = this.a;
            View.OnClickListener onClickListener = this.e;
            imageButton.setOnClickListener(onClickListener);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.f;
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
            this.f = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (a1$a)object;
            this.z((a1$a)object);
            n10 = 1;
        } else {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void z(a1$a a1$a) {
        this.c = a1$a;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 1L;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

