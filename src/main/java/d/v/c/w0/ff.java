/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.me.message.MessageFragment$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.j1.b.o0;
import d.v.c.w0.ef;
import d.v.c.w0.ff$a;
import d.v.c.w0.ff$b;
import d.v.c.w0.ff$c;

public class ff
extends ef
implements b$a {
    private static final ViewDataBinding$IncludedLayouts q;
    private static final SparseIntArray r;
    private final LinearLayout h;
    private final LinearLayout i;
    private final LinearLayout j;
    private final LinearLayout k;
    private final View.OnClickListener l;
    private ff$c m;
    private ff$a n;
    private ff$b o;
    private long p;

    static {
        SparseIntArray sparseIntArray;
        r = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363612, 5);
        sparseIntArray.put(2131363484, 6);
        sparseIntArray.put(2131363598, 7);
        sparseIntArray.put(2131363629, 8);
    }

    public ff(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = q;
        SparseIntArray sparseIntArray = r;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 9, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private ff(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        int n10 = 1;
        Object object3 = object2 = objectArray[n10];
        object3 = (ImageView)object2;
        Object object4 = object2 = objectArray[6];
        object4 = (TextView)object2;
        Object object5 = object2 = objectArray[7];
        object5 = (TextView)object2;
        Object object6 = object2 = objectArray[5];
        object6 = (TextView)object2;
        Object object7 = object2 = objectArray[8];
        object7 = (TextView)object2;
        super(object, view, 1, (ImageView)object3, (TextView)object4, (TextView)object5, (TextView)object6, (TextView)object7);
        this.p = -1;
        this.a.setTag(null);
        object = (LinearLayout)objectArray[0];
        this.h = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[2];
        this.i = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[3];
        this.j = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[4];
        this.k = object;
        object.setTag(null);
        this.setRootTag(view);
        object = new b(this, n10);
        this.l = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.p;
                long l11 = 1L;
                this.p = l10 |= l11;
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
    public void A(MessageFragment$a messageFragment$a) {
        this.g = messageFragment$a;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 2;
            this.p = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(o0 o02) {
        this.f = o02;
        synchronized (this) {
            long l10 = this.p;
            long l11 = 4;
            this.p = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        MessageFragment$a messageFragment$a = this.g;
        boolean bl2 = messageFragment$a != null;
        if (bl2) {
            messageFragment$a.a(view);
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
        int n10;
        boolean bl2;
        ff$a ff$a;
        ff$c ff$c;
        long l15;
        long l16;
        ff ff2 = this;
        synchronized (this) {
            l16 = this.p;
            this.p = l15 = 0L;
        }
        Object object = this.g;
        Object object2 = this.f;
        long l17 = 10;
        long l18 = l16 & l17;
        long l19 = l18 == l15 ? 0 : (l18 < l15 ? -1 : 1);
        Object object3 = null;
        if (l19 != false && object != null) {
            ff$c = this.m;
            if (ff$c == null) {
                this.m = ff$c = new ff$c();
            }
            ff$c = ff$c.b((MessageFragment$a)object);
            ff$a = ff2.n;
            if (ff$a == null) {
                ff2.n = ff$a = new ff$a();
            }
            ff$a = ff$a.b((MessageFragment$a)object);
            ff$b ff$b = ff2.o;
            if (ff$b == null) {
                ff2.o = ff$b = new ff$b();
            }
            object = ff$b.b((MessageFragment$a)object);
        } else {
            bl2 = false;
            object = null;
            l19 = 0;
            ff$c = null;
            ff$a = null;
        }
        long l20 = 13;
        long l21 = l16 & l20;
        long l22 = l21 == l15 ? 0 : (l21 < l15 ? -1 : 1);
        int n11 = 0;
        if (l22 != false) {
            if (object2 != null) {
                object2 = ((o0)object2).j();
            } else {
                n10 = 0;
                object2 = null;
            }
            ff2.updateLiveDataRegistration(0, (LiveData)object2);
            if (object2 != null) {
                object2 = ((LiveData)object2).getValue();
                object3 = object2;
                object3 = (Boolean)object2;
            }
            n10 = ViewDataBinding.safeUnbox(object3);
            if (l22 != false) {
                l14 = n10 != 0 ? (long)32 : (long)16;
                l16 |= l14;
            }
            if (n10 == 0) {
                n11 = n10 = 8;
            }
        }
        if ((n10 = (l13 = (l14 = l16 & (long)8) - l15) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != 0) {
            object2 = ff2.a;
            object3 = ff2.l;
            object2.setOnClickListener(object3);
        }
        if ((n10 = (l12 = (l11 = l16 & l17) - l15) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != 0) {
            ff2.i.setOnClickListener((View.OnClickListener)ff$c);
            object2 = ff2.j;
            object2.setOnClickListener((View.OnClickListener)object);
            object = ff2.k;
            object.setOnClickListener((View.OnClickListener)ff$a);
        }
        if (bl2 = (l10 = (l16 &= l20) - l15) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object = ff2.k;
            object.setVisibility(n11);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.p;
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
            this.p = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (LiveData)object;
        return this.C((LiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (MessageFragment$a)object;
            this.A((MessageFragment$a)object);
            return 1 != 0;
        } else {
            n11 = 152;
            if (n11 != n10) return 0 != 0;
            object = (o0)object;
            this.B((o0)object);
        }
        return 1 != 0;
    }
}

