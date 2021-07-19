/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$BigPictureStyle
 *  android.app.Notification$BigTextStyle
 *  android.app.Notification$DecoratedCustomViewStyle
 *  android.app.Notification$InboxStyle
 *  android.app.Notification$MessagingStyle
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.SystemClock
 *  android.widget.RemoteViews
 */
package androidx.core.app;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.RemoteViews;
import androidx.core.R$dimen;
import androidx.core.R$drawable;
import androidx.core.R$id;
import androidx.core.R$integer;
import androidx.core.R$string;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$BigPictureStyle;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$DecoratedCustomViewStyle;
import androidx.core.app.NotificationCompat$InboxStyle;
import androidx.core.app.NotificationCompat$MessagingStyle;
import androidx.core.graphics.drawable.IconCompat;
import java.text.NumberFormat;

public abstract class NotificationCompat$Style {
    public CharSequence mBigContentTitle;
    public NotificationCompat$Builder mBuilder;
    public CharSequence mSummaryText;
    public boolean mSummaryTextSet = false;

    private int calculateTopPadding() {
        Resources resources = this.mBuilder.mContext.getResources();
        int n10 = R$dimen.notification_top_pad;
        n10 = resources.getDimensionPixelSize(n10);
        int n11 = R$dimen.notification_top_pad_large_text;
        n11 = resources.getDimensionPixelSize(n11);
        float f10 = resources.getConfiguration().fontScale;
        float f11 = 1.0f;
        f10 = (NotificationCompat$Style.constrain(f10, f11, 1.3f) - f11) / 0.29999995f;
        f11 -= f10;
        float f12 = n10;
        f11 *= f12;
        f12 = n11;
        return Math.round(f11 + (f10 *= f12));
    }

    private static float constrain(float f10, float f11, float f12) {
        Object object = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        if (object < 0) {
            f10 = f11;
        } else {
            Object object2 = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
            if (object2 > 0) {
                f10 = f12;
            }
        }
        return f10;
    }

    public static NotificationCompat$Style constructCompatStyleByName(String object) {
        if (object != null) {
            ((String)object).hashCode();
            int n10 = -1;
            int n11 = ((String)object).hashCode();
            switch (n11) {
                default: {
                    break;
                }
                case 2090799565: {
                    String string2 = "androidx.core.app.NotificationCompat$MessagingStyle";
                    boolean bl2 = ((String)object).equals(string2);
                    if (!bl2) break;
                    n10 = 4;
                    break;
                }
                case 919595044: {
                    String string3 = "androidx.core.app.NotificationCompat$BigTextStyle";
                    boolean bl3 = ((String)object).equals(string3);
                    if (!bl3) break;
                    n10 = 3;
                    break;
                }
                case 912942987: {
                    String string4 = "androidx.core.app.NotificationCompat$InboxStyle";
                    boolean bl4 = ((String)object).equals(string4);
                    if (!bl4) break;
                    n10 = 2;
                    break;
                }
                case -171946061: {
                    String string5 = "androidx.core.app.NotificationCompat$BigPictureStyle";
                    boolean bl5 = ((String)object).equals(string5);
                    if (!bl5) break;
                    n10 = 1;
                    break;
                }
                case -716705180: {
                    String string6 = "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
                    boolean bl6 = ((String)object).equals(string6);
                    if (!bl6) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    break;
                }
                case 4: {
                    object = new NotificationCompat$MessagingStyle();
                    return object;
                }
                case 3: {
                    object = new NotificationCompat$BigTextStyle();
                    return object;
                }
                case 2: {
                    object = new NotificationCompat$InboxStyle();
                    return object;
                }
                case 1: {
                    object = new NotificationCompat$BigPictureStyle();
                    return object;
                }
                case 0: {
                    object = new NotificationCompat$DecoratedCustomViewStyle();
                    return object;
                }
            }
        }
        return null;
    }

    private static NotificationCompat$Style constructCompatStyleByPlatformName(String object) {
        if (object == null) {
            return null;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            String string2 = Notification.BigPictureStyle.class.getName();
            n11 = (int)(((String)object).equals(string2) ? 1 : 0);
            if (n11 != 0) {
                object = new NotificationCompat$BigPictureStyle();
                return object;
            }
            string2 = Notification.BigTextStyle.class.getName();
            n11 = (int)(((String)object).equals(string2) ? 1 : 0);
            if (n11 != 0) {
                object = new NotificationCompat$BigTextStyle();
                return object;
            }
            string2 = Notification.InboxStyle.class.getName();
            n11 = (int)(((String)object).equals(string2) ? 1 : 0);
            if (n11 != 0) {
                object = new NotificationCompat$InboxStyle();
                return object;
            }
            n11 = 24;
            if (n10 >= n11) {
                String string3 = Notification.MessagingStyle.class.getName();
                n10 = (int)(((String)object).equals(string3) ? 1 : 0);
                if (n10 != 0) {
                    object = new NotificationCompat$MessagingStyle();
                    return object;
                }
                string3 = Notification.DecoratedCustomViewStyle.class.getName();
                boolean bl2 = ((String)object).equals(string3);
                if (bl2) {
                    object = new NotificationCompat$DecoratedCustomViewStyle();
                    return object;
                }
            }
        }
        return null;
    }

    public static NotificationCompat$Style constructCompatStyleForBundle(Bundle object) {
        Object object2 = NotificationCompat$Style.constructCompatStyleByName(object.getString("androidx.core.app.extra.COMPAT_TEMPLATE"));
        if (object2 != null) {
            return object2;
        }
        object2 = "android.selfDisplayName";
        boolean bl2 = object.containsKey((String)object2);
        if (!bl2 && !(bl2 = object.containsKey((String)(object2 = "android.messagingStyleUser")))) {
            object2 = "android.picture";
            bl2 = object.containsKey((String)object2);
            if (bl2) {
                object = new NotificationCompat$BigPictureStyle();
                return object;
            }
            object2 = "android.bigText";
            bl2 = object.containsKey((String)object2);
            if (bl2) {
                object = new NotificationCompat$BigTextStyle();
                return object;
            }
            object2 = "android.textLines";
            bl2 = object.containsKey((String)object2);
            if (bl2) {
                object = new NotificationCompat$InboxStyle();
                return object;
            }
            return NotificationCompat$Style.constructCompatStyleByPlatformName(object.getString("android.template"));
        }
        object = new NotificationCompat$MessagingStyle();
        return object;
    }

    public static NotificationCompat$Style constructStyleForExtras(Bundle bundle) {
        NotificationCompat$Style notificationCompat$Style = NotificationCompat$Style.constructCompatStyleForBundle(bundle);
        if (notificationCompat$Style == null) {
            return null;
        }
        try {
            notificationCompat$Style.restoreFromCompatExtras(bundle);
            return notificationCompat$Style;
        }
        catch (ClassCastException classCastException) {
            return null;
        }
    }

    private Bitmap createColoredBitmap(int n10, int n11, int n12) {
        IconCompat iconCompat = IconCompat.createWithResource(this.mBuilder.mContext, n10);
        return this.createColoredBitmap(iconCompat, n11, n12);
    }

    private Bitmap createColoredBitmap(IconCompat iconCompat, int n10, int n11) {
        Context context = this.mBuilder.mContext;
        iconCompat = iconCompat.loadDrawable(context);
        int n12 = n11 == 0 ? iconCompat.getIntrinsicWidth() : n11;
        if (n11 == 0) {
            n11 = iconCompat.getIntrinsicHeight();
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        config = Bitmap.createBitmap((int)n12, (int)n11, (Bitmap.Config)config);
        PorterDuff.Mode mode = null;
        iconCompat.setBounds(0, 0, n12, n11);
        if (n10 != 0) {
            Drawable drawable2 = iconCompat.mutate();
            mode = PorterDuff.Mode.SRC_IN;
            context = new PorterDuffColorFilter(n10, mode);
            drawable2.setColorFilter((ColorFilter)context);
        }
        Canvas canvas = new Canvas((Bitmap)config);
        iconCompat.draw(canvas);
        return config;
    }

    private Bitmap createIconWithBackground(int n10, int n11, int n12, int n13) {
        Bitmap bitmap;
        int n14 = R$drawable.notification_icon_background;
        if (n13 == 0) {
            n13 = 0;
            bitmap = null;
        }
        bitmap = this.createColoredBitmap(n14, n13, n11);
        Canvas canvas = new Canvas(bitmap);
        Drawable drawable2 = this.mBuilder.mContext.getResources().getDrawable(n10).mutate();
        drawable2.setFilterBitmap(true);
        n11 = (n11 - n12) / 2;
        drawable2.setBounds(n11, n11, n12 += n11, n12);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(-1, mode);
        drawable2.setColorFilter((ColorFilter)porterDuffColorFilter);
        drawable2.draw(canvas);
        return bitmap;
    }

    public static NotificationCompat$Style extractStyleFromNotification(Notification notification) {
        if ((notification = NotificationCompat.getExtras(notification)) == null) {
            return null;
        }
        return NotificationCompat$Style.constructStyleForExtras((Bundle)notification);
    }

    private void hideNormalContent(RemoteViews remoteViews) {
        int n10 = R$id.title;
        int n11 = 8;
        remoteViews.setViewVisibility(n10, n11);
        n10 = R$id.text2;
        remoteViews.setViewVisibility(n10, n11);
        n10 = R$id.text;
        remoteViews.setViewVisibility(n10, n11);
    }

    public void addCompatExtras(Bundle bundle) {
        String string2;
        CharSequence charSequence;
        boolean bl2 = this.mSummaryTextSet;
        if (bl2) {
            charSequence = this.mSummaryText;
            string2 = "android.summaryText";
            bundle.putCharSequence(string2, charSequence);
        }
        if ((charSequence = this.mBigContentTitle) != null) {
            string2 = "android.title.big";
            bundle.putCharSequence(string2, charSequence);
        }
        if ((charSequence = this.getClassName()) != null) {
            string2 = "androidx.core.app.extra.COMPAT_TEMPLATE";
            bundle.putString(string2, (String)charSequence);
        }
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public RemoteViews applyStandardTemplate(boolean var1_1, int var2_2, boolean var3_3) {
        var4_4 = this;
        var5_5 = this.mBuilder.mContext.getResources();
        var7_7 = this.mBuilder.mContext.getPackageName();
        var8_8 = var2_2;
        var6_6 = new RemoteViews((String)var7_7, var2_2);
        var7_7 = this.mBuilder;
        var9_9 = var7_7.getPriority();
        var8_8 = -1;
        var10_10 = 0.0f / 0.0f;
        var11_11 = 1;
        var12_12 = 1.4E-45f;
        var13_13 = 0;
        if (var9_9 < var8_8) {
            var9_9 = var11_11;
        } else {
            var9_9 = 0;
            var7_7 = null;
        }
        var14_14 = Build.VERSION.SDK_INT;
        var15_15 = 21;
        var16_16 = 16;
        if (var14_14 >= var16_16 && var14_14 < var15_15) {
            var17_17 /* !! */  = "setBackgroundResource";
            if (var9_9 != 0) {
                var9_9 = R$id.notification_background;
                var18_18 = R$drawable.notification_bg_low;
                var6_6.setInt(var9_9, var17_17 /* !! */ , var18_18);
                var9_9 = R$id.icon;
                var18_18 = R$drawable.notification_template_icon_low_bg;
                var6_6.setInt(var9_9, var17_17 /* !! */ , var18_18);
            } else {
                var9_9 = R$id.notification_background;
                var18_18 = R$drawable.notification_bg;
                var6_6.setInt(var9_9, var17_17 /* !! */ , var18_18);
                var9_9 = R$id.icon;
                var18_18 = R$drawable.notification_template_icon_bg;
                var6_6.setInt(var9_9, var17_17 /* !! */ , var18_18);
            }
        }
        var7_7 = var4_4.mBuilder;
        var17_17 /* !! */  = var7_7.mLargeIcon;
        var19_19 = 8;
        var20_20 = 1.1E-44f;
        if (var17_17 /* !! */  != null) {
            if (var14_14 >= var16_16) {
                var9_9 = R$id.icon;
                var6_6.setViewVisibility(var9_9, 0);
                var17_17 /* !! */  = var4_4.mBuilder.mLargeIcon;
                var6_6.setImageViewBitmap(var9_9, (Bitmap)var17_17 /* !! */ );
            } else {
                var9_9 = R$id.icon;
                var6_6.setViewVisibility(var9_9, var19_19);
            }
            if (var1_1) {
                var7_7 = var4_4.mBuilder.mNotification;
                var9_9 = var7_7.icon;
                if (var9_9 != 0) {
                    var9_9 = R$dimen.notification_right_icon_size;
                    var9_9 = var5_5.getDimensionPixelSize(var9_9);
                    var21_21 = R$dimen.notification_small_icon_background_padding;
                    var21_21 = var5_5.getDimensionPixelSize(var21_21) * 2;
                    var21_21 = var9_9 - var21_21;
                    if (var14_14 >= var15_15) {
                        var22_22 = var4_4.mBuilder;
                        var23_23 = var22_22.mNotification;
                        var18_18 = var23_23.icon;
                        var8_8 = var22_22.getColor();
                        var7_7 = var4_4.createIconWithBackground(var18_18, var9_9, var21_21, var8_8);
                        var8_8 = R$id.right_icon;
                        var6_6.setImageViewBitmap(var8_8, (Bitmap)var7_7);
                    } else {
                        var9_9 = R$id.right_icon;
                        var17_17 /* !! */  = var4_4.mBuilder.mNotification;
                        var21_21 = var17_17 /* !! */ .icon;
                        var22_22 = var4_4.createColoredBitmap(var21_21, var8_8);
                        var6_6.setImageViewBitmap(var9_9, (Bitmap)var22_22);
                    }
                    var9_9 = R$id.right_icon;
                    var6_6.setViewVisibility(var9_9, 0);
                }
            }
        } else if (var1_1) {
            var7_7 = var7_7.mNotification;
            var9_9 = var7_7.icon;
            if (var9_9 != 0) {
                var9_9 = R$id.icon;
                var6_6.setViewVisibility(var9_9, 0);
                if (var14_14 >= var15_15) {
                    var8_8 = R$dimen.notification_large_icon_width;
                    var8_8 = var5_5.getDimensionPixelSize(var8_8);
                    var21_21 = R$dimen.notification_big_circle_margin;
                    var21_21 = var5_5.getDimensionPixelSize(var21_21);
                    var8_8 -= var21_21;
                    var21_21 = R$dimen.notification_small_icon_size_as_large;
                    var21_21 = var5_5.getDimensionPixelSize(var21_21);
                    var23_23 = var4_4.mBuilder;
                    var24_24 = var23_23.mNotification;
                    var25_25 = var24_24.icon;
                    var18_18 = var23_23.getColor();
                    var22_22 = var4_4.createIconWithBackground(var25_25, var8_8, var21_21, var18_18);
                    var6_6.setImageViewBitmap(var9_9, (Bitmap)var22_22);
                } else {
                    var17_17 /* !! */  = var4_4.mBuilder.mNotification;
                    var21_21 = var17_17 /* !! */ .icon;
                    var22_22 = var4_4.createColoredBitmap(var21_21, var8_8);
                    var6_6.setImageViewBitmap(var9_9, (Bitmap)var22_22);
                }
            }
        }
        if ((var7_7 = var4_4.mBuilder.mContentTitle) != null) {
            var8_8 = R$id.title;
            var6_6.setTextViewText(var8_8, (CharSequence)var7_7);
        }
        if ((var7_7 = var4_4.mBuilder.mContentText) != null) {
            var8_8 = R$id.text;
            var6_6.setTextViewText(var8_8, (CharSequence)var7_7);
            var9_9 = var11_11;
        } else {
            var9_9 = 0;
            var7_7 = null;
        }
        if (var14_14 < var15_15 && (var22_22 = var4_4.mBuilder.mLargeIcon) != null) {
            var8_8 = var11_11;
            var10_10 = var12_12;
        } else {
            var8_8 = 0;
            var22_22 = null;
            var10_10 = 0.0f;
        }
        var26_26 = var4_4.mBuilder;
        var17_17 /* !! */  = var26_26.mContentInfo;
        if (var17_17 /* !! */  != null) {
            var9_9 = R$id.info;
            var6_6.setTextViewText(var9_9, (CharSequence)var17_17 /* !! */ );
            var6_6.setViewVisibility(var9_9, 0);
lbl124:
            // 2 sources

            while (true) {
                var27_28 = var11_11;
                var28_29 = var11_11;
                var29_30 = var12_12;
                break;
            }
        } else {
            var15_15 = var26_26.mNumber;
            if (var15_15 > 0) {
                var9_9 = R$integer.status_bar_notification_info_maxnum;
                var9_9 = var5_5.getInteger(var9_9);
                var22_22 = var4_4.mBuilder;
                var8_8 = var22_22.mNumber;
                if (var8_8 > var9_9) {
                    var9_9 = R$id.info;
                    var8_8 = R$string.status_bar_notification_info_overflow;
                    var22_22 = var5_5.getString(var8_8);
                    var6_6.setTextViewText(var9_9, (CharSequence)var22_22);
                } else {
                    var7_7 = NumberFormat.getIntegerInstance();
                    var8_8 = R$id.info;
                    var26_26 = var4_4.mBuilder;
                    var15_15 = var26_26.mNumber;
                    var30_27 = var15_15;
                    var7_7 = var7_7.format(var30_27);
                    var6_6.setTextViewText(var8_8, (CharSequence)var7_7);
                }
                var9_9 = R$id.info;
                var6_6.setViewVisibility(var9_9, 0);
                ** continue;
            }
            var15_15 = R$id.info;
            var6_6.setViewVisibility(var15_15, var19_19);
            var27_28 = var9_9;
            var28_29 = var8_8;
            var29_30 = var10_10;
        }
        var7_7 = var4_4.mBuilder.mSubText;
        if (var7_7 == null || var14_14 < var16_16) ** GOTO lbl169
        var8_8 = R$id.text;
        var6_6.setTextViewText(var8_8, (CharSequence)var7_7);
        var7_7 = var4_4.mBuilder.mContentText;
        if (var7_7 != null) {
            var8_8 = R$id.text2;
            var6_6.setTextViewText(var8_8, (CharSequence)var7_7);
            var6_6.setViewVisibility(var8_8, 0);
            var9_9 = var11_11;
        } else {
            var9_9 = R$id.text2;
            var6_6.setViewVisibility(var9_9, var19_19);
lbl169:
            // 2 sources

            var9_9 = 0;
            var7_7 = null;
        }
        if (var9_9 != 0 && var14_14 >= var16_16) {
            if (var3_3) {
                var9_9 = R$dimen.notification_subtext_size;
                var32_31 = var5_5.getDimensionPixelSize(var9_9);
                var33_32 = var32_31;
                var9_9 = R$id.text;
                var6_6.setTextViewTextSize(var9_9, 0, var33_32);
            }
            var8_8 = R$id.line1;
            var15_15 = 0;
            var26_26 = null;
            var21_21 = 0;
            var17_17 /* !! */  = null;
            var18_18 = 0;
            var23_23 = null;
            var25_25 = 0;
            var24_24 = null;
            var7_7 = var6_6;
            var6_6.setViewPadding(var8_8, 0, 0, 0, 0);
        }
        if ((var32_31 = (int)((cfr_temp_0 = (var34_33 = (var5_5 = var4_4.mBuilder).getWhenIfShowing()) - (var36_34 = 0L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) != 0) {
            var5_5 = var4_4.mBuilder;
            var32_31 = (int)var5_5.mUseChronometer;
            if (var32_31 != 0 && var14_14 >= var16_16) {
                var32_31 = R$id.chronometer;
                var6_6.setViewVisibility(var32_31, 0);
                var38_35 = var4_4.mBuilder.getWhenIfShowing();
                var30_27 = SystemClock.elapsedRealtime();
                var40_37 = System.currentTimeMillis();
                var26_26 = "setBase";
                var6_6.setLong(var32_31, (String)var26_26, var38_35 += (var30_27 -= var40_37));
                var6_6.setBoolean(var32_31, "setStarted", (boolean)var11_11);
                var7_7 = var4_4.mBuilder;
                var9_9 = var7_7.mChronometerCountDown;
                if (var9_9 != 0) {
                    var8_8 = 24;
                    var10_10 = 3.4E-44f;
                    if (var14_14 >= var8_8) {
                        var6_6.setChronometerCountDown(var32_31, (boolean)var9_9);
                    }
                }
            } else {
                var32_31 = R$id.time;
                var6_6.setViewVisibility(var32_31, 0);
                var7_7 = var4_4.mBuilder;
                var38_36 = var7_7.getWhenIfShowing();
                var26_26 = "setTime";
                var6_6.setLong(var32_31, (String)var26_26, var38_36);
            }
        } else {
            var11_11 = var28_29;
            var12_12 = var29_30;
        }
        var32_31 = R$id.right_side;
        if (var11_11 != 0) {
            var9_9 = 0;
            var7_7 = null;
        } else {
            var9_9 = var19_19;
        }
        var6_6.setViewVisibility(var32_31, var9_9);
        var32_31 = R$id.line3;
        if (var27_28 == 0) {
            var13_13 = var19_19;
        }
        var6_6.setViewVisibility(var32_31, var13_13);
        return var6_6;
    }

    public Notification build() {
        NotificationCompat$Builder notificationCompat$Builder = this.mBuilder;
        notificationCompat$Builder = notificationCompat$Builder != null ? notificationCompat$Builder.build() : null;
        return notificationCompat$Builder;
    }

    public void buildIntoRemoteViews(RemoteViews remoteViews, RemoteViews remoteViews2) {
        this.hideNormalContent(remoteViews);
        int n10 = R$id.notification_main_column;
        remoteViews.removeAllViews(n10);
        remoteViews2 = remoteViews2.clone();
        remoteViews.addView(n10, remoteViews2);
        remoteViews2 = null;
        remoteViews.setViewVisibility(n10, 0);
        int n11 = Build.VERSION.SDK_INT;
        n10 = 21;
        if (n11 >= n10) {
            int n12 = R$id.notification_main_column_container;
            int n13 = this.calculateTopPadding();
            remoteViews.setViewPadding(n12, 0, n13, 0, 0);
        }
    }

    public void clearCompatExtraKeys(Bundle bundle) {
        bundle.remove("android.summaryText");
        bundle.remove("android.title.big");
        bundle.remove("androidx.core.app.extra.COMPAT_TEMPLATE");
    }

    public Bitmap createColoredBitmap(int n10, int n11) {
        return this.createColoredBitmap(n10, n11, 0);
    }

    public Bitmap createColoredBitmap(IconCompat iconCompat, int n10) {
        return this.createColoredBitmap(iconCompat, n10, 0);
    }

    public boolean displayCustomViewInline() {
        return false;
    }

    public String getClassName() {
        return null;
    }

    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        return null;
    }

    public void restoreFromCompatExtras(Bundle object) {
        CharSequence charSequence = "android.summaryText";
        boolean bl2 = object.containsKey(charSequence);
        if (bl2) {
            boolean bl3;
            charSequence = object.getCharSequence(charSequence);
            this.mSummaryText = charSequence;
            this.mSummaryTextSet = bl3 = true;
        }
        object = object.getCharSequence("android.title.big");
        this.mBigContentTitle = object;
    }

    public void setBuilder(NotificationCompat$Builder notificationCompat$Builder) {
        NotificationCompat$Builder notificationCompat$Builder2 = this.mBuilder;
        if (notificationCompat$Builder2 != notificationCompat$Builder) {
            this.mBuilder = notificationCompat$Builder;
            if (notificationCompat$Builder != null) {
                notificationCompat$Builder.setStyle(this);
            }
        }
    }
}

