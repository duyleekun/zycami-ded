/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageButton
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.voice.music.EditorAudioBeatFragment$c;
import com.zhiyun.cama.widget.AudioBeatView;
import com.zhiyun.cama.widget.ZYTextView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.i1.i2;
import d.v.c.q0.f.a;
import d.v.c.w0.j4;
import d.v.c.w0.r8;
import d.v.c.y1.f.o;
import d.v.e.l.l2;
import java.util.List;
import l.a.q.g0.u;

public class s8
extends r8
implements b$a {
    private static final ViewDataBinding$IncludedLayouts s;
    private static final SparseIntArray t;
    private final ConstraintLayout m;
    private final View.OnClickListener n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private long r;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        s = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(10);
        String[] stringArray = new String[]{"editor_bottom_choice_layout"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 8;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        viewDataBinding$IncludedLayouts = new SparseIntArray();
        t = viewDataBinding$IncludedLayouts;
        viewDataBinding$IncludedLayouts.put(2131363695, 9);
    }

    public s8(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = s;
        SparseIntArray sparseIntArray = t;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 10, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private s8(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[4];
        object2 = (AudioBeatView)((Object)object);
        Object object3 = object = objectArray[8];
        object3 = (j4)object;
        Object object4 = object = objectArray[6];
        object4 = (ImageButton)object;
        Object object5 = object = objectArray[7];
        object5 = (ImageButton)object;
        Object object6 = object = objectArray[5];
        object6 = (ImageButton)object;
        Object object7 = object = objectArray[2];
        object7 = (ZYTextView)object;
        int n10 = 1;
        Object object8 = object = objectArray[n10];
        object8 = (TextView)object;
        int n11 = 3;
        Object object9 = object = objectArray[n11];
        object9 = (ZYTextView)object;
        Object object10 = object = objectArray[9];
        object10 = (View)object;
        object = this;
        super(dataBindingComponent, view, 4, (AudioBeatView)((Object)object2), (j4)object3, (ImageButton)object4, (ImageButton)object5, (ImageButton)object6, (ZYTextView)object7, (TextView)object8, (ZYTextView)object9, (View)object10);
        this.r = -1;
        this.a.setTag(null);
        object = this.b;
        this.setContainedBinding((ViewDataBinding)object);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.m = object;
        object.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, n11);
        this.n = object;
        object = new b(this, n10);
        this.o = object;
        object = new b(this, 4);
        this.p = object;
        object = new b(this, 2);
        this.q = object;
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
                long l10 = this.r;
                long l11 = 2;
                this.r = l10 |= l11;
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
    private boolean F(j4 j42, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.r;
                long l11 = 4;
                this.r = l10 |= l11;
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
                long l10 = this.r;
                long l11 = 1L;
                this.r = l10 |= l11;
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
                long l10 = this.r;
                long l11 = 8;
                this.r = l10 |= l11;
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
    public void B(o o10) {
        this.k = o10;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 64;
            this.r = l10 |= l11;
        }
        this.notifyPropertyChanged(5);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(EditorAudioBeatFragment$c editorAudioBeatFragment$c) {
        this.j = editorAudioBeatFragment$c;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 16;
            this.r = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(i2 i22) {
        this.l = i22;
        synchronized (this) {
            long l10 = this.r;
            long l11 = 32;
            this.r = l10 |= l11;
        }
        this.notifyPropertyChanged(49);
        super.requestRebind();
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
                    if (n10 == n13) {
                        EditorAudioBeatFragment$c editorAudioBeatFragment$c = this.j;
                        if (editorAudioBeatFragment$c != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            n11 = 100000;
                            editorAudioBeatFragment$c.h(n11);
                        }
                    }
                } else {
                    EditorAudioBeatFragment$c editorAudioBeatFragment$c = this.j;
                    if (editorAudioBeatFragment$c != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        editorAudioBeatFragment$c.i();
                    }
                }
            } else {
                EditorAudioBeatFragment$c editorAudioBeatFragment$c = this.j;
                if (editorAudioBeatFragment$c != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    n11 = -100000;
                    editorAudioBeatFragment$c.h(n11);
                }
            }
        } else {
            EditorAudioBeatFragment$c editorAudioBeatFragment$c = this.j;
            if (editorAudioBeatFragment$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                editorAudioBeatFragment$c.j();
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        var1_1 = this;
        synchronized (this) {
            var2_2 = this.r;
            this.r = var4_3 = 0L;
        }
        var6_4 = this.j;
        var7_5 = this.l;
        var8_6 = this.k;
        var9_7 = 144L & var2_2;
        var11_8 = var9_7 == var4_3 ? 0 : (var9_7 < var4_3 ? -1 : 1);
        var12_9 = 169L & var2_2;
        var14_10 /* !! */  = var12_9 == var4_3 ? 0 : (var12_9 < var4_3 ? -1 : 1);
        var15_11 = 168L;
        var17_12 = 161L;
        if (var14_10 /* !! */  != false) {
            var19_13 = var2_2 & var17_12;
            cfr_temp_0 = var19_13 - var4_3;
            var14_10 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var14_10 /* !! */  != false) {
                if (var7_5 != null) {
                    var21_14 = var7_5.T0();
                } else {
                    var14_10 /* !! */  = 0;
                    var21_14 = null;
                }
                var22_15 = 0;
                var23_16 = null;
                var1_1.updateLiveDataRegistration(0, (LiveData)var21_14);
                if (var21_14 != null) {
                    var21_14 = (Long)var21_14.getValue();
                } else {
                    var14_10 /* !! */  = 0;
                    var21_14 = null;
                }
                var19_13 = ViewDataBinding.safeUnbox((Long)var21_14);
                var21_14 = l2.e(var19_13);
                var23_16 = new StringBuilder();
                var23_16.append((String)var21_14);
                var23_16.append(" / ");
                var21_14 = var23_16.toString();
            } else {
                var14_10 /* !! */  = 0;
                var21_14 = null;
            }
            var19_13 = var2_2 & var15_11;
            var22_15 = var19_13 == var4_3 ? 0 : (var19_13 < var4_3 ? -1 : 1);
            if (var22_15 != false) {
                var7_5 = var7_5 != null ? var7_5.c2() : null;
                var22_15 = 3;
                var1_1.updateLiveDataRegistration((int)var22_15, (LiveData)var7_5);
                var7_5 = var7_5 != null ? (Long)var7_5.getValue() : null;
                var19_13 = ViewDataBinding.safeUnbox((Long)var7_5);
                var7_5 = l2.e(var19_13);
            } else {
                var7_5 = null;
            }
        } else {
            var7_5 = null;
            var14_10 /* !! */  = 0;
            var21_14 = null;
        }
        var19_13 = 194L & var2_2;
        var22_15 = var19_13 == var4_3 ? 0 : (var19_13 < var4_3 ? -1 : 1);
        if (var22_15 == false) ** GOTO lbl-1000
        var8_6 = var8_6 != null ? var8_6.j() : null;
        var24_17 = 1;
        var1_1.updateLiveDataRegistration(var24_17, (LiveData)var8_6);
        if (var8_6 != null) {
            var8_6 = (List)var8_6.getValue();
        } else lbl-1000:
        // 2 sources

        {
            var8_6 = null;
        }
        if (var22_15 != false) {
            var25_18 = var1_1.a;
            var25_18.setDataList((List)var8_6);
        }
        if (var11_8 != false) {
            var8_6 = var1_1.b;
            var8_6.z((a)var6_4);
        }
        if ((var28_20 = (cfr_temp_1 = (var26_19 = 128L & var2_2) - var4_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.c;
            var8_6 = var1_1.n;
            var6_4.setOnClickListener((View.OnClickListener)var8_6);
            var6_4 = var1_1.d;
            var8_6 = var1_1.p;
            var6_4.setOnClickListener((View.OnClickListener)var8_6);
            var6_4 = var1_1.e;
            var8_6 = var1_1.q;
            var6_4.setOnClickListener((View.OnClickListener)var8_6);
            var6_4 = var1_1.g;
            var8_6 = var1_1.o;
            var6_4.setOnClickListener((View.OnClickListener)var8_6);
        }
        if ((var28_20 = (cfr_temp_2 = (var26_19 = var2_2 & var17_12) - var4_3) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.f;
            u.n((TextView)var6_4, (String)var21_14, null, null);
        }
        if ((var28_20 = (cfr_temp_3 = (var2_2 &= (var26_19 = 168L)) - var4_3) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) {
            var6_4 = var1_1.h;
            u.n((TextView)var6_4, (String)var7_5, null, null);
        }
        ViewDataBinding.executeBindingsOn(var1_1.b);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.r;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            j4 j42 = this.b;
            l12 = (long)j42.hasPendingBindings();
            if (l12 != false) {
                return bl2;
            }
            return false;
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
            this.r = l10 = 128L;
        }
        this.b.invalidateAll();
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
                    object = (MutableLiveData)object;
                    return this.H((MutableLiveData)object, n11);
                }
                object = (j4)object;
                return this.F((j4)object, n11);
            }
            object = (MutableLiveData)object;
            return this.E((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.G((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.b.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 25;
        if (n11 == n10) {
            object = (EditorAudioBeatFragment$c)object;
            this.C((EditorAudioBeatFragment$c)object);
            return 1 != 0;
        } else {
            n11 = 49;
            if (n11 == n10) {
                object = (i2)object;
                this.D((i2)object);
                return 1 != 0;
            } else {
                n11 = 5;
                if (n11 != n10) return 0 != 0;
                object = (o)object;
                this.B((o)object);
            }
        }
        return 1 != 0;
    }
}

