/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.FrameLayout
 *  android.widget.HorizontalScrollView
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.adapters.Converters;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment$b;
import com.zhiyun.cama.widget.MediaConstrainLayout;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.c.f1.a.b;
import d.v.c.f1.a.b$a;
import d.v.c.f1.a.l;
import d.v.c.f1.a.l$a;
import d.v.c.f1.a.p;
import d.v.c.f1.a.p$a;
import d.v.c.k1.a.w;
import d.v.c.r0.c;
import d.v.c.r0.c$b;
import d.v.c.r0.c$c;
import d.v.c.w0.v6;
import d.v.f.e.a;

public class w6
extends v6
implements b$a,
l$a,
p$a {
    private static final ViewDataBinding$IncludedLayouts D;
    private static final SparseIntArray E;
    private final View.OnClickListener A;
    private final View.OnClickListener B;
    private long C;
    private final ImageView t;
    private final View.OnClickListener u;
    private final View.OnClickListener v;
    private final View.OnClickListener w;
    private final View.OnClickListener x;
    private final c$b y;
    private final c$c z;

    static {
        SparseIntArray sparseIntArray;
        E = sparseIntArray = new SparseIntArray();
        sparseIntArray.put(2131362844, 13);
        sparseIntArray.put(2131362046, 14);
        sparseIntArray.put(2131363077, 15);
    }

    public w6(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = D;
        SparseIntArray sparseIntArray = E;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 16, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private w6(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object = this;
        Barrier barrier = (Barrier)((Object)objectArray[14]);
        FrameLayout frameLayout = (FrameLayout)objectArray[9];
        FrameLayout frameLayout2 = (FrameLayout)objectArray[11];
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView)objectArray[2];
        ImageView imageView = (ImageView)objectArray[1];
        LinearLayout linearLayout = (LinearLayout)objectArray[13];
        RecyclerView recyclerView = (RecyclerView)objectArray[10];
        RecyclerView recyclerView2 = (RecyclerView)objectArray[15];
        MediaConstrainLayout mediaConstrainLayout = (MediaConstrainLayout)((Object)objectArray[0]);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)objectArray[8];
        StatusView statusView = (StatusView)((Object)objectArray[7]);
        TextView textView = (TextView)objectArray[3];
        TextView textView2 = (TextView)objectArray[6];
        TextView textView3 = (TextView)objectArray[5];
        TextView textView4 = (TextView)objectArray[4];
        int n10 = 4;
        super(dataBindingComponent, view, n10, barrier, frameLayout, frameLayout2, horizontalScrollView, imageView, linearLayout, recyclerView, recyclerView2, mediaConstrainLayout, swipeRefreshLayout, statusView, textView, textView2, textView3, textView4);
        this.C = -1;
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        object = (ImageView)objectArray[12];
        this.t = object;
        object.setTag(null);
        this.g.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        object = view;
        this.setRootTag(view);
        object = new b(this, 3);
        this.u = object;
        object = new b(this, 7);
        this.v = object;
        object = new b(this, 8);
        this.w = object;
        object = new b(this, 4);
        this.x = object;
        this.y = object = new l(this, 1);
        this.z = object = new p(this, 2);
        object = new b(this, 6);
        this.A = object;
        object = new b(this, 5);
        this.B = object;
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
                long l10 = this.C;
                long l11 = 8;
                this.C = l10 |= l11;
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
    private boolean H(ObservableList observableList, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.C;
                long l11 = 4;
                this.C = l10 |= l11;
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
                long l10 = this.C;
                long l11 = 2;
                this.C = l10 |= l11;
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
    private boolean J(MutableLiveData mutableLiveData, int n10) {
        if (n10 == 0) {
            synchronized (this) {
                long l10 = this.C;
                long l11 = 1L;
                this.C = l10 |= l11;
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
    public void C(AddVideoFragment$b addVideoFragment$b) {
        this.p = addVideoFragment$b;
        synchronized (this) {
            long l10 = this.C;
            long l11 = 128L;
            this.C = l10 |= l11;
        }
        this.notifyPropertyChanged(25);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void D(Integer n10) {
        this.r = n10;
        synchronized (this) {
            long l10 = this.C;
            long l11 = 32;
            this.C = l10 |= l11;
        }
        this.notifyPropertyChanged(62);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void E(w w10) {
        this.q = w10;
        synchronized (this) {
            long l10 = this.C;
            long l11 = 16;
            this.C = l10 |= l11;
        }
        this.notifyPropertyChanged(84);
        super.requestRebind();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void F(MediaType mediaType) {
        this.s = mediaType;
        synchronized (this) {
            long l10 = this.C;
            long l11 = 64;
            this.C = l10 |= l11;
        }
        this.notifyPropertyChanged(85);
        super.requestRebind();
    }

    public final void a(int n10, View object) {
        boolean bl2 = true;
        switch (n10) {
            default: {
                break;
            }
            case 8: {
                Object object2 = this.q;
                AddVideoFragment$b addVideoFragment$b = this.p;
                boolean bl3 = object2 != null ? bl2 : false;
                if (!bl3 || !(bl3 = (object2 = ((w)object2).o()) != null ? bl2 : false) || (n10 = (int)(((Boolean)(object2 = (Boolean)((LiveData)object2).getValue())).booleanValue() ? 1 : 0)) == 0) break;
                if (addVideoFragment$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                addVideoFragment$b.c((View)object);
                break;
            }
            case 7: {
                AddVideoFragment$b addVideoFragment$b = this.p;
                if (addVideoFragment$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                object = MediaType.GIF;
                addVideoFragment$b.b((MediaType)((Object)object));
                break;
            }
            case 6: {
                AddVideoFragment$b addVideoFragment$b = this.p;
                if (addVideoFragment$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                object = MediaType.IMAGE;
                addVideoFragment$b.b((MediaType)((Object)object));
                break;
            }
            case 5: {
                AddVideoFragment$b addVideoFragment$b = this.p;
                if (addVideoFragment$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                object = MediaType.VIDEO;
                addVideoFragment$b.b((MediaType)((Object)object));
                break;
            }
            case 4: {
                AddVideoFragment$b addVideoFragment$b = this.p;
                if (addVideoFragment$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                object = MediaType.ALL;
                addVideoFragment$b.b((MediaType)((Object)object));
                break;
            }
            case 3: {
                AddVideoFragment$b addVideoFragment$b = this.p;
                if (addVideoFragment$b == null) {
                    bl2 = false;
                }
                if (!bl2) break;
                addVideoFragment$b.a((View)object);
            }
        }
    }

    public final void d(int n10, boolean bl2, int n11, d.v.h.e.a a10) {
        AddVideoFragment$b addVideoFragment$b = this.p;
        boolean bl3 = addVideoFragment$b != null;
        if (bl3) {
            addVideoFragment$b.e(bl2, n11, a10);
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
        float f10;
        float f11;
        long l17;
        float f12;
        float f13;
        int n10;
        MediaType mediaType;
        int n11;
        long l18;
        long l19;
        long l20;
        Object object;
        int n12;
        int n13;
        float f14;
        boolean bl2;
        long l21;
        int n14;
        int n15;
        int n16;
        Object object2;
        int n17;
        int n18;
        float f15;
        int n19;
        long l22;
        int n20;
        Object object3;
        long l23;
        Object object4;
        Object object5;
        long l24;
        w6 w62;
        block97: {
            block96: {
                block95: {
                    long l25;
                    long l26;
                    Object object6;
                    MediaType mediaType2;
                    long l27;
                    block94: {
                        block93: {
                            block92: {
                                long l28;
                                w62 = this;
                                synchronized (this) {
                                    l24 = this.C;
                                    this.C = l27 = 0L;
                                }
                                object5 = this.q;
                                object4 = this.r;
                                mediaType2 = this.s;
                                l23 = 0x11FL & l24;
                                object3 = l23 == l27 ? 0 : (l23 < l27 ? -1 : 1);
                                n20 = 2;
                                long l29 = 274L;
                                long l30 = 273L;
                                l22 = 277L;
                                n19 = 8;
                                f15 = 1.1E-44f;
                                n18 = 0;
                                Object object7 = null;
                                n17 = 0;
                                FrameLayout frameLayout = null;
                                if (object3 != false) {
                                    long l31 = l24 & l22;
                                    long l32 = l31 - l27;
                                    object3 = l32 == 0L ? 0 : (l32 < 0L ? -1 : 1);
                                    if (object3 != false) {
                                        long l33;
                                        if (object5 != null) {
                                            object2 = ((w)object5).F();
                                            ObservableList observableList = ((w)object5).s();
                                            object6 = observableList;
                                        } else {
                                            object3 = 0;
                                            object2 = null;
                                            n16 = 0;
                                            object6 = null;
                                        }
                                        w62.updateLiveDataRegistration(0, (LiveData)object2);
                                        w62.updateRegistration(n20, (ObservableList)object6);
                                        if (object2 != null) {
                                            object2 = (Boolean)((LiveData)object2).getValue();
                                        } else {
                                            object3 = 0;
                                            object2 = null;
                                        }
                                        if (object6 != null) {
                                            n16 = object6.size();
                                        } else {
                                            n16 = 0;
                                            object6 = null;
                                        }
                                        object3 = ViewDataBinding.safeUnbox((Boolean)object2);
                                        if (n16 != 0) {
                                            n16 = 1;
                                        } else {
                                            n16 = 0;
                                            object6 = null;
                                        }
                                        long l34 = l24 & l30;
                                        n15 = (int)(l34 == l27 ? 0 : (l34 < l27 ? -1 : 1));
                                        if (n15 != 0) {
                                            if (object3 != false) {
                                                l24 |= 0x4000000L;
                                                l34 = 0x40000000L;
                                            } else {
                                                l24 |= 0x2000000L;
                                                l34 = 0x20000000L;
                                            }
                                            l24 |= l34;
                                        }
                                        if ((n15 = (int)((l33 = (l34 = l24 & l30) - l27) == 0L ? 0 : (l33 < 0L ? -1 : 1))) != 0) {
                                            n15 = object3 != false ? n19 : 0;
                                            frameLayout = w62.b;
                                            n14 = object3 != false ? 2131099762 : 2131099761;
                                            n17 = ViewDataBinding.getColorFromResource((View)frameLayout, n14);
                                        } else {
                                            n17 = 0;
                                            frameLayout = null;
                                            n15 = 0;
                                        }
                                        object3 = object3 | n16;
                                        l30 = l24 & l22;
                                        n16 = (int)(l30 == l27 ? 0 : (l30 < l27 ? -1 : 1));
                                        if (n16 != 0) {
                                            l30 = object3 != false ? 0x100000000L : 0x80000000L;
                                            l24 |= l30;
                                        }
                                        if (object3 != false) {
                                            object3 = 0;
                                            object2 = null;
                                        } else {
                                            object3 = n19;
                                        }
                                    } else {
                                        object3 = 0;
                                        object2 = null;
                                        n17 = 0;
                                        frameLayout = null;
                                        n15 = 0;
                                    }
                                    l30 = l24 & l29;
                                    n16 = l30 == l27 ? 0 : (l30 < l27 ? -1 : 1);
                                    if (n16 != 0) {
                                        if (object5 != null) {
                                            object6 = ((w)object5).t();
                                        } else {
                                            n16 = 0;
                                            object6 = null;
                                        }
                                        n14 = 1;
                                        w62.updateLiveDataRegistration(n14, (LiveData)object6);
                                        if (object6 != null) {
                                            object6 = (Boolean)((LiveData)object6).getValue();
                                        } else {
                                            n16 = 0;
                                            object6 = null;
                                        }
                                        n16 = (int)(ViewDataBinding.safeUnbox((Boolean)object6) ? 1 : 0);
                                    } else {
                                        n16 = 0;
                                        object6 = null;
                                    }
                                    l30 = 280L;
                                    l21 = l24 & l30;
                                    n14 = (int)(l21 == l27 ? 0 : (l21 < l27 ? -1 : 1));
                                    if (n14 != 0) {
                                        if (object5 != null) {
                                            object5 = ((w)object5).o();
                                        } else {
                                            bl2 = false;
                                            object5 = null;
                                        }
                                        l26 = 3;
                                        f14 = 4.2E-45f;
                                        w62.updateLiveDataRegistration((int)l26, (LiveData)object5);
                                        if (object5 != null) {
                                            object7 = object5 = ((LiveData)object5).getValue();
                                            object7 = (Boolean)object5;
                                        }
                                        bl2 = ViewDataBinding.safeUnbox(object7);
                                        if (n14 != 0) {
                                            l30 = bl2 ? 0x400000000L : 0x200000000L;
                                            l24 |= l30;
                                        }
                                        if (bl2) {
                                            object5 = w62.t.getContext();
                                            n14 = 2131231059;
                                        } else {
                                            object5 = w62.t.getContext();
                                            n14 = 2131231058;
                                        }
                                        object7 = object5 = AppCompatResources.getDrawable((Context)object5, n14);
                                    }
                                    object5 = object7;
                                    n14 = n15;
                                } else {
                                    bl2 = false;
                                    object5 = null;
                                    object3 = 0;
                                    object2 = null;
                                    n16 = 0;
                                    object6 = null;
                                    n17 = 0;
                                    frameLayout = null;
                                    n14 = 0;
                                }
                                l21 = 288L;
                                long l35 = (l24 & l21) - l27;
                                l26 = l35 == 0L ? 0 : (l35 < 0L ? -1 : 1);
                                l25 = 32768L;
                                if (l26 == false) break block92;
                                n13 = ViewDataBinding.safeUnbox((Integer)object4);
                                n12 = n13 == (n12 = 1) ? 1 : 0;
                                if (n13 == n20) {
                                    n20 = 1;
                                } else {
                                    n20 = 0;
                                    object = null;
                                }
                                if (l26 != false) {
                                    l20 = n12 != 0 ? 16384L : 8192L;
                                    l24 |= l20;
                                }
                                if ((l19 = (l28 = (l20 = l24 & l21) - l27) == 0L ? 0 : (l28 < 0L ? -1 : 1)) != false) {
                                    if (n20 != 0) {
                                        l20 = 65536L;
                                        l24 |= l20;
                                    } else {
                                        l24 |= l25;
                                    }
                                }
                                if (n12 == 0) break block93;
                                n12 = n19;
                                break block94;
                            }
                            n13 = 0;
                            object4 = null;
                            n20 = 0;
                            object = null;
                        }
                        n12 = 0;
                    }
                    l20 = 320L;
                    l18 = l24 & l20;
                    l19 = l18 == l27 ? 0 : (l18 < l27 ? -1 : 1);
                    l26 = 0;
                    f14 = 0.0f;
                    MediaType mediaType3 = null;
                    if (l19 != false) {
                        float f16;
                        int n21;
                        Resources resources;
                        float f17;
                        int n22;
                        long l36;
                        long l37;
                        long l38;
                        long l39;
                        int n23;
                        float f18;
                        mediaType3 = MediaType.ALL;
                        if (mediaType2 == mediaType3) {
                            l26 = 1;
                            f14 = Float.MIN_VALUE;
                        } else {
                            l26 = 0;
                            f14 = 0.0f;
                            mediaType3 = null;
                        }
                        MediaType mediaType4 = MediaType.IMAGE;
                        if (mediaType2 == mediaType4) {
                            n11 = 1;
                            f18 = Float.MIN_VALUE;
                        } else {
                            n11 = 0;
                            f18 = 0.0f;
                            mediaType4 = null;
                        }
                        mediaType = MediaType.GIF;
                        n18 = n16;
                        if (mediaType2 == mediaType) {
                            n10 = 1;
                            f13 = Float.MIN_VALUE;
                        } else {
                            n10 = 0;
                            f13 = 0.0f;
                            mediaType = null;
                        }
                        object6 = MediaType.VIDEO;
                        if (mediaType2 == object6) {
                            n23 = 1;
                            f12 = Float.MIN_VALUE;
                        } else {
                            n23 = 0;
                            f12 = 0.0f;
                            mediaType2 = null;
                        }
                        if (l19 != false) {
                            if (l26 != false) {
                                l24 |= 0x40000L;
                                l17 = 0x4000000000L;
                            } else {
                                l24 |= 0x20000L;
                                l17 = 0x2000000000L;
                            }
                            l24 |= l17;
                        }
                        if ((n16 = (int)((l39 = (l17 = l24 & l20) - (l18 = 0L)) == 0L ? 0 : (l39 < 0L ? -1 : 1))) != 0) {
                            if (n11 != 0) {
                                l24 |= 0x1000000L;
                                l17 = 0x1000000000L;
                            } else {
                                l24 |= 0x800000L;
                                l17 = 0x800000000L;
                            }
                            l24 |= l17;
                        }
                        if ((n16 = (int)((l38 = (l17 = l24 & l20) - (l18 = 0L)) == 0L ? 0 : (l38 < 0L ? -1 : 1))) != 0) {
                            if (n10 != 0) {
                                l24 |= 0x400L;
                                l17 = 0x100000L;
                            } else {
                                l24 |= 0x200L;
                                l17 = 524288L;
                            }
                            l24 |= l17;
                        }
                        if ((n16 = (int)((l37 = (l17 = l24 & l20) - (l18 = 0L)) == 0L ? 0 : (l37 < 0L ? -1 : 1))) != 0) {
                            if (n23 != 0) {
                                l24 |= 0x400000L;
                                l17 = 0x10000000L;
                            } else {
                                l24 |= 0x200000L;
                                l17 = 0x8000000L;
                            }
                            l24 |= l17;
                        }
                        n16 = 2131099772;
                        TextView textView = w62.l;
                        if (l26 == false) {
                            n16 = 2131099781;
                        }
                        l19 = ViewDataBinding.getColorFromResource((View)textView, n16);
                        if (l26 != false) {
                            mediaType3 = w62.l.getResources();
                            f14 = mediaType3.getDimension(2131165546);
                            n16 = 2131165544;
                        } else {
                            mediaType3 = w62.l.getResources();
                            n16 = 2131165544;
                            f14 = mediaType3.getDimension(n16);
                        }
                        if (n11 != 0) {
                            float f19;
                            object6 = w62.n.getResources();
                            l36 = l24;
                            n22 = 2131165546;
                            f17 = f19 = object6.getDimension(n22);
                        } else {
                            l36 = l24;
                            resources = w62.n.getResources();
                            n21 = 2131165544;
                            float f20 = 1.7945308E38f;
                            f17 = resources.getDimension(n21);
                        }
                        if (n11 != 0) {
                            TextView textView2 = w62.n;
                            n11 = 2131099772;
                            f18 = 1.7811907E38f;
                            n21 = ViewDataBinding.getColorFromResource((View)textView2, n11);
                            n16 = 2131099781;
                        } else {
                            n11 = 2131099772;
                            f18 = 1.7811907E38f;
                            TextView textView3 = w62.n;
                            n16 = 2131099781;
                            n21 = ViewDataBinding.getColorFromResource((View)textView3, n16);
                        }
                        if (n10 != 0) {
                            object6 = w62.m;
                            n16 = ViewDataBinding.getColorFromResource((View)object6, n11);
                        } else {
                            mediaType4 = w62.m;
                            n16 = n11 = ViewDataBinding.getColorFromResource((View)mediaType4, 2131099781);
                        }
                        if (n10 != 0) {
                            mediaType4 = w62.m.getResources();
                            f18 = mediaType4.getDimension(2131165546);
                            n10 = 2131165544;
                            f13 = 1.7945308E38f;
                        } else {
                            mediaType4 = w62.m.getResources();
                            n10 = 2131165544;
                            f13 = 1.7945308E38f;
                            f18 = mediaType4.getDimension(n10);
                        }
                        if (n23 != 0) {
                            mediaType = w62.o.getResources();
                            f16 = f17;
                            n22 = 2131165546;
                            f17 = mediaType.getDimension(n22);
                        } else {
                            f16 = f17;
                            resources = w62.o.getResources();
                            f17 = resources.getDimension(n10);
                        }
                        mediaType = w62.o;
                        if (n23 != 0) {
                            n23 = 2131099772;
                            f12 = 1.7811907E38f;
                        } else {
                            n23 = 2131099781;
                            f12 = 1.7811925E38f;
                        }
                        n10 = ViewDataBinding.getColorFromResource((View)mediaType, n23);
                        f11 = f17;
                        f12 = f18;
                        n15 = n10;
                        f13 = f16;
                        n11 = n21;
                        l24 = l36;
                    } else {
                        n18 = n16;
                        n10 = 0;
                        mediaType = null;
                        f13 = 0.0f;
                        boolean bl3 = false;
                        mediaType2 = null;
                        f12 = 0.0f;
                        f11 = 0.0f;
                        n11 = 0;
                        float f21 = 0.0f;
                        Object var51_40 = null;
                        n16 = 0;
                        object6 = null;
                        l19 = 0;
                        Object var61_52 = null;
                        n15 = 0;
                    }
                    l25 = l24 & l25;
                    l18 = 0L;
                    long l40 = l25 == l18 ? 0 : (l25 < l18 ? -1 : 1);
                    if (l40 == false) break block95;
                    f10 = f13;
                    n10 = 5;
                    f13 = 7.0E-45f;
                    if (n13 != n10) break block96;
                    n10 = 1;
                    f13 = Float.MIN_VALUE;
                    break block97;
                }
                f10 = f13;
            }
            n10 = 0;
            f13 = 0.0f;
            mediaType = null;
        }
        l17 = l24 & l21;
        n13 = (int)(l17 == l18 ? 0 : (l17 < l18 ? -1 : 1));
        if (n13 != 0) {
            if (n20 != 0) {
                n10 = 1;
                f13 = Float.MIN_VALUE;
            }
            if (n13 != 0) {
                l17 = n10 != 0 ? 4096L : 2048L;
                l24 |= l17;
            }
            if (n10 == 0) {
                n19 = 0;
                f15 = 0.0f;
            }
            n10 = n19;
            f13 = f15;
        } else {
            n10 = 0;
            f13 = 0.0f;
            mediaType = null;
        }
        long l41 = l24 & 0x111L;
        l18 = 0L;
        n13 = (int)(l41 == l18 ? 0 : (l41 < l18 ? -1 : 1));
        if (n13 != 0) {
            object4 = w62.b;
            object = Converters.convertColorToDrawable(n17);
            ViewBindingAdapter.setBackground((View)object4, (Drawable)object);
            object4 = w62.c;
            object4.setVisibility(n14);
        }
        if ((n13 = (int)((l16 = (l22 = l24 & l22) - l18) == 0L ? 0 : (l16 < 0L ? -1 : 1))) != 0) {
            object4 = w62.b;
            object4.setVisibility((int)object3);
        }
        if ((n13 = (int)((l15 = (l23 = 0x100L & l24) - l18) == 0L ? 0 : (l15 < 0L ? -1 : 1))) != 0) {
            object4 = w62.c;
            object2 = w62.w;
            object4.setOnClickListener((View.OnClickListener)object2);
            object4 = w62.e;
            object2 = w62.u;
            object4.setOnClickListener((View.OnClickListener)object2);
            d.v.f.e.a.a(w62.g, true);
            object4 = w62.i;
            object2 = w62.y;
            object = w62.z;
            d.v.c.r0.c.a((MediaConstrainLayout)((Object)object4), (c$b)object2, (c$c)object);
            object4 = w62.j;
            object3 = 0;
            ((SwipeRefreshLayout)object4).setEnabled(false);
            object4 = w62.k;
            object2 = object4.getContext();
            n20 = 2131231811;
            object2 = AppCompatResources.getDrawable((Context)object2, n20);
            ((StatusView)((Object)object4)).setErrorImage((Drawable)object2);
            w62.k.setErrorText("@string/no_photo_video");
            object4 = w62.k;
            object2 = AppCompatResources.getDrawable(object4.getContext(), n20);
            ((StatusView)((Object)object4)).setEmptyImage((Drawable)object2);
            w62.k.setEmptyText("@string/no_photo_video");
            object4 = w62.l;
            object2 = w62.x;
            object4.setOnClickListener((View.OnClickListener)object2);
            object4 = w62.m;
            object2 = w62.v;
            object4.setOnClickListener((View.OnClickListener)object2);
            object4 = w62.n;
            object2 = w62.A;
            object4.setOnClickListener((View.OnClickListener)object2);
            object4 = w62.o;
            object2 = w62.B;
            object4.setOnClickListener((View.OnClickListener)object2);
        }
        if ((n13 = (int)((l14 = (l23 = l24 & l21) - (l22 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0) {
            object4 = w62.d;
            object4.setVisibility(n10);
            mediaType = w62.e;
            mediaType.setVisibility(n12);
        }
        if ((n10 = (int)((l13 = (l12 = 0x118L & l24) - l22) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0) {
            mediaType = w62.t;
            ImageViewBindingAdapter.setImageDrawable((ImageView)mediaType, (Drawable)object5);
        }
        if (bl2 = (l11 = (l12 = 0x112L & l24) - l22) == 0L ? 0 : (l11 < 0L ? -1 : 1)) {
            object5 = w62.j;
            n10 = n18;
            ((SwipeRefreshLayout)object5).setRefreshing(n18 != 0);
        }
        if (bl2 = (l10 = (l24 &= l20) - l22) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            w62.l.setTextColor((int)l19);
            TextViewBindingAdapter.setTextSize(w62.l, f14);
            w62.m.setTextColor(n16);
            TextViewBindingAdapter.setTextSize(w62.m, f12);
            w62.n.setTextColor(n11);
            object5 = w62.n;
            f14 = f10;
            TextViewBindingAdapter.setTextSize((TextView)object5, f10);
            object5 = w62.o;
            n10 = n15;
            object5.setTextColor(n15);
            object5 = w62.o;
            f14 = f11;
            TextViewBindingAdapter.setTextSize((TextView)object5, f11);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.C;
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
            this.C = l10 = 256L;
        }
        this.requestRebind();
    }

    public final void l(int n10, int n11) {
        AddVideoFragment$b addVideoFragment$b = this.p;
        boolean bl2 = addVideoFragment$b != null;
        if (bl2) {
            addVideoFragment$b.d(n11);
        }
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
                    return this.G((MutableLiveData)object, n11);
                }
                object = (ObservableList)object;
                return this.H((ObservableList)object, n11);
            }
            object = (MutableLiveData)object;
            return this.I((MutableLiveData)object, n11);
        }
        object = (MutableLiveData)object;
        return this.J((MutableLiveData)object, n11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean setVariable(int n10, Object object) {
        int n11 = 84;
        if (n11 == n10) {
            w w10 = (w)object;
            this.E(w10);
            return 1 != 0;
        } else {
            n11 = 62;
            if (n11 == n10) {
                Integer n12 = (Integer)object;
                this.D(n12);
                return 1 != 0;
            } else {
                n11 = 85;
                if (n11 == n10) {
                    MediaType mediaType = (MediaType)((Object)object);
                    this.F(mediaType);
                    return 1 != 0;
                } else {
                    n11 = 25;
                    if (n11 != n10) return 0 != 0;
                    AddVideoFragment$b addVideoFragment$b = (AddVideoFragment$b)object;
                    this.C(addVideoFragment$b);
                }
            }
        }
        return 1 != 0;
    }
}

