/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

public final class FocusMeteringResult {
    private boolean mIsFocusSuccessful;

    private FocusMeteringResult(boolean bl2) {
        this.mIsFocusSuccessful = bl2;
    }

    public static FocusMeteringResult create(boolean bl2) {
        FocusMeteringResult focusMeteringResult = new FocusMeteringResult(bl2);
        return focusMeteringResult;
    }

    public static FocusMeteringResult emptyInstance() {
        FocusMeteringResult focusMeteringResult = new FocusMeteringResult(false);
        return focusMeteringResult;
    }

    public boolean isFocusSuccessful() {
        return this.mIsFocusSuccessful;
    }
}

