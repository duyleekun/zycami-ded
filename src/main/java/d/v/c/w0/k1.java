/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.w0.j1;
import l.a.q.g0.u;

public class k1
extends j1 {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final FrameLayout e;
    private long f;

    public k1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private k1(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[2];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[1];
        object3 = (TextView)object;
        super(dataBindingComponent, view, 0, (ImageView)object2, (TextView)object3);
        this.f = -1;
        this.a.setTag(null);
        dataBindingComponent = (FrameLayout)objectArray[0];
        this.e = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(boolean bl2) {
        this.d = bl2;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 2;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(118);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        long l11;
        long l12;
        int n10;
        long l13;
        long l14;
        long l15;
        long l16;
        synchronized (this) {
            l16 = this.f;
            this.f = l15 = 0L;
        }
        String string2 = this.c;
        float f10 = 0.0f;
        int n11 = this.d;
        long l17 = 6;
        long l18 = l16 & l17;
        long l19 = l18 == l15 ? 0 : (l18 < l15 ? -1 : 1);
        if (l19 != false) {
            if (l19 != false) {
                l18 = n11 != 0 ? (long)16 : (long)8;
                l16 |= l18;
            }
            f10 = n11 != 0 ? 1.0f : 0.4f;
        }
        if ((n11 = (l14 = (l13 = l16 & l17) - l15) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != 0 && (n11 = ViewDataBinding.getBuildSdkInt()) >= (n10 = 11)) {
            ImageView imageView = this.a;
            imageView.setAlpha(f10);
        }
        if ((l12 = (l11 = (l16 &= (l10 = (long)5)) - l15) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            TextView textView = this.b;
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
            this.f = l10 = (long)4;
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
        int n11 = 96;
        if (n11 == n10) {
            object = (String)object;
            this.z((String)object);
            return 1 != 0;
        } else {
            n11 = 118;
            if (n11 != n10) return 0 != 0;
            object = (Boolean)object;
            n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
            this.A(n10 != 0);
        }
        return 1 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void z(String string2) {
        this.c = string2;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 1L;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(96);
        super.requestRebind();
    }
}

