/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.util.Arrays;

public final class LibraryLoader {
    private static final String TAG = "LibraryLoader";
    private boolean isAvailable;
    private boolean loadAttempted;
    private String[] nativeLibraries;

    public LibraryLoader(String ... stringArray) {
        this.nativeLibraries = stringArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isAvailable() {
        synchronized (this) {
            boolean bl2 = this.loadAttempted;
            if (bl2) {
                return this.isAvailable;
            }
            this.loadAttempted = bl2 = true;
            try {
                for (String string2 : this.nativeLibraries) {
                    System.loadLibrary(string2);
                }
                this.isAvailable = bl2;
                return this.isAvailable;
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                String string3 = TAG;
                Object object = "Failed to load ";
                Object object2 = this.nativeLibraries;
                object2 = Arrays.toString((Object[])object2);
                object2 = String.valueOf(object2);
                int n10 = ((String)object2).length();
                object = n10 != 0 ? ((String)object).concat((String)object2) : (object2 = new String((String)object));
                Log.w(string3, (String)object);
            }
            return this.isAvailable;
        }
    }

    public void setLibraries(String ... stringArray) {
        synchronized (this) {
            boolean bl2 = this.loadAttempted;
            bl2 = !bl2;
            String string2 = "Cannot set libraries after loading";
            Assertions.checkState(bl2, string2);
            this.nativeLibraries = stringArray;
            return;
        }
    }
}

