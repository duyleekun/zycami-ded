/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.cama.data.database.model.music.AlbumData;
import d.v.c.w0.sb;
import d.v.l.g.a;
import l.a.q.g0.u;

public class tb
extends sb {
    private static final ViewDataBinding$IncludedLayouts g;
    private static final SparseIntArray h;
    private final ConstraintLayout c;
    private final TextView d;
    private final TextView e;
    private long f;

    public tb(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = g;
        SparseIntArray sparseIntArray = h;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 4, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private tb(DataBindingComponent object, View view, Object[] objectArray) {
        ImageView imageView = (ImageView)objectArray[1];
        super(object, view, 0, imageView);
        this.f = -1;
        this.a.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.c = object;
        object.setTag(null);
        object = (TextView)objectArray[2];
        this.d = object;
        object.setTag(null);
        object = (TextView)objectArray[3];
        this.e = object;
        object.setTag(null);
        this.setRootTag(view);
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        String string2;
        String string3;
        String string4;
        long l10;
        synchronized (this) {
            long l11 = this.f;
            this.f = l10 = 0L;
        }
        int n10 = 0;
        String string5 = null;
        AlbumData albumData = this.b;
        long l12 = 3;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (l14 != false) {
            if (albumData != null) {
                string4 = albumData.showLabel();
                n10 = albumData.getSongCount();
                string3 = albumData.getCoverUrl();
            } else {
                string4 = null;
                string3 = null;
            }
            string2 = String.valueOf(n10);
            string5 = string3;
        } else {
            string4 = null;
            n10 = 0;
            string5 = null;
            string2 = null;
        }
        if (l14 != false) {
            string3 = this.a;
            albumData = null;
            Context context = string3.getContext();
            int n11 = 2131231799;
            Drawable drawable2 = AppCompatResources.getDrawable(context, n11);
            int n12 = 14;
            boolean bl2 = true;
            d.v.l.g.a.b((ImageView)string3, string5, null, drawable2, n12, bl2, false, null, null, null);
            u.n(this.d, string4, null, null);
            context = this.e;
            u.n((TextView)context, string2, null, null);
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
            this.f = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = 3;
        if (n11 == n10) {
            object = (AlbumData)object;
            this.z((AlbumData)object);
            n10 = 1;
        } else {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void z(AlbumData albumData) {
        this.b = albumData;
        synchronized (this) {
            long l10 = this.f;
            long l11 = 1L;
            this.f = l10 |= l11;
        }
        this.notifyPropertyChanged(3);
        super.requestRebind();
    }
}

