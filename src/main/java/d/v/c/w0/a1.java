/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.z0$a;
import d.v.c.w0.z0;

public class a1
extends z0
implements b$a {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final ConstraintLayout f;
    private final ImageButton g;
    private final View.OnClickListener h;
    private long i;

    static {
        SparseIntArray sparseIntArray;
        k = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363608, 2);
        sparseIntArray.put(2131363389, 3);
        sparseIntArray.put(2131363501, 4);
        sparseIntArray.put(2131362632, 5);
    }

    public a1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private a1(DataBindingComponent object, View object2, Object[] imageButton) {
        Object object3;
        Object object4 = object3 = imageButton[5];
        object4 = (ImageView)object3;
        Object object5 = object3 = imageButton[3];
        object5 = (TextView)object3;
        Object object6 = object3 = imageButton[4];
        object6 = (TextView)object3;
        Object object7 = object3 = imageButton[2];
        object7 = (TextView)object3;
        super(object, (View)object2, 0, (ImageView)object4, (TextView)object5, (TextView)object6, (TextView)object7);
        this.i = -1;
        object = (ConstraintLayout)((Object)imageButton[0]);
        this.f = object;
        object.setTag(null);
        int n10 = 1;
        this.g = imageButton = (ImageButton)imageButton[n10];
        imageButton.setTag(null);
        this.setRootTag((View)object2);
        super(this, n10);
        this.h = object2;
        this.invalidateAll();
    }

    public final void a(int n10, View view) {
        z0$a z0$a = this.e;
        boolean bl2 = z0$a != null;
        if (bl2) {
            z0$a.a();
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
            ImageButton imageButton = this.g;
            View.OnClickListener onClickListener = this.h;
            imageButton.setOnClickListener(onClickListener);
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
        int n11 = 23;
        if (n11 == n10) {
            object = (z0$a)object;
            this.z((z0$a)object);
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
    public void z(z0$a z0$a) {
        this.e = z0$a;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 1L;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

