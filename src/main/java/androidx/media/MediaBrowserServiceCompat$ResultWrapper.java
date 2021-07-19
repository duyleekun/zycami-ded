/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$MediaItem
 *  android.os.Parcel
 *  android.service.media.MediaBrowserService$Result
 */
package androidx.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import java.util.ArrayList;
import java.util.List;

public class MediaBrowserServiceCompat$ResultWrapper {
    public MediaBrowserService.Result mResultFwk;

    public MediaBrowserServiceCompat$ResultWrapper(MediaBrowserService.Result result2) {
        this.mResultFwk = result2;
    }

    public void detach() {
        this.mResultFwk.detach();
    }

    public List parcelListToItemList(List object) {
        boolean bl2;
        if (object == null) {
            return null;
        }
        ArrayList<MediaBrowser.MediaItem> arrayList = new ArrayList<MediaBrowser.MediaItem>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Parcel parcel = (Parcel)object.next();
            parcel.setDataPosition(0);
            MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem)MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel);
            arrayList.add(mediaItem);
            parcel.recycle();
        }
        return arrayList;
    }

    public void sendResult(Object object) {
        boolean bl2 = object instanceof List;
        if (bl2) {
            MediaBrowserService.Result result2 = this.mResultFwk;
            object = (List)object;
            object = this.parcelListToItemList((List)object);
            result2.sendResult(object);
        } else {
            bl2 = object instanceof Parcel;
            if (bl2) {
                object = (Parcel)object;
                bl2 = false;
                object.setDataPosition(0);
                MediaBrowserService.Result result3 = this.mResultFwk;
                Object object2 = MediaBrowser.MediaItem.CREATOR.createFromParcel((Parcel)object);
                result3.sendResult(object2);
                object.recycle();
            } else {
                object = this.mResultFwk;
                bl2 = false;
                Object var3_5 = null;
                object.sendResult(null);
            }
        }
    }
}

