/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.camera.live.LiveDialog$b;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.f5;

public class g5
extends f5
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
        sparseIntArray.put(2131363608, 3);
        sparseIntArray.put(2131362478, 4);
        sparseIntArray.put(2131362891, 5);
        sparseIntArray.put(2131362278, 6);
        sparseIntArray.put(2131363671, 7);
    }

    public g5(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private g5(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[6];
        object2 = (View)object;
        Object object3 = object = objectArray[4];
        object3 = (FrameLayout)object;
        Object object4 = object = objectArray[5];
        object4 = (TextView)object;
        int n10 = 1;
        Object object5 = object = objectArray[n10];
        object5 = (Button)object;
        int n11 = 2;
        Object object6 = object = objectArray[n11];
        object6 = (Button)object;
        Object object7 = object = objectArray[3];
        object7 = (TextView)object;
        Object object8 = object = objectArray[7];
        object8 = (View)object;
        object = this;
        super(dataBindingComponent, view, 0, (View)object2, (FrameLayout)object3, (TextView)object4, (Button)object5, (Button)object6, (TextView)object7, (View)object8);
        this.l = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.i = object;
        object.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n11);
        this.j = object;
        object = new b(this, n10);
        this.k = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                LiveDialog$b liveDialog$b = this.h;
                if (liveDialog$b != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    liveDialog$b.b();
                }
            }
        } else {
            LiveDialog$b liveDialog$b = this.h;
            if (liveDialog$b != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                liveDialog$b.a();
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
            Button button = this.d;
            View.OnClickListener onClickListener = this.k;
            button.setOnClickListener(onClickListener);
            button = this.e;
            onClickListener = this.j;
            button.setOnClickListener(onClickListener);
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
        int n11 = 25;
        if (n11 == n10) {
            object = (LiveDialog$b)object;
            this.z((LiveDialog$b)object);
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
    public void z(LiveDialog$b liveDialog$b) {
        this.h = liveDialog$b;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 1L;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

