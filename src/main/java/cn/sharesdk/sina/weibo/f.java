/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.LinearLayout
 *  com.mob.tools.utils.BitmapHelper
 */
package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.ResHelper;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import com.sina.weibo.sdk.share.WbShareCallback;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class f
extends FakeActivity
implements WbShareCallback {
    private IWBAPI a;
    private String b;
    private String c;
    private String d;
    private AuthorizeListener e;
    private Platform$ShareParams f;
    private long g = 0x200000L;

    public f(String string2, String string3, String string4, Platform$ShareParams platform$ShareParams, AuthorizeListener authorizeListener) {
        this.b = string2;
        this.c = string3;
        this.d = string4;
        this.f = platform$ShareParams;
        this.e = authorizeListener;
    }

    private Bitmap a(Bitmap bitmap, double d10) {
        int n10 = bitmap.getWidth();
        int n11 = bitmap.getHeight();
        d10 = Math.sqrt(d10);
        n10 = (int)((double)n10 / d10);
        int n12 = (int)((double)n11 / d10);
        return Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n10, (int)n12, (boolean)true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private WebpageObject a() {
        WebpageObject webpageObject = new WebpageObject();
        Object object = this.f.getTitle();
        webpageObject.title = object;
        object = this.f.getText();
        webpageObject.description = object;
        object = this.f.getUrl();
        webpageObject.actionUrl = object;
        object = this.f.getText();
        webpageObject.defaultText = object;
        try {
            object = this.f;
            object = ((InnerShareParams)object).getImageData();
            if (object != null) {
                object = this.activity;
                Platform$ShareParams platform$ShareParams = this.f;
                platform$ShareParams = platform$ShareParams.getImageData();
                object = this.a((Context)object, (Bitmap)platform$ShareParams);
                webpageObject.thumbData = (byte[])object;
                return webpageObject;
            }
            object = this.f;
            boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((InnerShareParams)object).getImagePath()));
            if (bl2) return webpageObject;
            object = this.activity;
            Object object2 = this.f;
            object2 = ((InnerShareParams)object2).getImagePath();
            object = this.a((Context)object, (String)object2);
            webpageObject.thumbData = (byte[])object;
            return webpageObject;
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "SinaWeiboShareOfficial getWebpageObj catch: ";
            objectArray.append(string2);
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            nLog.d(string3, objectArray);
            boolean bl3 = false;
            string3 = null;
            webpageObject.thumbData = null;
        }
        return webpageObject;
    }

    private byte[] a(Context object, Bitmap bitmap) {
        if (bitmap != null) {
            boolean bl2 = bitmap.isRecycled();
            if (!bl2) {
                return this.b((Context)object, bitmap);
            }
            object = new RuntimeException("checkArgs fail, thumbData is recycled");
            throw object;
        }
        object = new RuntimeException("checkArgs fail, thumbData is null");
        throw object;
    }

    private byte[] a(Context object, String string2) {
        File file = new File(string2);
        boolean bl2 = file.exists();
        if (bl2) {
            string2 = BitmapHelper.getBitmap((String)string2);
            return this.b((Context)object, (Bitmap)string2);
        }
        object = new FileNotFoundException();
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private MultiImageObject b() {
        MultiImageObject multiImageObject = new MultiImageObject();
        try {
            Object object = this.f;
            object = ((InnerShareParams)object).getImageArray();
            object = Arrays.asList(object);
            ArrayList arrayList = new ArrayList();
            object = object.iterator();
            while (true) {
                int n10;
                if ((n10 = object.hasNext()) == 0) {
                    multiImageObject.imageList = arrayList;
                    return multiImageObject;
                }
                Object object2 = object.next();
                File file = new File((String)(object2 = (String)object2));
                n10 = file.exists();
                if (n10 == 0) continue;
                n10 = Build.VERSION.SDK_INT;
                int n11 = 24;
                if (n10 >= n11) {
                    object2 = MobSDK.getContext();
                    StringBuilder stringBuilder = new StringBuilder();
                    Context context = MobSDK.getContext();
                    String string2 = context.getPackageName();
                    stringBuilder.append(string2);
                    String string3 = ".cn.sharesdk.ShareSDKFileProvider";
                    stringBuilder.append(string3);
                    String string4 = stringBuilder.toString();
                    object2 = ShareSDKFileProvider.a(object2, string4, file);
                    file = MobSDK.getContext();
                    String string5 = "com.sina.weibo";
                    int n12 = 3;
                    file.grantUriPermission(string5, (Uri)object2, n12);
                    arrayList.add(object2);
                    continue;
                }
                object2 = Uri.fromFile((File)file);
                arrayList.add(object2);
            }
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string6 = "SinaWeiboShareOfficial getMultiImageObject catch: ";
            objectArray.append(string6);
            objectArray.append(throwable);
            String string7 = objectArray.toString();
            boolean bl2 = false;
            objectArray = new Object[]{};
            nLog.d(string7, objectArray);
        }
        return multiImageObject;
    }

    private byte[] b(Context object, Bitmap bitmap) {
        if (bitmap != null) {
            boolean bl2 = bitmap.isRecycled();
            if (!bl2) {
                long l10;
                long l11;
                long l12;
                long l13;
                object = new ByteArrayOutputStream();
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                int n10 = 85;
                bitmap.compress(compressFormat, n10, (OutputStream)object);
                object.flush();
                object.close();
                object = object.toByteArray();
                int n11 = ((Context)object).length;
                while ((l13 = (l12 = (l11 = (long)n11) - (l10 = this.g)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                    double d10 = n11;
                    double d11 = l10;
                    bitmap = this.a(bitmap, d10 /= d11);
                    object = new ByteArrayOutputStream();
                    compressFormat = Bitmap.CompressFormat.JPEG;
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

    /*
     * Loose catch block
     * Could not resolve type clashes
     */
    private VideoSourceObject c() {
        String string2;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object[] objectArray;
        VideoSourceObject videoSourceObject;
        block30: {
            block31: {
                block29: {
                    videoSourceObject = new VideoSourceObject();
                    objectArray = null;
                    object4 = this.f;
                    object4 = ((InnerShareParams)object4).getFilePath();
                    boolean bl2 = TextUtils.isEmpty((CharSequence)object4);
                    object3 = null;
                    if (!bl2) break block29;
                    object4 = SSDKLog.b();
                    object2 = "SinaWeiboShareOfficial getVideoSourceObject filePath is null ";
                    object = new Object[]{};
                    ((NLog)object4).d(object2, object);
                    return null;
                }
                object2 = new File((String)object4);
                int n10 = ((File)object2).exists();
                if (n10 == 0) break block30;
                n10 = Build.VERSION.SDK_INT;
                int n11 = 24;
                if (n10 < n11) break block31;
                object4 = MobSDK.getContext();
                object = new StringBuilder();
                string2 = MobSDK.getContext();
                string2 = string2.getPackageName();
                object.append(string2);
                string2 = ".cn.sharesdk.ShareSDKFileProvider";
                object.append(string2);
                object = object.toString();
                object4 = ShareSDKFileProvider.a((Context)object4, (String)object, (File)object2);
                object2 = MobSDK.getContext();
                object = "com.sina.weibo";
                int n12 = 3;
                object2.grantUriPermission((String)object, (Uri)object4, n12);
                object3 = object4;
                break block30;
            }
            object3 = Uri.fromFile((File)object2);
        }
        videoSourceObject.videoPath = object3;
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            object = new StringBuilder();
            string2 = "SinaWeiboShareOfficial getVideoSourceObject copyFile catch: ";
            object.append(string2);
            object.append(throwable);
            object4 = object.toString();
            object = new Object[]{};
            try {
                ((NLog)object2).d(object4, object);
                return null;
            }
            catch (Throwable throwable2) {
                object2 = SSDKLog.b();
                object3 = new StringBuilder();
                object = "SinaWeiboShareOfficial getVideoSourceObject catch: ";
                ((StringBuilder)object3).append((String)object);
                ((StringBuilder)object3).append(throwable2);
                String string3 = ((StringBuilder)object3).toString();
                objectArray = new Object[]{};
                ((NLog)object2).d(string3, objectArray);
            }
        }
        return videoSourceObject;
    }

    private ImageObject d() {
        ImageObject imageObject = new ImageObject();
        Object object = this.activity;
        Object object2 = this.f;
        object2 = ((InnerShareParams)object2).getImageData();
        object = this.a((Context)object, (Bitmap)object2);
        try {
            imageObject.imageData = (byte[])object;
        }
        catch (Throwable throwable) {
            object2 = SSDKLog.b();
            Object[] objectArray = new StringBuilder();
            String string2 = "SinaWeiboShareOfficial getImageObj catch: ";
            objectArray.append(string2);
            objectArray.append(throwable);
            String string3 = objectArray.toString();
            objectArray = new Object[]{};
            ((NLog)object2).d(string3, objectArray);
        }
        return imageObject;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private MultiImageObject e() {
        MultiImageObject multiImageObject = new MultiImageObject();
        int n10 = 1;
        Object[] objectArray = null;
        try {
            Object object = new String[n10];
            ArrayList<Object> arrayList = this.f;
            arrayList = ((InnerShareParams)((Object)arrayList)).getImagePath();
            object[0] = arrayList;
            object = Arrays.asList(object);
            arrayList = new ArrayList<Object>();
            object = object.iterator();
            while (true) {
                int n11;
                if ((n11 = object.hasNext()) == 0) {
                    multiImageObject.imageList = arrayList;
                    return multiImageObject;
                }
                Object object2 = object.next();
                Object object3 = new File((String)(object2 = (String)object2));
                n11 = ((File)object3).exists();
                if (n11 == 0) continue;
                n11 = Build.VERSION.SDK_INT;
                int n12 = 24;
                if (n11 >= n12) {
                    StringBuilder stringBuilder = new StringBuilder();
                    Object object4 = MobSDK.getContext();
                    object4 = object4.getExternalFilesDir(null);
                    object4 = ((File)object4).getPath();
                    stringBuilder.append((String)object4);
                    object4 = "/";
                    stringBuilder.append((String)object4);
                    object4 = ((File)object3).getName();
                    stringBuilder.append((String)object4);
                    String string2 = stringBuilder.toString();
                    object2 = new File(string2);
                    String string3 = ((File)object3).getPath();
                    object2 = ((File)object2).getPath();
                    n11 = (int)(ResHelper.copyFile(string3, (String)object2) ? 1 : 0);
                    if (n11 != 0) {
                        object2 = MobSDK.getContext();
                        StringBuilder stringBuilder2 = new StringBuilder();
                        object4 = MobSDK.getContext();
                        object4 = object4.getPackageName();
                        stringBuilder2.append((String)object4);
                        object4 = ".cn.sharesdk.ShareSDKFileProvider";
                        stringBuilder2.append((String)object4);
                        String string4 = stringBuilder2.toString();
                        object2 = ShareSDKFileProvider.a((Context)object2, string4, (File)object3);
                        object3 = MobSDK.getContext();
                        String string5 = "com.sina.weibo";
                        int n13 = 3;
                        object3.grantUriPermission(string5, (Uri)object2, n13);
                        arrayList.add(object2);
                        continue;
                    }
                    object2 = SSDKLog.b();
                    object3 = "QQQ";
                    Object[] objectArray2 = new Object[n10];
                    objectArray2[0] = object4 = " SinaWeiboShareOfficial copy failed ";
                    ((NLog)object2).d(object3, objectArray2);
                    continue;
                }
                object2 = Uri.fromFile((File)object3);
                arrayList.add(object2);
            }
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            StringBuilder stringBuilder = new StringBuilder();
            String string6 = "SinaWeiboShareOfficial getOneImage catch: ";
            stringBuilder.append(string6);
            stringBuilder.append(throwable);
            String string7 = stringBuilder.toString();
            objectArray = new Object[]{};
            nLog.d(string7, objectArray);
            multiImageObject.imageList = null;
        }
        return multiImageObject;
    }

    private void f() {
        Object object;
        Object object2 = new WeiboMultiMessage();
        Object object3 = this.f.getText();
        int n10 = TextUtils.isEmpty((CharSequence)object3);
        if (n10 == 0) {
            object3 = new TextObject();
            object = this.f.getText();
            ((TextObject)object3).text = object;
            ((WeiboMultiMessage)object2).textObject = object3;
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object3 = this.f.getUrl()))) == 0) {
            object3 = this.a();
            ((WeiboMultiMessage)object2).mediaObject = object3;
        } else {
            object3 = this.f.getImageArray();
            if (object3 != null && (n10 = ((String[])(object3 = this.f.getImageArray())).length) > 0) {
                object3 = this.b();
                ((WeiboMultiMessage)object2).multiImageObject = object3;
            } else {
                object3 = this.f.getFilePath();
                n10 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                if (n10 == 0) {
                    object3 = this.c();
                    if (object3 != null) {
                        object3 = this.c();
                        ((WeiboMultiMessage)object2).videoSourceObject = object3;
                    }
                } else {
                    object3 = this.f.getImageData();
                    if (object3 != null || (n10 = (int)(TextUtils.isEmpty((CharSequence)(object3 = this.f.getImagePath())) ? 1 : 0)) == 0) {
                        object3 = this.f.getImageData();
                        if (object3 != null) {
                            object3 = this.d();
                            ((WeiboMultiMessage)object2).imageObject = object3;
                        } else {
                            object3 = this.f.getImagePath();
                            n10 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                            if (n10 == 0) {
                                object3 = this.e();
                                ((WeiboMultiMessage)object2).multiImageObject = object3;
                            }
                        }
                    }
                }
            }
        }
        object3 = this.a;
        if (object3 != null) {
            boolean bl2 = true;
            try {
                object3.shareMessage((WeiboMultiMessage)object2, bl2);
            }
            catch (Throwable throwable) {
                CharSequence charSequence;
                object3 = this.e;
                if (object3 != null) {
                    charSequence = new StringBuilder();
                    String string2 = "Share to sina failed: ";
                    ((StringBuilder)charSequence).append(string2);
                    ((StringBuilder)charSequence).append(throwable);
                    charSequence = ((StringBuilder)charSequence).toString();
                    object = new Throwable((String)charSequence);
                    object3.onError((Throwable)object);
                }
                object3 = SSDKLog.b();
                object = new StringBuilder();
                charSequence = "SinaWeiboShareOfficial share catch: ";
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append(throwable);
                String string3 = ((StringBuilder)object).toString();
                ((NLog)object3).w(string3);
                this.finish();
            }
        } else {
            object2 = this.e;
            if (object2 != null) {
                object = "SinaWeibo SDK init failed";
                object3 = new Throwable((String)object);
                object2.onError((Throwable)object3);
            }
            this.finish();
        }
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        Object object = this.a;
        if (object != null) {
            object.doResultIntent(intent, this);
        } else {
            object = SSDKLog.b();
            String string2 = "SinaWeiboShareOfficial onActivityResult iwbapi is null";
            ((NLog)object).w(string2);
        }
        super.onActivityResult(n10, n11, intent);
        SSDKLog.b().w("SinaWeiboShareOfficial onActivityResult");
    }

    public void onCancel() {
        AuthorizeListener authorizeListener = this.e;
        if (authorizeListener != null) {
            authorizeListener.onCancel();
        }
        SSDKLog.b().w("SinaWeiboShareOfficial doShare onCancel");
        this.finish();
    }

    public void onComplete() {
        AuthorizeListener authorizeListener = this.e;
        if (authorizeListener != null) {
            authorizeListener.onComplete(null);
        }
        SSDKLog.b().w("SinaWeiboShareOfficial doShare onComplete ");
        this.finish();
    }

    public void onCreate() {
        CharSequence charSequence;
        Object object;
        super.onCreate();
        int n10 = 1;
        Object object2 = this.activity;
        Object object3 = new LinearLayout((Context)object2);
        object3.setOrientation(n10);
        object2 = this.activity;
        try {
            object2.setContentView((View)object3);
        }
        catch (Exception exception) {
            object2 = SSDKLog.b();
            ((NLog)object2).d(exception);
        }
        try {
            object2 = this.activity;
        }
        catch (Throwable throwable) {
            object2 = this.e;
            if (object2 != null) {
                object = new StringBuilder();
                charSequence = "sinaweibo sdk init failed: ";
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append(throwable);
                object = ((StringBuilder)object).toString();
                object2 = new Throwable((String)object);
                object = this.e;
                object.onError((Throwable)object2);
            }
            object2 = SSDKLog.b();
            Object[] objectArray = new Object[n10];
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("onCreate AuthInfo ");
            ((StringBuilder)charSequence).append(throwable);
            String string2 = ((StringBuilder)charSequence).toString();
            objectArray[0] = string2;
            ((NLog)object2).d("SinaWeiboShareOfficial", objectArray);
            this.finish();
            return;
        }
        object = this.b;
        charSequence = this.c;
        String string3 = this.d;
        object3 = new AuthInfo((Context)object2, (String)object, (String)charSequence, string3);
        object2 = this.activity;
        object2 = WBAPIFactory.createWBAPI((Context)object2);
        this.a = object2;
        object = this.activity;
        object2.registerApp((Context)object, (AuthInfo)object3);
        this.f();
    }

    public void onDestroy() {
        super.onDestroy();
        SSDKLog.b().w("SinaWeiboShareOfficial doShare onDestroy");
    }

    public void onError(UiError object) {
        Object object2;
        Object object3 = this.e;
        if (object3 != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("errorCode: ");
            int n10 = ((UiError)object).errorCode;
            ((StringBuilder)object2).append(n10);
            ((StringBuilder)object2).append(" errorMessage: ");
            String string2 = ((UiError)object).errorMessage;
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(" errorDetail: ");
            string2 = ((UiError)object).errorDetail;
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            object3 = new Throwable((String)object2);
            object2 = this.e;
            object2.onError((Throwable)object3);
        }
        object3 = SSDKLog.b();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("SinaWeiboShareOfficial doShare onError: ");
        object = ((UiError)object).errorDetail;
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        ((NLog)object3).w((String)object);
        this.finish();
    }

    public void onPause() {
        super.onPause();
        SSDKLog.b().w("SinaWeiboShareOfficial doShare onPause");
    }

    public void onResume() {
        super.onResume();
        SSDKLog.b().w("SinaWeiboShareOfficial doShare onResume");
    }

    public void onStop() {
        super.onStop();
        SSDKLog.b().w("SinaWeiboShareOfficial doShare onStop");
    }
}

