/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipDescription
 *  android.net.Uri
 */
package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl;

public final class InputContentInfoCompat$InputContentInfoCompatBaseImpl
implements InputContentInfoCompat$InputContentInfoCompatImpl {
    private final Uri mContentUri;
    private final ClipDescription mDescription;
    private final Uri mLinkUri;

    public InputContentInfoCompat$InputContentInfoCompatBaseImpl(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.mContentUri = uri;
        this.mDescription = clipDescription;
        this.mLinkUri = uri2;
    }

    public Uri getContentUri() {
        return this.mContentUri;
    }

    public ClipDescription getDescription() {
        return this.mDescription;
    }

    public Object getInputContentInfo() {
        return null;
    }

    public Uri getLinkUri() {
        return this.mLinkUri;
    }

    public void releasePermission() {
    }

    public void requestPermission() {
    }
}

