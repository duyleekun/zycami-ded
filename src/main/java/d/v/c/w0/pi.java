/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import com.zhiyun.cama.publish.VideoCropFragment$c;
import com.zhiyun.cama.widget.ThumbnailView;
import com.zhiyun.zyplayer.ExoVideoView;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.s0.a7.j1;
import d.v.c.w0.oi;
import d.v.e.l.m1;
import l.a.q.g0.u;

public class pi
extends oi
implements b$a {
    private static final ViewDataBinding$IncludedLayouts w;
    private static final SparseIntArray x;
    private final ConstraintLayout p;
    private final View q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private final View.OnClickListener t;
    private final View.OnClickListener u;
    private long v;

    static {
        SparseIntArray sparseIntArray;
        x = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131363669, 10);
        sparseIntArray.put(2131363664, 11);
        sparseIntArray.put(2131363317, 12);
    }

    public pi(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = w;
        SparseIntArray sparseIntArray = x;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 13, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private pi(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[9];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[1];
        object3 = (TextView)object;
        Object object4 = object = objectArray[8];
        object4 = (TextView)object;
        Object object5 = object = objectArray[6];
        object5 = (ProgressBar)object;
        Object object6 = object = objectArray[4];
        object6 = (ImageView)object;
        Object object7 = object = objectArray[12];
        object7 = (ThumbnailView)object;
        Object object8 = object = objectArray[3];
        object8 = (TextView)object;
        Object object9 = object = objectArray[7];
        object9 = (TextView)object;
        Object object10 = object = objectArray[2];
        object10 = (ExoVideoView)object;
        Object object11 = object = objectArray[11];
        object11 = (TextView)object;
        Object object12 = object = objectArray[10];
        object12 = (ProgressBar)object;
        object = this;
        int n10 = 2;
        super(dataBindingComponent, view, n10, (ImageView)object2, (TextView)object3, (TextView)object4, (ProgressBar)object5, (ImageView)object6, (ThumbnailView)object7, (TextView)object8, (TextView)object9, (ExoVideoView)object10, (TextView)object11, (ProgressBar)object12);
        this.v = -1;
        this.a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.p = object;
        object.setTag(null);
        object = (View)objectArray[5];
        this.q = object;
        object.setTag(null);
        this.e.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, 3);
        this.r = object;
        object = new b(this, 1);
        this.s = object;
        object = new b(this, 2);
        this.t = object;
        object = new b(this, 4);
        this.u = object;
        this.invalidateAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean G(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.v;
                long l11 = 2;
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
    private boolean H(ObservableBoolean observableBoolean, int n10) {
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
    public void C(VideoCropFragment$c videoCropFragment$c) {
        this.o = videoCropFragment$c;
        synchronized (this) {
            long l10 = this.v;
            long l11 = 16;
            this.v = l10 |= l11;
        }
        this.notifyPropertyChanged(23);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(UploadCEMediaInfo uploadCEMediaInfo) {
        this.l = uploadCEMediaInfo;
        synchronized (this) {
            long l10 = this.v;
            long l11 = 4;
            this.v = l10 |= l11;
        }
        this.notifyPropertyChanged(83);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(j1 j12) {
        this.n = j12;
        synchronized (this) {
            long l10 = this.v;
            long l11 = 8;
            this.v = l10 |= l11;
        }
        this.notifyPropertyChanged(110);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(ObservableBoolean observableBoolean) {
        this.updateRegistration(0, observableBoolean);
        this.m = observableBoolean;
        synchronized (this) {
            long l10 = this.v;
            long l11 = 1L;
            this.v = l10 |= l11;
        }
        this.notifyPropertyChanged(122);
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
                        VideoCropFragment$c videoCropFragment$c = this.o;
                        if (videoCropFragment$c != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            videoCropFragment$c.a();
                        }
                    }
                } else {
                    VideoCropFragment$c videoCropFragment$c = this.o;
                    if (videoCropFragment$c != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        videoCropFragment$c.d();
                    }
                }
            } else {
                VideoCropFragment$c videoCropFragment$c = this.o;
                if (videoCropFragment$c != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    videoCropFragment$c.c();
                }
            }
        } else {
            VideoCropFragment$c videoCropFragment$c = this.o;
            if (videoCropFragment$c != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                videoCropFragment$c.b();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        View.OnClickListener onClickListener;
        String string2;
        long l10;
        long l11;
        long l12;
        boolean bl2;
        long l13;
        long l14;
        pi pi2 = this;
        synchronized (this) {
            l14 = this.v;
            this.v = l13 = 0L;
        }
        ObservableBoolean observableBoolean = this.m;
        Object object = this.l;
        Object object2 = this.n;
        long l15 = 33;
        long l16 = l14 & l15;
        long l17 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1);
        int n10 = 1;
        int n11 = 0;
        if (l17 != false) {
            if (observableBoolean != null) {
                bl2 = observableBoolean.get();
            } else {
                bl2 = false;
                observableBoolean = null;
            }
            if (l17 != false) {
                l12 = bl2 ? 128L : (long)64;
                l14 |= l12;
            }
            l17 = bl2 ? (long)0 : (long)8;
            bl2 ^= n10;
        } else {
            bl2 = false;
            observableBoolean = null;
            l17 = 0;
        }
        l12 = (long)36 & l14;
        long l18 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l18 != false) {
            float f10;
            int n12;
            if (object != null) {
                n12 = ((UploadCEMediaInfo)object).b();
            } else {
                n12 = 0;
                object = null;
                f10 = 0.0f;
            }
            f10 = n12;
            n12 = Math.round(f10);
            object = m1.D(n12);
        } else {
            boolean bl3 = false;
            float f11 = 0.0f;
            object = null;
        }
        long l19 = (long)42 & l14;
        long l20 = l19 == l13 ? 0 : (l19 < l13 ? -1 : 1);
        if (l20 != false) {
            object2 = object2 != null ? ((j1)object2).b : null;
            pi2.updateLiveDataRegistration(n10, (LiveData)object2);
            object2 = object2 != null ? (Integer)((LiveData)object2).getValue() : null;
            n11 = ViewDataBinding.safeUnbox((Integer)object2);
        } else {
            object2 = null;
        }
        long l21 = l14 & (long)32;
        n10 = (int)(l21 == l13 ? 0 : (l21 < l13 ? -1 : 1));
        if (n10 != 0) {
            Object object3 = pi2.a;
            View.OnClickListener onClickListener2 = pi2.u;
            object3.setOnClickListener(onClickListener2);
            object3 = pi2.b;
            onClickListener2 = pi2.s;
            object3.setOnClickListener(onClickListener2);
            object3 = pi2.i;
            onClickListener2 = pi2.t;
            object3.setOnClickListener(onClickListener2);
        }
        if ((l11 = (l10 = (l14 &= l15) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            pi2.b.setEnabled(bl2);
            pi2.c.setVisibility((int)l17);
            pi2.d.setVisibility((int)l17);
            pi2.q.setVisibility((int)l17);
            string2 = pi2.e;
            onClickListener = pi2.r;
            ViewBindingAdapter.setOnClick((View)string2, onClickListener, bl2);
            observableBoolean = pi2.h;
            observableBoolean.setVisibility((int)l17);
        }
        if (l20 != false) {
            pi2.d.setProgress(n11);
            observableBoolean = pi2.h;
            string2 = "@string/media_composing_with_progress";
            onClickListener = null;
            l.a.q.g0.u.n((TextView)observableBoolean, string2, object2, null);
        } else {
            onClickListener = null;
        }
        if (l18 != false) {
            observableBoolean = pi2.g;
            l.a.q.g0.u.n((TextView)observableBoolean, (String)object, null, null);
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
            this.v = l10 = (long)32;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                return false;
            }
            object = (MutableLiveData)object;
            return this.G((MutableLiveData)object, n11);
        }
        object = (ObservableBoolean)object;
        return this.H((ObservableBoolean)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 122;
        if (n11 == n10) {
            object = (ObservableBoolean)object;
            this.F((ObservableBoolean)object);
            return 1 != 0;
        } else {
            n11 = 83;
            if (n11 == n10) {
                object = (UploadCEMediaInfo)object;
                this.D((UploadCEMediaInfo)object);
                return 1 != 0;
            } else {
                n11 = 110;
                if (n11 == n10) {
                    object = (j1)object;
                    this.E((j1)object);
                    return 1 != 0;
                } else {
                    n11 = 23;
                    if (n11 != n10) return 0 != 0;
                    object = (VideoCropFragment$c)object;
                    this.C((VideoCropFragment$c)object);
                }
            }
        }
        return 1 != 0;
    }
}

