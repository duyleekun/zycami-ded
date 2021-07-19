/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import d.v.c.w0.kh;
import d.v.f.i.g;
import l.a.q.g0.u;

public class lh
extends kh {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final TextView i;
    private final ImageView j;
    private long k;

    static {
        SparseIntArray sparseIntArray;
        m = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362707, 5);
    }

    public lh(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private lh(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[0];
        object2 = (ConstraintLayout)((Object)object);
        Object object3 = object = objectArray[5];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[1];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[2];
        object5 = (ImageView)object;
        super(dataBindingComponent, view, 0, (ConstraintLayout)((Object)object2), (ImageView)object3, (ImageView)object4, (ImageView)object5);
        this.k = -1;
        this.a.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        dataBindingComponent = (TextView)objectArray[3];
        this.i = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (ImageView)objectArray[4];
        this.j = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(Integer n10) {
        this.e = n10;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 4;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(99);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(Integer n10) {
        this.h = n10;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 2;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(137);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(Integer n10) {
        this.g = n10;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 1L;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(139);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(Integer n10) {
        this.f = n10;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 8;
            this.k = l10 |= l11;
        }
        this.notifyPropertyChanged(145);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        ImageView imageView;
        boolean bl2;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        long l17;
        synchronized (this) {
            l17 = this.k;
            this.k = l16 = 0L;
        }
        int n10 = 0;
        Integer n11 = this.g;
        Integer n12 = this.h;
        Integer n13 = this.e;
        Integer n14 = this.f;
        long l18 = (long)17 & l17;
        long l19 = l18 == l16 ? 0 : (l18 < l16 ? -1 : 1);
        if (l19 != false) {
            int n15 = ViewDataBinding.safeUnbox(n11);
            Context context = this.getRoot().getContext();
            n11 = d.v.f.i.g.f(context, n15);
        } else {
            boolean bl3 = false;
            n11 = null;
        }
        long l20 = (long)18 & l17;
        long l21 = l20 == l16 ? 0 : (l20 < l16 ? -1 : 1);
        if (l21 != false) {
            n10 = ViewDataBinding.safeUnbox(n12);
        }
        if ((l15 = (l14 = (l13 = (long)20 & l17) - l16) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false) {
            int n16 = ViewDataBinding.safeUnbox(n13);
            Context context = this.getRoot().getContext();
            n13 = d.v.f.i.g.f(context, n16);
        } else {
            boolean bl4 = false;
            n13 = null;
        }
        l13 = (long)24 & l17;
        long l22 = l13 == l16 ? 0 : (l13 < l16 ? -1 : 1);
        if (l22 != false) {
            int n17 = ViewDataBinding.safeUnbox(n14);
            Context context = this.getRoot().getContext();
            n14 = d.v.f.i.g.f(context, n17);
        } else {
            boolean bl5 = false;
            n14 = null;
        }
        if (l15 != false) {
            n12 = this.c;
            ImageViewBindingAdapter.setImageDrawable((ImageView)n12, (Drawable)n13);
        }
        if ((l12 = (l11 = (l17 &= (l10 = (long)16)) - l16) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false && (l12 = (long)ViewDataBinding.getBuildSdkInt()) >= (bl2 = 21 != 0)) {
            imageView = this.c;
            bl2 = true;
            imageView.setClipToOutline(bl2);
            imageView = this.d;
            imageView.setClipToOutline(bl2);
        }
        if (l22 != false) {
            imageView = this.d;
            ImageViewBindingAdapter.setImageDrawable(imageView, (Drawable)n14);
        }
        if (l21 != false) {
            imageView = this.i;
            u.k((TextView)imageView, n10, null, null);
        }
        if (l19 != false) {
            imageView = this.j;
            ImageViewBindingAdapter.setImageDrawable(imageView, (Drawable)n11);
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
            this.k = l10 = (long)16;
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
        int n11 = 139;
        if (n11 == n10) {
            object = (Integer)object;
            this.E((Integer)object);
            return 1 != 0;
        } else {
            n11 = 137;
            if (n11 == n10) {
                object = (Integer)object;
                this.D((Integer)object);
                return 1 != 0;
            } else {
                n11 = 99;
                if (n11 == n10) {
                    object = (Integer)object;
                    this.C((Integer)object);
                    return 1 != 0;
                } else {
                    n11 = 145;
                    if (n11 != n10) return 0 != 0;
                    object = (Integer)object;
                    this.F((Integer)object);
                }
            }
        }
        return 1 != 0;
    }
}

