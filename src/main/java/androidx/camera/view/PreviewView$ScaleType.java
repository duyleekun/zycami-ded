/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

public final class PreviewView$ScaleType
extends Enum {
    private static final /* synthetic */ PreviewView$ScaleType[] $VALUES;
    public static final /* enum */ PreviewView$ScaleType FILL_CENTER;
    public static final /* enum */ PreviewView$ScaleType FILL_END;
    public static final /* enum */ PreviewView$ScaleType FILL_START;
    public static final /* enum */ PreviewView$ScaleType FIT_CENTER;
    public static final /* enum */ PreviewView$ScaleType FIT_END;
    public static final /* enum */ PreviewView$ScaleType FIT_START;
    private final int mId;

    static {
        PreviewView$ScaleType previewView$ScaleType;
        PreviewView$ScaleType previewView$ScaleType2;
        PreviewView$ScaleType previewView$ScaleType3;
        PreviewView$ScaleType previewView$ScaleType4;
        PreviewView$ScaleType previewView$ScaleType5;
        PreviewView$ScaleType previewView$ScaleType6;
        FILL_START = previewView$ScaleType6 = new PreviewView$ScaleType("FILL_START", 0, 0);
        int n10 = 1;
        FILL_CENTER = previewView$ScaleType5 = new PreviewView$ScaleType("FILL_CENTER", n10, n10);
        int n11 = 2;
        FILL_END = previewView$ScaleType4 = new PreviewView$ScaleType("FILL_END", n11, n11);
        int n12 = 3;
        FIT_START = previewView$ScaleType3 = new PreviewView$ScaleType("FIT_START", n12, n12);
        int n13 = 4;
        FIT_CENTER = previewView$ScaleType2 = new PreviewView$ScaleType("FIT_CENTER", n13, n13);
        int n14 = 5;
        FIT_END = previewView$ScaleType = new PreviewView$ScaleType("FIT_END", n14, n14);
        PreviewView$ScaleType[] previewView$ScaleTypeArray = new PreviewView$ScaleType[6];
        previewView$ScaleTypeArray[0] = previewView$ScaleType6;
        previewView$ScaleTypeArray[n10] = previewView$ScaleType5;
        previewView$ScaleTypeArray[n11] = previewView$ScaleType4;
        previewView$ScaleTypeArray[n12] = previewView$ScaleType3;
        previewView$ScaleTypeArray[n13] = previewView$ScaleType2;
        previewView$ScaleTypeArray[n14] = previewView$ScaleType;
        $VALUES = previewView$ScaleTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PreviewView$ScaleType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mId = var3_1;
    }

    public static PreviewView$ScaleType fromId(int n10) {
        for (PreviewView$ScaleType previewView$ScaleType : PreviewView$ScaleType.values()) {
            int n11 = previewView$ScaleType.mId;
            if (n11 != n10) continue;
            return previewView$ScaleType;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown scale type id ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static PreviewView$ScaleType valueOf(String string2) {
        return Enum.valueOf(PreviewView$ScaleType.class, string2);
    }

    public static PreviewView$ScaleType[] values() {
        return (PreviewView$ScaleType[])$VALUES.clone();
    }

    public int getId() {
        return this.mId;
    }
}

