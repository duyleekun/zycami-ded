/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.wechat.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import cn.sharesdk.framework.utils.f;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.utils.WXAppExtendObject;
import cn.sharesdk.wechat.utils.WXEmojiObject;
import cn.sharesdk.wechat.utils.WXFileObject;
import cn.sharesdk.wechat.utils.WXImageObject;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WXMiniProgramObject;
import cn.sharesdk.wechat.utils.WXMusicObject;
import cn.sharesdk.wechat.utils.WXTextObject;
import cn.sharesdk.wechat.utils.WXVideoObject;
import cn.sharesdk.wechat.utils.WXWebpageObject;
import cn.sharesdk.wechat.utils.WechatHandlerActivity;
import cn.sharesdk.wechat.utils.a;
import cn.sharesdk.wechat.utils.d;
import cn.sharesdk.wechat.utils.g;
import cn.sharesdk.wechat.utils.i$a;
import cn.sharesdk.wechat.utils.j;
import cn.sharesdk.wechat.utils.k;
import cn.sharesdk.wechat.utils.m;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class l {
    private static l a;
    private j b;
    private k c;
    private String d;
    private String e;
    private boolean f;
    private int g;

    private l() {
        j j10;
        this.b = j10 = new j();
    }

    private Bitmap a(Bitmap bitmap, double d10) {
        int n10 = bitmap.getWidth();
        int n11 = bitmap.getHeight();
        d10 = Math.sqrt(d10);
        n10 = (int)((double)n10 / d10);
        int n12 = (int)((double)n11 / d10);
        return Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n10, (int)n12, (boolean)true);
    }

    public static l a() {
        l l10 = a;
        if (l10 == null) {
            a = l10 = new l();
        }
        return a;
    }

    private void a(Context object, String string2, String string3, Bitmap bitmap, int n10, k k10) {
        WXImageObject wXImageObject = new WXImageObject();
        Object object2 = new ByteArrayOutputStream();
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        int n11 = 85;
        bitmap.compress(compressFormat, n11, (OutputStream)object2);
        ((OutputStream)object2).flush();
        ((ByteArrayOutputStream)object2).close();
        object2 = ((ByteArrayOutputStream)object2).toByteArray();
        wXImageObject.imageData = (byte[])object2;
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).mediaObject = wXImageObject;
        if (n10 != 0) {
            ((WXMediaMessage)object2).title = string2;
            ((WXMediaMessage)object2).description = string3;
        }
        object = this.a((Context)object, bitmap, false);
        ((WXMediaMessage)object2).thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "img", n10, k10);
    }

    private void a(Context object, String string2, String string3, String string4, int n10, k k10) {
        Object object2;
        WXImageObject wXImageObject = new WXImageObject();
        boolean bl2 = this.f();
        if (bl2) {
            bl2 = this.g();
            if (bl2) {
                object2 = new File(string4);
                wXImageObject.imagePath = object2 = this.a((File)object2);
                NLog nLog = SSDKLog.b();
                StringBuilder stringBuilder = new StringBuilder();
                String string5 = "ShareSDK share file with FileProvider path is: ";
                stringBuilder.append(string5);
                stringBuilder.append((String)object2);
                object2 = stringBuilder.toString();
                nLog.w((String)object2);
            }
        } else {
            object2 = k10.c();
            if (object2 != null) {
                object2 = new Throwable("Wecaht Version is not new");
                PlatformActionListener platformActionListener = k10.c();
                Platform platform = k10.b();
                int n11 = 9;
                platformActionListener.onError(platform, n11, (Throwable)object2);
            }
        }
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).mediaObject = wXImageObject;
        if (n10 != 0) {
            ((WXMediaMessage)object2).title = string2;
            ((WXMediaMessage)object2).description = string3;
        }
        object = this.a((Context)object, string4, false);
        ((WXMediaMessage)object2).thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "img", n10, k10);
    }

    private void a(Context object, String string2, String string3, String object2, Bitmap bitmap, int n10, k k10) {
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = object2;
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).title = string2;
        ((WXMediaMessage)object2).description = string3;
        ((WXMediaMessage)object2).mediaObject = wXVideoObject;
        object = this.a((Context)object, bitmap, false);
        ((WXMediaMessage)object2).thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "video", n10, k10);
    }

    private void a(Context object, String string2, String string3, String object2, String string4, int n10, k k10) {
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = object2;
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).title = string2;
        ((WXMediaMessage)object2).description = string3;
        ((WXMediaMessage)object2).mediaObject = wXVideoObject;
        object = this.a((Context)object, string4, false);
        ((WXMediaMessage)object2).thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "video", n10, k10);
    }

    private void a(Context object, String string2, String string3, String object2, String string4, Bitmap bitmap, int n10, k k10) {
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = string4;
        wXMusicObject.musicDataUrl = object2;
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).title = string2;
        ((WXMediaMessage)object2).description = string3;
        ((WXMediaMessage)object2).mediaObject = wXMusicObject;
        object = this.a((Context)object, bitmap, false);
        ((WXMediaMessage)object2).thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "music", n10, k10);
    }

    private void a(Context object, String string2, String string3, String object2, String string4, String string5, int n10, k k10) {
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = string4;
        wXMusicObject.musicDataUrl = object2;
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).title = string2;
        ((WXMediaMessage)object2).description = string3;
        ((WXMediaMessage)object2).mediaObject = wXMusicObject;
        object = this.a((Context)object, string5, false);
        ((WXMediaMessage)object2).thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "music", n10, k10);
    }

    private void a(Context object, String object2, String string2, String charSequence, String string3, String string4, Bitmap bitmap, int n10, k k10) {
        int n11;
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = object2;
        int n12 = TextUtils.isEmpty((CharSequence)string2);
        String string5 = "@app";
        if (n12 == 0 && (n12 = string2.endsWith(string5)) != 0) {
            wXMiniProgramObject.userName = string2;
        } else {
            object2 = new StringBuilder();
            object2.append(string2);
            object2.append(string5);
            object2 = object2.toString();
            wXMiniProgramObject.userName = object2;
        }
        n12 = TextUtils.isEmpty((CharSequence)charSequence);
        int n13 = 1;
        if (n12 == 0) {
            object2 = ((String)charSequence).split("\\?");
            n11 = ((String[])object2).length;
            string5 = null;
            if (n11 > n13) {
                charSequence = new StringBuilder();
                string5 = object2[0];
                ((StringBuilder)charSequence).append(string5);
                string5 = ".html?";
                ((StringBuilder)charSequence).append(string5);
                object2 = object2[n13];
                ((StringBuilder)charSequence).append((String)object2);
                object2 = ((StringBuilder)charSequence).toString();
            } else {
                charSequence = new StringBuilder();
                object2 = object2[0];
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(".html");
                object2 = ((StringBuilder)charSequence).toString();
            }
            wXMiniProgramObject.path = object2;
            wXMiniProgramObject.withShareTicket = n12 = this.f;
            wXMiniProgramObject.miniprogramType = n12 = this.g;
        }
        object2 = new WXMediaMessage();
        object2.title = string3;
        object2.mediaObject = wXMiniProgramObject;
        object2.description = string4;
        if (bitmap != null && (n11 = (int)(bitmap.isRecycled() ? 1 : 0)) == 0) {
            object = this.a((Context)object, bitmap, n13 != 0);
            object2.thumbData = (byte[])object;
            if (object != null) {
                int n14 = ((Context)object).length;
                n13 = 131072;
                if (n14 > n13) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("checkArgs fail, thumbData is too large: ");
                    n12 = object2.thumbData.length;
                    ((StringBuilder)charSequence).append(n12);
                    ((StringBuilder)charSequence).append(" > ");
                    ((StringBuilder)charSequence).append(n13);
                    object2 = ((StringBuilder)charSequence).toString();
                    object = new RuntimeException((String)object2);
                    throw object;
                }
            } else {
                object = new RuntimeException("checkArgs fail, thumbData is null");
                throw object;
            }
        }
        this.a((WXMediaMessage)object2, "webpage", n10, k10);
    }

    private void a(Context object, String object2, String string2, String charSequence, String string3, String string4, String string5, int n10, k k10) {
        int n11;
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.miniprogramType = n11 = this.g;
        wXMiniProgramObject.webpageUrl = object2;
        int n12 = TextUtils.isEmpty((CharSequence)string2);
        String string6 = "@app";
        if (n12 == 0 && (n12 = string2.endsWith(string6)) != 0) {
            wXMiniProgramObject.userName = string2;
        } else {
            object2 = new StringBuilder();
            object2.append(string2);
            object2.append(string6);
            object2 = object2.toString();
            wXMiniProgramObject.userName = object2;
        }
        n12 = TextUtils.isEmpty((CharSequence)charSequence);
        int n13 = 1;
        if (n12 == 0) {
            object2 = ((String)charSequence).split("\\?");
            int n14 = ((String[])object2).length;
            n11 = 0;
            string6 = null;
            if (n14 > n13) {
                charSequence = new StringBuilder();
                string6 = object2[0];
                ((StringBuilder)charSequence).append(string6);
                string6 = ".html?";
                ((StringBuilder)charSequence).append(string6);
                object2 = object2[n13];
                ((StringBuilder)charSequence).append((String)object2);
                object2 = ((StringBuilder)charSequence).toString();
            } else {
                charSequence = new StringBuilder();
                object2 = object2[0];
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(".html");
                object2 = ((StringBuilder)charSequence).toString();
            }
            wXMiniProgramObject.path = object2;
            wXMiniProgramObject.withShareTicket = n12 = this.f;
            wXMiniProgramObject.miniprogramType = n12 = this.g;
        }
        object2 = new WXMediaMessage();
        object2.title = string3;
        object2.mediaObject = wXMiniProgramObject;
        object2.description = string4;
        object = this.a((Context)object, string5, n13 != 0);
        object2.thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "webpage", n10, k10);
    }

    private void a(WXMediaMessage wXMediaMessage, String string2, int n10, k k10) {
        boolean bl2;
        Object object;
        Object object2 = DeviceHelper.getInstance(MobSDK.getContext());
        Serializable serializable = new StringBuilder();
        object2 = ((DeviceHelper)object2).getPackageName();
        ((StringBuilder)serializable).append((String)object2);
        ((StringBuilder)serializable).append(".wxapi.WXEntryActivity");
        object2 = ((StringBuilder)serializable).toString();
        try {
            serializable = Class.forName((String)object2);
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            ((NLog)object).d(throwable);
            bl2 = false;
            serializable = null;
        }
        if (serializable != null && !(bl2 = ((Class)(object = WechatHandlerActivity.class)).isAssignableFrom((Class<?>)serializable))) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append((String)object2);
            ((StringBuilder)serializable).append(" does not extend from ");
            object2 = WechatHandlerActivity.class.getName();
            ((StringBuilder)serializable).append((String)object2);
            object2 = ((StringBuilder)serializable).toString();
            serializable = new Throwable((String)object2);
            ((Throwable)serializable).printStackTrace();
        }
        object2 = new d();
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append(string2);
        long l10 = System.currentTimeMillis();
        ((StringBuilder)serializable).append(l10);
        ((m)object2).e = string2 = ((StringBuilder)serializable).toString();
        ((d)object2).a = wXMediaMessage;
        ((d)object2).b = n10;
        this.c = k10;
        boolean bl3 = wXMediaMessage.mediaObject instanceof WXMiniProgramObject;
        this.b.a((m)object2, bl3);
    }

    private void a(String string2, String string3) {
        int n10;
        i$a i$a = new i$a();
        i$a.a = string2;
        i$a.b = string3;
        i$a.c = n10 = this.g;
        this.b.b(i$a);
    }

    private void a(String string2, String string3, int n10, k k10) {
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = string3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = string2;
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = string3;
        this.a(wXMediaMessage, "text", n10, k10);
    }

    private byte[] a(Context object, Bitmap bitmap, Bitmap.CompressFormat compressFormat, boolean bl2) {
        if (bitmap != null) {
            boolean bl3 = bitmap.isRecycled();
            if (!bl3) {
                object = new ByteArrayOutputStream();
                int n10 = 100;
                bitmap.compress(compressFormat, n10, (OutputStream)object);
                object.flush();
                object.close();
                object = object.toByteArray();
                int n11 = ((Context)object).length;
                int n12 = 32768;
                if (bl2) {
                    n12 = 131072;
                }
                while (n11 > n12) {
                    double d10 = n11;
                    double d11 = n12;
                    bitmap = this.a(bitmap, d10 /= d11);
                    object = new ByteArrayOutputStream();
                    bitmap.compress(compressFormat, n10, (OutputStream)object);
                    object.flush();
                    object.close();
                    object = object.toByteArray();
                    n11 = ((Context)object).length;
                }
                return object;
            }
            object = new RuntimeException("checkArgs fail, thumbData is recycled");
            throw object;
        }
        object = new RuntimeException("checkArgs fail, thumbData is null");
        throw object;
    }

    private byte[] a(Context object, Bitmap bitmap, boolean bl2) {
        if (bitmap != null) {
            boolean bl3 = bitmap.isRecycled();
            if (!bl3) {
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                return this.a((Context)object, bitmap, compressFormat, bl2);
            }
            object = new RuntimeException("checkArgs fail, thumbData is recycled");
            throw object;
        }
        object = new RuntimeException("checkArgs fail, thumbData is null");
        throw object;
    }

    private byte[] a(Context object, String string2, boolean bl2) {
        File file = new File(string2);
        boolean bl3 = file.exists();
        if (bl3) {
            file = BitmapHelper.getBmpFormat((String)string2);
            string2 = BitmapHelper.getBitmap((String)string2);
            return this.a((Context)object, (Bitmap)string2, (Bitmap.CompressFormat)file, bl2);
        }
        object = new FileNotFoundException();
        throw object;
    }

    private void b(Context object, String string2, String string3, Bitmap object2, int n10, k k10) {
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        object = this.a((Context)object, (Bitmap)object2, false);
        wXEmojiObject.emojiData = (byte[])object;
        object2 = new WXMediaMessage();
        object2.title = string2;
        object2.mediaObject = wXEmojiObject;
        object2.description = string3;
        object2.thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "emoji", n10, k10);
    }

    private void b(Context object, String string2, String string3, String string4, int n10, k k10) {
        WXImageObject wXImageObject = new WXImageObject();
        Object object2 = "/data/";
        int n11 = string4.startsWith((String)object2);
        if (n11 != 0) {
            object2 = this.d(string4);
            wXImageObject.imageData = (byte[])object2;
        } else {
            n11 = Build.VERSION.SDK_INT;
            int n12 = 24;
            if (n11 >= n12) {
                object2 = new File(string4);
                wXImageObject.imagePath = object2 = this.a((File)object2);
            } else {
                wXImageObject.imagePath = string4;
            }
        }
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).mediaObject = wXImageObject;
        if (n10 != 0) {
            ((WXMediaMessage)object2).title = string2;
            ((WXMediaMessage)object2).description = string3;
        }
        object = this.a((Context)object, string4, false);
        ((WXMediaMessage)object2).thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "img", n10, k10);
    }

    private void b(Context object, String string2, String charSequence, String object2, Bitmap bitmap, int n10, k k10) {
        int n11;
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = object2;
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).title = string2;
        ((WXMediaMessage)object2).description = charSequence;
        ((WXMediaMessage)object2).mediaObject = wXWebpageObject;
        if (bitmap != null && (n11 = bitmap.isRecycled()) == 0) {
            n11 = 0;
            string2 = null;
            object = this.a((Context)object, bitmap, false);
            ((WXMediaMessage)object2).thumbData = (byte[])object;
            if (object != null) {
                int n12 = ((Context)object).length;
                n11 = 32768;
                if (n12 > n11) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("checkArgs fail, thumbData is too large: ");
                    int n13 = ((WXMediaMessage)object2).thumbData.length;
                    ((StringBuilder)charSequence).append(n13);
                    ((StringBuilder)charSequence).append(" > ");
                    ((StringBuilder)charSequence).append(n11);
                    string2 = ((StringBuilder)charSequence).toString();
                    object = new RuntimeException(string2);
                    throw object;
                }
            } else {
                object = new RuntimeException("checkArgs fail, thumbData is null");
                throw object;
            }
        }
        this.a((WXMediaMessage)object2, "webpage", n10, k10);
    }

    private void b(Context object, String object2, String charSequence, String object3, String string2, int n10, k k10) {
        int n11;
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = object3;
        object3 = new WXMediaMessage();
        ((WXMediaMessage)object3).title = object2;
        ((WXMediaMessage)object3).description = charSequence;
        ((WXMediaMessage)object3).mediaObject = wXWebpageObject;
        if (string2 != null && (n11 = ((File)(object2 = new File(string2))).exists()) != 0) {
            n11 = 0;
            object2 = null;
            object = this.a((Context)object, string2, false);
            ((WXMediaMessage)object3).thumbData = (byte[])object;
            if (object != null) {
                int n12 = ((Context)object).length;
                n11 = 32768;
                if (n12 > n11) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("checkArgs fail, thumbData is too large: ");
                    int n13 = ((WXMediaMessage)object3).thumbData.length;
                    ((StringBuilder)charSequence).append(n13);
                    ((StringBuilder)charSequence).append(" > ");
                    ((StringBuilder)charSequence).append(n11);
                    object2 = ((StringBuilder)charSequence).toString();
                    object = new RuntimeException((String)object2);
                    throw object;
                }
            } else {
                object = new RuntimeException("checkArgs fail, thumbData is null");
                throw object;
            }
        }
        this.a((WXMediaMessage)object3, "webpage", n10, k10);
    }

    private void b(Context object, String string2, String string3, String object2, String string4, Bitmap bitmap, int n10, k k10) {
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.filePath = object2;
        wXAppExtendObject.extInfo = string4;
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).title = string2;
        ((WXMediaMessage)object2).description = string3;
        ((WXMediaMessage)object2).mediaObject = wXAppExtendObject;
        object = this.a((Context)object, bitmap, false);
        ((WXMediaMessage)object2).thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "appdata", n10, k10);
    }

    private void b(Context object, String string2, String string3, String object2, String string4, String string5, int n10, k k10) {
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.filePath = object2;
        wXAppExtendObject.extInfo = string4;
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).title = string2;
        ((WXMediaMessage)object2).description = string3;
        ((WXMediaMessage)object2).mediaObject = wXAppExtendObject;
        object = this.a((Context)object, string5, false);
        ((WXMediaMessage)object2).thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "appdata", n10, k10);
    }

    private void c(Context object, String string2, String string3, String string4, int n10, k k10) {
        Object object2;
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            object2 = new File(string4);
            wXEmojiObject.emojiPath = object2 = this.a((File)object2);
        } else {
            wXEmojiObject.emojiPath = string4;
        }
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).title = string2;
        ((WXMediaMessage)object2).mediaObject = wXEmojiObject;
        ((WXMediaMessage)object2).description = string3;
        object = this.a((Context)object, string4, false);
        ((WXMediaMessage)object2).thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "emoji", n10, k10);
    }

    private void c(Context object, String string2, String string3, String object2, Bitmap bitmap, int n10, k k10) {
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.filePath = object2;
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).title = string2;
        ((WXMediaMessage)object2).description = string3;
        ((WXMediaMessage)object2).mediaObject = wXFileObject;
        object = this.a((Context)object, bitmap, false);
        ((WXMediaMessage)object2).thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "filedata", n10, k10);
    }

    private void c(Context object, String string2, String string3, String object2, String string4, int n10, k k10) {
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.filePath = object2;
        object2 = new WXMediaMessage();
        ((WXMediaMessage)object2).title = string2;
        ((WXMediaMessage)object2).description = string3;
        ((WXMediaMessage)object2).mediaObject = wXFileObject;
        object = this.a((Context)object, string4, false);
        ((WXMediaMessage)object2).thumbData = (byte[])object;
        this.a((WXMediaMessage)object2, "filedata", n10, k10);
    }

    private byte[] d(String object) {
        FileInputStream fileInputStream = new FileInputStream((String)object);
        object = new ByteArrayOutputStream();
        int n10 = 1024;
        byte[] byArray = new byte[n10];
        int n11 = fileInputStream.read(byArray);
        while (n11 > 0) {
            ((ByteArrayOutputStream)object).write(byArray, 0, n11);
            n11 = fileInputStream.read(byArray);
        }
        try {
            ((OutputStream)object).flush();
            fileInputStream.close();
            ((ByteArrayOutputStream)object).close();
            return ((ByteArrayOutputStream)object).toByteArray();
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            return null;
        }
    }

    public String a(File file) {
        boolean bl2;
        Context context = null;
        if (file != null && (bl2 = file.exists())) {
            Object object;
            Object object2 = MobSDK.getContext();
            try {
                object2 = object2.getPackageName();
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                Object[] objectArray = new StringBuilder();
                String string2 = "get packagename is catch: ";
                objectArray.append(string2);
                objectArray.append(throwable);
                object2 = objectArray.toString();
                objectArray = new Object[]{};
                ((NLog)object).d(object2, objectArray);
                bl2 = false;
                object2 = null;
            }
            if (object2 != null) {
                context = MobSDK.getContext();
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(".cn.sharesdk.ShareSDKFileProvider");
                object2 = ((StringBuilder)object).toString();
                file = ShareSDKFileProvider.a(context, (String)object2, file);
                MobSDK.getContext().grantUriPermission("com.tencent.mm", (Uri)file, 1);
                return file.toString();
            }
        }
        return null;
    }

    public void a(int n10) {
        this.g = n10;
    }

    public void a(k object) {
        this.c = object;
        object = new a();
        ((a)object).a = "snsapi_userinfo";
        ((a)object).b = "sharesdk_wechat_auth";
        this.b.a((m)object, false);
    }

    public void a(k object, Platform$ShareParams platform$ShareParams, PlatformActionListener platformActionListener) {
        int n10;
        object = ((k)object).b();
        Object object2 = "scene";
        Object object3 = (Integer)platform$ShareParams.get((String)object2, Integer.class);
        int n11 = (Integer)object3;
        object3 = n11 == (n10 = 1) ? "com.tencent.mm.ui.tools.ShareToTimeLineUI" : "com.tencent.mm.ui.tools.ShareImgUI";
        object2 = new f();
        ((f)object2).a("com.tencent.mm", (String)object3);
        ((f)object2).a(platform$ShareParams, (Platform)object);
        object3 = new Object();
        ((HashMap)object3).put("ShareParams", platform$ShareParams);
        platformActionListener.onComplete((Platform)object, 9, (HashMap)object3);
    }

    public void a(String string2) {
        this.e = string2;
    }

    public void a(boolean bl2) {
        this.f = bl2;
    }

    public boolean a(WechatHandlerActivity wechatHandlerActivity) {
        j j10 = this.b;
        k k10 = this.c;
        return j10.a(wechatHandlerActivity, k10);
    }

    public void b(k object) {
        this.c = object;
        g g10 = new g();
        object = ((k)object).a();
        String string2 = String.valueOf(((InnerShareParams)object).getWxTemplateid());
        String string3 = String.valueOf(((InnerShareParams)object).getWxReserved());
        int n10 = ((InnerShareParams)object).getScence();
        g10.b = string2;
        g10.a = n10;
        g10.c = string3;
        this.b.a(g10);
    }

    public void b(String string2) {
        this.d = string2;
    }

    public boolean b() {
        return this.b.a();
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public void c(k k10) {
        int n10;
        int n11;
        l l10 = this;
        Object object = k10.b();
        Object object2 = k10.a();
        PlatformActionListener platformActionListener = k10.c();
        int n12 = ((InnerShareParams)object2).getShareType();
        if (n12 == (n11 = 11) && (n11 = this.e()) < (n10 = 620756993)) {
            n12 = 4;
        }
        Object object3 = ((InnerShareParams)object2).getTitle();
        String string2 = ((InnerShareParams)object2).getText();
        int n13 = ((InnerShareParams)object2).getScence();
        Object object4 = ((InnerShareParams)object2).getImagePath();
        Object object5 = ((InnerShareParams)object2).getImageFileProviderPath();
        String string3 = ((InnerShareParams)object2).getImageUrl();
        Bitmap bitmap = ((InnerShareParams)object2).getImageData();
        CharSequence charSequence = ((InnerShareParams)object2).getMusicUrl();
        Object object6 = ((InnerShareParams)object2).getUrl();
        String string4 = ((InnerShareParams)object2).getFilePath();
        String string5 = ((InnerShareParams)object2).getExtInfo();
        object2 = "checkArgs fail, UserName or Path is invalid";
        String string6 = object5;
        n10 = 0;
        object5 = null;
        switch (n12) {
            default: {
                if (platformActionListener == null) break;
                charSequence = new StringBuilder();
                object5 = "shareType = ";
                ((StringBuilder)charSequence).append((String)object5);
                ((StringBuilder)charSequence).append(n12);
                String string7 = ((StringBuilder)charSequence).toString();
                object2 = new IllegalArgumentException(string7);
                n12 = 9;
                platformActionListener.onError((Platform)object, n12, (Throwable)object2);
                break;
            }
            case 12: {
                Object object7 = l10.d;
                n12 = (int)(TextUtils.isEmpty((CharSequence)object7) ? 1 : 0);
                if (n12 == 0 && (n12 = (int)(TextUtils.isEmpty((CharSequence)(object7 = l10.e)) ? 1 : 0)) == 0) {
                    object = l10.d;
                    object2 = l10.e;
                    l10.a((String)object, (String)object2);
                    break;
                }
                object7 = new Throwable((String)object2);
                n11 = 9;
                platformActionListener.onError((Platform)object, n11, (Throwable)object7);
                break;
            }
            case 11: {
                n12 = 1;
                n11 = 9;
                if (n13 != n12) {
                    n12 = 2;
                    if (n13 != n12) {
                        int n14;
                        Object object8 = l10.d;
                        n12 = (int)(TextUtils.isEmpty((CharSequence)object8) ? 1 : 0);
                        if (n12 != 0) {
                            object8 = new Throwable((String)object2);
                            platformActionListener.onError((Platform)object, n11, (Throwable)object8);
                            return;
                        }
                        object8 = object.getShortLintk((String)object6, false);
                        object = k10.a();
                        object.setUrl((String)object8);
                        if (object4 != null && (n14 = ((String)object4).length()) > 0) {
                            Context context = MobSDK.getContext();
                            charSequence = l10.d;
                            object5 = l10.e;
                            object2 = this;
                            k k11 = k10;
                            this.a(context, (String)object8, (String)charSequence, (String)object5, (String)object3, string2, (String)object4, n13, k10);
                            break;
                        }
                        if (bitmap != null && (n14 = (int)(bitmap.isRecycled() ? 1 : 0)) == 0) {
                            Context context = MobSDK.getContext();
                            charSequence = l10.d;
                            object5 = l10.e;
                            object2 = this;
                            object4 = bitmap;
                            k k12 = k10;
                            this.a(context, (String)object8, (String)charSequence, (String)object5, (String)object3, string2, (Bitmap)object4, n13, k10);
                            break;
                        }
                        if (string3 != null && (n14 = string3.length()) > 0) {
                            object = MobSDK.getContext();
                            object4 = BitmapHelper.downloadBitmap((Context)object, (String)string3);
                            Context context = MobSDK.getContext();
                            charSequence = l10.d;
                            object5 = l10.e;
                            object2 = this;
                            k k13 = k10;
                            this.a(context, (String)object8, (String)charSequence, (String)object5, (String)object3, string2, (String)object4, n13, k10);
                            break;
                        }
                        Context context = MobSDK.getContext();
                        charSequence = l10.d;
                        object5 = l10.e;
                        object4 = "";
                        object2 = this;
                        k k14 = k10;
                        this.a(context, (String)object8, (String)charSequence, (String)object5, (String)object3, string2, (String)object4, n13, k10);
                        break;
                    }
                    object = new Throwable("WechatFavorite does not support SAHRE_WXMINIPROGRAM");
                    throw object;
                }
                object = new Throwable("WechatMoments does not support SAHRE_WXMINIPROGRAM");
                throw object;
            }
            case 9: {
                int n15 = 1;
                if (n13 != n15) {
                    n15 = 2;
                    if (n13 != n15) {
                        if (object4 != null && (n15 = ((String)object4).length()) > 0) {
                            Context context = MobSDK.getContext();
                            object2 = this;
                            String string8 = object3;
                            charSequence = string2;
                            object5 = object4;
                            k k15 = k10;
                            this.c(context, (String)object3, (String)charSequence, (String)object4, n13, k10);
                            break;
                        }
                        if (string3 != null && (n15 = string3.length()) > 0) {
                            object6 = new NetworkHelper();
                            string4 = MobSDK.getContext();
                            boolean bl2 = true;
                            string5 = "images";
                            object5 = ((NetworkHelper)object6).downloadCache((Context)string4, string3, string5, bl2, null);
                            Context context = MobSDK.getContext();
                            object2 = this;
                            Object object9 = object3;
                            charSequence = string2;
                            k k16 = k10;
                            this.c(context, (String)object3, (String)charSequence, (String)object5, n13, k10);
                            break;
                        }
                        if (bitmap != null && (n15 = (int)(bitmap.isRecycled() ? 1 : 0)) == 0) {
                            Context context = MobSDK.getContext();
                            object2 = this;
                            Object object10 = object3;
                            charSequence = string2;
                            object5 = bitmap;
                            k k17 = k10;
                            this.b(context, (String)object3, (String)charSequence, bitmap, n13, k10);
                            break;
                        }
                        Context context = MobSDK.getContext();
                        object5 = "";
                        object2 = this;
                        String string9 = object3;
                        charSequence = string2;
                        k k18 = k10;
                        this.c(context, (String)object3, (String)charSequence, (String)object5, n13, k10);
                        break;
                    }
                    object = new Throwable("WechatFavorite does not support SHARE_EMOJI");
                    throw object;
                }
                object = new Throwable("WechatMoments does not support SHARE_EMOJI");
                throw object;
            }
            case 8: {
                int n16 = 1;
                if (n13 != n16) {
                    if (object4 != null && (n16 = ((String)object4).length()) > 0) {
                        Context context = MobSDK.getContext();
                        object2 = this;
                        String string10 = object3;
                        charSequence = string2;
                        object5 = string4;
                        object3 = object4;
                        object4 = k10;
                        this.c(context, string10, string2, string4, (String)object3, n13, k10);
                        break;
                    }
                    if (bitmap != null && (n16 = (int)(bitmap.isRecycled() ? 1 : 0)) == 0) {
                        Context context = MobSDK.getContext();
                        object2 = this;
                        String string11 = object3;
                        charSequence = string2;
                        object5 = string4;
                        object3 = bitmap;
                        object4 = k10;
                        this.c(context, string11, string2, string4, bitmap, n13, k10);
                        break;
                    }
                    if (string3 != null && (n16 = string3.length()) > 0) {
                        object = BitmapHelper.downloadBitmap((Context)MobSDK.getContext(), (String)string3);
                        Context context = MobSDK.getContext();
                        object2 = this;
                        String string12 = object3;
                        charSequence = string2;
                        object5 = string4;
                        object3 = object;
                        object4 = k10;
                        this.c(context, string12, string2, string4, (String)object, n13, k10);
                        break;
                    }
                    Context context = MobSDK.getContext();
                    object = "";
                    object2 = this;
                    String string13 = object3;
                    charSequence = string2;
                    object5 = string4;
                    object3 = object;
                    object4 = k10;
                    this.c(context, string13, string2, string4, (String)object, n13, k10);
                    break;
                }
                object = new Throwable("WechatMoments does not support SHARE_FILE");
                throw object;
            }
            case 7: {
                int n17 = 1;
                if (n13 != n17) {
                    n17 = 2;
                    if (n13 != n17) {
                        if (object4 != null && (n17 = ((String)object4).length()) > 0) {
                            Context context = MobSDK.getContext();
                            object2 = this;
                            String string14 = object3;
                            charSequence = string2;
                            object5 = string4;
                            object3 = string5;
                            Object object11 = object4;
                            this.b(context, string14, (String)charSequence, string4, string5, (String)object4, n13, k10);
                            break;
                        }
                        if (bitmap != null && (n17 = (int)(bitmap.isRecycled() ? 1 : 0)) == 0) {
                            Context context = MobSDK.getContext();
                            object2 = this;
                            String string15 = object3;
                            charSequence = string2;
                            object5 = string4;
                            object3 = string5;
                            Bitmap bitmap2 = bitmap;
                            this.b(context, string15, (String)charSequence, string4, string5, bitmap, n13, k10);
                            break;
                        }
                        if (string3 != null && (n17 = string3.length()) > 0) {
                            object = BitmapHelper.downloadBitmap((Context)MobSDK.getContext(), (String)string3);
                            Context context = MobSDK.getContext();
                            object2 = this;
                            Object object12 = object3;
                            charSequence = string2;
                            object5 = string4;
                            object3 = string5;
                            String[] stringArray = object;
                            this.b(context, (String)object12, (String)charSequence, string4, string5, (String)object, n13, k10);
                            break;
                        }
                        Context context = MobSDK.getContext();
                        object = "";
                        object2 = this;
                        String string16 = object3;
                        charSequence = string2;
                        object5 = string4;
                        object3 = string5;
                        String[] stringArray = object;
                        this.b(context, string16, (String)charSequence, string4, string5, (String)object, n13, k10);
                        break;
                    }
                    object = new Throwable("WechatFavorite does not support SAHRE_APP");
                    throw object;
                }
                object = new Throwable("WechatMoments does not support SAHRE_APP");
                throw object;
            }
            case 6: {
                int n18;
                object5 = object.getShortLintk((String)object6, false);
                object = k10.a();
                object.setUrl((String)object5);
                if (object4 != null && (n18 = ((String)object4).length()) > 0) {
                    Context context = MobSDK.getContext();
                    object2 = this;
                    String string17 = object3;
                    charSequence = string2;
                    object3 = object4;
                    object4 = k10;
                    this.a(context, string17, string2, (String)object5, (String)object3, n13, k10);
                    break;
                }
                if (bitmap != null && (n18 = (int)(bitmap.isRecycled() ? 1 : 0)) == 0) {
                    Context context = MobSDK.getContext();
                    object2 = this;
                    Object object13 = object3;
                    charSequence = string2;
                    object3 = bitmap;
                    object4 = k10;
                    this.a(context, (String)object13, string2, (String)object5, bitmap, n13, k10);
                    break;
                }
                if (string3 != null && (n18 = string3.length()) > 0) {
                    object = BitmapHelper.downloadBitmap((Context)MobSDK.getContext(), (String)string3);
                    Context context = MobSDK.getContext();
                    object2 = this;
                    Object object14 = object3;
                    charSequence = string2;
                    object3 = object;
                    object4 = k10;
                    this.a(context, (String)object14, string2, (String)object5, (String)object, n13, k10);
                    break;
                }
                Context context = MobSDK.getContext();
                object = "";
                object2 = this;
                String string18 = object3;
                charSequence = string2;
                object3 = object;
                object4 = k10;
                this.a(context, string18, string2, (String)object5, (String)object, n13, k10);
                break;
            }
            case 5: {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)charSequence);
                String string19 = " ";
                ((StringBuilder)object2).append(string19);
                ((StringBuilder)object2).append((String)object6);
                object2 = ((StringBuilder)object2).toString();
                object = object.getShortLintk((String)object2, false);
                object2 = object.split(string19);
                object5 = object2[0];
                object = object.split(string19);
                int n19 = 1;
                object = object[n19];
                if (object4 != null && (n19 = ((String)object4).length()) > 0) {
                    Context context = MobSDK.getContext();
                    object2 = this;
                    Object object15 = object3;
                    charSequence = string2;
                    object3 = object;
                    Object object16 = object4;
                    this.a(context, (String)object15, (String)charSequence, (String)object5, (String)object, (String)object4, n13, k10);
                    break;
                }
                if (bitmap != null && (n19 = (int)(bitmap.isRecycled() ? 1 : 0)) == 0) {
                    Context context = MobSDK.getContext();
                    object2 = this;
                    Object object17 = object3;
                    charSequence = string2;
                    object3 = object;
                    Bitmap bitmap3 = bitmap;
                    this.a(context, (String)object17, (String)charSequence, (String)object5, (String)object, bitmap, n13, k10);
                    break;
                }
                if (string3 != null && (n19 = string3.length()) > 0) {
                    object4 = BitmapHelper.downloadBitmap((Context)MobSDK.getContext(), (String)string3);
                    Context context = MobSDK.getContext();
                    object2 = this;
                    Object object18 = object3;
                    charSequence = string2;
                    object3 = object;
                    Object object19 = object4;
                    this.a(context, (String)object18, (String)charSequence, (String)object5, (String)object, (String)object4, n13, k10);
                    break;
                }
                Context context = MobSDK.getContext();
                object4 = "";
                object2 = this;
                Object object20 = object3;
                charSequence = string2;
                object3 = object;
                Object object21 = object4;
                this.a(context, (String)object20, (String)charSequence, (String)object5, (String)object, (String)object4, n13, k10);
                break;
            }
            case 4: {
                int n20;
                object5 = object.getShortLintk((String)object6, false);
                object = k10.a();
                object.setUrl((String)object5);
                if (object4 != null && (n20 = ((String)object4).length()) > 0) {
                    Context context = MobSDK.getContext();
                    object2 = this;
                    String string20 = object3;
                    charSequence = string2;
                    object3 = object4;
                    object4 = k10;
                    this.b(context, string20, string2, (String)object5, (String)object3, n13, k10);
                    break;
                }
                if (bitmap != null && (n20 = (int)(bitmap.isRecycled() ? 1 : 0)) == 0) {
                    Context context = MobSDK.getContext();
                    object2 = this;
                    Object object22 = object3;
                    charSequence = string2;
                    object3 = bitmap;
                    object4 = k10;
                    this.b(context, (String)object22, string2, (String)object5, bitmap, n13, k10);
                    break;
                }
                if (string3 != null && (n20 = string3.length()) > 0) {
                    object = BitmapHelper.downloadBitmap((Context)MobSDK.getContext(), (String)string3);
                    Context context = MobSDK.getContext();
                    object2 = this;
                    Object object23 = object3;
                    charSequence = string2;
                    object3 = object;
                    object4 = k10;
                    this.b(context, (String)object23, string2, (String)object5, (String)object, n13, k10);
                    break;
                }
                Context context = MobSDK.getContext();
                object = "";
                object2 = this;
                String string21 = object3;
                charSequence = string2;
                object3 = object;
                object4 = k10;
                this.b(context, string21, string2, (String)object5, (String)object, n13, k10);
                break;
            }
            case 2: {
                int n21;
                if (object4 != null && (n21 = ((String)object4).length()) > 0) {
                    Context context = MobSDK.getContext();
                    object2 = this;
                    String string22 = object3;
                    charSequence = string2;
                    object5 = object4;
                    k k19 = k10;
                    this.b(context, (String)object3, (String)charSequence, (String)object4, n13, k10);
                    break;
                }
                if (string6 != null && (n21 = string6.length()) > 0) {
                    Context context = MobSDK.getContext();
                    object2 = this;
                    String string23 = object3;
                    charSequence = string2;
                    object5 = string6;
                    k k20 = k10;
                    this.a(context, (String)object3, (String)charSequence, string6, n13, k10);
                    break;
                }
                if (bitmap != null && (n21 = (int)(bitmap.isRecycled() ? 1 : 0)) == 0) {
                    Context context = MobSDK.getContext();
                    object2 = this;
                    String string24 = object3;
                    charSequence = string2;
                    object5 = bitmap;
                    k k21 = k10;
                    this.a(context, (String)object3, (String)charSequence, bitmap, n13, k10);
                    break;
                }
                if (string3 != null && (n21 = string3.length()) > 0) {
                    Object object24;
                    object = MobSDK.getContext();
                    object4 = BitmapHelper.downloadBitmap((Context)object, (String)string3);
                    try {
                        n21 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0);
                        if (n21 == 0) {
                            String string25;
                            boolean bl3;
                            object = new File((String)object4);
                            if ((object = object.getParentFile()) != null && (bl3 = object.isDirectory()) && ((n21 = (int)(((File)(object2 = new File((String)(object = object.getAbsolutePath()), string25 = ".nomedia"))).exists() ? 1 : 0)) == 0 || (n21 = (int)(((File)object2).isFile() ? 1 : 0)) == 0)) {
                                ((File)object2).createNewFile();
                            }
                        }
                    }
                    catch (Throwable throwable) {
                        object2 = SSDKLog.b();
                        StringBuilder stringBuilder = new StringBuilder();
                        object24 = "when share iamge wechat that create nomedia catch ";
                        stringBuilder.append((String)object24);
                        stringBuilder.append(throwable);
                        String string26 = stringBuilder.toString();
                        Object[] objectArray = new Object[]{};
                        ((NLog)object2).d(string26, objectArray);
                    }
                    Context context = MobSDK.getContext();
                    object2 = this;
                    object24 = object3;
                    charSequence = string2;
                    object5 = object4;
                    k k22 = k10;
                    this.b(context, (String)object3, (String)charSequence, (String)object4, n13, k10);
                    break;
                }
                Context context = MobSDK.getContext();
                object5 = "";
                object2 = this;
                String string27 = object3;
                charSequence = string2;
                k k23 = k10;
                this.b(context, (String)object3, (String)charSequence, (String)object5, n13, k10);
                break;
            }
            case 1: {
                object2 = k10;
                l10.a((String)object3, string2, n13, k10);
            }
        }
    }

    public boolean c() {
        return this.b.b();
    }

    public boolean c(String string2) {
        return this.b.a(string2);
    }

    public boolean d() {
        return this.b.c();
    }

    public final int e() {
        Wechat wechat = new Wechat();
        boolean bl2 = wechat.isClientValid();
        int n10 = 0;
        if (!bl2) {
            return 0;
        }
        wechat = MobSDK.getContext();
        wechat = wechat.getPackageManager();
        Object object = "com.tencent.mm";
        int n11 = 128;
        wechat = wechat.getApplicationInfo((String)object, n11);
        wechat = ((ApplicationInfo)wechat).metaData;
        object = "com.tencent.mm.BuildInfo.OPEN_SDK_VERSION";
        try {
            n10 = wechat.getInt((String)object, 0);
        }
        catch (Exception exception) {
            object = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "WechatHelper getWXAppSupportAPI() get from metaData failed : ";
            objectArray.append(string2);
            objectArray.append(exception);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            ((NLog)object).d(string3, objectArray);
        }
        return n10;
    }

    public boolean f() {
        int n10;
        Object object = MobSDK.getContext();
        object = object.getPackageManager();
        Object object2 = "com.tencent.mm";
        object = object.getPackageInfo((String)object2, 0);
        object = ((PackageInfo)object).versionName;
        object2 = SSDKLog.b();
        Object object3 = new StringBuilder();
        Object[] objectArray = "wechat versionName ==>> ";
        ((StringBuilder)object3).append((String)objectArray);
        ((StringBuilder)object3).append((String)object);
        object3 = ((StringBuilder)object3).toString();
        objectArray = new Object[]{};
        try {
            ((NLog)object2).i(object3, objectArray);
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(throwable);
            object = "0";
        }
        object = ((String)object).split("_")[0];
        object2 = "\\.";
        object = ((String)object).split((String)object2);
        int n11 = ((Object)object).length;
        object3 = new int[n11];
        objectArray = null;
        for (n10 = 0; n10 < n11; n10 += 1) {
            Object object4 = object[n10];
            int n12 = ResHelper.parseInt((String)object4);
            try {
                object3[n10] = n12;
                continue;
            }
            catch (Throwable throwable) {
                NLog nLog = SSDKLog.b();
                nLog.d(throwable);
                object3[n10] = false;
            }
        }
        Object object5 = 3;
        if (n11 >= object5) {
            object5 = object3[0];
            n11 = 7;
            n10 = 1;
            if (object5 == n11 && !(object5 = (Object)object3[n10]) && (object5 = (Object)object3[2]) >= (n11 = 13)) {
                return n10 != 0;
            }
            object5 = object3[0];
            n11 = 8;
            if (object5 >= n11) {
                return n10 != 0;
            }
        }
        return false;
    }

    public boolean g() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }
}

