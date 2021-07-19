/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package cn.leancloud;

import android.os.Parcel;
import android.os.Parcelable;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVParcelableObject$AVObjectCreator;
import cn.leancloud.ArchivedRequests;
import cn.leancloud.utils.LogUtil;

public class AVParcelableObject
implements Parcelable {
    public static final transient Parcelable.Creator CREATOR;
    private static final AVLogger LOGGER;
    private AVObject instance = null;

    static {
        LOGGER = LogUtil.getLogger(AVParcelableObject.class);
        CREATOR = AVParcelableObject$AVObjectCreator.instance;
    }

    public AVParcelableObject() {
    }

    public AVParcelableObject(AVObject aVObject) {
        this.instance = aVObject;
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    public int describeContents() {
        return 0;
    }

    public AVObject object() {
        return this.instance;
    }

    public void writeToParcel(Parcel object, int n10) {
        String string2 = ArchivedRequests.getArchiveContent(this.instance, false);
        CharSequence charSequence = this.instance.getClassName();
        object.writeString((String)charSequence);
        object.writeString(string2);
        object = LOGGER;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("writeToParcel with archivedContent: ");
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        ((AVLogger)object).d(string2);
    }
}

