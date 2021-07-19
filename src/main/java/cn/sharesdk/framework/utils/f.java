/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap$CompressFormat
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.framework.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class f {
    private String a;
    private String b;
    private boolean c = true;

    public void a(Uri object, Platform platform, PlatformActionListener platformActionListener) {
        Object object2 = new Intent("android.intent.action.SEND");
        object2.setType("video/*");
        String string2 = this.a;
        object2.setPackage(string2);
        string2 = "android.intent.extra.STREAM";
        object2.putExtra(string2, (Parcelable)object);
        object = this.b;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 != 0) {
            object = this.a;
            object2.setPackage((String)object);
        } else {
            object = this.a;
            string2 = this.b;
            object2.setClassName((String)object, string2);
        }
        n10 = 0x10000000;
        object2.addFlags(n10);
        object = MobSDK.getContext();
        try {
            object.startActivity((Intent)object2);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(throwable);
        }
        object = new HashMap();
        int n11 = 0;
        object2 = null;
        string2 = "ShareParams";
        ((HashMap)object).put(string2, null);
        if (platformActionListener != null) {
            n11 = 9;
            platformActionListener.onComplete(platform, n11, (HashMap)object);
        }
    }

    public void a(Platform$ShareParams object, Platform object2) {
        int n10;
        int n11;
        Object object3;
        int n12;
        Object[] objectArray = SSDKLog.b();
        String string2 = null;
        Object object4 = new Object[]{};
        objectArray.d("ShareSDK QQ ShareBypassApproval toShare", (Object[])object4);
        objectArray = new Intent();
        object4 = ((InnerShareParams)object).getImagePath();
        Object object5 = ((InnerShareParams)object).getImageUrl();
        Object object6 = new ArrayList();
        Object object7 = ((InnerShareParams)object).getImageArray();
        if (object7 != null) {
            object6 = Arrays.asList(((InnerShareParams)object).getImageArray());
        }
        object7 = ((InnerShareParams)object).getText();
        int n13 = TextUtils.isEmpty((CharSequence)object7);
        if (n13 == 0) {
            object2 = ((Platform)object2).getShortLintk((String)object7, false);
            ((InnerShareParams)object).setText((String)object2);
            objectArray.putExtra("android.intent.extra.TEXT", (String)object2);
            object7 = "Kdescription";
            objectArray.putExtra((String)object7, (String)object2);
        }
        object2 = "images";
        if (object6 == null || (n12 = object6.size()) <= 0) {
            n12 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0);
            if (n12 != 0 || (n12 = (int)(((File)(object7 = new File((String)object4))).exists() ? 1 : 0)) == 0) {
                if ((object = ((InnerShareParams)object).getImageData()) != null && (n12 = (int)(object.isRecycled() ? 1 : 0)) == 0) {
                    object4 = ResHelper.getCachePath(MobSDK.getContext(), (String)object2);
                    object7 = new StringBuilder();
                    long l10 = System.currentTimeMillis();
                    ((StringBuilder)object7).append(l10);
                    object3 = ".png";
                    ((StringBuilder)object7).append((String)object3);
                    object7 = ((StringBuilder)object7).toString();
                    object5 = new File((String)object4, (String)object7);
                    object4 = new FileOutputStream((File)object5);
                    object7 = Bitmap.CompressFormat.PNG;
                    n13 = 100;
                    object.compress((Bitmap.CompressFormat)object7, n13, (OutputStream)object4);
                    ((OutputStream)object4).flush();
                    ((FileOutputStream)object4).close();
                    object4 = ((File)object5).getAbsolutePath();
                } else {
                    n11 = TextUtils.isEmpty((CharSequence)object5);
                    if (n11 == 0) {
                        object = MobSDK.getContext();
                        object4 = BitmapHelper.downloadBitmap((Context)object, (String)object5);
                    }
                }
            }
            if ((n11 = TextUtils.isEmpty((CharSequence)object4)) == 0) {
                object6.add((Object)object4);
            }
        }
        object = new ArrayList();
        object4 = object6.iterator();
        while ((n10 = object4.hasNext()) != 0) {
            object5 = (String)object4.next();
            boolean bl2 = ((String)object5).startsWith((String)(object6 = "http"));
            if (bl2) {
                object6 = MobSDK.getContext();
                object5 = BitmapHelper.downloadBitmap((Context)object6, (String)object5);
            }
            if ((n12 = (int)(((File)(object6 = new File((String)object5))).exists() ? 1 : 0)) == 0) continue;
            object7 = "/data/";
            n12 = (int)(((String)object5).startsWith((String)object7) ? 1 : 0);
            if (n12 != 0) {
                object7 = ResHelper.getCachePath(MobSDK.getContext(), (String)object2);
                CharSequence charSequence = new StringBuilder();
                long l11 = System.currentTimeMillis();
                charSequence.append(l11);
                String string3 = ((File)object6).getName();
                charSequence.append(string3);
                charSequence = charSequence.toString();
                object3 = new File((String)object7, (String)charSequence);
                object7 = ((File)object3).getAbsolutePath();
                ((File)object3).createNewFile();
                n10 = (int)(ResHelper.copyFile((String)object5, (String)object7) ? 1 : 0);
                if (n10 != 0) {
                    object6 = object3;
                }
            }
            if ((n10 = Build.VERSION.SDK_INT) >= (n12 = 24)) {
                object5 = MobSDK.getContext();
                object7 = new StringBuilder();
                object3 = MobSDK.getContext();
                object3 = object3.getPackageName();
                ((StringBuilder)object7).append((String)object3);
                object3 = ".cn.sharesdk.ShareSDKFileProvider";
                ((StringBuilder)object7).append((String)object3);
                object7 = ((StringBuilder)object7).toString();
                object5 = ShareSDKFileProvider.a((Context)object5, (String)object7, (File)object6);
                object6 = MobSDK.getContext();
                object7 = this.a;
                n13 = 3;
                object6.grantUriPermission((String)object7, (Uri)object5, n13);
                try {
                    ((ArrayList)object).add(object5);
                }
                catch (Throwable throwable) {
                    object6 = SSDKLog.b();
                    object7 = new Object[]{};
                    object3 = "ShareSDK ShareBypassApproval getUriForFile exception";
                    ((NLog)object6).d(throwable, object3, (Object[])object7);
                }
                continue;
            }
            object5 = Uri.fromFile((File)object6);
            ((ArrayList)object).add(object5);
        }
        int n14 = ((ArrayList)object).size();
        object4 = "android.intent.action.SEND";
        if (n14 <= 0) {
            objectArray.setAction((String)object4);
            object = "text/plain";
            objectArray.setType((String)object);
        } else {
            n14 = ((ArrayList)object).size();
            n10 = 1;
            object6 = "image/*";
            object7 = "android.intent.extra.STREAM";
            if (n14 == n10 && (object2 = ((ArrayList)object).get(0)) != null) {
                objectArray.setAction((String)object4);
                object2 = (Parcelable)((ArrayList)object).get(0);
                objectArray.putExtra((String)object7, (Parcelable)object2);
                object2 = URLConnection.getFileNameMap();
                object = ((Uri)((ArrayList)object).get(0)).toString();
                object = object2.getContentTypeFor((String)object);
                if (object != null && (n14 = ((String)object).length()) > 0) {
                    object6 = object;
                }
                objectArray.setType((String)object6);
            } else {
                object2 = "android.intent.action.SEND_MULTIPLE";
                objectArray.setAction((String)object2);
                objectArray.putParcelableArrayListExtra((String)object7, (ArrayList)object);
                objectArray.setType((String)object6);
            }
        }
        object = this.b;
        n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 != 0) {
            object = this.a;
            objectArray.setPackage((String)object);
        } else {
            object = this.a;
            object2 = this.b;
            objectArray.setClassName((String)object, (String)object2);
        }
        n11 = 0x14000000;
        objectArray.addFlags(n11);
        object = MobSDK.getContext();
        try {
            object.startActivity((Intent)objectArray);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            objectArray = new Object[]{};
            string2 = "ShareSDK  QQ ShareBypassApproval toShare catch";
            ((NLog)object2).d(throwable, (Object)string2, objectArray);
        }
    }

    public void a(String string2) {
        this.a = string2;
        this.b = "";
    }

    public void a(String uri, Platform platform, PlatformActionListener platformActionListener) {
        Object object;
        Object object2 = new Intent("android.intent.action.SEND");
        Object object3 = "mp4";
        int n10 = uri.endsWith((String)object3);
        if (n10 != 0 || (n10 = uri.endsWith((String)(object3 = "mkv"))) != 0) {
            object3 = "video/*";
            object2.setType((String)object3);
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object3 = this.b))) != 0) {
            object3 = this.a;
            object2.setPackage((String)object3);
        } else {
            object3 = this.a;
            object = this.b;
            object2.setClassName((String)object3, (String)object);
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        String string2 = "android.intent.extra.STREAM";
        if (n10 >= n11) {
            n10 = (int)(TextUtils.isEmpty((CharSequence)uri) ? 1 : 0);
            if (n10 == 0) {
                object3 = new File((String)uri);
                uri = MobSDK.getContext();
                object = new StringBuilder();
                Object object4 = MobSDK.getContext();
                object4 = object4.getPackageName();
                object.append((String)object4);
                object4 = ".cn.sharesdk.ShareSDKFileProvider";
                object.append((String)object4);
                object = object.toString();
                uri = ShareSDKFileProvider.a(uri, (String)object, (File)object3);
                object3 = MobSDK.getContext();
                object = this.a;
                int n12 = 3;
                object3.grantUriPermission((String)object, uri, n12);
                try {
                    object2.putExtra(string2, (Parcelable)uri);
                }
                catch (Throwable throwable) {
                    object3 = SSDKLog.b();
                    n11 = 0;
                    object = new Object[]{};
                    string2 = "ShareSDK ShareBypassApproval getUriForFile exception";
                    ((NLog)object3).d(throwable, (Object)string2, object);
                }
            }
        } else {
            object3 = new File((String)uri);
            uri = Uri.fromFile((File)object3);
            object2.putExtra(string2, (Parcelable)uri);
        }
        int n13 = 0x10000000;
        object2.addFlags(n13);
        uri = MobSDK.getContext();
        try {
            uri.startActivity((Intent)object2);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(throwable);
        }
        uri = new HashMap();
        int n14 = 0;
        object2 = null;
        object3 = "ShareParams";
        uri.put(object3, null);
        if (platformActionListener != null) {
            n14 = 9;
            platformActionListener.onComplete(platform, n14, (HashMap)uri);
        }
    }

    public void a(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }
}

