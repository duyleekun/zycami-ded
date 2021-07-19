/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.media.ThumbnailUtils
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Images$Thumbnails
 *  android.provider.MediaStore$Video$Media
 *  android.provider.MediaStore$Video$Thumbnails
 *  android.util.Log
 */
package com.cdv.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import com.cdv.utils.NvAndroidBitmap;
import com.cdv.utils.NvAndroidBitmap$Size;

public class NvAndroidThumbnail {
    private static final String TAG = "NvAndroidThumbnail";

    public static Bitmap createThumbnail(Context context, String string2, boolean bl2, int n10, int n11) {
        boolean bl3;
        Context context2 = context;
        String string3 = string2;
        boolean bl4 = bl2;
        Object object = null;
        if (context != null && string2 != null && !(bl3 = string2.isEmpty())) {
            String string4;
            String[] stringArray;
            String[] stringArray2;
            Object object2;
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                return null;
            }
            ContentResolver contentResolver2 = "content://";
            int n12 = string2.startsWith((String)contentResolver2);
            int n13 = n10;
            NvAndroidBitmap$Size nvAndroidBitmap$Size = new NvAndroidBitmap$Size(n10, n11);
            String string5 = "_id";
            int n14 = 1;
            if (n12 == 0) {
                contentResolver2 = bl2 ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                object2 = contentResolver2;
                stringArray2 = new String[]{string5};
                stringArray = new String[n14];
                stringArray[0] = string3;
                string4 = "_data=?";
                contentResolver2 = contentResolver;
                contentResolver2 = contentResolver.query((Uri)object2, stringArray2, string4, stringArray, null);
            } else {
                object2 = Uri.parse((String)string2);
                stringArray2 = new String[]{string5};
                string4 = null;
                stringArray = null;
                contentResolver2 = contentResolver;
                contentResolver2 = contentResolver.query((Uri)object2, stringArray2, null, null, null);
            }
            if (contentResolver2 != null && (n13 = (int)(contentResolver2.moveToFirst() ? 1 : 0)) != 0) {
                long l10;
                ContentResolver contentResolver3;
                n13 = contentResolver2.getColumnIndex(string5);
                if (n13 < 0) {
                    contentResolver2.close();
                    return NvAndroidThumbnail.createThumbnailFromFile(context2, string3, bl4, nvAndroidBitmap$Size);
                }
                long l11 = contentResolver2.getLong(n13);
                contentResolver2.close();
                n12 = Build.VERSION.SDK_INT;
                n13 = 29;
                if (n12 < n13) {
                    contentResolver2 = bl4 ? MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI : MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
                    object2 = contentResolver2;
                    stringArray2 = new String[n14];
                    stringArray2[0] = string5 = "_data";
                    contentResolver2 = new StringBuilder();
                    string4 = bl4 ? "video_id" : "image_id";
                    contentResolver2.append(string4);
                    contentResolver2.append("=?");
                    string4 = contentResolver2.toString();
                    String[] stringArray3 = new String[n14];
                    contentResolver2 = String.valueOf(l11);
                    stringArray3[0] = contentResolver2;
                    contentResolver2 = contentResolver;
                    contentResolver3 = contentResolver;
                    l10 = l11;
                    stringArray = stringArray3;
                    contentResolver2 = contentResolver.query((Uri)object2, stringArray2, string4, stringArray3, null);
                    if (contentResolver2 != null && (n13 = (int)(contentResolver2.moveToFirst() ? 1 : 0)) != 0 && (n13 = bl4 ? contentResolver2.getColumnIndex(string5) : contentResolver2.getColumnIndex(string5)) >= 0) {
                        object2 = contentResolver2.getString(n13);
                        contentResolver2.close();
                        n12 = (int)(((String)object2).isEmpty() ? 1 : 0);
                        if (n12 == 0 && (contentResolver2 = NvAndroidBitmap.createRotatedBitmap(context2, (String)object2, nvAndroidBitmap$Size, n12 = 2, false)) != null) {
                            return NvAndroidThumbnail.transformSystemGeneratedBitmap(context2, (Bitmap)contentResolver2, string3, bl4);
                        }
                        n12 = 0;
                        contentResolver2 = null;
                    }
                    if (contentResolver2 != null) {
                        contentResolver2.close();
                    }
                } else {
                    contentResolver3 = contentResolver;
                    l10 = l11;
                }
                if (bl4) {
                    contentResolver2 = contentResolver3;
                    n13 = 0;
                    object2 = null;
                    contentResolver2 = MediaStore.Video.Thumbnails.getThumbnail((ContentResolver)contentResolver3, (long)l10, (int)n14, null);
                } else {
                    contentResolver2 = contentResolver3;
                    n13 = 0;
                    object2 = null;
                    contentResolver2 = MediaStore.Images.Thumbnails.getThumbnail((ContentResolver)contentResolver3, (long)l10, (int)n14, null);
                }
                if (contentResolver2 != null) {
                    return NvAndroidThumbnail.transformSystemGeneratedBitmap(context2, (Bitmap)contentResolver2, string3, bl4);
                }
                contentResolver2 = new Object[n14];
                contentResolver2[0] = object = Long.valueOf(l10);
                object = String.format("Fail to get thumbnail file for media '%d'!", (Object[])contentResolver2);
                Log.w((String)TAG, (String)object);
                return NvAndroidThumbnail.createThumbnailFromFile(context2, string3, bl4, nvAndroidBitmap$Size);
            }
            if (contentResolver2 != null) {
                contentResolver2.close();
            }
            return NvAndroidThumbnail.createThumbnailFromFile(context2, string3, bl4, nvAndroidBitmap$Size);
        }
        return null;
    }

    private static Bitmap createThumbnailFromFile(Context object, String string2, boolean bl2, NvAndroidBitmap$Size nvAndroidBitmap$Size) {
        if (!bl2) {
            return NvAndroidBitmap.createRotatedBitmap((Context)object, string2, nvAndroidBitmap$Size, 2, false);
        }
        int n10 = 1;
        Bitmap bitmap = ThumbnailUtils.createVideoThumbnail((String)string2, (int)n10);
        if (bitmap == null) {
            object = new Object[n10];
            object[0] = string2;
            object = String.format("Failed to create video thumbnail bitmap for '%s'!", object);
            string2 = TAG;
            Log.e((String)string2, (String)object);
        }
        return bitmap;
    }

    private static Bitmap transformSystemGeneratedBitmap(Context object, Bitmap bitmap, String string2, boolean n10) {
        if (bitmap == null) {
            return null;
        }
        if (n10 != 0) {
            return bitmap;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            return bitmap;
        }
        if ((object = NvAndroidBitmap.getImageInfo(object, string2)) != null) {
            int n12 = object.orientation;
            try {
                bitmap = NvAndroidBitmap.transformBitmap(bitmap, n12);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return bitmap;
    }
}

