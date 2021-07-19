/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package d.v.c.t0;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig$Resolution;
import com.zhiyun.cama.publish.UploadCEMediaInfo;
import d.v.c.t0.w$a;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

public class w
implements NavArgs {
    private final HashMap a;

    private w() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private w(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ w(HashMap hashMap, w$a w$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(w w10) {
        return w10.a;
    }

    public static w b(Bundle object) {
        Object object2 = CompositeConfig$Resolution.class;
        Object object3 = new w();
        Object object4 = w.class.getClassLoader();
        object.setClassLoader((ClassLoader)object4);
        object4 = "templateId";
        boolean bl2 = object.containsKey((String)object4);
        if (bl2) {
            long l10 = object.getLong((String)object4);
            HashMap hashMap = ((w)object3).a;
            Object object5 = Long.valueOf(l10);
            hashMap.put(object4, object5);
            object4 = "mediaArr";
            bl2 = object.containsKey((String)object4);
            if (bl2) {
                UploadCEMediaInfo[] uploadCEMediaInfoArray;
                object5 = object.getParcelableArray((String)object4);
                if (object5 != null) {
                    int n10 = ((Parcelable[])object5).length;
                    uploadCEMediaInfoArray = new UploadCEMediaInfo[n10];
                    int n11 = ((Parcelable[])object5).length;
                    System.arraycopy(object5, 0, uploadCEMediaInfoArray, 0, n11);
                } else {
                    boolean bl3 = false;
                    uploadCEMediaInfoArray = null;
                }
                if (uploadCEMediaInfoArray != null) {
                    object5 = ((w)object3).a;
                    ((HashMap)object5).put(object4, uploadCEMediaInfoArray);
                    object4 = "resolution";
                    bl2 = object.containsKey((String)object4);
                    if (bl2) {
                        object5 = Parcelable.class;
                        bl2 = ((Class)object5).isAssignableFrom((Class<?>)object2);
                        if (!bl2 && !(bl2 = ((Class)(object5 = Serializable.class)).isAssignableFrom((Class<?>)object2))) {
                            object3 = new StringBuilder();
                            object2 = ((Class)object2).getName();
                            ((StringBuilder)object3).append((String)object2);
                            ((StringBuilder)object3).append(" must implement Parcelable or Serializable or must be an Enum.");
                            object2 = ((StringBuilder)object3).toString();
                            object = new UnsupportedOperationException((String)object2);
                            throw object;
                        }
                        if ((object = (CompositeConfig$Resolution)((Object)object.get((String)object4))) != null) {
                            ((w)object3).a.put(object4, object);
                            return object3;
                        }
                        object = new IllegalArgumentException("Argument \"resolution\" is marked as non-null but was passed a null value.");
                        throw object;
                    }
                    object = new IllegalArgumentException("Required argument \"resolution\" is missing and does not have an android:defaultValue");
                    throw object;
                }
                object = new IllegalArgumentException("Argument \"mediaArr\" is marked as non-null but was passed a null value.");
                throw object;
            }
            object = new IllegalArgumentException("Required argument \"mediaArr\" is missing and does not have an android:defaultValue");
            throw object;
        }
        object = new IllegalArgumentException("Required argument \"templateId\" is missing and does not have an android:defaultValue");
        throw object;
    }

    public UploadCEMediaInfo[] c() {
        return (UploadCEMediaInfo[])this.a.get("mediaArr");
    }

    public CompositeConfig$Resolution d() {
        return (CompositeConfig$Resolution)((Object)this.a.get("resolution"));
    }

    public long e() {
        return (Long)this.a.get("templateId");
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            long l10;
            HashMap hashMap;
            boolean bl4;
            object = (w)object;
            object3 = this.a;
            object2 = "templateId";
            Object object4 = ((HashMap)object3).containsKey(object2);
            if (object4 != (bl4 = (hashMap = ((w)object).a).containsKey(object2))) {
                return false;
            }
            long l11 = this.e();
            long l12 = l11 - (l10 = ((w)object).e());
            object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4) {
                return false;
            }
            object3 = this.a;
            object2 = "mediaArr";
            object4 = ((HashMap)object3).containsKey(object2);
            if (object4 != (bl4 = (hashMap = ((w)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.c();
            if (object3 != null ? !(object4 = (object3 = this.c()).equals(object2 = ((w)object).c())) : (object3 = ((w)object).c()) != null) {
                return false;
            }
            object3 = this.a;
            object2 = "resolution";
            object4 = ((HashMap)object3).containsKey(object2);
            if (object4 != (bl4 = (hashMap = ((w)object).a).containsKey(object2))) {
                return false;
            }
            object3 = this.d();
            if (object3 != null ? !(bl3 = ((Enum)(object3 = this.d())).equals(object = ((w)object).d())) : (object = ((w)object).d()) != null) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bundle f() {
        Object object = CompositeConfig$Resolution.class;
        Bundle bundle = new Bundle();
        Object object2 = this.a;
        String string2 = "templateId";
        boolean bl2 = ((HashMap)object2).containsKey(string2);
        if (bl2) {
            object2 = (Long)this.a.get(string2);
            long l10 = (Long)object2;
            bundle.putLong(string2, l10);
        }
        if (bl2 = ((HashMap)(object2 = this.a)).containsKey(string2 = "mediaArr")) {
            object2 = (UploadCEMediaInfo[])this.a.get(string2);
            bundle.putParcelableArray(string2, (Parcelable[])object2);
        }
        if (!(bl2 = ((HashMap)(object2 = this.a)).containsKey(string2 = "resolution"))) return bundle;
        object2 = (CompositeConfig$Resolution)((Object)this.a.get(string2));
        Class clazz = Parcelable.class;
        boolean bl3 = clazz.isAssignableFrom((Class<?>)object);
        if (!bl3 && object2 != null) {
            clazz = Serializable.class;
            bl3 = clazz.isAssignableFrom((Class<?>)object);
            if (bl3) {
                object = (Serializable)Serializable.class.cast(object2);
                bundle.putSerializable(string2, (Serializable)object);
                return bundle;
            }
            object2 = new StringBuilder();
            object = ((Class)object).getName();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" must implement Parcelable or Serializable or must be an Enum.");
            object = ((StringBuilder)object2).toString();
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
            throw unsupportedOperationException;
        }
        object = (Parcelable)Parcelable.class.cast(object2);
        bundle.putParcelable(string2, (Parcelable)object);
        return bundle;
    }

    public int hashCode() {
        long l10 = this.e();
        long l11 = this.e();
        int n10 = 32;
        int n11 = (int)(l10 ^= (l11 >>>= n10));
        int n12 = 31;
        n11 = (n11 + n12) * n12;
        Object[] objectArray = this.c();
        int n13 = Arrays.hashCode(objectArray);
        n11 = (n11 + n13) * n12;
        CompositeConfig$Resolution compositeConfig$Resolution = this.d();
        if (compositeConfig$Resolution != null) {
            compositeConfig$Resolution = this.d();
            n12 = compositeConfig$Resolution.hashCode();
        } else {
            n12 = 0;
            compositeConfig$Resolution = null;
        }
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CECompositingDialogArgs{templateId=");
        long l10 = this.e();
        stringBuilder.append(l10);
        stringBuilder.append(", mediaArr=");
        Object object = this.c();
        stringBuilder.append(object);
        stringBuilder.append(", resolution=");
        object = this.d();
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

