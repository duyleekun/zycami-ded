/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.text.TextUtils
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaControllerCallback$Stub;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.util.List;

public class IMediaControllerCallback$Stub$Proxy
implements IMediaControllerCallback {
    public static IMediaControllerCallback sDefaultImpl;
    private IBinder mRemote;

    public IMediaControllerCallback$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "android.support.v4.media.session.IMediaControllerCallback";
    }

    public void onCaptioningEnabledChanged(boolean bl2) {
        Parcel parcel;
        block10: {
            IBinder iBinder;
            int n10;
            int n11;
            Object object;
            block9: {
                parcel = Parcel.obtain();
                object = "android.support.v4.media.session.IMediaControllerCallback";
                parcel.writeInterfaceToken((String)object);
                n11 = 1;
                if (bl2) {
                    n10 = n11;
                    break block9;
                }
                n10 = 0;
                iBinder = null;
            }
            parcel.writeInt(n10);
            iBinder = this.mRemote;
            int n12 = 11;
            n11 = (int)(iBinder.transact(n12, parcel, null, n11) ? 1 : 0);
            if (n11 != 0) break block10;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) break block10;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onCaptioningEnabledChanged(bl2);
            return;
        }
        parcel.recycle();
        return;
        finally {
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onEvent(String string2, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaControllerCallback";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeString(string2);
            boolean bl2 = false;
            object = null;
            int n10 = 1;
            if (bundle != null) {
                parcel.writeInt(n10);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            object = this.mRemote;
            bl2 = object.transact(n10, parcel, null, n10);
            if (bl2) return;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) return;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onEvent(string2, bundle);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onExtrasChanged(Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaControllerCallback";
        try {
            parcel.writeInterfaceToken((String)object);
            int n10 = 1;
            IBinder iBinder = null;
            if (bundle != null) {
                parcel.writeInt(n10);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            iBinder = this.mRemote;
            int n11 = 7;
            n10 = (int)(iBinder.transact(n11, parcel, null, n10) ? 1 : 0);
            if (n10 != 0) return;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) return;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onExtrasChanged(bundle);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
        Parcel parcel = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaControllerCallback";
        try {
            parcel.writeInterfaceToken((String)object);
            int n10 = 1;
            IBinder iBinder = null;
            if (mediaMetadataCompat != null) {
                parcel.writeInt(n10);
                mediaMetadataCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            iBinder = this.mRemote;
            int n11 = 4;
            n10 = (int)(iBinder.transact(n11, parcel, null, n10) ? 1 : 0);
            if (n10 != 0) return;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) return;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onMetadataChanged(mediaMetadataCompat);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
        Parcel parcel = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaControllerCallback";
        try {
            parcel.writeInterfaceToken((String)object);
            int n10 = 1;
            IBinder iBinder = null;
            if (playbackStateCompat != null) {
                parcel.writeInt(n10);
                playbackStateCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            iBinder = this.mRemote;
            int n11 = 3;
            n10 = (int)(iBinder.transact(n11, parcel, null, n10) ? 1 : 0);
            if (n10 != 0) return;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) return;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onPlaybackStateChanged(playbackStateCompat);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onQueueChanged(List list) {
        Parcel parcel;
        block8: {
            parcel = Parcel.obtain();
            Object object = "android.support.v4.media.session.IMediaControllerCallback";
            parcel.writeInterfaceToken((String)object);
            parcel.writeTypedList(list);
            object = this.mRemote;
            int n10 = 5;
            int n11 = 1;
            boolean bl2 = object.transact(n10, parcel, null, n11);
            if (bl2) break block8;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) break block8;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onQueueChanged(list);
            return;
        }
        parcel.recycle();
        return;
        finally {
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onQueueTitleChanged(CharSequence charSequence) {
        Parcel parcel = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaControllerCallback";
        try {
            parcel.writeInterfaceToken((String)object);
            int n10 = 1;
            IBinder iBinder = null;
            if (charSequence != null) {
                parcel.writeInt(n10);
                TextUtils.writeToParcel((CharSequence)charSequence, (Parcel)parcel, (int)0);
            } else {
                parcel.writeInt(0);
            }
            iBinder = this.mRemote;
            int n11 = 6;
            n10 = (int)(iBinder.transact(n11, parcel, null, n10) ? 1 : 0);
            if (n10 != 0) return;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) return;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onQueueTitleChanged(charSequence);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public void onRepeatModeChanged(int n10) {
        Parcel parcel;
        block8: {
            parcel = Parcel.obtain();
            Object object = "android.support.v4.media.session.IMediaControllerCallback";
            parcel.writeInterfaceToken((String)object);
            parcel.writeInt(n10);
            object = this.mRemote;
            int n11 = 9;
            int n12 = 1;
            boolean bl2 = object.transact(n11, parcel, null, n12);
            if (bl2) break block8;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) break block8;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onRepeatModeChanged(n10);
            return;
        }
        parcel.recycle();
        return;
        finally {
            parcel.recycle();
        }
    }

    public void onSessionDestroyed() {
        Parcel parcel;
        block7: {
            parcel = Parcel.obtain();
            Object object = "android.support.v4.media.session.IMediaControllerCallback";
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 2;
            int n11 = 1;
            boolean bl2 = object.transact(n10, parcel, null, n11);
            if (bl2) break block7;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) break block7;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onSessionDestroyed();
            return;
        }
        parcel.recycle();
        return;
        finally {
            parcel.recycle();
        }
    }

    public void onSessionReady() {
        Parcel parcel;
        block7: {
            parcel = Parcel.obtain();
            Object object = "android.support.v4.media.session.IMediaControllerCallback";
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 13;
            int n11 = 1;
            boolean bl2 = object.transact(n10, parcel, null, n11);
            if (bl2) break block7;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) break block7;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onSessionReady();
            return;
        }
        parcel.recycle();
        return;
        finally {
            parcel.recycle();
        }
    }

    public void onShuffleModeChanged(int n10) {
        Parcel parcel;
        block8: {
            parcel = Parcel.obtain();
            Object object = "android.support.v4.media.session.IMediaControllerCallback";
            parcel.writeInterfaceToken((String)object);
            parcel.writeInt(n10);
            object = this.mRemote;
            int n11 = 12;
            int n12 = 1;
            boolean bl2 = object.transact(n11, parcel, null, n12);
            if (bl2) break block8;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) break block8;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onShuffleModeChanged(n10);
            return;
        }
        parcel.recycle();
        return;
        finally {
            parcel.recycle();
        }
    }

    public void onShuffleModeChangedRemoved(boolean bl2) {
        Parcel parcel;
        block10: {
            IBinder iBinder;
            int n10;
            int n11;
            Object object;
            block9: {
                parcel = Parcel.obtain();
                object = "android.support.v4.media.session.IMediaControllerCallback";
                parcel.writeInterfaceToken((String)object);
                n11 = 1;
                if (bl2) {
                    n10 = n11;
                    break block9;
                }
                n10 = 0;
                iBinder = null;
            }
            parcel.writeInt(n10);
            iBinder = this.mRemote;
            int n12 = 10;
            n11 = (int)(iBinder.transact(n12, parcel, null, n11) ? 1 : 0);
            if (n11 != 0) break block10;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) break block10;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onShuffleModeChangedRemoved(bl2);
            return;
        }
        parcel.recycle();
        return;
        finally {
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) {
        Parcel parcel = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaControllerCallback";
        try {
            parcel.writeInterfaceToken((String)object);
            int n10 = 1;
            IBinder iBinder = null;
            if (parcelableVolumeInfo != null) {
                parcel.writeInt(n10);
                parcelableVolumeInfo.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            iBinder = this.mRemote;
            int n11 = 8;
            n10 = (int)(iBinder.transact(n11, parcel, null, n10) ? 1 : 0);
            if (n10 != 0) return;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            if (object == null) return;
            object = IMediaControllerCallback$Stub.getDefaultImpl();
            object.onVolumeInfoChanged(parcelableVolumeInfo);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}

