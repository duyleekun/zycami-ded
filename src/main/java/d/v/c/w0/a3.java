/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.zhiyun.device.connection.BleDevice$State;
import d.v.c.w0.z2;
import l.a.q.g0.u;

public class a3
extends z2 {
    private static final ViewDataBinding$IncludedLayouts j;
    private static final SparseIntArray k;
    private final ConstraintLayout f;
    private final ImageView g;
    private final ProgressBar h;
    private long i;

    public a3(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = j;
        SparseIntArray sparseIntArray = k;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private a3(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3 = object2 = objectArray[2];
        object3 = (Button)object2;
        Object object4 = object2 = objectArray[1];
        object4 = (TextView)object2;
        super(object, view, 0, (Button)object3, (TextView)object4);
        this.i = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.f = object;
        object.setTag(null);
        object = (ImageView)objectArray[3];
        this.g = object;
        object.setTag(null);
        object = (ProgressBar)objectArray[4];
        this.h = object;
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
    public void B(boolean bl2) {
        this.d = bl2;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 4;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(33);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(String string2) {
        this.e = string2;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 2;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(38);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(BleDevice$State bleDevice$State) {
        this.c = bleDevice$State;
        synchronized (this) {
            long l10 = this.i;
            long l11 = 1L;
            this.i = l10 |= l11;
        }
        this.notifyPropertyChanged(127);
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
        long l13;
        Context context;
        long l14;
        long l15;
        long l16;
        int n10;
        long l17;
        BleDevice$State bleDevice$State;
        int n11;
        long l18;
        long l19;
        a3 a32 = this;
        synchronized (this) {
            l19 = this.i;
            this.i = l18 = 0L;
        }
        BleDevice$State bleDevice$State2 = this.c;
        String string2 = this.e;
        int n12 = this.d;
        long l20 = 9;
        long l21 = l19 & l20;
        long l22 = l21 == l18 ? 0 : (l21 < l18 ? -1 : 1);
        if (l22 != false) {
            long l23;
            long l24;
            int n13;
            BleDevice$State bleDevice$State3 = BleDevice$State.CONNECTING;
            int n14 = 1;
            if (bleDevice$State2 == bleDevice$State3) {
                n11 = n14;
            } else {
                n11 = 0;
                bleDevice$State3 = null;
            }
            BleDevice$State bleDevice$State4 = BleDevice$State.UNCONNECTED;
            if (bleDevice$State2 == bleDevice$State4) {
                n13 = n14;
            } else {
                n13 = 0;
                bleDevice$State4 = null;
            }
            bleDevice$State = BleDevice$State.CONNECTED;
            if (bleDevice$State2 != bleDevice$State) {
                n14 = 0;
            }
            if (l22 != false) {
                l17 = n11 != 0 ? (long)32 : (long)16;
                l19 |= l17;
            }
            if ((n10 = (l24 = (l17 = l19 & l20) - l18) == 0L ? 0 : (l24 < 0L ? -1 : 1)) != 0) {
                l17 = n13 != 0 ? 512L : 256L;
                l19 |= l17;
            }
            if ((n10 = (l23 = (l17 = l19 & l20) - l18) == 0L ? 0 : (l23 < 0L ? -1 : 1)) != 0) {
                l17 = n14 != 0 ? 8192L : 4096L;
                l19 |= l17;
            }
            n10 = 8;
            l22 = n11 != 0 ? (long)0 : (long)n10;
            if (n13 != 0) {
                n11 = 0;
                bleDevice$State3 = null;
            } else {
                n11 = n10;
            }
            if (n14 != 0) {
                n10 = 0;
                bleDevice$State2 = null;
            }
        } else {
            n10 = 0;
            bleDevice$State2 = null;
            l22 = 0;
            n11 = 0;
            Object var14_11 = null;
        }
        if ((l16 = (l15 = (l17 = l19 & (l14 = (long)12)) - l18) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false) {
            TextView textView;
            if (l16 != false) {
                if (n12 != 0) {
                    l19 |= 0x80L;
                    l17 = 2048L;
                } else {
                    l19 |= (long)64;
                    l17 = 1024L;
                }
                l19 |= l17;
            }
            if (n12 != 0) {
                bleDevice$State = a32.f.getContext();
                int n15 = 2131230888;
                context = AppCompatResources.getDrawable((Context)bleDevice$State, n15);
            } else {
                context = a32.f.getContext();
                l16 = 2131230920;
                context = AppCompatResources.getDrawable(context, (int)l16);
            }
            if (n12 != 0) {
                textView = a32.b;
                l16 = 2131099772;
            } else {
                textView = a32.b;
                l16 = 2131099739;
            }
            n12 = ViewDataBinding.getColorFromResource((View)textView, (int)l16);
        } else {
            n12 = 0;
            Object var28_25 = null;
            boolean bl2 = false;
            context = null;
        }
        long l25 = (l13 = (l20 &= l19) - l18) == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l25 != false) {
            a32.a.setVisibility(n11);
            ImageView imageView = a32.g;
            imageView.setVisibility(n10);
            bleDevice$State2 = a32.h;
            bleDevice$State2.setVisibility((int)l22);
        }
        if ((n10 = (int)((l12 = (l20 = l19 & l14) - l18) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
            ViewBindingAdapter.setBackground((View)a32.f, (Drawable)context);
            bleDevice$State2 = a32.b;
            bleDevice$State2.setTextColor(n12);
        }
        if ((n10 = (int)((l11 = (l19 &= (l10 = (long)10)) - l18) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0) {
            bleDevice$State2 = a32.b;
            u.n((TextView)bleDevice$State2, string2, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.i;
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
            this.i = l10 = (long)8;
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
        int n11 = 127;
        if (n11 == n10) {
            object = (BleDevice$State)((Object)object);
            this.D((BleDevice$State)((Object)object));
            return 1 != 0;
        } else {
            n11 = 38;
            if (n11 == n10) {
                object = (String)object;
                this.C((String)object);
                return 1 != 0;
            } else {
                n11 = 33;
                if (n11 != n10) return 0 != 0;
                object = (Boolean)object;
                n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                this.B(n10 != 0);
            }
        }
        return 1 != 0;
    }
}

