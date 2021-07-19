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

public interface InputContentInfoCompat$InputContentInfoCompatImpl {
    public Uri getContentUri();

    public ClipDescription getDescription();

    public Object getInputContentInfo();

    public Uri getLinkUri();

    public void releasePermission();

    public void requestPermission();
}

