/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package com.zhiyun.cama.template.edit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;

public class EditorTemplateEditActivity$d
extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ EditorTemplateEditActivity b;

    public EditorTemplateEditActivity$d(EditorTemplateEditActivity editorTemplateEditActivity, boolean bl2) {
        this.b = editorTemplateEditActivity;
        this.a = bl2;
    }

    public void onAnimationEnd(Animator object) {
        super.onAnimationEnd(object);
        boolean bl2 = this.a;
        if (!bl2) {
            object = EditorTemplateEditActivity.j((EditorTemplateEditActivity)this.b).a;
            int n10 = 4;
            object.setVisibility(n10);
        }
    }
}

