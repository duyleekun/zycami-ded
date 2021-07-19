/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.f1.a.b$a;
import d.v.c.w0.b4;
import d.v.c.z0.i$b;

public class c4
extends b4
implements b$a {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final ConstraintLayout e;
    private final TextView f;
    private final View.OnClickListener g;
    private final View.OnClickListener h;
    private long i;

    static {
        SparseIntArray sparseIntArray;
        k = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362981, 3);
        sparseIntArray.put(2131363544, 4);
    }

    public c4(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private c4(DataBindingComponent object, View object2, Object[] textView) {
        Object object3;
        int n10 = 2;
        Object object4 = object3 = textView[n10];
        object4 = (TextView)object3;
        Object object5 = object3 = textView[3];
        object5 = (ProgressBar)object3;
        Object object6 = object3 = textView[4];
        object6 = (TextView)object3;
        super(object, (View)object2, 0, (TextView)object4, (ProgressBar)object5, (TextView)object6);
        this.i = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)textView[0]);
        this.e = object;
        object.setTag(null);
        int n11 = 1;
        this.f = textView = (TextView)textView[n11];
        textView.setTag(null);
        this.setRootTag((View)object2);
        super(this, n11);
        this.g = object2;
        super(this, n10);
        this.h = object;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                i$b i$b = this.d;
                if (i$b != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    i$b.b();
                }
            }
        } else {
            i$b i$b = this.d;
            if (i$b != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                i$b.a();
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
            long l11 = this.i;
            this.i = l10 = 0L;
        }
        long l12 = 2;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            TextView textView = this.a;
            View.OnClickListener onClickListener = this.h;
            textView.setOnClickListener(onClickListener);
            textView = this.f;
            onClickListener = this.g;
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
            long l10 = this.i;
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
            this.i = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (i$b)object;
            this.z((i$b)object);
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
    public void z(i$b i$b) {
        this.d = i$b;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 1L;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }
}

