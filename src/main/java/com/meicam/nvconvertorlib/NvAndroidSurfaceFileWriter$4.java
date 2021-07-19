/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.nvconvertorlib;

import com.meicam.nvconvertorlib.Logger;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter;
import com.meicam.nvconvertorlib.NvVideoFrame;
import java.nio.ByteBuffer;

public class NvAndroidSurfaceFileWriter$4
implements Runnable {
    public final /* synthetic */ NvAndroidSurfaceFileWriter this$0;

    public NvAndroidSurfaceFileWriter$4(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter) {
        this.this$0 = nvAndroidSurfaceFileWriter;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        block25: {
            block30: {
                var1_1 = null;
                var2_3 = false;
                var3_4 = null;
                do {
                    block29: {
                        var4_5 = this.this$0;
                        var5_6 = var4_5.mRelease;
                        if (var5_6) break block25;
                        if ((var4_5 = NvAndroidSurfaceFileWriter.access$100((NvAndroidSurfaceFileWriter)var4_5)) == null) {
                            return;
                        }
                        var4_5 = NvAndroidSurfaceFileWriter.access$200(this.this$0);
                        synchronized (var4_5) {
                            block28: {
                                block26: {
                                    var5_6 = false;
                                    var6_7 = null;
                                    try {
                                        block27: {
                                            try {
                                                var7_8 = this.this$0;
                                                var7_8 = NvAndroidSurfaceFileWriter.access$100((NvAndroidSurfaceFileWriter)var7_8);
                                                var8_9 = var7_8.size();
                                                if (var8_9 != 0) ** GOTO lbl-1000
                                                var7_8 = "wait";
                                                var9_10 = "m_audioArraySyncObject111";
                                                Logger.e((String)var7_8, var9_10);
                                                var7_8 = this.this$0;
                                                var7_8 = NvAndroidSurfaceFileWriter.access$200((NvAndroidSurfaceFileWriter)var7_8);
                                                var7_8.wait();
                                                var7_8 = "wait";
                                                var9_10 = "m_audioArraySyncObject222";
                                                Logger.e((String)var7_8, var9_10);
                                                var7_8 = this.this$0;
                                                var7_8 = NvAndroidSurfaceFileWriter.access$100((NvAndroidSurfaceFileWriter)var7_8);
                                                var8_9 = var7_8.size();
                                                if (var8_9 <= 0) break block26;
                                                var7_8 = this.this$0;
                                                var7_8 = NvAndroidSurfaceFileWriter.access$100((NvAndroidSurfaceFileWriter)var7_8);
                                                var7_8 = var7_8.get(0);
                                                var7_8 = (NvVideoFrame)var7_8;
                                                break block27;
                                            }
                                            catch (Exception v0) {}
                                            break block26;
                                            catch (InterruptedException var9_12) {
                                                var8_9 = 0;
                                                var7_8 = null;
                                                break block28;
                                            }
                                        }
                                        try {
                                            var9_10 = this.this$0;
                                            var9_10 = NvAndroidSurfaceFileWriter.access$100((NvAndroidSurfaceFileWriter)var9_10);
                                            var9_10.remove(0);
                                            break block29;
                                        }
                                        catch (InterruptedException var9_11) {
                                            break block28;
                                        }
                                    }
                                    catch (Throwable var1_2) {
                                        ** break block31
                                    }
                                }
                                var8_9 = 0;
                                var7_8 = null;
                                break block29;
                            }
                            var10_13 = "SurfaceFileWriter";
                            try {
                                var11_14 = new StringBuilder();
                                var12_15 = "";
                                var11_14.append((String)var12_15);
                                var12_15 = var9_10.getMessage();
                                var11_14.append((String)var12_15);
                                var11_14 = var11_14.toString();
                                Logger.e(var10_13, var11_14);
                                var9_10.printStackTrace();
                                break block29;
                            }
                            catch (Exception v1) {}
lbl-1000:
                            // 1 sources

                            {
                                var7_8 = this.this$0;
                                var7_8 = NvAndroidSurfaceFileWriter.access$100((NvAndroidSurfaceFileWriter)var7_8);
                                var7_8 = var7_8.get(0);
                                var7_8 = (NvVideoFrame)var7_8;
                            }
                            var9_10 = this.this$0;
                            var9_10 = NvAndroidSurfaceFileWriter.access$100((NvAndroidSurfaceFileWriter)var9_10);
                            var9_10.remove(0);
                        }
                    }
                    var13_16 = true;
                    if (var7_8 == null) {
                        if (var2_3) {
                            try {
                                var7_8 = this.this$0;
                                var14_17 = 0L;
                                NvAndroidSurfaceFileWriter.access$300((NvAndroidSurfaceFileWriter)var7_8, null, var14_17);
                            }
                            catch (Exception v2) {
                                var11_14 = this.this$0;
                                var12_15 = null;
                                var16_18 = 0L;
                                var18_19 = 64;
                                NvAndroidSurfaceFileWriter.access$400((NvAndroidSurfaceFileWriter)var11_14, null, var16_18, 0, 0, var18_19);
                                var3_4 = NvAndroidSurfaceFileWriter.access$500(this.this$0);
                                var3_4.onCatchException();
                                var2_3 = var13_16;
                            }
                            continue;
                        }
                        if (var7_8 != null && (var6_7 = var7_8.buffer) != null) continue;
                        var1_1 = this.this$0;
                        NvAndroidSurfaceFileWriter.access$602(var1_1, var13_16);
                        break block25;
                    }
                    if (!var2_3) {
                        try {
                            var6_7 = this.this$0;
                            var9_10 = var7_8.buffer;
                            var19_20 = var7_8.streamTime;
                            NvAndroidSurfaceFileWriter.access$300((NvAndroidSurfaceFileWriter)var6_7, (ByteBuffer)var9_10, var19_20);
                        }
                        catch (Exception v3) {
                            var12_15 = this.this$0;
                            var21_21 = 0L;
                            var18_19 = 0;
                            var23_22 = 64;
                            NvAndroidSurfaceFileWriter.access$400((NvAndroidSurfaceFileWriter)var12_15, null, var21_21, 0, 0, var23_22);
                            var3_4 = NvAndroidSurfaceFileWriter.access$500(this.this$0);
                            var3_4.onCatchException();
                            var2_3 = var13_16;
                        }
                        var4_5 = NvAndroidSurfaceFileWriter.access$700(this.this$0);
                        if (var4_5 == null) continue;
                        var4_5 = NvAndroidSurfaceFileWriter.access$700(this.this$0);
                        var4_5.returnToPool((NvVideoFrame)var7_8);
                        continue;
                    }
                    if (var7_8 == null || (var6_7 = var7_8.buffer) == null) break block30;
                } while (!(var13_16 = NvAndroidSurfaceFileWriter.access$600((NvAndroidSurfaceFileWriter)(var4_5 = this.this$0))));
                break block25;
            }
            var1_1 = this.this$0;
            NvAndroidSurfaceFileWriter.access$602(var1_1, var13_16);
            break block25;
lbl-1000:
            // 1 sources

            {
                throw var1_2;
            }
        }
        NvAndroidSurfaceFileWriter.access$400(this.this$0, null, 0L, 0, 0, 64);
    }
}

