/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package com.sina.weibo.sdk.api;

import android.os.Bundle;
import android.os.Parcelable;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.MediaObject;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.VideoSourceObject;
import java.io.Serializable;

public class WeiboMultiMessage
implements Serializable {
    private static final long serialVersionUID = -3336491646257094828L;
    public ImageObject imageObject;
    public MediaObject mediaObject;
    public MultiImageObject multiImageObject;
    public TextObject textObject;
    public VideoSourceObject videoSourceObject;

    public void readFromBundle(Bundle object) {
        MediaObject mediaObject;
        this.mediaObject = mediaObject = (MediaObject)object.getParcelable("_weibo_message_media");
        mediaObject = (TextObject)object.getParcelable("_weibo_message_text");
        this.textObject = mediaObject;
        mediaObject = (ImageObject)object.getParcelable("_weibo_message_image");
        this.imageObject = mediaObject;
        mediaObject = (MultiImageObject)object.getParcelable("_weibo_message_multi_image");
        this.multiImageObject = mediaObject;
        object = (VideoSourceObject)object.getParcelable("_weibo_message_video_source");
        this.videoSourceObject = object;
    }

    public Bundle writeToBundle(Bundle bundle) {
        MediaObject mediaObject = this.mediaObject;
        String string2 = "_weibo_message_media";
        if (mediaObject != null) {
            bundle.putParcelable(string2, (Parcelable)mediaObject);
        } else {
            bundle.putParcelable(string2, null);
        }
        mediaObject = this.textObject;
        string2 = "_weibo_message_text";
        if (mediaObject != null) {
            bundle.putParcelable(string2, (Parcelable)mediaObject);
        } else {
            bundle.putParcelable(string2, null);
        }
        mediaObject = this.imageObject;
        string2 = "_weibo_message_image";
        if (mediaObject != null) {
            bundle.putParcelable(string2, (Parcelable)mediaObject);
        } else {
            bundle.putParcelable(string2, null);
        }
        mediaObject = this.multiImageObject;
        string2 = "_weibo_message_multi_image";
        if (mediaObject != null) {
            bundle.putParcelable(string2, (Parcelable)mediaObject);
        } else {
            bundle.putParcelable(string2, null);
        }
        mediaObject = this.videoSourceObject;
        string2 = "_weibo_message_video_source";
        if (mediaObject != null) {
            bundle.putParcelable(string2, (Parcelable)mediaObject);
        } else {
            bundle.putParcelable(string2, null);
        }
        return bundle;
    }
}

