/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.camera.ble.BleViewModel;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.f1$a;
import d.v.c.w0.l1;

public class m1
extends l1
implements b$a {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout k;
    private final View.OnClickListener l;
    private long m;

    static {
        SparseIntArray sparseIntArray;
        o = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362498, 2);
        sparseIntArray.put(2131363608, 3);
        sparseIntArray.put(2131363105, 4);
        sparseIntArray.put(2131363065, 5);
        sparseIntArray.put(2131363061, 6);
        sparseIntArray.put(2131363032, 7);
        sparseIntArray.put(2131362468, 8);
    }

    public m1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private m1(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[8];
        object2 = (FrameLayout)object;
        Object object3 = object = objectArray[2];
        object3 = (FrameLayout)object;
        int n10 = 1;
        Object object4 = object = objectArray[n10];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[7];
        object5 = (RadioButton)object;
        Object object6 = object = objectArray[6];
        object6 = (RadioButton)object;
        Object object7 = object = objectArray[5];
        object7 = (RadioButton)object;
        Object object8 = object = objectArray[4];
        object8 = (RadioGroup)object;
        Object object9 = object = objectArray[3];
        object9 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 0, (FrameLayout)object2, (FrameLayout)object3, (ImageView)object4, (RadioButton)object5, (RadioButton)object6, (RadioButton)object7, (RadioGroup)object8, (TextView)object9);
        this.m = -1;
        this.c.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.k = object;
        object.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.l = object;
        this.invalidateAll();
    }

    public void A(BleViewModel bleViewModel) {
        this.j = bleViewModel;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(f1$a f1$a) {
        this.i = f1$a;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 1L;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        f1$a f1$a = this.i;
        boolean bl2 = f1$a != null;
        if (bl2) {
            f1$a.a();
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
            long l11 = this.m;
            this.m = l10 = 0L;
        }
        long l12 = 4;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            ImageView imageView = this.c;
            View.OnClickListener onClickListener = this.l;
            imageView.setOnClickListener(onClickListener);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.m;
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
            this.m = l10 = (long)4;
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
            object = (f1$a)object;
            this.B((f1$a)object);
            return 1 != 0;
        } else {
            n11 = 12;
            if (n11 != n10) return 0 != 0;
            object = (BleViewModel)object;
            this.A((BleViewModel)object);
        }
        return 1 != 0;
    }
}

