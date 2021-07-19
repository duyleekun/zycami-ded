/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

public final class PreviewView$ImplementationMode
extends Enum {
    private static final /* synthetic */ PreviewView$ImplementationMode[] $VALUES;
    public static final /* enum */ PreviewView$ImplementationMode COMPATIBLE;
    public static final /* enum */ PreviewView$ImplementationMode PERFORMANCE;
    private final int mId;

    static {
        PreviewView$ImplementationMode previewView$ImplementationMode;
        PreviewView$ImplementationMode previewView$ImplementationMode2;
        PERFORMANCE = previewView$ImplementationMode2 = new PreviewView$ImplementationMode("PERFORMANCE", 0, 0);
        int n10 = 1;
        COMPATIBLE = previewView$ImplementationMode = new PreviewView$ImplementationMode("COMPATIBLE", n10, n10);
        PreviewView$ImplementationMode[] previewView$ImplementationModeArray = new PreviewView$ImplementationMode[2];
        previewView$ImplementationModeArray[0] = previewView$ImplementationMode2;
        previewView$ImplementationModeArray[n10] = previewView$ImplementationMode;
        $VALUES = previewView$ImplementationModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PreviewView$ImplementationMode() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mId = var3_1;
    }

    public static PreviewView$ImplementationMode fromId(int n10) {
        for (PreviewView$ImplementationMode previewView$ImplementationMode : PreviewView$ImplementationMode.values()) {
            int n11 = previewView$ImplementationMode.mId;
            if (n11 != n10) continue;
            return previewView$ImplementationMode;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown implementation mode id ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static PreviewView$ImplementationMode valueOf(String string2) {
        return Enum.valueOf(PreviewView$ImplementationMode.class, string2);
    }

    public static PreviewView$ImplementationMode[] values() {
        return (PreviewView$ImplementationMode[])$VALUES.clone();
    }

    public int getId() {
        return this.mId;
    }
}

