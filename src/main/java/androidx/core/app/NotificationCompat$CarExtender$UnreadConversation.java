/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 */
package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.app.RemoteInput;

public class NotificationCompat$CarExtender$UnreadConversation {
    private final long mLatestTimestamp;
    private final String[] mMessages;
    private final String[] mParticipants;
    private final PendingIntent mReadPendingIntent;
    private final RemoteInput mRemoteInput;
    private final PendingIntent mReplyPendingIntent;

    public NotificationCompat$CarExtender$UnreadConversation(String[] stringArray, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] stringArray2, long l10) {
        this.mMessages = stringArray;
        this.mRemoteInput = remoteInput;
        this.mReadPendingIntent = pendingIntent2;
        this.mReplyPendingIntent = pendingIntent;
        this.mParticipants = stringArray2;
        this.mLatestTimestamp = l10;
    }

    public long getLatestTimestamp() {
        return this.mLatestTimestamp;
    }

    public String[] getMessages() {
        return this.mMessages;
    }

    public String getParticipant() {
        Object object = this.mParticipants;
        int n10 = ((String[])object).length;
        if (n10 > 0) {
            n10 = 0;
            object = object[0];
        } else {
            object = null;
        }
        return object;
    }

    public String[] getParticipants() {
        return this.mParticipants;
    }

    public PendingIntent getReadPendingIntent() {
        return this.mReadPendingIntent;
    }

    public RemoteInput getRemoteInput() {
        return this.mRemoteInput;
    }

    public PendingIntent getReplyPendingIntent() {
        return this.mReplyPendingIntent;
    }
}

