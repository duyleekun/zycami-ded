/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.main;

import androidx.activity.OnBackPressedCallback;
import com.zhiyun.cama.main.EditorMainActivity;
import d.v.c.i1.i2;

public class EditorMainActivity$a
extends OnBackPressedCallback {
    public final /* synthetic */ EditorMainActivity a;

    public EditorMainActivity$a(EditorMainActivity editorMainActivity, boolean bl2) {
        this.a = editorMainActivity;
        super(bl2);
    }

    public void handleOnBackPressed() {
        Object object = EditorMainActivity.i(this.a);
        boolean bl2 = ((i2)object).A1();
        if (bl2) {
            object = this.a;
            EditorMainActivity.j((EditorMainActivity)object);
        } else {
            object = this.a;
            EditorMainActivity.k((EditorMainActivity)object);
        }
    }
}

