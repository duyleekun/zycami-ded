/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.text.TextUtils
 */
package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaControllerCallback$Stub$Proxy;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.util.List;

public abstract class IMediaControllerCallback$Stub
extends Binder
implements IMediaControllerCallback {
    private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
    public static final int TRANSACTION_onCaptioningEnabledChanged = 11;
    public static final int TRANSACTION_onEvent = 1;
    public static final int TRANSACTION_onExtrasChanged = 7;
    public static final int TRANSACTION_onMetadataChanged = 4;
    public static final int TRANSACTION_onPlaybackStateChanged = 3;
    public static final int TRANSACTION_onQueueChanged = 5;
    public static final int TRANSACTION_onQueueTitleChanged = 6;
    public static final int TRANSACTION_onRepeatModeChanged = 9;
    public static final int TRANSACTION_onSessionDestroyed = 2;
    public static final int TRANSACTION_onSessionReady = 13;
    public static final int TRANSACTION_onShuffleModeChanged = 12;
    public static final int TRANSACTION_onShuffleModeChangedRemoved = 10;
    public static final int TRANSACTION_onVolumeInfoChanged = 8;

    public IMediaControllerCallback$Stub() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static IMediaControllerCallback asInterface(IBinder iBinder) {
        boolean bl2;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface != null && (bl2 = iInterface instanceof IMediaControllerCallback)) {
            return (IMediaControllerCallback)iInterface;
        }
        iInterface = new IMediaControllerCallback$Stub$Proxy(iBinder);
        return iInterface;
    }

    public static IMediaControllerCallback getDefaultImpl() {
        return IMediaControllerCallback$Stub$Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(IMediaControllerCallback iMediaControllerCallback) {
        IMediaControllerCallback iMediaControllerCallback2 = IMediaControllerCallback$Stub$Proxy.sDefaultImpl;
        if (iMediaControllerCallback2 == null && iMediaControllerCallback != null) {
            IMediaControllerCallback$Stub$Proxy.sDefaultImpl = iMediaControllerCallback;
            return true;
        }
        return false;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n10, Parcel object, Parcel parcel, int n11) {
        int n12 = 1598968902;
        int n13 = 1;
        String string2 = DESCRIPTOR;
        if (n10 != n12) {
            n12 = 0;
            Object object2 = null;
            switch (n10) {
                default: {
                    return super.onTransact(n10, object, parcel, n11);
                }
                case 13: {
                    object.enforceInterface(string2);
                    this.onSessionReady();
                    return n13;
                }
                case 12: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    this.onShuffleModeChanged(n10);
                    return n13;
                }
                case 11: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        n12 = n13;
                    }
                    this.onCaptioningEnabledChanged(n12 != 0);
                    return n13;
                }
                case 10: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        n12 = n13;
                    }
                    this.onShuffleModeChangedRemoved(n12 != 0);
                    return n13;
                }
                case 9: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    this.onRepeatModeChanged(n10);
                    return n13;
                }
                case 8: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        Object object3;
                        object2 = object3 = ParcelableVolumeInfo.CREATOR.createFromParcel(object);
                        object2 = (ParcelableVolumeInfo)object3;
                    }
                    this.onVolumeInfoChanged((ParcelableVolumeInfo)object2);
                    return n13;
                }
                case 7: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        Object object4;
                        object2 = object4 = Bundle.CREATOR.createFromParcel(object);
                        object2 = (Bundle)object4;
                    }
                    this.onExtrasChanged((Bundle)object2);
                    return n13;
                }
                case 6: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        Object object5;
                        object2 = object5 = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(object);
                        object2 = (CharSequence)object5;
                    }
                    this.onQueueTitleChanged((CharSequence)object2);
                    return n13;
                }
                case 5: {
                    object.enforceInterface(string2);
                    Object object6 = MediaSessionCompat$QueueItem.CREATOR;
                    object6 = object.createTypedArrayList(object6);
                    this.onQueueChanged((List)object6);
                    return n13;
                }
                case 4: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        Object object7;
                        object2 = object7 = MediaMetadataCompat.CREATOR.createFromParcel(object);
                        object2 = (MediaMetadataCompat)object7;
                    }
                    this.onMetadataChanged((MediaMetadataCompat)object2);
                    return n13;
                }
                case 3: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        Object object8;
                        object2 = object8 = PlaybackStateCompat.CREATOR.createFromParcel(object);
                        object2 = (PlaybackStateCompat)object8;
                    }
                    this.onPlaybackStateChanged((PlaybackStateCompat)object2);
                    return n13;
                }
                case 2: {
                    object.enforceInterface(string2);
                    this.onSessionDestroyed();
                    return n13;
                }
                case 1: 
            }
            object.enforceInterface(string2);
            String string3 = object.readString();
            int n14 = object.readInt();
            if (n14 != 0) {
                parcel = Bundle.CREATOR;
                object = parcel.createFromParcel(object);
                object2 = object;
                object2 = (Bundle)object;
            }
            this.onEvent(string3, (Bundle)object2);
            return n13;
        }
        parcel.writeString(string2);
        return n13;
    }
}

