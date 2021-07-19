/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.view.View
 *  android.widget.TextView
 */
package com.zhiyun.cama.template.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;
import com.zhiyun.cama.template.list.TemplateListAdapter;
import com.zhiyun.cama.template.list.TemplateListAdapter$WrapperView;
import com.zhiyun.cama.template.list.TemplateListAdapter$e;

public class TemplateListAdapter$a
extends AnimatorListenerAdapter {
    public final /* synthetic */ TemplateListAdapter$e a;
    public final /* synthetic */ TemplateListAdapter b;

    public TemplateListAdapter$a(TemplateListAdapter templateListAdapter, TemplateListAdapter$e e10) {
        this.b = templateListAdapter;
        this.a = e10;
    }

    public void onAnimationEnd(Animator animator2) {
        super.onAnimationEnd(animator2);
        this.a.i.setVisibility(0);
        animator2 = this.a.i.getPaint();
        Object object = this.a.i.getText().toString();
        float f10 = animator2.measureText((String)object);
        Object object2 = this.a.i;
        object = new TemplateListAdapter$WrapperView((View)object2);
        object2 = new int[2];
        int n10 = (int)f10;
        object2[0] = (TextView)n10;
        n10 = this.a.i.getWidth();
        object2[1] = (TextView)n10;
        ObjectAnimator.ofInt((Object)object, (String)"width", (int[])object2).setDuration(1000L).start();
    }
}

