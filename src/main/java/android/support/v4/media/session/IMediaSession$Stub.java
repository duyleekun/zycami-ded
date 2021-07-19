/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.net.Uri
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaControllerCallback$Stub;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.IMediaSession$Stub$Proxy;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

public abstract class IMediaSession$Stub
extends Binder
implements IMediaSession {
    private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
    public static final int TRANSACTION_addQueueItem = 41;
    public static final int TRANSACTION_addQueueItemAt = 42;
    public static final int TRANSACTION_adjustVolume = 11;
    public static final int TRANSACTION_fastForward = 22;
    public static final int TRANSACTION_getExtras = 31;
    public static final int TRANSACTION_getFlags = 9;
    public static final int TRANSACTION_getLaunchPendingIntent = 8;
    public static final int TRANSACTION_getMetadata = 27;
    public static final int TRANSACTION_getPackageName = 6;
    public static final int TRANSACTION_getPlaybackState = 28;
    public static final int TRANSACTION_getQueue = 29;
    public static final int TRANSACTION_getQueueTitle = 30;
    public static final int TRANSACTION_getRatingType = 32;
    public static final int TRANSACTION_getRepeatMode = 37;
    public static final int TRANSACTION_getSessionInfo = 50;
    public static final int TRANSACTION_getShuffleMode = 47;
    public static final int TRANSACTION_getTag = 7;
    public static final int TRANSACTION_getVolumeAttributes = 10;
    public static final int TRANSACTION_isCaptioningEnabled = 45;
    public static final int TRANSACTION_isShuffleModeEnabledRemoved = 38;
    public static final int TRANSACTION_isTransportControlEnabled = 5;
    public static final int TRANSACTION_next = 20;
    public static final int TRANSACTION_pause = 18;
    public static final int TRANSACTION_play = 13;
    public static final int TRANSACTION_playFromMediaId = 14;
    public static final int TRANSACTION_playFromSearch = 15;
    public static final int TRANSACTION_playFromUri = 16;
    public static final int TRANSACTION_prepare = 33;
    public static final int TRANSACTION_prepareFromMediaId = 34;
    public static final int TRANSACTION_prepareFromSearch = 35;
    public static final int TRANSACTION_prepareFromUri = 36;
    public static final int TRANSACTION_previous = 21;
    public static final int TRANSACTION_rate = 25;
    public static final int TRANSACTION_rateWithExtras = 51;
    public static final int TRANSACTION_registerCallbackListener = 3;
    public static final int TRANSACTION_removeQueueItem = 43;
    public static final int TRANSACTION_removeQueueItemAt = 44;
    public static final int TRANSACTION_rewind = 23;
    public static final int TRANSACTION_seekTo = 24;
    public static final int TRANSACTION_sendCommand = 1;
    public static final int TRANSACTION_sendCustomAction = 26;
    public static final int TRANSACTION_sendMediaButton = 2;
    public static final int TRANSACTION_setCaptioningEnabled = 46;
    public static final int TRANSACTION_setPlaybackSpeed = 49;
    public static final int TRANSACTION_setRepeatMode = 39;
    public static final int TRANSACTION_setShuffleMode = 48;
    public static final int TRANSACTION_setShuffleModeEnabledRemoved = 40;
    public static final int TRANSACTION_setVolumeTo = 12;
    public static final int TRANSACTION_skipToQueueItem = 17;
    public static final int TRANSACTION_stop = 19;
    public static final int TRANSACTION_unregisterCallbackListener = 4;

    public IMediaSession$Stub() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static IMediaSession asInterface(IBinder iBinder) {
        boolean bl2;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (iInterface != null && (bl2 = iInterface instanceof IMediaSession)) {
            return (IMediaSession)iInterface;
        }
        iInterface = new IMediaSession$Stub$Proxy(iBinder);
        return iInterface;
    }

    public static IMediaSession getDefaultImpl() {
        return IMediaSession$Stub$Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(IMediaSession iMediaSession) {
        IMediaSession iMediaSession2 = IMediaSession$Stub$Proxy.sDefaultImpl;
        if (iMediaSession2 == null && iMediaSession != null) {
            IMediaSession$Stub$Proxy.sDefaultImpl = iMediaSession;
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
            Bundle bundle;
            n12 = 0;
            Parcelable.Creator creator = null;
            Object object2 = null;
            switch (n10) {
                default: {
                    return super.onTransact(n10, object, parcel, n11);
                }
                case 51: {
                    RatingCompat ratingCompat;
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        ratingCompat = (RatingCompat)RatingCompat.CREATOR.createFromParcel(object);
                    } else {
                        n10 = 0;
                        ratingCompat = null;
                        float f10 = 0.0f;
                    }
                    n11 = object.readInt();
                    if (n11 != 0) {
                        Parcelable.Creator creator2 = Bundle.CREATOR;
                        object = creator2.createFromParcel(object);
                        object2 = object;
                        object2 = (Bundle)object;
                    }
                    this.rateWithExtras(ratingCompat, (Bundle)object2);
                    parcel.writeNoException();
                    return n13;
                }
                case 50: {
                    object.enforceInterface(string2);
                    Bundle bundle2 = this.getSessionInfo();
                    parcel.writeNoException();
                    if (bundle2 != null) {
                        parcel.writeInt(n13);
                        bundle2.writeToParcel(parcel, n13);
                    } else {
                        parcel.writeInt(0);
                    }
                    return n13;
                }
                case 49: {
                    object.enforceInterface(string2);
                    float f11 = object.readFloat();
                    this.setPlaybackSpeed(f11);
                    parcel.writeNoException();
                    return n13;
                }
                case 48: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    this.setShuffleMode(n10);
                    parcel.writeNoException();
                    return n13;
                }
                case 47: {
                    object.enforceInterface(string2);
                    n10 = this.getShuffleMode();
                    parcel.writeNoException();
                    parcel.writeInt(n10);
                    return n13;
                }
                case 46: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        n12 = n13;
                    }
                    this.setCaptioningEnabled(n12 != 0);
                    parcel.writeNoException();
                    return n13;
                }
                case 45: {
                    object.enforceInterface(string2);
                    n10 = (int)(this.isCaptioningEnabled() ? 1 : 0);
                    parcel.writeNoException();
                    parcel.writeInt(n10);
                    return n13;
                }
                case 44: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    this.removeQueueItemAt(n10);
                    parcel.writeNoException();
                    return n13;
                }
                case 43: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        Object object3;
                        object2 = object3 = MediaDescriptionCompat.CREATOR.createFromParcel(object);
                        object2 = (MediaDescriptionCompat)object3;
                    }
                    this.removeQueueItem((MediaDescriptionCompat)object2);
                    parcel.writeNoException();
                    return n13;
                }
                case 42: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        Object object4;
                        object2 = object4 = MediaDescriptionCompat.CREATOR.createFromParcel(object);
                        object2 = (MediaDescriptionCompat)object4;
                    }
                    n10 = object.readInt();
                    this.addQueueItemAt((MediaDescriptionCompat)object2, n10);
                    parcel.writeNoException();
                    return n13;
                }
                case 41: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        Object object5;
                        object2 = object5 = MediaDescriptionCompat.CREATOR.createFromParcel(object);
                        object2 = (MediaDescriptionCompat)object5;
                    }
                    this.addQueueItem((MediaDescriptionCompat)object2);
                    parcel.writeNoException();
                    return n13;
                }
                case 40: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        n12 = n13;
                    }
                    this.setShuffleModeEnabledRemoved(n12 != 0);
                    parcel.writeNoException();
                    return n13;
                }
                case 39: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    this.setRepeatMode(n10);
                    parcel.writeNoException();
                    return n13;
                }
                case 38: {
                    object.enforceInterface(string2);
                    n10 = (int)(this.isShuffleModeEnabledRemoved() ? 1 : 0);
                    parcel.writeNoException();
                    parcel.writeInt(n10);
                    return n13;
                }
                case 37: {
                    object.enforceInterface(string2);
                    n10 = this.getRepeatMode();
                    parcel.writeNoException();
                    parcel.writeInt(n10);
                    return n13;
                }
                case 36: {
                    Uri uri;
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        uri = (Uri)Uri.CREATOR.createFromParcel(object);
                    } else {
                        n10 = 0;
                        uri = null;
                        float f12 = 0.0f;
                    }
                    n11 = object.readInt();
                    if (n11 != 0) {
                        Parcelable.Creator creator3 = Bundle.CREATOR;
                        object = creator3.createFromParcel(object);
                        object2 = object;
                        object2 = (Bundle)object;
                    }
                    this.prepareFromUri(uri, (Bundle)object2);
                    parcel.writeNoException();
                    return n13;
                }
                case 35: {
                    object.enforceInterface(string2);
                    String string3 = object.readString();
                    n11 = object.readInt();
                    if (n11 != 0) {
                        Parcelable.Creator creator4 = Bundle.CREATOR;
                        object = creator4.createFromParcel(object);
                        object2 = object;
                        object2 = (Bundle)object;
                    }
                    this.prepareFromSearch(string3, (Bundle)object2);
                    parcel.writeNoException();
                    return n13;
                }
                case 34: {
                    object.enforceInterface(string2);
                    String string4 = object.readString();
                    n11 = object.readInt();
                    if (n11 != 0) {
                        Parcelable.Creator creator5 = Bundle.CREATOR;
                        object = creator5.createFromParcel(object);
                        object2 = object;
                        object2 = (Bundle)object;
                    }
                    this.prepareFromMediaId(string4, (Bundle)object2);
                    parcel.writeNoException();
                    return n13;
                }
                case 33: {
                    object.enforceInterface(string2);
                    this.prepare();
                    parcel.writeNoException();
                    return n13;
                }
                case 32: {
                    object.enforceInterface(string2);
                    n10 = this.getRatingType();
                    parcel.writeNoException();
                    parcel.writeInt(n10);
                    return n13;
                }
                case 31: {
                    object.enforceInterface(string2);
                    Bundle bundle3 = this.getExtras();
                    parcel.writeNoException();
                    if (bundle3 != null) {
                        parcel.writeInt(n13);
                        bundle3.writeToParcel(parcel, n13);
                    } else {
                        parcel.writeInt(0);
                    }
                    return n13;
                }
                case 30: {
                    object.enforceInterface(string2);
                    CharSequence charSequence = this.getQueueTitle();
                    parcel.writeNoException();
                    if (charSequence != null) {
                        parcel.writeInt(n13);
                        TextUtils.writeToParcel((CharSequence)charSequence, (Parcel)parcel, (int)n13);
                    } else {
                        parcel.writeInt(0);
                    }
                    return n13;
                }
                case 29: {
                    object.enforceInterface(string2);
                    List list = this.getQueue();
                    parcel.writeNoException();
                    parcel.writeTypedList(list);
                    return n13;
                }
                case 28: {
                    object.enforceInterface(string2);
                    PlaybackStateCompat playbackStateCompat = this.getPlaybackState();
                    parcel.writeNoException();
                    if (playbackStateCompat != null) {
                        parcel.writeInt(n13);
                        playbackStateCompat.writeToParcel(parcel, n13);
                    } else {
                        parcel.writeInt(0);
                    }
                    return n13;
                }
                case 27: {
                    object.enforceInterface(string2);
                    MediaMetadataCompat mediaMetadataCompat = this.getMetadata();
                    parcel.writeNoException();
                    if (mediaMetadataCompat != null) {
                        parcel.writeInt(n13);
                        mediaMetadataCompat.writeToParcel(parcel, n13);
                    } else {
                        parcel.writeInt(0);
                    }
                    return n13;
                }
                case 26: {
                    object.enforceInterface(string2);
                    String string5 = object.readString();
                    n11 = object.readInt();
                    if (n11 != 0) {
                        Parcelable.Creator creator6 = Bundle.CREATOR;
                        object = creator6.createFromParcel(object);
                        object2 = object;
                        object2 = (Bundle)object;
                    }
                    this.sendCustomAction(string5, (Bundle)object2);
                    parcel.writeNoException();
                    return n13;
                }
                case 25: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        Object object6;
                        object2 = object6 = RatingCompat.CREATOR.createFromParcel(object);
                        object2 = (RatingCompat)object6;
                    }
                    this.rate((RatingCompat)object2);
                    parcel.writeNoException();
                    return n13;
                }
                case 24: {
                    object.enforceInterface(string2);
                    long l10 = object.readLong();
                    this.seekTo(l10);
                    parcel.writeNoException();
                    return n13;
                }
                case 23: {
                    object.enforceInterface(string2);
                    this.rewind();
                    parcel.writeNoException();
                    return n13;
                }
                case 22: {
                    object.enforceInterface(string2);
                    this.fastForward();
                    parcel.writeNoException();
                    return n13;
                }
                case 21: {
                    object.enforceInterface(string2);
                    this.previous();
                    parcel.writeNoException();
                    return n13;
                }
                case 20: {
                    object.enforceInterface(string2);
                    this.next();
                    parcel.writeNoException();
                    return n13;
                }
                case 19: {
                    object.enforceInterface(string2);
                    this.stop();
                    parcel.writeNoException();
                    return n13;
                }
                case 18: {
                    object.enforceInterface(string2);
                    this.pause();
                    parcel.writeNoException();
                    return n13;
                }
                case 17: {
                    object.enforceInterface(string2);
                    long l11 = object.readLong();
                    this.skipToQueueItem(l11);
                    parcel.writeNoException();
                    return n13;
                }
                case 16: {
                    Uri uri;
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        uri = (Uri)Uri.CREATOR.createFromParcel(object);
                    } else {
                        n10 = 0;
                        uri = null;
                        float f13 = 0.0f;
                    }
                    n11 = object.readInt();
                    if (n11 != 0) {
                        Parcelable.Creator creator7 = Bundle.CREATOR;
                        object = creator7.createFromParcel(object);
                        object2 = object;
                        object2 = (Bundle)object;
                    }
                    this.playFromUri(uri, (Bundle)object2);
                    parcel.writeNoException();
                    return n13;
                }
                case 15: {
                    object.enforceInterface(string2);
                    String string6 = object.readString();
                    n11 = object.readInt();
                    if (n11 != 0) {
                        Parcelable.Creator creator8 = Bundle.CREATOR;
                        object = creator8.createFromParcel(object);
                        object2 = object;
                        object2 = (Bundle)object;
                    }
                    this.playFromSearch(string6, (Bundle)object2);
                    parcel.writeNoException();
                    return n13;
                }
                case 14: {
                    object.enforceInterface(string2);
                    String string7 = object.readString();
                    n11 = object.readInt();
                    if (n11 != 0) {
                        Parcelable.Creator creator9 = Bundle.CREATOR;
                        object = creator9.createFromParcel(object);
                        object2 = object;
                        object2 = (Bundle)object;
                    }
                    this.playFromMediaId(string7, (Bundle)object2);
                    parcel.writeNoException();
                    return n13;
                }
                case 13: {
                    object.enforceInterface(string2);
                    this.play();
                    parcel.writeNoException();
                    return n13;
                }
                case 12: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    n11 = object.readInt();
                    object = object.readString();
                    this.setVolumeTo(n10, n11, (String)object);
                    parcel.writeNoException();
                    return n13;
                }
                case 11: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    n11 = object.readInt();
                    object = object.readString();
                    this.adjustVolume(n10, n11, (String)object);
                    parcel.writeNoException();
                    return n13;
                }
                case 10: {
                    object.enforceInterface(string2);
                    ParcelableVolumeInfo parcelableVolumeInfo = this.getVolumeAttributes();
                    parcel.writeNoException();
                    if (parcelableVolumeInfo != null) {
                        parcel.writeInt(n13);
                        parcelableVolumeInfo.writeToParcel(parcel, n13);
                    } else {
                        parcel.writeInt(0);
                    }
                    return n13;
                }
                case 9: {
                    object.enforceInterface(string2);
                    long l12 = this.getFlags();
                    parcel.writeNoException();
                    parcel.writeLong(l12);
                    return n13;
                }
                case 8: {
                    object.enforceInterface(string2);
                    PendingIntent pendingIntent = this.getLaunchPendingIntent();
                    parcel.writeNoException();
                    if (pendingIntent != null) {
                        parcel.writeInt(n13);
                        pendingIntent.writeToParcel(parcel, n13);
                    } else {
                        parcel.writeInt(0);
                    }
                    return n13;
                }
                case 7: {
                    object.enforceInterface(string2);
                    String string8 = this.getTag();
                    parcel.writeNoException();
                    parcel.writeString(string8);
                    return n13;
                }
                case 6: {
                    object.enforceInterface(string2);
                    String string9 = this.getPackageName();
                    parcel.writeNoException();
                    parcel.writeString(string9);
                    return n13;
                }
                case 5: {
                    object.enforceInterface(string2);
                    n10 = (int)(this.isTransportControlEnabled() ? 1 : 0);
                    parcel.writeNoException();
                    parcel.writeInt(n10);
                    return n13;
                }
                case 4: {
                    object.enforceInterface(string2);
                    IMediaControllerCallback iMediaControllerCallback = IMediaControllerCallback$Stub.asInterface(object.readStrongBinder());
                    this.unregisterCallbackListener(iMediaControllerCallback);
                    parcel.writeNoException();
                    return n13;
                }
                case 3: {
                    object.enforceInterface(string2);
                    IMediaControllerCallback iMediaControllerCallback = IMediaControllerCallback$Stub.asInterface(object.readStrongBinder());
                    this.registerCallbackListener(iMediaControllerCallback);
                    parcel.writeNoException();
                    return n13;
                }
                case 2: {
                    object.enforceInterface(string2);
                    n10 = object.readInt();
                    if (n10 != 0) {
                        Object object7;
                        object2 = object7 = KeyEvent.CREATOR.createFromParcel(object);
                        object2 = (KeyEvent)object7;
                    }
                    n10 = (int)(this.sendMediaButton((KeyEvent)object2) ? 1 : 0);
                    parcel.writeNoException();
                    parcel.writeInt(n10);
                    return n13;
                }
                case 1: 
            }
            object.enforceInterface(string2);
            String string10 = object.readString();
            n11 = object.readInt();
            if (n11 != 0) {
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(object);
            } else {
                n11 = 0;
                bundle = null;
            }
            n12 = object.readInt();
            if (n12) {
                creator = MediaSessionCompat$ResultReceiverWrapper.CREATOR;
                object = creator.createFromParcel(object);
                object2 = object;
                object2 = (MediaSessionCompat$ResultReceiverWrapper)object;
            }
            this.sendCommand(string10, bundle, (MediaSessionCompat$ResultReceiverWrapper)object2);
            parcel.writeNoException();
            return n13;
        }
        parcel.writeString(string2);
        return n13;
    }
}

