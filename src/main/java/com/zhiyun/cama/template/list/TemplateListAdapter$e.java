/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.util.Size
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.FrameLayout
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package com.zhiyun.cama.template.list;

import android.content.res.Resources;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.zhiyun.cama.template.PlayLayout;
import com.zhiyun.cama.template.PlayState;
import com.zhiyun.cama.template.list.TemplateListAdapter;
import com.zhiyun.cama.template.list.TemplateListAdapter$b;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.u1.g;
import d.v.c.u1.j;
import d.v.c.u1.n.w;
import d.v.c.w0.qc;
import d.v.e.l.h2;
import d.v.e.l.n2;
import m.a.a;

public class TemplateListAdapter$e
extends RecyclerView$ViewHolder {
    public qc a;
    public PlayLayout b;
    public LinearLayout c;
    public FrameLayout d;
    public ConstraintLayout e;
    public ConstraintLayout f;
    public View g;
    public RingProgressBar h;
    public TextView i;
    public TextView j;
    public TextView k;
    public View l;
    public View m;
    public TextView n;
    public TextView o;
    public TextView p;
    public ImageButton q;
    public ImageView r;
    public final /* synthetic */ TemplateListAdapter s;

    public TemplateListAdapter$e(TemplateListAdapter templateListAdapter, View view) {
        this.s = templateListAdapter;
        super(view);
    }

    public TemplateListAdapter$e(TemplateListAdapter object, qc object2) {
        Object object3;
        this.s = object;
        object = ((ViewDataBinding)object2).getRoot();
        super((View)object);
        this.a = object2;
        object = ((qc)object2).f;
        this.b = object;
        this.c = object3 = ((qc)object2).k;
        object3 = ((qc)object2).d;
        this.d = object3;
        object3 = ((qc)object2).b;
        this.e = object3;
        object3 = ((qc)object2).c;
        this.f = object3;
        object3 = ((qc)object2).p;
        this.g = object3;
        object3 = ((qc)object2).l;
        this.h = object3;
        object3 = ((qc)object2).m;
        this.i = object3;
        object3 = ((qc)object2).o;
        this.j = object3;
        object3 = ((qc)object2).n;
        this.k = object3;
        object3 = ((qc)object2).s;
        this.l = object3;
        object3 = ((qc)object2).e;
        this.m = object3;
        object3 = ((qc)object2).i;
        this.n = object3;
        object3 = ((qc)object2).h;
        this.o = object3;
        object3 = ((qc)object2).j;
        this.p = object3;
        object3 = ((qc)object2).a;
        this.q = object3;
        object2 = ((qc)object2).g;
        this.r = object2;
        ((PlayLayout)((Object)object)).setLoop(true);
        object = this.b;
        object2 = new w(this);
        ((PlayLayout)((Object)object)).setOnPlayStateChangeListener((g)object2);
    }

    private Size b(int n10) {
        this.j.measure(0, 0);
        int n11 = TemplateListAdapter.a(this.s).getHeight();
        int n12 = ((ViewGroup.MarginLayoutParams)this.m.getLayoutParams()).topMargin;
        n11 -= n12;
        n12 = this.j.getMeasuredHeight() * 2;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("mParentSize.getHeight():");
        int n13 = TemplateListAdapter.a(this.s).getHeight();
        charSequence.append(n13);
        charSequence.append(",tvTemplateTitle.getHeight():");
        n13 = this.j.getMeasuredHeight();
        charSequence.append(n13);
        charSequence.append(",maxheight\uff1a");
        charSequence.append(n11 -= n12);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)charSequence, objectArray);
        String string2 = ((TemplatePOJO)TemplateListAdapter.b(this.s).get(n10)).getTemplateData().getVideoRatio();
        string2 = d.v.c.u1.j.b(this.a.getRoot().getContext(), n11, string2);
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append("width:");
        n12 = string2.getWidth();
        charSequence2.append(n12);
        charSequence2.append(",height:");
        n12 = string2.getHeight();
        charSequence2.append(n12);
        charSequence2 = charSequence2.toString();
        Object[] objectArray2 = new Object[]{};
        m.a.a.b((String)charSequence2, objectArray2);
        return string2;
    }

    private /* synthetic */ void c(PlayState object) {
        int[] nArray = TemplateListAdapter$b.b;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11 && n10 != (n11 = 2)) {
            n11 = 3;
            if (n10 == n11) {
                object = this.itemView.getContext().getResources();
                n11 = 2131952066;
                object = d.v.f.i.g.o((Resources)object, n11);
                n2.e((String)object);
            }
            object = this.l;
            n11 = 0;
            nArray = null;
            object.setVisibility(0);
        } else {
            object = this.l;
            n11 = 8;
            object.setVisibility(n11);
        }
    }

    public void a(int n10) {
        int n11;
        int n12;
        Size size = this.b(n10);
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        layoutParams.height = n12 = size.getHeight();
        this.d.setLayoutParams(layoutParams);
        layoutParams = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
        layoutParams.width = n12 = size.getWidth();
        TemplateListAdapter templateListAdapter = this.s;
        n12 = templateListAdapter.getItemCount();
        int n13 = 1;
        if (n10 == (n12 -= n13)) {
            templateListAdapter = this.s;
            n12 = TemplateListAdapter.c(templateListAdapter);
            n11 = size.getWidth();
            n12 -= n11;
            n11 = layoutParams.getMarginStart();
            layoutParams.setMarginEnd(n12 -= n11);
        } else {
            n12 = 0;
            templateListAdapter = null;
            layoutParams.setMarginEnd(0);
        }
        this.c.setLayoutParams(layoutParams);
        layoutParams = this.j;
        n12 = size.getWidth();
        n11 = h2.b(24.0f);
        layoutParams.setMaxWidth(n12 -= n11);
        String string2 = ((TemplatePOJO)TemplateListAdapter.b(this.s).get(n10)).getTemplateData().getCoverUrl();
        this.b.w(size, string2);
        this.e.setClipToOutline(n13 != 0);
    }

    public /* synthetic */ void d(PlayState playState) {
        this.c(playState);
    }
}

