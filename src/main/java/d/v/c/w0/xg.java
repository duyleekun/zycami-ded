/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.set.SetSupportFragment$a;
import d.v.c.w0.wg;
import d.v.c.w0.xg$a;
import d.v.c.w0.xg$b;
import d.v.c.w0.xg$c;
import d.v.c.w0.xg$d;
import d.v.e.l.w1;

public class xg
extends wg {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final LinearLayout d;
    private final LinearLayout e;
    private final LinearLayout f;
    private final LinearLayout g;
    private xg$d h;
    private xg$a i;
    private xg$b j;
    private xg$c k;
    private long l;

    static {
        SparseIntArray sparseIntArray;
        n = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363612, 5);
    }

    public xg(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private xg(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[5];
        object3 = (TextView)object;
        super(dataBindingComponent, view, 0, (ImageView)object2, (TextView)object3);
        this.l = -1;
        this.a.setTag(null);
        dataBindingComponent = (LinearLayout)objectArray[0];
        this.d = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (LinearLayout)objectArray[2];
        this.e = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (LinearLayout)objectArray[3];
        this.f = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (LinearLayout)objectArray[4];
        this.g = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        long l11;
        xg$b xg$b;
        xg$a xg$a;
        Object object;
        String string2;
        long l12;
        long l13;
        synchronized (this) {
            l13 = this.l;
            this.l = l12 = 0L;
        }
        Object object2 = this.c;
        long l14 = 2;
        long l15 = l13 & l14;
        long l16 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1);
        if (l16 != false && l16 != false) {
            string2 = "zh_CN".toLowerCase();
            l16 = (long)string2.equals(object = w1.a());
            l15 = l16 != false ? (long)8 : (long)4;
            l13 |= l15;
        }
        l15 = (long)3 & l13;
        l16 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1);
        object = null;
        if (l16 != false && object2 != null) {
            object = this.h;
            if (object == null) {
                this.h = object = new xg$d();
            }
            object = ((xg$d)object).b((SetSupportFragment$a)object2);
            xg$a = this.i;
            if (xg$a == null) {
                this.i = xg$a = new xg$a();
            }
            xg$a = xg$a.b((SetSupportFragment$a)object2);
            xg$b = this.j;
            if (xg$b == null) {
                this.j = xg$b = new xg$b();
            }
            xg$b = xg$b.b((SetSupportFragment$a)object2);
            xg$c xg$c = this.k;
            if (xg$c == null) {
                this.k = xg$c = new xg$c();
            }
            object2 = xg$c.b((SetSupportFragment$a)object2);
        } else {
            object2 = null;
            xg$a = null;
            xg$b = null;
        }
        if (l16 != false) {
            this.a.setOnClickListener((View.OnClickListener)object);
            this.e.setOnClickListener((View.OnClickListener)xg$a);
            this.f.setOnClickListener(xg$b);
            string2 = this.g;
            string2.setOnClickListener((View.OnClickListener)object2);
        }
        if ((l11 = (l10 = (l13 &= l14) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            String string3;
            LinearLayout linearLayout = this.g;
            String string4 = "zh_CN".toLowerCase();
            int n10 = string4.equals(string3 = w1.a());
            if (n10 != 0) {
                n10 = 0;
                string4 = null;
            } else {
                n10 = 8;
            }
            linearLayout.setVisibility(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.l;
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
            this.l = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (SetSupportFragment$a)object;
            this.z((SetSupportFragment$a)object);
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
    public void z(SetSupportFragment$a setSupportFragment$a) {
        this.c = setSupportFragment$a;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 1L;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

