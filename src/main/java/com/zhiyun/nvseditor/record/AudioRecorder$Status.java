/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.nvseditor.record;

public final class AudioRecorder$Status
extends Enum {
    public static final /* enum */ AudioRecorder$Status STATUS_NO_READY;
    public static final /* enum */ AudioRecorder$Status STATUS_READY;
    public static final /* enum */ AudioRecorder$Status STATUS_START;
    public static final /* enum */ AudioRecorder$Status STATUS_STOP;
    private static final /* synthetic */ AudioRecorder$Status[] a;

    static {
        AudioRecorder$Status audioRecorder$Status;
        AudioRecorder$Status audioRecorder$Status2;
        AudioRecorder$Status audioRecorder$Status3;
        AudioRecorder$Status audioRecorder$Status4;
        STATUS_NO_READY = audioRecorder$Status4 = new AudioRecorder$Status("STATUS_NO_READY", 0);
        int n10 = 1;
        STATUS_READY = audioRecorder$Status3 = new AudioRecorder$Status("STATUS_READY", n10);
        int n11 = 2;
        STATUS_START = audioRecorder$Status2 = new AudioRecorder$Status("STATUS_START", n11);
        int n12 = 3;
        STATUS_STOP = audioRecorder$Status = new AudioRecorder$Status("STATUS_STOP", n12);
        AudioRecorder$Status[] audioRecorder$StatusArray = new AudioRecorder$Status[4];
        audioRecorder$StatusArray[0] = audioRecorder$Status4;
        audioRecorder$StatusArray[n10] = audioRecorder$Status3;
        audioRecorder$StatusArray[n11] = audioRecorder$Status2;
        audioRecorder$StatusArray[n12] = audioRecorder$Status;
        a = audioRecorder$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AudioRecorder$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static AudioRecorder$Status valueOf(String string2) {
        return Enum.valueOf(AudioRecorder$Status.class, string2);
    }

    public static AudioRecorder$Status[] values() {
        return (AudioRecorder$Status[])a.clone();
    }
}

