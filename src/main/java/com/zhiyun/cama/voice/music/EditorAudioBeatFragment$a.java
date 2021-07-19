/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package com.zhiyun.cama.voice.music;

import android.view.ViewTreeObserver;
import com.zhiyun.cama.voice.music.EditorAudioBeatFragment;
import com.zhiyun.cama.widget.AudioBeatView;

public class EditorAudioBeatFragment$a
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ EditorAudioBeatFragment a;

    public EditorAudioBeatFragment$a(EditorAudioBeatFragment editorAudioBeatFragment) {
        this.a = editorAudioBeatFragment;
    }

    public void onGlobalLayout() {
        int n10 = EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.a).a.getWidth();
        AudioBeatView audioBeatView = EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.a).a;
        audioBeatView.setFirstRectLeft(n10 >>= 1);
        EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.a).a.setLastRectRight(n10);
        AudioBeatView audioBeatView2 = EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.a).a;
        int n11 = EditorAudioBeatFragment.y(this.a).d();
        audioBeatView2.setDrawableWidth(n11);
        EditorAudioBeatFragment.x((EditorAudioBeatFragment)this.a).a.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    }
}

