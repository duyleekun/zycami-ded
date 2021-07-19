/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.main.home.MeasureTextView;
import d.v.c.f1.a.b$a;
import d.v.c.i1.s2.r$c;
import d.v.c.w0.r9;
import d.v.g.g.c1;
import l.a.q.g0.u;

public class s9
extends r9
implements b$a {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final ConstraintLayout f;
    private final View.OnClickListener g;
    private final View.OnClickListener h;
    private long i;

    public s9(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private s9(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[3];
        object4 = (ImageView)object3;
        int n10 = 1;
        Object object5 = object2 = objectArray[n10];
        object5 = (MeasureTextView)object2;
        int n11 = 2;
        Object object6 = object2 = objectArray[n11];
        object6 = (MeasureTextView)object2;
        object2 = this;
        super(object, view, 1, (ImageView)object4, (MeasureTextView)object5, (MeasureTextView)object6);
        this.i = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.setRootTag(view);
        super(this, n11);
        this.g = object;
        super(this, n10);
        this.h = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.i;
                long l11 = 1L;
                this.i = l10 |= l11;
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(r$c r$c) {
        this.e = r$c;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 4;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(c1 c12) {
        this.d = c12;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 2;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(63);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                r$c r$c = this.e;
                if (r$c != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    r$c.a();
                }
            }
        } else {
            r$c r$c = this.e;
            if (r$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                r$c.f();
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        synchronized (this) {
            var1_1 = this.i;
            this.i = var3_2 = 0L;
        }
        var5_3 = this.d;
        var6_4 = (long)11 & var1_1;
        var8_5 = var6_4 == var3_2 ? 0 : (var6_4 < var3_2 ? -1 : 1);
        if (var8_5 == false) ** GOTO lbl-1000
        var5_3 = var5_3 != null ? var5_3.r() : null;
        this.updateLiveDataRegistration(0, (LiveData)var5_3);
        if (var5_3 != null) {
            var5_3 = (String)var5_3.getValue();
        } else lbl-1000:
        // 2 sources

        {
            var5_3 = null;
        }
        var9_6 = 8;
        cfr_temp_0 = (var1_1 &= var9_6) - var3_2;
        var11_7 = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
        if (var11_7 != false) {
            var12_8 /* !! */  = this.a;
            var13_9 /* !! */  = this.g;
            var12_8 /* !! */ .setOnClickListener(var13_9 /* !! */ );
            var12_8 /* !! */  = this.c;
            var13_9 /* !! */  = this.h;
            var12_8 /* !! */ .setOnClickListener(var13_9 /* !! */ );
        }
        if (var8_5 != false) {
            var12_8 /* !! */  = this.b;
            var13_9 /* !! */  = "@string/new_firmware_found_with_version";
            u.n((TextView)var12_8 /* !! */ , (String)var13_9 /* !! */ , var5_3, null);
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
            this.i = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (LiveData)object;
        return this.C((LiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 63;
        if (n11 == n10) {
            object = (c1)object;
            this.B((c1)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 != n10) return 0 != 0;
            object = (r$c)object;
            this.A((r$c)object);
        }
        return 1 != 0;
    }
}

