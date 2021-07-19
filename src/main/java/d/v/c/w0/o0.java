/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 */
package d.v.c.w0;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.w0$a;
import d.v.c.w0.n0;

public class o0
extends n0
implements b$a {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final View.OnClickListener e;
    private long f;

    public o0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 1, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private o0(DataBindingComponent object, View view, Object[] imageView) {
        imageView = (ImageView)imageView[0];
        super(object, view, 0, imageView);
        this.f = -1;
        this.a.setTag(null);
        this.setRootTag(view);
        object = new b(this, 1);
        this.e = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(w0$a w0$a) {
        this.d = w0$a;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 4;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(Drawable drawable2) {
        this.c = drawable2;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 1L;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(68);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(int n10) {
        this.b = n10;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 2;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(69);
        super.requestRebind();
    }

    public final void a(int n10, View object) {
        n10 = this.b;
        object = this.d;
        boolean bl2 = object != null;
        if (bl2) {
            ((w0$a)object).a(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        ImageView imageView;
        long l10;
        long l11;
        synchronized (this) {
            l11 = this.f;
            this.f = l10 = 0L;
        }
        Drawable drawable2 = this.c;
        long l12 = (long)9 & l11;
        long l13 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        long l14 = 8;
        long l15 = (l11 &= l14) - l10;
        long l16 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (l16 != false) {
            imageView = this.a;
            View.OnClickListener onClickListener = this.e;
            imageView.setOnClickListener(onClickListener);
        }
        if (l13 != false) {
            imageView = this.a;
            ImageViewBindingAdapter.setImageDrawable(imageView, drawable2);
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
            this.f = l10 = (long)8;
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
        int n11 = 68;
        if (n11 == n10) {
            object = (Drawable)object;
            this.C((Drawable)object);
            return 1 != 0;
        } else {
            n11 = 69;
            if (n11 == n10) {
                object = (Integer)object;
                n10 = (Integer)object;
                this.D(n10);
                return 1 != 0;
            } else {
                n11 = 23;
                if (n11 != n10) return 0 != 0;
                object = (w0$a)object;
                this.B((w0$a)object);
            }
        }
        return 1 != 0;
    }
}

