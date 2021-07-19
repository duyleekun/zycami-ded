/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.device.active.ActivationPrepareFragment$c;
import d.v.c.f1.a.b$a;
import d.v.c.w0.n5;
import d.v.c.y0.a.p;

public class o5
extends n5
implements b$a {
    private static final ViewDataBinding$IncludedLayouts m;
    private static final SparseIntArray n;
    private final ConstraintLayout j;
    private final View.OnClickListener k;
    private long l;

    static {
        SparseIntArray sparseIntArray;
        n = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363353, 3);
        sparseIntArray.put(2131363345, 4);
        sparseIntArray.put(2131363454, 5);
        sparseIntArray.put(2131362038, 6);
        sparseIntArray.put(2131363532, 7);
    }

    public o5(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = m;
        SparseIntArray sparseIntArray = n;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private o5(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[6];
        object4 = (CheckBox)object3;
        int n10 = 1;
        Object object5 = object2 = objectArray[n10];
        object5 = (ImageView)object2;
        Object object6 = object2 = objectArray[4];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[3];
        object7 = (TextView)object2;
        Object object8 = object2 = objectArray[5];
        object8 = (TextView)object2;
        Object object9 = object2 = objectArray[7];
        object9 = (TextView)object2;
        Object object10 = object2 = objectArray[2];
        object10 = (TextView)object2;
        object2 = this;
        super(object, view, 2, (CheckBox)object4, (ImageView)object5, (TextView)object6, (TextView)object7, (TextView)object8, (TextView)object9, (TextView)object10);
        this.l = -1;
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.j = object;
        object.setTag(null);
        this.g.setTag(null);
        this.setRootTag(view);
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.l;
                long l11 = 2;
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
    public void A(ActivationPrepareFragment$c activationPrepareFragment$c) {
        this.h = activationPrepareFragment$c;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 4;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(p p10) {
        this.i = p10;
        synchronized (this) {
            long l10 = this.l;
            long l11 = 8;
            this.l = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        ActivationPrepareFragment$c activationPrepareFragment$c = this.h;
        boolean bl2 = activationPrepareFragment$c != null;
        if (bl2) {
            activationPrepareFragment$c.a();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        block14: {
            synchronized (this) {
                var1_1 = this.l;
                this.l = var3_2 = 0L;
            }
            var5_3 = this.i;
            var6_4 = (long)27 & var1_1;
            var8_5 /* !! */  = var6_4 == var3_2 ? 0 : (var6_4 < var3_2 ? -1 : 1);
            var9_6 = 26;
            var11_7 = 25;
            var13_8 = 0;
            var14_9 = null;
            if (var8_5 /* !! */  == false) break block14;
            var15_10 = var1_1 & var11_7;
            cfr_temp_0 = var15_10 - var3_2;
            var8_5 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var8_5 /* !! */  == false) ** GOTO lbl-1000
            if (var5_3 != null) {
                var17_11 = var5_3.d();
            } else {
                var8_5 /* !! */  = 0;
                var17_11 = null;
            }
            this.updateLiveDataRegistration(0, var17_11);
            if (var17_11 != null) {
                var17_11 = (Drawable)var17_11.getValue();
            } else lbl-1000:
            // 2 sources

            {
                var8_5 /* !! */  = 0;
                var17_11 = null;
            }
            var15_10 = var1_1 & var9_6;
            var18_12 = var15_10 == var3_2 ? 0 : (var15_10 < var3_2 ? -1 : 1);
            if (var18_12 != false) {
                if (var5_3 != null) {
                    var5_3 = var5_3.e();
                } else {
                    var19_13 = 0;
                    var5_3 = null;
                }
                var13_8 = 1;
                this.updateLiveDataRegistration(var13_8, (LiveData)var5_3);
                if (var5_3 != null) {
                    var14_9 = var5_3 = var5_3.getValue();
                    var14_9 = (Boolean)var5_3;
                }
                var13_8 = (int)ViewDataBinding.safeUnbox((Boolean)var14_9);
            }
            var14_9 = var17_11;
        }
        if ((var19_13 = (cfr_temp_1 = (var20_14 = var1_1 & var11_7) - var3_2) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var5_3 = this.b;
            ImageViewBindingAdapter.setImageDrawable((ImageView)var5_3, var14_9);
        }
        if ((var19_13 = (cfr_temp_2 = (var20_14 = var1_1 & var9_6) - var3_2) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var5_3 = this.g;
            var5_3.setEnabled((boolean)var13_8);
        }
        if ((var22_15 = (cfr_temp_3 = (var1_1 &= (var20_14 = (long)16)) - var3_2) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
            var23_16 = this.g;
            var24_17 = this.k;
            var23_16.setOnClickListener(var24_17);
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
            this.l = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (MutableLiveData)object;
            return this.D((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (ActivationPrepareFragment$c)object;
            this.A((ActivationPrepareFragment$c)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (p)object;
            this.B((p)object);
        }
        return 1 != 0;
    }
}

