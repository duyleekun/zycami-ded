/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.b1$b;
import d.v.c.w0.p9;

public class q9
extends p9
implements b$a {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final ImageView d;
    private final View.OnClickListener e;
    private long f;

    static {
        SparseIntArray sparseIntArray;
        h = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362312, 2);
    }

    public q9(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private q9(DataBindingComponent dataBindingComponent, View object, Object[] imageView) {
        Object object2;
        Object object3 = object2 = imageView[2];
        object3 = (ProgressBar)object2;
        Object object4 = object2 = imageView[0];
        object4 = (ConstraintLayout)((Object)object2);
        super(dataBindingComponent, (View)object, 0, (ProgressBar)object3, (ConstraintLayout)((Object)object4));
        this.f = -1;
        int n10 = 1;
        this.d = imageView = (ImageView)imageView[n10];
        imageView.setTag(null);
        this.b.setTag(null);
        this.setRootTag((View)object);
        super(this, n10);
        this.e = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        b1$b b1$b = this.c;
        boolean bl2 = b1$b != null;
        if (bl2) {
            b1$b.a();
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
            ImageView imageView = this.d;
            View.OnClickListener onClickListener = this.e;
            imageView.setOnClickListener(onClickListener);
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
            object = (b1$b)object;
            this.z((b1$b)object);
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
    public void z(b1$b b1$b) {
        this.c = b1$b;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 1L;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

