/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.a.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.account.R$id;
import com.zhiyun.account.me.account.widget.MeNameView$b;
import d.v.a.d;
import d.v.a.g.w;
import d.v.a.g.x$a;
import d.v.a.g.x$b;

public class x
extends w {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final LinearLayout e;
    private x$b f;
    private x$a g;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        int n10 = R$id.et_name;
        sparseIntArray.put(n10, 3);
    }

    public x(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private x(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[3];
        object2 = (EditText)object;
        Object object3 = object = objectArray[2];
        object3 = (ImageView)object;
        Object object4 = object = objectArray[1];
        object4 = (TextView)object;
        super(dataBindingComponent, view, 0, (EditText)object2, (ImageView)object3, (TextView)object4);
        this.h = -1;
        this.b.setTag(null);
        dataBindingComponent = (LinearLayout)objectArray[0];
        this.e = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.c.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        Object object;
        long l10;
        synchronized (this) {
            long l11 = this.h;
            this.h = l10 = 0L;
        }
        MeNameView$b meNameView$b = this.d;
        long l12 = 3;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        Object object2 = null;
        if (l14 != false && meNameView$b != null) {
            object2 = this.f;
            if (object2 == null) {
                this.f = object2 = new x$b();
            }
            object2 = object2.b(meNameView$b);
            object = this.g;
            if (object == null) {
                this.g = object = new x$a();
            }
            x$a x$a = object.b(meNameView$b);
            object = object2;
            object2 = x$a;
        } else {
            object = null;
        }
        if (l14 != false) {
            this.b.setOnClickListener((View.OnClickListener)object2);
            TextView textView = this.c;
            textView.setOnClickListener((View.OnClickListener)object);
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
        int n11 = d.v.a.d.x;
        if (n11 == n10) {
            object = (MeNameView$b)object;
            this.z((MeNameView$b)object);
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
    public void z(MeNameView$b meNameView$b) {
        this.d = meNameView$b;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 1L;
            this.h = l10 |= l11;
        }
        int n10 = d.v.a.d.x;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }
}

