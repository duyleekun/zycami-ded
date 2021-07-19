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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.f1.a.b$a;
import d.v.c.n0.a;
import d.v.c.s0.d7.z;
import d.v.c.w0.qd;
import d.v.n.j.b;
import l.a.q.g0.u;

public class rd
extends qd
implements b$a {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final LinearLayout e;
    private final ImageView f;
    private final TextView g;
    private final TextView h;
    private final TextView i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private long l;

    static {
        SparseIntArray sparseIntArray;
        n = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363694, 6);
    }

    public rd(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private rd(DataBindingComponent dataBindingComponent, View object, Object[] textView) {
        Object object2;
        Object object3 = object2 = textView[4];
        object3 = (ImageView)object2;
        Object object4 = object2 = textView[6];
        object4 = (View)object2;
        rd rd2 = this;
        DataBindingComponent dataBindingComponent2 = dataBindingComponent;
        super(dataBindingComponent, (View)object, 1, (ImageView)object3, (View)object4);
        this.l = -1;
        this.a.setTag(null);
        dataBindingComponent = (LinearLayout)textView[0];
        this.e = dataBindingComponent;
        dataBindingComponent.setTag(null);
        int n10 = 1;
        rd2 = (ImageView)textView[n10];
        this.f = rd2;
        rd2.setTag(null);
        int n11 = 2;
        dataBindingComponent2 = (TextView)textView[n11];
        this.g = dataBindingComponent2;
        dataBindingComponent2.setTag(null);
        dataBindingComponent2 = (TextView)textView[3];
        this.h = dataBindingComponent2;
        dataBindingComponent2.setTag(null);
        this.i = textView = (TextView)textView[5];
        textView.setTag(null);
        this.setRootTag((View)object);
        super(this, n11);
        this.j = object;
        super(this, n10);
        this.k = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 1L;
                this.l = l10 |= l11;
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
    public void A(CameraFragment$j cameraFragment$j) {
        this.c = cameraFragment$j;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 2;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(z z10) {
        this.d = z10;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 4;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(80);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 == n13) {
                CameraFragment$j cameraFragment$j = this.c;
                if (cameraFragment$j != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    cameraFragment$j.h();
                }
            }
        } else {
            z z10 = this.d;
            if (z10 != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                z10.z0();
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
            var1_1 = this.l;
            this.l = var3_2 = 0L;
        }
        var5_3 = this.d;
        var6_4 = (long)13 & var1_1;
        var8_5 = var6_4 == var3_2 ? 0 : (var6_4 < var3_2 ? -1 : 1);
        var9_6 = 0;
        if (var8_5 == false) ** GOTO lbl-1000
        var5_3 = var5_3 != null ? var5_3.p : null;
        this.updateLiveDataRegistration(0, (LiveData)var5_3);
        var5_3 = var5_3 != null ? (b)var5_3.getValue() : null;
        if (var5_3 != null) {
            var9_6 = var5_3.q();
            var10_7 = var5_3.k();
            var5_3 = var5_3.h();
        } else lbl-1000:
        // 2 sources

        {
            var5_3 = null;
            var10_7 = null;
        }
        var11_8 = 8;
        cfr_temp_0 = (var1_1 &= var11_8) - var3_2;
        var13_9 = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
        if (var13_9 != false) {
            var14_10 = this.a;
            var15_11 = this.k;
            var14_10.setOnClickListener(var15_11);
            var14_10 = this.i;
            var15_11 = this.j;
            var14_10.setOnClickListener(var15_11);
        }
        if (var8_5 != false) {
            d.v.c.n0.a.f(this.f, var9_6);
            u.n(this.g, var10_7, null, null);
            var14_10 = this.h;
            u.n((TextView)var14_10, (String)var5_3, null, null);
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
            this.l = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (CameraFragment$j)object;
            this.A((CameraFragment$j)object);
            return 1 != 0;
        } else {
            n11 = 80;
            if (n11 != n10) return 0 != 0;
            object = (z)object;
            this.B((z)object);
        }
        return 1 != 0;
    }
}

