/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfj;
import com.google.android.gms.measurement.internal.zzhp;
import com.google.android.gms.measurement.internal.zzhr;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public final class zzhq
implements Runnable {
    public final /* synthetic */ zzhr zza;
    private final URL zzb;
    private final String zzc;
    private final zzfj zzd;

    public zzhq(zzhr zzhr2, String string2, URL uRL, byte[] byArray, Map map, zzfj zzfj2, byte[] byArray2) {
        this.zza = zzhr2;
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(uRL);
        Preconditions.checkNotNull(zzfj2);
        this.zzb = uRL;
        this.zzd = zzfj2;
        this.zzc = string2;
    }

    private final void zzb(int n10, Exception exception, byte[] byArray, Map map) {
        zzfi zzfi2 = this.zza.zzx.zzau();
        zzhp zzhp2 = new zzhp(this, n10, exception, byArray, map);
        zzfi2.zzh(zzhp2);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final void run() {
        Map<String, List<String>> map;
        int n10;
        Object object;
        Object object2;
        block24: {
            block23: {
                InputStream inputStream;
                block25: {
                    block22: {
                        this.zza.zzav();
                        object2 = null;
                        object = this.zza;
                        URL uRL = this.zzb;
                        object = ((zzhr)object).zzd(uRL);
                        n10 = ((HttpURLConnection)object).getResponseCode();
                        map = ((URLConnection)object).getHeaderFields();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        inputStream = ((URLConnection)object).getInputStream();
                        int n11 = 1024;
                        try {
                            int n12;
                            byte[] byArray = new byte[n11];
                            while ((n12 = inputStream.read(byArray)) > 0) {
                                byteArrayOutputStream.write(byArray, 0, n12);
                            }
                            object2 = byteArrayOutputStream.toByteArray();
                            if (inputStream == null) break block22;
                        }
                        catch (Throwable throwable) {}
                        inputStream.close();
                    }
                    if (object != null) {
                        ((HttpURLConnection)object).disconnect();
                    }
                    this.zzb(n10, null, (byte[])object2, map);
                    return;
                    break block25;
                    catch (Throwable throwable) {
                        inputStream = null;
                    }
                }
                if (inputStream == null) throw object2;
                try {
                    inputStream.close();
                    throw object2;
                }
                catch (Throwable throwable) {}
                catch (IOException iOException) {}
                finally {
                    break block23;
                }
                catch (Throwable throwable) {
                    map = null;
                    break block23;
                }
                catch (IOException iOException) {
                    map = null;
                    break block24;
                }
                catch (Throwable throwable) {
                    map = null;
                    Throwable throwable2 = throwable;
                    n10 = 0;
                    Object var3_13 = null;
                    object2 = throwable2;
                    break block23;
                }
                catch (IOException iOException) {
                    map = null;
                    IOException iOException2 = iOException;
                    n10 = 0;
                    Object var3_15 = null;
                    object2 = iOException2;
                    break block24;
                }
                catch (Throwable throwable) {
                    n10 = 0;
                    Object var3_16 = null;
                    map = null;
                    object2 = throwable;
                    object = null;
                }
            }
            if (object != null) {
                ((HttpURLConnection)object).disconnect();
            }
            this.zzb(n10, null, null, map);
            throw object2;
            catch (IOException iOException) {
                n10 = 0;
                Object var3_17 = null;
                map = null;
                object2 = iOException;
                object = null;
            }
        }
        if (object != null) {
            ((HttpURLConnection)object).disconnect();
        }
        this.zzb(n10, (Exception)object2, null, map);
    }

    public final /* synthetic */ void zza(int n10, Exception exception, byte[] byArray, Map map) {
        zzfj zzfj2 = this.zzd;
        String string2 = this.zzc;
        zzfj2.zza(string2, n10, exception, byArray, map);
    }
}

