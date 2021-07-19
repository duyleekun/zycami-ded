/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.provider.MediaStore$Images$Media
 *  android.util.Pair
 *  com.google.zxing.Binarizer
 *  com.google.zxing.BinaryBitmap
 *  com.google.zxing.ChecksumException
 *  com.google.zxing.DecodeHintType
 *  com.google.zxing.FormatException
 *  com.google.zxing.LuminanceSource
 *  com.google.zxing.NotFoundException
 *  com.google.zxing.RGBLuminanceSource
 *  com.google.zxing.common.HybridBinarizer
 *  com.google.zxing.qrcode.QRCodeReader
 */
package cn.sharesdk.framework.loopshare.watermark;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Pair;
import cn.sharesdk.framework.loopshare.watermark.FirstPic$1;
import cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener;
import cn.sharesdk.framework.loopshare.watermark.e;
import cn.sharesdk.framework.utils.SSDKLog;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.mob.tools.log.NLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.EnumMap;

public class FirstPic {
    private static Bitmap a(Context context, Uri object, ReadQrImageListener readQrImageListener) {
        Object[] objectArray;
        try {
            context = context.getContentResolver();
            objectArray = "r";
        }
        catch (IOException iOException) {
            if (readQrImageListener != null) {
                object = SSDKLog.b();
                int n10 = 1;
                objectArray = new Object[n10];
                String string2 = " getBitmapFromPath catch ";
                objectArray[0] = string2;
                String string3 = "ShareSDK";
                ((NLog)object).e(string3, objectArray);
                int n11 = -1;
                readQrImageListener.onFailed(iOException, n11);
            }
            return null;
        }
        context = context.openFileDescriptor((Uri)object, (String)objectArray);
        object = context.getFileDescriptor();
        object = BitmapFactory.decodeFileDescriptor((FileDescriptor)object);
        context.close();
        return object;
    }

    private static Bitmap a(Bitmap object) {
        Object object2;
        int n10;
        Object object3 = new ByteArrayOutputStream();
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        int n11 = 50;
        object.compress(compressFormat, n11, (OutputStream)object3);
        int n12 = 90;
        while ((n10 = ((byte[])(object2 = ((ByteArrayOutputStream)object3).toByteArray())).length / 1024) > n11) {
            ((ByteArrayOutputStream)object3).reset();
            object2 = Bitmap.CompressFormat.JPEG;
            object.compress((Bitmap.CompressFormat)object2, n12, (OutputStream)object3);
            n12 += -10;
        }
        object3 = ((ByteArrayOutputStream)object3).toByteArray();
        object = new ByteArrayInputStream((byte[])object3);
        return BitmapFactory.decodeStream((InputStream)object, null, null);
    }

    public static Uri a(Context object, String string2) {
        boolean bl2;
        Object object2 = object.getContentResolver();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String string3 = "_id";
        String[] stringArray = new String[]{string3};
        String string4 = "_data=? ";
        String[] stringArray2 = new String[]{string2};
        if ((object2 = object2.query(uri, stringArray, string4, stringArray2, null)) != null && (bl2 = object2.moveToFirst())) {
            int n10 = object2.getColumnIndex(string3);
            n10 = object2.getInt(n10);
            string2 = Uri.parse((String)"content://media/external/images/media");
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("");
            ((StringBuilder)object2).append(n10);
            object = ((StringBuilder)object2).toString();
            return Uri.withAppendedPath((Uri)string2, (String)object);
        }
        object2 = new File(string2);
        boolean bl3 = ((File)object2).exists();
        if (bl3) {
            object2 = new ContentValues();
            object2.put("_data", string2);
            object = object.getContentResolver();
            string2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            return object.insert((Uri)string2, (ContentValues)object2);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Pair a(Context context) {
        Object object = "date_modified";
        CharSequence charSequence = "_data";
        try {
            int n10;
            Uri uri;
            String string2;
            boolean bl2 = e.b();
            if (bl2) {
                string2 = FirstPic.b();
            } else {
                bl2 = e.a();
                if (bl2) {
                    string2 = FirstPic.a();
                } else {
                    bl2 = false;
                    string2 = null;
                }
            }
            string2 = FirstPic.a(string2);
            String[] stringArray = new String[]{charSequence, object};
            String string3 = "bucket_id = ?";
            int n11 = 1;
            String[] stringArray2 = new String[n11];
            n11 = 0;
            ContentResolver contentResolver = null;
            stringArray2[0] = string2;
            contentResolver = context.getContentResolver();
            Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            String string4 = "date_modified DESC";
            string2 = contentResolver.query(uri2, stringArray, string3, stringArray2, string4);
            n11 = (int)(string2.moveToFirst() ? 1 : 0);
            if (n11 != 0) {
                int n12 = string2.getColumnIndex((String)object);
                long l10 = string2.getLong(n12);
                Long l11 = l10;
                int n13 = string2.getColumnIndex((String)charSequence);
                string2 = string2.getString(n13);
                contentResolver = new Pair((Object)l11, (Object)string2);
            }
            if (bl2 = (context = (contentResolver = context.getContentResolver()).query(uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI, stringArray, string3, stringArray2, string4 = "date_modified DESC")).moveToFirst()) {
                n10 = context.getColumnIndex((String)object);
                long l12 = context.getLong(n10);
                object = l12;
                int n14 = context.getColumnIndex((String)charSequence);
                charSequence = context.getString(n14);
                string2 = new Pair(object, (Object)charSequence);
            } else {
                bl2 = false;
                string2 = null;
            }
            n10 = (int)(context.isClosed() ? 1 : 0);
            if (n10 == 0) {
                context.close();
            }
            if (string2 != null) {
                return string2;
            }
            return null;
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("getOVLatestPhoto catch: ");
            ((StringBuilder)charSequence).append(throwable);
            String string5 = ((StringBuilder)charSequence).toString();
            ((NLog)object).w(string5);
            return null;
        }
    }

    private static String a() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = Environment.getExternalStorageDirectory().toString();
        stringBuilder.append(string2);
        stringBuilder.append("/Pictures/Screenshots");
        return stringBuilder.toString();
    }

    private static String a(String string2) {
        return String.valueOf(string2.toLowerCase().hashCode());
    }

    public static void a(Context object, ReadQrImageListener readQrImageListener) {
        Object object2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 <= n11) {
            if (readQrImageListener != null) {
                String string2 = "The minimum version supported for this feature is 7.0";
                object = new Throwable(string2);
                n10 = -2;
                readQrImageListener.onFailed((Throwable)object, n10);
            }
            return;
        }
        if (object == null) {
            if (readQrImageListener != null) {
                String string3 = "Please set Contenxt";
                object2 = new Throwable(string3);
                n11 = -4;
                readQrImageListener.onFailed((Throwable)object2, n11);
            } else {
                return;
            }
        }
        object2 = new FirstPic$1((Context)object, readQrImageListener);
        ((Thread)object2).start();
    }

    public static void a(Context context, String string2, ReadQrImageListener readQrImageListener) {
        int n10;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = n10 = 1;
        string2 = FirstPic.a(context, string2);
        context = FirstPic.a(context, (Uri)string2, readQrImageListener);
        string2 = null;
        options.inJustDecodeBounds = false;
        float f10 = options.outHeight;
        float f11 = 400.0f;
        int n11 = (int)(f10 /= f11);
        if (n11 > 0) {
            n10 = n11;
        }
        options.inSampleSize = n10;
        FirstPic.a((Bitmap)context, readQrImageListener);
    }

    public static void a(Bitmap object, ReadQrImageListener readQrImageListener) {
        block16: {
            String string2 = "\u89e3\u6790\u4e8c\u7ef4\u7801\u5f02\u5e38 ";
            String string3 = "ShareSDK";
            if (object == null && readQrImageListener != null) {
                object = new Throwable("\u8bfb\u53d6\u76f8\u518c\u56fe\u7247\u5931\u8d25");
                readQrImageListener.onFailed((Throwable)object, -1);
                return;
            }
            Object object2 = FirstPic.a(object);
            int n10 = object2.getWidth();
            int n11 = object2.getHeight();
            int[] nArray = new int[n10 * n11];
            Object object3 = null;
            HybridBinarizer hybridBinarizer = null;
            Object object4 = nArray;
            int n12 = n10;
            object2.getPixels(nArray, 0, n10, 0, 0, n10, n11);
            object2 = new QRCodeReader();
            object4 = new EnumMap;
            ((EnumMap)object4)(DecodeHintType.class);
            DecodeHintType decodeHintType = DecodeHintType.TRY_HARDER;
            Object[] objectArray = Boolean.TRUE;
            object4.put(decodeHintType, objectArray);
            decodeHintType = DecodeHintType.PURE_BARCODE;
            object4.put(decodeHintType, objectArray);
            decodeHintType = DecodeHintType.CHARACTER_SET;
            objectArray = "utf-8";
            object4.put(decodeHintType, objectArray);
            int n13 = -3;
            decodeHintType = null;
            n12 = 1;
            object3 = new RGBLuminanceSource(n10, n11, nArray);
            hybridBinarizer = new HybridBinarizer((LuminanceSource)object3);
            object = new BinaryBitmap((Binarizer)hybridBinarizer);
            object = object2.decode((BinaryBitmap)object);
            if (readQrImageListener == null) break block16;
            object = object.getText();
            try {
                readQrImageListener.onSucessed((String)object);
            }
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                objectArray = new Object[n12];
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(throwable);
                string2 = ((StringBuilder)object3).toString();
                objectArray[0] = string2;
                ((NLog)object2).e(string3, objectArray);
                if (readQrImageListener != null) {
                    readQrImageListener.onFailed(throwable, n13);
                }
            }
            catch (FormatException formatException) {
                object2 = SSDKLog.b();
                objectArray = new Object[n12];
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((Object)formatException);
                string2 = ((StringBuilder)object3).toString();
                objectArray[0] = string2;
                ((NLog)object2).e(string3, objectArray);
                if (readQrImageListener != null) {
                    readQrImageListener.onFailed(formatException, n13);
                }
            }
            catch (ChecksumException checksumException) {
                object2 = SSDKLog.b();
                objectArray = new Object[n12];
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((Object)checksumException);
                string2 = ((StringBuilder)object3).toString();
                objectArray[0] = string2;
                ((NLog)object2).e(string3, objectArray);
                if (readQrImageListener != null) {
                    readQrImageListener.onFailed(checksumException, n13);
                }
            }
            catch (NotFoundException notFoundException) {
                object2 = SSDKLog.b();
                objectArray = new Object[n12];
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((Object)notFoundException);
                string2 = ((StringBuilder)object3).toString();
                objectArray[0] = string2;
                ((NLog)object2).e(string3, objectArray);
                if (readQrImageListener == null) break block16;
                readQrImageListener.onFailed(notFoundException, n13);
            }
        }
    }

    public static Pair b(Context object) {
        long l10;
        Object object2;
        Pair pair;
        block50: {
            int n10;
            block49: {
                boolean bl2;
                block48: {
                    String string2;
                    ContentResolver contentResolver;
                    Object object3;
                    String[] stringArray;
                    String string3;
                    String[] stringArray2;
                    CharSequence charSequence;
                    Object object4;
                    block47: {
                        block46: {
                            object4 = "date_modified";
                            charSequence = "_data";
                            try {
                                pair = new StringBuilder();
                                object2 = Environment.getExternalStorageDirectory();
                            }
                            catch (Throwable throwable) {
                                object4 = SSDKLog.b();
                                charSequence = new StringBuilder();
                                ((StringBuilder)charSequence).append("getLatestPhoto catch: ");
                                ((StringBuilder)charSequence).append(throwable);
                                String string4 = ((StringBuilder)charSequence).toString();
                                ((NLog)object4).w(string4);
                                return null;
                            }
                            object2 = ((File)object2).toString();
                            pair.append((String)object2);
                            object2 = "/DCIM/Camera";
                            pair.append((String)object2);
                            pair = pair.toString();
                            object2 = FirstPic.c();
                            pair = FirstPic.a((String)pair);
                            object2 = FirstPic.a((String)object2);
                            stringArray2 = new String[]{charSequence, object4};
                            string3 = "bucket_id = ?";
                            int n11 = 1;
                            stringArray = new String[n11];
                            int n12 = 0;
                            object3 = null;
                            stringArray[0] = pair;
                            pair = new String[n11];
                            pair[0] = object2;
                            contentResolver = object.getContentResolver();
                            object3 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                            string2 = "date_modified DESC";
                            object2 = contentResolver.query(object3, stringArray2, string3, stringArray, string2);
                            n11 = (int)(object2.moveToFirst() ? 1 : 0);
                            if (n11 == 0) break block46;
                            n12 = object2.getColumnIndex((String)object4);
                            long l11 = object2.getLong(n12);
                            object3 = l11;
                            int n13 = object2.getColumnIndex((String)charSequence);
                            object2 = object2.getString(n13);
                            contentResolver = new Pair(object3, object2);
                            object2 = contentResolver;
                            break block47;
                        }
                        object2 = null;
                    }
                    contentResolver = object.getContentResolver();
                    object3 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    string2 = "date_modified DESC";
                    stringArray = pair;
                    object = contentResolver.query(object3, stringArray2, string3, (String[])pair, string2);
                    bl2 = object.moveToFirst();
                    if (!bl2) break block48;
                    n10 = object.getColumnIndex((String)object4);
                    l10 = object.getLong(n10);
                    object4 = l10;
                    int n14 = object.getColumnIndex((String)charSequence);
                    charSequence = object.getString(n14);
                    pair = new Pair(object4, (Object)charSequence);
                    break block49;
                }
                bl2 = false;
                pair = null;
            }
            n10 = (int)(object.isClosed() ? 1 : 0);
            if (n10 != 0) break block50;
            object.close();
        }
        if (object2 != null && pair != null) {
            object = ((Pair)object2).first;
            object = (Long)object;
            long l12 = (Long)object;
            object = pair.first;
            object = (Long)object;
            l10 = (Long)object;
            long l13 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
            if (l13 > 0) {
                return object2;
            }
            return pair;
        }
        if (object2 != null && pair == null) {
            return object2;
        }
        if (object2 == null && pair != null) {
            return pair;
        }
        return null;
    }

    private static String b() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = Environment.getExternalStorageDirectory().toString();
        stringBuilder.append(string2);
        stringBuilder.append("/Screenshot");
        return stringBuilder.toString();
    }

    private static String c() {
        CharSequence charSequence = new StringBuilder();
        Object object = Environment.getExternalStorageDirectory().toString();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("/DCIM/Screenshots");
        charSequence = ((StringBuilder)charSequence).toString();
        object = new File((String)charSequence);
        boolean bl2 = ((File)object).exists();
        if (!bl2) {
            charSequence = new StringBuilder();
            object = Environment.getExternalStorageDirectory().toString();
            ((StringBuilder)charSequence).append((String)object);
            object = "/Pictures/Screenshots";
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }
}

