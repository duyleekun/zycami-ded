/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification$DecoratedCustomViewStyle
 *  android.app.Notification$Style
 *  android.app.PendingIntent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.widget.RemoteViews
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.R$color;
import androidx.core.R$id;
import androidx.core.R$layout;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Style;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.List;

public class NotificationCompat$DecoratedCustomViewStyle
extends NotificationCompat$Style {
    private static final int MAX_ACTION_BUTTONS = 3;
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";

    /*
     * Unable to fully structure code
     */
    private RemoteViews createRemoteViews(RemoteViews var1_1, boolean var2_2) {
        var3_3 = R$layout.notification_template_custom_big;
        var4_4 = true;
        var5_5 = 0;
        var6_6 = this.applyStandardTemplate(var4_4, var3_3, false);
        var7_7 = R$id.actions;
        var6_6.removeAllViews(var7_7);
        var8_8 = NotificationCompat$DecoratedCustomViewStyle.getNonContextualActions(this.mBuilder.mActions);
        if (var2_2 == 0 || var8_8 == null) ** GOTO lbl-1000
        var2_2 = var8_8.size();
        var9_9 = 3;
        if ((var2_2 = Math.min(var2_2, var9_9)) > 0) {
            for (var9_9 = 0; var9_9 < var2_2; ++var9_9) {
                var10_10 = (NotificationCompat$Action)var8_8.get(var9_9);
                var10_10 = this.generateActionButton(var10_10);
                var11_11 = R$id.actions;
                var6_6.addView(var11_11, (RemoteViews)var10_10);
            }
        } else lbl-1000:
        // 2 sources

        {
            var4_4 = false;
        }
        if (!var4_4) {
            var5_5 = 8;
        }
        var2_2 = R$id.actions;
        var6_6.setViewVisibility(var2_2, var5_5);
        var2_2 = R$id.action_divider;
        var6_6.setViewVisibility(var2_2, var5_5);
        this.buildIntoRemoteViews(var6_6, var1_1);
        return var6_6;
    }

    private RemoteViews generateActionButton(NotificationCompat$Action object) {
        int n10;
        PendingIntent pendingIntent = ((NotificationCompat$Action)object).actionIntent;
        if (pendingIntent == null) {
            n10 = 1;
        } else {
            n10 = 0;
            pendingIntent = null;
        }
        Object object2 = this.mBuilder.mContext.getPackageName();
        int n11 = n10 != 0 ? R$layout.notification_action_tombstone : R$layout.notification_action;
        RemoteViews remoteViews = new RemoteViews((String)object2, n11);
        object2 = ((NotificationCompat$Action)object).getIconCompat();
        if (object2 != null) {
            n11 = R$id.action_image;
            Resources resources = this.mBuilder.mContext.getResources();
            int n12 = R$color.notification_action_color_filter;
            int n13 = resources.getColor(n12);
            object2 = this.createColoredBitmap((IconCompat)object2, n13);
            remoteViews.setImageViewBitmap(n11, (Bitmap)object2);
        }
        int n14 = R$id.action_text;
        CharSequence charSequence = ((NotificationCompat$Action)object).title;
        remoteViews.setTextViewText(n14, charSequence);
        if (n10 == 0) {
            n10 = R$id.action_container;
            object2 = ((NotificationCompat$Action)object).actionIntent;
            remoteViews.setOnClickPendingIntent(n10, (PendingIntent)object2);
        }
        if ((n10 = Build.VERSION.SDK_INT) >= (n14 = 15)) {
            n10 = R$id.action_container;
            object = ((NotificationCompat$Action)object).title;
            remoteViews.setContentDescription(n10, (CharSequence)object);
        }
        return remoteViews;
    }

    private static List getNonContextualActions(List object) {
        boolean bl2;
        if (object == null) {
            return null;
        }
        ArrayList<NotificationCompat$Action> arrayList = new ArrayList<NotificationCompat$Action>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            NotificationCompat$Action notificationCompat$Action = (NotificationCompat$Action)object.next();
            boolean bl3 = notificationCompat$Action.isContextual();
            if (bl3) continue;
            arrayList.add(notificationCompat$Action);
        }
        return arrayList;
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            notificationBuilderWithBuilderAccessor = notificationBuilderWithBuilderAccessor.getBuilder();
            Notification.DecoratedCustomViewStyle decoratedCustomViewStyle = new Notification.DecoratedCustomViewStyle();
            notificationBuilderWithBuilderAccessor.setStyle((Notification.Style)decoratedCustomViewStyle);
        }
    }

    public boolean displayCustomViewInline() {
        return true;
    }

    public String getClassName() {
        return TEMPLATE_CLASS_NAME;
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return null;
        }
        notificationBuilderWithBuilderAccessor = this.mBuilder.getBigContentView();
        if (notificationBuilderWithBuilderAccessor == null) {
            notificationBuilderWithBuilderAccessor = this.mBuilder.getContentView();
        }
        if (notificationBuilderWithBuilderAccessor == null) {
            return null;
        }
        return this.createRemoteViews((RemoteViews)notificationBuilderWithBuilderAccessor, true);
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return null;
        }
        notificationBuilderWithBuilderAccessor = this.mBuilder.getContentView();
        if (notificationBuilderWithBuilderAccessor == null) {
            return null;
        }
        notificationBuilderWithBuilderAccessor = this.mBuilder.getContentView();
        return this.createRemoteViews((RemoteViews)notificationBuilderWithBuilderAccessor, false);
    }

    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return null;
        }
        notificationBuilderWithBuilderAccessor = this.mBuilder.getHeadsUpContentView();
        NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor2 = notificationBuilderWithBuilderAccessor != null ? notificationBuilderWithBuilderAccessor : this.mBuilder.getContentView();
        if (notificationBuilderWithBuilderAccessor == null) {
            return null;
        }
        return this.createRemoteViews((RemoteViews)notificationBuilderWithBuilderAccessor2, true);
    }
}

