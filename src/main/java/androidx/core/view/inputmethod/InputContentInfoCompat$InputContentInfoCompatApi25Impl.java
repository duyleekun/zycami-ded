/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipDescription
 *  android.net.Uri
 *  android.view.inputmethod.InputContentInfo
 */
package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl;

public final class InputContentInfoCompat$InputContentInfoCompatApi25Impl
implements InputContentInfoCompat$InputContentInfoCompatImpl {
    public final InputContentInfo mObject;

    public InputContentInfoCompat$InputContentInfoCompatApi25Impl(Uri uri, ClipDescription clipDescription, Uri uri2) {
        InputContentInfo inputContentInfo;
        this.mObject = inputContentInfo = new InputContentInfo(uri, clipDescription, uri2);
    }

    public InputContentInfoCompat$InputContentInfoCompatApi25Impl(Object object) {
        object = (InputContentInfo)object;
        this.mObject = object;
    }

    public Uri getContentUri() {
        return this.mObject.getContentUri();
    }

    public ClipDescription getDescription() {
        return this.mObject.getDescription();
    }

    public Object getInputContentInfo() {
        return this.mObject;
    }

    public Uri getLinkUri() {
        return this.mObject.getLinkUri();
    }

    public void releasePermission() {
        this.mObject.releasePermission();
    }

    public void requestPermission() {
        this.mObject.requestPermission();
    }
}

