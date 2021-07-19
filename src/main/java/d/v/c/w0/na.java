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
import d.v.c.w0.ma;
import d.v.c.y0.b.u.b;
import d.v.e.l.o1;
import l.a.q.g0.u;

public class na
extends ma {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final ConstraintLayout g;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363558, 4);
        sparseIntArray.put(2131362363, 5);
    }

    public na(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private na(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[5];
        object3 = (TextView)object2;
        Object object4 = object2 = objectArray[1];
        object4 = (ImageView)object2;
        Object object5 = object2 = objectArray[2];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[3];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[4];
        object7 = (TextView)object2;
        super(object, view, 0, (TextView)object3, (ImageView)object4, (TextView)object5, (TextView)object6, (TextView)object7);
        this.h = -1;
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.g = object;
        object.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        String string2;
        String string3;
        long l10;
        synchronized (this) {
            long l11 = this.h;
            this.h = l10 = 0L;
        }
        int n10 = 0;
        Drawable drawable2 = null;
        b b10 = this.f;
        long l12 = 3;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            if (b10 != null) {
                n10 = b10.b();
                string3 = b10.a();
                string2 = b10.c();
            } else {
                string3 = null;
                string2 = null;
            }
            b10 = this.getRoot().getContext();
            drawable2 = o1.m((Context)b10, n10);
        } else {
            string3 = null;
            string2 = null;
            n10 = 0;
            drawable2 = null;
        }
        if (l14 != false) {
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable2);
            u.n(this.c, string3, null, null);
            TextView textView = this.d;
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
            long l10 = this.h;
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
            this.h = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 75;
        if (n11 == n10) {
            object = (b)object;
            this.z((b)object);
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
    public void z(b b10) {
        this.f = b10;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 1L;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(75);
        super.requestRebind();
    }
}

