/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.inputmethod.InputConnection
 *  android.view.inputmethod.InputConnectionWrapper
 *  android.view.inputmethod.InputContentInfo
 */
package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener;
import androidx.core.view.inputmethod.InputContentInfoCompat;

public class InputConnectionCompat$1
extends InputConnectionWrapper {
    public final /* synthetic */ InputConnectionCompat$OnCommitContentListener val$listener;

    public InputConnectionCompat$1(InputConnection inputConnection, boolean bl2, InputConnectionCompat$OnCommitContentListener inputConnectionCompat$OnCommitContentListener) {
        this.val$listener = inputConnectionCompat$OnCommitContentListener;
        super(inputConnection, bl2);
    }

    public boolean commitContent(InputContentInfo inputContentInfo, int n10, Bundle bundle) {
        InputConnectionCompat$OnCommitContentListener inputConnectionCompat$OnCommitContentListener = this.val$listener;
        InputContentInfoCompat inputContentInfoCompat = InputContentInfoCompat.wrap(inputContentInfo);
        boolean bl2 = inputConnectionCompat$OnCommitContentListener.onCommitContent(inputContentInfoCompat, n10, bundle);
        if (bl2) {
            return true;
        }
        return super.commitContent(inputContentInfo, n10, bundle);
    }
}

