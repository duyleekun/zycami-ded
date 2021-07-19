/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 */
package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.app.NotificationCompat$CarExtender$UnreadConversation;
import androidx.core.app.RemoteInput;
import java.util.ArrayList;
import java.util.List;

public class NotificationCompat$CarExtender$UnreadConversation$Builder {
    private long mLatestTimestamp;
    private final List mMessages;
    private final String mParticipant;
    private PendingIntent mReadPendingIntent;
    private RemoteInput mRemoteInput;
    private PendingIntent mReplyPendingIntent;

    public NotificationCompat$CarExtender$UnreadConversation$Builder(String string2) {
        ArrayList arrayList;
        this.mMessages = arrayList = new ArrayList();
        this.mParticipant = string2;
    }

    public NotificationCompat$CarExtender$UnreadConversation$Builder addMessage(String string2) {
        if (string2 != null) {
            List list = this.mMessages;
            list.add(string2);
        }
        return this;
    }

    public NotificationCompat$CarExtender$UnreadConversation build() {
        Object object = this.mMessages;
        String[] stringArray = new String[object.size()];
        String[] stringArray2 = object = object.toArray(stringArray);
        stringArray2 = object;
        object = this.mParticipant;
        String[] stringArray3 = new String[]{object};
        RemoteInput remoteInput = this.mRemoteInput;
        PendingIntent pendingIntent = this.mReplyPendingIntent;
        PendingIntent pendingIntent2 = this.mReadPendingIntent;
        long l10 = this.mLatestTimestamp;
        stringArray = object;
        object = new NotificationCompat$CarExtender$UnreadConversation(stringArray2, remoteInput, pendingIntent, pendingIntent2, stringArray3, l10);
        return object;
    }

    public NotificationCompat$CarExtender$UnreadConversation$Builder setLatestTimestamp(long l10) {
        this.mLatestTimestamp = l10;
        return this;
    }

    public NotificationCompat$CarExtender$UnreadConversation$Builder setReadPendingIntent(PendingIntent pendingIntent) {
        this.mReadPendingIntent = pendingIntent;
        return this;
    }

    public NotificationCompat$CarExtender$UnreadConversation$Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
        this.mRemoteInput = remoteInput;
        this.mReplyPendingIntent = pendingIntent;
        return this;
    }
}

