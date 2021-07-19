/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.share;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.sina.weibo.sdk.a;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.share.b;
import com.sina.weibo.sdk.share.c;
import java.lang.ref.WeakReference;

public final class e
extends AsyncTask {
    private WeakReference H;
    private b I;

    public e(Context context, b b10) {
        WeakReference<Context> weakReference;
        this.H = weakReference = new WeakReference<Context>(context);
        this.I = b10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private c a(StoryMessage ... object) {
        Context context = (Context)this.H.get();
        c c10 = null;
        if (context == null) {
            return null;
        }
        if ((object = object[0]) == null) {
            return null;
        }
        c10 = new c();
        try {
            boolean bl2;
            Uri uri = ((StoryMessage)object).getImageUri();
            int n10 = 1;
            if (uri != null && (bl2 = com.sina.weibo.sdk.c.b.a(context, uri))) {
                StoryObject storyObject;
                c10.G = storyObject = e.b(context, uri, n10);
                c10.E = n10;
            }
            if ((object = ((StoryMessage)object).getVideoUri()) == null) return c10;
            boolean bl3 = com.sina.weibo.sdk.c.b.b(context, (Uri)object);
            if (!bl3) return c10;
            c10.G = object = e.b(context, (Uri)object, 0);
            c10.E = n10;
            return c10;
        }
        catch (Throwable throwable) {
            String string2;
            c10.E = false;
            c10.errorMessage = string2 = throwable.getMessage();
        }
        return c10;
    }

    private static StoryObject b(Context object, Uri object2, int n10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object2 = com.sina.weibo.sdk.share.a.a(object, object2, n10)));
        if (bl2) {
            return null;
        }
        StoryObject storyObject = new StoryObject();
        storyObject.sourcePath = object2;
        storyObject.sourceType = n10;
        object2 = a.a().getAppKey();
        storyObject.appId = object2;
        object = object.getPackageName();
        storyObject.appPackage = object;
        storyObject.callbackAction = "com.sina.weibo.sdk.action.ACTION_SDK_REQ_STORY";
        return storyObject;
    }

    public final /* synthetic */ Object doInBackground(Object[] objectArray) {
        objectArray = (StoryMessage[])objectArray;
        return this.a((StoryMessage[])objectArray);
    }

    public final /* synthetic */ void onPostExecute(Object object) {
        object = (c)object;
        super.onPostExecute(object);
        b b10 = this.I;
        if (b10 != null) {
            b10.a((c)object);
        }
    }
}

