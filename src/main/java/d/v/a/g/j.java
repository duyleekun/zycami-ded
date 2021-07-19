/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.VideoView
 */
package d.v.a.g;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import com.zhiyun.account.R$id;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.me.account.AccountMainFragment$b;
import d.v.a.c;
import d.v.a.d;
import d.v.a.g.i;
import d.v.a.g.j$a;
import d.v.a.g.j$b;
import d.v.a.g.j$c;
import d.v.a.h.a.a;
import d.v.a.h.a.a$a;

public class j
extends i
implements a$a {
    private static final ViewDataBinding$IncludedLayouts x;
    private static final SparseIntArray y;
    private final ConstraintLayout m;
    private final ImageView n;
    private final View.OnClickListener o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;
    private final View.OnClickListener r;
    private final View.OnClickListener s;
    private j$c t;
    private j$a u;
    private j$b v;
    private long w;

    static {
        SparseIntArray sparseIntArray;
        y = sparseIntArray = new SparseIntArray();
        int n10 = R$id.iv_bg;
        sparseIntArray.put(n10, 11);
        n10 = R$id.video_bg;
        sparseIntArray.put(n10, 12);
    }

    public j(DataBindingComponent dataBindingComponent, View view) {
        Object[] objectArray = x;
        SparseIntArray sparseIntArray = y;
        objectArray = ViewDataBinding.mapBindings(dataBindingComponent, view, 13, (ViewDataBinding$IncludedLayouts)objectArray, sparseIntArray);
        this(dataBindingComponent, view, objectArray);
    }

    private j(DataBindingComponent dataBindingComponent, View view, Object[] objectArray) {
        Object object;
        Object object2 = object = objectArray[11];
        object2 = (ImageView)object;
        Object object3 = object = objectArray[5];
        object3 = (LinearLayout)object;
        Object object4 = object = objectArray[4];
        object4 = (LinearLayout)object;
        Object object5 = object = objectArray[9];
        object5 = (ImageView)object;
        Object object6 = object = objectArray[7];
        object6 = (ImageView)object;
        Object object7 = object = objectArray[10];
        object7 = (ImageView)object;
        Object object8 = object = objectArray[8];
        object8 = (ImageView)object;
        Object object9 = object = objectArray[6];
        object9 = (ImageView)object;
        Object object10 = object = objectArray[2];
        object10 = (TextView)object;
        Object object11 = object = objectArray[3];
        object11 = (TextView)object;
        Object object12 = object = objectArray[12];
        object12 = (VideoView)object;
        object = this;
        Object object13 = dataBindingComponent;
        View view2 = view;
        super(dataBindingComponent, view, 0, (ImageView)object2, (LinearLayout)object3, (LinearLayout)object4, (ImageView)object5, (ImageView)object6, (ImageView)object7, (ImageView)object8, (ImageView)object9, (TextView)object10, (TextView)object11, (VideoView)object12);
        this.w = -1;
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        object = (ConstraintLayout)((Object)objectArray[0]);
        this.m = object;
        object.setTag(null);
        int n10 = 1;
        view2 = (ImageView)objectArray[n10];
        this.n = view2;
        view2.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        object13 = view;
        this.setRootTag(view);
        object13 = new a(this, 4);
        this.o = object13;
        object13 = new a(this, 2);
        this.p = object13;
        object13 = new a(this, 5);
        this.q = object13;
        object13 = new a(this, 3);
        this.r = object13;
        object13 = new a(this, n10);
        this.s = object13;
        this.invalidateAll();
    }

    public final void a(int n10, View object) {
        int n11 = 0;
        object = null;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 3;
                if (n10 != n13) {
                    n13 = 4;
                    if (n10 != n13) {
                        n13 = 5;
                        if (n10 == n13) {
                            AccountMainFragment$b accountMainFragment$b = this.l;
                            if (accountMainFragment$b != null) {
                                n11 = n12;
                            }
                            if (n11 != 0) {
                                object = ThirdPlatform.TWITTER;
                                accountMainFragment$b.d((ThirdPlatform)((Object)object));
                            }
                        }
                    } else {
                        AccountMainFragment$b accountMainFragment$b = this.l;
                        if (accountMainFragment$b != null) {
                            n11 = n12;
                        }
                        if (n11 != 0) {
                            object = ThirdPlatform.FACEBOOK;
                            accountMainFragment$b.d((ThirdPlatform)((Object)object));
                        }
                    }
                } else {
                    AccountMainFragment$b accountMainFragment$b = this.l;
                    if (accountMainFragment$b != null) {
                        n11 = n12;
                    }
                    if (n11 != 0) {
                        object = ThirdPlatform.WEIBO;
                        accountMainFragment$b.d((ThirdPlatform)((Object)object));
                    }
                }
            } else {
                AccountMainFragment$b accountMainFragment$b = this.l;
                if (accountMainFragment$b != null) {
                    n11 = n12;
                }
                if (n11 != 0) {
                    object = ThirdPlatform.QQ;
                    accountMainFragment$b.d((ThirdPlatform)((Object)object));
                }
            }
        } else {
            AccountMainFragment$b accountMainFragment$b = this.l;
            if (accountMainFragment$b != null) {
                n11 = n12;
            }
            if (n11 != 0) {
                object = ThirdPlatform.WE_CHAT;
                accountMainFragment$b.d((ThirdPlatform)((Object)object));
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void executeBindings() {
        ImageView imageView;
        long l10;
        Object object;
        boolean bl2;
        long l11;
        long l12;
        synchronized (this) {
            l12 = this.w;
            this.w = l11 = 0L;
        }
        Object object2 = this.l;
        long l13 = 2;
        long l14 = l12 & l13;
        long l15 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
        int n10 = 0;
        if (l15 != false) {
            bl2 = d.v.a.c.a;
            if (l15 != false) {
                long l16 = bl2 ? (long)8 : (long)4;
                l12 |= l16;
            }
            if (!bl2) {
                l15 = 8;
                n10 = l15;
            }
        }
        long l17 = (long)3 & l12;
        l15 = l17 == l11 ? 0 : (l17 < l11 ? -1 : 1);
        bl2 = false;
        Object object3 = null;
        if (l15 != false && object2 != null) {
            object3 = this.t;
            if (object3 == null) {
                this.t = object3 = new j$c();
            }
            object3 = object3.b((AccountMainFragment$b)object2);
            object = this.u;
            if (object == null) {
                object = new j$a();
                this.u = object;
            }
            object = ((j$a)object).b((AccountMainFragment$b)object2);
            j$b j$b = this.v;
            if (j$b == null) {
                this.v = j$b = new j$b();
            }
            object2 = j$b.b((AccountMainFragment$b)object2);
            j$a j$a = object;
            object = object2;
            object2 = object3;
            object3 = j$a;
        } else {
            object2 = null;
            object = null;
        }
        long l18 = (l10 = (l12 &= l13) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1);
        if (l18 != false) {
            this.b.setVisibility(n10);
            this.c.setVisibility(n10);
            imageView = this.d;
            View.OnClickListener onClickListener = this.o;
            imageView.setOnClickListener(onClickListener);
            imageView = this.e;
            onClickListener = this.p;
            imageView.setOnClickListener(onClickListener);
            imageView = this.f;
            onClickListener = this.q;
            imageView.setOnClickListener(onClickListener);
            imageView = this.g;
            onClickListener = this.r;
            imageView.setOnClickListener(onClickListener);
            imageView = this.h;
            onClickListener = this.s;
            imageView.setOnClickListener(onClickListener);
        }
        if (l15 != false) {
            this.n.setOnClickListener((View.OnClickListener)object3);
            this.i.setOnClickListener((View.OnClickListener)object2);
            imageView = this.j;
            imageView.setOnClickListener((View.OnClickListener)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasPendingBindings() {
        synchronized (this) {
            long l10 = this.w;
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
            this.w = l10 = (long)2;
        }
        this.requestRebind();
    }

    public boolean onFieldChange(int n10, Object object, int n11) {
        return false;
    }

    public boolean setVariable(int n10, Object object) {
        int n11 = d.v.a.d.x;
        if (n11 == n10) {
            object = (AccountMainFragment$b)object;
            this.z((AccountMainFragment$b)object);
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
    public void z(AccountMainFragment$b accountMainFragment$b) {
        this.l = accountMainFragment$b;
        synchronized (this) {
            long l10 = this.w;
            long l11 = 1L;
            this.w = l10 |= l11;
        }
        int n10 = d.v.a.d.x;
        this.notifyPropertyChanged(n10);
        super.requestRebind();
    }
}

