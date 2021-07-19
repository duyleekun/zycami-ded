/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged;
import com.zhiyun.cama.widget.BackEditText;
import d.v.c.f1.a.b$a;
import d.v.c.w0.h8;
import d.v.c.w0.i8$a;

public class i8
extends h8
implements b$a {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final ConstraintLayout e;
    private final View.OnClickListener f;
    private i8$a g;
    private long h;

    static {
        SparseIntArray sparseIntArray;
        j = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363677, 3);
    }

    public i8(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private i8(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        int n10 = 1;
        Object object3 = object2 = objectArray[n10];
        object3 = (BackEditText)object2;
        Object object4 = object2 = objectArray[2];
        object4 = (TextView)object2;
        Object object5 = object2 = objectArray[3];
        object5 = (View)object2;
        super(object, view, 0, (BackEditText)object3, (TextView)object4, (View)object5);
        this.h = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.e = object;
        object.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.f = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        d.v.c.x0.c.e.b$a b$a = this.d;
        boolean bl2 = b$a != null;
        if (bl2) {
            b$a.b();
        }
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
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.h;
            this.h = l13 = 0L;
        }
        Object object = this.d;
        long l15 = (long)3 & l14;
        long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
        if (l16 != false && object != null) {
            i8$a i8$a = this.g;
            if (i8$a == null) {
                this.g = i8$a = new i8$a();
            }
            object = i8$a.a((d.v.c.x0.c.e.b$a)object);
        } else {
            object = null;
        }
        if (l16 != false) {
            BackEditText backEditText = this.a;
            TextViewBindingAdapter.setTextWatcher((TextView)backEditText, null, null, (TextViewBindingAdapter$AfterTextChanged)object, null);
        }
        if ((l12 = (l11 = (l14 &= (l10 = (long)2)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            TextView textView = this.b;
            View.OnClickListener onClickListener = this.f;
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
        int n11 = 24;
        if (n11 == n10) {
            object = (d.v.c.x0.c.e.b$a)object;
            this.z((d.v.c.x0.c.e.b$a)object);
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
    public void z(d.v.c.x0.c.e.b$a b$a) {
        this.d = b$a;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 1L;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(24);
        super.requestRebind();
    }
}

