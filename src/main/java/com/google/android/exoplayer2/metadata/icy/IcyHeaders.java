/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders$1;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.Map;

public final class IcyHeaders
implements Metadata$Entry {
    public static final Parcelable.Creator CREATOR;
    public static final String REQUEST_HEADER_ENABLE_METADATA_NAME = "Icy-MetaData";
    public static final String REQUEST_HEADER_ENABLE_METADATA_VALUE = "1";
    private static final String RESPONSE_HEADER_BITRATE = "icy-br";
    private static final String RESPONSE_HEADER_GENRE = "icy-genre";
    private static final String RESPONSE_HEADER_METADATA_INTERVAL = "icy-metaint";
    private static final String RESPONSE_HEADER_NAME = "icy-name";
    private static final String RESPONSE_HEADER_PUB = "icy-pub";
    private static final String RESPONSE_HEADER_URL = "icy-url";
    private static final String TAG = "IcyHeaders";
    public final int bitrate;
    public final String genre;
    public final boolean isPublic;
    public final int metadataInterval;
    public final String name;
    public final String url;

    static {
        IcyHeaders$1 icyHeaders$1 = new IcyHeaders$1();
        CREATOR = icyHeaders$1;
    }

    public IcyHeaders(int n10, String string2, String string3, String string4, boolean bl2, int n11) {
        int n12 = -1;
        n12 = n11 != n12 && n11 <= 0 ? 0 : 1;
        Assertions.checkArgument(n12 != 0);
        this.bitrate = n10;
        this.genre = string2;
        this.name = string3;
        this.url = string4;
        this.isPublic = bl2;
        this.metadataInterval = n11;
    }

    public IcyHeaders(Parcel parcel) {
        int n10;
        String string2;
        int n11;
        this.bitrate = n11 = parcel.readInt();
        this.genre = string2 = parcel.readString();
        this.name = string2 = parcel.readString();
        this.url = string2 = parcel.readString();
        n11 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.isPublic = n11;
        this.metadataInterval = n10 = parcel.readInt();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static IcyHeaders parse(Map var0) {
        block28: {
            block27: {
                var1_1 = "Invalid metadata interval: ";
                var2_2 = (List)var0.get("icy-br");
                var3_3 = "IcyHeaders";
                var4_4 = -1;
                var5_5 = 1;
                var6_6 = 1.4E-45f;
                var7_7 = 0;
                if (var2_2 != null) {
                    var2_2 = (String)var2_2.get(0);
                    var8_8 = Integer.parseInt((String)var2_2) * 1000;
                    if (var8_8 <= 0) {
                        var11_11 = "Invalid bitrate: ";
                    }
                    var9_9 = var5_5;
                    var10_10 = var6_6;
lbl17:
                    // 2 sources

                    while (true) {
                        var14_15 = var8_8;
lbl19:
                        // 2 sources

                        while (true) {
                            var16_16 = (List)var0.get("icy-genre");
                            var15_14 = 0;
                            var12_12 = null;
                            if (var16_16 != null) {
                                var17_17 = var2_2 = (String)var16_16.get(0);
                                var9_9 = var5_5;
                                var10_10 = var6_6;
                            } else {
                                var13_13 = 0;
                                var17_17 = null;
                            }
                            var16_16 = (List)var0.get("icy-name");
                            if (var16_16 != null) {
                                var18_18 = var2_2 = (String)var16_16.get(0);
                                var9_9 = var5_5;
                                var10_10 = var6_6;
                            } else {
                                var18_18 = null;
                            }
                            var16_16 = (List)var0.get("icy-url");
                            if (var16_16 != null) {
                                var19_19 = var2_2 = (String)var16_16.get(0);
                                var9_9 = var5_5;
                                var10_10 = var6_6;
                            } else {
                                var20_20 = 0;
                                var19_19 = null;
                            }
                            var16_16 = (List)var0.get("icy-pub");
                            if (var16_16 != null) {
                                var2_2 = (String)var16_16.get(0);
                                var16_16 = "1";
                                var21_21 = var2_2.equals(var16_16);
                                var9_9 = var5_5;
                                var10_10 = var6_6;
                            } else {
                                var21_21 = 0;
                            }
                            var16_16 = "icy-metaint";
                            var0 = (List)var0.get(var16_16);
                            if (var0 != null) {
                                var0 = (String)var0.get(0);
                                var7_7 = Integer.parseInt((String)var0);
                                if (var7_7 <= 0) break block27;
                                var4_4 = var7_7;
                                break block28;
                            }
lbl63:
                            // 4 sources

                            while (true) {
                                if (var9_9 == 0) return var12_12;
                                var16_16 = var0;
                                var12_12 = var17_17;
                                var17_17 = var18_18;
                                var18_18 = var19_19;
                                var20_20 = var21_21;
                                var21_21 = var4_4;
                                var0 = new IcyHeaders(var14_15, (String)var12_12, (String)var17_17, (String)var19_19, (boolean)var20_20, var4_4);
                                return var0;
                            }
                            break;
                        }
                        break;
                    }
                    try {
                        var12_12 = String.valueOf(var2_2);
                        var13_13 = var12_12.length();
                        if (var13_13 != 0) {
                            var11_11 = var11_11.concat((String)var12_12);
                        } else {
                            var12_12 = new String(var11_11);
                            var11_11 = var12_12;
                        }
                        Log.w(var3_3, var11_11);
                        var8_8 = var4_4;
                    }
                    catch (NumberFormatException v1) {
                        ** continue;
                    }
lbl83:
                    // 2 sources

                    while (true) {
                        var9_9 = 0;
                        var2_2 = null;
                        var10_10 = 0.0f;
                        ** continue;
                        break;
                    }
                    catch (NumberFormatException v0) {
                        var8_8 = var4_4;
lbl90:
                        // 2 sources

                        while (true) {
                            var11_11 = "Invalid bitrate header: ";
                            var15_14 = (var2_2 = String.valueOf(var2_2)).length();
                            var2_2 = var15_14 != 0 ? var11_11.concat((String)var2_2) : new String(var11_11);
                            Log.w(var3_3, (String)var2_2);
                            ** continue;
                            break;
                        }
                    }
                }
                var14_15 = var4_4;
                var9_9 = 0;
                var2_2 = null;
                var10_10 = 0.0f;
                ** while (true)
            }
            try {
                var22_22 = String.valueOf(var0);
                var8_8 = var22_22.length();
                var22_22 = var8_8 != 0 ? var1_1.concat(var22_22) : new String(var1_1);
                Log.w(var3_3, var22_22);
                var5_5 = var9_9;
                var6_6 = var10_10;
            }
            catch (NumberFormatException v2) {
                var4_4 = var7_7;
lbl113:
                // 2 sources

                while (true) {
                    var5_5 = (var0 = String.valueOf(var0)).length();
                    var0 = var5_5 != 0 ? var1_1.concat((String)var0) : new String(var1_1);
                    Log.w(var3_3, (String)var0);
                    ** continue;
                    break;
                }
            }
        }
        var9_9 = var5_5;
        var10_10 = var6_6;
        ** GOTO lbl63
        catch (NumberFormatException v3) {
            ** continue;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = IcyHeaders.class) == (object2 = object.getClass())) {
            int n10;
            object = (IcyHeaders)object;
            int n11 = this.bitrate;
            int n12 = ((IcyHeaders)object).bitrate;
            if (n11 != n12 || (n11 = (int)(Util.areEqual(object3 = this.genre, object2 = ((IcyHeaders)object).genre) ? 1 : 0)) == 0 || (n11 = (int)(Util.areEqual(object3 = this.name, object2 = ((IcyHeaders)object).name) ? 1 : 0)) == 0 || (n11 = (int)(Util.areEqual(object3 = this.url, object2 = ((IcyHeaders)object).url) ? 1 : 0)) == 0 || (n11 = (int)(this.isPublic ? 1 : 0)) != (n12 = (int)(((IcyHeaders)object).isPublic ? 1 : 0)) || (n11 = this.metadataInterval) != (n10 = ((IcyHeaders)object).metadataInterval)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.bitrate;
        int n11 = (527 + n10) * 31;
        String string2 = this.genre;
        int n12 = 0;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        n11 = (n11 + n10) * 31;
        string2 = this.name;
        if (string2 != null) {
            n10 = string2.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        n11 = (n11 + n10) * 31;
        string2 = this.url;
        if (string2 != null) {
            n12 = string2.hashCode();
        }
        n11 = (n11 + n12) * 31;
        n10 = (int)(this.isPublic ? 1 : 0);
        n11 = (n11 + n10) * 31;
        n10 = this.metadataInterval;
        return n11 + n10;
    }

    public String toString() {
        String string2 = this.name;
        String string3 = this.genre;
        int n10 = this.bitrate;
        int n11 = this.metadataInterval;
        int n12 = String.valueOf(string2).length() + 80;
        int n13 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n12 += n13);
        stringBuilder.append("IcyHeaders: name=\"");
        stringBuilder.append(string2);
        stringBuilder.append("\", genre=\"");
        stringBuilder.append(string3);
        stringBuilder.append("\", bitrate=");
        stringBuilder.append(n10);
        stringBuilder.append(", metadataInterval=");
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.bitrate;
        parcel.writeInt(n10);
        String string2 = this.genre;
        parcel.writeString(string2);
        string2 = this.name;
        parcel.writeString(string2);
        string2 = this.url;
        parcel.writeString(string2);
        n10 = (int)(this.isPublic ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        n10 = this.metadataInterval;
        parcel.writeInt(n10);
    }
}

