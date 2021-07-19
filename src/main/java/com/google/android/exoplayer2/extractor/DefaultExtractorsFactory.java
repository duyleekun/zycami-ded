/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.google.android.exoplayer2.extractor.flac.FlacExtractor;
import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.jpeg.JpegExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import com.google.android.exoplayer2.util.FileTypes;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DefaultExtractorsFactory
implements ExtractorsFactory {
    private static final int[] DEFAULT_EXTRACTOR_ORDER;
    private static final Constructor FLAC_EXTENSION_EXTRACTOR_CONSTRUCTOR;
    private int adtsFlags;
    private int amrFlags;
    private boolean constantBitrateSeekingEnabled;
    private int flacFlags;
    private int fragmentedMp4Flags;
    private int matroskaFlags;
    private int mp3Flags;
    private int mp4Flags;
    private int tsFlags;
    private int tsMode = 1;
    private int tsTimestampSearchBytes = 112800;

    static {
        Object object;
        block15: {
            int[] nArray = object = new int[14];
            int[] nArray2 = object;
            nArray[0] = 5;
            nArray2[1] = 4;
            nArray[2] = 12;
            nArray2[3] = 8;
            nArray[4] = 3;
            nArray2[5] = 10;
            nArray[6] = 9;
            nArray2[7] = 11;
            nArray[8] = 6;
            nArray2[9] = 2;
            nArray[10] = 0;
            nArray2[11] = 1;
            nArray[12] = 7;
            nArray2[13] = 14;
            DEFAULT_EXTRACTOR_ORDER = object;
            object = null;
            Class<Object> clazz = Boolean.TRUE;
            Class[] classArray = "com.google.android.exoplayer2.ext.flac.FlacLibrary";
            classArray = Class.forName((String)classArray);
            Object object2 = "isAvailable";
            Class[] classArray2 = new Class[]{};
            classArray = classArray.getMethod((String)object2, classArray2);
            object2 = new Object[]{};
            classArray = classArray.invoke(null, object2);
            boolean bl2 = ((Boolean)((Object)clazz)).equals(classArray);
            if (!bl2) break block15;
            clazz = "com.google.android.exoplayer2.ext.flac.FlacExtractor";
            clazz = Class.forName((String)((Object)clazz));
            classArray = Extractor.class;
            clazz = clazz.asSubclass(classArray);
            int n10 = 1;
            classArray = new Class[n10];
            object2 = Integer.TYPE;
            classArray[0] = object2;
            try {
                object = clazz.getConstructor(classArray);
            }
            catch (Exception exception) {
                clazz = new Class<Object>("Error instantiating FLAC extension", (Throwable)exception);
                throw clazz;
            }
            catch (ClassNotFoundException classNotFoundException) {}
        }
        FLAC_EXTENSION_EXTRACTOR_CONSTRUCTOR = object;
    }

    private void addExtractorsForFileType(int n10, List object) {
        switch (n10) {
            default: {
                break;
            }
            case 14: {
                JpegExtractor jpegExtractor = new JpegExtractor();
                object.add(jpegExtractor);
                break;
            }
            case 12: {
                WavExtractor wavExtractor = new WavExtractor();
                object.add(wavExtractor);
                break;
            }
            case 11: {
                int n11 = this.tsMode;
                int n12 = this.tsFlags;
                int n13 = this.tsTimestampSearchBytes;
                TsExtractor tsExtractor = new TsExtractor(n11, n12, n13);
                object.add(tsExtractor);
                break;
            }
            case 10: {
                PsExtractor psExtractor = new PsExtractor();
                object.add(psExtractor);
                break;
            }
            case 9: {
                OggExtractor oggExtractor = new OggExtractor();
                object.add(oggExtractor);
                break;
            }
            case 8: {
                int n14 = this.fragmentedMp4Flags;
                Extractor extractor = new FragmentedMp4Extractor(n14);
                object.add(extractor);
                n14 = this.mp4Flags;
                extractor = new Mp4Extractor(n14);
                object.add(extractor);
                break;
            }
            case 7: {
                int n15 = this.mp3Flags;
                int n16 = this.constantBitrateSeekingEnabled;
                Mp3Extractor mp3Extractor = new Mp3Extractor(n15 |= n16);
                object.add(mp3Extractor);
                break;
            }
            case 6: {
                int n17 = this.matroskaFlags;
                MatroskaExtractor matroskaExtractor = new MatroskaExtractor(n17);
                object.add(matroskaExtractor);
                break;
            }
            case 5: {
                FlvExtractor flvExtractor = new FlvExtractor();
                object.add(flvExtractor);
                break;
            }
            case 4: {
                Object object2 = FLAC_EXTENSION_EXTRACTOR_CONSTRUCTOR;
                if (object2 != null) {
                    Object[] objectArray;
                    int n18 = 1;
                    try {
                        objectArray = new Object[n18];
                        boolean bl2 = false;
                    }
                    catch (Exception exception) {
                        object = new IllegalStateException("Unexpected error creating FLAC extractor", exception);
                        throw object;
                    }
                    int n19 = this.flacFlags;
                    Integer n20 = n19;
                    objectArray[0] = n20;
                    object2 = ((Constructor)object2).newInstance(objectArray);
                    object2 = (Extractor)object2;
                    object.add(object2);
                    break;
                }
                int n21 = this.flacFlags;
                object2 = new FlacExtractor(n21);
                object.add(object2);
                break;
            }
            case 3: {
                int n22 = this.amrFlags;
                int n23 = this.constantBitrateSeekingEnabled;
                AmrExtractor amrExtractor = new AmrExtractor(n22 |= n23);
                object.add(amrExtractor);
                break;
            }
            case 2: {
                int n24 = this.adtsFlags;
                int n25 = this.constantBitrateSeekingEnabled;
                AdtsExtractor adtsExtractor = new AdtsExtractor(n24 |= n25);
                object.add(adtsExtractor);
                break;
            }
            case 1: {
                Ac4Extractor ac4Extractor = new Ac4Extractor();
                object.add(ac4Extractor);
                break;
            }
            case 0: {
                Ac3Extractor ac3Extractor = new Ac3Extractor();
                object.add(ac3Extractor);
            }
        }
    }

    public Extractor[] createExtractors() {
        synchronized (this) {
            Extractor[] extractorArray = Uri.EMPTY;
            HashMap hashMap = new HashMap();
            extractorArray = this.createExtractors((Uri)extractorArray, hashMap);
            return extractorArray;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Extractor[] createExtractors(Uri extractorArray, Map map) {
        synchronized (this) {
            int n10;
            void var2_2;
            int n11 = 14;
            ArrayList arrayList = new ArrayList(n11);
            int n12 = FileTypes.inferFileTypeFromResponseHeaders((Map)var2_2);
            n11 = -1;
            if (n12 != n11) {
                this.addExtractorsForFileType(n12, arrayList);
            }
            if ((n10 = FileTypes.inferFileTypeFromUri((Uri)extractorArray)) != n11 && n10 != n12) {
                this.addExtractorsForFileType(n10, arrayList);
            }
            int[] nArray = DEFAULT_EXTRACTOR_ORDER;
            int n13 = nArray.length;
            int n14 = 0;
            while (true) {
                if (n14 >= n13) {
                    n10 = arrayList.size();
                    extractorArray = new Extractor[n10];
                    return arrayList.toArray(extractorArray);
                }
                int n15 = nArray[n14];
                if (n15 != n12 && n15 != n10) {
                    this.addExtractorsForFileType(n15, arrayList);
                }
                ++n14;
            }
        }
    }

    public DefaultExtractorsFactory setAdtsExtractorFlags(int n10) {
        synchronized (this) {
            this.adtsFlags = n10;
            return this;
        }
    }

    public DefaultExtractorsFactory setAmrExtractorFlags(int n10) {
        synchronized (this) {
            this.amrFlags = n10;
            return this;
        }
    }

    public DefaultExtractorsFactory setConstantBitrateSeekingEnabled(boolean bl2) {
        synchronized (this) {
            this.constantBitrateSeekingEnabled = bl2;
            return this;
        }
    }

    public DefaultExtractorsFactory setFlacExtractorFlags(int n10) {
        synchronized (this) {
            this.flacFlags = n10;
            return this;
        }
    }

    public DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int n10) {
        synchronized (this) {
            this.fragmentedMp4Flags = n10;
            return this;
        }
    }

    public DefaultExtractorsFactory setMatroskaExtractorFlags(int n10) {
        synchronized (this) {
            this.matroskaFlags = n10;
            return this;
        }
    }

    public DefaultExtractorsFactory setMp3ExtractorFlags(int n10) {
        synchronized (this) {
            this.mp3Flags = n10;
            return this;
        }
    }

    public DefaultExtractorsFactory setMp4ExtractorFlags(int n10) {
        synchronized (this) {
            this.mp4Flags = n10;
            return this;
        }
    }

    public DefaultExtractorsFactory setTsExtractorFlags(int n10) {
        synchronized (this) {
            this.tsFlags = n10;
            return this;
        }
    }

    public DefaultExtractorsFactory setTsExtractorMode(int n10) {
        synchronized (this) {
            this.tsMode = n10;
            return this;
        }
    }

    public DefaultExtractorsFactory setTsExtractorTimestampSearchBytes(int n10) {
        synchronized (this) {
            this.tsTimestampSearchBytes = n10;
            return this;
        }
    }
}

