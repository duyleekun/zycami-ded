/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 */
package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.WithHint;

public class AppCompatHintHelper {
    private AppCompatHintHelper() {
    }

    public static InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo, View object) {
        CharSequence charSequence;
        if (inputConnection != null && (charSequence = editorInfo.hintText) == null) {
            boolean bl2;
            object = object.getParent();
            while (bl2 = object instanceof View) {
                bl2 = object instanceof WithHint;
                if (bl2) {
                    object = ((WithHint)object).getHint();
                    editorInfo.hintText = object;
                    break;
                }
                object = ((ViewParent)object).getParent();
            }
        }
        return inputConnection;
    }
}

