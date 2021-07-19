/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.camera.widget.StringScrollView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.y0$a;
import d.v.c.w0.r0;

public class s0
extends r0
implements b$a {
    private static final ViewDataBinding$IncludedLayouts p;
    private static final SparseIntArray q;
    private final ConstraintLayout m;
    private final View.OnClickListener n;
    private long o;

    static {
        SparseIntArray sparseIntArray;
        q = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363478, 2);
        sparseIntArray.put(2131363249, 3);
        sparseIntArray.put(2131362288, 4);
        sparseIntArray.put(2131363628, 5);
        sparseIntArray.put(2131363251, 6);
        sparseIntArray.put(2131362290, 7);
        sparseIntArray.put(2131363531, 8);
        sparseIntArray.put(2131362131, 9);
        sparseIntArray.put(2131362289, 10);
        sparseIntArray.put(2131362837, 11);
    }

    public s0(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = p;
        SparseIntArray sparseIntArray = q;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 12, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private s0(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[9];
        object2 = (CheckBox)object;
        Object object3 = object = objectArray[4];
        object3 = (View)object;
        Object object4 = object = objectArray[10];
        object4 = (View)object;
        Object object5 = object = objectArray[7];
        object5 = (View)object;
        Object object6 = object = objectArray[11];
        object6 = (LinearLayout)object;
        Object object7 = object = objectArray[3];
        object7 = (StringScrollView)object;
        Object object8 = object = objectArray[6];
        object8 = (StringScrollView)object;
        Object object9 = object = objectArray[2];
        object9 = (TextView)object;
        Object object10 = object = objectArray[8];
        object10 = (TextView)object;
        Object object11 = object = objectArray[5];
        object11 = (TextView)object;
        Object object12 = object = objectArray[1];
        object12 = (View)object;
        object = this;
        super(dataBindingComponent, view, 0, (CheckBox)object2, (View)object3, (View)object4, (View)object5, (LinearLayout)object6, (StringScrollView)object7, (StringScrollView)object8, (TextView)object9, (TextView)object10, (TextView)object11, (View)object12);
        this.o = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.m = object;
        object.setTag(null);
        this.k.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, 1);
        this.n = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        y0$a y0$a = this.l;
        boolean bl2 = y0$a != null;
        if (bl2) {
            y0$a.a();
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
            long l11 = this.o;
            this.o = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            View view = this.k;
            View.OnClickListener onClickListener = this.n;
            view.setOnClickListener(onClickListener);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.o;
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
            this.o = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (y0$a)object;
            this.z((y0$a)object);
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
    public void z(y0$a y0$a) {
        this.l = y0$a;
        synchronized (this) {
            long l10 = this.o;
            long l11 = 1L;
            this.o = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

