/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

public final class TXAudioEffectManager$TXVoiceReverbType
extends Enum {
    private static final /* synthetic */ TXAudioEffectManager$TXVoiceReverbType[] $VALUES;
    public static final /* enum */ TXAudioEffectManager$TXVoiceReverbType TXLiveVoiceReverbType_0;
    public static final /* enum */ TXAudioEffectManager$TXVoiceReverbType TXLiveVoiceReverbType_1;
    public static final /* enum */ TXAudioEffectManager$TXVoiceReverbType TXLiveVoiceReverbType_2;
    public static final /* enum */ TXAudioEffectManager$TXVoiceReverbType TXLiveVoiceReverbType_3;
    public static final /* enum */ TXAudioEffectManager$TXVoiceReverbType TXLiveVoiceReverbType_4;
    public static final /* enum */ TXAudioEffectManager$TXVoiceReverbType TXLiveVoiceReverbType_5;
    public static final /* enum */ TXAudioEffectManager$TXVoiceReverbType TXLiveVoiceReverbType_6;
    public static final /* enum */ TXAudioEffectManager$TXVoiceReverbType TXLiveVoiceReverbType_7;
    private int nativeValue;

    static {
        TXAudioEffectManager$TXVoiceReverbType tXAudioEffectManager$TXVoiceReverbType;
        TXAudioEffectManager$TXVoiceReverbType tXAudioEffectManager$TXVoiceReverbType2;
        TXAudioEffectManager$TXVoiceReverbType tXAudioEffectManager$TXVoiceReverbType3;
        TXAudioEffectManager$TXVoiceReverbType tXAudioEffectManager$TXVoiceReverbType4;
        TXAudioEffectManager$TXVoiceReverbType tXAudioEffectManager$TXVoiceReverbType5;
        TXAudioEffectManager$TXVoiceReverbType tXAudioEffectManager$TXVoiceReverbType6;
        TXAudioEffectManager$TXVoiceReverbType tXAudioEffectManager$TXVoiceReverbType7;
        TXAudioEffectManager$TXVoiceReverbType tXAudioEffectManager$TXVoiceReverbType8;
        TXLiveVoiceReverbType_0 = tXAudioEffectManager$TXVoiceReverbType8 = new TXAudioEffectManager$TXVoiceReverbType("TXLiveVoiceReverbType_0", 0, 0);
        int n10 = 1;
        TXLiveVoiceReverbType_1 = tXAudioEffectManager$TXVoiceReverbType7 = new TXAudioEffectManager$TXVoiceReverbType("TXLiveVoiceReverbType_1", n10, n10);
        int n11 = 2;
        TXLiveVoiceReverbType_2 = tXAudioEffectManager$TXVoiceReverbType6 = new TXAudioEffectManager$TXVoiceReverbType("TXLiveVoiceReverbType_2", n11, n11);
        int n12 = 3;
        TXLiveVoiceReverbType_3 = tXAudioEffectManager$TXVoiceReverbType5 = new TXAudioEffectManager$TXVoiceReverbType("TXLiveVoiceReverbType_3", n12, n12);
        int n13 = 4;
        TXLiveVoiceReverbType_4 = tXAudioEffectManager$TXVoiceReverbType4 = new TXAudioEffectManager$TXVoiceReverbType("TXLiveVoiceReverbType_4", n13, n13);
        int n14 = 5;
        TXLiveVoiceReverbType_5 = tXAudioEffectManager$TXVoiceReverbType3 = new TXAudioEffectManager$TXVoiceReverbType("TXLiveVoiceReverbType_5", n14, n14);
        int n15 = 6;
        TXLiveVoiceReverbType_6 = tXAudioEffectManager$TXVoiceReverbType2 = new TXAudioEffectManager$TXVoiceReverbType("TXLiveVoiceReverbType_6", n15, n15);
        n15 = 7;
        TXLiveVoiceReverbType_7 = tXAudioEffectManager$TXVoiceReverbType = new TXAudioEffectManager$TXVoiceReverbType("TXLiveVoiceReverbType_7", n15, n15);
        TXAudioEffectManager$TXVoiceReverbType[] tXAudioEffectManager$TXVoiceReverbTypeArray = new TXAudioEffectManager$TXVoiceReverbType[8];
        tXAudioEffectManager$TXVoiceReverbTypeArray[0] = tXAudioEffectManager$TXVoiceReverbType8;
        tXAudioEffectManager$TXVoiceReverbTypeArray[n10] = tXAudioEffectManager$TXVoiceReverbType7;
        tXAudioEffectManager$TXVoiceReverbTypeArray[n11] = tXAudioEffectManager$TXVoiceReverbType6;
        tXAudioEffectManager$TXVoiceReverbTypeArray[n12] = tXAudioEffectManager$TXVoiceReverbType5;
        tXAudioEffectManager$TXVoiceReverbTypeArray[n13] = tXAudioEffectManager$TXVoiceReverbType4;
        tXAudioEffectManager$TXVoiceReverbTypeArray[n14] = tXAudioEffectManager$TXVoiceReverbType3;
        tXAudioEffectManager$TXVoiceReverbTypeArray[6] = tXAudioEffectManager$TXVoiceReverbType2;
        tXAudioEffectManager$TXVoiceReverbTypeArray[n15] = tXAudioEffectManager$TXVoiceReverbType;
        $VALUES = tXAudioEffectManager$TXVoiceReverbTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TXAudioEffectManager$TXVoiceReverbType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.nativeValue = var3_1;
    }

    public static TXAudioEffectManager$TXVoiceReverbType valueOf(String string2) {
        return Enum.valueOf(TXAudioEffectManager$TXVoiceReverbType.class, string2);
    }

    public static TXAudioEffectManager$TXVoiceReverbType[] values() {
        return (TXAudioEffectManager$TXVoiceReverbType[])$VALUES.clone();
    }

    public int getNativeValue() {
        return this.nativeValue;
    }
}

