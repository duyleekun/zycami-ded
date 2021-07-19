/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.CheckedTextView
 *  android.widget.CompoundButton
 *  android.widget.ImageView
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
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.data.CameraSet$Theme;
import com.zhiyun.cama.camera.dialog.more.SetGeneralFragment$b;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.u6;
import d.v.c.s0.v6;
import d.v.c.w0.v1;
import d.v.c.w0.w1$a;

public class w1
extends v1
implements b$a {
    private static final ViewDataBinding$IncludedLayouts E;
    private static final SparseIntArray F;
    private final LinearLayout A;
    private final View.OnClickListener B;
    private w1$a C;
    private long D;
    private final ScrollView w;
    private final LinearLayout x;
    private final LinearLayout y;
    private final LinearLayout z;

    static {
        SparseIntArray sparseIntArray;
        F = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362764, 10);
        sparseIntArray.put(2131363111, 11);
        sparseIntArray.put(2131362726, 12);
        sparseIntArray.put(2131363360, 13);
        sparseIntArray.put(2131363411, 14);
        sparseIntArray.put(2131362134, 15);
        sparseIntArray.put(2131363108, 16);
        sparseIntArray.put(2131363054, 17);
        sparseIntArray.put(2131363053, 18);
        sparseIntArray.put(2131363417, 19);
        sparseIntArray.put(2131363416, 20);
        sparseIntArray.put(2131363444, 21);
        sparseIntArray.put(2131363570, 22);
    }

    public w1(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = E;
        SparseIntArray sparseIntArray = F;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 23, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private w1(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        w1 w12 = this;
        w1 w13 = this;
        Object object = dataBindingComponent;
        CheckBox checkBox = (CheckBox)objectArray[15];
        CheckBox checkBox2 = (CheckBox)objectArray[2];
        CheckedTextView checkedTextView = (CheckedTextView)objectArray[9];
        ImageView imageView = (ImageView)objectArray[12];
        ImageView imageView2 = (ImageView)objectArray[10];
        RadioButton radioButton = (RadioButton)objectArray[18];
        RadioButton radioButton2 = (RadioButton)objectArray[17];
        RadioButton radioButton3 = (RadioButton)objectArray[3];
        RadioButton radioButton4 = (RadioButton)objectArray[5];
        RadioButton radioButton5 = (RadioButton)objectArray[4];
        RadioGroup radioGroup = (RadioGroup)objectArray[16];
        RadioGroup radioGroup2 = (RadioGroup)objectArray[11];
        TextView textView = (TextView)objectArray[13];
        TextView textView2 = (TextView)objectArray[14];
        TextView textView3 = (TextView)objectArray[20];
        TextView textView4 = (TextView)objectArray[19];
        TextView textView5 = (TextView)objectArray[21];
        TextView textView6 = (TextView)objectArray[22];
        int n10 = 4;
        super(dataBindingComponent, view, n10, checkBox, checkBox2, checkedTextView, imageView, imageView2, radioButton, radioButton2, radioButton3, radioButton4, radioButton5, radioGroup, radioGroup2, textView, textView2, textView3, textView4, textView5, textView6);
        this.D = -1;
        this.b.setTag(null);
        this.c.setTag(null);
        w13 = (ScrollView)objectArray[0];
        this.w = w13;
        w13.setTag(null);
        int n11 = 1;
        w12 = (LinearLayout)objectArray[n11];
        this.x = w12;
        w12.setTag(null);
        w12 = (LinearLayout)objectArray[6];
        this.y = w12;
        w12.setTag(null);
        w12 = (LinearLayout)objectArray[7];
        this.z = w12;
        w12.setTag(null);
        w12 = (LinearLayout)objectArray[8];
        this.A = w12;
        w12.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n11);
        this.B = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean G(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.D;
                long l11 = 2;
                this.D = l10 |= l11;
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
    private boolean H(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.D;
                long l11 = 8;
                this.D = l10 |= l11;
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
    private boolean I(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.D;
                long l11 = 4;
                this.D = l10 |= l11;
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
    private boolean J(LiveData liveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.D;
                long l11 = 1L;
                this.D = l10 |= l11;
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
    public void C(BleViewModel bleViewModel) {
        this.t = bleViewModel;
        synchronized (this) {
            long l10 = this.D;
            long l11 = 32;
            this.D = l10 |= l11;
        }
        this.notifyPropertyChanged(12);
        super.requestRebind();
    }

    public void D(u6 u62) {
        this.u = u62;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(SetGeneralFragment$b setGeneralFragment$b) {
        this.s = setGeneralFragment$b;
        synchronized (this) {
            long l10 = this.D;
            long l11 = 128L;
            this.D = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    public void F(v6 v62) {
        this.v = v62;
    }

    public final void a(int n10, View view) {
        SetGeneralFragment$b setGeneralFragment$b = this.s;
        boolean bl2 = setGeneralFragment$b != null;
        if (bl2) {
            setGeneralFragment$b.a();
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
        float f10;
        CameraSet$Theme cameraSet$Theme;
        long l19;
        float f11;
        Object object;
        int n10;
        float f12;
        boolean bl2;
        float f13;
        int n11;
        long l20;
        Object object2;
        float f14;
        long l21;
        long l22;
        float f15;
        int n12;
        Object object3;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        CameraSet$Theme cameraSet$Theme2;
        float f16;
        int n13;
        LiveData liveData;
        long l23;
        long l24;
        long l25;
        long l26;
        float f17;
        int n14;
        float f18;
        int n15;
        long l27;
        long l28;
        long l29;
        long l30;
        int n16;
        int n17;
        CameraSet$Theme cameraSet$Theme3;
        float f19;
        int n18;
        long l31;
        long l32;
        Object object4;
        Object object5;
        long l33;
        w1 w12;
        block107: {
            block106: {
                block105: {
                    block104: {
                        block103: {
                            block102: {
                                Object object6;
                                long l34;
                                long l35;
                                long l36;
                                long l37;
                                long l38;
                                block96: {
                                    block99: {
                                        Object object7;
                                        block101: {
                                            block100: {
                                                long l39;
                                                long l40;
                                                long l41;
                                                long l42;
                                                long l43;
                                                long l44;
                                                w12 = this;
                                                synchronized (this) {
                                                    l33 = this.D;
                                                    this.D = l38 = 0L;
                                                }
                                                object5 = this.t;
                                                object4 = this.s;
                                                long l45 = 256L;
                                                l32 = l33 & l45;
                                                l31 = l32 == l38 ? 0 : (l32 < l38 ? -1 : 1);
                                                n18 = 0;
                                                f19 = 0.0f;
                                                cameraSet$Theme3 = null;
                                                if (l31 != false) {
                                                    CameraSet$Theme cameraSet$Theme4 = CameraSet$Theme.PINK;
                                                    l31 = cameraSet$Theme4.getId();
                                                    CameraSet$Theme cameraSet$Theme5 = CameraSet$Theme.DEFAULT;
                                                    n17 = cameraSet$Theme5.getId();
                                                    CameraSet$Theme cameraSet$Theme6 = CameraSet$Theme.PEARL;
                                                    n16 = cameraSet$Theme6.getId();
                                                } else {
                                                    l31 = 0;
                                                    Object var16_13 = null;
                                                    n17 = 0;
                                                    Object var17_15 = null;
                                                    n16 = 0;
                                                    Object var19_18 = null;
                                                }
                                                l30 = 0x12FL & l33;
                                                l29 = l30 == l38 ? 0 : (l30 < l38 ? -1 : 1);
                                                long l46 = 1024L;
                                                l37 = 8192L;
                                                l28 = 0x1000000L;
                                                l27 = 32768L;
                                                l36 = 0x400000L;
                                                l35 = 0x4000000L;
                                                l34 = 4096L;
                                                n15 = 1065353216;
                                                f18 = 1.0f;
                                                n14 = 1053609165;
                                                f17 = 0.4f;
                                                l26 = 296L;
                                                l25 = 297L;
                                                l24 = 290L;
                                                l23 = 292L;
                                                object6 = null;
                                                if (l29 == false) break block99;
                                                long l47 = l33 & l23;
                                                long l48 = l47 - l38;
                                                object7 = l48 == 0L ? 0 : (l48 < 0L ? -1 : 1);
                                                if (object7 != false) {
                                                    long l49;
                                                    if (object5 != null) {
                                                        liveData = ((BleViewModel)object5).v;
                                                    } else {
                                                        l29 = 0;
                                                        liveData = null;
                                                    }
                                                    n13 = 2;
                                                    f16 = 2.8E-45f;
                                                    w12.updateLiveDataRegistration(n13, liveData);
                                                    if (liveData != null) {
                                                        cameraSet$Theme2 = (CameraSet$Theme)((Object)liveData.getValue());
                                                    } else {
                                                        n13 = 0;
                                                        cameraSet$Theme2 = null;
                                                        f16 = 0.0f;
                                                    }
                                                    if (cameraSet$Theme2 != null) {
                                                        l29 = 1;
                                                    } else {
                                                        l29 = 0;
                                                        liveData = null;
                                                    }
                                                    bl5 = cameraSet$Theme2 == null;
                                                    if (object7 != false) {
                                                        if (l29 != false) {
                                                            l33 = l33 | l36 | l35;
                                                        } else {
                                                            l33 |= 0x200000L;
                                                            l44 = 0x2000000L;
                                                            l33 |= l44;
                                                        }
                                                    }
                                                    if ((object7 = (l49 = (l44 = l33 & l23) - l38) == 0L ? 0 : (l49 < 0L ? -1 : 1)) != false) {
                                                        if (bl5) {
                                                            l44 = 65536L;
                                                            l33 |= l44;
                                                        } else {
                                                            l33 |= l27;
                                                        }
                                                    }
                                                } else {
                                                    l29 = 0;
                                                    liveData = null;
                                                    bl5 = false;
                                                    n13 = 0;
                                                    cameraSet$Theme2 = null;
                                                    f16 = 0.0f;
                                                }
                                                if ((object7 = (l43 = (l44 = l33 & l24) - l38) == 0L ? 0 : (l43 < 0L ? -1 : 1)) != false) {
                                                    long l50;
                                                    bl4 = object5 == null;
                                                    bl3 = object5 != null;
                                                    if (object7 != false) {
                                                        if (bl4) {
                                                            l42 = 16384L;
                                                            l33 |= l42;
                                                        } else {
                                                            l33 |= l37;
                                                        }
                                                    }
                                                    if ((object7 = (l50 = (l42 = l33 & l24) - l38) == 0L ? 0 : (l50 < 0L ? -1 : 1)) != false) {
                                                        if (bl3) {
                                                            l33 = l33 | l46 | l28;
                                                        } else {
                                                            l33 |= 0x200L;
                                                            l42 = 0x800000L;
                                                            l33 |= l42;
                                                        }
                                                    }
                                                } else {
                                                    bl4 = false;
                                                    bl3 = false;
                                                }
                                                if ((object7 = (l41 = (l42 = l33 & l25) - l38) == 0L ? 0 : (l41 < 0L ? -1 : 1)) == false) break block100;
                                                if (object5 != null) {
                                                    object3 = ((BleViewModel)object5).L;
                                                } else {
                                                    n12 = 0;
                                                    object3 = null;
                                                    f15 = 0.0f;
                                                }
                                                l22 = 3;
                                                w12.updateLiveDataRegistration((int)l22, (LiveData)object3);
                                                if (object3 != null) {
                                                    object3 = (Boolean)((LiveData)object3).getValue();
                                                } else {
                                                    n12 = 0;
                                                    object3 = null;
                                                    f15 = 0.0f;
                                                }
                                                n12 = ViewDataBinding.safeUnbox((Boolean)object3);
                                                if (object7 != false) {
                                                    if (n12 != 0) {
                                                        l33 |= l34;
                                                    } else {
                                                        l21 = 2048L;
                                                        l33 |= l21;
                                                    }
                                                }
                                                if ((object7 = (l40 = (l21 = l33 & l26) - l38) == 0L ? 0 : (l40 < 0L ? -1 : 1)) != false) {
                                                    l21 = n12 != 0 ? 0x10000000L : 0x8000000L;
                                                    l33 |= l21;
                                                }
                                                if ((object7 = (l39 = (l21 = l33 & l26) - l38) == 0L ? 0 : (l39 < 0L ? -1 : 1)) == false) break block101;
                                                if (n12 != 0) {
                                                    object7 = n15;
                                                    f14 = f18;
                                                    break block96;
                                                } else {
                                                    object7 = n14;
                                                    f14 = f17;
                                                }
                                                break block96;
                                            }
                                            n12 = 0;
                                            object3 = null;
                                            f15 = 0.0f;
                                        }
                                        object7 = 0;
                                        f14 = 0.0f;
                                        break block96;
                                    }
                                    l29 = 0;
                                    liveData = null;
                                    n12 = 0;
                                    object3 = null;
                                    f15 = 0.0f;
                                    bl5 = false;
                                    bl4 = false;
                                    bl3 = false;
                                    boolean bl6 = false;
                                    f14 = 0.0f;
                                    n13 = 0;
                                    cameraSet$Theme2 = null;
                                    f16 = 0.0f;
                                }
                                l21 = 384L;
                                long l51 = l33 & l21;
                                l22 = l51 == l38 ? 0 : (l51 < l38 ? -1 : 1);
                                if (l22 != false && object4 != null) {
                                    object2 = w12.C;
                                    if (object2 == null) {
                                        object2 = new w1$a();
                                        w12.C = object2;
                                    }
                                    object4 = ((w1$a)object2).b((SetGeneralFragment$b)object4);
                                } else {
                                    object4 = null;
                                }
                                l34 = l33 & l34;
                                l22 = l34 == l38 ? 0 : (l34 < l38 ? -1 : 1);
                                if (l22 != false) {
                                    if (object5 != null) {
                                        object2 = ((BleViewModel)object5).M;
                                    } else {
                                        l22 = 0;
                                        object2 = null;
                                    }
                                    w12.updateLiveDataRegistration(0, (LiveData)object2);
                                    if (object2 != null) {
                                        object2 = (Boolean)((LiveData)object2).getValue();
                                    } else {
                                        l22 = 0;
                                        object2 = null;
                                    }
                                    l22 = (long)ViewDataBinding.safeUnbox((Boolean)object2);
                                } else {
                                    l22 = 0;
                                    object2 = null;
                                }
                                l35 = l33 & l35;
                                long l52 = l35 == l38 ? 0 : (l35 < l38 ? -1 : 1);
                                if (l52 != false && (cameraSet$Theme3 = CameraSet$Theme.PEARL) == cameraSet$Theme2) {
                                    n18 = 1;
                                    f19 = Float.MIN_VALUE;
                                } else {
                                    n18 = 0;
                                    f19 = 0.0f;
                                    cameraSet$Theme3 = null;
                                }
                                l20 = l33 & 0x1002400L;
                                long l53 = l20 == l38 ? 0 : (l20 < l38 ? -1 : 1);
                                if (l53 != false) {
                                    if (object5 != null) {
                                        object5 = ((BleViewModel)object5).u;
                                    } else {
                                        n11 = 0;
                                        object5 = null;
                                        f13 = 0.0f;
                                    }
                                    bl2 = true;
                                    f12 = Float.MIN_VALUE;
                                    w12.updateLiveDataRegistration((int)(bl2 ? 1 : 0), (LiveData)object5);
                                    if (object5 != null) {
                                        object6 = object5 = ((LiveData)object5).getValue();
                                        object6 = (CameraSet$Theme)((Object)object5);
                                    }
                                    object5 = object6;
                                    l20 = 0L;
                                    long l54 = (l28 = l33 & l28) - l20;
                                    n10 = l54 == 0L ? 0 : (l54 < 0L ? -1 : 1);
                                    if (n10 && (object = CameraSet$Theme.PEARL) == object6) {
                                        n10 = bl2;
                                        f11 = f12;
                                    } else {
                                        n10 = false;
                                        f11 = 0.0f;
                                        object = null;
                                    }
                                    l37 = l33 & l37;
                                    l19 = l37 == l20 ? 0 : (l37 < l20 ? -1 : 1);
                                    if (l19 != false && (cameraSet$Theme = CameraSet$Theme.DEFAULT) == object5) {
                                        bl2 = true;
                                        f12 = Float.MIN_VALUE;
                                    } else {
                                        bl2 = false;
                                        f12 = 0.0f;
                                        cameraSet$Theme = null;
                                    }
                                    l37 = l33 & 0x400L;
                                    l19 = l37 == l20 ? 0 : (l37 < l20 ? -1 : 1);
                                    if (l19 != false) {
                                        l19 = (long)bl2;
                                        f10 = f12;
                                        cameraSet$Theme = CameraSet$Theme.PINK;
                                        if (cameraSet$Theme == object5) {
                                            n11 = 1;
                                            f13 = Float.MIN_VALUE;
                                        } else {
                                            n11 = 0;
                                            f13 = 0.0f;
                                            object5 = null;
                                        }
                                        bl2 = (boolean)l19;
                                        f12 = f10;
                                    } else {
                                        l19 = (long)bl2;
                                        f10 = f12;
                                        n11 = 0;
                                        f13 = 0.0f;
                                        object5 = null;
                                    }
                                } else {
                                    l20 = l38;
                                    n11 = 0;
                                    f13 = 0.0f;
                                    object5 = null;
                                    bl2 = false;
                                    f12 = 0.0f;
                                    cameraSet$Theme = null;
                                    n10 = false;
                                    f11 = 0.0f;
                                    object = null;
                                }
                                l37 = l33 & l36;
                                l19 = l37 == l20 ? 0 : (l37 < l20 ? -1 : 1);
                                if (l19 == false) break block102;
                                l19 = n11;
                                f10 = f13;
                                object5 = CameraSet$Theme.PINK;
                                if (object5 != cameraSet$Theme2) break block103;
                                n11 = 1;
                                f13 = Float.MIN_VALUE;
                                break block104;
                            }
                            l19 = n11;
                            f10 = f13;
                        }
                        n11 = 0;
                        f13 = 0.0f;
                        object5 = null;
                    }
                    l18 = l33 & l27;
                    l17 = l18 == l20 ? 0 : (l18 < l20 ? -1 : 1);
                    if (l17 == false) break block105;
                    l17 = n11;
                    object5 = CameraSet$Theme.DEFAULT;
                    if (object5 != cameraSet$Theme2) break block106;
                    n11 = 1;
                    f13 = Float.MIN_VALUE;
                    break block107;
                }
                l17 = n11;
            }
            n11 = 0;
            f13 = 0.0f;
            object5 = null;
        }
        l28 = l33 & l24;
        n13 = (int)(l28 == l20 ? 0 : (l28 < l20 ? -1 : 1));
        if (n13 != 0) {
            if (!bl3) {
                l19 = 0;
                f10 = 0.0f;
            }
            if (bl4) {
                bl2 = true;
                f12 = Float.MIN_VALUE;
            }
            if (!bl3) {
                n10 = false;
                f11 = 0.0f;
                object = null;
            }
            n13 = (int)l19;
            f16 = f10;
        } else {
            bl2 = false;
            f12 = 0.0f;
            cameraSet$Theme = null;
            n10 = false;
            f11 = 0.0f;
            object = null;
            n13 = 0;
            f16 = 0.0f;
            cameraSet$Theme2 = null;
        }
        l28 = l33 & l25;
        l27 = 0L;
        l19 = l28 == l27 ? 0 : (l28 < l27 ? -1 : 1);
        if (l19 != false) {
            if (n12 == 0) {
                l22 = 0;
                object2 = null;
            }
            if (l19 != false) {
                l28 = l22 != false ? 0x100000000L : 0x80000000L;
                l33 |= l28;
            }
            if (l22 != false) {
                n12 = n15;
                f15 = f18;
            } else {
                n12 = n14;
                f15 = f17;
            }
        } else {
            n12 = 0;
            object3 = null;
            f15 = 0.0f;
            l22 = 0;
            object2 = null;
        }
        l28 = l33 & l23;
        l27 = 0L;
        l19 = l28 == l27 ? 0 : (l28 < l27 ? -1 : 1);
        if (l19 != false) {
            long l55;
            long l56;
            if (bl5) {
                n11 = 1;
                f13 = Float.MIN_VALUE;
            }
            if (l29 == false) {
                l17 = 0;
            }
            if (l29 == false) {
                n18 = 0;
                f19 = 0.0f;
                cameraSet$Theme3 = null;
            }
            if (l19 != false) {
                l28 = n11 != 0 ? 262144L : 131072L;
                l33 |= l28;
            }
            if ((l29 = (l56 = (l28 = l33 & l23) - (l27 = 0L)) == 0L ? 0 : (l56 < 0L ? -1 : 1)) != false) {
                l28 = l17 != false ? 0x100000L : 524288L;
                l33 |= l28;
            }
            if ((l29 = (l55 = (l28 = l33 & l23) - l27) == 0L ? 0 : (l55 < 0L ? -1 : 1)) != false) {
                l28 = n18 != 0 ? 0x40000000L : 0x20000000L;
                l33 |= l28;
            }
            l29 = n11 ^ 1;
            if (n11 != 0) {
                n15 = n14;
                f18 = f17;
            }
            n11 = 8;
            f13 = 1.1E-44f;
            if (l17 != false) {
                l19 = 0;
                f10 = 0.0f;
            } else {
                l19 = n11;
                f10 = f13;
            }
            if (n18 != 0) {
                n18 = 0;
                f19 = 0.0f;
                cameraSet$Theme3 = null;
            } else {
                n18 = n11;
                f19 = f13;
            }
            n11 = n18;
            f13 = f19;
            n18 = (int)l29;
            l29 = l19;
            l19 = n13;
            f10 = f16;
            n13 = n15;
            f16 = f18;
        } else {
            l19 = n13;
            f10 = f16;
            n13 = 0;
            cameraSet$Theme2 = null;
            f16 = 0.0f;
            n11 = 0;
            f13 = 0.0f;
            object5 = null;
            n18 = 0;
            f19 = 0.0f;
            cameraSet$Theme3 = null;
            l29 = 0;
            liveData = null;
        }
        l18 = l33 & l23;
        long l57 = 0L;
        l17 = l18 == l57 ? 0 : (l18 < l57 ? -1 : 1);
        boolean bl7 = n10;
        float f20 = f11;
        if (l17 != false) {
            w12.b.setEnabled(n18 != 0);
            object = w12.i;
            object.setVisibility(n11);
            object5 = w12.j;
            object5.setVisibility((int)l29);
            n11 = ViewDataBinding.getBuildSdkInt();
            n10 = 11 != 0;
            f11 = 1.5E-44f;
            if (n11 >= n10) {
                object5 = w12.x;
                object5.setAlpha(f16);
            }
        }
        if ((n11 = (int)((l16 = (l57 = l33 & l25) - (l15 = 0L)) == 0L ? 0 : (l16 < 0L ? -1 : 1))) != 0) {
            object5 = w12.c;
            object5.setEnabled((boolean)l22);
            n11 = ViewDataBinding.getBuildSdkInt();
            n10 = 11 != 0;
            f11 = 1.5E-44f;
            if (n11 >= n10) {
                object5 = w12.A;
                object5.setAlpha(f15);
            }
        }
        if ((n11 = (int)((l14 = (l30 = l33 & l21) - (l57 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0) {
            object5 = w12.c;
            object5.setOnClickListener((View.OnClickListener)object4);
        }
        if ((n11 = (int)((l13 = (l12 = 0x100L & l33) - l57) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0) {
            object5 = w12.y;
            object = w12.B;
            object5.setOnClickListener((View.OnClickListener)object);
            object5 = w12.h;
            object = n17;
            object5.setTag(object);
            object5 = w12.i;
            object = n16;
            object5.setTag(object);
            object5 = w12.j;
            object = (int)l31;
            object5.setTag(object);
        }
        if ((n11 = (int)((l11 = (l12 = l33 & l26) - (l32 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0) {
            n11 = ViewDataBinding.getBuildSdkInt();
            n10 = 11 != 0;
            f11 = 1.5E-44f;
            if (n11 >= n10) {
                object5 = w12.z;
                object5.setAlpha(f14);
            }
        }
        if ((n11 = (int)((l10 = (l33 &= l24) - l32) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            CompoundButtonBindingAdapter.setChecked((CompoundButton)w12.h, bl2);
            object5 = w12.i;
            n10 = bl7;
            f11 = f20;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)object5, bl7);
            object5 = w12.j;
            CompoundButtonBindingAdapter.setChecked((CompoundButton)object5, (boolean)l19);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.D;
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
            this.D = l10 = 256L;
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
                        return false;
                    }
                    object = (LiveData)object;
                    return this.H((LiveData)object, n11);
                }
                object = (LiveData)object;
                return this.I((LiveData)object, n11);
            }
            object = (LiveData)object;
            return this.G((LiveData)object, n11);
        }
        object = (LiveData)object;
        return this.J((LiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 112;
        if (n11 == n10) {
            object = (v6)object;
            this.F((v6)object);
            return 1 != 0;
        } else {
            n11 = 12;
            if (n11 == n10) {
                object = (BleViewModel)object;
                this.C((BleViewModel)object);
                return 1 != 0;
            } else {
                n11 = 15;
                if (n11 == n10) {
                    object = (u6)object;
                    this.D((u6)object);
                    return 1 != 0;
                } else {
                    n11 = 23;
                    if (n11 != n10) return 0 != 0;
                    object = (SetGeneralFragment$b)object;
                    this.E((SetGeneralFragment$b)object);
                }
            }
        }
        return 1 != 0;
    }
}

