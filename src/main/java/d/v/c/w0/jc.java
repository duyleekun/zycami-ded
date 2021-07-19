/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CompoundButton
 *  android.widget.RadioButton
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.api.entity.sticker.StickerTabInfo;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment$b;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.w0.ic;
import d.v.c.x0.b.s;
import l.a.q.g0.u;

public class jc
extends ic
implements b$a {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final RadioButton d;
    private final View.OnClickListener e;
    private long f;

    public jc(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 1, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private jc(DataBindingComponent object, View view, Object[] objectArray) {
        super(object, view, 2);
        this.f = -1;
        object = (RadioButton)objectArray[0];
        this.d = object;
        object.setTag(null);
        this.setRootTag(view);
        object = new b(this, 1);
        this.e = object;
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
                long l10 = this.f;
                long l11 = 1L;
                this.f = l10 |= l11;
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
    private boolean F(StickerTabInfo stickerTabInfo, int n10) {
        boolean bl2 = true;
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.f;
                long l11 = 2;
                this.f = l10 |= l11;
                return bl2;
            }
        }
        int n11 = 77;
        if (n10 == n11) {
            synchronized (this) {
                long l12 = this.f;
                long l13 = 16;
                this.f = l12 |= l13;
                return bl2;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(EditorStickerFragment$b editorStickerFragment$b) {
        this.c = editorStickerFragment$b;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 8;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void C(s s10) {
        this.a = s10;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 4;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(128);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(StickerTabInfo stickerTabInfo) {
        int n10 = 1;
        this.updateRegistration(n10, stickerTabInfo);
        this.b = stickerTabInfo;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 2;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(132);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        StickerTabInfo stickerTabInfo = this.b;
        EditorStickerFragment$b editorStickerFragment$b = this.c;
        boolean bl2 = true;
        boolean bl3 = editorStickerFragment$b != null ? bl2 : false;
        if (bl3) {
            if (stickerTabInfo == null) {
                bl2 = false;
            }
            if (bl2) {
                n10 = stickerTabInfo.getLabelIndex();
                editorStickerFragment$b.h(view, n10);
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
        long l13;
        long l14;
        jc jc2 = this;
        synchronized (this) {
            l14 = this.f;
            this.f = l13 = 0L;
        }
        Object object = this.a;
        int n11 = 0;
        float f10 = 0.0f;
        View.OnClickListener onClickListener = null;
        Object object2 = this.b;
        long l15 = 55;
        long l16 = l14 & l15;
        long l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
        long l18 = 34;
        int n12 = 0;
        if (l17 != false) {
            long l19;
            if (object != null) {
                object = ((s)object).c();
            } else {
                n10 = 0;
                object = null;
            }
            jc2.updateLiveDataRegistration(0, (LiveData)object);
            if (object2 != null) {
                n11 = ((StickerTabInfo)object2).getLabelIndex();
            } else {
                n11 = 0;
                onClickListener = null;
                f10 = 0.0f;
            }
            if (object != null) {
                object = (Integer)((LiveData)object).getValue();
            } else {
                n10 = 0;
                object = null;
            }
            n10 = ViewDataBinding.safeUnbox((Integer)object);
            if (n10 == n11) {
                n12 = n10 = 1;
            }
            if (l17 != false) {
                if (n12 != 0) {
                    l14 |= 0x80L;
                    l19 = 512L;
                } else {
                    l14 |= (long)64;
                    l19 = 256L;
                }
                l14 |= l19;
            }
            object = jc2.d;
            if (n12 != 0) {
                n11 = 2131099772;
                f10 = 1.7811907E38f;
            } else {
                n11 = 2131099781;
                f10 = 1.7811925E38f;
            }
            n10 = ViewDataBinding.getColorFromResource((View)object, n11);
            onClickListener = jc2.d.getResources();
            l17 = n12 != 0 ? (long)2131165275 : (long)2131165277;
            f10 = onClickListener.getDimension((int)l17);
            l19 = l14 & l18;
            l17 = l19 == l13 ? 0 : (l19 < l13 ? -1 : 1);
            object2 = l17 != false && object2 != null ? ((StickerTabInfo)object2).showLabel() : null;
        } else {
            object2 = null;
            n10 = 0;
            object = null;
        }
        long l20 = (l12 = (l15 &= l14) - l13) == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (l20 != false) {
            CompoundButtonBindingAdapter.setChecked((CompoundButton)jc2.d, n12 != 0);
            RadioButton radioButton = jc2.d;
            radioButton.setTextColor(n10);
            object = jc2.d;
            TextViewBindingAdapter.setTextSize((TextView)object, f10);
        }
        if ((n10 = (l11 = (l15 = (long)32 & l14) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != 0) {
            object = jc2.d;
            onClickListener = jc2.e;
            object.setOnClickListener(onClickListener);
        }
        if ((n10 = (int)((l10 = (l14 &= l18) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            object = jc2.d;
            u.n((TextView)object, (String)object2, null, null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.f;
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
            this.f = l10 = (long)32;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (StickerTabInfo)object;
            return this.F((StickerTabInfo)object, n11);
        }
        object = (MutableLiveData)object;
        return this.E((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 128;
        if (n11 == n10) {
            object = (s)object;
            this.C((s)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 == n10) {
                object = (EditorStickerFragment$b)object;
                this.B((EditorStickerFragment$b)object);
                return 1 != 0;
            } else {
                n11 = 132;
                if (n11 != n10) return 0 != 0;
                object = (StickerTabInfo)object;
                this.D((StickerTabInfo)object);
            }
        }
        return 1 != 0;
    }
}

