/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template;

public final class PlayState
extends Enum {
    public static final /* enum */ PlayState STATE_COMPLETED;
    public static final /* enum */ PlayState STATE_ERROR_IO;
    public static final /* enum */ PlayState STATE_IDLE;
    public static final /* enum */ PlayState STATE_PAUSE;
    public static final /* enum */ PlayState STATE_PLAYING;
    public static final /* enum */ PlayState STATE_PLAY_PREPARE;
    private static final /* synthetic */ PlayState[] a;

    static {
        PlayState playState;
        PlayState playState2;
        PlayState playState3;
        PlayState playState4;
        PlayState playState5;
        PlayState playState6;
        STATE_IDLE = playState6 = new PlayState("STATE_IDLE", 0);
        int n10 = 1;
        STATE_PLAY_PREPARE = playState5 = new PlayState("STATE_PLAY_PREPARE", n10);
        int n11 = 2;
        STATE_PLAYING = playState4 = new PlayState("STATE_PLAYING", n11);
        int n12 = 3;
        STATE_PAUSE = playState3 = new PlayState("STATE_PAUSE", n12);
        int n13 = 4;
        STATE_ERROR_IO = playState2 = new PlayState("STATE_ERROR_IO", n13);
        int n14 = 5;
        STATE_COMPLETED = playState = new PlayState("STATE_COMPLETED", n14);
        PlayState[] playStateArray = new PlayState[6];
        playStateArray[0] = playState6;
        playStateArray[n10] = playState5;
        playStateArray[n11] = playState4;
        playStateArray[n12] = playState3;
        playStateArray[n13] = playState2;
        playStateArray[n14] = playState;
        a = playStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PlayState() {
        void var2_-1;
        void var1_-1;
    }

    public static boolean isPlaying(PlayState playState) {
        boolean bl2;
        PlayState playState2 = STATE_PLAY_PREPARE;
        if (playState != playState2 && playState != (playState2 = STATE_PLAYING)) {
            bl2 = false;
            playState = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static PlayState valueOf(String string2) {
        return Enum.valueOf(PlayState.class, string2);
    }

    public static PlayState[] values() {
        return (PlayState[])a.clone();
    }
}

