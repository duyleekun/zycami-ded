/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.SeekBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.databinding.adapters.SeekBarBindingAdapter$OnProgressChanged;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.widget.NoOffsetSeekBar;
import d.v.c.f1.a.g$a;
import d.v.c.w0.d8;
import d.v.c.x0.c.c.d$a;
import d.v.c.x0.c.c.f;
import l.a.q.g0.u;

public class e8
extends d8
implements g$a {
    private static final ViewDataBinding$IncludedLayouts k;
    private static final SparseIntArray l;
    private final ConstraintLayout h;
    private final SeekBarBindingAdapter$OnProgressChanged i;
    private long j;

    static {
        SparseIntArray sparseIntArray;
        l = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362190, 3);
        sparseIntArray.put(2131363523, 4);
        sparseIntArray.put(2131363068, 5);
    }

    public e8(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = k;
        SparseIntArray sparseIntArray = l;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 6, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private e8(DataBindingComponent object, View view, Object[] objectArray) {
        Object object2;
        Object object3;
        Object object4 = object3 = objectArray[3];
        object4 = (ConstraintLayout)((Object)object3);
        Object object5 = object3 = objectArray[5];
        object5 = (RecyclerView)object3;
        int n10 = 1;
        Object object6 = object2 = objectArray[n10];
        object6 = (NoOffsetSeekBar)((Object)object2);
        Object object7 = object2 = objectArray[2];
        object7 = (TextView)object2;
        Object object8 = object2 = objectArray[4];
        object8 = (TextView)object2;
        object2 = this;
        super(object, view, 1, (ConstraintLayout)((Object)object4), (RecyclerView)object5, (NoOffsetSeekBar)((Object)object6), (TextView)object7, (TextView)object8);
        this.j = -1;
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.h = object;
        object.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.setRootTag(view);
        super(this, n10);
        this.i = object;
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
    public void A(d$a d$a) {
        this.f = d$a;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 2;
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
    public void B(f f10) {
        this.g = f10;
        synchronized (this) {
            long l10 = this.j;
            long l11 = 4;
            this.j = l10 |= l11;
        }
        this.notifyPropertyChanged(27);
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
        long l14;
        synchronized (this) {
            l14 = this.j;
            this.j = l13 = 0L;
        }
        Object object = this.g;
        long l15 = (long)13 & l14;
        long l16 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1);
        int n10 = 0;
        if (l16 != false) {
            object = object != null ? ((f)object).j() : null;
            this.updateLiveDataRegistration(0, (LiveData)object);
            object = object != null ? (Integer)((LiveData)object).getValue() : null;
            n10 = ViewDataBinding.safeUnbox((Integer)object);
            object = String.valueOf(n10);
        } else {
            object = null;
        }
        if (l16 != false) {
            SeekBarBindingAdapter.setProgress(this.c, n10);
            TextView textView = this.d;
            u.n(textView, (String)object, null, null);
        }
        if ((l12 = (l11 = (l14 &= (l10 = (long)8)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            NoOffsetSeekBar noOffsetSeekBar = this.c;
            SeekBarBindingAdapter$OnProgressChanged seekBarBindingAdapter$OnProgressChanged = this.i;
            SeekBarBindingAdapter.setOnSeekBarChangeListener(noOffsetSeekBar, null, null, seekBarBindingAdapter$OnProgressChanged, null);
        }
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
            this.j = l10 = (long)8;
        }
        this.requestRebind();
    }

    public final void n(int n10, SeekBar seekBar, int n11, boolean bl2) {
        d$a d$a = this.f;
        boolean bl3 = d$a != null;
        if (bl3) {
            d$a.h(seekBar, n11, bl2);
        }
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
        int n11 = 25;
        if (n11 == n10) {
            object = (d$a)object;
            this.A((d$a)object);
            return 1 != 0;
        } else {
            n11 = 27;
            if (n11 != n10) return 0 != 0;
            object = (f)object;
            this.B((f)object);
        }
        return 1 != 0;
    }
}

