/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.view.KeyEvent
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.IMediaSession$Stub;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

public class IMediaSession$Stub$Proxy
implements IMediaSession {
    public static IMediaSession sDefaultImpl;
    private IBinder mRemote;

    public IMediaSession$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            boolean bl2 = false;
            object = null;
            if (mediaDescriptionCompat != null) {
                int n10 = 1;
                parcel.writeInt(n10);
                mediaDescriptionCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = this.mRemote;
            int n11 = 41;
            bl2 = iBinder.transact(n11, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.addQueueItem(mediaDescriptionCompat);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int n10) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            boolean bl2 = false;
            object = null;
            if (mediaDescriptionCompat != null) {
                int n11 = 1;
                parcel.writeInt(n11);
                mediaDescriptionCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeInt(n10);
            IBinder iBinder = this.mRemote;
            int n12 = 42;
            bl2 = iBinder.transact(n12, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.addQueueItemAt(mediaDescriptionCompat, n10);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void adjustVolume(int n10, int n11, String string2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeInt(n10);
            parcel.writeInt(n11);
            parcel.writeString(string2);
            object = this.mRemote;
            int n12 = 11;
            boolean bl2 = object.transact(n12, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.adjustVolume(n10, n11, string2);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public void fastForward() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 22;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.fastForward();
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public Bundle getExtras() {
        int n10;
        Object object;
        Parcel parcel;
        Parcel parcel2;
        block12: {
            block11: {
                parcel2 = Parcel.obtain();
                parcel = Parcel.obtain();
                object = "android.support.v4.media.session.IMediaSession";
                parcel2.writeInterfaceToken((String)object);
                object = this.mRemote;
                int n11 = 31;
                n10 = object.transact(n11, parcel2, parcel, 0);
                if (n10 != 0) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                if (object == null) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                object = object.getExtras();
                return object;
            }
            parcel.readException();
            n10 = parcel.readInt();
            if (n10 == 0) break block12;
            object = Bundle.CREATOR;
            object = object.createFromParcel(parcel);
            object = (Bundle)object;
        }
        n10 = 0;
        object = null;
        parcel.recycle();
        parcel2.recycle();
        return object;
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public long getFlags() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 9;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                long l10 = object.getFlags();
                return l10;
            }
            parcel2.readException();
            long l11 = parcel2.readLong();
            return l11;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public String getInterfaceDescriptor() {
        return "android.support.v4.media.session.IMediaSession";
    }

    public PendingIntent getLaunchPendingIntent() {
        int n10;
        Object object;
        Parcel parcel;
        Parcel parcel2;
        block12: {
            block11: {
                parcel2 = Parcel.obtain();
                parcel = Parcel.obtain();
                object = "android.support.v4.media.session.IMediaSession";
                parcel2.writeInterfaceToken((String)object);
                object = this.mRemote;
                int n11 = 8;
                n10 = object.transact(n11, parcel2, parcel, 0);
                if (n10 != 0) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                if (object == null) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                object = object.getLaunchPendingIntent();
                return object;
            }
            parcel.readException();
            n10 = parcel.readInt();
            if (n10 == 0) break block12;
            object = PendingIntent.CREATOR;
            object = object.createFromParcel(parcel);
            object = (PendingIntent)object;
        }
        n10 = 0;
        object = null;
        parcel.recycle();
        parcel2.recycle();
        return object;
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public MediaMetadataCompat getMetadata() {
        int n10;
        Object object;
        Parcel parcel;
        Parcel parcel2;
        block12: {
            block11: {
                parcel2 = Parcel.obtain();
                parcel = Parcel.obtain();
                object = "android.support.v4.media.session.IMediaSession";
                parcel2.writeInterfaceToken((String)object);
                object = this.mRemote;
                int n11 = 27;
                n10 = object.transact(n11, parcel2, parcel, 0);
                if (n10 != 0) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                if (object == null) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                object = object.getMetadata();
                return object;
            }
            parcel.readException();
            n10 = parcel.readInt();
            if (n10 == 0) break block12;
            object = MediaMetadataCompat.CREATOR;
            object = object.createFromParcel(parcel);
            object = (MediaMetadataCompat)object;
        }
        n10 = 0;
        object = null;
        parcel.recycle();
        parcel2.recycle();
        return object;
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public String getPackageName() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 6;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object = object.getPackageName();
                return object;
            }
            parcel2.readException();
            object = parcel2.readString();
            return object;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public PlaybackStateCompat getPlaybackState() {
        int n10;
        Object object;
        Parcel parcel;
        Parcel parcel2;
        block12: {
            block11: {
                parcel2 = Parcel.obtain();
                parcel = Parcel.obtain();
                object = "android.support.v4.media.session.IMediaSession";
                parcel2.writeInterfaceToken((String)object);
                object = this.mRemote;
                int n11 = 28;
                n10 = object.transact(n11, parcel2, parcel, 0);
                if (n10 != 0) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                if (object == null) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                object = object.getPlaybackState();
                return object;
            }
            parcel.readException();
            n10 = parcel.readInt();
            if (n10 == 0) break block12;
            object = PlaybackStateCompat.CREATOR;
            object = object.createFromParcel(parcel);
            object = (PlaybackStateCompat)object;
        }
        n10 = 0;
        object = null;
        parcel.recycle();
        parcel2.recycle();
        return object;
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public List getQueue() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 29;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object = object.getQueue();
                return object;
            }
            parcel2.readException();
            object = MediaSessionCompat$QueueItem.CREATOR;
            object = parcel2.createTypedArrayList((Parcelable.Creator)object);
            return object;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public CharSequence getQueueTitle() {
        int n10;
        Object object;
        Parcel parcel;
        Parcel parcel2;
        block12: {
            block11: {
                parcel2 = Parcel.obtain();
                parcel = Parcel.obtain();
                object = "android.support.v4.media.session.IMediaSession";
                parcel2.writeInterfaceToken((String)object);
                object = this.mRemote;
                int n11 = 30;
                n10 = object.transact(n11, parcel2, parcel, 0);
                if (n10 != 0) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                if (object == null) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                object = object.getQueueTitle();
                return object;
            }
            parcel.readException();
            n10 = parcel.readInt();
            if (n10 == 0) break block12;
            object = TextUtils.CHAR_SEQUENCE_CREATOR;
            object = object.createFromParcel(parcel);
            object = (CharSequence)object;
        }
        n10 = 0;
        object = null;
        parcel.recycle();
        parcel2.recycle();
        return object;
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public int getRatingType() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 32;
            int n11 = object.transact(n10, parcel, parcel2, 0);
            if (n11 == 0 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                n11 = object.getRatingType();
                return n11;
            }
            parcel2.readException();
            n11 = parcel2.readInt();
            return n11;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public int getRepeatMode() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 37;
            int n11 = object.transact(n10, parcel, parcel2, 0);
            if (n11 == 0 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                n11 = object.getRepeatMode();
                return n11;
            }
            parcel2.readException();
            n11 = parcel2.readInt();
            return n11;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public Bundle getSessionInfo() {
        int n10;
        Object object;
        Parcel parcel;
        Parcel parcel2;
        block12: {
            block11: {
                parcel2 = Parcel.obtain();
                parcel = Parcel.obtain();
                object = "android.support.v4.media.session.IMediaSession";
                parcel2.writeInterfaceToken((String)object);
                object = this.mRemote;
                int n11 = 50;
                n10 = object.transact(n11, parcel2, parcel, 0);
                if (n10 != 0) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                if (object == null) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                object = object.getSessionInfo();
                return object;
            }
            parcel.readException();
            n10 = parcel.readInt();
            if (n10 == 0) break block12;
            object = Bundle.CREATOR;
            object = object.createFromParcel(parcel);
            object = (Bundle)object;
        }
        n10 = 0;
        object = null;
        parcel.recycle();
        parcel2.recycle();
        return object;
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public int getShuffleMode() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 47;
            int n11 = object.transact(n10, parcel, parcel2, 0);
            if (n11 == 0 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                n11 = object.getShuffleMode();
                return n11;
            }
            parcel2.readException();
            n11 = parcel2.readInt();
            return n11;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public String getTag() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 7;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object = object.getTag();
                return object;
            }
            parcel2.readException();
            object = parcel2.readString();
            return object;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public ParcelableVolumeInfo getVolumeAttributes() {
        int n10;
        Object object;
        Parcel parcel;
        Parcel parcel2;
        block12: {
            block11: {
                parcel2 = Parcel.obtain();
                parcel = Parcel.obtain();
                object = "android.support.v4.media.session.IMediaSession";
                parcel2.writeInterfaceToken((String)object);
                object = this.mRemote;
                int n11 = 10;
                n10 = object.transact(n11, parcel2, parcel, 0);
                if (n10 != 0) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                if (object == null) break block11;
                object = IMediaSession$Stub.getDefaultImpl();
                object = object.getVolumeAttributes();
                return object;
            }
            parcel.readException();
            n10 = parcel.readInt();
            if (n10 == 0) break block12;
            object = ParcelableVolumeInfo.CREATOR;
            object = object.createFromParcel(parcel);
            object = (ParcelableVolumeInfo)object;
        }
        n10 = 0;
        object = null;
        parcel.recycle();
        parcel2.recycle();
        return object;
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public boolean isCaptioningEnabled() {
        boolean bl2;
        Parcel parcel;
        Parcel parcel2;
        block9: {
            block8: {
                parcel2 = Parcel.obtain();
                parcel = Parcel.obtain();
                Object object = "android.support.v4.media.session.IMediaSession";
                parcel2.writeInterfaceToken((String)object);
                object = this.mRemote;
                int n10 = 45;
                bl2 = false;
                boolean bl3 = object.transact(n10, parcel2, parcel, 0);
                if (bl3) break block8;
                object = IMediaSession$Stub.getDefaultImpl();
                if (object == null) break block8;
                object = IMediaSession$Stub.getDefaultImpl();
                boolean bl4 = object.isCaptioningEnabled();
                return bl4;
            }
            parcel.readException();
            int n10 = parcel.readInt();
            if (n10 == 0) break block9;
            bl2 = true;
        }
        parcel.recycle();
        parcel2.recycle();
        return bl2;
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public boolean isShuffleModeEnabledRemoved() {
        boolean bl2;
        Parcel parcel;
        Parcel parcel2;
        block9: {
            block8: {
                parcel2 = Parcel.obtain();
                parcel = Parcel.obtain();
                Object object = "android.support.v4.media.session.IMediaSession";
                parcel2.writeInterfaceToken((String)object);
                object = this.mRemote;
                int n10 = 38;
                bl2 = false;
                boolean bl3 = object.transact(n10, parcel2, parcel, 0);
                if (bl3) break block8;
                object = IMediaSession$Stub.getDefaultImpl();
                if (object == null) break block8;
                object = IMediaSession$Stub.getDefaultImpl();
                boolean bl4 = object.isShuffleModeEnabledRemoved();
                return bl4;
            }
            parcel.readException();
            int n10 = parcel.readInt();
            if (n10 == 0) break block9;
            bl2 = true;
        }
        parcel.recycle();
        parcel2.recycle();
        return bl2;
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public boolean isTransportControlEnabled() {
        boolean bl2;
        Parcel parcel;
        Parcel parcel2;
        block9: {
            block8: {
                parcel2 = Parcel.obtain();
                parcel = Parcel.obtain();
                Object object = "android.support.v4.media.session.IMediaSession";
                parcel2.writeInterfaceToken((String)object);
                object = this.mRemote;
                int n10 = 5;
                bl2 = false;
                boolean bl3 = object.transact(n10, parcel2, parcel, 0);
                if (bl3) break block8;
                object = IMediaSession$Stub.getDefaultImpl();
                if (object == null) break block8;
                object = IMediaSession$Stub.getDefaultImpl();
                boolean bl4 = object.isTransportControlEnabled();
                return bl4;
            }
            parcel.readException();
            int n10 = parcel.readInt();
            if (n10 == 0) break block9;
            bl2 = true;
        }
        parcel.recycle();
        parcel2.recycle();
        return bl2;
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public void next() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 20;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.next();
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void pause() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 18;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.pause();
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void play() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 13;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.play();
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void playFromMediaId(String string2, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeString(string2);
            boolean bl2 = false;
            object = null;
            if (bundle != null) {
                int n10 = 1;
                parcel.writeInt(n10);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = this.mRemote;
            int n11 = 14;
            bl2 = iBinder.transact(n11, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.playFromMediaId(string2, bundle);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void playFromSearch(String string2, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeString(string2);
            boolean bl2 = false;
            object = null;
            if (bundle != null) {
                int n10 = 1;
                parcel.writeInt(n10);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = this.mRemote;
            int n11 = 15;
            bl2 = iBinder.transact(n11, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.playFromSearch(string2, bundle);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void playFromUri(Uri uri, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            int n10 = 1;
            if (uri != null) {
                parcel.writeInt(n10);
                uri.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (bundle != null) {
                parcel.writeInt(n10);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            object = this.mRemote;
            int n11 = 16;
            n10 = (int)(object.transact(n11, parcel, parcel2, 0) ? 1 : 0);
            if (n10 == 0 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.playFromUri(uri, bundle);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void prepare() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 33;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.prepare();
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void prepareFromMediaId(String string2, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeString(string2);
            boolean bl2 = false;
            object = null;
            if (bundle != null) {
                int n10 = 1;
                parcel.writeInt(n10);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = this.mRemote;
            int n11 = 34;
            bl2 = iBinder.transact(n11, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.prepareFromMediaId(string2, bundle);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void prepareFromSearch(String string2, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeString(string2);
            boolean bl2 = false;
            object = null;
            if (bundle != null) {
                int n10 = 1;
                parcel.writeInt(n10);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = this.mRemote;
            int n11 = 35;
            bl2 = iBinder.transact(n11, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.prepareFromSearch(string2, bundle);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void prepareFromUri(Uri uri, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            int n10 = 1;
            if (uri != null) {
                parcel.writeInt(n10);
                uri.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (bundle != null) {
                parcel.writeInt(n10);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            object = this.mRemote;
            int n11 = 36;
            n10 = (int)(object.transact(n11, parcel, parcel2, 0) ? 1 : 0);
            if (n10 == 0 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.prepareFromUri(uri, bundle);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void previous() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 21;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.previous();
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void rate(RatingCompat ratingCompat) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            boolean bl2 = false;
            object = null;
            if (ratingCompat != null) {
                int n10 = 1;
                parcel.writeInt(n10);
                ratingCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = this.mRemote;
            int n11 = 25;
            bl2 = iBinder.transact(n11, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.rate(ratingCompat);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            int n10 = 1;
            if (ratingCompat != null) {
                parcel.writeInt(n10);
                ratingCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (bundle != null) {
                parcel.writeInt(n10);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            object = this.mRemote;
            int n11 = 51;
            n10 = (int)(object.transact(n11, parcel, parcel2, 0) ? 1 : 0);
            if (n10 == 0 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.rateWithExtras(ratingCompat, bundle);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            boolean bl2;
            parcel.writeInterfaceToken((String)object);
            if (iMediaControllerCallback != null) {
                object = iMediaControllerCallback.asBinder();
            } else {
                bl2 = false;
                object = null;
            }
            parcel.writeStrongBinder((IBinder)object);
            object = this.mRemote;
            int n10 = 3;
            bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.registerCallbackListener(iMediaControllerCallback);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            boolean bl2 = false;
            object = null;
            if (mediaDescriptionCompat != null) {
                int n10 = 1;
                parcel.writeInt(n10);
                mediaDescriptionCompat.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = this.mRemote;
            int n11 = 43;
            bl2 = iBinder.transact(n11, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.removeQueueItem(mediaDescriptionCompat);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void removeQueueItemAt(int n10) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeInt(n10);
            object = this.mRemote;
            int n11 = 44;
            boolean bl2 = object.transact(n11, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.removeQueueItemAt(n10);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void rewind() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 23;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.rewind();
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void seekTo(long l10) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeLong(l10);
            object = this.mRemote;
            int n10 = 24;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.seekTo(l10);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void sendCommand(String string2, Bundle bundle, MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeString(string2);
            int n10 = 1;
            if (bundle != null) {
                parcel.writeInt(n10);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (mediaSessionCompat$ResultReceiverWrapper != null) {
                parcel.writeInt(n10);
                mediaSessionCompat$ResultReceiverWrapper.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = this.mRemote;
            n10 = (int)(iBinder.transact(n10, parcel, parcel2, 0) ? 1 : 0);
            if (n10 == 0 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.sendCommand(string2, bundle, mediaSessionCompat$ResultReceiverWrapper);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void sendCustomAction(String string2, Bundle bundle) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeString(string2);
            boolean bl2 = false;
            object = null;
            if (bundle != null) {
                int n10 = 1;
                parcel.writeInt(n10);
                bundle.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = this.mRemote;
            int n11 = 26;
            bl2 = iBinder.transact(n11, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.sendCustomAction(string2, bundle);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean sendMediaButton(KeyEvent keyEvent) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            IMediaSession iMediaSession;
            parcel.writeInterfaceToken((String)object);
            boolean bl2 = true;
            if (keyEvent != null) {
                parcel.writeInt((int)(bl2 ? 1 : 0));
                keyEvent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = this.mRemote;
            int n10 = 2;
            boolean bl3 = iBinder.transact(n10, parcel, parcel2, 0);
            if (!bl3 && (iMediaSession = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                boolean bl4 = object.sendMediaButton(keyEvent);
                return bl4;
            }
            parcel2.readException();
            int n11 = parcel2.readInt();
            if (n11 != 0) {
                return bl2;
            } else {
                bl2 = false;
                object = null;
            }
            return bl2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void setCaptioningEnabled(boolean bl2) {
        IBinder iBinder;
        int n10;
        boolean bl3;
        Object object;
        Parcel parcel;
        Parcel parcel2;
        block11: {
            parcel2 = Parcel.obtain();
            parcel = Parcel.obtain();
            object = "android.support.v4.media.session.IMediaSession";
            parcel2.writeInterfaceToken((String)object);
            bl3 = false;
            object = null;
            if (bl2) {
                n10 = 1;
                break block11;
            }
            n10 = 0;
            iBinder = null;
        }
        try {
            parcel2.writeInt(n10);
            iBinder = this.mRemote;
            int n11 = 46;
            bl3 = iBinder.transact(n11, parcel2, parcel, 0);
            if (!bl3 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.setCaptioningEnabled(bl2);
                return;
            }
            parcel.readException();
            return;
        }
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public void setPlaybackSpeed(float f10) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeFloat(f10);
            object = this.mRemote;
            int n10 = 49;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.setPlaybackSpeed(f10);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void setRepeatMode(int n10) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeInt(n10);
            object = this.mRemote;
            int n11 = 39;
            boolean bl2 = object.transact(n11, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.setRepeatMode(n10);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void setShuffleMode(int n10) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeInt(n10);
            object = this.mRemote;
            int n11 = 48;
            boolean bl2 = object.transact(n11, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.setShuffleMode(n10);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void setShuffleModeEnabledRemoved(boolean bl2) {
        IBinder iBinder;
        int n10;
        boolean bl3;
        Object object;
        Parcel parcel;
        Parcel parcel2;
        block11: {
            parcel2 = Parcel.obtain();
            parcel = Parcel.obtain();
            object = "android.support.v4.media.session.IMediaSession";
            parcel2.writeInterfaceToken((String)object);
            bl3 = false;
            object = null;
            if (bl2) {
                n10 = 1;
                break block11;
            }
            n10 = 0;
            iBinder = null;
        }
        try {
            parcel2.writeInt(n10);
            iBinder = this.mRemote;
            int n11 = 40;
            bl3 = iBinder.transact(n11, parcel2, parcel, 0);
            if (!bl3 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.setShuffleModeEnabledRemoved(bl2);
                return;
            }
            parcel.readException();
            return;
        }
        finally {
            parcel.recycle();
            parcel2.recycle();
        }
    }

    public void setVolumeTo(int n10, int n11, String string2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeInt(n10);
            parcel.writeInt(n11);
            parcel.writeString(string2);
            object = this.mRemote;
            int n12 = 12;
            boolean bl2 = object.transact(n12, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.setVolumeTo(n10, n11, string2);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void skipToQueueItem(long l10) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            parcel.writeLong(l10);
            object = this.mRemote;
            int n10 = 17;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.skipToQueueItem(l10);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public void stop() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            parcel.writeInterfaceToken((String)object);
            object = this.mRemote;
            int n10 = 19;
            boolean bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.stop();
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        Object object = "android.support.v4.media.session.IMediaSession";
        try {
            boolean bl2;
            parcel.writeInterfaceToken((String)object);
            if (iMediaControllerCallback != null) {
                object = iMediaControllerCallback.asBinder();
            } else {
                bl2 = false;
                object = null;
            }
            parcel.writeStrongBinder((IBinder)object);
            object = this.mRemote;
            int n10 = 4;
            bl2 = object.transact(n10, parcel, parcel2, 0);
            if (!bl2 && (object = IMediaSession$Stub.getDefaultImpl()) != null) {
                object = IMediaSession$Stub.getDefaultImpl();
                object.unregisterCallbackListener(iMediaControllerCallback);
                return;
            }
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

