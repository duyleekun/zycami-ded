/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification$DecoratedMediaCustomViewStyle
 *  android.app.Notification$MediaStyle
 *  android.app.Notification$Style
 *  android.os.Build$VERSION
 *  android.widget.RemoteViews
 */
package androidx.media.app;

import android.app.Notification;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat$Builder;
import androidx.media.R$color;
import androidx.media.R$id;
import androidx.media.R$layout;
import androidx.media.app.NotificationCompat$MediaStyle;

public class NotificationCompat$DecoratedMediaCustomViewStyle
extends NotificationCompat$MediaStyle {
    private void setBackgroundColor(RemoteViews remoteViews) {
        int n10;
        NotificationCompat$Builder notificationCompat$Builder = this.mBuilder;
        int n11 = notificationCompat$Builder.getColor();
        if (n11 != 0) {
            notificationCompat$Builder = this.mBuilder;
            n11 = notificationCompat$Builder.getColor();
        } else {
            notificationCompat$Builder = this.mBuilder.mContext.getResources();
            n10 = R$color.notification_material_background_media_default_color;
            n11 = notificationCompat$Builder.getColor(n10);
        }
        n10 = R$id.status_bar_latest_event_content;
        remoteViews.setInt(n10, "setBackgroundColor", n11);
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            notificationBuilderWithBuilderAccessor = notificationBuilderWithBuilderAccessor.getBuilder();
            Notification.DecoratedMediaCustomViewStyle decoratedMediaCustomViewStyle = new Notification.DecoratedMediaCustomViewStyle();
            decoratedMediaCustomViewStyle = this.fillInMediaStyle((Notification.MediaStyle)decoratedMediaCustomViewStyle);
            notificationBuilderWithBuilderAccessor.setStyle((Notification.Style)decoratedMediaCustomViewStyle);
        } else {
            super.apply(notificationBuilderWithBuilderAccessor);
        }
    }

    public int getBigContentViewLayoutResource(int n10) {
        int n11 = 3;
        n10 = n10 <= n11 ? R$layout.notification_template_big_media_narrow_custom : R$layout.notification_template_big_media_custom;
        return n10;
    }

    public int getContentViewLayoutResource() {
        RemoteViews remoteViews = this.mBuilder.getContentView();
        int n10 = remoteViews != null ? R$layout.notification_template_media_custom : super.getContentViewLayoutResource();
        return n10;
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int n10 = Build.VERSION.SDK_INT;
        RemoteViews remoteViews = null;
        int n11 = 24;
        if (n10 >= n11) {
            return null;
        }
        RemoteViews remoteViews2 = this.mBuilder.getBigContentView();
        remoteViews2 = remoteViews2 != null ? this.mBuilder.getBigContentView() : this.mBuilder.getContentView();
        if (remoteViews2 == null) {
            return null;
        }
        remoteViews = this.generateBigContentView();
        this.buildIntoRemoteViews(remoteViews, remoteViews2);
        n11 = 21;
        if (n10 >= n11) {
            this.setBackgroundColor(remoteViews);
        }
        return remoteViews;
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int n10 = Build.VERSION.SDK_INT;
        RemoteViews remoteViews = null;
        int n11 = 24;
        if (n10 >= n11) {
            return null;
        }
        RemoteViews remoteViews2 = this.mBuilder.getContentView();
        int n12 = 1;
        if (remoteViews2 != null) {
            n11 = n12;
        } else {
            n11 = 0;
            remoteViews2 = null;
        }
        int n13 = 21;
        if (n10 >= n13) {
            if (n11 == 0 && (notificationBuilderWithBuilderAccessor = this.mBuilder.getBigContentView()) == null) {
                n12 = 0;
            }
            if (n12 != 0) {
                notificationBuilderWithBuilderAccessor = this.generateContentView();
                if (n11 != 0) {
                    remoteViews = this.mBuilder.getContentView();
                    this.buildIntoRemoteViews((RemoteViews)notificationBuilderWithBuilderAccessor, remoteViews);
                }
                this.setBackgroundColor((RemoteViews)notificationBuilderWithBuilderAccessor);
                return notificationBuilderWithBuilderAccessor;
            }
        } else {
            notificationBuilderWithBuilderAccessor = this.generateContentView();
            if (n11 != 0) {
                remoteViews = this.mBuilder.getContentView();
                this.buildIntoRemoteViews((RemoteViews)notificationBuilderWithBuilderAccessor, remoteViews);
                return notificationBuilderWithBuilderAccessor;
            }
        }
        return null;
    }

    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int n10 = Build.VERSION.SDK_INT;
        RemoteViews remoteViews = null;
        int n11 = 24;
        if (n10 >= n11) {
            return null;
        }
        RemoteViews remoteViews2 = this.mBuilder.getHeadsUpContentView();
        remoteViews2 = remoteViews2 != null ? this.mBuilder.getHeadsUpContentView() : this.mBuilder.getContentView();
        if (remoteViews2 == null) {
            return null;
        }
        remoteViews = this.generateBigContentView();
        this.buildIntoRemoteViews(remoteViews, remoteViews2);
        n11 = 21;
        if (n10 >= n11) {
            this.setBackgroundColor(remoteViews);
        }
        return remoteViews;
    }
}

