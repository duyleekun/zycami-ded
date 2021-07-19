/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
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
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.c.w0.fa;
import d.v.e.l.m1;
import d.v.l.g.a;
import l.a.q.g0.u;

public class ga
extends fa {
    private static final ViewDataBinding$IncludedLayouts h;
    private static final SparseIntArray i;
    private final ConstraintLayout f;
    private long g;

    public ga(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = h;
        SparseIntArray sparseIntArray = i;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ga(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[2];
        object4 = (TextView)object2;
        super(object, view, 1, (ImageView)object3, (TextView)object4);
        this.g = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        this.b.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(ObservableInt observableInt, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.g;
                long l11 = 1L;
                this.g = l10 |= l11;
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
    public void B(ObservableInt observableInt) {
        this.updateRegistration(0, observableInt);
        this.d = observableInt;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 1L;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(32);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(UploadCEMediaInfo uploadCEMediaInfo) {
        this.e = uploadCEMediaInfo;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 2;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(75);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(Integer n10) {
        this.c = n10;
        synchronized (this) {
            long l10 = this.g;
            long l11 = 4;
            this.g = l10 |= l11;
        }
        this.notifyPropertyChanged(101);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        int n10;
        long l10;
        int n11;
        int n12;
        Object object;
        long l11;
        float f10;
        int n13;
        long l12;
        long l13;
        ga ga2 = this;
        synchronized (this) {
            l13 = this.g;
            this.g = l12 = 0L;
        }
        Object object2 = this.e;
        Integer n14 = this.c;
        ObservableInt observableInt = this.d;
        long l14 = 10;
        long l15 = l13 & l14;
        long l16 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1);
        int n15 = 1;
        float f11 = Float.MIN_VALUE;
        if (l16 != false) {
            MediaType mediaType;
            String string2;
            float f12;
            int n16;
            Object object3;
            if (object2 != null) {
                object3 = object2.a();
                int n17 = object2.b();
                n13 = object2.c();
                n16 = n17;
            } else {
                object3 = null;
                n13 = 0;
                f12 = 0.0f;
                object2 = null;
                n16 = 0;
                f10 = 0.0f;
                string2 = null;
            }
            if (l16 != false) {
                long l17 = n13 != 0 ? (long)32 : (long)16;
                l13 |= l17;
            }
            if (object3 != null) {
                mediaType = ((d.v.h.e.a)object3).f();
                object3 = ((d.v.h.e.a)object3).e();
            } else {
                l16 = 0;
                mediaType = null;
                object3 = null;
            }
            f10 = n16;
            n16 = Math.round(f10);
            if (n13 != 0) {
                n13 = 0;
                f12 = 0.0f;
                object2 = null;
            } else {
                n13 = 1065353216;
                f12 = 1.0f;
            }
            MediaType mediaType2 = MediaType.VIDEO;
            if (mediaType == mediaType2) {
                l16 = n15;
            } else {
                l16 = 0;
                mediaType = null;
            }
            string2 = m1.D(n16);
            long l18 = l13 & l14;
            l11 = l18 == l12 ? 0 : (l18 < l12 ? -1 : 1);
            if (l11 != false) {
                l18 = l16 != false ? 128L : (long)64;
                l13 |= l18;
            }
            if (l16 != false) {
                l16 = 0;
                mediaType = null;
            } else {
                l16 = 8;
            }
            object = object3;
            n16 = n13;
            f10 = f12;
            object2 = string2;
        } else {
            n13 = 0;
            object2 = null;
            float f13 = 0.0f;
            object = null;
            l16 = 0;
            Object var25_24 = null;
            boolean bl2 = false;
            f10 = 0.0f;
            Object var22_21 = null;
        }
        long l19 = (long)13 & l13;
        l11 = l19 == l12 ? 0 : (l19 < l12 ? -1 : 1);
        if (l11 != false) {
            n12 = ViewDataBinding.safeUnbox(n14);
            if (observableInt != null) {
                n11 = observableInt.get();
            } else {
                n11 = 0;
                observableInt = null;
            }
            int n18 = n11 == n12 ? n15 : 0;
            n12 = n18;
        } else {
            n12 = 0;
            n14 = null;
        }
        long l20 = l13 & l14;
        n11 = (int)(l20 == l12 ? 0 : (l20 < l12 ? -1 : 1));
        if (n11 != 0) {
            int n19;
            n11 = ViewDataBinding.getBuildSdkInt();
            if (n11 >= (n19 = 11)) {
                observableInt = ga2.a;
                observableInt.setAlpha(f10);
            }
            d.v.l.g.a.b(ga2.a, object, null, null, 0, false, false, null, null, null);
            ga2.b.setVisibility((int)l16);
            observableInt = ga2.b;
            u.n((TextView)observableInt, (String)object2, null, null);
        }
        if ((n13 = (int)((l10 = (l13 &= (l20 = (long)8)) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 && (n13 = ViewDataBinding.getBuildSdkInt()) >= (n10 = 21)) {
            object2 = ga2.f;
            object2.setClipToOutline(n15 != 0);
        }
        if (l11 != false) {
            object2 = ga2.f;
            object2.setSelected(n12 != 0);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.g;
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
            this.g = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (ObservableInt)object;
        return this.E((ObservableInt)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 75;
        if (n11 == n10) {
            object = (UploadCEMediaInfo)object;
            this.C((UploadCEMediaInfo)object);
            return 1 != 0;
        } else {
            n11 = 101;
            if (n11 == n10) {
                object = (Integer)object;
                this.D((Integer)object);
                return 1 != 0;
            } else {
                n11 = 32;
                if (n11 != n10) return 0 != 0;
                object = (ObservableInt)object;
                this.B((ObservableInt)object);
            }
        }
        return 1 != 0;
    }
}

