/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
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
import d.v.c.f1.a.b$a;
import d.v.c.w0.f6;
import d.v.c.y1.d$a;

public class g6
extends f6
implements b$a {
    private static final ViewDataBinding$IncludedLayouts k;
    private static final SparseIntArray l;
    private final ConstraintLayout f;
    private final View.OnClickListener g;
    private final View.OnClickListener h;
    private final View.OnClickListener i;
    private long j;

    static {
        SparseIntArray sparseIntArray;
        l = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363505, 3);
        sparseIntArray.put(2131363553, 4);
    }

    public g6(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = k;
        SparseIntArray sparseIntArray = l;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private g6(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        int n10 = 1;
        Object object4 = object3 = objectArray[n10];
        object4 = (ImageView)object3;
        int n11 = 2;
        Object object5 = object2 = objectArray[n11];
        object5 = (ImageView)object2;
        int n12 = 3;
        Object object6 = object2 = objectArray[n12];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[4];
        object7 = (TextView)object2;
        object2 = this;
        super(object, view, 0, (ImageView)object4, (ImageView)object5, (TextView)object6, (TextView)object7);
        this.j = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.setRootTag(view);
        super(this, n11);
        this.g = object;
        super(this, n12);
        this.h = object;
        super(this, n10);
        this.i = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 == n13) {
                    d$a d$a = this.e;
                    if (d$a != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        d$a.c();
                    }
                }
            } else {
                d$a d$a = this.e;
                if (d$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    d$a.b();
                }
            }
        } else {
            d$a d$a = this.e;
            if (d$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                d$a.a();
            }
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
            long l11 = this.j;
            this.j = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            Object object = this.a;
            View.OnClickListener onClickListener = this.g;
            object.setOnClickListener(onClickListener);
            object = this.b;
            onClickListener = this.h;
            object.setOnClickListener(onClickListener);
            object = this.f;
            onClickListener = this.i;
            object.setOnClickListener(onClickListener);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.j;
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
            this.j = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (d$a)object;
            this.z((d$a)object);
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
    public void z(d$a d$a) {
        this.e = d$a;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 1L;
            this.j = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

