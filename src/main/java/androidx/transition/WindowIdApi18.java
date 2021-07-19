/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.WindowId
 */
package androidx.transition;

import android.view.View;
import android.view.WindowId;
import androidx.transition.WindowIdImpl;

public class WindowIdApi18
implements WindowIdImpl {
    private final WindowId mWindowId;

    public WindowIdApi18(View view) {
        view = view.getWindowId();
        this.mWindowId = view;
    }

    public boolean equals(Object object) {
        WindowId windowId;
        boolean bl2;
        boolean bl3 = object instanceof WindowIdApi18;
        if (bl3 && (bl2 = (object = ((WindowIdApi18)object).mWindowId).equals((Object)(windowId = this.mWindowId)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int hashCode() {
        return this.mWindowId.hashCode();
    }
}

