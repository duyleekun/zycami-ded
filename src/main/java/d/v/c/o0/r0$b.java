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
import androidx.navigation.NavDirections;
import com.zhiyun.cama.album.AlbumSection;
import d.v.c.o0.r0$a;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

public class r0$b
implements NavDirections {
    private final HashMap a;

    private r0$b(AlbumSection[] object) {
        HashMap<String, AlbumSection[]> hashMap;
        this.a = hashMap = new HashMap<String, AlbumSection[]>();
        if (object != null) {
            hashMap.put("deleteSections", (AlbumSection[])object);
            return;
        }
        super("Argument \"deleteSections\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public /* synthetic */ r0$b(AlbumSection[] albumSectionArray, r0$a r0$a) {
        this(albumSectionArray);
    }

    public AlbumSection[] a() {
        return (AlbumSection[])this.a.get("deleteSections");
    }

    public r0$b b(AlbumSection[] object) {
        if (object != null) {
            this.a.put("deleteSections", object);
            return this;
        }
        object = new IllegalArgumentException("Argument \"deleteSections\" is marked as non-null but was passed a null value.");
        throw object;
    }

    public boolean equals(Object object) {
        Object object2;
        Serializable serializable;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (serializable = this.getClass()) == (object2 = object.getClass())) {
            int n10;
            boolean bl3;
            HashMap hashMap;
            boolean bl4;
            object = (r0$b)object;
            serializable = this.a;
            object2 = "deleteSections";
            boolean n12 = ((HashMap)serializable).containsKey(object2);
            if (n12 != (bl4 = (hashMap = ((r0$b)object).a).containsKey(object2))) {
                return false;
            }
            serializable = this.a();
            if (serializable != null ? !(bl3 = (serializable = this.a()).equals(object2 = ((r0$b)object).a())) : (serializable = ((r0$b)object).a()) != null) {
                return false;
            }
            int n11 = this.getActionId();
            if (n11 != (n10 = ((r0$b)object).getActionId())) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int getActionId() {
        return 2131361874;
    }

    public Bundle getArguments() {
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

    public int hashCode() {
        int n10 = Arrays.hashCode(this.a());
        int n11 = 31;
        n10 = (n10 + n11) * n11;
        n11 = this.getActionId();
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActionAlbumListFragmentToAlbumDeleteConfirmDialog(actionId=");
        int n10 = this.getActionId();
        stringBuilder.append(n10);
        stringBuilder.append("){deleteSections=");
        AlbumSection[] albumSectionArray = this.a();
        stringBuilder.append(albumSectionArray);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

