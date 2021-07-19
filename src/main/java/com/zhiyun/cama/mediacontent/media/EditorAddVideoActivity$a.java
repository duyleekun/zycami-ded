/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.TextView
 */
package com.zhiyun.cama.mediacontent.media;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment;
import com.zhiyun.cama.mediacontent.media.EditorAddVideoActivity;

public class EditorAddVideoActivity$a
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ AddVideoFragment a;
    public final /* synthetic */ EditorAddVideoActivity b;

    public EditorAddVideoActivity$a(EditorAddVideoActivity editorAddVideoActivity, AddVideoFragment addVideoFragment) {
        this.b = editorAddVideoActivity;
        this.a = addVideoFragment;
    }

    public void onGlobalLayout() {
        EditorAddVideoActivity.i(this.b).getRoot().getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        TextView textView = EditorAddVideoActivity.i((EditorAddVideoActivity)this.b).b.c;
        AddVideoFragment addVideoFragment = this.a;
        int n10 = addVideoFragment.C();
        if (n10 != 0) {
            n10 = 0;
            addVideoFragment = null;
        } else {
            n10 = 4;
        }
        textView.setVisibility(n10);
    }
}

