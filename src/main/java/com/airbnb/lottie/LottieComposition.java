/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LottieComposition {
    private Rect bounds;
    private SparseArrayCompat characters;
    private float endFrame;
    private Map fonts;
    private float frameRate;
    private boolean hasDashPattern;
    private Map images;
    private LongSparseArray layerMap;
    private List layers;
    private List markers;
    private int maskAndMatteCount;
    private final PerformanceTracker performanceTracker;
    private Map precomps;
    private float startFrame;
    private final HashSet warnings;

    public LottieComposition() {
        HashSet hashSet = new HashSet();
        this.performanceTracker = hashSet;
        this.warnings = hashSet = new HashSet();
        this.maskAndMatteCount = 0;
    }

    public void addWarning(String string2) {
        Logger.warning(string2);
        this.warnings.add(string2);
    }

    public Rect getBounds() {
        return this.bounds;
    }

    public SparseArrayCompat getCharacters() {
        return this.characters;
    }

    public float getDuration() {
        float f10 = this.getDurationFrames();
        float f11 = this.frameRate;
        return (long)(f10 / f11 * 1000.0f);
    }

    public float getDurationFrames() {
        float f10 = this.endFrame;
        float f11 = this.startFrame;
        return f10 - f11;
    }

    public float getEndFrame() {
        return this.endFrame;
    }

    public Map getFonts() {
        return this.fonts;
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public Map getImages() {
        return this.images;
    }

    public List getLayers() {
        return this.layers;
    }

    public Marker getMarker(String string2) {
        Object object;
        int n10;
        this.markers.size();
        for (int i10 = 0; i10 < (n10 = (object = this.markers).size()); ++i10) {
            object = (Marker)this.markers.get(i10);
            boolean bl2 = ((Marker)object).matchesName(string2);
            if (!bl2) continue;
            return object;
        }
        return null;
    }

    public List getMarkers() {
        return this.markers;
    }

    public int getMaskAndMatteCount() {
        return this.maskAndMatteCount;
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.performanceTracker;
    }

    public List getPrecomps(String string2) {
        return (List)this.precomps.get(string2);
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public ArrayList getWarnings() {
        Collection<Object> collection = this.warnings;
        String[] stringArray = new String[collection.size()];
        collection = Arrays.asList(collection.toArray(stringArray));
        ArrayList arrayList = new ArrayList(collection);
        return arrayList;
    }

    public boolean hasDashPattern() {
        return this.hasDashPattern;
    }

    public boolean hasImages() {
        return this.images.isEmpty() ^ true;
    }

    public void incrementMatteOrMaskCount(int n10) {
        int n11;
        this.maskAndMatteCount = n11 = this.maskAndMatteCount + n10;
    }

    public void init(Rect rect, float f10, float f11, float f12, List list, LongSparseArray longSparseArray, Map map, Map map2, SparseArrayCompat sparseArrayCompat, Map map3, List list2) {
        this.bounds = rect;
        this.startFrame = f10;
        this.endFrame = f11;
        this.frameRate = f12;
        this.layers = list;
        this.layerMap = longSparseArray;
        this.precomps = map;
        this.images = map2;
        this.characters = sparseArrayCompat;
        this.fonts = map3;
        this.markers = list2;
    }

    public Layer layerModelForId(long l10) {
        return (Layer)this.layerMap.get(l10);
    }

    public void setHasDashPattern(boolean bl2) {
        this.hasDashPattern = bl2;
    }

    public void setPerformanceTrackingEnabled(boolean bl2) {
        this.performanceTracker.setEnabled(bl2);
    }

    public String toString() {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder("LottieComposition:\n");
        Iterator iterator2 = this.layers.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (Layer)iterator2.next();
            String string2 = "\t";
            object = ((Layer)object).toString(string2);
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString();
    }
}

