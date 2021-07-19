/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.account.data.me.ThirdPlatform;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.m1.d.k$a;
import d.v.c.w0.cg;
import d.v.c.w0.dg$a;
import d.v.c.w0.dg$b;
import d.v.c.w0.dg$c;

public class dg
extends cg
implements b$a {
    private static final ViewDataBinding$IncludedLayouts t;
    private static final SparseIntArray u;
    private final View.OnClickListener l;
    private final View.OnClickListener m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private dg$c p;
    private dg$a q;
    private dg$b r;
    private long s;

    static {
        SparseIntArray sparseIntArray;
        u = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363420, 8);
        sparseIntArray.put(2131363496, 9);
    }

    public dg(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = t;
        SparseIntArray sparseIntArray = u;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private dg(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[2];
        object2 = (Button)object;
        Object object3 = object = objectArray[3];
        object3 = (Button)object;
        Object object4 = object = objectArray[0];
        object4 = (ConstraintLayout)((Object)object);
        Object object5 = object = objectArray[1];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[7];
        object6 = (ImageView)object;
        Object object7 = object = objectArray[5];
        object7 = (ImageView)object;
        int n10 = 4;
        Object object8 = object = objectArray[n10];
        object8 = (ImageView)object;
        Object object9 = object = objectArray[6];
        object9 = (ImageView)object;
        Object object10 = object = objectArray[8];
        object10 = (TextView)object;
        Object object11 = object = objectArray[9];
        object11 = (TextView)object;
        object = this;
        super(dataBindingComponent, view, 0, (Button)object2, (Button)object3, (ConstraintLayout)((Object)object4), (ImageView)object5, (ImageView)object6, (ImageView)object7, (ImageView)object8, (ImageView)object9, (TextView)object10, (TextView)object11);
        this.s = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n10);
        this.l = object;
        object = new b(this, 2);
        this.m = object;
        object = new b(this, 1);
        this.n = object;
        object = new b(this, 3);
        this.o = object;
        this.invalidateAll();
    }

    public final void a(int n10, View object) {
        int n11 = 0;
        object = null;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 4;
                    if (n10 == n13) {
                        k$a k$a = this.k;
                        if (k$a != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            object = ThirdPlatform.FACEBOOK;
                            k$a.d((ThirdPlatform)((Object)object));
                        }
                    }
                } else {
                    k$a k$a = this.k;
                    if (k$a != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        object = ThirdPlatform.WEIBO;
                        k$a.d((ThirdPlatform)((Object)object));
                    }
                }
            } else {
                k$a k$a = this.k;
                if (k$a != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    object = ThirdPlatform.QQ;
                    k$a.d((ThirdPlatform)((Object)object));
                }
            }
        } else {
            k$a k$a = this.k;
            if (k$a != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                object = ThirdPlatform.WE_CHAT;
                k$a.d((ThirdPlatform)((Object)object));
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
        long l12;
        dg$a dg$a;
        long l13;
        long l14;
        synchronized (this) {
            l14 = this.s;
            this.s = l13 = 0L;
        }
        Object object = this.k;
        long l15 = (long)3 & l14;
        long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
        Object object2 = null;
        if (l16 != false && object != null) {
            object2 = this.p;
            if (object2 == null) {
                object2 = new dg$c();
                this.p = object2;
            }
            object2 = ((dg$c)object2).b((k$a)object);
            dg$a = this.q;
            if (dg$a == null) {
                this.q = dg$a = new dg$a();
            }
            dg$a = dg$a.b((k$a)object);
            dg$b dg$b = this.r;
            if (dg$b == null) {
                this.r = dg$b = new dg$b();
            }
            object = dg$b.b((k$a)object);
            dg$c dg$c = object2;
            object2 = object;
            object = dg$c;
        } else {
            object = null;
            dg$a = null;
        }
        if (l16 != false) {
            this.a.setOnClickListener((View.OnClickListener)object2);
            this.b.setOnClickListener((View.OnClickListener)dg$a);
            ImageView imageView = this.d;
            imageView.setOnClickListener((View.OnClickListener)object);
        }
        if ((l12 = (l11 = (l14 &= (l10 = (long)2)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            ConstraintLayout constraintLayout;
            boolean bl2;
            l12 = ViewDataBinding.getBuildSdkInt();
            if (l12 >= (bl2 = 21 != 0)) {
                constraintLayout = this.c;
                bl2 = true;
                constraintLayout.setClipToOutline(bl2);
            }
            constraintLayout = this.e;
            View.OnClickListener onClickListener = this.l;
            constraintLayout.setOnClickListener(onClickListener);
            constraintLayout = this.f;
            onClickListener = this.m;
            constraintLayout.setOnClickListener(onClickListener);
            constraintLayout = this.g;
            onClickListener = this.n;
            constraintLayout.setOnClickListener(onClickListener);
            constraintLayout = this.h;
            onClickListener = this.o;
            constraintLayout.setOnClickListener(onClickListener);
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
            this.s = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (k$a)object;
            this.z((k$a)object);
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
    public void z(k$a k$a) {
        this.k = k$a;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 1L;
            this.s = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }
}

