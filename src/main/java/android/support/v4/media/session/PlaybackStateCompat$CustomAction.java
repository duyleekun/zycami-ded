/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.session.PlaybackState$CustomAction
 *  android.media.session.PlaybackState$CustomAction$Builder
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat$CustomAction$1;
import android.text.TextUtils;

public final class PlaybackStateCompat$CustomAction
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final String mAction;
    private PlaybackState.CustomAction mCustomActionFwk;
    private final Bundle mExtras;
    private final int mIcon;
    private final CharSequence mName;

    static {
        PlaybackStateCompat$CustomAction$1 playbackStateCompat$CustomAction$1 = new PlaybackStateCompat$CustomAction$1();
        CREATOR = playbackStateCompat$CustomAction$1;
    }

    public PlaybackStateCompat$CustomAction(Parcel parcel) {
        int n10;
        Object object = parcel.readString();
        this.mAction = object;
        object = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mName = object;
        this.mIcon = n10 = parcel.readInt();
        object = MediaSessionCompat.class.getClassLoader();
        parcel = parcel.readBundle((ClassLoader)object);
        this.mExtras = parcel;
    }

    public PlaybackStateCompat$CustomAction(String string2, CharSequence charSequence, int n10, Bundle bundle) {
        this.mAction = string2;
        this.mName = charSequence;
        this.mIcon = n10;
        this.mExtras = bundle;
    }

    public static PlaybackStateCompat$CustomAction fromCustomAction(Object object) {
        int n10;
        int n11;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            object = (PlaybackState.CustomAction)object;
            Bundle bundle = object.getExtras();
            MediaSessionCompat.ensureClassLoader(bundle);
            String string2 = object.getAction();
            CharSequence charSequence = object.getName();
            int n12 = object.getIcon();
            PlaybackStateCompat$CustomAction playbackStateCompat$CustomAction = new PlaybackStateCompat$CustomAction(string2, charSequence, n12, bundle);
            playbackStateCompat$CustomAction.mCustomActionFwk = object;
            return playbackStateCompat$CustomAction;
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.mAction;
    }

    public Object getCustomAction() {
        int n10;
        int n11;
        PlaybackState.CustomAction customAction = this.mCustomActionFwk;
        if (customAction == null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            String string2 = this.mAction;
            CharSequence charSequence = this.mName;
            int n12 = this.mIcon;
            customAction = new PlaybackState.CustomAction.Builder(string2, charSequence, n12);
            string2 = this.mExtras;
            customAction.setExtras((Bundle)string2);
            customAction = customAction.build();
        }
        return customAction;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getIcon() {
        return this.mIcon;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Action:mName='");
        CharSequence charSequence = this.mName;
        stringBuilder.append((Object)charSequence);
        stringBuilder.append(", mIcon=");
        int n10 = this.mIcon;
        stringBuilder.append(n10);
        stringBuilder.append(", mExtras=");
        charSequence = this.mExtras;
        stringBuilder.append((Object)charSequence);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.mAction;
        parcel.writeString(string2);
        TextUtils.writeToParcel((CharSequence)this.mName, (Parcel)parcel, (int)n10);
        n10 = this.mIcon;
        parcel.writeInt(n10);
        Bundle bundle = this.mExtras;
        parcel.writeBundle(bundle);
    }
}

