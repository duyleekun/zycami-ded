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
import com.zhiyun.account.set.privacy.ChooseModifyPassFragment$a;
import d.v.a.d;
import d.v.a.g.g0;
import d.v.a.g.h0$a;
import d.v.a.g.h0$b;
import d.v.a.g.h0$c;

public class h0
extends g0 {
    private static final ViewDataBinding$IncludedLayouts k;
    private static final SparseIntArray l;
    private final LinearLayout d;
    private final TextView e;
    private final TextView f;
    private h0$c g;
    private h0$a h;
    private h0$b i;
    private long j;

    static {
        SparseIntArray sparseIntArray;
        l = sparseIntArray = new SparseIntArray();
        int n10 = R$id.tv_title_center;
        sparseIntArray.put(n10, 4);
    }

    public h0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = k;
        SparseIntArray sparseIntArray = l;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private h0(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[4];
        object3 = (TextView)object;
        super(dataBindingComponent, view, 0, (ImageView)object2, (TextView)object3);
        this.j = -1;
        this.a.setTag(null);
        dataBindingComponent = (LinearLayout)objectArray[0];
        this.d = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (TextView)objectArray[2];
        this.e = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (TextView)objectArray[3];
        this.f = dataBindingComponent;
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
        h0$b h0$b;
        Object object;
        long l10;
        synchronized (this) {
            long l11 = this.j;
            this.j = l10 = 0L;
        }
        ChooseModifyPassFragment$a chooseModifyPassFragment$a = this.c;
        long l12 = 3;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        Object object2 = null;
        if (l14 != false && chooseModifyPassFragment$a != null) {
            object2 = this.g;
            if (object2 == null) {
                this.g = object2 = new h0$c();
            }
            object2 = object2.b(chooseModifyPassFragment$a);
            object = this.h;
            if (object == null) {
                this.h = object = new h0$a();
            }
            object = object.b(chooseModifyPassFragment$a);
            h0$b = this.i;
            if (h0$b == null) {
                this.i = h0$b = new h0$b();
            }
            h0$b = h0$b.b(chooseModifyPassFragment$a);
            h0$a h0$a = object;
            object = object2;
            object2 = h0$a;
        } else {
            object = null;
            h0$b = null;
        }
        if (l14 != false) {
            this.a.setOnClickListener((View.OnClickListener)object2);
            this.e.setOnClickListener((View.OnClickListener)object);
            TextView textView = this.f;
            textView.setOnClickListener(h0$b);
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
        int n11 = d.v.a.d.x;
        if (n11 == n10) {
            object = (ChooseModifyPassFragment$a)object;
            this.z((ChooseModifyPassFragment$a)object);
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
    public void z(ChooseModifyPassFragment$a chooseModifyPassFragment$a) {
        this.c = chooseModifyPassFragment$a;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 1L;
            this.j = l10 |= l11;
        }
        int n10 = d.v.a.d.x;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }
}

