/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package d.v.c.o0;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavArgs;
import com.zhiyun.cama.album.AlbumSection;
import d.v.c.o0.m0$a;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

public class m0
implements NavArgs {
    private final HashMap a;

    private m0() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    private m0(HashMap hashMap) {
        HashMap hashMap2;
        this.a = hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
    }

    public /* synthetic */ m0(HashMap hashMap, m0$a m0$a) {
        this(hashMap);
    }

    public static /* synthetic */ HashMap a(m0 m02) {
        return m02.a;
    }

    public static m0 b(Bundle object) {
        m0 m02 = new m0();
        Object object2 = m0.class.getClassLoader();
        object.setClassLoader((ClassLoader)object2);
        object2 = "deleteSections";
        int n10 = object.containsKey((String)object2);
        if (n10 != 0) {
            AlbumSection[] albumSectionArray;
            if ((object = object.getParcelableArray((String)object2)) != null) {
                n10 = ((Parcelable[])object).length;
                albumSectionArray = new AlbumSection[n10];
                int n11 = ((Parcelable[])object).length;
                System.arraycopy(object, 0, albumSectionArray, 0, n11);
            } else {
                n10 = 0;
                albumSectionArray = null;
            }
            if (albumSectionArray != null) {
                m02.a.put(object2, albumSectionArray);
                return m02;
            }
            object = new IllegalArgumentException("Argument \"deleteSections\" is marked as non-null but was passed a null value.");
            throw object;
        }
        object = new IllegalArgumentException("Required argument \"deleteSections\" is missing and does not have an android:defaultValue");
        throw object;
    }

    public AlbumSection[] c() {
        return (AlbumSection[])this.a.get("deleteSections");
    }

    public Bundle d() {
        Bundle bundle = new Bundle();
        Parcelable[] parcelableArray = this.a;
        String string2 = "deleteSections";
        boolean bl2 = parcelableArray.containsKey(string2);
        if (bl2) {
            parcelableArray = (AlbumSection[])this.a.get(string2);
            bundle.putParcelableArray(string2, parcelableArray);
        }
        return bundle;
    }

    public boolean equals(Object albumSectionArray) {
        Object object;
        Serializable serializable;
        boolean bl2 = true;
        if (this == albumSectionArray) {
            return bl2;
        }
        if (albumSectionArray != null && (serializable = this.getClass()) == (object = albumSectionArray.getClass())) {
            boolean bl3;
            HashMap hashMap;
            boolean bl4;
            albumSectionArray = (m0)albumSectionArray;
            serializable = this.a;
            object = "deleteSections";
            boolean bl5 = ((HashMap)serializable).containsKey(object);
            if (bl5 != (bl4 = (hashMap = albumSectionArray.a).containsKey(object))) {
                return false;
            }
            serializable = this.c();
            if (serializable != null ? !(bl3 = (serializable = this.c()).equals(albumSectionArray = albumSectionArray.c())) : (albumSectionArray = albumSectionArray.c()) != null) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = Arrays.hashCode(this.c());
        return 31 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AlbumDeleteConfirmDialogArgs{deleteSections=");
        AlbumSection[] albumSectionArray = this.c();
        stringBuilder.append(albumSectionArray);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

