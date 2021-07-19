/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.util.Base64
 */
package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.phenotype.zzj;
import com.google.android.gms.phenotype.zzk;
import com.google.android.gms.phenotype.zzn;
import java.util.Arrays;
import java.util.Comparator;

public final class zzi
extends AbstractSafeParcelable
implements Comparable {
    public static final Parcelable.Creator CREATOR;
    private static final Comparator zzai;
    public final String name;
    private final long zzab;
    private final boolean zzac;
    private final double zzad;
    private final String zzae;
    private final byte[] zzaf;
    private final int zzag;
    public final int zzah;

    static {
        Object object = new zzk();
        CREATOR = object;
        zzai = object = new zzj();
    }

    public zzi(String string2, long l10, boolean bl2, double d10, String string3, byte[] byArray, int n10, int n11) {
        this.name = string2;
        this.zzab = l10;
        this.zzac = bl2;
        this.zzad = d10;
        this.zzae = string3;
        this.zzaf = byArray;
        this.zzag = n10;
        this.zzah = n11;
    }

    private static int compare(int n10, int n11) {
        if (n10 < n11) {
            return -1;
        }
        if (n10 == n11) {
            return 0;
        }
        return 1;
    }

    public final /* synthetic */ int compareTo(Object object) {
        object = (zzi)object;
        Object object2 = this.name;
        Object object3 = ((zzi)object).name;
        Object object4 = ((String)object2).compareTo((String)object3);
        if (object4 != 0) {
            return object4;
        }
        object4 = this.zzag;
        Object object5 = ((zzi)object).zzag;
        if ((object4 = zzi.compare(object4, object5)) != 0) {
            return object4;
        }
        object4 = this.zzag;
        object5 = -1;
        int n10 = 0;
        StringBuilder stringBuilder = null;
        int n11 = 1;
        if (object4 != n11) {
            int n12 = 2;
            if (object4 != n12) {
                n12 = 3;
                if (object4 != n12) {
                    n12 = 4;
                    if (object4 != n12) {
                        n12 = 5;
                        if (object4 == n12) {
                            object2 = this.zzaf;
                            byte[] byArray = ((zzi)object).zzaf;
                            if (object2 == byArray) {
                                return 0;
                            }
                            if (object2 == null) {
                                return object5;
                            }
                            if (byArray == null) {
                                return n11;
                            }
                            while (true) {
                                object2 = this.zzaf;
                                object4 = ((Object)object2).length;
                                object3 = ((zzi)object).zzaf;
                                object5 = ((Object)object3).length;
                                if (n10 >= (object4 = Math.min(object4, object5))) break;
                                object2 = this.zzaf;
                                object4 = object2[n10];
                                object3 = ((zzi)object).zzaf;
                                object5 = object3[n10];
                                if ((object4 -= object5) != 0) {
                                    return object4;
                                }
                                ++n10;
                            }
                            object4 = this.zzaf.length;
                            int n13 = ((zzi)object).zzaf.length;
                            return zzi.compare(object4, n13);
                        }
                        object4 = this.zzag;
                        stringBuilder = new StringBuilder(31);
                        stringBuilder.append("Invalid enum value: ");
                        stringBuilder.append((int)object4);
                        object2 = stringBuilder.toString();
                        object = new AssertionError(object2);
                        throw object;
                    }
                    object2 = this.zzae;
                    object = ((zzi)object).zzae;
                    if (object2 == object) {
                        return 0;
                    }
                    if (object2 == null) {
                        return object5;
                    }
                    if (object == null) {
                        return n11;
                    }
                    return ((String)object2).compareTo((String)object);
                }
                double d10 = this.zzad;
                double d11 = ((zzi)object).zzad;
                return Double.compare(d10, d11);
            }
            object4 = this.zzac;
            int n14 = ((zzi)object).zzac;
            if (object4 == n14) {
                return 0;
            }
            if (object4 != 0) {
                return n11;
            }
            return object5;
        }
        long l10 = this.zzab;
        long l11 = ((zzi)object).zzab;
        long l12 = l10 - l11;
        Object object6 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object6 < 0) {
            return object5;
        }
        if (object6 == false) {
            return 0;
        }
        return n11;
    }

    public final boolean equals(Object object) {
        int n10 = object instanceof zzi;
        int n11 = 0;
        if (n10 != 0) {
            int n12;
            int n13;
            object = (zzi)object;
            Object object2 = this.name;
            CharSequence charSequence = ((zzi)object).name;
            n10 = zzn.equals(object2, charSequence);
            if (n10 != 0 && (n10 = this.zzag) == (n13 = ((zzi)object).zzag) && (n13 = this.zzah) == (n12 = ((zzi)object).zzah)) {
                n13 = 1;
                if (n10 != n13) {
                    n12 = 2;
                    if (n10 != n12) {
                        n12 = 3;
                        if (n10 != n12) {
                            n11 = 4;
                            if (n10 != n11) {
                                n11 = 5;
                                if (n10 == n11) {
                                    object2 = this.zzaf;
                                    object = ((zzi)object).zzaf;
                                    return Arrays.equals((byte[])object2, (byte[])object);
                                }
                                n10 = this.zzag;
                                charSequence = new StringBuilder(31);
                                ((StringBuilder)charSequence).append("Invalid enum value: ");
                                ((StringBuilder)charSequence).append(n10);
                                object2 = ((StringBuilder)charSequence).toString();
                                object = new AssertionError(object2);
                                throw object;
                            }
                            object2 = this.zzae;
                            object = ((zzi)object).zzae;
                            return zzn.equals(object2, object);
                        }
                        double d10 = this.zzad;
                        double d11 = ((zzi)object).zzad;
                        double d12 = d10 - d11;
                        Object object3 = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
                        if (object3 == false) {
                            return n13 != 0;
                        }
                        return false;
                    }
                    n10 = (int)(this.zzac ? 1 : 0);
                    int n14 = ((zzi)object).zzac;
                    if (n10 == n14) {
                        return n13 != 0;
                    }
                    return false;
                }
                long l10 = this.zzab;
                long l11 = ((zzi)object).zzab;
                long l12 = l10 - l11;
                Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object4 == false) {
                    return n13 != 0;
                }
            }
        }
        return false;
    }

    public final String toString() {
        int n10;
        String string2;
        Object object;
        block6: {
            block0: {
                block1: {
                    block2: {
                        Object object2;
                        CharSequence charSequence;
                        block7: {
                            block3: {
                                int n11;
                                int n12;
                                block4: {
                                    block5: {
                                        object = new StringBuilder();
                                        ((StringBuilder)object).append("Flag(");
                                        string2 = this.name;
                                        ((StringBuilder)object).append(string2);
                                        string2 = ", ";
                                        ((StringBuilder)object).append(string2);
                                        n10 = this.zzag;
                                        n12 = 1;
                                        if (n10 == n12) break block0;
                                        n12 = 2;
                                        if (n10 == n12) break block1;
                                        n12 = 3;
                                        if (n10 == n12) break block2;
                                        n11 = 4;
                                        charSequence = "'";
                                        if (n10 == n11) break block3;
                                        n11 = 5;
                                        if (n10 != n11) break block4;
                                        object2 = this.zzaf;
                                        if (object2 != null) break block5;
                                        object2 = "null";
                                        ((StringBuilder)object).append((String)object2);
                                        break block6;
                                    }
                                    ((StringBuilder)object).append((String)charSequence);
                                    object2 = Base64.encodeToString((byte[])this.zzaf, (int)n12);
                                    break block7;
                                }
                                String string3 = this.name;
                                n12 = this.zzag;
                                n11 = String.valueOf(string3).length() + 27;
                                charSequence = new StringBuilder(n11);
                                ((StringBuilder)charSequence).append("Invalid type: ");
                                ((StringBuilder)charSequence).append(string3);
                                ((StringBuilder)charSequence).append(string2);
                                ((StringBuilder)charSequence).append(n12);
                                string2 = ((StringBuilder)charSequence).toString();
                                object = new AssertionError((Object)string2);
                                throw object;
                            }
                            ((StringBuilder)object).append((String)charSequence);
                            object2 = this.zzae;
                        }
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append((String)charSequence);
                        break block6;
                    }
                    double d10 = this.zzad;
                    ((StringBuilder)object).append(d10);
                    break block6;
                }
                n10 = (int)(this.zzac ? 1 : 0);
                ((StringBuilder)object).append(n10 != 0);
                break block6;
            }
            long l10 = this.zzab;
            ((StringBuilder)object).append(l10);
        }
        ((StringBuilder)object).append(string2);
        n10 = this.zzag;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(string2);
        int n13 = this.zzah;
        ((StringBuilder)object).append(n13);
        ((StringBuilder)object).append(")");
        return ((StringBuilder)object).toString();
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        Object object = this.name;
        SafeParcelWriter.writeString(parcel, 2, (String)object, false);
        long l10 = this.zzab;
        SafeParcelWriter.writeLong(parcel, 3, l10);
        int n11 = this.zzac;
        SafeParcelWriter.writeBoolean(parcel, 4, n11 != 0);
        double d10 = this.zzad;
        SafeParcelWriter.writeDouble(parcel, 5, d10);
        object = this.zzae;
        SafeParcelWriter.writeString(parcel, 6, (String)object, false);
        object = this.zzaf;
        SafeParcelWriter.writeByteArray(parcel, 7, (byte[])object, false);
        n11 = this.zzag;
        SafeParcelWriter.writeInt(parcel, 8, n11);
        n11 = this.zzah;
        SafeParcelWriter.writeInt(parcel, 9, n11);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

