/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import d.v.c.n1.h2$b;
import d.v.c.w0.h6;
import d.v.c.w0.i6$a;
import d.v.c.w0.i6$b;
import d.v.c.w0.i6$c;
import d.v.c.w0.i6$d;

public class i6
extends h6 {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final ConstraintLayout h;
    private i6$d i;
    private i6$a j;
    private i6$b k;
    private i6$c l;
    private long m;

    static {
        SparseIntArray sparseIntArray;
        o = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362467, 5);
    }

    public i6(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private i6(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[5];
        object3 = (FrameLayout)object2;
        Object object4 = object2 = objectArray[1];
        object4 = (ImageView)object2;
        Object object5 = object2 = objectArray[3];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[4];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[2];
        object7 = (TextView)object2;
        super(object, view, 0, (FrameLayout)object3, (ImageView)object4, (TextView)object5, (TextView)object6, (TextView)object7);
        this.m = -1;
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.h = object;
        object.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(h2$b h2$b) {
        this.g = h2$b;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 2;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(Boolean bl2) {
        this.f = bl2;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 1L;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(151);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        long l11;
        Object object;
        Object object2;
        float f10;
        int n10;
        long l12;
        int n11;
        long l13;
        long l14;
        i6 i62 = this;
        synchronized (this) {
            l14 = this.m;
            this.m = l13 = 0L;
        }
        Boolean bl2 = this.f;
        Object object3 = this.g;
        long l15 = 5;
        long l16 = l14 & l15;
        long l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
        int n12 = 0;
        float f11 = 0.0f;
        TextView textView = null;
        int n13 = 0;
        if (l17 != false) {
            int n14 = ViewDataBinding.safeUnbox(bl2);
            if (l17 != false) {
                if (n14 != 0) {
                    l14 = l14 | (long)64 | 0x400L;
                    l16 = 4096L;
                } else {
                    l14 = l14 | (long)32 | 0x200L;
                    l16 = 2048L;
                }
                l14 |= l16;
            }
            l17 = 2131099772;
            n12 = 2131099781;
            f11 = 1.7811925E38f;
            TextView textView2 = i62.e;
            n11 = n14 != 0 ? ViewDataBinding.getColorFromResource((View)textView2, (int)l17) : ViewDataBinding.getColorFromResource((View)textView2, n12);
            l12 = n14 ^ 1;
            if (n14 == 0) {
                n13 = 8;
            }
            n10 = 2131165546;
            int n15 = 2131165544;
            if (n14 != 0) {
                bl2 = i62.e.getResources();
                f10 = bl2.getDimension(n10);
            } else {
                bl2 = i62.e.getResources();
                f10 = bl2.getDimension(n15);
            }
            long l18 = l14 & l15;
            long l19 = l18 == l13 ? 0 : (l18 < l13 ? -1 : 1);
            if (l19 != false) {
                if (l12 != false) {
                    l14 |= (long)16;
                    l18 = 256L;
                } else {
                    l14 |= (long)8;
                    l18 = 128L;
                }
                l14 |= l18;
            }
            if (l12 != false) {
                textView = i62.c;
                l17 = ViewDataBinding.getColorFromResource((View)textView, (int)l17);
            } else {
                TextView textView3 = i62.c;
                l17 = ViewDataBinding.getColorFromResource((View)textView3, n12);
            }
            textView = i62.c.getResources();
            f11 = l12 != false ? textView.getDimension(n10) : textView.getDimension(n15);
            int n16 = n13;
            n13 = (int)l17;
            l17 = n16;
        } else {
            boolean bl3 = false;
            bl2 = null;
            f10 = 0.0f;
            l17 = 0;
            Object var27_25 = null;
            n11 = 0;
            Object var18_16 = null;
        }
        long l20 = (long)6 & l14;
        l12 = l20 == l13 ? 0 : (l20 < l13 ? -1 : 1);
        n10 = 0;
        Object object4 = null;
        if (l12 != false && object3 != null) {
            object4 = i62.i;
            if (object4 == null) {
                i62.i = object4 = new i6$d();
            }
            object4 = object4.b((h2$b)object3);
            i6$a i6$a = i62.j;
            if (i6$a == null) {
                i62.j = i6$a = new i6$a();
            }
            i6$a = i6$a.b((h2$b)object3);
            object2 = i62.k;
            if (object2 == null) {
                i62.k = object2 = new i6$b();
            }
            object2 = object2.b((h2$b)object3);
            object = i62.l;
            if (object == null) {
                i62.l = object = new i6$c();
            }
            object3 = object.b((h2$b)object3);
            object = object2;
            object2 = object4;
            object4 = i6$a;
        } else {
            object2 = null;
            object = null;
            object3 = null;
        }
        if (l12 != false) {
            i62.b.setOnClickListener((View.OnClickListener)object4);
            TextView textView4 = i62.c;
            textView4.setOnClickListener(object2);
            i62.d.setOnClickListener(object);
            object2 = i62.e;
            object2.setOnClickListener((View.OnClickListener)object3);
        }
        if ((l11 = (l10 = (l14 &= l15) - (l13 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            i62.c.setTextColor(n13);
            TextViewBindingAdapter.setTextSize(i62.c, f11);
            i62.d.setVisibility((int)l17);
            i62.e.setTextColor(n11);
            TextView textView5 = i62.e;
            TextViewBindingAdapter.setTextSize(textView5, f10);
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
        int n11 = 151;
        if (n11 == n10) {
            object = (Boolean)object;
            this.B((Boolean)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (h2$b)object;
            this.A((h2$b)object);
        }
        return 1 != 0;
    }
}

