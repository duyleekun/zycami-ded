/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.davemorrissey.labs.subscaleview.decoder;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import java.io.InputStream;
import java.util.List;

public class SkiaImageDecoder
implements ImageDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private final Bitmap.Config bitmapConfig;

    public SkiaImageDecoder() {
        this(null);
    }

    public SkiaImageDecoder(Bitmap.Config config) {
        this.bitmapConfig = config == null ? (config = Bitmap.Config.RGB_565) : config;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Bitmap decode(Context object, Uri object2) {
        void var1_8;
        block16: {
            Bitmap bitmap;
            block12: {
                int n10;
                BitmapFactory.Options options;
                block11: {
                    void var2_19;
                    InputStream inputStream;
                    block18: {
                        void var2_10;
                        block17: {
                            boolean bl2;
                            Object object3;
                            String string2;
                            block15: {
                                block13: {
                                    CharSequence charSequence;
                                    boolean bl3;
                                    int n11;
                                    int n12;
                                    List list;
                                    block14: {
                                        String string3;
                                        String string4;
                                        string2 = var2_10.toString();
                                        options = new BitmapFactory.Options();
                                        object3 = this.bitmapConfig;
                                        options.inPreferredConfig = object3;
                                        object3 = RESOURCE_PREFIX;
                                        bl2 = string2.startsWith((String)object3);
                                        if (!bl2) break block13;
                                        String string5 = var2_10.getAuthority();
                                        object3 = object.getPackageName();
                                        bl2 = ((String)object3).equals(string5);
                                        object3 = bl2 ? object.getResources() : object.getPackageManager().getResourcesForApplication(string5);
                                        list = var2_10.getPathSegments();
                                        n12 = list.size();
                                        int n13 = 2;
                                        n11 = 1;
                                        n10 = 0;
                                        if (n12 != n13 || (n13 = (int)((string4 = (String)list.get(0)).equals(string3 = "drawable") ? 1 : 0)) == 0) break block14;
                                        String string6 = (String)list.get(n11);
                                        n10 = object3.getIdentifier(string6, string3, string5);
                                        break block11;
                                    }
                                    if (n12 != n11 || !(bl3 = TextUtils.isDigitsOnly((CharSequence)(charSequence = (CharSequence)list.get(0))))) break block11;
                                    try {
                                        Object e10 = list.get(0);
                                        String string7 = (String)e10;
                                        n10 = Integer.parseInt(string7);
                                        break block11;
                                    }
                                    catch (NumberFormatException numberFormatException) {}
                                }
                                object3 = ASSET_PREFIX;
                                bl2 = string2.startsWith((String)object3);
                                boolean bl4 = false;
                                inputStream = null;
                                if (!bl2) break block15;
                                int n14 = 22;
                                String string8 = string2.substring(n14);
                                Bitmap bitmap2 = BitmapFactory.decodeStream((InputStream)object.getAssets().open(string8), null, (BitmapFactory.Options)options);
                                break block16;
                            }
                            object3 = FILE_PREFIX;
                            bl2 = string2.startsWith((String)object3);
                            if (!bl2) break block17;
                            int n15 = 7;
                            Bitmap bitmap3 = BitmapFactory.decodeFile((String)string2.substring(n15), (BitmapFactory.Options)options);
                            break block16;
                        }
                        ContentResolver contentResolver = object.getContentResolver();
                        InputStream inputStream2 = contentResolver.openInputStream((Uri)var2_10);
                        bitmap = BitmapFactory.decodeStream((InputStream)inputStream2, null, (BitmapFactory.Options)options);
                        if (inputStream2 == null) break block12;
                        try {
                            inputStream2.close();
                            break block12;
                        }
                        catch (Exception exception) {}
                        catch (Throwable throwable) {
                            inputStream = inputStream2;
                        }
                        break block18;
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    if (inputStream == null) throw var2_19;
                    try {
                        inputStream.close();
                    }
                    catch (Exception exception) {
                        throw var2_19;
                    }
                    throw var2_19;
                }
                Bitmap bitmap4 = BitmapFactory.decodeResource((Resources)object.getResources(), (int)n10, (BitmapFactory.Options)options);
                break block16;
            }
            Bitmap bitmap5 = bitmap;
        }
        if (var1_8 != null) {
            return var1_8;
        }
        RuntimeException runtimeException = new RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
        throw runtimeException;
    }
}

