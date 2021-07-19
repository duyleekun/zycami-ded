/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.LinearLayout
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.f1.a.b$a;
import d.v.c.s0.d7.z;
import d.v.c.w0.wd;
import d.v.c.w0.xd$a;
import d.v.n.j.b;
import l.a.q.g0.u;

public class xd
extends wd
implements b$a {
    private static final ViewDataBinding$IncludedLayouts t;
    private static final SparseIntArray u;
    private final LinearLayout j;
    private final TextView k;
    private final TextView l;
    private final TextView m;
    private final RelativeLayout n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private InverseBindingListener r;
    private long s;

    static {
        SparseIntArray sparseIntArray;
        u = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363585, 11);
    }

    public xd(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = t;
        SparseIntArray sparseIntArray = u;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 12, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private xd(DataBindingComponent object, View object2, Object[] relativeLayout) {
        Object object3;
        Object object4 = object3 = relativeLayout[8];
        object4 = (CheckBox)object3;
        Object object5 = object3 = relativeLayout[9];
        object5 = (RecyclerView)object3;
        Object object6 = object3 = relativeLayout[4];
        object6 = (TextView)object3;
        Object object7 = object3 = relativeLayout[6];
        object7 = (TextView)object3;
        Object object8 = object3 = relativeLayout[5];
        object8 = (TextView)object3;
        Object object9 = object3 = relativeLayout[7];
        object9 = (TextView)object3;
        Object object10 = object3 = relativeLayout[11];
        object10 = (TextView)object3;
        xd xd2 = this;
        DataBindingComponent dataBindingComponent = object;
        super(object, (View)object2, 3, (CheckBox)object4, (RecyclerView)object5, (TextView)object6, (TextView)object7, (TextView)object8, (TextView)object9, (TextView)object10);
        this.r = object = new xd$a(this);
        this.s = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        object = (LinearLayout)relativeLayout[0];
        this.j = object;
        object.setTag(null);
        int n10 = 1;
        xd2 = (TextView)relativeLayout[n10];
        this.k = xd2;
        xd2.setTag(null);
        xd2 = (TextView)relativeLayout[10];
        this.l = xd2;
        xd2.setTag(null);
        int n11 = 2;
        dataBindingComponent = (TextView)relativeLayout[n11];
        this.m = dataBindingComponent;
        dataBindingComponent.setTag(null);
        int n12 = 3;
        this.n = relativeLayout = (RelativeLayout)relativeLayout[n12];
        relativeLayout.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.setRootTag((View)object2);
        super(this, n12);
        this.o = object2;
        super(this, n10);
        this.p = object2;
        object = new d.v.c.f1.a.b(this, n11);
        this.q = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.s;
                long l11 = 4;
                this.s = l10 |= l11;
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
    private boolean D(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.s;
                long l11 = 2;
                this.s = l10 |= l11;
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
    private boolean E(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.s;
                long l11 = 1L;
                this.s = l10 |= l11;
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
    public void A(CameraFragment$j cameraFragment$j) {
        this.h = cameraFragment$j;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 8;
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
    public void B(z z10) {
        this.i = z10;
        synchronized (this) {
            long l10 = this.s;
            long l11 = 16;
            this.s = l10 |= l11;
        }
        this.notifyPropertyChanged(80);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 == n13) {
                    CameraFragment$j cameraFragment$j = this.h;
                    if (cameraFragment$j != null) {
                        n11 = n12;
                    }
                    if (n11) {
                        cameraFragment$j.n0();
                    }
                }
            } else {
                z z10 = this.i;
                if (z10 != null) {
                    n11 = n12;
                }
                if (n11) {
                    z10.t0(n12 != 0);
                }
            }
        } else {
            z z11 = this.i;
            if (z11 == null) {
                n12 = 0;
            }
            if (n12) {
                z11.t0(false);
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
        Object object;
        long l12;
        long l13;
        RelativeLayout relativeLayout;
        String string2;
        int n10;
        int n11;
        int n12;
        int n13;
        float f10;
        long l14;
        long l15;
        Object object2;
        int n14;
        String string3;
        float f11;
        Object object3;
        long l16;
        long l17;
        xd xd2 = this;
        synchronized (this) {
            l17 = this.s;
            this.s = l16 = 0L;
        }
        Object object4 = this.i;
        long l18 = (long)55 & l17;
        Object object5 = l18 == l16 ? 0 : (l18 < l16 ? -1 : 1);
        long l19 = 52;
        long l20 = 50;
        long l21 = 49;
        boolean bl2 = false;
        Object object6 = null;
        if (object5 != false) {
            String string4;
            Object object7;
            long l22 = l17 & l21;
            long l23 = l22 - l16;
            object5 = l23 == 0L ? 0 : (l23 < 0L ? -1 : 1);
            if (object5 != false) {
                if (object4 != null) {
                    object3 = ((z)object4).W();
                } else {
                    object5 = 0;
                    object3 = null;
                }
                xd2.updateLiveDataRegistration(0, (LiveData)object3);
                if (object3 != null) {
                    object3 = (Boolean)((LiveData)object3).getValue();
                } else {
                    object5 = 0;
                    object3 = null;
                }
                object5 = ViewDataBinding.safeUnbox((Boolean)object3);
            } else {
                object5 = 0;
                object3 = null;
            }
            l22 = l17 & l20;
            long l24 = l22 == l16 ? 0 : (l22 < l16 ? -1 : 1);
            int n15 = 8;
            if (l24 != false) {
                String string5;
                if (object4 != null) {
                    object7 = ((z)object4).p;
                } else {
                    f11 = 0.0f;
                    object7 = null;
                }
                bl2 = true;
                xd2.updateLiveDataRegistration((int)(bl2 ? 1 : 0), (LiveData)object7);
                if (object7 != null) {
                    object7 = (b)((LiveData)object7).getValue();
                } else {
                    f11 = 0.0f;
                    object7 = null;
                }
                if (object7 != null) {
                    object6 = ((b)object7).x();
                    string4 = ((b)object7).s();
                    String string6 = ((b)object7).j();
                    String string7 = ((b)object7).w();
                    object7 = ((b)object7).r();
                    string5 = string6;
                    string3 = string7;
                } else {
                    n14 = 0;
                    string5 = null;
                    string3 = null;
                    f11 = 0.0f;
                    object7 = null;
                    bl2 = false;
                    object6 = null;
                    string4 = null;
                }
                if (string5 != null) {
                    object2 = "restream";
                    n14 = string5.equals(object2);
                } else {
                    n14 = 0;
                    string5 = null;
                }
                if (l24 != false) {
                    l15 = n14 != 0 ? 128L : (long)64;
                    l17 |= l15;
                }
                if (n14 != 0) {
                    n14 = 0;
                    string5 = null;
                } else {
                    n14 = n15;
                }
            } else {
                n14 = 0;
                Object var28_23 = null;
                string3 = null;
                f11 = 0.0f;
                object7 = null;
                bl2 = false;
                object6 = null;
                string4 = null;
            }
            l15 = l17 & l19;
            l14 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1);
            if (l14 != false) {
                Resources resources;
                int n16;
                if (object4 != null) {
                    object4 = ((z)object4).G;
                } else {
                    n16 = 0;
                    object4 = null;
                }
                int n17 = 2;
                f10 = 2.8E-45f;
                xd2.updateLiveDataRegistration(n17, (LiveData)object4);
                if (object4 != null) {
                    object4 = (Boolean)((LiveData)object4).getValue();
                } else {
                    n16 = 0;
                    object4 = null;
                }
                n16 = ViewDataBinding.safeUnbox((Boolean)object4);
                if (l14 != false) {
                    if (n16 != 0) {
                        l17 = l17 | 0x200L | 0x800L | 0x2000L | 0x8000L | 0x20000L;
                        l19 = 524288L;
                    } else {
                        l17 = l17 | 0x100L | 0x400L | 0x1000L | 0x4000L | 0x10000L;
                        l19 = 262144L;
                    }
                    l17 |= l19;
                }
                n17 = 2131165277;
                f10 = 1.7944767E38f;
                n13 = 2131165275;
                object2 = xd2.k.getResources();
                float f12 = n16 != 0 ? object2.getDimension(n17) : object2.getDimension(n13);
                if (n16 != 0) {
                    Resources resources2 = xd2.m.getResources();
                    f10 = resources2.getDimension(n13);
                } else {
                    resources = xd2.m.getResources();
                    f10 = resources.getDimension(n17);
                }
                if (n16 != 0) {
                    n13 = 0;
                    resources = null;
                } else {
                    n13 = n15;
                }
                n12 = 2131099781;
                n11 = 2131099772;
                TextView textView = xd2.k;
                n10 = n16 != 0 ? ViewDataBinding.getColorFromResource((View)textView, n12) : ViewDataBinding.getColorFromResource((View)textView, n11);
                if (n16 == 0) {
                    n15 = 0;
                }
                if (n16 != 0) {
                    object4 = xd2.m;
                    n16 = ViewDataBinding.getColorFromResource((View)object4, n11);
                } else {
                    object4 = xd2.m;
                    n16 = ViewDataBinding.getColorFromResource((View)object4, n12);
                }
                n12 = n16;
                object4 = object7;
                f11 = f12;
                n11 = n15;
                string2 = string4;
                l15 = 49;
            } else {
                l15 = l21;
                object4 = object7;
                string2 = string4;
                n12 = 0;
                relativeLayout = null;
                n11 = 0;
                boolean bl3 = false;
                f10 = 0.0f;
                Object var40_39 = null;
                n13 = 0;
                Object var41_42 = null;
                n10 = 0;
                Object var44_47 = null;
                f11 = 0.0f;
                object7 = null;
            }
            bl2 = object5;
            object3 = object6;
        } else {
            l15 = l21;
            boolean bl4 = false;
            object4 = null;
            n12 = 0;
            relativeLayout = null;
            n11 = 0;
            object5 = 0;
            object3 = null;
            boolean bl5 = false;
            f10 = 0.0f;
            Object var40_40 = null;
            n13 = 0;
            Object var41_43 = null;
            n14 = 0;
            Object var28_24 = null;
            string3 = null;
            n10 = 0;
            Object var44_48 = null;
            string2 = null;
            f11 = 0.0f;
            Object var23_17 = null;
            bl2 = false;
            object6 = null;
        }
        long l25 = 0L;
        long l26 = (l15 &= l17) - l25;
        l14 = l26 == 0L ? 0 : (l26 < 0L ? -1 : 1);
        if (l14 != false) {
            object2 = xd2.a;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)object2, bl2);
        }
        if (bl2 = (l13 = (l12 = (long)32 & l17) - l25) == 0L ? 0 : (l13 < 0L ? -1 : 1)) {
            object6 = xd2.a;
            object2 = xd2.r;
            object = object3;
            object5 = 0;
            CompoundButtonBindingAdapter.setListeners((CompoundButton)object6, null, (InverseBindingListener)object2);
            object3 = xd2.k;
            object6 = xd2.p;
            object3.setOnClickListener((View.OnClickListener)object6);
            object3 = xd2.l;
            object6 = xd2.o;
            object3.setOnClickListener((View.OnClickListener)object6);
            object3 = xd2.m;
            object6 = xd2.q;
            object3.setOnClickListener((View.OnClickListener)object6);
        } else {
            object = object3;
        }
        l12 = (long)52 & l17;
        l25 = 0L;
        object5 = l12 == l25 ? 0 : (l12 < l25 ? -1 : 1);
        if (object5 != false) {
            xd2.b.setVisibility(n13);
            TextViewBindingAdapter.setTextSize(xd2.k, f11);
            xd2.k.setTextColor(n10);
            TextViewBindingAdapter.setTextSize(xd2.m, f10);
            object3 = xd2.m;
            object3.setTextColor(n12);
            relativeLayout = xd2.n;
            relativeLayout.setVisibility(n11);
        }
        if ((l11 = (l10 = (l17 &= (long)50) - (l16 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            xd2.m.setVisibility(n14);
            l.a.q.g0.u.n(xd2.c, string3, null, null);
            l.a.q.g0.u.n(xd2.d, string2, null, null);
            TextView textView = xd2.e;
            l.a.q.g0.u.n(textView, (String)object4, null, null);
            object4 = xd2.f;
            object6 = object;
            l.a.q.g0.u.n((TextView)object4, (String)object, null, null);
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
            this.s = l10 = (long)32;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    return false;
                }
                object = (MutableLiveData)object;
                return this.C((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.D((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.E((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 23;
        if (n11 == n10) {
            object = (CameraFragment$j)object;
            this.A((CameraFragment$j)object);
            return 1 != 0;
        } else {
            n11 = 80;
            if (n11 != n10) return 0 != 0;
            object = (z)object;
            this.B((z)object);
        }
        return 1 != 0;
    }
}

