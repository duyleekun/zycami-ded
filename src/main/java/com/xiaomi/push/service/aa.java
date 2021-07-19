/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.Notification
 *  android.app.Notification$BigPictureStyle
 *  android.app.Notification$BigTextStyle
 *  android.app.Notification$Builder
 *  android.app.Notification$Style
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.util.Pair
 *  android.widget.RemoteViews
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.push.service;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import com.xiaomi.push.ba;
import com.xiaomi.push.fb;
import com.xiaomi.push.g;
import com.xiaomi.push.g$a;
import com.xiaomi.push.hm;
import com.xiaomi.push.hr;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.l;
import com.xiaomi.push.service.aa$a;
import com.xiaomi.push.service.aa$b;
import com.xiaomi.push.service.aa$c;
import com.xiaomi.push.service.ab;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.bi;
import com.xiaomi.push.service.f;
import com.xiaomi.push.t;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aa {
    public static long a;
    private static final LinkedList a;
    private static ExecutorService a;

    static {
        LinkedList linkedList;
        a = linkedList = new LinkedList();
        a = Executors.newCachedThreadPool();
    }

    public static int a(Context context, String string2) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(string2, -1 >>> 1);
    }

    private static int a(Context context, String string2, String string3) {
        String string4 = context.getPackageName();
        boolean bl2 = string2.equals(string4);
        if (bl2) {
            return context.getResources().getIdentifier(string3, "drawable", string2);
        }
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int a(Map object) {
        if (object == null) {
            object = null;
        } else {
            String string2 = "timeout";
            object = (String)object.get(string2);
        }
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        int n10 = 0;
        if (bl2) return n10;
        try {
            return Integer.parseInt((String)object);
        }
        catch (Exception exception) {
            return n10;
        }
    }

    private static Notification.Builder a(Notification.Builder builder, Context context, String charSequence, Map map) {
        CharSequence charSequence2;
        CharSequence charSequence3;
        boolean bl2;
        int n10 = 1;
        Object object = aa.a(context, charSequence, n10, map);
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(charSequence3 = (CharSequence)map.get(charSequence2 = "notification_style_button_left_name"))))) {
            charSequence2 = (CharSequence)map.get(charSequence2);
            builder.addAction(0, charSequence2, object);
        }
        if ((object = aa.a(context, charSequence, n10 = 2, map)) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(charSequence3 = (CharSequence)map.get(charSequence2 = "notification_style_button_mid_name"))))) {
            charSequence2 = (CharSequence)map.get(charSequence2);
            builder.addAction(0, charSequence2, object);
        }
        if ((context = aa.a(context, charSequence, n10 = 3, map)) != null && (n10 = (int)(TextUtils.isEmpty((CharSequence)(object = (CharSequence)map.get(charSequence = "notification_style_button_right_name"))) ? 1 : 0)) == 0) {
            charSequence = (CharSequence)map.get(charSequence);
            builder.addAction(0, charSequence, (PendingIntent)context);
        }
        return builder;
    }

    private static Notification.Builder a(Context object, Map object2, Notification.Builder builder, String string2) {
        String string3 = "2";
        String string4 = "notification_style_type";
        Object v10 = object2.get(string4);
        boolean bl2 = string3.equals(v10);
        if (bl2) {
            string4 = null;
            if (object2 == null) {
                boolean bl3 = false;
                object = null;
            } else {
                object2 = (String)object2.get("notification_bigPic_uri");
                bl2 = false;
                v10 = null;
                object = aa.a(object, (String)object2, false);
            }
            if (object == null) {
                b.a("can not get big picture.");
                return builder;
            }
            object2 = new Notification.BigPictureStyle(builder);
            object2.bigPicture((Bitmap)object);
            object2.setSummaryText((CharSequence)string2);
            object2.bigLargeIcon(null);
            builder.setStyle((Notification.Style)object2);
        } else {
            object2 = "1";
            object = object2.get(string4);
            boolean bl4 = ((String)object2).equals(object);
            if (bl4) {
                object = new Notification.BigTextStyle();
                object = object.bigText((CharSequence)string2);
                builder.setStyle((Notification.Style)object);
            }
        }
        return builder;
    }

    private static Notification a(Notification notification) {
        Object object = ba.a((Object)notification, "extraNotification");
        if (object != null) {
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            Boolean bl2 = Boolean.TRUE;
            objectArray[0] = bl2;
            String string2 = "setCustomizedIcon";
            ba.a(object, string2, objectArray);
        }
        return notification;
    }

    private static Notification a(Notification notification, String string2) {
        Object object = Notification.class;
        Object[] objectArray = "extraNotification";
        object = ((Class)object).getDeclaredField((String)objectArray);
        int n10 = 1;
        ((Field)object).setAccessible(n10 != 0);
        object = ((Field)object).get(notification);
        GenericDeclaration genericDeclaration = object.getClass();
        String string3 = "setTargetPkg";
        Class[] classArray = new Class[n10];
        Class<CharSequence> clazz = CharSequence.class;
        classArray[0] = clazz;
        genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod(string3, classArray);
        ((Method)genericDeclaration).setAccessible(n10 != 0);
        objectArray = new Object[n10];
        objectArray[0] = string2;
        try {
            ((Method)genericDeclaration).invoke(object, objectArray);
        }
        catch (Exception exception) {
            b.a(exception);
        }
        return notification;
    }

    private static PendingIntent a(Context context, ii ii2, hz hz2, byte[] byArray, int n10) {
        ComponentName componentName;
        String string2;
        boolean bl2;
        Context context2 = context;
        Object object = ii2;
        hz hz3 = hz2;
        Object object2 = byArray;
        int n11 = aa.c(ii2);
        n11 = n11 != 0 ? 1000 : ((n11 = (int)(aa.a(ii2) ? 1 : 0)) != 0 ? 3000 : -1);
        String string3 = hz3 != null ? hz2.a() : "";
        String string4 = "eventMessageType";
        String string5 = "messageId";
        int n12 = 0x8000000;
        if (hz3 != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = hz3.e)))) {
            object = new Intent("android.intent.action.VIEW");
            hz3 = Uri.parse((String)hz3.e);
            object.setData((Uri)hz3);
            object.addFlags(0x10000000);
            object.putExtra(string5, string3);
            object.putExtra(string4, n11);
            return PendingIntent.getActivity((Context)context2, (int)0, (Intent)object, (int)n12);
        }
        boolean bl3 = aa.a(ii2);
        bl2 = true;
        String string6 = "mipush_notified";
        String string7 = "mipush_payload";
        String string8 = "com.xiaomi.mipush.sdk.PushMessageHandler";
        if (bl3) {
            hz3 = new Intent();
            String string9 = "com.xiaomi.xmsf";
            componentName = new ComponentName(string9, string8);
        } else {
            hz3 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            String string10 = ((ii)object).b;
            componentName = new ComponentName(string10, string8);
        }
        hz3.setComponent(componentName);
        hz3.putExtra(string7, (byte[])object2);
        hz3.putExtra(string6, bl2);
        object2 = String.valueOf(n10);
        hz3.addCategory((String)object2);
        object2 = String.valueOf(string3);
        hz3.addCategory((String)object2);
        hz3.putExtra(string5, string3);
        hz3.putExtra(string4, n11);
        object2 = ((ii)object).b;
        String string11 = "com.xiaomi.mipush.MESSAGE_CLICKED";
        boolean bl4 = f.b(context2, (String)object2, string11);
        if (bl4) {
            object2 = new Intent;
            object2();
            object2.setAction(string11);
            object = ((ii)object).b;
            object2.setClassName((String)object, "com.xiaomi.mipush.sdk.BridgeActivity");
            object2.addFlags(0x10800000);
            object2.putExtra("mipush_serviceIntent", (Parcelable)hz3);
            object = String.valueOf(n10);
            object2.addCategory((String)object);
            object = String.valueOf(string3);
            object2.addCategory((String)object);
            return PendingIntent.getActivity((Context)context2, (int)0, (Intent)object2, (int)n12);
        }
        return PendingIntent.getService((Context)context2, (int)0, (Intent)hz3, (int)n12);
    }

    private static PendingIntent a(Context context, String string2, int n10, Map map) {
        if (map == null) {
            return null;
        }
        if ((string2 = aa.a(context, string2, n10, map)) != null) {
            return PendingIntent.getActivity((Context)context, (int)0, (Intent)string2, (int)0);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Intent a(Context context, String object, int n10, Map object2) {
        String string2;
        block16: {
            Object object3;
            block18: {
                block22: {
                    block19: {
                        String string3;
                        int n11;
                        int n12;
                        block20: {
                            block21: {
                                block17: {
                                    n12 = 3;
                                    n11 = 2;
                                    string3 = n10 < n11 ? "notification_style_button_left_notify_effect" : (n10 < n12 ? "notification_style_button_mid_notify_effect" : "notification_style_button_right_notify_effect");
                                    boolean bl3 = TextUtils.isEmpty((CharSequence)(string3 = (String)object2.get(string3)));
                                    if (bl3) {
                                        return null;
                                    }
                                    String string4 = at.a;
                                    bl3 = string4.equals(string3);
                                    string2 = "Cause: ";
                                    if (bl3) {
                                        try {
                                            PackageManager object4 = context.getPackageManager();
                                            object = object4.getLaunchIntentForPackage((String)object);
                                            break block16;
                                        }
                                        catch (Exception exception) {
                                            StringBuilder object32 = new StringBuilder();
                                            object32.append(string2);
                                            object = exception.getMessage();
                                            object32.append((String)object);
                                            object = object32.toString();
                                            b.d((String)object);
                                            return null;
                                        }
                                    }
                                    string4 = at.b;
                                    bl3 = string4.equals(string3);
                                    if (!bl3) break block20;
                                    string3 = n10 < n11 ? "notification_style_button_left_intent_uri" : (n10 < n12 ? "notification_style_button_mid_intent_uri" : "notification_style_button_right_intent_uri");
                                    object3 = n10 < n11 ? "notification_style_button_left_intent_class" : (n10 < n12 ? "notification_style_button_mid_intent_class" : "notification_style_button_right_intent_class");
                                    n12 = (int)(object2.containsKey(string3) ? 1 : 0);
                                    if (n12 == 0) break block21;
                                    object3 = (String)object2.get(string3);
                                    if (object3 == null) return null;
                                    int bl4 = 1;
                                    try {
                                        object3 = Intent.parseUri((String)object3, (int)bl4);
                                    }
                                    catch (URISyntaxException uRISyntaxException) {
                                        n10 = 0;
                                        object3 = null;
                                        break block17;
                                    }
                                    try {
                                        object3.setPackage((String)object);
                                        break block18;
                                    }
                                    catch (URISyntaxException uRISyntaxException) {}
                                }
                                object2 = new StringBuilder();
                                ((StringBuilder)object2).append(string2);
                                object = ((URISyntaxException)object).getMessage();
                                break block22;
                            }
                            n12 = (int)(object2.containsKey(object3) ? 1 : 0);
                            if (n12 == 0) return null;
                            object3 = (String)object2.get(object3);
                            object2 = new Intent();
                            ComponentName componentName = new ComponentName((String)object, (String)object3);
                            object2.setComponent(componentName);
                            object = object2;
                            break block16;
                        }
                        object = at.c;
                        boolean bl2 = ((String)object).equals(string3);
                        if (!bl2) return null;
                        object = n10 < n11 ? "notification_style_button_left_web_uri" : (n10 < n12 ? "notification_style_button_mid_web_uri" : "notification_style_button_right_web_uri");
                        object = (String)object2.get(object);
                        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                        if (n10 != 0) return null;
                        boolean bl3 = ((String)(object = ((String)object).trim())).startsWith((String)(object3 = "http://"));
                        if (!bl3 && !(bl3 = ((String)object).startsWith((String)(object2 = "https://")))) {
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append((String)object3);
                            ((StringBuilder)object2).append((String)object);
                            object = ((StringBuilder)object2).toString();
                        }
                        try {
                            object3 = new URL((String)object);
                            object3 = ((URL)object3).getProtocol();
                            object2 = "http";
                            bl3 = ((String)object2).equals(object3);
                            if (!bl3) {
                                object2 = "https";
                                n10 = (int)(((String)object2).equals(object3) ? 1 : 0);
                                if (n10 == 0) return null;
                            }
                            object2 = "android.intent.action.VIEW";
                            object3 = new Intent((String)object2);
                        }
                        catch (MalformedURLException malformedURLException) {
                            n10 = 0;
                            object3 = null;
                            break block19;
                        }
                        try {
                            object = Uri.parse((String)object);
                            object3.setData((Uri)object);
                            aj.a(context, (Intent)object3);
                            break block18;
                        }
                        catch (MalformedURLException malformedURLException) {}
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(string2);
                    object = ((Throwable)object).getMessage();
                }
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                b.d((String)object);
            }
            object = object3;
        }
        if (object == null) return null;
        n10 = 0x10000000;
        object.addFlags(n10);
        try {
            context = context.getPackageManager();
            n10 = 65536;
            context = context.resolveActivity((Intent)object, n10);
            if (context == null) return null;
            return object;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            String string5 = exception.getMessage();
            ((StringBuilder)object).append(string5);
            string5 = ((StringBuilder)object).toString();
            b.d(string5);
        }
        return null;
    }

    private static Bitmap a(Context context, int n10) {
        return aa.a(context.getResources().getDrawable(n10));
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Bitmap a(Context object, String string2, boolean bl2) {
        Throwable throwable2;
        boolean bl3;
        block6: {
            ExecutorService executorService = a;
            Object object2 = new aa$a(string2, (Context)object, bl2);
            object = executorService.submit(object2);
            long l10 = 180L;
            bl3 = true;
            try {
                object2 = TimeUnit.SECONDS;
                string2 = object.get(l10, (TimeUnit)((Object)object2));
                string2 = (Bitmap)string2;
                if (string2 != null) return string2;
                object.cancel(bl3);
            }
            catch (Throwable throwable2) {
                break block6;
            }
            catch (TimeoutException timeoutException) {
            }
            catch (ExecutionException executionException) {
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            return string2;
            {
                b.a((Throwable)((Object)string2));
                object.cancel(bl3);
            }
            return null;
        }
        object.cancel(bl3);
        throw throwable2;
    }

    public static Bitmap a(Drawable drawable2) {
        int n10 = drawable2 instanceof BitmapDrawable;
        if (n10 != 0) {
            return ((BitmapDrawable)drawable2).getBitmap();
        }
        n10 = drawable2.getIntrinsicWidth();
        int n11 = 1;
        if (n10 <= 0) {
            n10 = n11;
        }
        int n12 = drawable2.getIntrinsicHeight();
        if (n12 > 0) {
            n11 = n12;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)config);
        Canvas canvas = new Canvas(bitmap);
        n12 = canvas.getWidth();
        int n13 = canvas.getHeight();
        drawable2.setBounds(0, 0, n12, n13);
        drawable2.draw(canvas);
        return bitmap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static RemoteViews a(Context context, ii object, byte[] object2) {
        object2 = "time";
        Object object3 = "image";
        Object object4 = "text";
        Object object5 = ((ii)object).a();
        object = aa.a((ii)object);
        if ((object5 = ((hz)object5).a()) == null) {
            return null;
        }
        Object object6 = (String)object5.get("layout_name");
        String string2 = "layout_value";
        object5 = (String)object5.get(string2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object6);
        if (bl2) return null;
        bl2 = TextUtils.isEmpty((CharSequence)object5);
        if (bl2) {
            return null;
        }
        context = context.getPackageManager();
        try {
            context = context.getResourcesForApplication((String)object);
            string2 = "layout";
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            b.a(nameNotFoundException);
            return null;
        }
        int n11 = context.getIdentifier((String)object6, string2, (String)object);
        if (n11 == 0) {
            return null;
        }
        string2 = new RemoteViews((String)object, n11);
        try {
            boolean bl3;
            int n10;
            String string4;
            Object object7;
            int n12;
            object6 = new JSONObject((String)object5);
            int n13 = object6.has((String)object4);
            String string3 = "id";
            if (n13 != 0) {
                object4 = object6.getJSONObject((String)object4);
                object5 = object4.keys();
                while ((n12 = object5.hasNext()) != 0) {
                    object7 = object5.next();
                    object7 = (String)object7;
                    string4 = object4.getString(object7);
                    n12 = context.getIdentifier(object7, string3, (String)object);
                    if (n12 <= 0) continue;
                    string2.setTextViewText(n12, (CharSequence)string4);
                }
            }
            if ((n10 = object6.has((String)object3)) != 0) {
                object3 = object6.getJSONObject((String)object3);
                object4 = object3.keys();
                while ((n13 = object4.hasNext()) != 0) {
                    object5 = object4.next();
                    object5 = (String)object5;
                    object7 = object3.getString((String)object5);
                    n13 = context.getIdentifier((String)object5, string3, (String)object);
                    string4 = "drawable";
                    n12 = context.getIdentifier(object7, string4, (String)object);
                    if (n13 <= 0) continue;
                    string2.setImageViewResource(n13, n12);
                }
            }
            if (!(bl3 = object6.has((String)object2))) return string2;
            object2 = object6.getJSONObject((String)object2);
            object3 = object2.keys();
            while ((n10 = object3.hasNext()) != 0) {
                object4 = object3.next();
                object5 = object2.getString((String)(object4 = (String)object4));
                n11 = ((String)object5).length();
                if (n11 == 0) {
                    object5 = "yy-MM-dd hh:mm";
                }
                if ((n10 = context.getIdentifier((String)object4, string3, (String)object)) <= 0) continue;
                long l10 = System.currentTimeMillis();
                object6 = new SimpleDateFormat((String)object5);
                object5 = new Date(l10);
                object5 = ((DateFormat)object6).format((Date)object5);
                string2.setTextViewText(n10, (CharSequence)object5);
            }
            return string2;
        }
        catch (JSONException jSONException) {
            b.a(jSONException);
            return null;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static aa$b a(Context var0, ii var1_1, byte[] var2_2, RemoteViews var3_3, PendingIntent var4_4) {
        block153: {
            block152: {
                block144: {
                    block151: {
                        block150: {
                            block149: {
                                block148: {
                                    block138: {
                                        var5_5 /* !! */  = var0;
                                        var6_6 = var3_3;
                                        var7_10 = Build.VERSION.SDK_INT;
                                        var8_11 = new aa$b();
                                        var9_12 /* !! */  = var1_1.a();
                                        var10_13 = aa.a(var1_1);
                                        var11_14 = var9_12 /* !! */ .a();
                                        var12_15 = new Notification.Builder((Context)var0);
                                        var13_16 = aa.a((Context)var0, (hz)var9_12 /* !! */ );
                                        var14_17 = 0;
                                        var15_18 = null;
                                        var16_19 = var13_16[0];
                                        var12_15.setContentTitle((CharSequence)var16_19);
                                        var17_20 = 1;
                                        var18_21 = 1.4E-45f;
                                        var19_22 = var13_16[var17_20];
                                        var12_15.setContentText((CharSequence)var19_22);
                                        var20_23 = 16;
                                        if (var3_3 != null) {
                                            var12_15.setContent(var3_3);
                                        } else if (var7_10 >= var20_23 && var11_14 != null && (var21_24 = var11_14.containsKey(var6_6 = "notification_style_type")) != 0) {
                                            var6_6 = var13_16[var17_20];
                                            var12_15 = aa.a((Context)var0, var11_14, var12_15, (String)var6_6);
                                        }
                                        var6_6 = var1_1.b();
                                        var12_15 = aa.a(var12_15, (Context)var5_5 /* !! */ , (String)var6_6, var11_14);
                                        var22_25 = System.currentTimeMillis();
                                        var12_15.setWhen(var22_25);
                                        if (var11_14 == null) {
                                            var21_24 = 0;
                                            var6_6 = null;
                                        } else {
                                            var6_6 = (String)var11_14.get("notification_show_when");
                                        }
                                        var24_26 = TextUtils.isEmpty((CharSequence)var6_6);
                                        var25_27 = 24;
                                        if (var24_26 != 0) {
                                            if (var7_10 >= var25_27) {
                                                var12_15.setShowWhen((boolean)var17_20);
                                            }
                                        } else {
                                            var21_24 = Boolean.parseBoolean((String)var6_6);
                                            var12_15.setShowWhen((boolean)var21_24);
                                        }
                                        var6_6 = var4_4;
                                        var12_15.setContentIntent(var4_4);
                                        var6_6 = "mipush_notification";
                                        var21_24 = aa.a((Context)var5_5 /* !! */ , (String)var10_13, (String)var6_6);
                                        var26_28 = "mipush_small_notification";
                                        var24_26 = aa.a((Context)var5_5 /* !! */ , (String)var10_13, var26_28);
                                        if (var21_24 > 0 && var24_26 > 0) {
                                            var6_6 = aa.a((Context)var5_5 /* !! */ , var21_24);
                                            var12_15.setLargeIcon((Bitmap)var6_6);
                                            var12_15.setSmallIcon(var24_26);
                                        } else {
                                            var21_24 = aa.b((Context)var5_5 /* !! */ , (String)var10_13);
                                            var12_15.setSmallIcon(var21_24);
                                        }
                                        var21_24 = 23;
                                        if (var7_10 < var21_24) break block148;
                                        var6_6 = "notification_small_icon_uri";
                                        if (var11_14 == null) {
                                            var24_26 = 0;
                                            var26_28 = null;
                                        } else {
                                            var26_28 = (String)var11_14.get(var6_6);
                                            var26_28 = aa.a((Context)var5_5 /* !! */ , var26_28, (boolean)var17_20);
                                        }
                                        if (var26_28 == null) ** GOTO lbl102
                                        var19_22 = new Object[var17_20];
                                        var19_22[0] = var26_28;
                                        var26_28 = "android.graphics.drawable.Icon";
                                        var13_16 = ba.a(var26_28, "createWithBitmap", (Object[])var19_22);
                                        if (var13_16 != null) {
                                            var6_6 = new Object[var17_20];
                                            var6_6[0] = var13_16;
                                            ba.a((Object)var12_15, "setSmallIcon", (Object[])var6_6);
                                            var6_6 = new Bundle();
                                            var13_16 = "miui.isGrayscaleIcon";
                                            var6_6.putBoolean((String)var13_16, (boolean)var17_20);
                                            var12_15.addExtras((Bundle)var6_6);
                                        } else {
                                            var13_16 = new StringBuilder();
                                            var19_22 = "failed te get small icon with url:";
                                            var13_16.append((String)var19_22);
                                            while (true) {
                                                var6_6 = (String)var11_14.get(var6_6);
lbl96:
                                                // 2 sources

                                                while (true) {
                                                    var13_16.append((String)var6_6);
                                                    var6_6 = var13_16.toString();
                                                    b.a((String)var6_6);
                                                    break block138;
                                                    break;
                                                }
                                                break;
                                            }
lbl102:
                                            // 1 sources

                                            var13_16 = new StringBuilder();
                                            var19_22 = "failed to get small icon url:";
                                            var13_16.append((String)var19_22);
                                            if (var11_14 != null) ** continue;
                                            var21_24 = 0;
                                            var6_6 = null;
                                            ** continue;
                                        }
                                    }
                                    if (var11_14 == null) {
                                        var21_24 = 0;
                                        var6_6 = null;
                                    } else {
                                        var6_6 = (String)var11_14.get("notification_small_icon_color");
                                    }
                                    var27_29 = TextUtils.isEmpty((CharSequence)var6_6);
                                    if (var27_29 == 0) {
                                        var21_24 = Color.parseColor((String)var6_6);
                                        var13_16 = "setColor";
                                        var19_22 = new Object[var17_20];
                                        var6_6 = var21_24;
                                        var19_22[0] = var6_6;
                                        try {
                                            ba.a((Object)var12_15, (String)var13_16, (Object[])var19_22);
                                        }
                                        catch (Exception var6_7) {
                                            b.a(var6_7);
                                        }
                                    }
                                }
                                if (var11_14 == null) {
                                    var21_24 = 0;
                                    var6_6 = null;
                                } else {
                                    var6_6 = (String)var11_14.get("__dynamic_icon_uri");
                                }
                                if (var11_14 != null && (var27_29 = Boolean.parseBoolean((String)(var13_16 = (String)var11_14.get("__adiom")))) != 0) {
                                    var27_29 = var17_20;
                                } else {
                                    var27_29 = 0;
                                    var13_16 = null;
                                }
                                if (var27_29 == 0 && (var27_29 = l.a()) != 0) {
                                    var27_29 = 0;
                                    var13_16 = null;
                                } else {
                                    var27_29 = var17_20;
                                }
                                if (var6_6 == null || var27_29 == 0) ** GOTO lbl-1000
                                var13_16 = "http";
                                var27_29 = var6_6.startsWith((String)var13_16);
                                if (var27_29 != 0) {
                                    if ((var6_6 = com.xiaomi.push.service.ai.a((Context)var5_5 /* !! */ , (String)var6_6, (boolean)var17_20)) != null) {
                                        var13_16 = var6_6.a;
                                        var8_11.a = var28_30 = var6_6.a;
                                    } else {
                                        var27_29 = 0;
                                        var13_16 = null;
                                    }
                                } else {
                                    var13_16 = com.xiaomi.push.service.ai.a((Context)var5_5 /* !! */ , (String)var6_6);
                                }
                                if (var13_16 != null) {
                                    var12_15.setLargeIcon((Bitmap)var13_16);
                                    var27_29 = 1;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var27_29 = 0;
                                    var13_16 = null;
                                }
                                if (var11_14 == null) {
                                    var21_24 = 0;
                                    var6_6 = null;
                                } else {
                                    var6_6 = (String)var11_14.get("notification_large_icon_uri");
                                    var14_17 = 1;
                                    var6_6 = aa.a((Context)var5_5 /* !! */ , (String)var6_6, (boolean)var14_17);
                                }
                                if (var6_6 != null) {
                                    var12_15.setLargeIcon((Bitmap)var6_6);
                                }
                                var6_6 = "setGroup";
                                if (var11_14 != null && var7_10 >= var25_27) {
                                    var15_18 = (Object[])var11_14.get("notification_group");
                                    var16_19 = (String)var11_14.get("notification_is_summary");
                                    var17_20 = Boolean.parseBoolean((String)var16_19);
                                    var25_27 = (int)TextUtils.isEmpty((CharSequence)var15_18);
                                    if (var25_27 != 0) {
                                        var15_18 = aa.a(var1_1);
                                    }
                                    var15_18 = ag.a().a((Context)var5_5 /* !! */ , var12_15, (String)var15_18);
                                    var24_26 = 1;
                                    var30_31 = new Object[var24_26];
                                    var20_23 = 0;
                                    var19_22 = null;
                                    var30_31[0] = var15_18;
                                    ba.a((Object)var12_15, (String)var6_6, (Object[])var30_31);
                                    var15_18 = new Object[var24_26];
                                    var15_18[0] = var16_19 = Boolean.valueOf((boolean)var17_20);
                                    var16_19 = "setGroupSummary";
                                    ba.a((Object)var12_15, (String)var16_19, var15_18);
                                } else {
                                    var24_26 = 1;
                                }
                                var12_15.setAutoCancel((boolean)var24_26);
                                var28_30 = System.currentTimeMillis();
                                if (var11_14 != null && (var31_32 = var11_14.containsKey(var30_31 = "ticker"))) {
                                    var30_31 = (CharSequence)var11_14.get(var30_31);
                                    var12_15.setTicker((CharSequence)var30_31);
                                }
                                var32_33 = aa.a;
                                var34_34 = 10000L;
                                cfr_temp_0 = (var32_33 = var28_30 - var32_33) - var34_34;
                                var25_27 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                if (var25_27 <= 0) break block149;
                                aa.a = var28_30;
                                var36_35 = var9_12 /* !! */ .a;
                                var14_17 = aa.b((Context)var5_5 /* !! */ , (String)var10_13);
                                if (var14_17 != 0) {
                                    var36_35 = aa.a((Context)var5_5 /* !! */ , (String)var10_13);
                                }
                                var12_15.setDefaults(var36_35);
                                if (var11_14 == null || (var14_17 = var36_35 & 1) == 0 || (var17_20 = TextUtils.isEmpty((CharSequence)(var15_18 = (String)var11_14.get("sound_uri")))) != 0) break block150;
                                var16_19 = new StringBuilder();
                                var30_31 = "android.resource://";
                                var16_19.append((String)var30_31);
                                var16_19.append((String)var10_13);
                                var16_19 = var16_19.toString();
                                var17_20 = var15_18.startsWith((String)var16_19);
                                if (var17_20 == 0) break block150;
                                var17_20 = var36_35 ^ 1;
                                var12_15.setDefaults(var17_20);
                                var15_18 = Uri.parse((String)var15_18);
                                var12_15.setSound((Uri)var15_18);
                                break block151;
                            }
                            var36_35 = -100;
                        }
                        var14_17 = 0;
                        var15_18 = null;
                    }
                    var16_19 = "_top_";
                    var30_31 = "com.xiaomi.xmsf";
                    var20_23 = 26;
                    if (var11_14 == null || var7_10 < var20_23) break block152;
                    var7_10 = aa.a(var11_14);
                    var26_28 = "setTimeoutAfter";
                    var37_36 = var8_11;
                    if (var7_10 > 0) {
                        var8_11 = new Object[1];
                        var38_37 = var22_25;
                        var40_38 = var7_10 *= 1000;
                        var42_39 = var40_38;
                        var20_23 = 0;
                        var19_22 = null;
                        var8_11[0] = var42_39;
                        ba.a((Object)var12_15, var26_28, (Object[])var8_11);
                    } else {
                        var38_37 = var22_25;
                    }
                    var8_11 = (String)var11_14.get("channel_id");
                    var20_23 = (int)TextUtils.isEmpty((CharSequence)var8_11);
                    if (var20_23 == 0) ** GOTO lbl-1000
                    var19_22 = var0.getApplicationInfo();
                    var20_23 = var19_22.targetSdkVersion;
                    var43_40 = 26;
                    if (var20_23 < var43_40) {
                        var44_41 = var27_29;
                    } else lbl-1000:
                    // 2 sources

                    {
                        block139: {
                            block140: {
                                block143: {
                                    block142: {
                                        block141: {
                                            var19_22 = new StringBuilder();
                                            var45_42 = "mipush_";
                                            var19_22.append((String)var45_42);
                                            var19_22.append((String)var10_13);
                                            var19_22.append("_default");
                                            var46_43 = var19_22.toString();
                                            var20_23 = (int)TextUtils.isEmpty((CharSequence)var8_11);
                                            if (var20_23 != 0) {
                                                var8_11 = var46_43;
                                            } else {
                                                var20_23 = (int)l.a();
                                                if (var20_23 != 0) {
                                                    var19_22 = new StringBuilder();
                                                    var19_22.append((String)var45_42);
                                                    var19_22.append((String)var10_13);
                                                    var42_39 = "_";
                                                    var19_22.append((String)var42_39);
                                                    var19_22.append((String)var8_11);
                                                    var8_11 = var19_22.toString();
                                                }
                                            }
                                            var19_22 = new Object[1];
                                            var7_10 = 0;
                                            var19_22[0] = var8_11;
                                            ba.a((Object)var12_15, "setChannelId", (Object[])var19_22);
                                            var42_39 = aa.a((Context)var5_5 /* !! */ , (String)var10_13, var11_14);
                                            var20_23 = aa.b(var11_14);
                                            var44_41 = var27_29;
                                            var27_29 = 4;
                                            if (var20_23 >= var27_29) {
                                                var13_16 = new StringBuilder();
                                                var47_44 = var46_43;
                                                var46_43 = aa.a(var1_1);
                                                var13_16.append((String)var46_43);
                                                var13_16.append((String)var16_19);
                                                var48_45 = var45_42;
                                                var22_25 = var38_37;
                                                var13_16.append(var38_37);
                                                var13_16 = var13_16.toString();
                                                var49_46 /* !! */  = var10_13;
                                                var17_20 = 1;
                                                var18_21 = 1.4E-45f;
                                                var10_13 = new Object[var17_20];
                                                var50_47 = null;
                                                var10_13[0] = var13_16;
                                                ba.a((Object)var12_15, (String)var6_6, (Object[])var10_13);
                                                var6_6 = var0.getPackageName();
                                                var21_24 = (int)var30_31.equals(var6_6);
                                                if (var21_24 != 0 && (var21_24 = (int)(var6_6 = ak.a((Context)var0)).a(var51_48 = (var10_13 = hr.aT).a(), (boolean)var17_20)) != 0 && (var21_24 = (var6_6 = ak.a((Context)var0)).a(var51_48 = (var10_13 = hr.aR).a(), var27_29 = 14400)) > 0) {
                                                    var10_13 = new Object[var17_20];
                                                    var50_47 = var15_18;
                                                    var52_50 = var21_24 *= 1000;
                                                    var6_6 = var52_50;
                                                    var27_29 = 0;
                                                    var13_16 = null;
                                                    var10_13[0] = var6_6;
                                                    ba.a((Object)var12_15, var26_28, (Object[])var10_13);
                                                    var6_6 = new Bundle();
                                                    var10_13 = "mipush_org_when";
                                                    var6_6.putLong((String)var10_13, var38_37);
                                                    var12_15.addExtras((Bundle)var6_6);
                                                } else {
                                                    var50_47 = var15_18;
                                                }
                                            } else {
                                                var49_46 /* !! */  = var10_13;
                                                var50_47 = var15_18;
                                                var48_45 = var45_42;
                                                var47_44 = var46_43;
                                            }
                                            var6_6 = (NotificationManager)var5_5 /* !! */ .getSystemService("notification");
                                            var10_13 = "getNotificationChannel";
                                            var14_17 = 1;
                                            var16_19 = new Object[var14_17];
                                            var27_29 = 0;
                                            var13_16 = null;
                                            var16_19[0] = var8_11;
                                            var10_13 = ba.a(var6_6, (String)var10_13, (Object[])var16_19);
                                            if (var10_13 != null) break block139;
                                            var10_13 = "android.app.NotificationChannel";
                                            var10_13 = t.a((Context)var5_5 /* !! */ , (String)var10_13);
                                            var17_20 = 3;
                                            var18_21 = 4.2E-45f;
                                            var45_42 = new Class[var17_20];
                                            var16_19 = String.class;
                                            var27_29 = 0;
                                            var13_16 = null;
                                            var45_42[0] = var16_19;
                                            var16_19 = CharSequence.class;
                                            var14_17 = 1;
                                            var45_42[var14_17] = var16_19;
                                            var16_19 = Integer.TYPE;
                                            var54_51 = 2;
                                            var45_42[var54_51] = var16_19;
                                            var10_13 = var10_13.getConstructor((Class<?>[])var45_42);
                                            var17_20 = 3;
                                            var18_21 = 4.2E-45f;
                                            var45_42 = new Object[var17_20];
                                            var27_29 = 0;
                                            var13_16 = null;
                                            var45_42[0] = var8_11;
                                            var27_29 = 1;
                                            var45_42[var27_29] = var42_39;
                                            var13_16 = var20_23;
                                            var14_17 = 2;
                                            var45_42[var14_17] = var13_16;
                                            var10_13 = var10_13.newInstance(var45_42);
                                            var27_29 = -100;
                                            if (var36_35 <= var27_29) break block140;
                                            var27_29 = 0;
                                            var13_16 = null;
                                            var12_15.setSound(null, null);
                                            var55_52 = 0;
                                            var8_11 = null;
                                            var12_15.setDefaults(0);
                                            var55_52 = var36_35 & 1;
                                            var27_29 = var36_35 & 2;
                                            var14_17 = 4;
                                            var36_35 &= var14_17;
                                            var15_18 = "setSound";
                                            var7_10 = 1;
                                            if (var55_52 == var7_10) break block141;
                                            var55_52 = 2;
                                            var16_19 = new Object[var55_52];
                                            var55_52 = 0;
                                            var8_11 = null;
                                            var20_23 = 0;
                                            var19_22 = null;
                                            var16_19[0] = null;
                                            var16_19[var7_10] = null;
                                            ba.a(var10_13, (String)var15_18, (Object[])var16_19);
                                        }
                                        if (var50_47 != null) {
                                            var55_52 = 2;
                                            var16_19 = new Object[var55_52];
                                            var55_52 = 0;
                                            var8_11 = null;
                                            var16_19[0] = var50_47;
                                            var8_11 = Notification.AUDIO_ATTRIBUTES_DEFAULT;
                                            var7_10 = 1;
                                            var16_19[var7_10] = var8_11;
                                            ba.a(var10_13, (String)var15_18, (Object[])var16_19);
                                        }
                                        var8_11 = "enableVibration";
                                        var7_10 = 1;
                                        var15_18 = new Object[var7_10];
                                        var17_20 = 2;
                                        var18_21 = 2.8E-45f;
                                        if (var27_29 == var17_20) {
                                            var27_29 = 1;
                                            break block142;
                                        }
                                        var27_29 = 0;
                                        var13_16 = null;
                                    }
                                    var13_16 = (boolean)var27_29;
                                    var17_20 = 0;
                                    var18_21 = 0.0f;
                                    var16_19 = null;
                                    var15_18[0] = var13_16;
                                    ba.a(var10_13, (String)var8_11, var15_18);
                                    var8_11 = "enableLights";
                                    var7_10 = 1;
                                    var13_16 = new Object[var7_10];
                                    var14_17 = 4;
                                    if (var36_35 == var14_17) {
                                        var36_35 = 1;
                                        break block143;
                                    }
                                    var36_35 = 0;
                                    var9_12 /* !! */  = null;
                                }
                                var9_12 /* !! */  = (boolean)var36_35;
                                var14_17 = 0;
                                var15_18 = null;
                                var13_16[0] = var9_12 /* !! */ ;
                                ba.a(var10_13, (String)var8_11, (Object[])var13_16);
                            }
                            aa.a(var10_13, var11_14);
                            var8_11 = "createNotificationChannel";
                            var7_10 = 1;
                            var9_12 /* !! */  = new Object[var7_10];
                            var27_29 = 0;
                            var13_16 = null;
                            var9_12 /* !! */ [0] = var10_13;
                            ba.a(var6_6, (String)var8_11, var9_12 /* !! */ );
                        }
                        var8_11 = "getNotificationChannels";
                        var36_35 = 0;
                        var9_12 /* !! */  = null;
                        var10_13 = new Object[]{};
                        var8_11 = ba.a(var6_6, (String)var8_11, (Object[])var10_13);
                        if (var8_11 != null && (var36_35 = var8_11 instanceof List) != 0) {
                            var8_11 = (List)var8_11;
                            if (var8_11 == null) break block144;
                            var36_35 = var8_11.size();
                            if (var36_35 <= 0) break block144;
                            var36_35 = 0;
                            var9_12 /* !! */  = null;
                            while (true) {
                                block147: {
                                    var51_48 = var8_11.size();
                                    if (var36_35 >= var51_48) break block144;
                                    var10_13 = var8_11.get(var36_35);
                                    var13_16 = "getName";
                                    var14_17 = 0;
                                    var15_18 = null;
                                    var16_19 = new Object[]{};
                                    var13_16 = ba.a(var10_13, (String)var13_16, (Object[])var16_19);
                                    var16_19 = "getId";
                                    var45_42 = new Object[]{};
                                    var10_13 = ba.a(var10_13, (String)var16_19, var45_42);
                                    var15_18 = var49_46 /* !! */ ;
                                    var16_19 = g.b((Context)var5_5 /* !! */ , (String)var49_46 /* !! */ );
                                    if (var13_16 != null && var10_13 != null && (var43_40 = var13_16 instanceof CharSequence) != 0 && (var43_40 = var10_13 instanceof String) != 0) {
                                        block146: {
                                            var27_29 = (int)var13_16.equals(var16_19);
                                            if (var27_29 == 0) ** break block145
                                            var13_16 = var10_13;
                                            var13_16 = (String)var10_13;
                                            var16_19 = new StringBuilder();
                                            var45_42 = var48_45;
                                            var16_19.append((String)var48_45);
                                            var16_19.append((String)var49_46 /* !! */ );
                                            var16_19 = var16_19.toString();
                                            var27_29 = (int)var13_16.startsWith((String)var16_19);
                                            if (var27_29 == 0) break block146;
                                            var13_16 = var47_44;
                                            var17_20 = (int)var10_13.equals(var47_44);
                                            if (var17_20 != 0) break block147;
                                            var16_19 = "deleteNotificationChannel";
                                            var7_10 = 1;
                                            var46_43 = new Object[var7_10];
                                            var20_23 = 0;
                                            var19_22 = null;
                                            var46_43[0] = var10_13;
                                            ba.a(var6_6, (String)var16_19, var46_43);
                                            break block147;
                                        }
                                        var13_16 = var47_44;
                                    } else {
                                        var13_16 = var47_44;
                                        var45_42 = var48_45;
                                    }
                                }
                                ++var36_35;
                                var47_44 = var13_16;
                                var49_46 /* !! */  = var15_18;
                                var48_45 = var45_42;
                            }
                        }
                    }
                    break block144;
                    catch (Exception var6_8) {
                        b.a(var6_8);
                    }
                }
                var6_6 = (String)var11_14.get("background_color");
                var55_52 = (int)TextUtils.isEmpty((CharSequence)var6_6);
                if (var55_52 == 0) {
                    var21_24 = Integer.parseInt((String)var6_6);
                    var7_10 = 1;
                    var12_15.setOngoing((boolean)var7_10);
                    var12_15.setColor(var21_24);
                    var6_6 = "setColorized";
                    var8_11 = new Object[var7_10];
                    var42_39 = Boolean.TRUE;
                    var51_48 = 0;
                    var10_13 = null;
                    var8_11[0] = var42_39;
                    try {
                        ba.a((Object)var12_15, (String)var6_6, (Object[])var8_11);
                    }
                    catch (Exception var6_9) {
                        b.a(var6_9);
                    }
                }
                break block153;
            }
            var37_36 = var8_11;
            var44_41 = var27_29;
            if (var11_14 != null && var7_10 >= (var55_52 = 16) && var7_10 < (var55_52 = 26)) {
                var7_10 = aa.c(var11_14);
                var55_52 = 1;
                var9_12 /* !! */  = new Object[var55_52];
                var13_16 = var7_10;
                var51_49 = false;
                var9_12 /* !! */ [0] = var13_16;
                var10_13 = "setPriority";
                ba.a((Object)var12_15, (String)var10_13, var9_12 /* !! */ );
                if (var7_10 >= var55_52) {
                    var42_39 = new StringBuilder();
                    var9_12 /* !! */  = aa.a(var1_1);
                    var42_39.append((String)var9_12 /* !! */ );
                    var42_39.append((String)var16_19);
                    var42_39.append(var22_25);
                    var42_39 = var42_39.toString();
                    var9_12 /* !! */  = new Object[var55_52];
                    var55_52 = 0;
                    var8_11 = null;
                    var9_12 /* !! */ [0] = var42_39;
                    ba.a((Object)var12_15, (String)var6_6, var9_12 /* !! */ );
                }
            }
        }
        if ((var21_24 = (int)l.c()) != 0 && (var21_24 = (int)var30_31.equals(var6_6 = var0.getPackageName())) != 0) {
            var6_6 = new Object[3];
            var7_10 = 0;
            var6_6[0] = var5_5 /* !! */ ;
            var56_53 = true;
            var6_6[var56_53] = var12_15;
            var42_39 = aa.a(var1_1);
            var55_52 = 2;
            var6_6[var55_52] = var42_39;
            var42_39 = "miui.util.NotificationHelper";
            var8_11 = "setTargetPkg";
            ba.a((String)var42_39, (String)var8_11, (Object[])var6_6);
        }
        var6_6 = var12_15.getNotification();
        if (var44_41 != 0 && (var7_10 = (int)l.a()) != 0) {
            aa.a((Notification)var6_6);
        }
        if (var11_14 != null && (var42_39 = ba.a(var6_6, "extraNotification")) != null) {
            var8_11 = "enable_keyguard";
            var9_12 /* !! */  = (CharSequence)var11_14.get(var8_11);
            var36_35 = (int)TextUtils.isEmpty((CharSequence)var9_12 /* !! */ );
            if (var36_35 == 0) {
                var9_12 /* !! */  = new Object[1];
                var56_53 = Boolean.parseBoolean((String)var11_14.get(var8_11));
                var5_5 /* !! */  = var56_53;
                var55_52 = 0;
                var8_11 = null;
                var9_12 /* !! */ [0] = var5_5 /* !! */ ;
                var5_5 /* !! */  = "setEnableKeyguard";
                ba.a(var42_39, (String)var5_5 /* !! */ , var9_12 /* !! */ );
            }
            if ((var55_52 = (int)TextUtils.isEmpty((CharSequence)(var8_11 = (CharSequence)var11_14.get(var5_5 /* !! */  = "enable_float")))) == 0) {
                var55_52 = 1;
                var8_11 = new Object[var55_52];
                var56_53 = Boolean.parseBoolean((String)var11_14.get(var5_5 /* !! */ ));
                var5_5 /* !! */  = var56_53;
                var36_35 = 0;
                var9_12 /* !! */  = null;
                var8_11[0] = var5_5 /* !! */ ;
                var5_5 /* !! */  = "setEnableFloat";
                ba.a(var42_39, (String)var5_5 /* !! */ , (Object[])var8_11);
            }
        }
        var5_5 /* !! */  = var37_36;
        var37_36.a = var6_6;
        return var37_36;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static aa$c a(Context context, ii ii2, byte[] byArray) {
        int n10;
        Object object;
        Object object2;
        int n11;
        Object object3;
        int n12;
        Object object4;
        int n13;
        Object object5;
        int n14;
        Object object6;
        Object object7;
        Object object8;
        aa$c aa$c;
        int n15;
        Object object9;
        Object object10;
        Object object11;
        block48: {
            block47: {
                block46: {
                    object11 = context;
                    object10 = ii2;
                    object9 = byArray;
                    n15 = Build.VERSION.SDK_INT;
                    aa$c = new aa$c();
                    object8 = aa.a(ii2);
                    if ((object8 = g.a(context, object8)) != (object7 = g$a.c)) break block46;
                    object9 = ii2.a();
                    if (object9 != null) {
                        object11 = fb.a(context.getApplicationContext());
                        String string2 = ii2.b();
                        object8 = aa.b(ii2);
                        object9 = ((hz)object9).a();
                        object7 = new StringBuilder();
                        ((StringBuilder)object7).append("10:");
                        String string3 = aa.a(ii2);
                        ((StringBuilder)object7).append(string3);
                        object7 = ((StringBuilder)object7).toString();
                        ((fb)object11).a(string2, (String)object8, (String)object9, (String)object7);
                    }
                    object9 = new StringBuilder;
                    ((StringBuilder)object9)();
                    ((StringBuilder)object9).append("Do not notify because user block ");
                    object11 = aa.a(ii2);
                    ((StringBuilder)object9).append((String)object11);
                    object11 = "\u2018s notification";
                    ((StringBuilder)object9).append((String)object11);
                    object9 = ((StringBuilder)object9).toString();
                    break block47;
                }
                object8 = (NotificationManager)context.getSystemService("notification");
                object7 = ii2.a();
                object6 = aa.a(context, ii2, byArray);
                n14 = 0;
                object5 = null;
                if (object7 != null) {
                    n13 = ((hz)object7).c();
                } else {
                    n13 = 0;
                    object4 = null;
                }
                String string4 = aa.a(ii2);
                n12 = string4.hashCode() / 10 * 10 + n13;
                object4 = aa.a((Context)object11, (ii)object10, (hz)object7, (byte[])object9, n12);
                if (object4 != null) break block48;
                if (object7 != null) {
                    object9 = fb.a(context.getApplicationContext());
                    object11 = ii2.b();
                    object10 = aa.b(ii2);
                    String string5 = ((hz)object7).a();
                    object8 = "11";
                    ((fb)object9).a((String)object11, (String)object10, string5, (String)object8);
                }
                object9 = "The click PendingIntent is null. ";
            }
            b.a((String)object9);
            return aa$c;
        }
        int n16 = 11;
        int n17 = 0;
        Object[] objectArray = null;
        if (n15 >= n16) {
            long l10;
            object9 = aa.a((Context)object11, (ii)object10, (byte[])object9, (RemoteViews)object6, (PendingIntent)object4);
            aa$c.a = l10 = ((aa$b)object9).a;
            object6 = aa.a(ii2);
            aa$c.a = object6;
            object3 = object9 = ((aa$b)object9).a;
        } else {
            block44: {
                block45: {
                    object9 = aa.a(ii2);
                    n11 = aa.b((Context)object11, (String)object9);
                    long l11 = System.currentTimeMillis();
                    object3 = new Notification(n11, null, l11);
                    object9 = aa.a((Context)object11, (hz)object7);
                    try {
                        Class clazz;
                        object2 = object3.getClass();
                        String string6 = "setLatestEventInfo";
                        n17 = 4;
                        object = new Class[n17];
                        object[0] = clazz = Context.class;
                        clazz = CharSequence.class;
                        int n18 = 1;
                        object[n18] = clazz;
                        clazz = CharSequence.class;
                        n18 = 2;
                        object[n18] = clazz;
                        clazz = PendingIntent.class;
                        int n19 = 3;
                        object[n19] = clazz;
                        object = ((Class)object2).getMethod(string6, (Class<?>)object);
                        objectArray = new Object[n17];
                        objectArray[0] = object11;
                        object5 = object9[0];
                        int n20 = 1;
                        objectArray[n20] = object5;
                        objectArray[n18] = object9 = object9[n20];
                        objectArray[n19] = object4;
                        ((Method)object).invoke(object3, objectArray);
                        break block44;
                    }
                    catch (InvocationTargetException invocationTargetException) {
                        if (object7 == null) break block45;
                        object5 = fb.a(context.getApplicationContext());
                        object4 = ii2.b();
                        objectArray = aa.b(ii2);
                        object = ((hz)object7).a();
                        object2 = "7";
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        if (object7 == null) break block45;
                        object5 = fb.a(context.getApplicationContext());
                        object4 = ii2.b();
                        objectArray = aa.b(ii2);
                        object = ((hz)object7).a();
                        object2 = "6";
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        if (object7 == null) break block45;
                        object5 = fb.a(context.getApplicationContext());
                        object4 = ii2.b();
                        objectArray = aa.b(ii2);
                        object = ((hz)object7).a();
                        object2 = "5";
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        if (object7 == null) break block45;
                        object5 = fb.a(context.getApplicationContext());
                        object4 = ii2.b();
                        objectArray = aa.b(ii2);
                        object = ((hz)object7).a();
                        object2 = "4";
                    }
                    ((fb)object5).b((String)object4, (String)objectArray, (String)object, (String)object2);
                }
                b.a((Throwable)object9);
            }
            object9 = ((hz)object7).a();
            if (object9 != null && (n14 = object9.containsKey(object5 = "ticker")) != 0) {
                ((Notification)object3).tickerText = object5 = (CharSequence)object9.get("ticker");
            }
            long l12 = System.currentTimeMillis();
            long l13 = a;
            long l14 = 10000L;
            long l15 = (l13 = l12 - l13) - l14;
            n17 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n17 > 0) {
                a = l12;
                n14 = ((hz)object7).a;
                object4 = aa.a(ii2);
                n13 = (int)(aa.b((Context)object11, (String)object4) ? 1 : 0);
                if (n13 != 0) {
                    object5 = aa.a(ii2);
                    n14 = aa.a((Context)object11, (String)object5);
                }
                ((Notification)object3).defaults = n14;
                if (object9 != null && (n13 = n14 & 1) != 0 && (n13 = (int)(TextUtils.isEmpty((CharSequence)(object9 = (String)object9.get(object4 = "sound_uri"))) ? 1 : 0)) == 0) {
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append("android.resource://");
                    objectArray = aa.a(ii2);
                    ((StringBuilder)object4).append((String)objectArray);
                    object4 = ((StringBuilder)object4).toString();
                    n13 = (int)(((String)object9).startsWith((String)object4) ? 1 : 0);
                    if (n13 != 0) {
                        n13 = 1;
                        ((Notification)object3).defaults = n14 ^= n13;
                        object9 = Uri.parse((String)object9);
                        ((Notification)object3).sound = object9;
                    }
                }
            }
            ((Notification)object3).flags = n11 = ((Notification)object3).flags | 0x10;
            if (object6 != null) {
                ((Notification)object3).contentView = object6;
            }
        }
        n11 = (int)(l.a() ? 1 : 0);
        if (n11 != 0 && n15 >= (n11 = 19)) {
            object9 = ((hz)object7).a();
            n11 = (int)(TextUtils.isEmpty((CharSequence)object9) ? 1 : 0);
            if (n11 == 0) {
                object9 = ((Notification)object3).extras;
                object6 = "message_id";
                object5 = ((hz)object7).a();
                object9.putString((String)object6, (String)object5);
            }
            if ((object9 = (Object)((hz)object7).b()) == null) {
                n11 = 0;
                object9 = null;
            } else {
                object9 = ((hz)object7).b();
                object6 = "score_info";
                object9 = (String)object9.get(object6);
            }
            boolean bl2 = TextUtils.isEmpty((CharSequence)object9);
            if (!bl2) {
                object6 = ((Notification)object3).extras;
                object5 = "score_info";
                object6.putString((String)object5, (String)object9);
            }
            n11 = -1;
            bl2 = aa.c(ii2);
            if (bl2) {
                n11 = 1000;
            } else {
                bl2 = aa.a(ii2);
                if (bl2) {
                    n11 = 3000;
                }
            }
            object6 = ((Notification)object3).extras;
            object9 = String.valueOf(n11);
            object6.putString("eventMessageType", (String)object9);
            object9 = ((Notification)object3).extras;
            object6 = "target_package";
            object5 = aa.a(ii2);
            object9.putString((String)object6, (String)object5);
        }
        if ((object9 = ((hz)object7).a()) == null) {
            n17 = 0;
            objectArray = null;
        } else {
            object9 = ((hz)object7).a();
            object6 = "message_count";
            object9 = object9.get(object6);
            objectArray = (Object[])object9;
            objectArray = (String)object9;
        }
        n11 = (int)(l.a() ? 1 : 0);
        if (n11 != 0 && objectArray != null) {
            try {
                n11 = Integer.parseInt((String)objectArray);
                aa.a((Notification)object3, n11);
            }
            catch (NumberFormatException numberFormatException) {
                if (object7 != null) {
                    object6 = fb.a(context.getApplicationContext());
                    object5 = ii2.b();
                    object4 = aa.b(ii2);
                    objectArray = ((hz)object7).a();
                    object = "8";
                    ((fb)object6).b((String)object5, (String)object4, (String)objectArray, (String)object);
                }
                b.a(numberFormatException);
            }
        }
        if ((n11 = (int)(l.c() ? 1 : 0)) == 0 && (n11 = (int)(((String)(object9 = (Object)"com.xiaomi.xmsf")).equals(object6 = context.getPackageName()) ? 1 : 0)) != 0) {
            object9 = aa.a(ii2);
            aa.a((Notification)object3, (String)object9);
        }
        object8.notify(n12, (Notification)object3);
        n11 = (int)(l.a() ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((String)(object9 = "com.xiaomi.xmsf")).equals(object6 = context.getPackageName()) ? 1 : 0)) != 0) {
            object9 = ag.a();
            ((ag)object9).a((Context)object11, n12, (Notification)object3);
        }
        if ((n11 = (int)(aa.a(ii2) ? 1 : 0)) != 0) {
            object9 = context.getApplicationContext();
            object3 = fb.a((Context)object9);
            objectArray = ii2.b();
            object = aa.b(ii2);
            object2 = ((hz)object7).a();
            n10 = 3002;
            ((fb)object3).a((String)objectArray, (String)object, (String)object2, n10, null);
        }
        if ((n11 = (int)(aa.c(ii2) ? 1 : 0)) != 0) {
            object9 = context.getApplicationContext();
            object3 = fb.a((Context)object9);
            objectArray = ii2.b();
            object = aa.b(ii2);
            object2 = ((hz)object7).a();
            n10 = 1002;
            ((fb)object3).a((String)objectArray, (String)object, (String)object2, n10, null);
        }
        if (n15 < (n11 = 26)) {
            object9 = ai.a(context);
            ((ai)object9).a(n12);
            object11 = ((hz)object7).a();
            int n21 = aa.a((Map)object11);
            if (n21 > 0) {
                ab ab2 = new ab(n12, (NotificationManager)object8);
                ((ai)object9).b(ab2, n21);
            }
        }
        object11 = n12;
        object9 = new Pair(object11, object10);
        object11 = a;
        synchronized (object11) {
            ((LinkedList)object11).add(object9);
            n11 = ((LinkedList)object11).size();
            int n22 = 100;
            if (n11 > n22) {
                ((LinkedList)object11).remove();
            }
            return aa$c;
        }
    }

    private static String a(Context context, String string2, Map map) {
        String string3;
        CharSequence charSequence;
        boolean bl2;
        if (map != null && !(bl2 = TextUtils.isEmpty((CharSequence)(charSequence = (CharSequence)map.get(string3 = "channel_name"))))) {
            return (String)map.get(string3);
        }
        return g.b(context, string2);
    }

    public static String a(ii ii2) {
        Object object = "com.xiaomi.xmsf";
        Object object2 = ii2.b;
        boolean bl2 = ((String)object).equals(object2);
        if (bl2 && (object2 = ii2.a()) != null && (object = ((hz)object2).a()) != null) {
            object2 = ((hz)object2).a();
            object = "miui_package_name";
            boolean bl3 = TextUtils.isEmpty((CharSequence)(object2 = (String)object2.get(object)));
            if (!bl3) {
                return object2;
            }
        }
        return ii2.b;
    }

    private static void a(Notification object, int n10) {
        Object[] objectArray = "extraNotification";
        if ((object = ba.a(object, (String)objectArray)) != null) {
            Object object2;
            int n11 = 1;
            objectArray = new Object[n11];
            objectArray[0] = object2 = Integer.valueOf(n10);
            object2 = "setMessageCount";
            ba.a(object, (String)object2, objectArray);
        }
    }

    public static void a(Context context, String string2) {
        aa.a(context, string2, -1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context, String object, int n10) {
        NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
        int n11 = ((String)object).hashCode() / 10 * 10 + n10;
        LinkedList linkedList = new LinkedList();
        if (n10 >= 0) {
            notificationManager.cancel(n11);
        }
        LinkedList linkedList2 = a;
        synchronized (linkedList2) {
            boolean bl2;
            Iterator iterator2 = linkedList2.iterator();
            while (bl2 = iterator2.hasNext()) {
                int n12;
                int n13;
                Object object2 = iterator2.next();
                object2 = (Pair)object2;
                Object object3 = ((Pair)object2).second;
                if ((object3 = (ii)object3) == null) continue;
                object3 = aa.a((ii)object3);
                if (n10 >= 0) {
                    Object object4 = ((Pair)object2).first;
                    n13 = (Integer)(object4 = (Integer)object4);
                    if (n11 != n13 || (n12 = TextUtils.equals((CharSequence)object3, (CharSequence)object)) == 0) continue;
                } else {
                    n13 = -1;
                    if (n10 != n13 || (n12 = TextUtils.equals((CharSequence)object3, (CharSequence)object)) == 0) continue;
                    object3 = ((Pair)object2).first;
                    object3 = (Integer)object3;
                    n12 = (Integer)object3;
                    notificationManager.cancel(n12);
                }
                linkedList.add(object2);
            }
            object = a;
            if (object != null) {
                ((AbstractCollection)object).removeAll(linkedList);
                aa.a(context, linkedList);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context, String object, String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager)context.getSystemService("notification");
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = a;
        synchronized (linkedList2) {
            boolean bl3;
            Iterator iterator2 = linkedList2.iterator();
            while (bl3 = iterator2.hasNext()) {
                int n10;
                boolean bl4;
                Object object2 = iterator2.next();
                object2 = (Pair)object2;
                Object object3 = ((Pair)object2).second;
                if ((object3 = (ii)object3) == null) continue;
                String string4 = aa.a((ii)object3);
                if ((object3 = ((ii)object3).a()) == null || !(bl4 = TextUtils.equals((CharSequence)string4, (CharSequence)object))) continue;
                string4 = ((hz)object3).c();
                object3 = ((hz)object3).d();
                boolean bl5 = TextUtils.isEmpty((CharSequence)string4);
                if (bl5 || (bl5 = TextUtils.isEmpty((CharSequence)object3)) || !(bl4 = aa.a(string2, string4)) || (n10 = aa.a(string3, (String)object3)) == 0) continue;
                object3 = ((Pair)object2).first;
                object3 = (Integer)object3;
                n10 = (Integer)object3;
                notificationManager.cancel(n10);
                linkedList.add(object2);
            }
            object = a;
            if (object != null) {
                ((AbstractCollection)object).removeAll(linkedList);
                aa.a(context, linkedList);
            }
            return;
        }
    }

    public static void a(Context context, LinkedList linkedList) {
        int n10;
        if (linkedList != null && (n10 = linkedList.size()) > 0) {
            int n11 = linkedList.size();
            long l10 = n11;
            String string2 = "category_clear_notification";
            String string3 = "clear_notification";
            String string4 = "";
            bi.a(context, string2, string3, l10, string4);
        }
    }

    private static void a(Object object, Map object2) {
        String string2;
        Object[] objectArray;
        int n10;
        if (object2 != null && (n10 = TextUtils.isEmpty((CharSequence)(objectArray = (Object[])object2.get(string2 = "channel_description")))) == 0) {
            n10 = 1;
            objectArray = new Object[n10];
            objectArray[0] = object2 = object2.get(string2);
            object2 = "setDescription";
            ba.a(object, (String)object2, objectArray);
        }
    }

    public static boolean a(Context object, String string2) {
        Object object2 = "activity";
        if ((object = ((ActivityManager)object.getSystemService((String)object2)).getRunningAppProcesses()) != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (ActivityManager.RunningAppProcessInfo)object.next();
                int n10 = ((ActivityManager.RunningAppProcessInfo)object2).importance;
                int n11 = 100;
                if (n10 != n11 || !(bl2 = (object2 = Arrays.asList(((ActivityManager.RunningAppProcessInfo)object2).pkgList)).contains(string2))) continue;
                return true;
            }
        }
        return false;
    }

    private static boolean a(hz object) {
        int n10;
        int n11;
        boolean bl2 = false;
        if (object != null && (n11 = TextUtils.isEmpty((CharSequence)(object = ((hz)object).a()))) == 0 && (n11 = ((String)object).length()) == (n10 = 22)) {
            int n12 = ((String)object).charAt(0);
            String string2 = "satuigmo";
            if ((n12 = string2.indexOf(n12)) >= 0) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public static boolean a(ii cloneable) {
        boolean bl2;
        boolean bl3 = aa.a((hz)(cloneable = ((ii)cloneable).a()));
        if (bl3 && (bl2 = ((hz)cloneable).l())) {
            bl2 = true;
        } else {
            bl2 = false;
            cloneable = null;
        }
        return bl2;
    }

    private static boolean a(String string2, String string3) {
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3 && !(bl2 = string3.contains(string2))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean a(Map object) {
        String string2;
        boolean bl2;
        if (object != null && (bl2 = object.containsKey(string2 = "notify_foreground"))) {
            object = (String)object.get(string2);
            return "1".equals(object);
        }
        return true;
    }

    private static String[] a(Context object, hz object2) {
        Object object3;
        Object object4;
        block5: {
            block7: {
                boolean bl2;
                int n10;
                float f10;
                int n11;
                block6: {
                    boolean bl3;
                    object4 = ((hz)object2).c();
                    object3 = ((hz)object2).d();
                    if ((object2 = ((hz)object2).a()) == null) break block5;
                    DisplayMetrics displayMetrics = object.getResources().getDisplayMetrics();
                    n11 = displayMetrics.widthPixels;
                    float f11 = object.getResources().getDisplayMetrics().density;
                    f10 = (float)n11 / f11;
                    f11 = 0.5f;
                    object = Float.valueOf(f10 + f11);
                    n10 = ((Float)object).intValue();
                    n11 = 320;
                    f10 = 4.48E-43f;
                    if (n10 > n11) break block6;
                    object = (String)object2.get("title_short");
                    n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                    if (n11 == 0) {
                        object4 = object;
                    }
                    if (bl3 = TextUtils.isEmpty((CharSequence)(object = (String)object2.get("description_short")))) break block5;
                    break block7;
                }
                n11 = 360;
                f10 = 5.04E-43f;
                if (n10 <= n11) break block5;
                object = (String)object2.get("title_long");
                n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n11 == 0) {
                    object4 = object;
                }
                if (bl2 = TextUtils.isEmpty((CharSequence)(object = (String)object2.get("description_long")))) break block5;
            }
            object3 = object;
        }
        object = new String[]{object4, object3};
        return object;
    }

    private static int b(Context context, String string2) {
        int n10;
        String string3 = "mipush_notification";
        int n11 = aa.a(context, string2, string3);
        String string4 = "mipush_small_notification";
        int n12 = aa.a(context, string2, string4);
        if (n11 <= 0) {
            if (n12 > 0) {
                n11 = n12;
            } else {
                string2 = context.getApplicationInfo();
                n11 = ((ApplicationInfo)string2).icon;
            }
        }
        if (n11 == 0 && (n12 = Build.VERSION.SDK_INT) >= (n10 = 9)) {
            context = context.getApplicationInfo();
            n11 = context.logo;
        }
        return n11;
    }

    private static int b(Map object) {
        CharSequence charSequence;
        boolean bl2;
        int n10 = 3;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = (String)object.get(charSequence = "channel_importance"))))) {
            charSequence = new StringBuilder();
            String string2 = "importance=";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            try {
                b.c((String)charSequence);
                n10 = Integer.parseInt((String)object);
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                string2 = "parsing channel importance error: ";
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(exception);
                String string3 = ((StringBuilder)charSequence).toString();
                b.d(string3);
            }
        }
        return n10;
    }

    public static String b(ii ii2) {
        boolean bl2 = aa.a(ii2);
        if (bl2) {
            return "E100002";
        }
        bl2 = aa.c(ii2);
        if (bl2) {
            return "E100000";
        }
        bl2 = aa.b(ii2);
        if (bl2) {
            return "E100001";
        }
        boolean bl3 = aa.d(ii2);
        if (bl3) {
            return "E100003";
        }
        return "";
    }

    public static void b(Context context, String string2) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(string2).commit();
    }

    public static void b(Context context, String string2, int n10) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(string2, n10).commit();
    }

    public static boolean b(Context context, String string2) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(string2);
    }

    public static boolean b(ii ii2) {
        boolean bl2;
        int n10;
        hz hz2 = ii2.a();
        boolean bl3 = aa.a(hz2);
        int n11 = 1;
        if (!bl3 || (n10 = hz2.b) != n11 || (bl2 = aa.a(ii2))) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private static int c(Map object) {
        CharSequence charSequence;
        boolean bl2;
        int n10 = 0;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = (String)object.get(charSequence = "notification_priority"))))) {
            charSequence = new StringBuilder();
            String string2 = "priority=";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            try {
                b.c((String)charSequence);
                n10 = Integer.parseInt((String)object);
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                string2 = "parsing notification priority error: ";
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(exception);
                String string3 = ((StringBuilder)charSequence).toString();
                b.d(string3);
            }
        }
        return n10;
    }

    public static boolean c(ii ii2) {
        boolean bl2;
        int n10;
        hz hz2 = ii2.a();
        boolean bl3 = aa.a(hz2);
        if (bl3 && (n10 = hz2.b) == 0 && !(bl2 = aa.a(ii2))) {
            bl2 = true;
        } else {
            bl2 = false;
            ii2 = null;
        }
        return bl2;
    }

    public static boolean d(ii object) {
        boolean bl2;
        hm hm2;
        if ((object = object.a()) == (hm2 = hm.a)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean e(ii ii2) {
        boolean bl2;
        boolean bl3 = aa.a(ii2);
        if (!(bl3 || (bl3 = aa.c(ii2)) || (bl2 = aa.b(ii2)))) {
            bl2 = false;
            ii2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

