/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.Config$OptionPriority;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.MultiValueSet;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.MutableTagBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class CaptureConfig$Builder {
    private List mCameraCaptureCallbacks;
    private MutableConfig mImplementationOptions;
    private MutableTagBundle mMutableTagBundle;
    private final Set mSurfaces;
    private int mTemplateType;
    private boolean mUseRepeatingSurface;

    public CaptureConfig$Builder() {
        Object object = new HashSet();
        this.mSurfaces = object;
        this.mImplementationOptions = object = MutableOptionsBundle.create();
        this.mTemplateType = -1;
        object = new ArrayList();
        this.mCameraCaptureCallbacks = object;
        this.mUseRepeatingSurface = false;
        this.mMutableTagBundle = object = MutableTagBundle.create();
    }

    private CaptureConfig$Builder(CaptureConfig object) {
        int n10;
        Object object2 = new HashSet();
        this.mSurfaces = object2;
        Object object3 = MutableOptionsBundle.create();
        this.mImplementationOptions = object3;
        this.mTemplateType = -1;
        object3 = new ArrayList();
        this.mCameraCaptureCallbacks = object3;
        this.mUseRepeatingSurface = false;
        this.mMutableTagBundle = object3 = MutableTagBundle.create();
        object3 = ((CaptureConfig)object).mSurfaces;
        object2.addAll(object3);
        this.mImplementationOptions = object2 = MutableOptionsBundle.from(((CaptureConfig)object).mImplementationOptions);
        this.mTemplateType = n10 = ((CaptureConfig)object).mTemplateType;
        object2 = this.mCameraCaptureCallbacks;
        object3 = ((CaptureConfig)object).getCameraCaptureCallbacks();
        object2.addAll(object3);
        n10 = ((CaptureConfig)object).isUseRepeatingSurface() ? 1 : 0;
        this.mUseRepeatingSurface = n10;
        this.mMutableTagBundle = object = MutableTagBundle.from(((CaptureConfig)object).getTagBundle());
    }

    public static CaptureConfig$Builder createFrom(UseCaseConfig object) {
        Object object2 = object.getCaptureOptionUnpacker(null);
        if (object2 != null) {
            CaptureConfig$Builder captureConfig$Builder = new CaptureConfig$Builder();
            object2.unpack((UseCaseConfig)object, captureConfig$Builder);
            return captureConfig$Builder;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Implementation is missing option unpacker for ");
        String string2 = object.toString();
        object = object.getTargetName(string2);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public static CaptureConfig$Builder from(CaptureConfig captureConfig) {
        CaptureConfig$Builder captureConfig$Builder = new CaptureConfig$Builder(captureConfig);
        return captureConfig$Builder;
    }

    public void addAllCameraCaptureCallbacks(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback)object.next();
            this.addCameraCaptureCallback(cameraCaptureCallback);
        }
    }

    public void addAllTags(TagBundle tagBundle) {
        this.mMutableTagBundle.addTagBundle(tagBundle);
    }

    public void addCameraCaptureCallback(CameraCaptureCallback object) {
        List list = this.mCameraCaptureCallbacks;
        boolean bl2 = list.contains(object);
        if (!bl2) {
            this.mCameraCaptureCallbacks.add(object);
            return;
        }
        object = new IllegalArgumentException("duplicate camera capture callback");
        throw object;
    }

    public void addImplementationOption(Config$Option config$Option, Object object) {
        this.mImplementationOptions.insertOption(config$Option, object);
    }

    public void addImplementationOptions(Config config) {
        boolean bl2;
        Iterator iterator2 = config.listOptions().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (Config$Option)iterator2.next();
            Object object2 = this.mImplementationOptions.retrieveOption((Config$Option)object, null);
            Object object3 = config.retrieveOption((Config$Option)object);
            boolean bl3 = object2 instanceof MultiValueSet;
            if (bl3) {
                object2 = (MultiValueSet)object2;
                object3 = (MultiValueSet)object3;
                object = ((MultiValueSet)object3).getAllItems();
                ((MultiValueSet)object2).addAll((List)object);
                continue;
            }
            boolean bl4 = object3 instanceof MultiValueSet;
            if (bl4) {
                object3 = ((MultiValueSet)object3).clone();
            }
            object2 = this.mImplementationOptions;
            Config$OptionPriority config$OptionPriority = config.getOptionPriority((Config$Option)object);
            object2.insertOption((Config$Option)object, config$OptionPriority, object3);
        }
    }

    public void addSurface(DeferrableSurface deferrableSurface) {
        this.mSurfaces.add(deferrableSurface);
    }

    public void addTag(String string2, Integer n10) {
        this.mMutableTagBundle.putTag(string2, n10);
    }

    public CaptureConfig build() {
        CaptureConfig captureConfig;
        Object object = this.mSurfaces;
        ArrayList arrayList = new ArrayList(object);
        OptionsBundle optionsBundle = OptionsBundle.from(this.mImplementationOptions);
        int n10 = this.mTemplateType;
        List list = this.mCameraCaptureCallbacks;
        boolean bl2 = this.mUseRepeatingSurface;
        TagBundle tagBundle = TagBundle.from(this.mMutableTagBundle);
        object = captureConfig;
        captureConfig = new CaptureConfig(arrayList, optionsBundle, n10, list, bl2, tagBundle);
        return captureConfig;
    }

    public void clearSurfaces() {
        this.mSurfaces.clear();
    }

    public Config getImplementationOptions() {
        return this.mImplementationOptions;
    }

    public Set getSurfaces() {
        return this.mSurfaces;
    }

    public Integer getTag(String string2) {
        return this.mMutableTagBundle.getTag(string2);
    }

    public int getTemplateType() {
        return this.mTemplateType;
    }

    public boolean isUseRepeatingSurface() {
        return this.mUseRepeatingSurface;
    }

    public void removeSurface(DeferrableSurface deferrableSurface) {
        this.mSurfaces.remove(deferrableSurface);
    }

    public void setImplementationOptions(Config config) {
        config = MutableOptionsBundle.from(config);
        this.mImplementationOptions = config;
    }

    public void setTemplateType(int n10) {
        this.mTemplateType = n10;
    }

    public void setUseRepeatingSurface(boolean bl2) {
        this.mUseRepeatingSurface = bl2;
    }
}

