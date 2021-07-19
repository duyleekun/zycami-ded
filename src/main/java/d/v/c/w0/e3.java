/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.os.Build;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.album.Album;
import com.zhiyun.cama.album.AlbumInfoDialog$a;
import com.zhiyun.cama.album.AlbumSection;
import d.v.c.f1.a.b$a;
import d.v.c.w0.d3;
import d.v.e.l.m1;
import l.a.q.g0.u;

public class e3
extends d3
implements b$a {
    private static final ViewDataBinding$IncludedLayouts o;
    private static final SparseIntArray p;
    private final ConstraintLayout l;
    private final View.OnClickListener m;
    private long n;

    static {
        SparseIntArray sparseIntArray;
        p = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363319, 6);
        sparseIntArray.put(2131362278, 7);
    }

    public e3(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = o;
        SparseIntArray sparseIntArray = p;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 8, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private e3(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[5];
        object4 = (TextView)object3;
        int n10 = 1;
        Object object5 = object2 = objectArray[n10];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[2];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[7];
        object7 = (View)object2;
        Object object8 = object2 = objectArray[3];
        object8 = (TextView)object2;
        Object object9 = object2 = objectArray[6];
        object9 = (TextView)object2;
        Object object10 = object2 = objectArray[4];
        object10 = (TextView)object2;
        object2 = this;
        super(object, view, 0, (TextView)object4, (TextView)object5, (TextView)object6, (View)object7, (TextView)object8, (TextView)object9, (TextView)object10);
        this.n = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.l = object;
        object.setTag(null);
        this.e.setTag(null);
        this.g.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.m = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(AlbumInfoDialog$a albumInfoDialog$a) {
        this.k = albumInfoDialog$a;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 8;
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
    public void D(String string2) {
        this.h = string2;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 4;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(60);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(Boolean bl2) {
        this.i = bl2;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 2;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(74);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(AlbumSection albumSection) {
        this.j = albumSection;
        synchronized (this) {
            long l10 = this.n;
            long l11 = 1L;
            this.n = l10 |= l11;
        }
        this.notifyPropertyChanged(116);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        AlbumInfoDialog$a albumInfoDialog$a = this.k;
        boolean bl2 = albumInfoDialog$a != null;
        if (bl2) {
            albumInfoDialog$a.a();
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
        String string2;
        long l13;
        int n10;
        long l14;
        int n11;
        boolean bl2;
        long l15;
        long l16;
        e3 e32 = this;
        synchronized (this) {
            l16 = this.n;
            this.n = l15 = 0L;
        }
        Object object = this.j;
        Boolean bl3 = this.i;
        String string3 = this.h;
        long l17 = 17;
        long l18 = l16 & l17;
        long l19 = l18 == l15 ? 0 : (l18 < l15 ? -1 : 1);
        int n12 = 0;
        if (l19 != false) {
            if (object != null) {
                object = ((AlbumSection)object).getAlbum();
            } else {
                bl2 = false;
                object = null;
            }
            if (object != null) {
                l19 = ((Album)object).width;
                n11 = ((Album)object).height;
                l14 = ((Album)object).addDate;
            } else {
                l14 = l15;
                l19 = 0;
                n11 = 0;
            }
            object = m1.l(l14, "yyyy-MM-dd HH:mm");
        } else {
            l19 = 0;
            n11 = 0;
            bl2 = false;
            object = null;
        }
        l14 = 18;
        long l20 = l16 & l14;
        Object object2 = l20 == l15 ? 0 : (l20 < l15 ? -1 : 1);
        if (object2 != false) {
            n10 = ViewDataBinding.safeUnbox(bl3);
            if (object2 != false) {
                l20 = n10 != 0 ? (long)64 : (long)32;
                l16 |= l20;
            }
            if (n10 == 0) {
                n12 = n10 = 8;
            }
        }
        n10 = (l13 = (l16 & (long)20) - l15) == 0L ? 0 : (l13 < 0L ? -1 : 1);
        l20 = l16 & (long)16;
        long l21 = l20 - l15;
        object2 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
        if (object2 != false) {
            TextView textView = e32.a;
            Object object3 = e32.m;
            textView.setOnClickListener(object3);
            textView = e32.c;
            object3 = "@string/info_device";
            string2 = Build.MODEL;
            u.n(textView, (String)object3, string2, null);
        }
        if ((l12 = (l11 = (l15 = l16 & l17) - (l17 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            u.n(e32.b, "@string/info_date", object, null);
            object = e32.e;
            string2 = "@string/info_size";
            Integer n13 = (int)l19;
            Integer n14 = n11;
            u.n((TextView)object, string2, n13, n14);
        }
        if (bl2 = (l10 = (l16 &= (long)18) - (l15 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object = e32.g;
            object.setVisibility(n12);
        }
        if (n10 != 0) {
            object = e32.g;
            u.n((TextView)object, string3, null, null);
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
            this.n = l10 = (long)16;
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
        int n11 = 116;
        if (n11 == n10) {
            object = (AlbumSection)object;
            this.F((AlbumSection)object);
            return 1 != 0;
        } else {
            n11 = 74;
            if (n11 == n10) {
                object = (Boolean)object;
                this.E((Boolean)object);
                return 1 != 0;
            } else {
                n11 = 60;
                if (n11 == n10) {
                    object = (String)object;
                    this.D((String)object);
                    return 1 != 0;
                } else {
                    n11 = 23;
                    if (n11 != n10) return 0 != 0;
                    object = (AlbumInfoDialog$a)object;
                    this.C((AlbumInfoDialog$a)object);
                }
            }
        }
        return 1 != 0;
    }
}

