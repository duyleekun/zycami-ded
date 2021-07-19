/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.widget.LinearLayout
 */
package com.zhiyun.cama.camera.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.zhiyun.cama.camera.widget.HintLayout$a;
import com.zhiyun.cama.camera.widget.HintLayout$b;
import d.v.c.s0.i7.b;
import d.v.c.w0.qi;
import d.v.f.i.g;
import java.util.List;

public class HintLayout
extends LinearLayout {
    private LinearLayout a;
    private final List b;
    private int c;

    public HintLayout(Context context) {
        this(context, null);
    }

    public HintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HintLayout(Context context, AttributeSet object, int n10) {
        super(context, object, n10);
        super();
        this.b = object;
        this.c = 0;
        this.b(context);
    }

    private void b(Context context) {
        this.a = this;
        this.setOrientation(1);
    }

    public static /* synthetic */ void c(qi qi2) {
        if (qi2 != null) {
            qi2 = qi2.a;
            qi2.performClick();
        }
    }

    public boolean a(HintLayout$b hintLayout$b) {
        synchronized (this) {
            block38: {
                Object object = null;
                if (hintLayout$b != null) {
                    int n10;
                    qi qi2;
                    Object object2;
                    int n11;
                    int n12;
                    Object object3;
                    block40: {
                        Object object4;
                        block39: {
                            object3 = HintLayout$b.a(hintLayout$b);
                            n12 = TextUtils.isEmpty((CharSequence)object3);
                            if (n12 != 0) break block38;
                            object3 = HintLayout$b.a(hintLayout$b);
                            this.d((String)object3);
                            object3 = this.getContext();
                            object3 = LayoutInflater.from((Context)object3);
                            int n13 = 2131558812;
                            n11 = 0;
                            object2 = null;
                            object3 = object3.inflate(n13, null, false);
                            qi2 = qi.s((View)object3);
                            object2 = new HintLayout$a(this);
                            qi2.A((HintLayout$a)object2);
                            object2 = qi2.d;
                            object4 = this.getResources();
                            int n14 = hintLayout$b.j();
                            Object[] objectArray = hintLayout$b.k();
                            object4 = g.p(object4, n14, objectArray);
                            object2.setText((CharSequence)object4);
                            object2 = this.getResources();
                            n10 = hintLayout$b.e();
                            object2 = g.o((Resources)object2, n10);
                            object4 = qi2.c;
                            object4.setText((CharSequence)object2);
                            object4 = qi2.c;
                            n11 = TextUtils.isEmpty((CharSequence)object2);
                            if (n11 != 0) {
                                n11 = 8;
                                break block39;
                            }
                            n11 = 0;
                            object2 = null;
                        }
                        object4.setVisibility(n11);
                        n11 = (int)(HintLayout$b.b(hintLayout$b) ? 1 : 0);
                        n10 = 1;
                        if (n11 != 0) break block40;
                        n11 = this.c + n10;
                        this.c = n11;
                        object2 = this.a;
                        object2.addView((View)object3, 0);
                        object3 = this.b;
                        object3.add(0, hintLayout$b);
                    }
                    object = new b(qi2);
                    object2 = this.a;
                    long l10 = HintLayout$b.c(hintLayout$b);
                    object2.postDelayed((Runnable)object, l10);
                    hintLayout$b.s((Runnable)object);
                    object = this.a;
                    n11 = this.c;
                    object.addView((View)object3, n11);
                    object = this.b;
                    n12 = this.c;
                    object.add(n12, hintLayout$b);
                    qi2.B(hintLayout$b);
                    return n10 != 0;
                }
            }
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean d(String object) {
        synchronized (this) {
            int n10;
            Object object2;
            int n11;
            int n12;
            block8: {
                n12 = 0;
                n11 = 0;
                while (true) {
                    object2 = this.b;
                    int n13 = object2.size();
                    n10 = -1;
                    if (n11 >= n13) break;
                    object2 = this.b;
                    object2 = object2.get(n11);
                    object2 = (HintLayout$b)object2;
                    n13 = (int)(((String)(object2 = HintLayout$b.a((HintLayout$b)object2))).equals(object) ? 1 : 0);
                    if (n13 == 0) {
                        ++n11;
                        continue;
                    }
                    break block8;
                    break;
                }
                n11 = n10;
            }
            if (n10 == n11) {
                return false;
            }
            object = this.b;
            object = object.get(n11);
            object = (HintLayout$b)object;
            int n14 = HintLayout$b.b((HintLayout$b)object);
            n12 = 1;
            if (n14 == 0) {
                this.c = n14 = this.c - n12;
            }
            object = this.b;
            object = object.get(n11);
            object = (HintLayout$b)object;
            if ((object = ((HintLayout$b)object).h()) != null) {
                object = this.a;
                object2 = this.b;
                object2 = object2.get(n11);
                object2 = (HintLayout$b)object2;
                object2 = ((HintLayout$b)object2).h();
                object.removeCallbacks((Runnable)object2);
            }
            object = this.b;
            object.remove(n11);
            object = this.a;
            object.removeViewAt(n11);
            return n12 != 0;
        }
    }
}

