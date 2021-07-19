/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import com.zhiyun.cama.set.bind.MyDeviceFragment$c;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.q1.g0;
import d.v.c.w0.uf;
import d.v.f.e.c;
import l.a.q.g0.u;

public class vf
extends uf
implements b$a {
    private static final ViewDataBinding$IncludedLayouts w;
    private static final SparseIntArray x;
    private final ConstraintLayout o;
    private final TextView p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private long v;

    static {
        SparseIntArray sparseIntArray;
        x = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362497, 9);
        sparseIntArray.put(2131362631, 10);
        sparseIntArray.put(2131363510, 11);
        sparseIntArray.put(2131363079, 12);
    }

    public vf(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = w;
        SparseIntArray sparseIntArray = x;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 13, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private vf(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[3];
        object2 = (ConstraintLayout)((Object)object);
        Object object3 = object = objectArray[9];
        object3 = (FrameLayout)object;
        Object object4 = object = objectArray[10];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[1];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[12];
        object6 = (RecyclerView)object;
        Object object7 = object = objectArray[8];
        object7 = (Button)object;
        Object object8 = object = objectArray[7];
        object8 = (StatusView)((Object)object);
        Object object9 = object = objectArray[4];
        object9 = (TextView)object;
        Object object10 = object = objectArray[5];
        object10 = (TextView)object;
        Object object11 = object = objectArray[11];
        object11 = (TextView)object;
        Object object12 = object = objectArray[6];
        object12 = (View)object;
        object = this;
        Object object13 = dataBindingComponent;
        View view2 = view;
        int n10 = 1;
        super(dataBindingComponent, view, n10, (ConstraintLayout)((Object)object2), (FrameLayout)object3, (ImageView)object4, (ImageView)object5, (RecyclerView)object6, (Button)object7, (StatusView)((Object)object8), (TextView)object9, (TextView)object10, (TextView)object11, (View)object12);
        this.v = -1;
        this.a.setTag(null);
        this.d.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.o = object;
        object.setTag(null);
        int n11 = 2;
        view2 = (TextView)objectArray[n11];
        this.p = view2;
        view2.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        object13 = view;
        this.setRootTag(view);
        object13 = new b(this, 4);
        this.q = object13;
        object13 = new b(this, n11);
        this.r = object13;
        object = new b(this, 5);
        this.s = object;
        object = new b(this, 3);
        this.t = object;
        object = new b(this, 1);
        this.u = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean E(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.v;
                long l11 = 1L;
                this.v = l10 |= l11;
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
    public void B(DeviceBindViewModel deviceBindViewModel) {
        this.n = deviceBindViewModel;
        synchronized (this) {
            long l10 = this.v;
            long l11 = 2;
            this.v = l10 |= l11;
        }
        this.notifyPropertyChanged(11);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(MyDeviceFragment$c myDeviceFragment$c) {
        this.l = myDeviceFragment$c;
        synchronized (this) {
            long l10 = this.v;
            long l11 = 4;
            this.v = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public void D(g0 g02) {
        this.m = g02;
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 4;
                    if (n10 != n13) {
                        n13 = 5;
                        if (n10 == n13) {
                            MyDeviceFragment$c myDeviceFragment$c = this.l;
                            if (myDeviceFragment$c != null) {
                                n11 = n12;
                            }
                            if (n11 != 0) {
                                myDeviceFragment$c.d();
                            }
                        }
                    } else {
                        MyDeviceFragment$c myDeviceFragment$c = this.l;
                        if (myDeviceFragment$c != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            myDeviceFragment$c.c();
                        }
                    }
                } else {
                    MyDeviceFragment$c myDeviceFragment$c = this.l;
                    if (myDeviceFragment$c != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        myDeviceFragment$c.e();
                    }
                }
            } else {
                MyDeviceFragment$c myDeviceFragment$c = this.l;
                if (myDeviceFragment$c != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    myDeviceFragment$c.a();
                }
            }
        } else {
            MyDeviceFragment$c myDeviceFragment$c = this.l;
            if (myDeviceFragment$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                myDeviceFragment$c.b(view);
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
        String string2;
        String string3;
        int n10;
        long l12;
        long l13;
        vf vf2 = this;
        synchronized (this) {
            l13 = this.v;
            this.v = l12 = 0L;
        }
        Object object = this.n;
        long l14 = 19;
        long l15 = l13 & l14;
        long l16 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1);
        int n11 = 0;
        float f10 = 0.0f;
        if (l16 != false) {
            long l17;
            long l18;
            float f11;
            int n12;
            if (object != null) {
                object = ((DeviceBindViewModel)object).b;
            } else {
                n10 = 0;
                object = null;
            }
            vf2.updateLiveDataRegistration(0, (LiveData)object);
            if (object != null) {
                object = (BindDeviceInfo)((LiveData)object).getValue();
            } else {
                n10 = 0;
                object = null;
            }
            if (object != null) {
                string3 = ((BindDeviceInfo)object).getDeviceName();
                string2 = ((BindDeviceInfo)object).getDeviceModel();
            } else {
                string3 = null;
                string2 = null;
            }
            int n13 = 1;
            float f12 = Float.MIN_VALUE;
            if (object != null) {
                n10 = n13;
            } else {
                n10 = 0;
                object = null;
            }
            if (string3 == null) {
                n12 = n13;
                f11 = f12;
            } else {
                n12 = 0;
                f11 = 0.0f;
            }
            if (string2 == null) {
                n11 = n13;
                f10 = f12;
            }
            if (l16 != false) {
                l18 = n12 != 0 ? (long)64 : (long)32;
                l13 |= l18;
            }
            if ((l16 = (l17 = (l18 = l13 & l14) - l12) == 0L ? 0 : (l17 < 0L ? -1 : 1)) != false) {
                l18 = n11 != 0 ? 256L : 128L;
                l13 |= l18;
            }
            l16 = n10;
            n10 = n11;
            n11 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object = null;
            l16 = 0;
            string3 = null;
            string2 = null;
        }
        long l19 = (l11 = (l14 &= l13) - l12) == 0L ? 0 : (l11 < 0L ? -1 : 1);
        if (l19 != false) {
            if (n11 != 0) {
                string3 = "";
            }
            if (n10 != 0) {
                string2 = "";
            }
        } else {
            string3 = null;
            string2 = null;
        }
        if (l19 != false) {
            d.v.f.e.c.a((View)vf2.a, (boolean)l16);
            l.a.q.g0.u.n(vf2.h, "@string/bind_device_model", string2, null);
            object = vf2.i;
            String string4 = "@string/bind_device_name";
            l.a.q.g0.u.n((TextView)object, string4, string3, null);
            object = vf2.k;
            d.v.f.e.c.a((View)object, (boolean)l16);
        }
        if ((n10 = (l10 = (l13 &= (l14 = (long)16)) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != 0) {
            object = vf2.a;
            View.OnClickListener onClickListener = vf2.t;
            object.setOnClickListener(onClickListener);
            object = vf2.d;
            onClickListener = vf2.u;
            object.setOnClickListener(onClickListener);
            object = vf2.p;
            onClickListener = vf2.r;
            object.setOnClickListener(onClickListener);
            object = vf2.f;
            onClickListener = vf2.s;
            object.setOnClickListener(onClickListener);
            object = vf2.g;
            int n14 = ViewDataBinding.getColorFromResource((View)object, 2131099772);
            ((StatusView)((Object)object)).setBackgroundColor(n14);
            object = vf2.g;
            onClickListener = AppCompatResources.getDrawable(object.getContext(), 2131231277);
            ((StatusView)((Object)object)).setEmptyImage((Drawable)onClickListener);
            vf2.g.setEmptyText("@string/device_empty");
            object = vf2.g;
            onClickListener = object.getContext();
            int n15 = 2131231806;
            onClickListener = AppCompatResources.getDrawable((Context)onClickListener, n15);
            ((StatusView)((Object)object)).setErrorImage((Drawable)onClickListener);
            vf2.g.setErrorText("@string/web_net_error");
            object = vf2.g;
            onClickListener = vf2.q;
            ((StatusView)((Object)object)).setOnClickErrorListener(onClickListener);
            object = vf2.g;
            n14 = ViewDataBinding.getColorFromResource((View)object, 2131099737);
            ((StatusView)((Object)object)).setTextColor(n14);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.v;
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
            this.v = l10 = (long)16;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.E((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 11;
        if (n11 == n10) {
            object = (DeviceBindViewModel)object;
            this.B((DeviceBindViewModel)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 == n10) {
                object = (MyDeviceFragment$c)object;
                this.C((MyDeviceFragment$c)object);
                return 1 != 0;
            } else {
                n11 = 152;
                if (n11 != n10) return 0 != 0;
                object = (g0)object;
                this.D((g0)object);
            }
        }
        return 1 != 0;
    }
}

