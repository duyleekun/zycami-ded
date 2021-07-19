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
import com.zhiyun.cama.set.SetAboutFragment$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.q1.g0;
import d.v.c.w0.kg;
import d.v.c.w0.lg$a;
import d.v.c.w0.lg$b;
import d.v.c.w0.lg$c;
import d.v.c.w0.lg$d;
import d.v.c.w0.lg$e;

public class lg
extends kg
implements b$a {
    private static final ViewDataBinding$IncludedLayouts t;
    private static final SparseIntArray u;
    private final LinearLayout g;
    private final TextView h;
    private final TextView i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private final View.OnClickListener m;
    private lg$e n;
    private lg$a o;
    private lg$b p;
    private lg$c q;
    private lg$d r;
    private long s;

    static {
        SparseIntArray sparseIntArray;
        u = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363612, 7);
        sparseIntArray.put(2131363361, 8);
        sparseIntArray.put(2131363362, 9);
    }

    public lg(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = t;
        SparseIntArray sparseIntArray = u;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private lg(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        int n10 = 1;
        Object object3 = object2 = objectArray[n10];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[8];
        object4 = (TextView)object2;
        Object object5 = object2 = objectArray[9];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[7];
        object6 = (TextView)object2;
        super(object, view, 0, (ImageView)object3, (TextView)object4, (TextView)object5, (TextView)object6);
        this.s = -1;
        this.a.setTag(null);
        object = (LinearLayout)objectArray[0];
        this.g = object;
        object.setTag(null);
        object = (TextView)objectArray[2];
        this.h = object;
        object.setTag(null);
        object = (TextView)objectArray[3];
        this.i = object;
        object.setTag(null);
        object = (TextView)objectArray[4];
        this.j = object;
        object.setTag(null);
        object = (TextView)objectArray[5];
        this.k = object;
        object.setTag(null);
        object = (TextView)objectArray[6];
        this.l = object;
        object.setTag(null);
        this.setRootTag(view);
        object = new b(this, n10);
        this.m = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(SetAboutFragment$a setAboutFragment$a) {
        this.e = setAboutFragment$a;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 1L;
            this.s = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public void B(g0 g02) {
        this.f = g02;
    }

    public final void a(int n10, View view) {
        SetAboutFragment$a setAboutFragment$a = this.e;
        boolean bl2 = setAboutFragment$a != null;
        if (bl2) {
            setAboutFragment$a.a(view);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        ImageView imageView;
        lg$c lg$c;
        lg$b lg$b;
        lg$a lg$a;
        long l10;
        long l11;
        synchronized (this) {
            l11 = this.s;
            this.s = l10 = 0L;
        }
        Object object = this.e;
        long l12 = (long)5 & l11;
        long l13 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        Object object2 = null;
        if (l13 != false && object != null) {
            object2 = this.n;
            if (object2 == null) {
                object2 = new lg$e();
                this.n = object2;
            }
            object2 = ((lg$e)object2).b((SetAboutFragment$a)object);
            lg$a = this.o;
            if (lg$a == null) {
                this.o = lg$a = new lg$a();
            }
            lg$a = lg$a.b((SetAboutFragment$a)object);
            lg$b = this.p;
            if (lg$b == null) {
                this.p = lg$b = new lg$b();
            }
            lg$b = lg$b.b((SetAboutFragment$a)object);
            lg$c = this.q;
            if (lg$c == null) {
                this.q = lg$c = new lg$c();
            }
            lg$c = lg$c.b((SetAboutFragment$a)object);
            lg$d lg$d = this.r;
            if (lg$d == null) {
                this.r = lg$d = new lg$d();
            }
            object = lg$d.b((SetAboutFragment$a)object);
            lg$e lg$e = object2;
            object2 = object;
            object = lg$e;
        } else {
            object = null;
            lg$a = null;
            lg$b = null;
            lg$c = null;
        }
        long l14 = 4;
        long l15 = (l11 &= l14) - l10;
        long l16 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (l16 != false) {
            imageView = this.a;
            View.OnClickListener onClickListener = this.m;
            imageView.setOnClickListener(onClickListener);
        }
        if (l13 != false) {
            this.h.setOnClickListener((View.OnClickListener)object2);
            this.i.setOnClickListener(lg$c);
            this.j.setOnClickListener((View.OnClickListener)lg$a);
            this.k.setOnClickListener((View.OnClickListener)lg$b);
            imageView = this.l;
            imageView.setOnClickListener((View.OnClickListener)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.s;
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
            this.s = l10 = (long)4;
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
        int n11 = 23;
        if (n11 == n10) {
            object = (SetAboutFragment$a)object;
            this.A((SetAboutFragment$a)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (g0)object;
            this.B((g0)object);
        }
        return 1 != 0;
    }
}

