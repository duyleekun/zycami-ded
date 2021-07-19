/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.cloud_engine.CECompositeFinishFragment$b;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.l2;
import d.v.l.g.a;

public class m2
extends l2
implements b$a {
    private static final ViewDataBinding$IncludedLayouts t;
    private static final SparseIntArray u;
    private final ConstraintLayout l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private long s;

    static {
        SparseIntArray sparseIntArray;
        u = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363009, 8);
        sparseIntArray.put(2131363295, 9);
    }

    public m2(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = t;
        SparseIntArray sparseIntArray = u;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private m2(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[1];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[5];
        object3 = (ImageView)object;
        int n10 = 6;
        Object object4 = object = objectArray[n10];
        object4 = (TextView)object;
        int n11 = 4;
        Object object5 = object = objectArray[n11];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[8];
        object6 = (ProgressBar)object;
        int n12 = 2;
        Object object7 = object = objectArray[n12];
        object7 = (TextView)object;
        Object object8 = object = objectArray[7];
        object8 = (TextView)object;
        Object object9 = object = objectArray[9];
        object9 = (TextView)object;
        int n13 = 3;
        Object object10 = object = objectArray[n13];
        object10 = (ExoVideoView)object;
        object = this;
        super(dataBindingComponent, view, 0, (ImageView)object2, (ImageView)object3, (TextView)object4, (ImageView)object5, (ProgressBar)object6, (TextView)object7, (TextView)object8, (TextView)object9, (ExoVideoView)object10);
        this.s = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.l = object;
        object.setTag(null);
        this.d.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.i.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.m = object;
        object = new b(this, n11);
        this.n = object;
        object = new b(this, 5);
        this.o = object;
        object = new b(this, 2);
        this.p = object;
        object = new b(this, 3);
        this.q = object;
        object = new b(this, 1);
        this.r = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void A(CECompositeFinishFragment$b cECompositeFinishFragment$b) {
        this.k = cECompositeFinishFragment$b;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 2;
            this.s = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(String string2) {
        this.j = string2;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 1L;
            this.s = l10 |= l11;
        }
        this.notifyPropertyChanged(30);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        boolean bl2 = true;
        switch (n10) {
            default: {
                break;
            }
            case 6: {
                CECompositeFinishFragment$b cECompositeFinishFragment$b = this.k;
                if (cECompositeFinishFragment$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cECompositeFinishFragment$b.j();
                break;
            }
            case 5: {
                CECompositeFinishFragment$b cECompositeFinishFragment$b = this.k;
                if (cECompositeFinishFragment$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cECompositeFinishFragment$b.b();
                break;
            }
            case 4: {
                CECompositeFinishFragment$b cECompositeFinishFragment$b = this.k;
                if (cECompositeFinishFragment$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cECompositeFinishFragment$b.i();
                break;
            }
            case 3: {
                CECompositeFinishFragment$b cECompositeFinishFragment$b = this.k;
                if (cECompositeFinishFragment$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cECompositeFinishFragment$b.h();
                break;
            }
            case 2: {
                CECompositeFinishFragment$b cECompositeFinishFragment$b = this.k;
                if (cECompositeFinishFragment$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cECompositeFinishFragment$b.g();
                break;
            }
            case 1: {
                CECompositeFinishFragment$b cECompositeFinishFragment$b = this.k;
                if (cECompositeFinishFragment$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cECompositeFinishFragment$b.a();
            }
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
        synchronized (this) {
            l11 = this.s;
            this.s = l10 = 0L;
        }
        String string2 = this.j;
        long l12 = ((long)5 & l11) - l10;
        long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        long l14 = 4;
        long l15 = (l11 &= l14) - l10;
        long l16 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (l16 != false) {
            Object object = this.a;
            View.OnClickListener onClickListener = this.r;
            object.setOnClickListener(onClickListener);
            object = this.c;
            onClickListener = this.o;
            object.setOnClickListener(onClickListener);
            object = this.d;
            onClickListener = this.n;
            object.setOnClickListener(onClickListener);
            object = this.f;
            onClickListener = this.p;
            object.setOnClickListener(onClickListener);
            object = this.g;
            onClickListener = this.m;
            object.setOnClickListener(onClickListener);
            object = this.i;
            onClickListener = this.q;
            object.setOnClickListener(onClickListener);
        }
        if (l13 != false) {
            ImageView imageView = this.b;
            d.v.l.g.a.b(imageView, string2, null, null, 0, false, false, null, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.s;
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
            this.s = l10 = (long)4;
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
        int n11 = 30;
        if (n11 == n10) {
            object = (String)object;
            this.B((String)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 != n10) return 0 != 0;
            object = (CECompositeFinishFragment$b)object;
            this.A((CECompositeFinishFragment$b)object);
        }
        return 1 != 0;
    }
}

