/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONObject
 */
package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStoreImpl;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

public class CachedSettingsIo {
    private static final String SETTINGS_CACHE_FILENAME = "com.crashlytics.settings.json";
    private final Context context;

    public CachedSettingsIo(Context context) {
        this.context = context;
    }

    private File getSettingsFile() {
        Context context = this.context;
        Object object = new FileStoreImpl(context);
        object = ((FileStoreImpl)object).getFilesDir();
        File file = new File((File)object, SETTINGS_CACHE_FILENAME);
        return file;
    }

    /*
     * WARNING - void declaration
     */
    public JSONObject readCachedSettings() {
        Object object;
        Object object2;
        String string2;
        block18: {
            block19: {
                Logger logger;
                block17: {
                    block16: {
                        boolean bl2;
                        Object object3;
                        block15: {
                            string2 = "Error while closing settings cache file.";
                            object2 = Logger.getLogger();
                            object3 = "Checking for cached settings...";
                            ((Logger)object2).d((String)object3);
                            object2 = null;
                            object3 = this.getSettingsFile();
                            bl2 = ((File)object3).exists();
                            if (!bl2) break block15;
                            object = new FileInputStream((File)object3);
                            object3 = CommonUtils.streamToString((InputStream)object);
                            try {
                                logger = new JSONObject((String)object3);
                                object2 = object;
                                break block16;
                            }
                            catch (Exception exception) {
                                break block17;
                            }
                        }
                        object3 = Logger.getLogger();
                        object = "Settings file does not exist.";
                        try {
                            ((Logger)object3).v((String)object);
                            logger = null;
                        }
                        catch (Throwable throwable) {
                            bl2 = false;
                            object = null;
                            object2 = throwable;
                            break block18;
                        }
                        catch (Exception exception) {
                            bl2 = false;
                            object = null;
                        }
                    }
                    CommonUtils.closeOrLog((Closeable)object2, string2);
                    object2 = logger;
                    break block19;
                }
                logger = Logger.getLogger();
                String string3 = "Failed to fetch cached settings";
                try {
                    void var3_8;
                    logger.e(string3, (Throwable)var3_8);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                CommonUtils.closeOrLog((Closeable)object, string2);
            }
            return object2;
        }
        CommonUtils.closeOrLog((Closeable)object, string2);
        throw object2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void writeCachedSettings(long var1_1, JSONObject var3_2) {
        block7: {
            var4_3 = "Failed to close settings writer.";
            var5_4 = Logger.getLogger();
            var6_5 = "Writing settings to cache file...";
            var5_4.v(var6_5);
            if (var3_2 /* !! */  == null) return;
            var5_4 = null;
            var6_5 = "expires_at";
            try {
                var3_2 /* !! */ .put(var6_5, var1_1);
                var8_7 = this.getSettingsFile();
                var7_6 = new FileWriter((File)var8_7);
            }
            catch (Throwable var8_10) {
                break block7;
            }
            catch (Exception var8_11) {
                // empty catch block
                ** GOTO lbl-1000
            }
            try {
                var8_7 = var3_2 /* !! */ .toString();
                var7_6.write((String)var8_7);
                var7_6.flush();
            }
            catch (Throwable var8_8) {
                var5_4 = var7_6;
                break block7;
            }
            catch (Exception var8_9) {
                var5_4 = var7_6;
                ** GOTO lbl-1000
            }
            CommonUtils.closeOrLog((Closeable)var7_6, var4_3);
            return;
lbl-1000:
            // 2 sources

            {
                var7_6 = Logger.getLogger();
                var3_2 /* !! */  = "Failed to cache settings";
                var7_6.e((String)var3_2 /* !! */ , (Throwable)var8_12);
            }
            CommonUtils.closeOrLog((Closeable)var5_4, var4_3);
            return;
        }
        CommonUtils.closeOrLog((Closeable)var5_4, var4_3);
        throw var8_13;
    }
}

