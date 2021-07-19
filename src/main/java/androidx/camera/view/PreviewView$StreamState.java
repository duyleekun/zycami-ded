/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

public final class PreviewView$StreamState
extends Enum {
    private static final /* synthetic */ PreviewView$StreamState[] $VALUES;
    public static final /* enum */ PreviewView$StreamState IDLE;
    public static final /* enum */ PreviewView$StreamState STREAMING;

    static {
        PreviewView$StreamState previewView$StreamState;
        PreviewView$StreamState previewView$StreamState2;
        IDLE = previewView$StreamState2 = new PreviewView$StreamState("IDLE", 0);
        int n10 = 1;
        STREAMING = previewView$StreamState = new PreviewView$StreamState("STREAMING", n10);
        PreviewView$StreamState[] previewView$StreamStateArray = new PreviewView$StreamState[2];
        previewView$StreamStateArray[0] = previewView$StreamState2;
        previewView$StreamStateArray[n10] = previewView$StreamState;
        $VALUES = previewView$StreamStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PreviewView$StreamState() {
        void var2_-1;
        void var1_-1;
    }

    public static PreviewView$StreamState valueOf(String string2) {
        return Enum.valueOf(PreviewView$StreamState.class, string2);
    }

    public static PreviewView$StreamState[] values() {
        return (PreviewView$StreamState[])$VALUES.clone();
    }
}

