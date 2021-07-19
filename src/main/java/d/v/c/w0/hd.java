/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.watermark.WaterMarkBean$WaterMarkDataInfo;
import com.zhiyun.cama.widget.RoundImageView;
import d.v.c.f1.a.b$a;
import d.v.c.w0.gd;
import d.v.c.z1.e;
import d.v.l.g.a;

public class hd
extends gd
implements b$a {
    private static final ViewDataBinding$IncludedLayouts i;
    private static final SparseIntArray j;
    private final ConstraintLayout f;
    private final View.OnClickListener g;
    private long h;

    public hd(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = i;
        SparseIntArray sparseIntArray = j;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private hd(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        int n10 = 1;
        Object object3 = object2 = objectArray[n10];
        object3 = (RoundImageView)object2;
        Object object4 = object2 = objectArray[2];
        object4 = (View)object2;
        super(object, view, 1, (RoundImageView)object3, (View)object4);
        this.h = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.g = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.h;
                long l11 = 1L;
                this.h = l10 |= l11;
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
    public void B(Integer n10) {
        this.d = n10;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 2;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(e e10) {
        this.e = e10;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 8;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(WaterMarkBean$WaterMarkDataInfo waterMarkBean$WaterMarkDataInfo) {
        this.c = waterMarkBean$WaterMarkDataInfo;
        synchronized (this) {
            long l10 = this.h;
            long l11 = 4;
            this.h = l10 |= l11;
        }
        this.notifyPropertyChanged(157);
        super.requestRebind();
    }

    public final void a(int n10, View object) {
        Integer n11 = this.d;
        object = this.e;
        WaterMarkBean$WaterMarkDataInfo waterMarkBean$WaterMarkDataInfo = this.c;
        boolean bl2 = object != null;
        if (bl2) {
            n10 = n11;
            ((e)object).f(n10, waterMarkBean$WaterMarkDataInfo);
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
        long l14;
        long l15;
        long l16;
        long l17;
        hd hd2 = this;
        synchronized (this) {
            l17 = this.h;
            this.h = l16 = 0L;
        }
        Object object = this.d;
        WaterMarkBean$WaterMarkDataInfo waterMarkBean$WaterMarkDataInfo = this.c;
        Object object2 = this.e;
        long l18 = 27;
        long l19 = l17 & l18;
        long l20 = l19 == l16 ? 0 : (l19 < l16 ? -1 : 1);
        String string2 = null;
        int n10 = 0;
        if (l20 != false) {
            object2 = object2 != null ? ((e)object2).d() : null;
            hd2.updateLiveDataRegistration(0, (LiveData)object2);
            object2 = object2 != null ? (Integer)((LiveData)object2).getValue() : null;
            if (object == object2) {
                l15 = 1;
            } else {
                l15 = 0;
                object = null;
            }
            if (l20 != false) {
                l14 = l15 != false ? (long)64 : (long)32;
                l17 |= l14;
            }
            if (l15 == false) {
                l15 = 4;
                n10 = l15;
            }
        }
        if ((l15 = (l13 = (l14 = (long)20 & l17) - l16) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false && waterMarkBean$WaterMarkDataInfo != null) {
            string2 = waterMarkBean$WaterMarkDataInfo.getThumbnail();
        }
        if (l15 != false) {
            RoundImageView roundImageView = hd2.a;
            object = roundImageView.getContext();
            int n11 = 2131231217;
            Drawable drawable2 = AppCompatResources.getDrawable((Context)object, n11);
            boolean bl2 = true;
            d.v.l.g.a.b(roundImageView, string2, null, drawable2, 0, bl2, false, null, null, null);
        }
        if ((l15 = (l12 = (l11 = (long)16 & l17) - l16) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            object = hd2.f;
            waterMarkBean$WaterMarkDataInfo = hd2.g;
            object.setOnClickListener((View.OnClickListener)waterMarkBean$WaterMarkDataInfo);
        }
        if ((l15 = (l10 = (l17 &= l18) - l16) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            object = hd2.b;
            object.setVisibility(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.h;
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
            this.h = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (LiveData)object;
        return this.E((LiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 101;
        if (n11 == n10) {
            object = (Integer)object;
            this.B((Integer)object);
            return 1 != 0;
        } else {
            n11 = 157;
            if (n11 == n10) {
                object = (WaterMarkBean$WaterMarkDataInfo)object;
                this.D((WaterMarkBean$WaterMarkDataInfo)object);
                return 1 != 0;
            } else {
                n11 = 152;
                if (n11 != n10) return 0 != 0;
                object = (e)object;
                this.C((e)object);
            }
        }
        return 1 != 0;
    }
}

