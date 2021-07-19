/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.media;

import android.os.Bundle;

public class MediaBrowserServiceCompat$Result {
    private final Object mDebug;
    private boolean mDetachCalled;
    private int mFlags;
    private boolean mSendErrorCalled;
    private boolean mSendResultCalled;

    public MediaBrowserServiceCompat$Result(Object object) {
        this.mDebug = object;
    }

    private void checkExtraFields(Bundle object) {
        block4: {
            block5: {
                float f10;
                if (object == null) {
                    return;
                }
                String string2 = "android.media.browse.extra.DOWNLOAD_PROGRESS";
                boolean bl2 = object.containsKey(string2);
                if (!bl2) break block4;
                float f11 = object.getFloat(string2);
                float f12 = f11 - (f10 = -1.0E-5f);
                Object object2 = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
                if (object2 < 0) break block5;
                object2 = 1065353300;
                f10 = 1.00001f;
                float f13 = f11 - f10;
                Object object3 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
                if (object3 <= 0) break block4;
            }
            object = new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0]");
            throw object;
        }
    }

    public void detach() {
        boolean bl2 = this.mDetachCalled;
        if (!bl2) {
            bl2 = this.mSendResultCalled;
            if (!bl2) {
                bl2 = this.mSendErrorCalled;
                if (!bl2) {
                    this.mDetachCalled = true;
                    return;
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("detach() called when sendError() had already been called for: ");
                Object object = this.mDebug;
                charSequence.append(object);
                charSequence = charSequence.toString();
                IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
                throw illegalStateException;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("detach() called when sendResult() had already been called for: ");
            Object object = this.mDebug;
            charSequence.append(object);
            charSequence = charSequence.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
            throw illegalStateException;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("detach() called when detach() had already been called for: ");
        Object object = this.mDebug;
        charSequence.append(object);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public boolean isDone() {
        boolean bl2 = this.mDetachCalled;
        bl2 = bl2 || (bl2 = this.mSendResultCalled) || (bl2 = this.mSendErrorCalled);
        return bl2;
    }

    public void onErrorSent(Bundle object) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("It is not supported to send an error for ");
        Object object2 = this.mDebug;
        charSequence.append(object2);
        charSequence = charSequence.toString();
        object = new UnsupportedOperationException((String)charSequence);
        throw object;
    }

    public void onProgressUpdateSent(Bundle object) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("It is not supported to send an interim update for ");
        Object object2 = this.mDebug;
        charSequence.append(object2);
        charSequence = charSequence.toString();
        object = new UnsupportedOperationException((String)charSequence);
        throw object;
    }

    public void onResultSent(Object object) {
    }

    public void sendError(Bundle object) {
        boolean bl2 = this.mSendResultCalled;
        if (!bl2 && !(bl2 = this.mSendErrorCalled)) {
            this.mSendErrorCalled = true;
            this.onErrorSent((Bundle)object);
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("sendError() called when either sendResult() or sendError() had already been called for: ");
        Object object2 = this.mDebug;
        charSequence.append(object2);
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public void sendProgressUpdate(Bundle object) {
        boolean bl2 = this.mSendResultCalled;
        if (!bl2 && !(bl2 = this.mSendErrorCalled)) {
            this.checkExtraFields((Bundle)object);
            this.onProgressUpdateSent((Bundle)object);
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: ");
        Object object2 = this.mDebug;
        charSequence.append(object2);
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public void sendResult(Object object) {
        boolean bl2 = this.mSendResultCalled;
        if (!bl2 && !(bl2 = this.mSendErrorCalled)) {
            this.mSendResultCalled = true;
            this.onResultSent(object);
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("sendResult() called when either sendResult() or sendError() had already been called for: ");
        Object object2 = this.mDebug;
        charSequence.append(object2);
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public void setFlags(int n10) {
        this.mFlags = n10;
    }
}

