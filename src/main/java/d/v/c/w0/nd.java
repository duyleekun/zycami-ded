/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.EditText
 *  android.widget.ImageView
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.CameraFragment$j;
import d.v.c.f1.a.b$a;
import d.v.c.n0.a;
import d.v.c.s0.d7.z;
import d.v.c.w0.md;
import d.v.c.w0.nd$a;
import d.v.c.w0.nd$b;
import d.v.n.j.b;
import l.a.q.g0.u;

public class nd
extends md
implements b$a {
    private static final ViewDataBinding$IncludedLayouts F;
    private static final SparseIntArray G;
    private final View.OnClickListener A;
    private final View.OnClickListener B;
    private InverseBindingListener C;
    private InverseBindingListener D;
    private long E;
    private final RelativeLayout o;
    private final RelativeLayout p;
    private final RelativeLayout q;
    private final RelativeLayout r;
    private final TextView s;
    private final TextView t;
    private final ImageView u;
    private final RelativeLayout v;
    private final View.OnClickListener w;
    private final View.OnClickListener x;
    private final View.OnClickListener y;
    private final View.OnClickListener z;

    static {
        SparseIntArray sparseIntArray;
        G = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363477, 16);
        sparseIntArray.put(2131362729, 17);
        sparseIntArray.put(2131362730, 18);
        sparseIntArray.put(2131363694, 19);
    }

    public nd(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = F;
        SparseIntArray sparseIntArray = G;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 20, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private nd(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        TextView textView;
        Object object;
        Object object2 = object = objectArray[11];
        object2 = (EditText)object;
        Object object3 = object = objectArray[9];
        object3 = (EditText)object;
        Object object4 = object = objectArray[1];
        object4 = (ImageView)object;
        Object object5 = object = objectArray[8];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[6];
        object6 = (ImageView)object;
        Object object7 = object = objectArray[14];
        object7 = (ImageView)object;
        Object object8 = object = objectArray[17];
        object8 = (ImageView)object;
        Object object9 = object = objectArray[18];
        object9 = (ImageView)object;
        Object object10 = object = objectArray[5];
        object10 = (RelativeLayout)object;
        Object object11 = object = objectArray[16];
        object11 = (TextView)object;
        Object object12 = object = objectArray[7];
        object12 = (TextView)object;
        Object object13 = object = objectArray[19];
        object13 = (View)object;
        object = this;
        Object object14 = view;
        super(dataBindingComponent, view, 1, (EditText)object2, (EditText)object3, (ImageView)object4, (ImageView)object5, (ImageView)object6, (ImageView)object7, (ImageView)object8, (ImageView)object9, (RelativeLayout)object10, (TextView)object11, (TextView)object12, (View)object13);
        this.C = object = new nd$a(this);
        this.D = object = new nd$b(this);
        this.E = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        object = (RelativeLayout)objectArray[0];
        this.o = object;
        object.setTag(null);
        object = (RelativeLayout)objectArray[10];
        this.p = object;
        object.setTag(null);
        object = (RelativeLayout)objectArray[12];
        this.q = object;
        object.setTag(null);
        object = (RelativeLayout)objectArray[13];
        this.r = object;
        object.setTag(null);
        object = (TextView)objectArray[15];
        this.s = object;
        object.setTag(null);
        int n10 = 2;
        this.t = textView = (TextView)objectArray[n10];
        textView.setTag(null);
        int n11 = 3;
        object2 = (ImageView)objectArray[n11];
        this.u = object2;
        object2.setTag(null);
        int n12 = 4;
        object3 = (RelativeLayout)objectArray[n12];
        this.v = object3;
        object3.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        this.setRootTag(view);
        super(this, 5);
        this.w = object14;
        super(this, 1);
        this.x = object14;
        super(this, 6);
        this.y = object14;
        super(this, n10);
        this.z = object14;
        object = new d.v.c.f1.a.b(this, n11);
        this.A = object;
        object = new d.v.c.f1.a.b(this, n12);
        this.B = object;
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
                long l10 = this.E;
                long l11 = 1L;
                this.E = l10 |= l11;
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
        this.m = cameraFragment$j;
        synchronized (this) {
            long l10 = this.E;
            long l11 = 2;
            this.E = l10 |= l11;
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
        this.n = z10;
        synchronized (this) {
            long l10 = this.E;
            long l11 = 4;
            this.E = l10 |= l11;
        }
        this.notifyPropertyChanged(80);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        boolean bl2 = true;
        switch (n10) {
            default: {
                break;
            }
            case 6: {
                CameraFragment$j cameraFragment$j = this.m;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.o0();
                break;
            }
            case 5: {
                z z10 = this.n;
                if (z10 == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                z10.z0();
                break;
            }
            case 4: {
                CameraFragment$j cameraFragment$j = this.m;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.l();
                break;
            }
            case 3: {
                CameraFragment$j cameraFragment$j = this.m;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.l0();
                break;
            }
            case 2: {
                CameraFragment$j cameraFragment$j = this.m;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.a();
                break;
            }
            case 1: {
                CameraFragment$j cameraFragment$j = this.m;
                if (cameraFragment$j == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                cameraFragment$j.e();
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
        int n10;
        int n11;
        String string2;
        String string3;
        String string4;
        int n12;
        String string5;
        String string6;
        boolean bl2;
        long l13;
        long l14;
        nd nd2 = this;
        synchronized (this) {
            l14 = this.E;
            this.E = l13 = 0L;
        }
        Object object = this.n;
        long l15 = 13;
        long l16 = l14 & l15;
        long l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
        long l18 = 1024L;
        int n13 = 0;
        String string7 = null;
        if (l17 != false) {
            int n14;
            long l19;
            long l20;
            String string8;
            String string9;
            String string10;
            String string11;
            if (object != null) {
                object = ((z)object).p;
            } else {
                bl2 = false;
                object = null;
            }
            nd2.updateLiveDataRegistration(0, (LiveData)object);
            if (object != null) {
                object = (b)((LiveData)object).getValue();
            } else {
                bl2 = false;
                object = null;
            }
            if (object != null) {
                string6 = ((b)object).a();
                string5 = ((b)object).j();
                string11 = ((b)object).i();
                string10 = ((b)object).d();
                string9 = ((b)object).m();
                object = ((b)object).l();
            } else {
                bl2 = false;
                object = null;
                string6 = null;
                string5 = null;
                string11 = null;
                string10 = null;
                string9 = null;
            }
            if (string5 != null) {
                string8 = "restream";
                n12 = string5.equals(string8);
                string7 = "weibo";
                n13 = string5.equals(string7);
            } else {
                n12 = 0;
                string8 = null;
                n13 = 0;
                string7 = null;
            }
            if (l17 != false) {
                if (n12 != 0) {
                    l14 |= (long)32;
                    l20 = 32768L;
                } else {
                    l14 |= (long)16;
                    l20 = 16384L;
                }
                l14 |= l20;
            }
            if ((l17 = (l19 = (l20 = l14 & l15) - l13) == 0L ? 0 : (l19 < 0L ? -1 : 1)) != false) {
                if (n13 != 0) {
                    l14 |= 0x200L;
                    l20 = 2048L;
                    l14 |= l20;
                } else {
                    l20 = 256L;
                    l14 = l14 | l20 | l18;
                }
            }
            l17 = (long)TextUtils.isEmpty((CharSequence)string10);
            l20 = l14 & l15;
            long l21 = l20 - l13;
            Object object2 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
            if (object2 != false) {
                l20 = l17 != false ? 128L : (long)64;
                l14 |= l20;
            }
            if (n12 != 0) {
                object2 = 0;
                float f10 = 0.0f;
            } else {
                object2 = 8;
                float f11 = 1.1E-44f;
            }
            if (n12 != 0) {
                n12 = 8;
            } else {
                n12 = 0;
                string8 = null;
            }
            if (n13 != 0) {
                n14 = 0;
                float f12 = 0.0f;
            } else {
                n14 = 8;
                float f13 = 1.1E-44f;
            }
            l17 = l17 != false ? (long)0 : (long)8;
            string4 = string11;
            string3 = string10;
            string2 = string9;
            n11 = object2;
            n10 = n14;
        } else {
            bl2 = false;
            object = null;
            l17 = 0;
            n12 = 0;
            Object var22_18 = null;
            n13 = 0;
            string7 = null;
            string4 = null;
            string6 = null;
            string5 = null;
            string3 = null;
            string2 = null;
            n11 = 0;
            n10 = 0;
        }
        long l22 = (l12 = (l18 &= l14) - l13) == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (l22 != false && string5 != null) {
            String string12 = "kuaishou";
            l22 = (long)string5.equals(string12);
        } else {
            l22 = 0;
            Object var36_34 = null;
        }
        long l23 = l14 & l15;
        long l24 = l23 == l13 ? 0 : (l23 < l13 ? -1 : 1);
        if (l24 != false) {
            if (n13 != 0) {
                l22 = 1;
            }
            if (l24 != false) {
                l23 = l22 != false ? 8192L : 4096L;
                l14 |= l23;
            }
            int n15 = l22 != false ? 0 : 8;
            n13 = n15;
        } else {
            n13 = 0;
            string7 = null;
        }
        long l25 = (l11 = (l15 &= l14) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1);
        if (l25 != false) {
            TextViewBindingAdapter.setText((TextView)nd2.a, string4);
            TextViewBindingAdapter.setText((TextView)nd2.b, (CharSequence)object);
            d.v.c.n0.a.g(nd2.c, string6);
            object = nd2.d;
            string4 = string3;
            d.v.c.n0.a.e((ImageView)object, string3);
            nd2.e.setVisibility((int)l17);
            object = nd2.p;
            l25 = n10;
            object.setVisibility(n10);
            object = nd2.q;
            l25 = n11;
            object.setVisibility(n11);
            object = nd2.t;
            string4 = string2;
            l25 = 0;
            l.a.q.g0.u.n((TextView)object, string2, null, null);
            nd2.v.setVisibility(n12);
            nd2.i.setVisibility(n13);
            object = nd2.k;
            object.setVisibility((int)l17);
        }
        if (bl2 = (l10 = (l14 &= (l15 = (long)8)) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            object = nd2.a;
            InverseBindingListener inverseBindingListener = nd2.C;
            TextViewBindingAdapter.setTextWatcher((TextView)object, null, null, null, inverseBindingListener);
            object = nd2.b;
            inverseBindingListener = nd2.D;
            TextViewBindingAdapter.setTextWatcher((TextView)object, null, null, null, inverseBindingListener);
            object = nd2.d;
            inverseBindingListener = nd2.z;
            object.setOnClickListener((View.OnClickListener)inverseBindingListener);
            object = nd2.f;
            inverseBindingListener = nd2.w;
            object.setOnClickListener((View.OnClickListener)inverseBindingListener);
            object = nd2.q;
            inverseBindingListener = nd2.A;
            object.setOnClickListener((View.OnClickListener)inverseBindingListener);
            object = nd2.r;
            inverseBindingListener = nd2.B;
            object.setOnClickListener((View.OnClickListener)inverseBindingListener);
            object = nd2.s;
            inverseBindingListener = nd2.y;
            object.setOnClickListener((View.OnClickListener)inverseBindingListener);
            object = nd2.u;
            inverseBindingListener = nd2.x;
            object.setOnClickListener((View.OnClickListener)inverseBindingListener);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.E;
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
            this.E = l10 = (long)8;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            return false;
        }
        object = (MutableLiveData)object;
        return this.C((MutableLiveData)object, n11);
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

