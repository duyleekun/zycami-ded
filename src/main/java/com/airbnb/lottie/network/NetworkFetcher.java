/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.airbnb.lottie.network;

import android.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.network.FileExtension;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

public class NetworkFetcher {
    private final LottieNetworkFetcher fetcher;
    private final NetworkCache networkCache;

    public NetworkFetcher(NetworkCache networkCache, LottieNetworkFetcher lottieNetworkFetcher) {
        this.networkCache = networkCache;
        this.fetcher = lottieNetworkFetcher;
    }

    private LottieComposition fetchFromCache(String object, String object2) {
        if (object2 == null) {
            return null;
        }
        object2 = this.networkCache.fetch((String)object);
        if (object2 == null) {
            return null;
        }
        Object object3 = (FileExtension)((Object)((Pair)object2).first);
        object2 = (InputStream)((Pair)object2).second;
        FileExtension fileExtension = FileExtension.ZIP;
        if (object3 == fileExtension) {
            object3 = new ZipInputStream((InputStream)object2);
            object = LottieCompositionFactory.fromZipStreamSync((ZipInputStream)object3, (String)object);
        } else {
            object = LottieCompositionFactory.fromJsonInputStreamSync((InputStream)object2, (String)object);
        }
        object2 = ((LottieResult)object).getValue();
        if (object2 != null) {
            return (LottieComposition)((LottieResult)object).getValue();
        }
        return null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private LottieResult fetchFromNetwork(String object, String object2) {
        Throwable throwable222222;
        Object object3;
        String string2;
        block16: {
            Object object4;
            block15: {
                string2 = "LottieFetchResult close failed ";
                object3 = new StringBuilder();
                object4 = "Fetching ";
                ((StringBuilder)object3).append((String)object4);
                ((StringBuilder)object3).append((String)object);
                Logger.debug(((StringBuilder)object3).toString());
                object3 = null;
                object4 = this.fetcher;
                object3 = object4.fetchSync((String)object);
                boolean bl2 = object3.isSuccessful();
                if (!bl2) break block15;
                object4 = object3.bodyByteStream();
                String string3 = object3.contentType();
                object = this.fromInputStream((String)object, (InputStream)object4, string3, (String)object2);
                object2 = new StringBuilder();
                object4 = "Completed fetch from network. Success: ";
                ((StringBuilder)object2).append((String)object4);
                object4 = ((LottieResult)object).getValue();
                if (object4 != null) {
                    bl2 = true;
                } else {
                    bl2 = false;
                    object4 = null;
                }
                ((StringBuilder)object2).append(bl2);
                object2 = ((StringBuilder)object2).toString();
                Logger.debug((String)object2);
                if (object3 == null) return object;
                try {
                    object3.close();
                    return object;
                }
                catch (IOException iOException) {
                    Logger.warning(string2, iOException);
                }
                return object;
            }
            object4 = object3.error();
            object2 = new IllegalArgumentException((String)object4);
            object = new LottieResult((Throwable)object2);
            if (object3 == null) return object;
            try {
                object3.close();
                return object;
            }
            catch (IOException iOException) {
                Logger.warning(string2, iOException);
            }
            return object;
            {
                catch (Throwable throwable222222) {
                    break block16;
                }
                catch (Exception exception) {}
                {
                    object2 = new LottieResult(exception);
                    if (object3 == null) return object2;
                }
                try {
                    object3.close();
                    return object2;
                }
                catch (IOException iOException) {
                    Logger.warning(string2, iOException);
                }
                return object2;
            }
        }
        if (object3 == null) throw throwable222222;
        try {
            object3.close();
            throw throwable222222;
        }
        catch (IOException iOException) {
            Logger.warning(string2, iOException);
        }
        throw throwable222222;
    }

    private LottieResult fromInputStream(String string2, InputStream object, String object2, String object3) {
        String string3;
        boolean bl2;
        if (object2 == null) {
            object2 = "application/json";
        }
        if (!(bl2 = object2.contains(string3 = "application/zip")) && !(bl2 = (object2 = string2.split("\\?")[0]).endsWith(string3 = ".lottie"))) {
            Logger.debug("Received json response.");
            object2 = FileExtension.JSON;
            object = this.fromJsonStream(string2, (InputStream)object, (String)object3);
        } else {
            Logger.debug("Handling zip response.");
            object2 = FileExtension.ZIP;
            object = this.fromZipStream(string2, (InputStream)object, (String)object3);
        }
        if (object3 != null && (object3 = ((LottieResult)object).getValue()) != null) {
            object3 = this.networkCache;
            ((NetworkCache)object3).renameTempFile(string2, (FileExtension)((Object)object2));
        }
        return object;
    }

    private LottieResult fromJsonStream(String string2, InputStream object, String object2) {
        if (object2 == null) {
            return LottieCompositionFactory.fromJsonInputStreamSync((InputStream)object, null);
        }
        object2 = this.networkCache;
        Object object3 = FileExtension.JSON;
        object = ((NetworkCache)object2).writeTempCacheFile(string2, (InputStream)object, (FileExtension)((Object)object3));
        object = ((File)object).getAbsolutePath();
        object3 = new File((String)object);
        object2 = new FileInputStream((File)object3);
        return LottieCompositionFactory.fromJsonInputStreamSync((InputStream)object2, string2);
    }

    private LottieResult fromZipStream(String object, InputStream object2, String object3) {
        if (object3 == null) {
            object = new ZipInputStream((InputStream)object2);
            return LottieCompositionFactory.fromZipStreamSync((ZipInputStream)object, null);
        }
        object3 = this.networkCache;
        Object object4 = FileExtension.ZIP;
        object2 = ((NetworkCache)object3).writeTempCacheFile((String)object, (InputStream)object2, (FileExtension)((Object)object4));
        object4 = new FileInputStream((File)object2);
        object3 = new ZipInputStream((InputStream)object4);
        return LottieCompositionFactory.fromZipStreamSync((ZipInputStream)object3, (String)object);
    }

    public LottieResult fetchSync(String object, String string2) {
        Object object2 = this.fetchFromCache((String)object, string2);
        if (object2 != null) {
            object = new LottieResult(object2);
            return object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Animation for ");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(" not found in cache. Fetching from network.");
        Logger.debug(((StringBuilder)object2).toString());
        return this.fetchFromNetwork((String)object, string2);
    }
}

