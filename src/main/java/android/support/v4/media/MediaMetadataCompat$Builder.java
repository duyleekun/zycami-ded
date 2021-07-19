/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.collection.SimpleArrayMap;

public final class MediaMetadataCompat$Builder {
    private final Bundle mBundle;

    public MediaMetadataCompat$Builder() {
        Bundle bundle;
        this.mBundle = bundle = new Bundle();
    }

    public MediaMetadataCompat$Builder(MediaMetadataCompat mediaMetadataCompat) {
        Bundle bundle;
        mediaMetadataCompat = mediaMetadataCompat.mBundle;
        this.mBundle = bundle = new Bundle((Bundle)mediaMetadataCompat);
        MediaSessionCompat.ensureClassLoader(bundle);
    }

    public MediaMetadataCompat$Builder(MediaMetadataCompat object, int n10) {
        this((MediaMetadataCompat)object);
        boolean bl2;
        object = this.mBundle.keySet().iterator();
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            Object object2 = this.mBundle.get(string2);
            int n11 = object2 instanceof Bitmap;
            if (n11 == 0 || (n11 = (object2 = (Bitmap)object2).getHeight()) <= n10 && (n11 = object2.getWidth()) <= n10) continue;
            object2 = this.scaleBitmap((Bitmap)object2, n10);
            this.putBitmap(string2, (Bitmap)object2);
        }
    }

    private Bitmap scaleBitmap(Bitmap bitmap, int n10) {
        float f10 = n10;
        float f11 = bitmap.getWidth();
        f11 = f10 / f11;
        float f12 = bitmap.getHeight();
        f10 /= f12;
        f10 = Math.min(f11, f10);
        int n11 = (int)((float)bitmap.getHeight() * f10);
        n10 = (int)((float)bitmap.getWidth() * f10);
        return Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n10, (int)n11, (boolean)true);
    }

    public MediaMetadataCompat build() {
        Bundle bundle = this.mBundle;
        MediaMetadataCompat mediaMetadataCompat = new MediaMetadataCompat(bundle);
        return mediaMetadataCompat;
    }

    public MediaMetadataCompat$Builder putBitmap(String string2, Bitmap object) {
        int n10;
        int n11;
        Object object2 = MediaMetadataCompat.METADATA_KEYS_TYPE;
        boolean n112 = ((SimpleArrayMap)object2).containsKey(string2);
        if (n112 && (n11 = ((Integer)(object2 = (Integer)((SimpleArrayMap)object2).get(string2))).intValue()) != (n10 = 2)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("The ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(" key cannot be used to put a Bitmap");
            string2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        this.mBundle.putParcelable(string2, (Parcelable)object);
        return this;
    }

    public MediaMetadataCompat$Builder putLong(String string2, long l10) {
        int n10;
        Object object = MediaMetadataCompat.METADATA_KEYS_TYPE;
        boolean bl2 = ((SimpleArrayMap)object).containsKey(string2);
        if (bl2 && (n10 = ((Integer)(object = (Integer)((SimpleArrayMap)object).get(string2))).intValue()) != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The ");
            stringBuilder.append(string2);
            stringBuilder.append(" key cannot be used to put a long");
            string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        this.mBundle.putLong(string2, l10);
        return this;
    }

    public MediaMetadataCompat$Builder putRating(String string2, RatingCompat object) {
        int n10;
        int n11;
        Object object2 = MediaMetadataCompat.METADATA_KEYS_TYPE;
        boolean n112 = ((SimpleArrayMap)object2).containsKey(string2);
        if (n112 && (n11 = ((Integer)(object2 = (Integer)((SimpleArrayMap)object2).get(string2))).intValue()) != (n10 = 3)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("The ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(" key cannot be used to put a Rating");
            string2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            object2 = this.mBundle;
            object = (Parcelable)((RatingCompat)object).getRating();
            object2.putParcelable(string2, (Parcelable)object);
        } else {
            object2 = this.mBundle;
            object2.putParcelable(string2, (Parcelable)object);
        }
        return this;
    }

    public MediaMetadataCompat$Builder putString(String string2, String object) {
        int n10;
        int n11;
        Object object2 = MediaMetadataCompat.METADATA_KEYS_TYPE;
        boolean n112 = ((SimpleArrayMap)object2).containsKey(string2);
        if (n112 && (n11 = ((Integer)(object2 = (Integer)((SimpleArrayMap)object2).get(string2))).intValue()) != (n10 = 1)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("The ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(" key cannot be used to put a String");
            string2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        this.mBundle.putCharSequence(string2, (CharSequence)object);
        return this;
    }

    public MediaMetadataCompat$Builder putText(String string2, CharSequence object) {
        int n10;
        int n11;
        Object object2 = MediaMetadataCompat.METADATA_KEYS_TYPE;
        boolean n112 = ((SimpleArrayMap)object2).containsKey(string2);
        if (n112 && (n11 = ((Integer)(object2 = (Integer)((SimpleArrayMap)object2).get(string2))).intValue()) != (n10 = 1)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("The ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(" key cannot be used to put a CharSequence");
            string2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        this.mBundle.putCharSequence(string2, (CharSequence)object);
        return this;
    }
}

