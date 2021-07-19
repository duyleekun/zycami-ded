/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.a.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.account.R$color;
import d.v.a.d;
import d.v.a.g.s;
import d.v.a.i.b.e;
import l.a.q.g0.u;

public class t
extends s {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final LinearLayout e;
    private long f;

    public t(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private t(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[2];
        object2 = (TextView)object;
        Object object3 = object = objectArray[1];
        object3 = (TextView)object;
        super(dataBindingComponent, view, 0, (TextView)object2, (TextView)object3);
        this.f = -1;
        dataBindingComponent = (LinearLayout)objectArray[0];
        this.e = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(e e10) {
        this.c = e10;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 1L;
            this.f = l10 |= l11;
        }
        int n10 = d.v.a.d.s0;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(boolean bl2) {
        this.d = bl2;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 2;
            this.f = l10 |= l11;
        }
        bl2 = d.v.a.d.u0;
        this.notifyPropertyChanged((int)(bl2 ? 1 : 0));
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
        String string2;
        String string3;
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.f;
            this.f = l13 = 0L;
        }
        Object object = this.c;
        int n10 = this.d;
        long l15 = 5;
        long l16 = l14 & l15;
        long l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
        if (l17 != false && object != null) {
            string3 = ((e)object).a();
            string2 = ((e)object).b();
            object = ((e)object).c();
        } else {
            object = null;
            l17 = 0;
            string3 = null;
            string2 = null;
        }
        long l18 = 6;
        long l19 = l14 & l18;
        long l20 = l19 == l13 ? 0 : (l19 < l13 ? -1 : 1);
        int n11 = 0;
        if (l20 != false) {
            TextView textView;
            if (l20 != false) {
                if (n10 != 0) {
                    l14 |= (long)16;
                    l19 = 64;
                } else {
                    l14 |= (long)8;
                    l19 = 32;
                }
                l14 |= l19;
            }
            TextView textView2 = this.a;
            n11 = n10 != 0 ? R$color.com_color_white : R$color.com_color_account_gray;
            l20 = ViewDataBinding.getColorFromResource((View)textView2, n11);
            n11 = (int)l20;
            if (n10 != 0) {
                textView = this.b;
                l20 = R$color.com_color_white;
            } else {
                textView = this.b;
                l20 = R$color.com_color_account_gray;
            }
            n10 = ViewDataBinding.getColorFromResource((View)textView, (int)l20);
        } else {
            n10 = 0;
            Object var21_16 = null;
        }
        long l21 = (l12 = (l18 &= l14) - l13) == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (l21 != false) {
            this.a.setTextColor(n11);
            TextView textView = this.b;
            textView.setTextColor(n10);
        }
        if ((l11 = (l10 = (l14 &= l15) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            TextView textView = this.a;
            String string4 = "@string/country_add";
            u.n(textView, string4, string3, string2);
            textView = this.b;
            u.n(textView, (String)object, null, null);
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
        int n11 = d.v.a.d.s0;
        if (n11 == n10) {
            object = (e)object;
            this.A((e)object);
            return 1 != 0;
        } else {
            n11 = d.v.a.d.u0;
            if (n11 != n10) return 0 != 0;
            object = (Boolean)object;
            n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
            this.B(n10 != 0);
        }
        return 1 != 0;
    }
}

