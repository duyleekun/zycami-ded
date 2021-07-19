/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.inputmethod.InputConnection
 *  android.view.inputmethod.InputConnectionWrapper
 */
package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener;

public class InputConnectionCompat$2
extends InputConnectionWrapper {
    public final /* synthetic */ InputConnectionCompat$OnCommitContentListener val$listener;

    public InputConnectionCompat$2(InputConnection inputConnection, boolean bl2, InputConnectionCompat$OnCommitContentListener inputConnectionCompat$OnCommitContentListener) {
        this.val$listener = inputConnectionCompat$OnCommitContentListener;
        super(inputConnection, bl2);
    }

    public boolean performPrivateCommand(String string2, Bundle bundle) {
        InputConnectionCompat$OnCommitContentListener inputConnectionCompat$OnCommitContentListener = this.val$listener;
        boolean bl2 = InputConnectionCompat.handlePerformPrivateCommand(string2, bundle, inputConnectionCompat$OnCommitContentListener);
        if (bl2) {
            return true;
        }
        return super.performPrivateCommand(string2, bundle);
    }
}

