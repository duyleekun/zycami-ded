/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  org.json.JSONObject
 */
package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory$1;
import com.airbnb.lottie.LottieCompositionFactory$10;
import com.airbnb.lottie.LottieCompositionFactory$11;
import com.airbnb.lottie.LottieCompositionFactory$2;
import com.airbnb.lottie.LottieCompositionFactory$3;
import com.airbnb.lottie.LottieCompositionFactory$4;
import com.airbnb.lottie.LottieCompositionFactory$5;
import com.airbnb.lottie.LottieCompositionFactory$6;
import com.airbnb.lottie.LottieCompositionFactory$7;
import com.airbnb.lottie.LottieCompositionFactory$8;
import com.airbnb.lottie.LottieCompositionFactory$9;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import h.m0;
import h.o;
import h.z;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

public class LottieCompositionFactory {
    private static final byte[] MAGIC;
    private static final Map taskCache;

    static {
        Object object = new HashMap();
        taskCache = object;
        Object object2 = object = (Object)new byte[4];
        object2[0] = 80;
        object2[1] = 75;
        object2[2] = 3;
        object2[3] = 4;
        MAGIC = (byte[])object;
    }

    private LottieCompositionFactory() {
    }

    public static /* synthetic */ Map access$000() {
        return taskCache;
    }

    private static LottieTask cache(String object, Callable object2) {
        boolean bl2;
        Object object3 = object == null ? null : LottieCompositionCache.getInstance().get((String)object);
        if (object3 != null) {
            object2 = new LottieCompositionFactory$9((LottieComposition)object3);
            object = new LottieTask((Callable)object2);
            return object;
        }
        if (object != null && (bl2 = (object3 = taskCache).containsKey(object))) {
            return (LottieTask)object3.get(object);
        }
        object3 = new LottieTask((Callable)object2);
        if (object != null) {
            object2 = new LottieCompositionFactory$10((String)object);
            ((LottieTask)object3).addListener((LottieListener)object2);
            object2 = new LottieCompositionFactory$11((String)object);
            ((LottieTask)object3).addFailureListener((LottieListener)object2);
            object2 = taskCache;
            object2.put(object, object3);
        }
        return object3;
    }

    public static void clearCache(Context context) {
        taskCache.clear();
        LottieCompositionCache.getInstance().clear();
        L.networkCache(context).clear();
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition object, String string2) {
        boolean bl2;
        object = ((LottieComposition)object).getImages().values().iterator();
        while (bl2 = object.hasNext()) {
            LottieImageAsset lottieImageAsset = (LottieImageAsset)object.next();
            String string3 = lottieImageAsset.getFileName();
            boolean bl3 = string3.equals(string2);
            if (!bl3) continue;
            return lottieImageAsset;
        }
        return null;
    }

    public static LottieTask fromAsset(Context context, String string2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("asset_");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        return LottieCompositionFactory.fromAsset(context, string2, (String)charSequence);
    }

    public static LottieTask fromAsset(Context context, String string2, String string3) {
        context = context.getApplicationContext();
        LottieCompositionFactory$2 lottieCompositionFactory$2 = new LottieCompositionFactory$2(context, string2, string3);
        return LottieCompositionFactory.cache(string3, lottieCompositionFactory$2);
    }

    public static LottieResult fromAssetSync(Context context, String string2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("asset_");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        return LottieCompositionFactory.fromAssetSync(context, string2, (String)charSequence);
    }

    public static LottieResult fromAssetSync(Context object, String object2, String string2) {
        Object object3;
        block10: {
            boolean bl2;
            object3 = ".zip";
            try {
                bl2 = ((String)object2).endsWith((String)object3);
                if (bl2) break block10;
                object3 = ".lottie";
            }
            catch (IOException iOException) {
                object2 = new LottieResult(iOException);
                return object2;
            }
            bl2 = ((String)object2).endsWith((String)object3);
            if (bl2) break block10;
            object = object.getAssets();
            object = object.open((String)object2);
            return LottieCompositionFactory.fromJsonInputStreamSync((InputStream)object, string2);
        }
        object = object.getAssets();
        object = object.open((String)object2);
        object3 = new ZipInputStream((InputStream)object);
        return LottieCompositionFactory.fromZipStreamSync((ZipInputStream)object3, string2);
    }

    public static LottieTask fromJson(JSONObject jSONObject, String string2) {
        LottieCompositionFactory$5 lottieCompositionFactory$5 = new LottieCompositionFactory$5(jSONObject, string2);
        return LottieCompositionFactory.cache(string2, lottieCompositionFactory$5);
    }

    public static LottieTask fromJsonInputStream(InputStream inputStream, String string2) {
        LottieCompositionFactory$4 lottieCompositionFactory$4 = new LottieCompositionFactory$4(inputStream, string2);
        return LottieCompositionFactory.cache(string2, lottieCompositionFactory$4);
    }

    public static LottieResult fromJsonInputStreamSync(InputStream inputStream, String string2) {
        return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, string2, true);
    }

    private static LottieResult fromJsonInputStreamSync(InputStream inputStream, String object, boolean bl2) {
        try {
            Closeable closeable = z.m(inputStream);
            closeable = z.d(closeable);
            closeable = JsonReader.of((o)closeable);
            object = LottieCompositionFactory.fromJsonReaderSync((JsonReader)closeable, (String)object);
            return object;
        }
        finally {
            if (bl2) {
                Utils.closeQuietly(inputStream);
            }
        }
    }

    public static LottieTask fromJsonReader(JsonReader jsonReader, String string2) {
        LottieCompositionFactory$7 lottieCompositionFactory$7 = new LottieCompositionFactory$7(jsonReader, string2);
        return LottieCompositionFactory.cache(string2, lottieCompositionFactory$7);
    }

    public static LottieResult fromJsonReaderSync(JsonReader jsonReader, String string2) {
        return LottieCompositionFactory.fromJsonReaderSyncInternal(jsonReader, string2, true);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static LottieResult fromJsonReaderSyncInternal(JsonReader jsonReader, String object, boolean bl2) {
        Throwable throwable2222222;
        block7: {
            block6: {
                LottieComposition lottieComposition = LottieCompositionMoshiParser.parse(jsonReader);
                if (object != null) {
                    LottieCompositionCache lottieCompositionCache = LottieCompositionCache.getInstance();
                    lottieCompositionCache.put((String)object, lottieComposition);
                }
                object = new LottieResult(lottieComposition);
                if (!bl2) break block6;
                {
                    LottieResult lottieResult;
                    block8: {
                        catch (Throwable throwable2222222) {
                            break block7;
                        }
                        catch (Exception exception) {}
                        {
                            lottieResult = new LottieResult(exception);
                            if (!bl2) break block8;
                        }
                        Utils.closeQuietly(jsonReader);
                    }
                    return lottieResult;
                }
                Utils.closeQuietly(jsonReader);
            }
            return object;
        }
        if (bl2) {
            Utils.closeQuietly(jsonReader);
        }
        throw throwable2222222;
    }

    public static LottieTask fromJsonString(String string2, String string3) {
        LottieCompositionFactory$6 lottieCompositionFactory$6 = new LottieCompositionFactory$6(string2, string3);
        return LottieCompositionFactory.cache(string3, lottieCompositionFactory$6);
    }

    public static LottieResult fromJsonStringSync(String object, String string2) {
        object = ((String)object).getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        return LottieCompositionFactory.fromJsonReaderSync(JsonReader.of(z.d(z.m(byteArrayInputStream))), string2);
    }

    public static LottieResult fromJsonSync(JSONObject jSONObject, String string2) {
        return LottieCompositionFactory.fromJsonStringSync(jSONObject.toString(), string2);
    }

    public static LottieTask fromRawRes(Context context, int n10) {
        String string2 = LottieCompositionFactory.rawResCacheKey(context, n10);
        return LottieCompositionFactory.fromRawRes(context, n10, string2);
    }

    public static LottieTask fromRawRes(Context context, int n10, String string2) {
        WeakReference<Context> weakReference = new WeakReference<Context>(context);
        context = context.getApplicationContext();
        LottieCompositionFactory$3 lottieCompositionFactory$3 = new LottieCompositionFactory$3(weakReference, context, n10, string2);
        return LottieCompositionFactory.cache(string2, lottieCompositionFactory$3);
    }

    public static LottieResult fromRawResSync(Context context, int n10) {
        String string2 = LottieCompositionFactory.rawResCacheKey(context, n10);
        return LottieCompositionFactory.fromRawResSync(context, n10, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static LottieResult fromRawResSync(Context object, int n10, String string2) {
        try {
            object = object.getResources();
            object = object.openRawResource(n10);
            object = z.m((InputStream)object);
            object = z.d((m0)object);
            Object object2 = LottieCompositionFactory.isZipCompressed((o)object);
            n10 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            if (n10 != 0) {
                object = object.l0();
                object2 = new ZipInputStream((InputStream)object);
                return LottieCompositionFactory.fromZipStreamSync((ZipInputStream)object2, string2);
            }
            object = object.l0();
            return LottieCompositionFactory.fromJsonInputStreamSync((InputStream)object, string2);
        }
        catch (Resources.NotFoundException notFoundException) {
            return new LottieResult(notFoundException);
        }
    }

    public static LottieTask fromUrl(Context context, String string2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("url_");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        return LottieCompositionFactory.fromUrl(context, string2, (String)charSequence);
    }

    public static LottieTask fromUrl(Context context, String string2, String string3) {
        LottieCompositionFactory$1 lottieCompositionFactory$1 = new LottieCompositionFactory$1(context, string2, string3);
        return LottieCompositionFactory.cache(string3, lottieCompositionFactory$1);
    }

    public static LottieResult fromUrlSync(Context context, String string2) {
        return LottieCompositionFactory.fromUrlSync(context, string2, string2);
    }

    public static LottieResult fromUrlSync(Context object, String object2, String string2) {
        object = L.networkFetcher((Context)object).fetchSync((String)object2, string2);
        if (string2 != null && (object2 = ((LottieResult)object).getValue()) != null) {
            object2 = LottieCompositionCache.getInstance();
            LottieComposition lottieComposition = (LottieComposition)((LottieResult)object).getValue();
            ((LottieCompositionCache)object2).put(string2, lottieComposition);
        }
        return object;
    }

    public static LottieTask fromZipStream(ZipInputStream zipInputStream, String string2) {
        LottieCompositionFactory$8 lottieCompositionFactory$8 = new LottieCompositionFactory$8(zipInputStream, string2);
        return LottieCompositionFactory.cache(string2, lottieCompositionFactory$8);
    }

    public static LottieResult fromZipStreamSync(ZipInputStream zipInputStream, String object) {
        try {
            object = LottieCompositionFactory.fromZipStreamSyncInternal(zipInputStream, (String)object);
            return object;
        }
        finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static LottieResult fromZipStreamSyncInternal(ZipInputStream object, String object2) {
        boolean bl2;
        int n10;
        Object object3;
        int n11;
        Object object4;
        Object object5 = new HashMap();
        try {
            object4 = ((ZipInputStream)object).getNextEntry();
            n11 = 0;
            object3 = null;
            while (object4 != null) {
                String string2;
                String string3 = ((ZipEntry)object4).getName();
                boolean bl3 = string3.contains(string2 = "__MACOSX");
                if (bl3) {
                    ((ZipInputStream)object).closeEntry();
                } else {
                    String string4;
                    string2 = ((ZipEntry)object4).getName();
                    bl3 = string2.equalsIgnoreCase(string4 = "manifest.json");
                    if (bl3) {
                        ((ZipInputStream)object).closeEntry();
                    } else {
                        boolean bl4 = ((String)(object4 = ((ZipEntry)object4).getName())).contains(string2 = ".json");
                        if (bl4) {
                            object4 = z.m((InputStream)object);
                            object4 = z.d((m0)object4);
                            object4 = JsonReader.of((o)object4);
                            object3 = null;
                            object4 = LottieCompositionFactory.fromJsonReaderSyncInternal((JsonReader)object4, null, false);
                            object3 = object4 = ((LottieResult)object4).getValue();
                            object3 = (LottieComposition)object4;
                        } else {
                            object4 = ".png";
                            bl4 = string3.contains((CharSequence)object4);
                            if (!bl4 && !(bl4 = string3.contains((CharSequence)(object4 = ".webp")))) {
                                ((ZipInputStream)object).closeEntry();
                            } else {
                                object4 = "/";
                                object4 = string3.split((String)object4);
                                n10 = ((String[])object4).length + -1;
                                object4 = object4[n10];
                                string3 = BitmapFactory.decodeStream((InputStream)object);
                                object5.put(object4, string3);
                            }
                        }
                    }
                }
                object4 = ((ZipInputStream)object).getNextEntry();
            }
            if (object3 == null) {
                object2 = new IllegalArgumentException("Unable to parse composition");
                return new LottieResult((Throwable)object2);
            }
            object = object5.entrySet().iterator();
        }
        catch (IOException iOException) {
            return new LottieResult(iOException);
        }
        while (bl2 = object.hasNext()) {
            object5 = object.next();
            object4 = (String)object5.getKey();
            if ((object4 = LottieCompositionFactory.findImageAssetForFileName((LottieComposition)object3, (String)object4)) == null) continue;
            object5 = (Bitmap)object5.getValue();
            n11 = ((LottieImageAsset)object4).getWidth();
            n10 = ((LottieImageAsset)object4).getHeight();
            object5 = Utils.resizeBitmapIfNeeded((Bitmap)object5, n11, n10);
            ((LottieImageAsset)object4).setBitmap((Bitmap)object5);
        }
        object = ((LottieComposition)object3).getImages().entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object5 = object.next();
            object4 = ((LottieImageAsset)object5.getValue()).getBitmap();
            if (object4 != null) continue;
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("There is no image for ");
            object5 = ((LottieImageAsset)object5.getValue()).getFileName();
            ((StringBuilder)object4).append((String)object5);
            object5 = ((StringBuilder)object4).toString();
            object2 = new IllegalStateException((String)object5);
            return new LottieResult((Throwable)object2);
        }
        if (object2 == null) return new LottieResult(object3);
        object = LottieCompositionCache.getInstance();
        ((LottieCompositionCache)object).put((String)object2, (LottieComposition)object3);
        return new LottieResult(object3);
    }

    private static boolean isNightMode(Context context) {
        context = context.getResources().getConfiguration();
        int n10 = context.uiMode & 0x30;
        int n11 = 32;
        if (n10 == n11) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        return n10 != 0;
    }

    private static Boolean isZipCompressed(o o10) {
        Boolean bl2 = Boolean.FALSE;
        o10 = o10.peek();
        byte[] byArray = MAGIC;
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            byte by3 = o10.readByte();
            if (by3 == by2) continue;
            return bl2;
        }
        try {
            o10.close();
            return Boolean.TRUE;
        }
        catch (Exception exception) {
            Logger.error("Failed to check zip file header", exception);
            return bl2;
        }
    }

    private static String rawResCacheKey(Context object, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "rawRes";
        stringBuilder.append(string2);
        boolean bl2 = LottieCompositionFactory.isNightMode(object);
        object = bl2 ? "_night_" : "_day_";
        stringBuilder.append((String)object);
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public static void setMaxCacheSize(int n10) {
        LottieCompositionCache.getInstance().resize(n10);
    }
}

