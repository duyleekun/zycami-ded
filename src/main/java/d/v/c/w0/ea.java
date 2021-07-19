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
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.c.w0.da;
import d.v.e.l.m1;
import d.v.l.g.a;
import l.a.q.g0.u;

public class ea
extends da {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final ConstraintLayout e;
    private long f;

    public ea(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ea(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[3];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[1];
        object4 = (ImageView)object2;
        Object object5 = object2 = objectArray[2];
        object5 = (TextView)object2;
        super(object, view, 0, (ImageView)object3, (ImageView)object4, (TextView)object5);
        this.f = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.e = object;
        object.setTag(null);
        this.c.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        long l10;
        UploadCEMediaInfo uploadCEMediaInfo;
        Object object;
        int n10;
        Object object2;
        long l11;
        long l12;
        ea ea2 = this;
        synchronized (this) {
            l12 = this.f;
            this.f = l11 = 0L;
        }
        UploadCEMediaInfo uploadCEMediaInfo2 = this.d;
        long l13 = 3;
        long l14 = l12 & l13;
        long l15 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
        int n11 = 0;
        if (l15 != false) {
            MediaType mediaType;
            long l16;
            float f10;
            float f11;
            float f12;
            int n12;
            int n13;
            int n14;
            if (uploadCEMediaInfo2 != null) {
                object2 = uploadCEMediaInfo2.a();
                n14 = uploadCEMediaInfo2.b();
                n13 = uploadCEMediaInfo2.c();
                uploadCEMediaInfo2 = uploadCEMediaInfo2.d();
            } else {
                n10 = 0;
                uploadCEMediaInfo2 = null;
                n12 = 0;
                object2 = null;
                f12 = 0.0f;
                n14 = 0;
                f11 = 0.0f;
                n13 = 0;
                f10 = 0.0f;
            }
            if (l15 != false) {
                l16 = n13 != 0 ? (long)32 : (long)16;
                l12 |= l16;
            }
            if (object2 != null) {
                mediaType = ((d.v.h.e.a)object2).f();
            } else {
                l15 = 0;
                mediaType = null;
            }
            f12 = n14;
            n12 = Math.round(f12);
            n14 = 8;
            f11 = 1.1E-44f;
            if (n13 != 0) {
                n13 = 0;
                f10 = 0.0f;
            } else {
                n13 = n14;
                f10 = f11;
            }
            object = MediaType.VIDEO;
            if (mediaType == object) {
                l15 = 1;
            } else {
                l15 = 0;
                mediaType = null;
            }
            object2 = m1.D(n12);
            l16 = l12 & l13;
            long l17 = l16 == l11 ? 0 : (l16 < l11 ? -1 : 1);
            if (l17 != false) {
                l16 = l15 != false ? (long)8 : (long)4;
                l12 |= l16;
            }
            if (l15 == false) {
                n11 = n14;
            }
            uploadCEMediaInfo = uploadCEMediaInfo2;
            n10 = n11;
            n11 = n13;
        } else {
            boolean bl2 = false;
            object2 = null;
            float f13 = 0.0f;
            uploadCEMediaInfo = null;
            n10 = 0;
            uploadCEMediaInfo2 = null;
        }
        long l18 = (l10 = (l12 &= l13) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1);
        if (l18 != false) {
            ea2.a.setVisibility(n11);
            object = ea2.b;
            d.v.l.g.a.b(object, uploadCEMediaInfo, null, null, 0, false, false, null, null, null);
            TextView textView = ea2.c;
            textView.setVisibility(n10);
            uploadCEMediaInfo2 = ea2.c;
            u.n((TextView)uploadCEMediaInfo2, (String)object2, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.f;
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
            this.f = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 75;
        if (n11 == n10) {
            object = (UploadCEMediaInfo)object;
            this.z((UploadCEMediaInfo)object);
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
    public void z(UploadCEMediaInfo uploadCEMediaInfo) {
        this.d = uploadCEMediaInfo;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 1L;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(75);
        super.requestRebind();
    }
}

