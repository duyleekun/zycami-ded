/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.RemoteInput;
import java.util.HashSet;
import java.util.Set;

public final class RemoteInput$Builder {
    private boolean mAllowFreeFormTextInput;
    private final Set mAllowedDataTypes;
    private CharSequence[] mChoices;
    private int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private CharSequence mLabel;
    private final String mResultKey;

    public RemoteInput$Builder(String object) {
        Bundle bundle;
        this.mAllowedDataTypes = bundle = new HashSet();
        this.mExtras = bundle = new Bundle();
        this.mAllowFreeFormTextInput = true;
        bundle = null;
        this.mEditChoicesBeforeSending = 0;
        if (object != null) {
            this.mResultKey = object;
            return;
        }
        object = new IllegalArgumentException("Result key can't be null");
        throw object;
    }

    public RemoteInput$Builder addExtras(Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = this.mExtras;
            bundle2.putAll(bundle);
        }
        return this;
    }

    public RemoteInput build() {
        String string2 = this.mResultKey;
        CharSequence charSequence = this.mLabel;
        CharSequence[] charSequenceArray = this.mChoices;
        boolean bl2 = this.mAllowFreeFormTextInput;
        int n10 = this.mEditChoicesBeforeSending;
        Bundle bundle = this.mExtras;
        Set set = this.mAllowedDataTypes;
        RemoteInput remoteInput = new RemoteInput(string2, charSequence, charSequenceArray, bl2, n10, bundle, set);
        return remoteInput;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public RemoteInput$Builder setAllowDataType(String string2, boolean bl2) {
        if (bl2) {
            Set set = this.mAllowedDataTypes;
            set.add(string2);
        } else {
            Set set = this.mAllowedDataTypes;
            set.remove(string2);
        }
        return this;
    }

    public RemoteInput$Builder setAllowFreeFormInput(boolean bl2) {
        this.mAllowFreeFormTextInput = bl2;
        return this;
    }

    public RemoteInput$Builder setChoices(CharSequence[] charSequenceArray) {
        this.mChoices = charSequenceArray;
        return this;
    }

    public RemoteInput$Builder setEditChoicesBeforeSending(int n10) {
        this.mEditChoicesBeforeSending = n10;
        return this;
    }

    public RemoteInput$Builder setLabel(CharSequence charSequence) {
        this.mLabel = charSequence;
        return this;
    }
}

