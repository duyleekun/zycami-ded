/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipDescription
 *  android.net.Uri
 *  android.os.Build$VERSION
 */
package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatApi25Impl;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatBaseImpl;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl;

public final class InputContentInfoCompat {
    private final InputContentInfoCompat$InputContentInfoCompatImpl mImpl;

    public InputContentInfoCompat(Uri uri, ClipDescription clipDescription, Uri uri2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            InputContentInfoCompat$InputContentInfoCompatApi25Impl inputContentInfoCompat$InputContentInfoCompatApi25Impl = new InputContentInfoCompat$InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
            this.mImpl = inputContentInfoCompat$InputContentInfoCompatApi25Impl;
        } else {
            InputContentInfoCompat$InputContentInfoCompatBaseImpl inputContentInfoCompat$InputContentInfoCompatBaseImpl = new InputContentInfoCompat$InputContentInfoCompatBaseImpl(uri, clipDescription, uri2);
            this.mImpl = inputContentInfoCompat$InputContentInfoCompatBaseImpl;
        }
    }

    private InputContentInfoCompat(InputContentInfoCompat$InputContentInfoCompatImpl inputContentInfoCompat$InputContentInfoCompatImpl) {
        this.mImpl = inputContentInfoCompat$InputContentInfoCompatImpl;
    }

    public static InputContentInfoCompat wrap(Object object) {
        InputContentInfoCompat inputContentInfoCompat = null;
        if (object == null) {
            return null;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 < n11) {
            return null;
        }
        InputContentInfoCompat$InputContentInfoCompatApi25Impl inputContentInfoCompat$InputContentInfoCompatApi25Impl = new InputContentInfoCompat$InputContentInfoCompatApi25Impl(object);
        inputContentInfoCompat = new InputContentInfoCompat(inputContentInfoCompat$InputContentInfoCompatApi25Impl);
        return inputContentInfoCompat;
    }

    public Uri getContentUri() {
        return this.mImpl.getContentUri();
    }

    public ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    public Uri getLinkUri() {
        return this.mImpl.getLinkUri();
    }

    public void releasePermission() {
        this.mImpl.releasePermission();
    }

    public void requestPermission() {
        this.mImpl.requestPermission();
    }

    public Object unwrap() {
        return this.mImpl.getInputContentInfo();
    }
}

