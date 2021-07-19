/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import androidx.versionedparcelable.VersionedParcelStream;
import androidx.versionedparcelable.VersionedParcelable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ParcelUtils {
    private static final String INNER_BUNDLE_KEY = "a";

    private ParcelUtils() {
    }

    public static VersionedParcelable fromInputStream(InputStream inputStream) {
        VersionedParcelStream versionedParcelStream = new VersionedParcelStream(inputStream, null);
        return versionedParcelStream.readVersionedParcelable();
    }

    public static VersionedParcelable fromParcelable(Parcelable object) {
        boolean bl2 = object instanceof ParcelImpl;
        if (bl2) {
            return ((ParcelImpl)object).getVersionedParcel();
        }
        object = new IllegalArgumentException("Invalid parcel");
        throw object;
    }

    public static VersionedParcelable getVersionedParcelable(Bundle bundle, String object) {
        try {
            bundle = bundle.getParcelable((String)object);
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        if (bundle == null) {
            return null;
        }
        object = ParcelUtils.class;
        object = ((Class)object).getClassLoader();
        bundle.setClassLoader((ClassLoader)object);
        object = INNER_BUNDLE_KEY;
        bundle = bundle.getParcelable((String)object);
        return ParcelUtils.fromParcelable((Parcelable)bundle);
    }

    public static List getVersionedParcelableList(Bundle object, String object2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.getParcelable((String)object2);
        object2 = ParcelUtils.class;
        object2 = ((Class)object2).getClassLoader();
        object.setClassLoader((ClassLoader)object2);
        object2 = INNER_BUNDLE_KEY;
        object = object.getParcelableArrayList((String)object2);
        try {
            object = ((ArrayList)object).iterator();
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
        while (true) {
            boolean bl2 = object.hasNext();
            if (!bl2) break;
            object2 = object.next();
            object2 = (Parcelable)object2;
            object2 = ParcelUtils.fromParcelable((Parcelable)object2);
            arrayList.add(object2);
            continue;
            break;
        }
        return arrayList;
    }

    public static void putVersionedParcelable(Bundle bundle, String string2, VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        versionedParcelable = ParcelUtils.toParcelable(versionedParcelable);
        bundle2.putParcelable(INNER_BUNDLE_KEY, (Parcelable)versionedParcelable);
        bundle.putParcelable(string2, (Parcelable)bundle2);
    }

    public static void putVersionedParcelableList(Bundle bundle, String string2, List object) {
        boolean bl2;
        Bundle bundle2 = new Bundle();
        ArrayList<Parcelable> arrayList = new ArrayList<Parcelable>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Parcelable parcelable = ParcelUtils.toParcelable((VersionedParcelable)object.next());
            arrayList.add(parcelable);
        }
        bundle2.putParcelableArrayList(INNER_BUNDLE_KEY, arrayList);
        bundle.putParcelable(string2, (Parcelable)bundle2);
    }

    public static void toOutputStream(VersionedParcelable versionedParcelable, OutputStream outputStream) {
        VersionedParcelStream versionedParcelStream = new VersionedParcelStream(null, outputStream);
        versionedParcelStream.writeVersionedParcelable(versionedParcelable);
        versionedParcelStream.closeField();
    }

    public static Parcelable toParcelable(VersionedParcelable versionedParcelable) {
        ParcelImpl parcelImpl = new ParcelImpl(versionedParcelable);
        return parcelImpl;
    }
}

