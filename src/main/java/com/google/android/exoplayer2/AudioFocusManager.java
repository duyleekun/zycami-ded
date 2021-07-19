/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioAttributes
 *  android.media.AudioFocusRequest
 *  android.media.AudioFocusRequest$Builder
 *  android.media.AudioManager
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  android.os.Handler
 */
package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.AudioFocusManager$AudioFocusListener;
import com.google.android.exoplayer2.AudioFocusManager$PlayerControl;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public final class AudioFocusManager {
    private static final int AUDIO_FOCUS_STATE_HAVE_FOCUS = 1;
    private static final int AUDIO_FOCUS_STATE_LOSS_TRANSIENT = 2;
    private static final int AUDIO_FOCUS_STATE_LOSS_TRANSIENT_DUCK = 3;
    private static final int AUDIO_FOCUS_STATE_NO_FOCUS = 0;
    public static final int PLAYER_COMMAND_DO_NOT_PLAY = 255;
    public static final int PLAYER_COMMAND_PLAY_WHEN_READY = 1;
    public static final int PLAYER_COMMAND_WAIT_FOR_CALLBACK = 0;
    private static final String TAG = "AudioFocusManager";
    private static final float VOLUME_MULTIPLIER_DEFAULT = 1.0f;
    private static final float VOLUME_MULTIPLIER_DUCK = 0.2f;
    private AudioAttributes audioAttributes;
    private AudioFocusRequest audioFocusRequest;
    private int audioFocusState;
    private final AudioManager audioManager;
    private int focusGain;
    private final AudioFocusManager$AudioFocusListener focusListener;
    private AudioFocusManager$PlayerControl playerControl;
    private boolean rebuildAudioFocusRequest;
    private float volumeMultiplier = 1.0f;

    public AudioFocusManager(Context object, Handler handler, AudioFocusManager$PlayerControl audioFocusManager$PlayerControl) {
        object = (AudioManager)Assertions.checkNotNull((AudioManager)object.getApplicationContext().getSystemService("audio"));
        this.audioManager = object;
        this.playerControl = audioFocusManager$PlayerControl;
        super(this, handler);
        this.focusListener = object;
        this.audioFocusState = 0;
    }

    private void abandonAudioFocus() {
        int n10 = this.audioFocusState;
        if (n10 == 0) {
            return;
        }
        n10 = Util.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            this.abandonAudioFocusV26();
        } else {
            this.abandonAudioFocusDefault();
        }
        this.setAudioFocusState(0);
    }

    private void abandonAudioFocusDefault() {
        AudioManager audioManager = this.audioManager;
        AudioFocusManager$AudioFocusListener audioFocusManager$AudioFocusListener = this.focusListener;
        audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)audioFocusManager$AudioFocusListener);
    }

    private void abandonAudioFocusV26() {
        AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
        if (audioFocusRequest != null) {
            AudioManager audioManager = this.audioManager;
            audioManager.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    public static /* synthetic */ void access$000(AudioFocusManager audioFocusManager, int n10) {
        audioFocusManager.handlePlatformAudioFocusChange(n10);
    }

    private static int convertAudioAttributesToFocusGain(AudioAttributes object) {
        int n10 = 0;
        if (object == null) {
            return 0;
        }
        int n11 = ((AudioAttributes)object).usage;
        int n12 = 3;
        String string2 = TAG;
        int n13 = 2;
        int n14 = 1;
        switch (n11) {
            default: {
                StringBuilder stringBuilder = new StringBuilder(37);
                stringBuilder.append("Unidentified audio usage: ");
                stringBuilder.append(n11);
                object = stringBuilder.toString();
                Log.w(string2, (String)object);
                return 0;
            }
            case 16: {
                int n15 = Util.SDK_INT;
                n10 = 19;
                if (n15 >= n10) {
                    return 4;
                }
                return n13;
            }
            case 11: {
                int n16 = ((AudioAttributes)object).contentType;
                if (n16 == n14) {
                    return n13;
                }
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 12: 
            case 13: {
                return n12;
            }
            case 3: {
                return 0;
            }
            case 2: 
            case 4: {
                return n13;
            }
            case 1: 
            case 14: {
                return n14;
            }
            case 0: 
        }
        Log.w(string2, "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
        return n14;
    }

    private void executePlayerCommand(int n10) {
        AudioFocusManager$PlayerControl audioFocusManager$PlayerControl = this.playerControl;
        if (audioFocusManager$PlayerControl != null) {
            audioFocusManager$PlayerControl.executePlayerCommand(n10);
        }
    }

    private void handlePlatformAudioFocusChange(int n10) {
        int n11 = -3;
        int n12 = -2;
        if (n10 != n11 && n10 != n12) {
            n11 = -1;
            if (n10 != n11) {
                n11 = 1;
                if (n10 != n11) {
                    StringBuilder stringBuilder = new StringBuilder(38);
                    stringBuilder.append("Unknown focus change type: ");
                    stringBuilder.append(n10);
                    String string2 = stringBuilder.toString();
                    Log.w(TAG, string2);
                    return;
                }
                this.setAudioFocusState(n11);
                this.executePlayerCommand(n11);
                return;
            }
            this.executePlayerCommand(n11);
            this.abandonAudioFocus();
            return;
        }
        if (n10 != n12 && (n10 = (int)(this.willPauseWhenDucked() ? 1 : 0)) == 0) {
            n10 = 3;
            this.setAudioFocusState(n10);
        } else {
            Object var5_6 = null;
            this.executePlayerCommand(0);
            n10 = 2;
            this.setAudioFocusState(n10);
        }
    }

    private int requestAudioFocus() {
        int n10 = this.audioFocusState;
        int n11 = 1;
        if (n10 == n11) {
            return n11;
        }
        n10 = Util.SDK_INT;
        int n12 = 26;
        n10 = n10 >= n12 ? this.requestAudioFocusV26() : this.requestAudioFocusDefault();
        if (n10 == n11) {
            this.setAudioFocusState(n11);
            return n11;
        }
        this.setAudioFocusState(0);
        return -1;
    }

    private int requestAudioFocusDefault() {
        AudioManager audioManager = this.audioManager;
        AudioFocusManager$AudioFocusListener audioFocusManager$AudioFocusListener = this.focusListener;
        int n10 = Util.getStreamTypeForAudioUsage(((AudioAttributes)Assertions.checkNotNull((Object)this.audioAttributes)).usage);
        int n11 = this.focusGain;
        return audioManager.requestAudioFocus((AudioManager.OnAudioFocusChangeListener)audioFocusManager$AudioFocusListener, n10, n11);
    }

    private int requestAudioFocusV26() {
        Object object;
        boolean bl2;
        AudioFocusRequest audioFocusRequest = this.audioFocusRequest;
        if (audioFocusRequest == null || (bl2 = this.rebuildAudioFocusRequest)) {
            if (audioFocusRequest == null) {
                int n10 = this.focusGain;
                audioFocusRequest = new AudioFocusRequest.Builder(n10);
            } else {
                object = this.audioFocusRequest;
                audioFocusRequest = new AudioFocusRequest.Builder(object);
            }
            boolean bl3 = this.willPauseWhenDucked();
            android.media.AudioAttributes audioAttributes = ((AudioAttributes)Assertions.checkNotNull(this.audioAttributes)).getAudioAttributesV21();
            audioFocusRequest = audioFocusRequest.setAudioAttributes(audioAttributes).setWillPauseWhenDucked(bl3);
            object = this.focusListener;
            this.audioFocusRequest = audioFocusRequest = audioFocusRequest.setOnAudioFocusChangeListener((AudioManager.OnAudioFocusChangeListener)object).build();
            audioFocusRequest = null;
            this.rebuildAudioFocusRequest = false;
        }
        audioFocusRequest = this.audioManager;
        object = this.audioFocusRequest;
        return audioFocusRequest.requestAudioFocus(object);
    }

    private void setAudioFocusState(int n10) {
        float f10;
        int n11 = this.audioFocusState;
        if (n11 == n10) {
            return;
        }
        this.audioFocusState = n10;
        n11 = 3;
        float f11 = 4.2E-45f;
        if (n10 == n11) {
            n10 = 1045220557;
            f10 = 0.2f;
        } else {
            n10 = 1065353216;
            f10 = 1.0f;
        }
        f11 = this.volumeMultiplier;
        n11 = (int)(f11 == f10 ? 0 : (f11 > f10 ? 1 : -1));
        if (n11 == 0) {
            return;
        }
        this.volumeMultiplier = f10;
        AudioFocusManager$PlayerControl audioFocusManager$PlayerControl = this.playerControl;
        if (audioFocusManager$PlayerControl != null) {
            audioFocusManager$PlayerControl.setVolumeMultiplier(f10);
        }
    }

    private boolean shouldAbandonAudioFocus(int n10) {
        int n11 = 1;
        if (n10 != n11 && (n10 = this.focusGain) == n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private boolean willPauseWhenDucked() {
        int n10;
        AudioAttributes audioAttributes = this.audioAttributes;
        int n11 = 1;
        if (audioAttributes == null || (n10 = audioAttributes.contentType) != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public AudioManager.OnAudioFocusChangeListener getFocusListener() {
        return this.focusListener;
    }

    public float getVolumeMultiplier() {
        return this.volumeMultiplier;
    }

    public void release() {
        this.playerControl = null;
        this.abandonAudioFocus();
    }

    public void setAudioAttributes(AudioAttributes object) {
        AudioAttributes audioAttributes = this.audioAttributes;
        int n10 = Util.areEqual(audioAttributes, object);
        if (n10 == 0) {
            int n11;
            this.audioAttributes = object;
            this.focusGain = n11 = AudioFocusManager.convertAudioAttributesToFocusGain((AudioAttributes)object);
            n10 = 1;
            if (n11 != n10 && n11 != 0) {
                n10 = 0;
                audioAttributes = null;
            }
            object = "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.";
            Assertions.checkArgument(n10 != 0, object);
        }
    }

    public int updateAudioFocus(boolean bl2, int n10) {
        n10 = (int)(this.shouldAbandonAudioFocus(n10) ? 1 : 0);
        int n11 = -1;
        if (n10 != 0) {
            this.abandonAudioFocus();
            if (bl2) {
                n11 = 1;
            }
            return n11;
        }
        if (bl2) {
            n11 = this.requestAudioFocus();
        }
        return n11;
    }
}

