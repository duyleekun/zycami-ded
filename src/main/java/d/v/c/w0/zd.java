/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.f1.a.b$a;
import d.v.c.s0.d7.z;
import d.v.c.w0.yd;
import d.v.n.j.b;
import l.a.q.g0.u;

public class zd
extends yd
implements b$a {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final LinearLayout g;
    private final LinearLayout h;
    private final TextView i;
    private final View.OnClickListener j;
    private final View.OnClickListener k;
    private long l;

    public zd(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private zd(DataBindingComponent dataBindingComponent, View object, Object[] textView) {
        Object object2;
        int n10 = 2;
        Object object3 = object2 = textView[n10];
        object3 = (TextView)object2;
        Object object4 = object2 = textView[3];
        object4 = (TextView)object2;
        Object object5 = object2 = textView[4];
        object5 = (TextView)object2;
        Object object6 = object2 = textView[5];
        object6 = (TextView)object2;
        zd zd2 = this;
        super(dataBindingComponent, (View)object, 1, (TextView)object3, (TextView)object4, (TextView)object5, (TextView)object6);
        this.l = -1;
        dataBindingComponent = (LinearLayout)textView[0];
        this.g = dataBindingComponent;
        dataBindingComponent.setTag(null);
        int n11 = 1;
        zd2 = (LinearLayout)textView[n11];
        this.h = zd2;
        zd2.setTag(null);
        this.i = textView = (TextView)textView[6];
        textView.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.setRootTag((View)object);
        super(this, n10);
        this.j = object;
        super(this, n11);
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
        this.e = cameraFragment$j;
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
        this.f = z10;
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
                CameraFragment$j cameraFragment$j = this.e;
                if (cameraFragment$j != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    cameraFragment$j.c();
                }
            }
        } else {
            CameraFragment$j cameraFragment$j = this.e;
            if (cameraFragment$j != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                cameraFragment$j.l();
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
        var5_3 = this.f;
        var6_4 = (long)13 & var1_1;
        var8_5 = var6_4 == var3_2 ? 0 : (var6_4 < var3_2 ? -1 : 1);
        if (var8_5 == false) ** GOTO lbl-1000
        var5_3 = var5_3 != null ? var5_3.p : null;
        var9_6 = null;
        this.updateLiveDataRegistration(0, (LiveData)var5_3);
        var5_3 = var5_3 != null ? (b)var5_3.getValue() : null;
        if (var5_3 != null) {
            var9_6 = var5_3.u();
            var10_7 = var5_3.v();
            var11_8 = var5_3.y();
            var5_3 = var5_3.t();
        } else lbl-1000:
        // 2 sources

        {
            var5_3 = null;
            var9_6 = null;
            var10_7 = null;
            var11_8 = null;
        }
        var12_9 = 8;
        cfr_temp_0 = (var1_1 &= var12_9) - var3_2;
        var14_10 = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
        if (var14_10 != false) {
            var15_11 = this.h;
            var16_12 = this.k;
            var15_11.setOnClickListener(var16_12);
            var15_11 = this.i;
            var16_12 = this.j;
            var15_11.setOnClickListener(var16_12);
        }
        if (var8_5 != false) {
            u.n(this.a, (String)var5_3, null, null);
            u.n(this.b, var11_8, null, null);
            u.n(this.c, var9_6, null, null);
            var15_11 = this.d;
            u.n((TextView)var15_11, var10_7, null, null);
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

