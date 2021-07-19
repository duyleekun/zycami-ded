/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package com.zhiyun.cama.voice.music.volume;

import android.view.ViewTreeObserver;
import com.zhiyun.cama.voice.music.volume.EditorMusicVolumeFragment;
import com.zhiyun.cama.widget.AudioBarView;
import d.v.c.y1.f.y.e;
import d.v.e.l.h2;

public class EditorMusicVolumeFragment$a
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ EditorMusicVolumeFragment a;

    public EditorMusicVolumeFragment$a(EditorMusicVolumeFragment editorMusicVolumeFragment) {
        this.a = editorMusicVolumeFragment;
    }

    public void onGlobalLayout() {
        Object object = EditorMusicVolumeFragment.y(this.a);
        int n10 = EditorMusicVolumeFragment.x((EditorMusicVolumeFragment)this.a).b.getWidth();
        int n11 = h2.b(60.0f);
        int n12 = ((e)object).n(n10 -= n11);
        EditorMusicVolumeFragment.x((EditorMusicVolumeFragment)this.a).b.setDrawableWidth(n12);
        EditorMusicVolumeFragment.y(this.a).m(n12);
        object = EditorMusicVolumeFragment.x((EditorMusicVolumeFragment)this.a).b;
        n10 = EditorMusicVolumeFragment.y(this.a).i();
        ((AudioBarView)((Object)object)).d(n10);
        EditorMusicVolumeFragment.x((EditorMusicVolumeFragment)this.a).b.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    }
}

