/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  android.os.Handler
 */
package com.google.android.exoplayer2;

import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.AudioFocusManager;
import d.h.a.a.b;

public class AudioFocusManager$AudioFocusListener
implements AudioManager.OnAudioFocusChangeListener {
    private final Handler eventHandler;
    public final /* synthetic */ AudioFocusManager this$0;

    public AudioFocusManager$AudioFocusListener(AudioFocusManager audioFocusManager, Handler handler) {
        this.this$0 = audioFocusManager;
        this.eventHandler = handler;
    }

    private /* synthetic */ void a(int n10) {
        AudioFocusManager.access$000(this.this$0, n10);
    }

    public /* synthetic */ void b(int n10) {
        this.a(n10);
    }

    public void onAudioFocusChange(int n10) {
        Handler handler = this.eventHandler;
        b b10 = new b(this, n10);
        handler.post((Runnable)b10);
    }
}

