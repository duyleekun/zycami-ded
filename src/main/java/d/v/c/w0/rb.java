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
import com.zhiyun.cama.widget.ZYTextView;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.c.k1.a.w;
import d.v.c.w0.qb;
import d.v.e.l.l2;
import d.v.h.e.a;
import l.a.q.g0.u;

public class rb
extends qb {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final ConstraintLayout d;
    private final ZYTextView e;
    private long f;

    static {
        SparseIntArray sparseIntArray;
        h = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362769, 2);
    }

    public rb(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private rb(DataBindingComponent object, View view, Object[] objectArray) {
        ImageView imageView = (ImageView)objectArray[2];
        super(object, view, 0, imageView);
        this.f = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.d = object;
        object.setTag(null);
        object = (ZYTextView)objectArray[1];
        this.e = object;
        object.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(a a10) {
        this.b = a10;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 1L;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(83);
        super.requestRebind();
    }

    public void B(w w10) {
        this.c = w10;
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
        long l12;
        boolean bl2;
        boolean bl3;
        MediaType mediaType;
        long l13;
        long l14;
        rb rb2 = this;
        synchronized (this) {
            l14 = this.f;
            this.f = l13 = 0L;
        }
        Object object2 = this.b;
        long l15 = 5;
        long l16 = l14 & l15;
        long l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
        long l18 = 64;
        long l19 = 32;
        if (l17 != false) {
            long l20;
            long l21;
            boolean bl4;
            if (object2 != null) {
                MediaType mediaType2;
                mediaType = mediaType2 = ((a)object2).f();
            } else {
                bl3 = false;
                mediaType = null;
            }
            MediaType mediaType3 = MediaType.VIDEO;
            if (mediaType == mediaType3) {
                bl2 = true;
            } else {
                bl2 = false;
                mediaType3 = null;
            }
            MediaType mediaType4 = MediaType.IMAGE;
            if (mediaType == mediaType4) {
                bl4 = true;
            } else {
                bl4 = false;
                mediaType4 = null;
            }
            if (l17 != false) {
                l14 = bl2 ? (l14 |= l18) : (l14 |= l19);
            }
            if ((l17 = (l21 = (l20 = l14 & l15) - l13) == 0L ? 0 : (l21 < 0L ? -1 : 1)) != false) {
                l20 = bl4 ? (long)16 : (long)8;
                l14 |= l20;
            }
            l17 = bl4 ? (long)8 : (long)0;
        } else {
            l17 = 0;
            bl3 = false;
            mediaType = null;
            bl2 = false;
            Object var19_14 = null;
        }
        long l22 = (l12 = (l19 &= l14) - l13) == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (l22 != false) {
            MediaType mediaType5 = MediaType.GIF;
            if (mediaType == mediaType5) {
                bl3 = true;
            } else {
                bl3 = false;
                mediaType = null;
            }
            if (l22 != false) {
                l19 = bl3 ? 256L : 128L;
                l14 |= l19;
            }
            object = bl3 ? "Gif" : "";
        } else {
            l22 = 0;
            object = null;
        }
        long l23 = (l11 = (l18 &= l14) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1);
        if (l23 != false) {
            l18 = object2 != null ? ((a)object2).d() : l13;
            object2 = l2.d(l18);
        } else {
            object2 = null;
        }
        long l24 = (l10 = (l14 &= l15) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1);
        if (l24 != false) {
            if (bl2) {
                object = object2;
            }
        } else {
            l22 = 0;
            object = null;
        }
        if (l24 != false) {
            rb2.e.setVisibility((int)l17);
            object2 = rb2.e;
            l24 = 0;
            u.n((TextView)object2, (String)object, null, null);
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
            this.f = l10 = (long)4;
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
        int n11 = 83;
        if (n11 == n10) {
            object = (a)object;
            this.A((a)object);
            return 1 != 0;
        } else {
            n11 = 86;
            if (n11 != n10) return 0 != 0;
            object = (w)object;
            this.B((w)object);
        }
        return 1 != 0;
    }
}

