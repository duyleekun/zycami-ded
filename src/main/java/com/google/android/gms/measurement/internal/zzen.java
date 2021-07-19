/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzem;
import com.google.android.gms.measurement.internal.zzeo;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzju;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzkf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public final class zzen
implements Runnable {
    public final /* synthetic */ zzeo zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzel zzd;
    private final String zze;
    private final Map zzf;

    public zzen(zzeo zzeo2, String string2, URL uRL, byte[] byArray, Map map, zzel zzel2) {
        this.zza = zzeo2;
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(uRL);
        Preconditions.checkNotNull(zzel2);
        this.zzb = uRL;
        this.zzc = byArray;
        this.zzd = zzel2;
        this.zze = string2;
        this.zzf = map;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final void run() {
        zzem zzem2;
        Object object;
        block40: {
            byte[] byArray;
            Serializable serializable;
            Map<String, List<String>> map;
            int n10;
            Object object2;
            Object object3;
            Object object4;
            Object object5;
            Object object6;
            Object object7;
            block35: {
                block37: {
                    block34: {
                        block39: {
                            Integer n11;
                            block38: {
                                block41: {
                                    boolean bl2;
                                    block36: {
                                        int n12;
                                        block33: {
                                            object = "Error closing HTTP compressed POST connection output stream. appId";
                                            this.zza.zzav();
                                            zzem2 = null;
                                            object7 = null;
                                            object6 = this.zza;
                                            object5 = this.zzb;
                                            object6 = ((zzeo)object6).zzc((URL)object5);
                                            object5 = this.zzf;
                                            if (object5 != null) {
                                                object5 = object5.entrySet();
                                                object5 = object5.iterator();
                                                while (bl2 = object5.hasNext()) {
                                                    object4 = object5.next();
                                                    object4 = (Map.Entry)object4;
                                                    object3 = object4.getKey();
                                                    object4 = object4.getValue();
                                                    object4 = (String)object4;
                                                    ((URLConnection)object6).addRequestProperty((String)object3, (String)object4);
                                                }
                                            }
                                            if ((object5 = (Object)this.zzc) == null) break block33;
                                            object5 = this.zza;
                                            object5 = ((zzju)object5).zza;
                                            object5 = ((zzkd)object5).zzn();
                                            object4 = this.zzc;
                                            object5 = ((zzkf)object5).zzs((byte[])object4);
                                            object4 = this.zza;
                                            object4 = ((zzge)object4).zzx;
                                            object4 = ((zzfl)object4).zzat();
                                            object4 = ((zzei)object4).zzk();
                                            n12 = ((Object)object5).length;
                                            object2 = "Uploading data. size";
                                            n11 = n12;
                                            ((zzeg)object4).zzb((String)object2, n11);
                                            bl2 = true;
                                            ((URLConnection)object6).setDoOutput(bl2);
                                            object4 = "Content-Encoding";
                                            object2 = "gzip";
                                            ((URLConnection)object6).addRequestProperty((String)object4, (String)object2);
                                            ((HttpURLConnection)object6).setFixedLengthStreamingMode(n12);
                                            ((URLConnection)object6).connect();
                                            object4 = ((URLConnection)object6).getOutputStream();
                                            try {
                                                ((OutputStream)object4).write((byte[])object5);
                                                ((OutputStream)object4).close();
                                            }
                                            catch (Throwable throwable) {
                                                n10 = 0;
                                                n11 = null;
                                                map = null;
                                                object7 = object4;
                                                break block34;
                                            }
                                            catch (IOException iOException) {
                                                n10 = 0;
                                                n11 = null;
                                                map = null;
                                                serializable = iOException;
                                                object7 = object4;
                                                break block35;
                                            }
                                        }
                                        n10 = ((HttpURLConnection)object6).getResponseCode();
                                        map = ((URLConnection)object6).getHeaderFields();
                                        object5 = new ByteArrayOutputStream();
                                        object4 = ((URLConnection)object6).getInputStream();
                                        n12 = 1024;
                                        try {
                                            int n13;
                                            object3 = new byte[n12];
                                            while ((n13 = ((InputStream)object4).read((byte[])object3)) > 0) {
                                                ((ByteArrayOutputStream)object5).write((byte[])object3, 0, n13);
                                            }
                                            byArray = ((ByteArrayOutputStream)object5).toByteArray();
                                            if (object4 == null) break block36;
                                        }
                                        catch (Throwable throwable) {}
                                        ((InputStream)object4).close();
                                    }
                                    if (object6 != null) {
                                        ((HttpURLConnection)object6).disconnect();
                                    }
                                    object = this.zza.zzx.zzau();
                                    object3 = this.zze;
                                    object2 = this.zzd;
                                    Object var14_31 = null;
                                    object4 = zzem2;
                                    zzem2 = new zzem((String)object3, (zzel)object2, n10, null, byArray, map, null);
                                    break block40;
                                    break block41;
                                    catch (Throwable throwable) {
                                        bl2 = false;
                                        object4 = null;
                                    }
                                }
                                if (object4 == null) throw zzem2;
                                try {
                                    ((InputStream)object4).close();
                                    throw zzem2;
                                }
                                catch (Throwable throwable) {
                                    object5 = throwable;
                                    break block34;
                                }
                                catch (IOException iOException) {
                                    object5 = iOException;
                                    break block37;
                                }
                                catch (Throwable throwable) {
                                    break block38;
                                }
                                catch (IOException iOException) {
                                    break block39;
                                }
                                catch (Throwable throwable) {
                                    n10 = 0;
                                    n11 = null;
                                }
                            }
                            map = null;
                            break block34;
                            catch (IOException iOException) {
                                n10 = 0;
                                n11 = null;
                            }
                        }
                        map = null;
                        break block37;
                        catch (Throwable throwable) {
                            n10 = 0;
                            Object var11_26 = null;
                            object6 = null;
                            map = null;
                        }
                    }
                    if (object7 != null) {
                        try {
                            ((OutputStream)object7).close();
                        }
                        catch (IOException iOException) {
                            object7 = this.zza.zzx.zzat().zzb();
                            object4 = zzei.zzl(this.zze);
                            ((zzeg)object7).zzc((String)object, object4, iOException);
                        }
                    }
                    if (object6 != null) {
                        ((HttpURLConnection)object6).disconnect();
                    }
                    object = this.zza.zzx.zzau();
                    object3 = this.zze;
                    object2 = this.zzd;
                    object4 = zzem2;
                    zzem2 = new zzem((String)object3, (zzel)object2, n10, null, null, map, null);
                    ((zzfi)object).zzh(zzem2);
                    throw object5;
                    catch (IOException iOException) {
                        n10 = 0;
                        Object var11_27 = null;
                        object6 = null;
                        map = null;
                    }
                }
                serializable = object5;
            }
            if (object7 != null) {
                try {
                    ((OutputStream)object7).close();
                }
                catch (IOException iOException) {
                    object7 = this.zza.zzx.zzat().zzb();
                    object5 = zzei.zzl(this.zze);
                    ((zzeg)object7).zzc((String)object, object5, iOException);
                }
            }
            if (object6 != null) {
                ((HttpURLConnection)object6).disconnect();
            }
            object = this.zza.zzx.zzau();
            object3 = this.zze;
            object2 = this.zzd;
            byArray = null;
            object4 = zzem2;
            zzem2 = new zzem((String)object3, (zzel)object2, n10, (Throwable)serializable, null, map, null);
        }
        ((zzfi)object).zzh(zzem2);
    }
}

