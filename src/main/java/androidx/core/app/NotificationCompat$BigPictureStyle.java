/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification$BigPictureStyle
 *  android.app.Notification$Builder
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Icon
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package androidx.core.app;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat$BigPictureStyle$Api16Impl;
import androidx.core.app.NotificationCompat$BigPictureStyle$Api23Impl;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$Style;
import androidx.core.app.NotificationCompatBuilder;
import androidx.core.graphics.drawable.IconCompat;

public class NotificationCompat$BigPictureStyle
extends NotificationCompat$Style {
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigPictureStyle";
    private IconCompat mBigLargeIcon;
    private boolean mBigLargeIconSet;
    private Bitmap mPicture;

    public NotificationCompat$BigPictureStyle() {
    }

    public NotificationCompat$BigPictureStyle(NotificationCompat$Builder notificationCompat$Builder) {
        this.setBuilder(notificationCompat$Builder);
    }

    private static IconCompat asIconCompat(Parcelable parcelable) {
        if (parcelable != null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 23;
            if (n10 >= n11 && (n10 = parcelable instanceof Icon) != 0) {
                return IconCompat.createFromIcon((Icon)parcelable);
            }
            n10 = parcelable instanceof Bitmap;
            if (n10 != 0) {
                return IconCompat.createWithBitmap((Bitmap)parcelable);
            }
        }
        return null;
    }

    public void apply(NotificationBuilderWithBuilderAccessor object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            int n12;
            Object object2 = object.getBuilder();
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle((Notification.Builder)object2);
            object2 = this.mBigContentTitle;
            bigPictureStyle = bigPictureStyle.setBigContentTitle((CharSequence)object2);
            object2 = this.mPicture;
            bigPictureStyle = bigPictureStyle.bigPicture((Bitmap)object2);
            boolean bl2 = this.mBigLargeIconSet;
            if (bl2) {
                object2 = this.mBigLargeIcon;
                Context context = null;
                if (object2 == null) {
                    NotificationCompat$BigPictureStyle$Api16Impl.setBigLargeIcon(bigPictureStyle, null);
                } else {
                    int n13 = 23;
                    if (n10 >= n13) {
                        n10 = object instanceof NotificationCompatBuilder;
                        if (n10 != 0) {
                            object = (NotificationCompatBuilder)object;
                            context = ((NotificationCompatBuilder)object).getContext();
                        }
                        object = this.mBigLargeIcon.toIcon(context);
                        NotificationCompat$BigPictureStyle$Api23Impl.setBigLargeIcon(bigPictureStyle, (Icon)object);
                    } else {
                        n12 = ((IconCompat)object2).getType();
                        if (n12 == (n10 = 1)) {
                            object = this.mBigLargeIcon.getBitmap();
                            NotificationCompat$BigPictureStyle$Api16Impl.setBigLargeIcon(bigPictureStyle, (Bitmap)object);
                        } else {
                            NotificationCompat$BigPictureStyle$Api16Impl.setBigLargeIcon(bigPictureStyle, null);
                        }
                    }
                }
            }
            if ((n12 = this.mSummaryTextSet) != 0) {
                object = this.mSummaryText;
                NotificationCompat$BigPictureStyle$Api16Impl.setSummaryText(bigPictureStyle, (CharSequence)object);
            }
        }
    }

    public NotificationCompat$BigPictureStyle bigLargeIcon(Bitmap object) {
        object = object == null ? null : IconCompat.createWithBitmap(object);
        this.mBigLargeIcon = object;
        this.mBigLargeIconSet = true;
        return this;
    }

    public NotificationCompat$BigPictureStyle bigPicture(Bitmap bitmap) {
        this.mPicture = bitmap;
        return this;
    }

    public void clearCompatExtraKeys(Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove("android.largeIcon.big");
        bundle.remove("android.picture");
    }

    public String getClassName() {
        return TEMPLATE_CLASS_NAME;
    }

    public void restoreFromCompatExtras(Bundle bundle) {
        super.restoreFromCompatExtras(bundle);
        Object object = "android.largeIcon.big";
        boolean bl2 = bundle.containsKey((String)object);
        if (bl2) {
            boolean bl3;
            this.mBigLargeIcon = object = NotificationCompat$BigPictureStyle.asIconCompat(bundle.getParcelable((String)object));
            this.mBigLargeIconSet = bl3 = true;
        }
        bundle = (Bitmap)bundle.getParcelable("android.picture");
        this.mPicture = bundle;
    }

    public NotificationCompat$BigPictureStyle setBigContentTitle(CharSequence charSequence) {
        this.mBigContentTitle = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat$BigPictureStyle setSummaryText(CharSequence charSequence) {
        this.mSummaryText = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.mSummaryTextSet = true;
        return this;
    }
}

