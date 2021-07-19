/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.data.api.entity.VersionInfo;
import d.v.c.w0.ki;
import d.v.c.w0.li$a;
import d.v.c.w0.li$b;
import d.v.c.w1.c$a;
import l.a.q.g0.u;

public class li
extends ki {
    private static final ViewDataBinding$IncludedLayouts n;
    private static final SparseIntArray o;
    private final LinearLayout i;
    private final TextView j;
    private li$b k;
    private li$a l;
    private long m;

    static {
        SparseIntArray sparseIntArray;
        o = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363608, 6);
    }

    public li(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = n;
        SparseIntArray sparseIntArray = o;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 7, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private li(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[3];
        object2 = (Button)object;
        Object object3 = object = objectArray[5];
        object3 = (Button)object;
        Object object4 = object = objectArray[2];
        object4 = (CheckBox)object;
        Object object5 = object = objectArray[6];
        object5 = (TextView)object;
        Object object6 = object = objectArray[4];
        object6 = (View)object;
        super(dataBindingComponent, view, 0, (Button)object2, (Button)object3, (CheckBox)object4, (TextView)object5, (View)object6);
        this.m = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        dataBindingComponent = (LinearLayout)objectArray[0];
        this.i = dataBindingComponent;
        dataBindingComponent.setTag(null);
        dataBindingComponent = (TextView)objectArray[1];
        this.j = dataBindingComponent;
        dataBindingComponent.setTag(null);
        this.e.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(c$a c$a) {
        this.f = c$a;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 4;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(boolean bl2) {
        this.h = bl2;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 2;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(36);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(VersionInfo versionInfo) {
        this.g = versionInfo;
        synchronized (this) {
            long l10 = this.m;
            long l11 = 1L;
            this.m = l10 |= l11;
        }
        this.notifyPropertyChanged(149);
        super.requestRebind();
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
        Button button;
        long l13;
        li$b li$b;
        li$a li$a;
        boolean bl2;
        int n10;
        int n11;
        long l14;
        long l15;
        Object object;
        boolean bl3;
        Object object2;
        long l16;
        long l17;
        li li2;
        block18: {
            block17: {
                block16: {
                    boolean bl4;
                    li2 = this;
                    synchronized (this) {
                        l17 = this.m;
                        this.m = l16 = 0L;
                    }
                    object2 = this.g;
                    bl3 = this.h;
                    object = this.f;
                    l15 = 9;
                    long l18 = l17 & l15;
                    l14 = l18 == l16 ? 0 : (l18 < l16 ? -1 : 1);
                    n11 = 8;
                    n10 = 0;
                    if (l14 == false) break block16;
                    if (object2 != null) {
                        bl4 = ((VersionInfo)object2).isForceUpdate();
                        object2 = ((VersionInfo)object2).getNoticeLine();
                    } else {
                        bl2 = false;
                        object2 = null;
                        bl4 = false;
                        li$a = null;
                    }
                    if (l14 != false) {
                        long l19 = bl4 ? (long)32 : (long)16;
                        l17 |= l19;
                    }
                    if (!bl4) break block17;
                    l14 = n11;
                    break block18;
                }
                bl2 = false;
                object2 = null;
            }
            l14 = 0;
        }
        long l20 = 10;
        long l21 = l17 & l20;
        long l22 = l21 == l16 ? 0 : (l21 < l16 ? -1 : 1);
        if (l22 != false) {
            if (l22 != false) {
                l21 = bl3 ? 128L : (long)64;
                l17 |= l21;
            }
            if (bl3) {
                n11 = 0;
                li$b = null;
            }
            n10 = n11;
        }
        if ((bl3 = (l13 = (l21 = l17 & (long)12) - l16) == 0L ? 0 : (l13 < 0L ? -1 : 1)) && object != null) {
            li$b = li2.k;
            if (li$b == null) {
                li2.k = li$b = new li$b();
            }
            li$b = li$b.b((c$a)object);
            li$a = li2.l;
            if (li$a == null) {
                li2.l = li$a = new li$a();
            }
            object = li$a.b((c$a)object);
        } else {
            object = null;
            n11 = 0;
            li$b = null;
        }
        if (bl3) {
            li2.a.setOnClickListener((View.OnClickListener)object);
            button = li2.b;
            button.setOnClickListener((View.OnClickListener)li$b);
        }
        if (bl3 = (l12 = (l11 = l17 & l15) - l16) == 0L ? 0 : (l12 < 0L ? -1 : 1)) {
            li2.a.setVisibility((int)l14);
            button = li2.j;
            u.n((TextView)button, (String)object2, null, null);
            object2 = li2.e;
            object2.setVisibility((int)l14);
        }
        if (bl2 = (l10 = (l17 &= (l11 = (long)10)) - l16) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object2 = li2.c;
            object2.setVisibility(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.m;
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
            this.m = l10 = (long)8;
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
        int n11 = 149;
        if (n11 == n10) {
            object = (VersionInfo)object;
            this.D((VersionInfo)object);
            return 1 != 0;
        } else {
            n11 = 36;
            if (n11 == n10) {
                object = (Boolean)object;
                n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                this.C(n10 != 0);
                return 1 != 0;
            } else {
                n11 = 23;
                if (n11 != n10) return 0 != 0;
                object = (c$a)object;
                this.B((c$a)object);
            }
        }
        return 1 != 0;
    }
}

