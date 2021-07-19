/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.widget.TextView
 */
package com.zhiyun.cama.template.edit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;

public class EditorTemplateEditActivity$c
extends AnimatorListenerAdapter {
    public final /* synthetic */ ConstraintLayout a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ TextView c;
    public final /* synthetic */ TextView d;
    public final /* synthetic */ EditorTemplateEditActivity e;

    public EditorTemplateEditActivity$c(EditorTemplateEditActivity editorTemplateEditActivity, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.e = editorTemplateEditActivity;
        this.a = constraintLayout;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
    }

    /*
     * WARNING - void declaration
     */
    public void onAnimationEnd(Animator object) {
        void var4_7;
        super.onAnimationEnd(object);
        object = this.a;
        float f10 = object.getAlpha();
        TextView textView = null;
        int bl2 = Float.compare(f10, 0.0f);
        if (bl2 != 0) {
            boolean bl3 = true;
            f10 = Float.MIN_VALUE;
        } else {
            boolean bl4 = false;
            f10 = 0.0f;
            object = null;
        }
        this.b.setEnabled((boolean)var4_7);
        this.c.setEnabled((boolean)var4_7);
        textView = this.d;
        if (textView != null) {
            textView.setEnabled((boolean)var4_7);
        }
    }
}

