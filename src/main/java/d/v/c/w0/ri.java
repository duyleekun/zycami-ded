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
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.camera.widget.HintLayout$a;
import com.zhiyun.cama.camera.widget.HintLayout$b;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.qi;

public class ri
extends qi
implements b$a {
    private static final ViewDataBinding$IncludedLayouts k;
    private static final SparseIntArray l;
    private final LinearLayout g;
    private final View.OnClickListener h;
    private final View.OnClickListener i;
    private long j;

    static {
        SparseIntArray sparseIntArray;
        l = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363608, 4);
    }

    public ri(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = k;
        SparseIntArray sparseIntArray = l;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ri(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[3];
        object4 = (ImageView)object3;
        int n10 = 1;
        Object object5 = object2 = objectArray[n10];
        object5 = (ImageView)object2;
        int n11 = 2;
        Object object6 = object2 = objectArray[n11];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[4];
        object7 = (TextView)object2;
        object2 = this;
        super(object, view, 0, (ImageView)object4, (ImageView)object5, (TextView)object6, (TextView)object7);
        this.j = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (LinearLayout)objectArray[0];
        this.g = object;
        object.setTag(null);
        this.c.setTag(null);
        this.setRootTag(view);
        object = new b(this, n11);
        this.h = object;
        object = new b(this, n10);
        this.i = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(HintLayout$a hintLayout$a) {
        this.e = hintLayout$a;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 1L;
            this.j = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(HintLayout$b hintLayout$b) {
        this.f = hintLayout$b;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 2;
            this.j = l10 |= l11;
        }
        this.notifyPropertyChanged(67);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                HintLayout$a hintLayout$a = this.e;
                HintLayout$b hintLayout$b = this.f;
                if (hintLayout$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    hintLayout$a.b(hintLayout$b, view);
                }
            }
        } else {
            HintLayout$a hintLayout$a = this.e;
            HintLayout$b hintLayout$b = this.f;
            if (hintLayout$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                hintLayout$a.a(hintLayout$b, view);
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
        long l11;
        long l12;
        long l13;
        int n10;
        long l14;
        long l15;
        synchronized (this) {
            l15 = this.j;
            this.j = l14 = 0L;
        }
        HintLayout$b hintLayout$b = this.f;
        long l16 = 6;
        long l17 = l15 & l16;
        long l18 = l17 == l14 ? 0 : (l17 < l14 ? -1 : 1);
        int n11 = 0;
        if (l18 != false) {
            if (hintLayout$b != null) {
                n10 = hintLayout$b.m();
            } else {
                n10 = 0;
                hintLayout$b = null;
            }
            if (l18 != false) {
                l13 = n10 != 0 ? (long)16 : (long)8;
                l15 |= l13;
            }
            if (n10 == 0) {
                n11 = n10 = 8;
            }
        }
        if ((n10 = (l12 = (l13 = (long)4 & l15) - l14) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0) {
            hintLayout$b = this.a;
            View.OnClickListener onClickListener = this.h;
            hintLayout$b.setOnClickListener(onClickListener);
            hintLayout$b = this.c;
            onClickListener = this.i;
            hintLayout$b.setOnClickListener(onClickListener);
        }
        if ((l11 = (l10 = (l15 &= l16) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            ImageView imageView = this.b;
            imageView.setVisibility(n11);
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
            this.j = l10 = (long)4;
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
            object = (HintLayout$a)object;
            this.A((HintLayout$a)object);
            return 1 != 0;
        } else {
            n11 = 67;
            if (n11 != n10) return 0 != 0;
            object = (HintLayout$b)object;
            this.B((HintLayout$b)object);
        }
        return 1 != 0;
    }
}

