/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.session.MediaSession$Token
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.IMediaSession$Stub;
import android.support.v4.media.session.MediaSessionCompat$Token$1;
import androidx.core.app.BundleCompat;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;

public final class MediaSessionCompat$Token
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private IMediaSession mExtraBinder;
    private final Object mInner;
    private final Object mLock;
    private VersionedParcelable mSession2Token;

    static {
        MediaSessionCompat$Token$1 mediaSessionCompat$Token$1 = new MediaSessionCompat$Token$1();
        CREATOR = mediaSessionCompat$Token$1;
    }

    public MediaSessionCompat$Token(Object object) {
        this(object, null, null);
    }

    public MediaSessionCompat$Token(Object object, IMediaSession iMediaSession) {
        this(object, iMediaSession, null);
    }

    public MediaSessionCompat$Token(Object object, IMediaSession iMediaSession, VersionedParcelable versionedParcelable) {
        Object object2;
        this.mLock = object2 = new Object();
        this.mInner = object;
        this.mExtraBinder = iMediaSession;
        this.mSession2Token = versionedParcelable;
    }

    public static MediaSessionCompat$Token fromBundle(Bundle object) {
        MediaSessionCompat$Token mediaSessionCompat$Token = null;
        if (object == null) {
            return null;
        }
        IMediaSession iMediaSession = IMediaSession$Stub.asInterface(BundleCompat.getBinder(object, "android.support.v4.media.session.EXTRA_BINDER"));
        VersionedParcelable versionedParcelable = ParcelUtils.getVersionedParcelable(object, "android.support.v4.media.session.SESSION_TOKEN2");
        String string2 = "android.support.v4.media.session.TOKEN";
        if ((object = (MediaSessionCompat$Token)object.getParcelable(string2)) != null) {
            object = object.mInner;
            mediaSessionCompat$Token = new MediaSessionCompat$Token(object, iMediaSession, versionedParcelable);
        }
        return mediaSessionCompat$Token;
    }

    public static MediaSessionCompat$Token fromToken(Object object) {
        return MediaSessionCompat$Token.fromToken(object, null);
    }

    public static MediaSessionCompat$Token fromToken(Object object, IMediaSession iMediaSession) {
        int n10;
        int n11;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            n11 = object instanceof MediaSession.Token;
            if (n11 != 0) {
                MediaSessionCompat$Token mediaSessionCompat$Token = new MediaSessionCompat$Token(object, iMediaSession);
                return mediaSessionCompat$Token;
            }
            object = new IllegalArgumentException("token is not a valid MediaSession.Token object");
            throw object;
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof MediaSessionCompat$Token;
        if (!bl3) {
            return false;
        }
        object = (MediaSessionCompat$Token)object;
        Object object2 = this.mInner;
        if (object2 == null) {
            object = ((MediaSessionCompat$Token)object).mInner;
            if (object != null) {
                bl2 = false;
            }
            return bl2;
        }
        object = ((MediaSessionCompat$Token)object).mInner;
        if (object == null) {
            return false;
        }
        return object2.equals(object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public IMediaSession getExtraBinder() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mExtraBinder;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public VersionedParcelable getSession2Token() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mSession2Token;
        }
    }

    public Object getToken() {
        return this.mInner;
    }

    public int hashCode() {
        Object object = this.mInner;
        if (object == null) {
            return 0;
        }
        return object.hashCode();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setExtraBinder(IMediaSession iMediaSession) {
        Object object = this.mLock;
        synchronized (object) {
            this.mExtraBinder = iMediaSession;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setSession2Token(VersionedParcelable versionedParcelable) {
        Object object = this.mLock;
        synchronized (object) {
            this.mSession2Token = versionedParcelable;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.v4.media.session.TOKEN", (Parcelable)this);
        Object object = this.mLock;
        synchronized (object) {
            String string2;
            Object object2 = this.mExtraBinder;
            if (object2 != null) {
                string2 = "android.support.v4.media.session.EXTRA_BINDER";
                object2 = object2.asBinder();
                BundleCompat.putBinder(bundle, string2, (IBinder)object2);
            }
            if ((object2 = this.mSession2Token) != null) {
                string2 = "android.support.v4.media.session.SESSION_TOKEN2";
                ParcelUtils.putVersionedParcelable(bundle, string2, (VersionedParcelable)object2);
            }
            return bundle;
        }
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            Parcelable parcelable = (Parcelable)this.mInner;
            parcel.writeParcelable(parcelable, n10);
        } else {
            IBinder iBinder = (IBinder)this.mInner;
            parcel.writeStrongBinder(iBinder);
        }
    }
}

