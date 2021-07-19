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
package d.v.a.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.account.R$id;
import com.zhiyun.account.set.privacy.PrivateBindFragment$a;
import d.v.a.c;
import d.v.a.d;
import d.v.a.g.a0;
import d.v.a.g.b0$a;
import d.v.a.g.b0$b;
import d.v.a.g.b0$c;

public class b0
extends a0 {
    private static final ViewDataBinding$IncludedLayouts l;
    private static final SparseIntArray m;
    private final LinearLayout d;
    private final TextView e;
    private final View f;
    private final TextView g;
    private b0$c h;
    private b0$a i;
    private b0$b j;
    private long k;

    static {
        SparseIntArray sparseIntArray;
        m = sparseIntArray = new SparseIntArray();
        int n10 = R$id.tv_title_center;
        sparseIntArray.put(n10, 5);
    }

    public b0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = l;
        SparseIntArray sparseIntArray = m;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private b0(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[5];
        object3 = (TextView)object;
        super(dataBindingComponent, view, 0, (ImageView)object2, (TextView)object3);
        this.k = -1;
        this.a.setTag(null);
        dataBindingComponent = (LinearLayout)objectArray[0];
        this.d = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (TextView)objectArray[2];
        this.e = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (View)objectArray[3];
        this.f = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (TextView)objectArray[4];
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
        b0$a b0$a;
        boolean bl2;
        long l12;
        long l13;
        synchronized (this) {
            l13 = this.k;
            this.k = l12 = 0L;
        }
        Object object = this.c;
        long l14 = 2;
        long l15 = l13 & l14;
        long l16 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1);
        int n10 = 0;
        if (l16 != false) {
            bl2 = d.v.a.c.a;
            if (l16 != false) {
                long l17 = bl2 ? (long)8 : (long)4;
                l13 |= l17;
            }
            if (!bl2) {
                l16 = 8;
                n10 = l16;
            }
        }
        long l18 = (long)3 & l13;
        l16 = l18 == l12 ? 0 : (l18 < l12 ? -1 : 1);
        bl2 = false;
        b0$c b0$c = null;
        if (l16 != false && object != null) {
            b0$c = this.h;
            if (b0$c == null) {
                this.h = b0$c = new b0$c();
            }
            b0$c = b0$c.b((PrivateBindFragment$a)object);
            b0$a = this.i;
            if (b0$a == null) {
                this.i = b0$a = new b0$a();
            }
            b0$a = b0$a.b((PrivateBindFragment$a)object);
            b0$b b0$b = this.j;
            if (b0$b == null) {
                this.j = b0$b = new b0$b();
            }
            object = b0$b.b((PrivateBindFragment$a)object);
        } else {
            object = null;
            b0$a = null;
        }
        if (l16 != false) {
            this.a.setOnClickListener((View.OnClickListener)b0$c);
            this.e.setOnClickListener((View.OnClickListener)b0$a);
            TextView textView = this.g;
            textView.setOnClickListener((View.OnClickListener)object);
        }
        if ((l11 = (l10 = (l13 &= l14) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            this.f.setVisibility(n10);
            TextView textView = this.g;
            textView.setVisibility(n10);
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
            this.k = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.a.d.x;
        if (n11 == n10) {
            object = (PrivateBindFragment$a)object;
            this.z((PrivateBindFragment$a)object);
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
    public void z(PrivateBindFragment$a privateBindFragment$a) {
        this.c = privateBindFragment$a;
        synchronized (this) {
            long l10 = this.k;
            long l11 = 1L;
            this.k = l10 |= l11;
        }
        int n10 = d.v.a.d.x;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }
}

