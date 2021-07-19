/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification$BigTextStyle
 *  android.app.Notification$Builder
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package androidx.core.app;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$Style;

public class NotificationCompat$BigTextStyle
extends NotificationCompat$Style {
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
    private CharSequence mBigText;

    public NotificationCompat$BigTextStyle() {
    }

    public NotificationCompat$BigTextStyle(NotificationCompat$Builder notificationCompat$Builder) {
        this.setBuilder(notificationCompat$Builder);
    }

    public void addCompatExtras(Bundle bundle) {
        super.addCompatExtras(bundle);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            CharSequence charSequence = this.mBigText;
            String string2 = "android.bigText";
            bundle.putCharSequence(string2, charSequence);
        }
    }

    public void apply(NotificationBuilderWithBuilderAccessor object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            object = object.getBuilder();
            Object object2 = new Notification.BigTextStyle((Notification.Builder)object);
            object = this.mBigContentTitle;
            object = object2.setBigContentTitle((CharSequence)object);
            object2 = this.mBigText;
            object = object.bigText((CharSequence)object2);
            n10 = (int)(this.mSummaryTextSet ? 1 : 0);
            if (n10 != 0) {
                object2 = this.mSummaryText;
                object.setSummaryText((CharSequence)object2);
            }
        }
    }

    public NotificationCompat$BigTextStyle bigText(CharSequence charSequence) {
        this.mBigText = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public void clearCompatExtraKeys(Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove("android.bigText");
    }

    public String getClassName() {
        return TEMPLATE_CLASS_NAME;
    }

    public void restoreFromCompatExtras(Bundle object) {
        super.restoreFromCompatExtras((Bundle)object);
        object = object.getCharSequence("android.bigText");
        this.mBigText = object;
    }

    public NotificationCompat$BigTextStyle setBigContentTitle(CharSequence charSequence) {
        this.mBigContentTitle = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat$BigTextStyle setSummaryText(CharSequence charSequence) {
        this.mSummaryText = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.mSummaryTextSet = true;
        return this;
    }
}

