/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package cn.leancloud;

import android.os.Parcel;
import android.os.Parcelable;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVParcelableObject;
import cn.leancloud.ArchivedRequests;
import cn.leancloud.Transformer;

public class AVParcelableObject$AVObjectCreator
implements Parcelable.Creator {
    public static AVParcelableObject$AVObjectCreator instance;

    static {
        AVParcelableObject$AVObjectCreator aVParcelableObject$AVObjectCreator;
        instance = aVParcelableObject$AVObjectCreator = new AVParcelableObject$AVObjectCreator();
    }

    private AVParcelableObject$AVObjectCreator() {
    }

    public AVParcelableObject createFromParcel(Parcel object) {
        String string2 = object.readString();
        object = object.readString();
        Object object2 = AVParcelableObject.access$000();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("createFromParcel with archivedContent: ");
        charSequence.append((String)object);
        charSequence.append(", className: ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        ((AVLogger)object2).d((String)charSequence);
        object = ArchivedRequests.parseAVObject((String)object);
        object = Transformer.transform((AVObject)object, string2);
        object2 = new AVParcelableObject((AVObject)object);
        return object2;
    }

    public AVParcelableObject[] newArray(int n10) {
        return new AVParcelableObject[n10];
    }
}

