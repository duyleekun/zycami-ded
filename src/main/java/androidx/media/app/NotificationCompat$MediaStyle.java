/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$MediaStyle
 *  android.app.Notification$Style
 *  android.app.PendingIntent
 *  android.content.res.Resources
 *  android.media.session.MediaSession$Token
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.widget.RemoteViews
 */
package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.res.Resources;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.widget.RemoteViews;
import androidx.core.app.BundleCompat;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$Style;
import androidx.media.R$id;
import androidx.media.R$integer;
import androidx.media.R$layout;
import java.util.ArrayList;

public class NotificationCompat$MediaStyle
extends NotificationCompat$Style {
    private static final int MAX_MEDIA_BUTTONS = 5;
    private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
    public int[] mActionsToShowInCompact = null;
    public PendingIntent mCancelButtonIntent;
    public boolean mShowCancelButton;
    public MediaSessionCompat$Token mToken;

    public NotificationCompat$MediaStyle() {
    }

    public NotificationCompat$MediaStyle(NotificationCompat$Builder notificationCompat$Builder) {
        this.setBuilder(notificationCompat$Builder);
    }

    private RemoteViews generateMediaActionButton(NotificationCompat$Action object) {
        int n10;
        PendingIntent pendingIntent = ((NotificationCompat$Action)object).getActionIntent();
        if (pendingIntent == null) {
            n10 = 1;
        } else {
            n10 = 0;
            pendingIntent = null;
        }
        String string2 = this.mBuilder.mContext.getPackageName();
        int n11 = R$layout.notification_media_action;
        RemoteViews remoteViews = new RemoteViews(string2, n11);
        int n12 = R$id.action0;
        n11 = ((NotificationCompat$Action)object).getIcon();
        remoteViews.setImageViewResource(n12, n11);
        if (n10 == 0) {
            pendingIntent = ((NotificationCompat$Action)object).getActionIntent();
            remoteViews.setOnClickPendingIntent(n12, pendingIntent);
        }
        if ((n10 = Build.VERSION.SDK_INT) >= (n11 = 15)) {
            object = ((NotificationCompat$Action)object).getTitle();
            remoteViews.setContentDescription(n12, (CharSequence)object);
        }
        return remoteViews;
    }

    public static MediaSessionCompat$Token getMediaSession(Notification object) {
        if ((object = NotificationCompat.getExtras(object)) != null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 21;
            String string2 = "android.mediaSession";
            if (n10 >= n11) {
                if ((object = object.getParcelable(string2)) != null) {
                    return MediaSessionCompat$Token.fromToken(object);
                }
            } else if ((object = BundleCompat.getBinder((Bundle)object, string2)) != null) {
                Parcel parcel = Parcel.obtain();
                parcel.writeStrongBinder((IBinder)object);
                parcel.setDataPosition(0);
                object = (MediaSessionCompat$Token)MediaSessionCompat$Token.CREATOR.createFromParcel(parcel);
                parcel.recycle();
                return object;
            }
        }
        return null;
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            notificationBuilderWithBuilderAccessor = notificationBuilderWithBuilderAccessor.getBuilder();
            Notification.MediaStyle mediaStyle = new Notification.MediaStyle();
            mediaStyle = this.fillInMediaStyle(mediaStyle);
            notificationBuilderWithBuilderAccessor.setStyle((Notification.Style)mediaStyle);
        } else {
            n10 = (int)(this.mShowCancelButton ? 1 : 0);
            if (n10) {
                notificationBuilderWithBuilderAccessor = notificationBuilderWithBuilderAccessor.getBuilder();
                n10 = 1;
                notificationBuilderWithBuilderAccessor.setOngoing(n10 != 0);
            }
        }
    }

    public Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle mediaStyle) {
        Object object = this.mActionsToShowInCompact;
        if (object != null) {
            mediaStyle.setShowActionsInCompactView(object);
        }
        if ((object = (Object)this.mToken) != null) {
            object = (MediaSession.Token)object.getToken();
            mediaStyle.setMediaSession((MediaSession.Token)object);
        }
        return mediaStyle;
    }

    public RemoteViews generateBigContentView() {
        String string2;
        ArrayList arrayList = this.mBuilder.mActions;
        int n10 = Math.min(arrayList.size(), 5);
        int n11 = this.getBigContentViewLayoutResource(n10);
        int n12 = 0;
        Resources resources = null;
        RemoteViews remoteViews = this.applyStandardTemplate(false, n11, false);
        int n13 = R$id.media_actions;
        remoteViews.removeAllViews(n13);
        if (n10 > 0) {
            string2 = null;
            for (n13 = 0; n13 < n10; ++n13) {
                NotificationCompat$Action notificationCompat$Action = (NotificationCompat$Action)this.mBuilder.mActions.get(n13);
                notificationCompat$Action = this.generateMediaActionButton(notificationCompat$Action);
                int n14 = R$id.media_actions;
                remoteViews.addView(n14, (RemoteViews)notificationCompat$Action);
            }
        }
        if ((n10 = (int)(this.mShowCancelButton ? 1 : 0)) != 0) {
            n10 = R$id.cancel_action;
            remoteViews.setViewVisibility(n10, 0);
            resources = this.mBuilder.mContext.getResources();
            n13 = R$integer.cancel_button_image_alpha;
            n12 = resources.getInteger(n13);
            string2 = "setAlpha";
            remoteViews.setInt(n10, string2, n12);
            resources = this.mCancelButtonIntent;
            remoteViews.setOnClickPendingIntent(n10, (PendingIntent)resources);
        } else {
            n10 = R$id.cancel_action;
            n12 = 8;
            remoteViews.setViewVisibility(n10, n12);
        }
        return remoteViews;
    }

    public RemoteViews generateContentView() {
        int n10;
        int n11;
        int n12 = this.getContentViewLayoutResource();
        int n13 = 0;
        Object object = null;
        int n14 = 1;
        Object object2 = this.applyStandardTemplate(false, n12, n14 != 0);
        Object object3 = this.mBuilder.mActions;
        int n15 = ((ArrayList)object3).size();
        Object[] objectArray = this.mActionsToShowInCompact;
        if (objectArray == null) {
            n11 = 0;
            objectArray = null;
        } else {
            n11 = objectArray.length;
            n10 = 3;
            n11 = Math.min(n11, n10);
        }
        n10 = R$id.media_actions;
        object2.removeAllViews(n10);
        if (n11 > 0) {
            Integer n16 = null;
            for (n10 = 0; n10 < n11; ++n10) {
                if (n10 < n15) {
                    Object object4 = this.mBuilder.mActions;
                    int[] nArray = this.mActionsToShowInCompact;
                    int n17 = nArray[n10];
                    object4 = (NotificationCompat$Action)((ArrayList)object4).get(n17);
                    object4 = this.generateMediaActionButton((NotificationCompat$Action)object4);
                    n17 = R$id.media_actions;
                    object2.addView(n17, (RemoteViews)object4);
                    continue;
                }
                objectArray = new Object[2];
                n16 = n10;
                objectArray[0] = n16;
                object = n15 - n14;
                objectArray[n14] = (int)object;
                object = String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", objectArray);
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
        }
        n14 = this.mShowCancelButton;
        n15 = 8;
        if (n14 != 0) {
            n14 = R$id.end_padder;
            object2.setViewVisibility(n14, n15);
            n14 = R$id.cancel_action;
            object2.setViewVisibility(n14, 0);
            object = this.mCancelButtonIntent;
            object2.setOnClickPendingIntent(n14, object);
            object = this.mBuilder.mContext.getResources();
            n15 = R$integer.cancel_button_image_alpha;
            n13 = object.getInteger(n15);
            object3 = "setAlpha";
            object2.setInt(n14, (String)object3, n13);
        } else {
            n14 = R$id.end_padder;
            object2.setViewVisibility(n14, 0);
            n13 = R$id.cancel_action;
            object2.setViewVisibility(n13, n15);
        }
        return object2;
    }

    public int getBigContentViewLayoutResource(int n10) {
        int n11 = 3;
        n10 = n10 <= n11 ? R$layout.notification_template_big_media_narrow : R$layout.notification_template_big_media;
        return n10;
    }

    public int getContentViewLayoutResource() {
        return R$layout.notification_template_media;
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return null;
        }
        return this.generateBigContentView();
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return null;
        }
        return this.generateContentView();
    }

    public NotificationCompat$MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
        this.mCancelButtonIntent = pendingIntent;
        return this;
    }

    public NotificationCompat$MediaStyle setMediaSession(MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.mToken = mediaSessionCompat$Token;
        return this;
    }

    public NotificationCompat$MediaStyle setShowActionsInCompactView(int ... nArray) {
        this.mActionsToShowInCompact = nArray;
        return this;
    }

    public NotificationCompat$MediaStyle setShowCancelButton(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            this.mShowCancelButton = bl2;
        }
        return this;
    }
}

