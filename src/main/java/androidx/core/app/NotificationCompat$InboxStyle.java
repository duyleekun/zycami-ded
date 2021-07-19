/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification$Builder
 *  android.app.Notification$InboxStyle
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
import java.util.ArrayList;
import java.util.Collections;

public class NotificationCompat$InboxStyle
extends NotificationCompat$Style {
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$InboxStyle";
    private ArrayList mTexts;

    public NotificationCompat$InboxStyle() {
        ArrayList arrayList;
        this.mTexts = arrayList = new ArrayList();
    }

    public NotificationCompat$InboxStyle(NotificationCompat$Builder notificationCompat$Builder) {
        ArrayList arrayList;
        this.mTexts = arrayList = new ArrayList();
        this.setBuilder(notificationCompat$Builder);
    }

    public NotificationCompat$InboxStyle addLine(CharSequence charSequence) {
        if (charSequence != null) {
            ArrayList arrayList = this.mTexts;
            charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
            arrayList.add(charSequence);
        }
        return this;
    }

    public void apply(NotificationBuilderWithBuilderAccessor object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            object = object.getBuilder();
            Object object2 = new Notification.InboxStyle((Notification.Builder)object);
            object = this.mBigContentTitle;
            object = object2.setBigContentTitle((CharSequence)object);
            n10 = (int)(this.mSummaryTextSet ? 1 : 0);
            if (n10 != 0) {
                object2 = this.mSummaryText;
                object.setSummaryText((CharSequence)object2);
            }
            object2 = this.mTexts.iterator();
            while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                CharSequence charSequence = (CharSequence)object2.next();
                object.addLine(charSequence);
            }
        }
    }

    public void clearCompatExtraKeys(Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove("android.textLines");
    }

    public String getClassName() {
        return TEMPLATE_CLASS_NAME;
    }

    public void restoreFromCompatExtras(Bundle charSequenceArray) {
        super.restoreFromCompatExtras((Bundle)charSequenceArray);
        this.mTexts.clear();
        String string2 = "android.textLines";
        boolean bl2 = charSequenceArray.containsKey(string2);
        if (bl2) {
            ArrayList arrayList = this.mTexts;
            charSequenceArray = charSequenceArray.getCharSequenceArray(string2);
            Collections.addAll(arrayList, charSequenceArray);
        }
    }

    public NotificationCompat$InboxStyle setBigContentTitle(CharSequence charSequence) {
        this.mBigContentTitle = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat$InboxStyle setSummaryText(CharSequence charSequence) {
        this.mSummaryText = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.mSummaryTextSet = true;
        return this;
    }
}

