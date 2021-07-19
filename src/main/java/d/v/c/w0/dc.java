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
import com.zhiyun.cama.widget.RoundImageView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.r1.d;
import d.v.c.w0.cc;
import d.v.e.l.l2;
import d.v.l.g.a;
import l.a.q.g0.u;

public class dc
extends cc {
    private static final ViewDataBinding$IncludedLayouts f;
    private static final SparseIntArray g;
    private final ConstraintLayout c;
    private final ZYTextView d;
    private long e;

    public dc(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = f;
        SparseIntArray sparseIntArray = g;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private dc(DataBindingComponent object, View view, Object[] objectArray) {
        int n10 = 1;
        RoundImageView roundImageView = (RoundImageView)objectArray[n10];
        super(object, view, n10, roundImageView);
        this.e = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.c = object;
        object.setTag(null);
        object = (ZYTextView)objectArray[2];
        this.d = object;
        object.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean A(d d10, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.e;
                long l11 = 1L;
                this.e = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        String string2;
        Object object;
        int n10;
        long l10;
        synchronized (this) {
            long l11 = this.e;
            this.e = l10 = 0L;
        }
        Object object2 = this.b;
        long l12 = 3;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            if (object2 != null) {
                l10 = ((d)object2).s();
                object2 = ((d)object2).t();
            } else {
                object2 = null;
            }
            n10 = 2;
            float f10 = l2.a(l10, n10);
            object = new StringBuilder();
            ((StringBuilder)object).append(f10);
            ((StringBuilder)object).append("S");
            string2 = ((StringBuilder)object).toString();
        } else {
            string2 = null;
            float f11 = 0.0f;
            object2 = null;
        }
        if (l14 != false) {
            object = this.a;
            n10 = 0;
            boolean bl2 = true;
            d.v.l.g.a.b((ImageView)object, object2, null, null, 0, bl2, false, null, null, null);
            ZYTextView zYTextView = this.d;
            u.n(zYTextView, string2, null, null);
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
        if (n10 != 0) {
            return false;
        }
        object = (d)object;
        return this.A((d)object, n11);
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 124;
        if (n11 == n10) {
            object = (d)object;
            this.z((d)object);
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
    public void z(d d10) {
        this.updateRegistration(0, d10);
        this.b = d10;
        synchronized (this) {
            long l10 = this.e;
            long l11 = 1L;
            this.e = l10 |= l11;
        }
        this.notifyPropertyChanged(124);
        super.requestRebind();
    }
}

