/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.share;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.share.a;
import com.sina.weibo.sdk.share.b;
import com.sina.weibo.sdk.share.c;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d
extends AsyncTask {
    private WeakReference H;
    private b I;

    public d(Context context, b b10) {
        WeakReference<Context> weakReference;
        this.H = weakReference = new WeakReference<Context>(context);
        this.I = b10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private c a(WeiboMultiMessage ... object) {
        int n10 = Build.VERSION.SDK_INT;
        String string2 = "WBShareTag";
        Object object2 = (Context)this.H.get();
        Object object3 = null;
        if (object2 == null) {
            return null;
        }
        WeiboMultiMessage weiboMultiMessage = object[0];
        if (weiboMultiMessage == null) {
            return null;
        }
        String string3 = com.sina.weibo.sdk.c.a.c((Context)object2).packageName;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            string3 = "com.sina.weibo";
        }
        c c10 = new c();
        try {
            boolean bl3;
            MultiImageObject multiImageObject;
            ImageObject imageObject;
            VideoSourceObject videoSourceObject;
            MultiImageObject multiImageObject2;
            ImageObject imageObject2 = weiboMultiMessage.imageObject;
            if (imageObject2 != null && (multiImageObject2 = weiboMultiMessage.multiImageObject) != null) {
                weiboMultiMessage.imageObject = null;
            }
            if ((videoSourceObject = weiboMultiMessage.videoSourceObject) != null && ((imageObject = weiboMultiMessage.imageObject) != null || (multiImageObject = weiboMultiMessage.multiImageObject) != null)) {
                weiboMultiMessage.imageObject = null;
                weiboMultiMessage.multiImageObject = null;
            }
            object3 = weiboMultiMessage.multiImageObject;
            int n11 = 24;
            int n12 = 1;
            if (object3 != null) {
                boolean bl4;
                object3 = new ArrayList();
                Object object4 = weiboMultiMessage.multiImageObject;
                object4 = ((MultiImageObject)object4).getImageList();
                object4 = ((ArrayList)object4).iterator();
                while (bl4 = object4.hasNext()) {
                    boolean bl5;
                    Object e10 = object4.next();
                    Uri uri = (Uri)e10;
                    if (uri == null || !(bl5 = com.sina.weibo.sdk.c.b.a((Context)object2, uri))) continue;
                    if (n10 >= n11) {
                        ((ArrayList)object3).add(uri);
                        object2.grantUriPermission(string3, uri, n12);
                        continue;
                    }
                    String string4 = a.a((Context)object2, uri, n12);
                    bl5 = TextUtils.isEmpty((CharSequence)string4);
                    if (bl5) {
                        String string5 = "image's path is null";
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string5);
                        throw illegalArgumentException;
                    }
                    File file = new File(string4);
                    Uri uri2 = Uri.fromFile((File)file);
                    ((ArrayList)object3).add(uri2);
                }
                object4 = weiboMultiMessage.multiImageObject;
                ((MultiImageObject)object4).imageList = object3;
            }
            if ((object3 = weiboMultiMessage.videoSourceObject) != null && (object3 = ((VideoSourceObject)object3).videoPath) != null && (bl3 = com.sina.weibo.sdk.c.b.b((Context)object2, (Uri)object3))) {
                if (n10 >= n11) {
                    long l10;
                    VideoSourceObject videoSourceObject2 = weiboMultiMessage.videoSourceObject;
                    videoSourceObject2.videoPath = object3;
                    object3 = com.sina.weibo.sdk.c.b.d((Context)object2, (Uri)object3);
                    videoSourceObject2.during = l10 = com.sina.weibo.sdk.c.b.e((String)object3);
                    videoSourceObject2 = weiboMultiMessage.videoSourceObject;
                    videoSourceObject2 = videoSourceObject2.videoPath;
                    object2.grantUriPermission(string3, (Uri)videoSourceObject2, n12);
                } else {
                    long l11;
                    String string6 = a.a((Context)object2, (Uri)object3, 0);
                    object3 = "prepare video resource and video'path is";
                    object2 = new StringBuilder((String)object3);
                    ((StringBuilder)object2).append(string6);
                    object2 = ((StringBuilder)object2).toString();
                    com.sina.weibo.sdk.c.c.a(string2, (String)object2);
                    boolean bl6 = TextUtils.isEmpty((CharSequence)string6);
                    if (bl6) {
                        string6 = "video's path is null";
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string6);
                        throw illegalArgumentException;
                    }
                    object2 = weiboMultiMessage.videoSourceObject;
                    object3 = new File(string6);
                    object3 = Uri.fromFile((File)object3);
                    ((VideoSourceObject)object2).videoPath = object3;
                    object2 = weiboMultiMessage.videoSourceObject;
                    ((VideoSourceObject)object2).during = l11 = com.sina.weibo.sdk.c.b.e(string6);
                }
            }
            c10.F = weiboMultiMessage;
            c10.E = n12;
            return c10;
        }
        catch (Throwable throwable) {
            c10.E = false;
            String string7 = throwable.getMessage();
            boolean bl7 = TextUtils.isEmpty((CharSequence)string7);
            if (bl7) {
                string7 = throwable.toString();
            }
            c10.errorMessage = string7;
            object2 = "prepare resource error is :";
            StringBuilder stringBuilder = new StringBuilder((String)object2);
            stringBuilder.append(string7);
            String string8 = stringBuilder.toString();
            com.sina.weibo.sdk.c.c.b(string2, string8);
        }
        return c10;
    }

    public final /* synthetic */ Object doInBackground(Object[] objectArray) {
        objectArray = (WeiboMultiMessage[])objectArray;
        return this.a((WeiboMultiMessage[])objectArray);
    }

    public final /* synthetic */ void onPostExecute(Object object) {
        object = (c)object;
        super.onPostExecute(object);
        b b10 = this.I;
        if (b10 != null) {
            b10.a((c)object);
        }
    }

    public final void onPreExecute() {
        super.onPreExecute();
    }
}

