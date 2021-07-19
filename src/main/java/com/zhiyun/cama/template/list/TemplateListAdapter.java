/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  android.util.Size
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewPropertyAnimator
 *  android.widget.TextView
 */
package com.zhiyun.cama.template.list;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.zhiyun.cama.template.PlayLayout;
import com.zhiyun.cama.template.list.TemplateListAdapter$a;
import com.zhiyun.cama.template.list.TemplateListAdapter$b;
import com.zhiyun.cama.template.list.TemplateListAdapter$c;
import com.zhiyun.cama.template.list.TemplateListAdapter$d;
import com.zhiyun.cama.template.list.TemplateListAdapter$e;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.common.util.Windows;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.c.u1.n.a0;
import d.v.c.u1.n.u;
import d.v.c.u1.n.v;
import d.v.c.u1.n.x;
import d.v.c.u1.n.y;
import d.v.c.u1.n.z;
import d.v.c.w0.qc;
import d.v.e.l.b2;
import d.v.e.l.h2;
import d.v.e.l.n2;
import d.v.f.i.g;
import d.v.j.g.d0.d;
import d.v.j.g.d0.f;
import java.io.Serializable;
import java.util.List;
import m.a.a;

public class TemplateListAdapter
extends RecyclerView$Adapter {
    private List a;
    private final int b;
    private final int c;
    private TemplateListAdapter$d d;
    private final int e;
    private Size f;
    private f g;
    private TemplateListAdapter$c h;

    public TemplateListAdapter(Context objectArray, f f10) {
        int n10;
        int n11;
        Serializable serializable;
        this.a = serializable = new Serializable();
        this.e = n11 = Windows.o((Context)objectArray).getWidth();
        double d10 = (double)n11 * 0.75;
        float f11 = 28.0f;
        double d11 = h2.b(f11);
        d10 -= d11;
        d11 = h2.b(f11);
        this.c = n10 = (int)(d10 - d11);
        d11 = (double)n11 * 0.94;
        double d12 = h2.b(f11);
        double d13 = h2.b(f11);
        this.b = n11 = (int)((d11 -= d12) - d13);
        int n12 = 1;
        Object[] objectArray2 = new Object[n12];
        objectArray = n11;
        objectArray2[0] = objectArray;
        m.a.a.b("mMax16_9VideoWidth:%d", objectArray2);
        objectArray = new Object[n12];
        objectArray[0] = serializable = Integer.valueOf(n10);
        m.a.a.b("mMax9_16VideoWidth:%d", objectArray);
        this.g = f10;
    }

    private void A(TemplateListAdapter$e templateListAdapter$e, DownloadEvent object) {
        boolean bl2 = ((DownloadEvent)object).isSingleEvent();
        if (bl2) {
            templateListAdapter$e.h.setAlpha(1.0f);
            templateListAdapter$e.h.setVisibility(0);
            templateListAdapter$e.i.setVisibility(4);
            object = templateListAdapter$e.h;
            int n10 = 100;
            ((RingProgressBar)((Object)object)).setProgress(n10);
            object = templateListAdapter$e.h;
            y y10 = new y(this, templateListAdapter$e);
            ((RingProgressBar)((Object)object)).setOnCompletedAnimListener(y10);
        }
    }

    private void B(TemplateListAdapter$e object, int n10) {
        ((TemplateListAdapter$e)object).h.setAlpha(1.0f);
        ((TemplateListAdapter$e)object).h.setVisibility(0);
        TextView textView = ((TemplateListAdapter$e)object).i;
        int n11 = 8;
        textView.setVisibility(n11);
        object = ((TemplateListAdapter$e)object).h;
        int n12 = 100;
        if (n10 >= n12) {
            n10 = 99;
        }
        ((RingProgressBar)((Object)object)).setProgress(n10);
    }

    public static /* synthetic */ Size a(TemplateListAdapter templateListAdapter) {
        return templateListAdapter.f;
    }

    public static /* synthetic */ List b(TemplateListAdapter templateListAdapter) {
        return templateListAdapter.a;
    }

    public static /* synthetic */ int c(TemplateListAdapter templateListAdapter) {
        return templateListAdapter.e;
    }

    private /* synthetic */ void e(int n10, View view) {
        TemplateListAdapter$c templateListAdapter$c = this.h;
        if (templateListAdapter$c != null) {
            templateListAdapter$c.a(view, n10);
        }
    }

    private /* synthetic */ void g(int n10, View view) {
        TemplateListAdapter$c templateListAdapter$c = this.h;
        if (templateListAdapter$c != null) {
            templateListAdapter$c.a(view, n10);
        }
    }

    private /* synthetic */ void i(TemplateListAdapter$e templateListAdapter$e, int n10, View object) {
        object = this.d;
        if (object != null) {
            templateListAdapter$e = templateListAdapter$e.itemView;
            object.a((View)templateListAdapter$e, n10);
        }
    }

    private /* synthetic */ void k(int n10, View object) {
        object = this.d;
        if (object != null) {
            object.b(n10);
        }
    }

    private /* synthetic */ void m(int n10, View view) {
        TemplateListAdapter$d templateListAdapter$d = this.d;
        if (templateListAdapter$d != null) {
            templateListAdapter$d.c(view, n10);
        }
    }

    private /* synthetic */ void o(TemplateListAdapter$e templateListAdapter$e) {
        ViewPropertyAnimator viewPropertyAnimator = templateListAdapter$e.h.animate().alpha(0.0f).setDuration(500L);
        TemplateListAdapter$a templateListAdapter$a = new TemplateListAdapter$a(this, templateListAdapter$e);
        viewPropertyAnimator.setListener((Animator.AnimatorListener)templateListAdapter$a);
        viewPropertyAnimator.start();
    }

    private void y(TemplateListAdapter$e templateListAdapter$e) {
        templateListAdapter$e.h.setAlpha(1.0f);
        templateListAdapter$e.h.setVisibility(0);
        templateListAdapter$e.i.setVisibility(8);
        templateListAdapter$e.h.setProgress(-1);
    }

    private void z(TemplateListAdapter$e templateListAdapter$e) {
        int n10;
        RingProgressBar ringProgressBar = templateListAdapter$e.h;
        int n11 = ringProgressBar.getProgress();
        if (n11 < (n10 = 100)) {
            templateListAdapter$e.h.setAlpha(1.0f);
            ringProgressBar = templateListAdapter$e.h;
            n10 = 8;
            ringProgressBar.setVisibility(n10);
            templateListAdapter$e = templateListAdapter$e.i;
            n11 = 0;
            ringProgressBar = null;
            templateListAdapter$e.setVisibility(0);
        }
    }

    public void C(TemplateListAdapter$e templateListAdapter$e, int n10) {
        int n11;
        Object object = this.a;
        if (object != null && n10 >= 0 && n10 < (n11 = object.size())) {
            TextView textView;
            object = templateListAdapter$e.b;
            int n12 = 1;
            ((PlayLayout)((Object)object)).setHideProgress(n12 != 0);
            TemplatePOJO templatePOJO = (TemplatePOJO)this.a.get(n10);
            object = templatePOJO.getTemplateData();
            Object object2 = templatePOJO.getTemplate();
            boolean bl2 = ((Template)object2).isEmpty();
            long l10 = ((Template)object2).getTypeId();
            long l11 = -999L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            int n13 = 0;
            if (l12 != false) {
                n12 = 0;
                textView = null;
            }
            object2 = templateListAdapter$e.n;
            String string2 = "";
            String string3 = bl2 ? string2 : ((TemplateData)object).getVideoRatio();
            object2.setText((CharSequence)string3);
            object2 = templateListAdapter$e.o;
            string3 = bl2 ? string2 : ((TemplateData)object).showVideoTime();
            object2.setText((CharSequence)string3);
            object2 = templateListAdapter$e.p;
            if (!bl2) {
                string2 = ((TemplateData)object).showVideoCountP();
            }
            object2.setText((CharSequence)string2);
            object2 = templateListAdapter$e.q;
            int n14 = 8;
            if (!bl2 && n12 != 0) {
                n12 = 0;
                textView = null;
            } else {
                n12 = n14;
            }
            object2.setVisibility(n12);
            textView = templateListAdapter$e.j;
            object2 = ((TemplateData)object).showTitle();
            textView.setText((CharSequence)object2);
            textView = templateListAdapter$e.k;
            object2 = ((TemplateData)object).showResSize();
            textView.setText((CharSequence)object2);
            textView = templateListAdapter$e.r;
            n11 = (int)(((TemplateData)object).isPrimeUsable() ? 1 : 0);
            if (n11 == 0) {
                n13 = n14;
            }
            textView.setVisibility(n13);
            this.v(templateListAdapter$e, templatePOJO);
        }
    }

    public void D(TemplateListAdapter$e object, int n10, boolean bl2, boolean bl3) {
        boolean bl4;
        if (object == null) {
            return;
        }
        List list = this.a;
        String string2 = ((TemplatePOJO)list.get(n10)).getTemplateData().getVideoUrl();
        boolean bl5 = TextUtils.isEmpty((CharSequence)string2);
        if (bl5) {
            return;
        }
        list = ((RecyclerView$ViewHolder)object).itemView.getContext();
        if (bl2 && !(bl4 = b2.m((Context)list)) && (bl4 = this.q(string2))) {
            if (bl3) {
                object = list.getResources();
                n10 = 2131952827;
                object = d.v.f.i.g.o((Resources)object, n10);
                n2.e((String)object);
            }
            return;
        }
        object = ((TemplateListAdapter$e)object).b;
        if (bl2) {
            ((PlayLayout)((Object)object)).C(string2);
        } else {
            ((PlayLayout)((Object)object)).u();
        }
    }

    public List d() {
        return this.a;
    }

    public /* synthetic */ void f(int n10, View view) {
        this.e(n10, view);
    }

    public int getItemCount() {
        return this.a.size();
    }

    public /* synthetic */ void h(int n10, View view) {
        this.g(n10, view);
    }

    public /* synthetic */ void j(TemplateListAdapter$e templateListAdapter$e, int n10, View view) {
        this.i(templateListAdapter$e, n10, view);
    }

    public /* synthetic */ void l(int n10, View view) {
        this.k(n10, view);
    }

    public /* synthetic */ void n(int n10, View view) {
        this.m(n10, view);
    }

    public /* synthetic */ void p(TemplateListAdapter$e templateListAdapter$e) {
        this.o(templateListAdapter$e);
    }

    public boolean q(String string2) {
        return string2.startsWith("http");
    }

    public void r(TemplateListAdapter$e templateListAdapter$e, int n10) {
        Object object = templateListAdapter$e.h;
        View.OnClickListener onClickListener = new v(this, n10);
        object.setOnClickListener(onClickListener);
        object = templateListAdapter$e.i;
        onClickListener = new u(this, n10);
        object.setOnClickListener(onClickListener);
        object = new z(this, templateListAdapter$e, n10);
        templateListAdapter$e.d.setOnClickListener((View.OnClickListener)object);
        templateListAdapter$e.j.setOnClickListener((View.OnClickListener)object);
        object = templateListAdapter$e.l;
        onClickListener = new x(this, n10);
        object.setOnClickListener(onClickListener);
        object = templateListAdapter$e.q;
        onClickListener = new a0(this, n10);
        object.setOnClickListener(onClickListener);
        this.C(templateListAdapter$e, n10);
        templateListAdapter$e.a(n10);
    }

    public TemplateListAdapter$e s(ViewGroup object, int n10) {
        Object object2 = this.f;
        if (object2 == null) {
            int n11 = object.getWidth();
            int n12 = object.getHeight();
            this.f = object2 = new Size(n11, n12);
        }
        object = (qc)DataBindingUtil.inflate(LayoutInflater.from((Context)object.getContext()), 2131558653, object, false);
        object2 = new TemplateListAdapter$e(this, (qc)object);
        return object2;
    }

    public void t(TemplateListAdapter$e templateListAdapter$e) {
        super.onViewDetachedFromWindow(templateListAdapter$e);
        templateListAdapter$e.b.u();
    }

    public void u(List list) {
        this.a.clear();
        this.a.addAll(list);
    }

    public void v(TemplateListAdapter$e templateListAdapter$e, TemplatePOJO object) {
        Object object2 = ((TemplatePOJO)object).getTemplate();
        Object object3 = this.g;
        long l10 = object2.getId();
        Long l11 = l10;
        object3 = ((d)object3).o(l11);
        object = ((TemplatePOJO)object).getTemplateData();
        if (object3 != null) {
            boolean n11;
            object = TemplateListAdapter$b.a;
            object2 = ((DownloadEvent)object3).getDownloadState();
            int n10 = ((Enum)object2).ordinal();
            Object object4 = object[n10];
            if (object4 != (n11 = true)) {
                int n12 = 2;
                if (object4 != n12) {
                    this.y(templateListAdapter$e);
                } else {
                    this.A(templateListAdapter$e, (DownloadEvent)object3);
                    this.z(templateListAdapter$e);
                }
            } else {
                object4 = ((DownloadEvent)object3).getProgress();
                this.B(templateListAdapter$e, (int)object4);
            }
        } else if (object != null) {
            boolean bl2 = object2.isEmpty();
            if (bl2) {
                object = templateListAdapter$e.h;
                int n13 = 8;
                object.setVisibility(n13);
                templateListAdapter$e = templateListAdapter$e.i;
                templateListAdapter$e.setVisibility(n13);
            } else {
                boolean bl3 = ((TemplateData)object).isDownloadFinished();
                if (bl3) {
                    this.z(templateListAdapter$e);
                } else {
                    this.y(templateListAdapter$e);
                }
            }
        }
    }

    public void w(TemplateListAdapter$c templateListAdapter$c) {
        this.h = templateListAdapter$c;
    }

    public void x(TemplateListAdapter$d templateListAdapter$d) {
        this.d = templateListAdapter$d;
    }
}

