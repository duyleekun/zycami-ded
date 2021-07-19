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
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.album.Album;
import com.zhiyun.cama.album.AlbumSection;
import d.v.c.w0.ka;
import d.v.e.l.m1;
import d.v.l.g.a;
import l.a.q.g0.u;

public class la
extends ka {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final ConstraintLayout e;
    private long f;

    public la(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private la(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[1];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[2];
        object4 = (View)object2;
        Object object5 = object2 = objectArray[3];
        object5 = (TextView)object2;
        super(object, view, 1, (ImageView)object3, (View)object4, (TextView)object5);
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
    private boolean A(ObservableBoolean observableBoolean, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.f;
                long l11 = 1L;
                this.f = l10 |= l11;
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
    public void executeBindings() {
        int n10;
        long l10;
        long l11;
        long l12;
        long l13;
        String string2;
        String string3;
        ImageView imageView;
        int n11;
        int n12;
        long l14;
        long l15;
        la la2 = this;
        synchronized (this) {
            l15 = this.f;
            this.f = l14 = 0L;
        }
        Object object = this.d;
        long l16 = 7;
        long l17 = l15 & l16;
        long l18 = l17 == l14 ? 0 : (l17 < l14 ? -1 : 1);
        long l19 = 6;
        int n13 = 0;
        if (l18 != false) {
            long l20;
            String string4;
            boolean bl2;
            int n14;
            if (object != null) {
                object = object.getAlbum();
            } else {
                n12 = 0;
                object = null;
            }
            long l21 = l15 & l19;
            l18 = l21 == l14 ? 0 : (l21 < l14 ? -1 : 1);
            if (l18 != false) {
                float f10;
                if (object != null) {
                    n14 = ((Album)object).getDurationSec();
                    bl2 = ((Album)object).isVideo;
                    string4 = ((Album)object).path;
                } else {
                    n11 = 0;
                    string4 = null;
                    n14 = 0;
                    imageView = null;
                    f10 = 0.0f;
                    bl2 = false;
                    string3 = null;
                }
                if (l18 != false) {
                    l20 = bl2 ? (long)64 : (long)32;
                    l15 |= l20;
                }
                float f11 = n14;
                l18 = Math.round(f11);
                if (bl2) {
                    n14 = 0;
                    imageView = null;
                    f10 = 0.0f;
                } else {
                    n14 = 8;
                    f10 = 1.1E-44f;
                }
                string2 = m1.D((int)l18);
            } else {
                l18 = 0;
                string2 = null;
                float f12 = 0.0f;
                n11 = 0;
                string4 = null;
                n14 = 0;
                imageView = null;
                float f13 = 0.0f;
            }
            if (object != null) {
                object = ((Album)object).isChecked;
            } else {
                n12 = 0;
                object = null;
            }
            la2.updateRegistration(0, (Observable)object);
            if (object != null) {
                n12 = (int)(((ObservableBoolean)object).get() ? 1 : 0);
            } else {
                n12 = 0;
                object = null;
            }
            l20 = l15 & l16;
            bl2 = l20 == l14 ? 0 : (l20 < l14 ? -1 : 1);
            if (bl2) {
                l20 = n12 != 0 ? (long)16 : (long)8;
                l15 |= l20;
            }
            if (n12 == 0) {
                n13 = 8;
            }
            string3 = string4;
            n11 = n12;
            n12 = n13;
            n13 = n14;
        } else {
            l18 = 0;
            string2 = null;
            float f14 = 0.0f;
            boolean bl3 = false;
            string3 = null;
            n12 = 0;
            object = null;
            n11 = 0;
            Object var20_16 = null;
        }
        long l22 = (l13 = (l19 &= l15) - l14) == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l22 != false) {
            imageView = la2.a;
            d.v.l.g.a.b(imageView, string3, null, null, 0, false, false, null, null, null);
            la2.c.setVisibility(n13);
            TextView textView = la2.c;
            u.n(textView, string2, null, null);
        }
        if ((l12 = (l11 = (l16 &= l15) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            View view = la2.b;
            view.setVisibility(n12);
            object = la2.b;
            object.setSelected(n11 != 0);
        }
        if ((n12 = (int)((l10 = (l15 &= (l16 = (long)4)) - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 && (n12 = ViewDataBinding.getBuildSdkInt()) >= (n10 = 21)) {
            object = la2.e;
            n10 = 1;
            object.setClipToOutline(n10 != 0);
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
        if (n10 != 0) {
            return false;
        }
        object = (ObservableBoolean)object;
        return this.A((ObservableBoolean)object, n11);
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 75;
        if (n11 == n10) {
            object = (AlbumSection)object;
            this.z((AlbumSection)object);
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
    public void z(AlbumSection albumSection) {
        this.d = albumSection;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 2;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(75);
        super.requestRebind();
    }
}

