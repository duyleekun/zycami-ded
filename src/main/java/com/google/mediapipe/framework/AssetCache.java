/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 */
package com.google.mediapipe.framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.common.base.Preconditions;
import com.google.common.flogger.AbstractLogger;
import com.google.common.flogger.FluentLogger;
import com.google.common.flogger.FluentLogger$Api;
import com.google.mediapipe.framework.AssetCacheDbHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AssetCache {
    public static final String MEDIAPIPE_ASSET_CACHE_DIR = "mediapipe_asset_cache";
    private static AssetCache assetCache;
    private static final FluentLogger logger;
    private int appVersionCode;
    private Context context;
    private AssetCacheDbHelper versionDatabase;

    static {
        logger = FluentLogger.forEnclosingClass();
    }

    private AssetCache(Context object) {
        Object object2;
        this.context = object;
        this.versionDatabase = object2 = new AssetCacheDbHelper((Context)object);
        try {
            object2 = object.getPackageManager();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            super("Can't get app version code.", nameNotFoundException);
            throw object2;
        }
        object = object.getPackageName();
        int n10 = 0;
        object = object2.getPackageInfo((String)object, 0);
        int n11 = ((PackageInfo)object).versionCode;
        this.appVersionCode = n11;
        object = logger;
        object = ((AbstractLogger)object).atInfo();
        object = (FluentLogger$Api)object;
        object2 = "Current app version code: %d";
        n10 = this.appVersionCode;
        object.log((String)object2, n10);
        object = this.versionDatabase;
        int n12 = this.appVersionCode;
        ((AssetCacheDbHelper)((Object)object)).invalidateCache(n12);
    }

    public static AssetCache create(Context object) {
        Class<AssetCache> clazz = AssetCache.class;
        synchronized (clazz) {
            Preconditions.checkNotNull(object);
            AssetCache assetCache = AssetCache.assetCache;
            if (assetCache == null) {
                AssetCache.assetCache = assetCache = new AssetCache((Context)object);
            }
            object = AssetCache.assetCache;
            return object;
        }
    }

    public static AssetCache getAssetCache() {
        Class<AssetCache> clazz = AssetCache.class;
        synchronized (clazz) {
            AssetCache assetCache = AssetCache.assetCache;
            return assetCache;
        }
    }

    public static void purgeCache(Context context) {
        Class<AssetCache> clazz = AssetCache.class;
        synchronized (clazz) {
            AssetCacheDbHelper assetCacheDbHelper = new AssetCacheDbHelper(context);
            int n10 = -1;
            assetCacheDbHelper.invalidateCache(n10);
            assetCacheDbHelper.close();
            return;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private static void writeStreamToFile(InputStream inputStream, File object) {
        void var0_3;
        FileOutputStream fileOutputStream;
        block10: {
            int n10;
            int n11 = 0;
            fileOutputStream = null;
            FileOutputStream fileOutputStream2 = new FileOutputStream((File)object);
            int n12 = 1000;
            try {
                object = new byte[n12];
            }
            catch (Throwable throwable) {
                fileOutputStream = fileOutputStream2;
                break block10;
            }
            while (true) {
                n11 = inputStream.read((byte[])object);
                n10 = -1;
                if (n11 != n10) break block9;
                break;
            }
            {
                block9: {
                    fileOutputStream2.close();
                    return;
                }
                n10 = 0;
                fileOutputStream2.write((byte[])object, 0, n11);
                continue;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        throw var0_3;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String getAbsolutePathFromAsset(String string2) {
        synchronized (this) {
            Object object = this.context;
            object = object.getAssets();
            Object object2 = this.getDefaultMediaPipeCacheDir();
            ((File)object2).mkdir();
            Object object3 = new File(string2);
            object3 = ((File)object3).getName();
            object2 = ((File)object2).getPath();
            Object object4 = new File((String)object2, (String)object3);
            int n10 = ((File)object4).exists();
            if (n10 != 0 && (n10 = this.appVersionCode) != 0 && (n10 = (int)(((AssetCacheDbHelper)((Object)(object3 = this.versionDatabase))).checkVersion(string2, n10) ? 1 : 0)) != 0) {
                return ((File)object4).getAbsolutePath();
            }
            n10 = 0;
            object2 = null;
            try {
                object = object.open(string2);
            }
            catch (IOException iOException) {
                boolean bl2 = false;
                object = null;
                object3 = logger;
                object3 = ((AbstractLogger)object3).atSevere();
                object3 = (FluentLogger$Api)object3;
                object4 = "Unable to unpack: %s";
                object3.log((String)object4, string2);
                if (object == null) return null;
                try {
                    ((InputStream)object).close();
                }
                catch (IOException iOException2) {
                    return null;
                }
                return null;
            }
            AssetCache.writeStreamToFile((InputStream)object, (File)object4);
            int n11 = this.appVersionCode;
            if (n11 == 0) return ((File)object4).getAbsolutePath();
            object = this.versionDatabase;
            object2 = ((File)object4).getAbsolutePath();
            int n12 = this.appVersionCode;
            ((AssetCacheDbHelper)((Object)object)).insertAsset(string2, (String)object2, n12);
            return ((File)object4).getAbsolutePath();
            {
                catch (IOException iOException) {}
            }
        }
    }

    public String[] getAvailableAssets() {
        synchronized (this) {
            String[] stringArray;
            block7: {
                stringArray = this.getDefaultMediaPipeCacheDir();
                boolean bl2 = stringArray.exists();
                if (!bl2) break block7;
                stringArray = stringArray.list();
                return stringArray;
            }
            stringArray = null;
            stringArray = new String[]{};
            return stringArray;
            finally {
            }
        }
    }

    public File getDefaultMediaPipeCacheDir() {
        File file = this.context.getCacheDir();
        File file2 = new File(file, MEDIAPIPE_ASSET_CACHE_DIR);
        return file2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void loadAllAssets(String object) {
        synchronized (this) {
            int n10;
            Object object2;
            Preconditions.checkNotNull(object);
            Object object3 = this.context;
            object3 = object3.getAssets();
            String[] stringArray = null;
            try {
                stringArray = object3.list((String)object);
            }
            catch (IOException object22) {
                object2 = logger;
                object2 = ((AbstractLogger)object2).atSevere();
                object2 = (FluentLogger$Api)object2;
                object3 = object2.withCause(object22);
                object3 = (FluentLogger$Api)object3;
                object2 = "Unable to get files in assets path: %s";
                object3.log((String)object2, object);
            }
            if (stringArray == null || (n10 = stringArray.length) == 0) {
                object = logger;
                object = ((AbstractLogger)object).atWarning();
                object = (FluentLogger$Api)object;
                object3 = "No files to load";
                object.log((String)object3);
                return;
            }
            n10 = stringArray.length;
            int n11 = 0;
            object2 = null;
            while (n11 < n10) {
                String string2 = stringArray[n11];
                boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((String)object);
                    String string3 = "/";
                    stringBuilder.append(string3);
                    stringBuilder.append(string2);
                    string2 = stringBuilder.toString();
                }
                this.getAbsolutePathFromAsset(string2);
                ++n11;
            }
            return;
        }
    }
}

