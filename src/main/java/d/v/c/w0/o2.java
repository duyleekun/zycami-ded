/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.cloud_engine.CEDirectPublishDialog$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.n2;

public class o2
extends n2
implements b$a {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final ConstraintLayout i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private long l;

    static {
        SparseIntArray sparseIntArray;
        n = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363319, 3);
        sparseIntArray.put(2131362913, 4);
        sparseIntArray.put(2131362163, 5);
        sparseIntArray.put(2131362554, 6);
        sparseIntArray.put(2131363651, 7);
    }

    public o2(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private o2(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        int n10 = 1;
        Object object2 = object = objectArray[n10];
        object2 = (TextView)object;
        Object object3 = object = objectArray[5];
        object3 = (CheckBox)object;
        int n11 = 2;
        Object object4 = object = objectArray[n11];
        object4 = (TextView)object;
        Object object5 = object = objectArray[6];
        object5 = (View)object;
        Object object6 = object = objectArray[4];
        object6 = (TextView)object;
        Object object7 = object = objectArray[3];
        object7 = (TextView)object;
        Object object8 = object = objectArray[7];
        object8 = (View)object;
        object = this;
        super(dataBindingComponent, view, 0, (TextView)object2, (CheckBox)object3, (TextView)object4, (View)object5, (TextView)object6, (TextView)object7, (View)object8);
        this.l = -1;
        this.a.setTag(null);
        this.c.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.i = object;
        object.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.j = object;
        object = new b(this, n11);
        this.k = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                CEDirectPublishDialog$a cEDirectPublishDialog$a = this.h;
                if (cEDirectPublishDialog$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    cEDirectPublishDialog$a.b();
                }
            }
        } else {
            CEDirectPublishDialog$a cEDirectPublishDialog$a = this.h;
            if (cEDirectPublishDialog$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                cEDirectPublishDialog$a.a();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        synchronized (this) {
            long l11 = this.l;
            this.l = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            TextView textView = this.a;
            View.OnClickListener onClickListener = this.j;
            textView.setOnClickListener(onClickListener);
            textView = this.c;
            onClickListener = this.k;
            textView.setOnClickListener(onClickListener);
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
            object = (CEDirectPublishDialog$a)object;
            this.z((CEDirectPublishDialog$a)object);
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
    public void z(CEDirectPublishDialog$a cEDirectPublishDialog$a) {
        this.h = cEDirectPublishDialog$a;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 1L;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

