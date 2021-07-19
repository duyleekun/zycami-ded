/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.NativeSessionFile;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

public class BytesBackedNativeSessionFile
implements NativeSessionFile {
    private final byte[] bytes;
    private final String dataTransportFilename;
    private final String reportsEndpointFilename;

    public BytesBackedNativeSessionFile(String string2, String string3, byte[] byArray) {
        this.dataTransportFilename = string2;
        this.reportsEndpointFilename = string3;
        this.bytes = byArray;
    }

    /*
     * Unable to fully structure code
     */
    private byte[] asGzippedBytes() {
        var1_1 = this.isEmpty();
        if (var1_1) {
            return null;
        }
        var2_2 = new ByteArrayOutputStream();
        var3_3 = new GZIPOutputStream(var2_2);
        var4_5 = this.bytes;
        var3_3.write(var4_5);
        var3_3.finish();
        var4_5 = var2_2.toByteArray();
        var3_3.close();
        var2_2.close();
        return var4_5;
        catch (Throwable var4_6) {
            var3_3.close();
lbl22:
            // 2 sources

            while (true) {
                try {
                    throw var4_6;
                }
                catch (Throwable var3_4) {
                    var2_2.close();
lbl28:
                    // 2 sources

                    while (true) {
                        throw var3_4;
                        break;
                    }
                }
                break;
            }
        }
lbl31:
        // 1 sources

        return null;
        {
            catch (Throwable v0) {
                ** continue;
            }
            {
                catch (Throwable v1) {
                    ** continue;
                }
                catch (IOException v2) {
                    ** continue;
                }
            }
        }
    }

    private boolean isEmpty() {
        boolean bl2;
        byte[] byArray = this.bytes;
        if (byArray != null && (bl2 = byArray.length)) {
            bl2 = false;
            byArray = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public CrashlyticsReport$FilesPayload$File asFilePayload() {
        Object object = this.asGzippedBytes();
        if (object == null) {
            object = null;
        } else {
            object = CrashlyticsReport$FilesPayload$File.builder().setContents((byte[])object);
            String string2 = this.dataTransportFilename;
            object = object.setFilename(string2).build();
        }
        return object;
    }

    public String getReportsEndpointFilename() {
        return this.reportsEndpointFilename;
    }

    public InputStream getStream() {
        ByteArrayInputStream byteArrayInputStream;
        boolean bl2 = this.isEmpty();
        if (bl2) {
            bl2 = false;
            byteArrayInputStream = null;
        } else {
            byte[] byArray = this.bytes;
            byteArrayInputStream = new ByteArrayInputStream(byArray);
        }
        return byteArrayInputStream;
    }
}

