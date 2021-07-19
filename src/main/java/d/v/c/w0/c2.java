/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.ImageButton
 *  android.widget.LinearLayout
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.dialog.more.SetVideoFragment$a;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.f7.d;
import d.v.c.s0.u6;
import d.v.c.w0.b2;
import d.v.c.w0.c2$a;
import d.v.c.w0.c2$b;
import d.v.f.e.c;

public class c2
extends b2
implements b$a {
    private static final ViewDataBinding$IncludedLayouts U;
    private static final SparseIntArray V;
    private final ScrollView H;
    private final CardView I;
    private final LinearLayout J;
    private final LinearLayout K;
    private final LinearLayout L;
    private final CardView M;
    private final LinearLayout N;
    private final LinearLayout O;
    private final CardView P;
    private final View.OnClickListener Q;
    private c2$b R;
    private c2$a S;
    private long T;

    static {
        SparseIntArray sparseIntArray;
        V = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362146, 16);
        sparseIntArray.put(2131363112, 17);
        sparseIntArray.put(2131363022, 18);
        sparseIntArray.put(2131363021, 19);
        sparseIntArray.put(2131363023, 20);
        sparseIntArray.put(2131363024, 21);
        sparseIntArray.put(2131363114, 22);
        sparseIntArray.put(2131363041, 23);
        sparseIntArray.put(2131363042, 24);
        sparseIntArray.put(2131363043, 25);
        sparseIntArray.put(2131362147, 26);
        sparseIntArray.put(2131363113, 27);
        sparseIntArray.put(2131363035, 28);
        sparseIntArray.put(2131363033, 29);
        sparseIntArray.put(2131363034, 30);
        sparseIntArray.put(2131362831, 31);
        sparseIntArray.put(2131363451, 32);
        sparseIntArray.put(2131362132, 33);
        sparseIntArray.put(2131363107, 34);
        sparseIntArray.put(2131363050, 35);
        sparseIntArray.put(2131363052, 36);
        sparseIntArray.put(2131363049, 37);
        sparseIntArray.put(2131363051, 38);
    }

    public c2(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = U;
        SparseIntArray sparseIntArray = V;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 39, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private c2(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        c2 c22 = this;
        Object object2 = dataBindingComponent;
        CheckBox checkBox = (CheckBox)objectArray[33];
        CheckBox checkBox2 = (CheckBox)objectArray[13];
        CheckBox checkBox3 = (CheckBox)objectArray[15];
        CheckBox checkBox4 = (CheckBox)objectArray[11];
        CheckBox checkBox5 = (CheckBox)objectArray[16];
        CheckBox checkBox6 = (CheckBox)objectArray[26];
        CheckBox checkBox7 = (CheckBox)objectArray[3];
        ImageButton imageButton = (ImageButton)objectArray[7];
        LinearLayout linearLayout = (LinearLayout)objectArray[31];
        RadioButton radioButton = (RadioButton)objectArray[19];
        RadioButton radioButton2 = (RadioButton)objectArray[18];
        RadioButton radioButton3 = (RadioButton)objectArray[20];
        RadioButton radioButton4 = (RadioButton)objectArray[21];
        RadioButton radioButton5 = (RadioButton)objectArray[29];
        RadioButton radioButton6 = (RadioButton)objectArray[30];
        RadioButton radioButton7 = (RadioButton)objectArray[28];
        RadioButton radioButton8 = (RadioButton)objectArray[23];
        RadioButton radioButton9 = (RadioButton)objectArray[24];
        RadioButton radioButton10 = (RadioButton)objectArray[25];
        RadioButton radioButton11 = (RadioButton)objectArray[37];
        RadioButton radioButton12 = (RadioButton)objectArray[35];
        RadioButton radioButton13 = (RadioButton)objectArray[38];
        RadioButton radioButton14 = (RadioButton)objectArray[36];
        RadioGroup radioGroup = (RadioGroup)objectArray[34];
        RadioGroup radioGroup2 = (RadioGroup)objectArray[17];
        RadioGroup radioGroup3 = (RadioGroup)objectArray[27];
        RadioGroup radioGroup4 = (RadioGroup)objectArray[22];
        TextView textView = (TextView)objectArray[8];
        TextView textView2 = (TextView)objectArray[32];
        TextView textView3 = (TextView)objectArray[5];
        int n10 = 5;
        super(dataBindingComponent, view, n10, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, imageButton, linearLayout, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9, radioButton10, radioButton11, radioButton12, radioButton13, radioButton14, radioGroup, radioGroup2, radioGroup3, radioGroup4, textView, textView2, textView3);
        this.T = -1;
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        c22 = (ScrollView)objectArray[0];
        this.H = c22;
        c22.setTag(null);
        int n11 = 1;
        object = (CardView)((Object)objectArray[n11]);
        this.I = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[10];
        this.J = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[12];
        this.K = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[14];
        this.L = object;
        object.setTag(null);
        object = (CardView)((Object)objectArray[2]);
        this.M = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[4];
        this.N = object;
        object.setTag(null);
        object = (LinearLayout)objectArray[6];
        this.O = object;
        object.setTag(null);
        object = (CardView)((Object)objectArray[9]);
        this.P = object;
        object.setTag(null);
        this.B.setTag(null);
        this.D.setTag(null);
        object2 = view;
        this.setRootTag(view);
        object2 = new b(this, n11);
        this.Q = object2;
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
                long l10 = this.T;
                long l11 = 16;
                this.T = l10 |= l11;
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
    private boolean F(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 1L;
                this.T = l10 |= l11;
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
    private boolean G(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 2;
                this.T = l10 |= l11;
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
    private boolean H(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 8;
                this.T = l10 |= l11;
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
    private boolean I(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.T;
                long l11 = 4;
                this.T = l10 |= l11;
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
    public void B(SetVideoFragment$a setVideoFragment$a) {
        this.E = setVideoFragment$a;
        synchronized (this) {
            long l10 = this.T;
            long l11 = 64;
            this.T = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public void C(d d10) {
        this.G = d10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(u6 u62) {
        this.F = u62;
        synchronized (this) {
            long l10 = this.T;
            long l11 = 128L;
            this.T = l10 |= l11;
        }
        this.notifyPropertyChanged(152);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        SetVideoFragment$a setVideoFragment$a = this.E;
        boolean bl2 = setVideoFragment$a != null;
        if (bl2) {
            setVideoFragment$a.a();
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
        long l15;
        long l16;
        long l17;
        long l18;
        long l19;
        int n10;
        Object object;
        Object object2;
        int n11;
        boolean bl2;
        Object object3;
        Object object4;
        boolean bl3;
        boolean bl4;
        float f10;
        int n12;
        boolean bl5;
        c2$b c2$b;
        int n13;
        float f11;
        float f12;
        float f13;
        Object object5;
        int n14;
        int n15;
        int n16;
        long l20;
        int n17;
        long l21;
        int n18;
        long l22;
        float f14;
        int n19;
        long l23;
        Object object6;
        long l24;
        long l25;
        long l26;
        long l27;
        long l28;
        int n20;
        c2$b c2$b2;
        long l29;
        long l30;
        long l31;
        Object object7;
        Object object8;
        long l32;
        long l33;
        c2 c22;
        block80: {
            CameraSet$Mode cameraSet$Mode;
            float f15;
            long l34;
            Object object9;
            block75: {
                long l35;
                float f16;
                int n21;
                int n22;
                float f17;
                int n23;
                block76: {
                    long l36;
                    long l37;
                    block79: {
                        MutableLiveData mutableLiveData;
                        block78: {
                            block77: {
                                long l38;
                                long l39;
                                long l40;
                                long l41;
                                c22 = this;
                                synchronized (this) {
                                    l33 = this.T;
                                    this.T = l32 = 0L;
                                }
                                object8 = this.E;
                                object7 = this.F;
                                l31 = 320L;
                                l30 = l33 & l31;
                                l29 = l30 == l32 ? 0 : (l30 < l32 ? -1 : 1);
                                if (l29 != false && object8 != null) {
                                    c2$b2 = this.R;
                                    if (c2$b2 == null) {
                                        this.R = c2$b2 = new c2$b();
                                    }
                                    c2$b2 = c2$b2.b((SetVideoFragment$a)object8);
                                    object9 = c22.S;
                                    if (object9 == null) {
                                        object9 = new c2$a();
                                        c22.S = object9;
                                    }
                                    object8 = ((c2$a)object9).b((SetVideoFragment$a)object8);
                                } else {
                                    n20 = 0;
                                    object8 = null;
                                    l29 = 0;
                                    c2$b2 = null;
                                }
                                long l42 = 0x19FL & l33;
                                l34 = l42 == l32 ? 0 : (l42 < l32 ? -1 : 1);
                                long l43 = 262144L;
                                long l44 = 131072L;
                                l28 = 388L;
                                l27 = 392L;
                                l26 = 386L;
                                l25 = 384L;
                                l24 = 65536L;
                                object6 = null;
                                l23 = 400L;
                                n19 = 8;
                                f14 = 1.1E-44f;
                                l22 = 385L;
                                n18 = 1;
                                l21 = 401L;
                                n17 = 0;
                                f15 = 0.0f;
                                cameraSet$Mode = null;
                                if (l34 == false) break block75;
                                long l45 = l33 & l25;
                                l20 = l45 == l32 ? 0 : (l45 < l32 ? -1 : 1);
                                n23 = 1053609165;
                                f17 = 0.4f;
                                if (l20 != false) {
                                    if (object7 != null) {
                                        n22 = ((u6)object7).b1();
                                        n16 = ((u6)object7).d();
                                        n15 = ((u6)object7).j1();
                                        n14 = ((u6)object7).m1();
                                        n21 = ((u6)object7).l1();
                                    } else {
                                        n22 = 0;
                                        object5 = null;
                                        n16 = 0;
                                        n15 = 0;
                                        f13 = 0.0f;
                                        n14 = 0;
                                        f12 = 0.0f;
                                        n21 = 0;
                                    }
                                    if (l20 != false) {
                                        l41 = n16 != 0 ? 16384L : 8192L;
                                        l33 |= l41;
                                    }
                                    if (n16 != 0) {
                                        l20 = 1065353216;
                                        f16 = 1.0f;
                                    } else {
                                        l20 = n23;
                                        f16 = f17;
                                    }
                                } else {
                                    n22 = 0;
                                    object5 = null;
                                    n16 = 0;
                                    n15 = 0;
                                    f13 = 0.0f;
                                    n14 = 0;
                                    f12 = 0.0f;
                                    n21 = 0;
                                    l20 = 0;
                                    f16 = 0.0f;
                                }
                                l41 = l33 & l22;
                                l35 = l41 == l32 ? 0 : (l41 < l32 ? -1 : 1);
                                if (l35 != false) {
                                    if (object7 != null) {
                                        object9 = object6 = ((u6)object7).K();
                                    } else {
                                        l34 = 0;
                                        f11 = 0.0f;
                                        object9 = null;
                                    }
                                    c22.updateLiveDataRegistration(0, (LiveData)object9);
                                    object6 = object9 != null ? (Boolean)((LiveData)object9).getValue() : null;
                                    n13 = ViewDataBinding.safeUnbox((Boolean)object6) ^ 1;
                                    if (l35 != false) {
                                        l33 = n13 != 0 ? (l33 |= l43) : (l33 |= l44);
                                    }
                                    Boolean bl6 = n13 != 0;
                                    l35 = (long)ViewDataBinding.safeUnbox(bl6);
                                    if (n13 != 0) {
                                        n23 = 1065353216;
                                        f17 = 1.0f;
                                    }
                                } else {
                                    l35 = 0;
                                    Object var65_50 = null;
                                    n13 = 0;
                                    n23 = 0;
                                    c2$b = null;
                                    f17 = 0.0f;
                                    l34 = 0;
                                    f11 = 0.0f;
                                    object9 = null;
                                    object6 = null;
                                }
                                if ((l40 = (l39 = (l38 = l33 & l26) - l32) == 0L ? 0 : (l39 < 0L ? -1 : 1)) != false) {
                                    Object object10;
                                    if (object7 != null) {
                                        MutableLiveData mutableLiveData2 = ((u6)object7).v0();
                                        object10 = mutableLiveData2;
                                    } else {
                                        bl5 = false;
                                        object10 = null;
                                    }
                                    c22.updateLiveDataRegistration(n18, (LiveData)object10);
                                    if (object10 != null) {
                                        object10 = (Boolean)((LiveData)object10).getValue();
                                    } else {
                                        bl5 = false;
                                        object10 = null;
                                    }
                                    bl5 = ViewDataBinding.safeUnbox((Boolean)object10);
                                } else {
                                    bl5 = false;
                                    Object var71_56 = null;
                                }
                                long l46 = l33 & l28;
                                n12 = l46 == l32 ? 0 : (l46 < l32 ? -1 : 1);
                                if (n12 != 0) {
                                    Boolean bl7;
                                    if (object7 != null) {
                                        mutableLiveData = ((u6)object7).C0();
                                    } else {
                                        n12 = 0;
                                        f10 = 0.0f;
                                        mutableLiveData = null;
                                    }
                                    bl4 = 2 != 0;
                                    c22.updateLiveDataRegistration((int)(bl4 ? 1 : 0), mutableLiveData);
                                    if (mutableLiveData != null) {
                                        bl7 = (Boolean)mutableLiveData.getValue();
                                    } else {
                                        bl4 = false;
                                        bl7 = null;
                                    }
                                    bl4 = ViewDataBinding.safeUnbox(bl7);
                                } else {
                                    bl4 = false;
                                    Object var79_66 = null;
                                }
                                long l47 = l33 & l27;
                                bl3 = l47 == l32 ? 0 : (l47 < l32 ? -1 : 1);
                                if (bl3) {
                                    Object object11;
                                    if (object7 != null) {
                                        object11 = ((u6)object7).A0();
                                    } else {
                                        bl3 = false;
                                        object11 = null;
                                    }
                                    n12 = 3;
                                    f10 = 4.2E-45f;
                                    c22.updateLiveDataRegistration(n12, (LiveData)object11);
                                    if (object11 != null) {
                                        object11 = (Boolean)((LiveData)object11).getValue();
                                    } else {
                                        bl3 = false;
                                        object11 = null;
                                    }
                                    bl3 = ViewDataBinding.safeUnbox((Boolean)object11);
                                } else {
                                    bl3 = false;
                                    Object var83_71 = null;
                                }
                                l47 = l33 & l21;
                                n12 = (int)(l47 == l32 ? 0 : (l47 < l32 ? -1 : 1));
                                if (n12 == 0) break block76;
                                if (object7 != null) {
                                    mutableLiveData = ((u6)object7).H();
                                } else {
                                    n12 = 0;
                                    f10 = 0.0f;
                                    mutableLiveData = null;
                                }
                                n18 = 4;
                                c22.updateLiveDataRegistration(n18, mutableLiveData);
                                if (mutableLiveData != null) {
                                    object4 = (CameraSet$Mode)((Object)mutableLiveData.getValue());
                                } else {
                                    n18 = 0;
                                    object4 = null;
                                }
                                l47 = l33 & l23;
                                n12 = (int)(l47 == l32 ? 0 : (l47 < l32 ? -1 : 1));
                                if (n12 == 0) break block77;
                                cameraSet$Mode = CameraSet$Mode.story;
                                if (cameraSet$Mode == object4) {
                                    n17 = 1;
                                    f15 = Float.MIN_VALUE;
                                } else {
                                    n17 = 0;
                                    f15 = 0.0f;
                                    cameraSet$Mode = null;
                                }
                                if (n12 != 0) {
                                    l37 = n17 != 0 ? 0x100000L : 524288L;
                                    l33 |= l37;
                                }
                                if (object7 != null) {
                                    n12 = ((u6)object7).Z0((CameraSet$Mode)((Object)object4));
                                } else {
                                    n12 = 0;
                                    f10 = 0.0f;
                                    mutableLiveData = null;
                                }
                                l37 = l33 & l23;
                                l36 = l37 == l32 ? 0 : (l37 < l32 ? -1 : 1);
                                if (l36 != false) {
                                    l37 = n12 != 0 ? 4096L : 2048L;
                                    l33 |= l37;
                                }
                                if (n17 != 0) {
                                    n17 = 0;
                                    f15 = 0.0f;
                                    cameraSet$Mode = null;
                                } else {
                                    n17 = n19;
                                    f15 = f14;
                                }
                                if (n12 != 0) break block78;
                                n12 = n19;
                                f10 = f14;
                                break block79;
                            }
                            n17 = 0;
                            f15 = 0.0f;
                            cameraSet$Mode = null;
                        }
                        n12 = 0;
                        f10 = 0.0f;
                        mutableLiveData = null;
                    }
                    if (object7 != null) {
                        n18 = ((u6)object7).W0((CameraSet$Mode)((Object)object4));
                    } else {
                        n18 = 0;
                        object4 = null;
                    }
                    l37 = l33 & l21;
                    l36 = l37 == l32 ? 0 : (l37 < l32 ? -1 : 1);
                    if (l36 != false) {
                        if (n18 != 0) {
                            l33 |= l24;
                        } else {
                            l37 = 32768L;
                            l33 |= l37;
                        }
                    }
                    object3 = object9;
                    bl2 = l35;
                    l34 = l20;
                    f11 = f16;
                    l20 = n18;
                    n18 = n21;
                    object5 = object8;
                    n20 = n16;
                    n16 = n17;
                    n17 = n15;
                    n15 = n12;
                    f13 = f10;
                    n12 = n14;
                    n14 = n23;
                    f12 = f17;
                    c2$b = c2$b2;
                    l29 = n22;
                    break block80;
                }
                object3 = object9;
                n17 = n15;
                n12 = n14;
                n18 = n21;
                bl2 = l35;
                n15 = 0;
                f13 = 0.0f;
                l34 = l20;
                f11 = f16;
                n14 = n23;
                f12 = f17;
                l20 = 0;
                f16 = 0.0f;
                c2$b = c2$b2;
                l29 = n22;
                object5 = object8;
                n20 = n16;
                n16 = 0;
                break block80;
            }
            object5 = object8;
            c2$b = c2$b2;
            l34 = 0;
            object9 = null;
            f11 = 0.0f;
            n14 = 0;
            f12 = 0.0f;
            n20 = 0;
            object8 = null;
            n17 = 0;
            f15 = 0.0f;
            cameraSet$Mode = null;
            l20 = 0;
            float f18 = 0.0f;
            l29 = 0;
            c2$b2 = null;
            n18 = 0;
            object4 = null;
            bl4 = false;
            Object var79_67 = null;
            bl3 = false;
            Object var83_72 = null;
            bl5 = false;
            Object var71_57 = null;
            n12 = 0;
            f10 = 0.0f;
            Object var76_62 = null;
            object6 = null;
            boolean bl8 = false;
            object3 = null;
            n16 = 0;
            n15 = 0;
            f13 = 0.0f;
            n13 = 0;
            bl2 = false;
        }
        l24 = l33 & l24;
        long l48 = l24 == l32 ? 0 : (l24 < l32 ? -1 : 1);
        if (l48 != false) {
            object7 = object7 != null ? ((u6)object7).K() : object3;
            n11 = 0;
            c22.updateLiveDataRegistration(0, (LiveData)object7);
            if (object7 != null) {
                object6 = object2 = ((LiveData)object7).getValue();
                object6 = (Boolean)object2;
            }
            object = ViewDataBinding.safeUnbox((Boolean)object6);
            n10 = 1;
            n13 = object ^ 1;
            l19 = l33 & l22;
            l24 = 0L;
            long l49 = l19 - l24;
            object = l49 == 0L ? 0 : (l49 < 0L ? -1 : 1);
            if (object != false) {
                l19 = n13 != 0 ? 262144L : 131072L;
                l33 |= l19;
            }
        } else {
            l24 = l32;
            n11 = 0;
        }
        if ((object = (l18 = (l19 = l33 & l21) - l24) == 0L ? 0 : (l18 < 0L ? -1 : 1)) != false) {
            if (l20 == false) {
                n13 = 0;
            }
            if (object != false) {
                l19 = n13 != 0 ? 1024L : 512L;
                l33 |= l19;
            }
            if (n13 != 0) {
                n19 = 0;
                f14 = 0.0f;
            }
            n11 = n19;
        }
        if ((object = (l17 = (l19 = l33 & l26) - (l26 = 0L)) == 0L ? 0 : (l17 < 0L ? -1 : 1)) != false) {
            object2 = c22.b;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)object2, bl5);
        }
        if ((object = (l16 = (l19 = l33 & l27) - l26) == 0L ? 0 : (l16 < 0L ? -1 : 1)) != false) {
            object2 = c22.c;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)object2, bl3);
        }
        l19 = l33 & l25;
        object = l19 == l26 ? 0 : (l19 < l26 ? -1 : 1);
        n10 = 11;
        if (object != false) {
            object = ViewDataBinding.getBuildSdkInt();
            if (object >= n10) {
                object2 = c22.d;
                object2.setAlpha(f11);
            }
            object2 = c22.d;
            object2.setEnabled(n20 != 0);
            d.v.f.e.c.a((View)c22.I, n18 != 0);
            c22.J.setVisibility((int)l29);
            d.v.f.e.c.a((View)c22.N, n17 != 0);
            object8 = c22.P;
            d.v.f.e.c.a((View)object8, n12 != 0);
        }
        if ((n20 = (l15 = (l31 = l33 & l28) - (l30 = 0L)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != 0) {
            object8 = c22.d;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)object8, bl4);
        }
        if ((n20 = (l14 = (l31 = l33 & l22) - l30) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != 0) {
            object8 = c22.g;
            object = bl2;
            object8.setEnabled(bl2);
            n20 = ViewDataBinding.getBuildSdkInt();
            if (n20 >= n10) {
                object8 = c22.M;
                object = n14;
                object8.setAlpha(f12);
            }
        }
        if ((n20 = (int)((l13 = (l19 = 0x100L & l33) - (l31 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0) {
            object8 = c22.h;
            object2 = c22.Q;
            object8.setOnClickListener((View.OnClickListener)object2);
        }
        if ((n20 = (int)((l12 = (l19 = l33 & l23) - l31) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
            object8 = c22.K;
            n12 = n15;
            f10 = f13;
            object8.setVisibility(n15);
            object8 = c22.L;
            object = n16;
            object8.setVisibility(n16);
        }
        if ((n20 = (int)((l11 = (l19 = l33 & l21) - l31) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0) {
            object8 = c22.O;
            object8.setVisibility(n11);
        }
        if ((n20 = (int)((l10 = (l33 &= (l32 = 320L)) - l31) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            object8 = c22.B;
            object4 = object5;
            object8.setOnClickListener((View.OnClickListener)object5);
            object8 = c22.D;
            c2$b2 = c2$b;
            object8.setOnClickListener((View.OnClickListener)c2$b);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.T;
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
            this.T = l10 = 256L;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 != n12) {
                        n12 = 4;
                        if (n10 != n12) {
                            return false;
                        }
                        object = (MutableLiveData)object;
                        return this.E((MutableLiveData)object, n11);
                    }
                    object = (MutableLiveData)object;
                    return this.H((MutableLiveData)object, n11);
                }
                object = (MutableLiveData)object;
                return this.I((MutableLiveData)object, n11);
            }
            object = (MutableLiveData)object;
            return this.G((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.F((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 89;
        if (n11 == n10) {
            object = (d)object;
            this.C((d)object);
            return 1 != 0;
        } else {
            n11 = 23;
            if (n11 == n10) {
                object = (SetVideoFragment$a)object;
                this.B((SetVideoFragment$a)object);
                return 1 != 0;
            } else {
                n11 = 152;
                if (n11 != n10) return 0 != 0;
                object = (u6)object;
                this.D((u6)object);
            }
        }
        return 1 != 0;
    }
}

