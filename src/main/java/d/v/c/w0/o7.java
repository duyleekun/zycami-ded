/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.SeekBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter$OnProgressChanged;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.voice.record.volume.EditorRecordVolumeFragment$a;
import com.zhiyun.cama.widget.NoOffsetSeekBar;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.g;
import d.v.c.f1.a.g$a;
import d.v.c.w0.j4;
import d.v.c.w0.n7;
import d.v.c.y1.g.n.b;
import l.a.q.g0.u;

public class o7
extends n7
implements g$a,
b$a {
    private static final ViewDataBinding$IncludedLayouts k;
    private static final SparseIntArray l;
    private final ConstraintLayout g;
    private final SeekBarBindingAdapter$OnProgressChanged h;
    private final View.OnClickListener i;
    private long j;

    static {
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts;
        k = viewDataBinding$IncludedLayouts = new ViewDataBinding$IncludedLayouts(5);
        String[] stringArray = new String[]{"editor_bottom_choice_layout"};
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 4;
        int[] nArray2 = new int[n10];
        nArray2[0] = 2131558529;
        viewDataBinding$IncludedLayouts.setIncludes(0, stringArray, nArray, nArray2);
        l = null;
    }

    public o7(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = k;
        SparseIntArray sparseIntArray = l;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 5, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private o7(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[4];
        object4 = (j4)object3;
        int n10 = 2;
        Object object5 = object2 = objectArray[n10];
        object5 = (NoOffsetSeekBar)((Object)object2);
        Object object6 = object2 = objectArray[3];
        object6 = (TextView)object2;
        int n11 = 1;
        Object object7 = object2 = objectArray[n11];
        object7 = (CheckBox)object2;
        object2 = this;
        super(object, view, 2, (j4)object4, (NoOffsetSeekBar)((Object)object5), (TextView)object6, (CheckBox)object7);
        this.j = -1;
        object = this.a;
        this.setContainedBinding((ViewDataBinding)object);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.g = object;
        object.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.setRootTag(view);
        object = new g(this, n10);
        this.h = object;
        object = new d.v.c.f1.a.b(this, n11);
        this.i = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean C(j4 j42, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.j;
                long l11 = 2;
                this.j = l10 |= l11;
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
                long l10 = this.j;
                long l11 = 1L;
                this.j = l10 |= l11;
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
    public void A(EditorRecordVolumeFragment$a editorRecordVolumeFragment$a) {
        this.f = editorRecordVolumeFragment$a;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 8;
            this.j = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B(b b10) {
        this.e = b10;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 4;
            this.j = l10 |= l11;
        }
        this.notifyPropertyChanged(155);
        super.requestRebind();
    }

    public final void a(int n10, View view) {
        EditorRecordVolumeFragment$a editorRecordVolumeFragment$a = this.f;
        boolean bl2 = editorRecordVolumeFragment$a != null;
        if (bl2) {
            editorRecordVolumeFragment$a.i();
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
        String string2;
        boolean bl2;
        long l13;
        int n10;
        long l14;
        long l15;
        synchronized (this) {
            l15 = this.j;
            this.j = l14 = 0L;
        }
        Object object = this.e;
        EditorRecordVolumeFragment$a editorRecordVolumeFragment$a = this.f;
        long l16 = (long)21 & l15;
        long l17 = l16 == l14 ? 0 : (l16 < l14 ? -1 : 1);
        int n11 = 0;
        float f10 = 0.0f;
        if (l17 != false) {
            float f11;
            if (object != null) {
                object = ((b)object).b();
            } else {
                n10 = 0;
                object = null;
                f11 = 0.0f;
            }
            this.updateLiveDataRegistration(0, (LiveData)object);
            if (object != null) {
                object = (Float)((LiveData)object).getValue();
            } else {
                n10 = 0;
                object = null;
                f11 = 0.0f;
            }
            f11 = ViewDataBinding.safeUnbox((Float)object) * 100.0f;
            n10 = (int)f11;
            l13 = 1;
            float f12 = Float.MIN_VALUE;
            bl2 = n10 != 0 ? l13 : false;
            string2 = String.valueOf(n10);
            if (n10 == 0) {
                n11 = (int)l13;
                f10 = f12;
            }
            int n12 = n11;
            n11 = n10;
            n10 = n12;
            f11 = f10;
        } else {
            n10 = 0;
            object = null;
            float f13 = 0.0f;
            bl2 = false;
            string2 = null;
        }
        long l18 = (long)24 & l15;
        l13 = l18 == l14 ? 0 : (l18 < l14 ? -1 : 1);
        if (l13 != false) {
            j4 j42 = this.a;
            j42.z(editorRecordVolumeFragment$a);
        }
        if (l17 != false) {
            SeekBarBindingAdapter.setProgress(this.b, n11);
            u.n(this.c, string2, null, null);
            CompoundButtonBindingAdapter.setChecked((CompoundButton)this.d, n10 != 0);
            object = this.d;
            editorRecordVolumeFragment$a = this.i;
            ViewBindingAdapter.setOnClick((View)object, (View.OnClickListener)editorRecordVolumeFragment$a, bl2);
        }
        if ((l12 = (l11 = (l15 &= (l10 = (long)16)) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            NoOffsetSeekBar noOffsetSeekBar = this.b;
            SeekBarBindingAdapter$OnProgressChanged seekBarBindingAdapter$OnProgressChanged = this.h;
            SeekBarBindingAdapter.setOnSeekBarChangeListener(noOffsetSeekBar, null, null, seekBarBindingAdapter$OnProgressChanged, null);
        }
        ViewDataBinding.executeBindingsOn(this.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.j;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            if (l12 != false) {
                return bl2;
            }
            j4 j42 = this.a;
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
            this.j = l10 = (long)16;
        }
        this.a.invalidateAll();
        this.requestRebind();
    }

    public final void n(int n10, SeekBar seekBar, int n11, boolean bl2) {
        EditorRecordVolumeFragment$a editorRecordVolumeFragment$a = this.f;
        boolean bl3 = editorRecordVolumeFragment$a != null;
        if (bl3) {
            editorRecordVolumeFragment$a.h(seekBar, n11, bl2);
        }
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (j4)object;
            return this.C((j4)object, n11);
        }
        object = (MutableLiveData)object;
        return this.D((MutableLiveData)object, n11);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.a.setLifecycleOwner(lifecycleOwner);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 155;
        if (n11 == n10) {
            object = (b)object;
            this.B((b)object);
            return 1 != 0;
        } else {
            n11 = 25;
            if (n11 != n10) return 0 != 0;
            object = (EditorRecordVolumeFragment$a)object;
            this.A((EditorRecordVolumeFragment$a)object);
        }
        return 1 != 0;
    }
}

