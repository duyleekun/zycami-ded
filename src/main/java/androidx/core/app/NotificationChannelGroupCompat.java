/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.NotificationChannel
 *  android.app.NotificationChannelGroup
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationChannelGroupCompat$Builder;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotificationChannelGroupCompat {
    private boolean mBlocked;
    private List mChannels;
    public String mDescription;
    public final String mId;
    public CharSequence mName;

    public NotificationChannelGroupCompat(NotificationChannelGroup notificationChannelGroup) {
        List list = Collections.emptyList();
        this(notificationChannelGroup, list);
    }

    public NotificationChannelGroupCompat(NotificationChannelGroup object, List list) {
        CharSequence charSequence = object.getId();
        this((String)charSequence);
        charSequence = object.getName();
        this.mName = charSequence;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            String string2;
            this.mDescription = string2 = object.getDescription();
        }
        if (n10 >= n11) {
            boolean bl2;
            this.mBlocked = bl2 = object.isBlocked();
            object = object.getChannels();
            object = this.getChannelsCompat((List)object);
            this.mChannels = object;
        } else {
            object = this.getChannelsCompat(list);
            this.mChannels = object;
        }
    }

    public NotificationChannelGroupCompat(String string2) {
        List list;
        this.mChannels = list = Collections.emptyList();
        this.mId = string2 = (String)Preconditions.checkNotNull(string2);
    }

    private List getChannelsCompat(List object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = this.mId;
            NotificationChannel notificationChannel = (NotificationChannel)object.next();
            String string2 = notificationChannel.getGroup();
            boolean bl3 = ((String)object2).equals(string2);
            if (!bl3) continue;
            object2 = new NotificationChannelCompat(notificationChannel);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public List getChannels() {
        return this.mChannels;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getId() {
        return this.mId;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public NotificationChannelGroup getNotificationChannelGroup() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            return null;
        }
        String string2 = this.mId;
        CharSequence charSequence = this.mName;
        NotificationChannelGroup notificationChannelGroup = new NotificationChannelGroup(string2, charSequence);
        int n12 = 28;
        if (n10 >= n12) {
            String string3 = this.mDescription;
            notificationChannelGroup.setDescription(string3);
        }
        return notificationChannelGroup;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    public NotificationChannelGroupCompat$Builder toBuilder() {
        CharSequence charSequence = this.mId;
        NotificationChannelGroupCompat$Builder notificationChannelGroupCompat$Builder = new NotificationChannelGroupCompat$Builder((String)charSequence);
        charSequence = this.mName;
        notificationChannelGroupCompat$Builder = notificationChannelGroupCompat$Builder.setName(charSequence);
        charSequence = this.mDescription;
        return notificationChannelGroupCompat$Builder.setDescription((String)charSequence);
    }
}

