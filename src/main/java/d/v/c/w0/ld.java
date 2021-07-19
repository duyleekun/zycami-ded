/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.d7.z;
import d.v.c.w0.kd;
import l.a.q.g0.u;

public class ld
extends kd
implements b$a {
    private static final ViewDataBinding$IncludedLayouts o;
    private static final SparseIntArray p;
    private final RelativeLayout h;
    private final RelativeLayout i;
    private final TextView j;
    private final View.OnClickListener k;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private long n;

    static {
        SparseIntArray sparseIntArray;
        p = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362374, 5);
        sparseIntArray.put(2131362775, 6);
        sparseIntArray.put(2131363694, 7);
    }

    public ld(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = o;
        SparseIntArray sparseIntArray = p;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ld(DataBindingComponent object, View object2, Object[] textView) {
        Object object3;
        Object object4;
        Object object5 = object4 = textView[5];
        object5 = (EditText)object4;
        int n10 = 1;
        Object object6 = object3 = textView[n10];
        object6 = (EditText)object3;
        int n11 = 3;
        Object object7 = object3 = textView[n11];
        object7 = (ImageView)object3;
        Object object8 = object3 = textView[6];
        object8 = (ImageView)object3;
        Object object9 = object3 = textView[7];
        object9 = (View)object3;
        object3 = this;
        DataBindingComponent dataBindingComponent = object;
        super(object, (View)object2, 1, (EditText)object5, (EditText)object6, (ImageView)object7, (ImageView)object8, (View)object9);
        this.n = -1;
        this.b.setTag(null);
        this.c.setTag(null);
        object = (RelativeLayout)textView[0];
        this.h = object;
        object.setTag(null);
        int n12 = 2;
        dataBindingComponent = (RelativeLayout)textView[n12];
        this.i = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.j = textView = (TextView)textView[4];
        textView.setTag(null);
        this.setRootTag((View)object2);
        super(this, n12);
        this.k = object2;
        object = new b(this, n11);
        this.l = object;
        object = new b(this, n10);
        this.m = object;
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
                long l10 = this.n;
                long l11 = 1L;
                this.n = l10 |= l11;
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
        this.f = cameraFragment$j;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 2;
            this.n = l10 |= l11;
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
        this.g = z10;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 4;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(80);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 == n13) {
                    CameraFragment$j cameraFragment$j = this.f;
                    if (cameraFragment$j != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        cameraFragment$j.o0();
                    }
                }
            } else {
                z z10 = this.g;
                if (z10 != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    z10.z0();
                }
            }
        } else {
            CameraFragment$j cameraFragment$j = this.f;
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
            var1_1 = this.n;
            this.n = var3_2 = 0L;
        }
        var5_3 = this.g;
        var6_4 = (long)13 & var1_1;
        var8_5 = var6_4 == var3_2 ? 0 : (var6_4 < var3_2 ? -1 : 1);
        if (var8_5 == false) ** GOTO lbl-1000
        var5_3 = var5_3 != null ? var5_3.I() : null;
        this.updateLiveDataRegistration(0, (LiveData)var5_3);
        if (var5_3 != null) {
            var5_3 = (String)var5_3.getValue();
        } else lbl-1000:
        // 2 sources

        {
            var5_3 = null;
        }
        if (var8_5 != false) {
            var9_6 = this.b;
            u.n((TextView)var9_6, (String)var5_3, null, null);
        }
        if ((var12_8 = (cfr_temp_0 = (var1_1 &= (var10_7 = (long)8)) - var3_2) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) != false) {
            var13_9 = this.c;
            var14_10 = this.k;
            var13_9.setOnClickListener(var14_10);
            var13_9 = this.i;
            var14_10 = this.m;
            var13_9.setOnClickListener(var14_10);
            var13_9 = this.j;
            var14_10 = this.l;
            var13_9.setOnClickListener(var14_10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.n;
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
            this.n = l10 = (long)8;
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

