/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.graphics.SurfaceTexture
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.params.StreamConfigurationMap
 *  android.media.CamcorderProfile
 *  android.media.MediaRecorder
 *  android.os.Build$VERSION
 *  android.util.Pair
 *  android.util.Rational
 *  android.util.Size
 *  android.view.WindowManager
 */
package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import android.view.WindowManager;
import androidx.camera.camera2.internal.CamcorderProfileHelper;
import androidx.camera.camera2.internal.CameraUnavailableExceptionHelper;
import androidx.camera.camera2.internal.SupportedSurfaceCombination$CompareAspectRatiosByDistanceToTargetRatio;
import androidx.camera.camera2.internal.SupportedSurfaceCombination$CompareSizesByArea;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.workaround.ExcludedSupportedSizesContainer;
import androidx.camera.camera2.internal.compat.workaround.TargetAspectRatio;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceConfig$ConfigSize;
import androidx.camera.core.impl.SurfaceConfig$ConfigType;
import androidx.camera.core.impl.SurfaceSizeDefinition;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.core.util.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class SupportedSurfaceCombination {
    private static final int ALIGN16 = 16;
    private static final Rational ASPECT_RATIO_16_9;
    private static final Rational ASPECT_RATIO_3_4;
    private static final Rational ASPECT_RATIO_4_3;
    private static final Rational ASPECT_RATIO_9_16;
    private static final Size DEFAULT_SIZE;
    private static final Size MAX_PREVIEW_SIZE;
    private static final Size QUALITY_1080P_SIZE;
    private static final Size QUALITY_480P_SIZE;
    private static final String TAG = "SupportedSurfaceCombination";
    private static final Size ZERO_SIZE;
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final String mCameraId;
    private final CameraCharacteristicsCompat mCharacteristics;
    private final Map mExcludedSizeListCache;
    private final ExcludedSupportedSizesContainer mExcludedSupportedSizesContainer;
    private final int mHardwareLevel;
    private boolean mIsBurstCaptureSupported;
    private boolean mIsRawSupported;
    private final boolean mIsSensorLandscapeResolution;
    private final Map mMaxSizeCache;
    private Map mOutputSizesCache;
    private final List mSurfaceCombinations;
    private SurfaceSizeDefinition mSurfaceSizeDefinition;

    static {
        Size size;
        int n10 = 1920;
        int n11 = 1080;
        MAX_PREVIEW_SIZE = size = new Size(n10, n11);
        int n12 = 480;
        DEFAULT_SIZE = size = new Size(640, n12);
        ZERO_SIZE = size = new Size(0, 0);
        QUALITY_1080P_SIZE = size = new Size(n10, n11);
        QUALITY_480P_SIZE = size = new Size(720, n12);
        n10 = 4;
        n11 = 3;
        size = new Rational(n10, n11);
        ASPECT_RATIO_4_3 = size;
        size = new Rational(n11, n10);
        ASPECT_RATIO_3_4 = size;
        n10 = 16;
        n11 = 9;
        size = new Rational(n10, n11);
        ASPECT_RATIO_16_9 = size;
        size = new Rational(n11, n10);
        ASPECT_RATIO_9_16 = size;
    }

    public SupportedSurfaceCombination(Context context, String object, CameraManagerCompat cameraManagerCompat, CamcorderProfileHelper object2) {
        int n10;
        block9: {
            block8: {
                Object object3 = new ArrayList();
                this.mSurfaceCombinations = object3;
                this.mMaxSizeCache = object3;
                super();
                this.mExcludedSizeListCache = object3;
                this.mIsRawSupported = false;
                this.mIsBurstCaptureSupported = false;
                super();
                this.mOutputSizesCache = object3;
                this.mCameraId = object3 = (String)Preconditions.checkNotNull(object);
                object2 = (CamcorderProfileHelper)Preconditions.checkNotNull(object2);
                this.mCamcorderProfileHelper = object2;
                context = (WindowManager)context.getSystemService("window");
                this.mExcludedSupportedSizesContainer = object2 = new ExcludedSupportedSizesContainer((String)object);
                try {
                    object = cameraManagerCompat.getCameraCharacteristicsCompat((String)object3);
                }
                catch (CameraAccessExceptionCompat cameraAccessExceptionCompat) {
                    throw CameraUnavailableExceptionHelper.createFrom(cameraAccessExceptionCompat);
                }
                this.mCharacteristics = object;
                cameraManagerCompat = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
                object = ((CameraCharacteristicsCompat)object).get((CameraCharacteristics.Key)cameraManagerCompat);
                object = (Integer)object;
                if (object == null) break block8;
                n10 = (Integer)object;
                break block9;
            }
            n10 = 2;
        }
        this.mHardwareLevel = n10;
        n10 = this.isSensorLandscapeResolution() ? 1 : 0;
        this.mIsSensorLandscapeResolution = n10;
        this.generateSupportedCombinationList();
        this.generateSurfaceSizeDefinition((WindowManager)context);
        this.checkCustomization();
    }

    private void checkCustomization() {
    }

    private Size[] doGetAllOutputSizesByFormat(int n10) {
        Object object = this.mCharacteristics;
        Object object2 = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        if ((object = (StreamConfigurationMap)object.get((CameraCharacteristics.Key)object2)) != null) {
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 23;
            if (n11 < n12 && n10 == (n11 = 34)) {
                object2 = SurfaceTexture.class;
                object = object.getOutputSizes((Class)object2);
            } else {
                object = object.getOutputSizes(n10);
            }
            if (object != null) {
                Size[] sizeArray = this.excludeProblematicSizes((Size[])object, n10);
                object = new SupportedSurfaceCombination$CompareSizesByArea(true);
                Arrays.sort(sizeArray, object);
                return sizeArray;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Can not get supported output size for the format: ");
            ((StringBuilder)object2).append(n10);
            String string2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
        throw illegalArgumentException;
    }

    private Size[] excludeProblematicSizes(Size[] object, int n10) {
        List list = this.fetchExcludedSizes(n10);
        object = Arrays.asList(object);
        ArrayList arrayList = new ArrayList(object);
        arrayList.removeAll(list);
        object = new Size[]{};
        return arrayList.toArray((T[])object);
    }

    private List fetchExcludedSizes(int n10) {
        Object object = this.mExcludedSizeListCache;
        Object object2 = n10;
        if ((object = (List)object.get(object2)) == null) {
            object = this.mExcludedSupportedSizesContainer.get(n10);
            object2 = this.mExcludedSizeListCache;
            Integer n11 = n10;
            object2.put(n11, object);
        }
        return object;
    }

    private Size fetchMaxSize(int n10) {
        Map map = this.mMaxSizeCache;
        Object object = n10;
        if ((map = (Size)map.get(object)) != null) {
            return map;
        }
        map = this.getMaxOutputSizeByFormat(n10);
        object = this.mMaxSizeCache;
        Integer n11 = n10;
        object.put(n11, map);
        return map;
    }

    private Size flipSizeByRotation(Size size, int n10) {
        if (size != null && (n10 = (int)(this.isRotationNeeded(n10) ? 1 : 0)) != 0) {
            Size size2;
            int n11 = size.getHeight();
            int n12 = size.getWidth();
            size = size2 = new Size(n11, n12);
        }
        return size;
    }

    private void generateSupportedCombinationList() {
        List list;
        List list2;
        Object object = this.mSurfaceCombinations;
        List list3 = this.getLegacySupportedCombinationList();
        object.addAll(list3);
        int n10 = this.mHardwareLevel;
        int n11 = 3;
        int n12 = 1;
        if (n10 == 0 || n10 == n12 || n10 == n11) {
            object = this.mSurfaceCombinations;
            list2 = this.getLimitedSupportedCombinationList();
            object.addAll(list2);
        }
        if ((n10 = this.mHardwareLevel) == n12 || n10 == n11) {
            object = this.mSurfaceCombinations;
            list2 = this.getFullSupportedCombinationList();
            object.addAll(list2);
        }
        object = this.mCharacteristics;
        list2 = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
        if ((object = (Object)((int[])((CameraCharacteristicsCompat)object).get((CameraCharacteristics.Key)list2))) != null) {
            for (Object object2 : object) {
                if (object2 == n11) {
                    this.mIsRawSupported = n12;
                    continue;
                }
                int n13 = 6;
                if (object2 != n13) continue;
                this.mIsBurstCaptureSupported = n12;
            }
        }
        if ((n10 = (int)(this.mIsRawSupported ? 1 : 0)) != 0) {
            object = this.mSurfaceCombinations;
            list = this.getRAWSupportedCombinationList();
            object.addAll(list);
        }
        if ((n10 = (int)(this.mIsBurstCaptureSupported ? 1 : 0)) != 0 && (n10 = this.mHardwareLevel) == 0) {
            object = this.mSurfaceCombinations;
            list = this.getBurstSupportedCombinationList();
            object.addAll(list);
        }
        if ((n10 = this.mHardwareLevel) == n11) {
            object = this.mSurfaceCombinations;
            list3 = this.getLevel3SupportedCombinationList();
            object.addAll(list3);
        }
    }

    private void generateSurfaceSizeDefinition(WindowManager object) {
        Size size = new Size(640, 480);
        object = SupportedSurfaceCombination.getPreviewSize(object);
        Size size2 = this.getRecordSize();
        object = SurfaceSizeDefinition.create(size, (Size)object, size2);
        this.mSurfaceSizeDefinition = object;
    }

    private Size[] getAllOutputSizesByFormat(int n10) {
        Size[] sizeArray = this.mOutputSizesCache;
        Object object = n10;
        if ((sizeArray = (Size[])sizeArray.get(object)) == null) {
            sizeArray = this.doGetAllOutputSizesByFormat(n10);
            object = this.mOutputSizesCache;
            Integer n11 = n10;
            object.put(n11, sizeArray);
        }
        return sizeArray;
    }

    private List getAllPossibleSizeArrangements(List object) {
        List list;
        int n10;
        int n11;
        ArrayList arrayList = object.iterator();
        int n12 = n11 = 1;
        while ((n10 = arrayList.hasNext()) != 0) {
            list = (List)arrayList.next();
            n10 = list.size();
            n12 *= n10;
        }
        if (n12 != 0) {
            int n13;
            ArrayList arrayList2;
            int n14;
            arrayList = new ArrayList();
            n10 = 0;
            list = null;
            List list2 = null;
            for (n14 = 0; n14 < n12; ++n14) {
                arrayList2 = new ArrayList();
                arrayList.add(arrayList2);
            }
            list2 = (List)object.get(0);
            n14 = list2.size();
            n14 = n12 / n14;
            int n15 = n12;
            arrayList2 = null;
            for (int i10 = 0; i10 < (n13 = object.size()); ++i10) {
                List list3 = (List)object.get(i10);
                for (int i11 = 0; i11 < n12; ++i11) {
                    List list4 = (List)arrayList.get(i11);
                    int n16 = i11 % n15 / n14;
                    Size size = (Size)list3.get(n16);
                    list4.add(size);
                }
                n13 = object.size() - n11;
                if (i10 >= n13) continue;
                n15 = i10 + 1;
                List list5 = (List)object.get(n15);
                n15 = list5.size();
                int n17 = n14 / n15;
                n15 = n14;
                n14 = n17;
            }
            return arrayList;
        }
        object = new IllegalArgumentException("Failed to find supported resolutions.");
        throw object;
    }

    private static int getArea(Size size) {
        int n10 = size.getWidth();
        int n11 = size.getHeight();
        return n10 * n11;
    }

    private Size[] getCustomizedSupportSizesFromConfig(int n10, ImageOutputConfig object) {
        Object object2 = null;
        if ((object = object.getSupportedResolutions(null)) != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Pair pair = (Pair)object.next();
                Integer n11 = (Integer)pair.first;
                int n12 = n11;
                if (n12 != n10) continue;
                object = pair.second;
                object2 = object;
                object2 = (Size[])object;
                break;
            }
        }
        if (object2 != null) {
            object2 = this.excludeProblematicSizes((Size[])object2, n10);
            boolean bl3 = true;
            SupportedSurfaceCombination$CompareSizesByArea supportedSurfaceCombination$CompareSizesByArea = new SupportedSurfaceCombination$CompareSizesByArea(bl3);
            Arrays.sort(object2, supportedSurfaceCombination$CompareSizesByArea);
        }
        return object2;
    }

    public static Size getPreviewSize(WindowManager object) {
        Size size;
        Size size2;
        Object object2 = new Point();
        object = object.getDefaultDisplay();
        object.getRealSize((Point)object2);
        int n10 = object2.x;
        int n11 = object2.y;
        if (n10 > n11) {
            n11 = object2.x;
            int n12 = object2.y;
            object = new Size(n11, n12);
        } else {
            n11 = object2.y;
            int n13 = object2.x;
            object = new Size(n11, n13);
        }
        object2 = new Size[2];
        int n14 = object.getWidth();
        n10 = object.getHeight();
        object2[0] = size2 = new Size(n14, n10);
        object2[1] = size = MAX_PREVIEW_SIZE;
        object = Arrays.asList(object2);
        object2 = new SupportedSurfaceCombination$CompareSizesByArea();
        return (Size)Collections.min(object, object2);
    }

    private Size getRecordSize() {
        Size size;
        block9: {
            size = QUALITY_480P_SIZE;
            String string2 = this.mCameraId;
            int n10 = Integer.parseInt(string2);
            CamcorderProfileHelper camcorderProfileHelper = this.mCamcorderProfileHelper;
            int n11 = 1;
            string2 = camcorderProfileHelper.get(n10, n11);
            if (string2 == null) break block9;
            int n12 = ((CamcorderProfile)string2).videoFrameWidth;
            n10 = ((CamcorderProfile)string2).videoFrameHeight;
            try {
                size = new Size(n12, n10);
            }
            catch (NumberFormatException numberFormatException) {
                size = this.getRecordSizeFromStreamConfigurationMap();
            }
        }
        return size;
    }

    private Size getRecordSizeFromStreamConfigurationMap() {
        Size[] sizeArray = this.mCharacteristics;
        Object object = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        if ((sizeArray = (StreamConfigurationMap)sizeArray.get((CameraCharacteristics.Key)object)) != null) {
            object = MediaRecorder.class;
            if ((sizeArray = sizeArray.getOutputSizes((Class)object)) == null) {
                return QUALITY_480P_SIZE;
            }
            object = new SupportedSurfaceCombination$CompareSizesByArea(true);
            Arrays.sort(sizeArray, object);
            for (Size size : sizeArray) {
                int n10;
                Size size2;
                int n11;
                int n12 = size.getWidth();
                if (n12 > (n11 = (size2 = QUALITY_1080P_SIZE).getWidth()) || (n12 = size.getHeight()) > (n10 = size2.getHeight())) continue;
                return size;
            }
            return QUALITY_480P_SIZE;
        }
        sizeArray = new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
        throw sizeArray;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Rational getTargetAspectRatio(ImageOutputConfig object) {
        Object object2 = new TargetAspectRatio();
        Object object3 = this.mCameraId;
        Object object4 = this.mCharacteristics;
        int n10 = ((TargetAspectRatio)object2).get((ImageOutputConfig)object, (String)object3, (CameraCharacteristicsCompat)object4);
        object3 = null;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                int n12 = 2;
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 != n12) return object3;
                    object2 = this.getTargetSize((ImageOutputConfig)object);
                    n12 = object.hasTargetAspectRatio() ? 1 : 0;
                    if (n12 != 0) {
                        int n13 = object.getTargetAspectRatio();
                        if (n13 != 0) {
                            if (n13 != n11) {
                                object2 = new StringBuilder();
                                object4 = "Undefined target aspect ratio: ";
                                ((StringBuilder)object2).append((String)object4);
                                ((StringBuilder)object2).append(n13);
                                object = ((StringBuilder)object2).toString();
                                object2 = TAG;
                                Logger.e((String)object2, (String)object);
                                return object3;
                            }
                            n13 = this.mIsSensorLandscapeResolution ? 1 : 0;
                            object = n13 != 0 ? ASPECT_RATIO_16_9 : ASPECT_RATIO_9_16;
                            return object;
                        }
                        n13 = this.mIsSensorLandscapeResolution ? 1 : 0;
                        object = n13 != 0 ? ASPECT_RATIO_4_3 : ASPECT_RATIO_3_4;
                        return object;
                    }
                    if (object2 == null) return object3;
                    int n14 = object2.getWidth();
                    n10 = object2.getHeight();
                    return new Rational(n14, n10);
                }
                object = this.fetchMaxSize(256);
                n10 = object.getWidth();
                int n15 = object.getHeight();
                return new Rational(n10, n15);
            }
            boolean bl2 = this.mIsSensorLandscapeResolution;
            if (!bl2) return ASPECT_RATIO_9_16;
            return ASPECT_RATIO_16_9;
        }
        boolean bl3 = this.mIsSensorLandscapeResolution;
        if (!bl3) return ASPECT_RATIO_3_4;
        return ASPECT_RATIO_4_3;
    }

    private Size getTargetSize(ImageOutputConfig imageOutputConfig) {
        int n10 = imageOutputConfig.getTargetRotation(0);
        imageOutputConfig = imageOutputConfig.getTargetResolution(null);
        return this.flipSizeByRotation((Size)imageOutputConfig, n10);
    }

    private List getUseCasesPriorityOrder(List list) {
        int n10;
        Object object;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object2 = new ArrayList();
        Object object3 = list.iterator();
        while (true) {
            int n11 = object3.hasNext();
            boolean bl2 = false;
            Integer n12 = null;
            if (n11 == 0) break;
            object = (UseCaseConfig)object3.next();
            n11 = object.getSurfaceOccupancyPriority(0);
            n12 = n11;
            bl2 = object2.contains(n12);
            if (bl2) continue;
            object = n11;
            object2.add(object);
        }
        Collections.sort(object2);
        Collections.reverse(object2);
        object2 = object2.iterator();
        while ((n10 = object2.hasNext()) != 0) {
            int n13;
            object3 = (Integer)object2.next();
            n10 = (Integer)object3;
            object = list.iterator();
            while ((n13 = object.hasNext()) != 0) {
                Object object4 = (UseCaseConfig)object.next();
                int n14 = object4.getSurfaceOccupancyPriority(0);
                if (n10 != n14) continue;
                n13 = list.indexOf(object4);
                object4 = n13;
                arrayList.add(object4);
            }
        }
        return arrayList;
    }

    private Map groupSizesByAspectRatio(List object) {
        boolean bl2;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Object object2 = ASPECT_RATIO_4_3;
        Object object3 = new ArrayList();
        hashMap.put(object2, object3);
        object2 = ASPECT_RATIO_16_9;
        object3 = new ArrayList();
        hashMap.put(object2, object3);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            int n10;
            object2 = (Size)object.next();
            object3 = null;
            ArrayList arrayList = hashMap.keySet().iterator();
            while ((n10 = arrayList.hasNext()) != 0) {
                Rational rational = (Rational)arrayList.next();
                boolean bl3 = SupportedSurfaceCombination.hasMatchingAspectRatio((Size)object2, rational);
                if (!bl3) continue;
                object3 = (List)hashMap.get(rational);
                bl3 = object3.contains(object2);
                if (!bl3) {
                    object3.add(object2);
                }
                object3 = rational;
            }
            if (object3 != null) continue;
            int n11 = object2.getWidth();
            n10 = object2.getHeight();
            object3 = new Rational(n11, n10);
            object2 = Collections.singleton(object2);
            arrayList = new ArrayList(object2);
            hashMap.put(object3, arrayList);
        }
        return hashMap;
    }

    public static boolean hasMatchingAspectRatio(Size size, Rational rational) {
        boolean bl2 = false;
        if (rational != null) {
            int n10;
            int n11 = size.getWidth();
            Rational rational2 = new Rational(n11, n10 = size.getHeight());
            int n12 = rational.equals((Object)rational2);
            if (n12 != 0) {
                bl2 = true;
            } else {
                Size size2;
                n12 = SupportedSurfaceCombination.getArea(size);
                if (n12 >= (n11 = SupportedSurfaceCombination.getArea(size2 = DEFAULT_SIZE))) {
                    bl2 = SupportedSurfaceCombination.isPossibleMod16FromAspectRatio(size, rational);
                }
            }
        }
        return bl2;
    }

    private static boolean isPossibleMod16FromAspectRatio(Size size, Rational rational) {
        int n10;
        int n11 = size.getWidth();
        int n12 = size.getHeight();
        int n13 = rational.getDenominator();
        int bl2 = rational.getNumerator();
        Rational rational2 = new Rational(n13, bl2);
        n13 = n11 % 16;
        boolean bl3 = false;
        if (n13 == 0 && (n10 = n12 % 16) == 0) {
            boolean bl4;
            n13 = n12 + -16;
            int n14 = SupportedSurfaceCombination.ratioIntersectsMod16Segment(n13 = Math.max(0, n13), n11, rational);
            if (n14 != 0 || (n12 = (int)(SupportedSurfaceCombination.ratioIntersectsMod16Segment(n14 = Math.max(0, n11 += -16), n12, rational2) ? 1 : 0)) != 0) {
                bl4 = true;
            }
            return bl4;
        }
        if (n13 == 0) {
            return SupportedSurfaceCombination.ratioIntersectsMod16Segment(n12, n11, rational);
        }
        int n15 = n12 % 16;
        if (n15 == 0) {
            return SupportedSurfaceCombination.ratioIntersectsMod16Segment(n11, n12, rational2);
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private boolean isRotationNeeded(int n10) {
        void var5_8;
        Object object = this.mCharacteristics;
        Object object2 = CameraCharacteristics.SENSOR_ORIENTATION;
        object = (Integer)((CameraCharacteristicsCompat)object).get((CameraCharacteristics.Key)object2);
        Preconditions.checkNotNull(object, "Camera HAL in bad state, unable to retrieve the SENSOR_ORIENTATION");
        n10 = CameraOrientationUtil.surfaceRotationToDegrees(n10);
        object2 = this.mCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.LENS_FACING;
        object2 = (Integer)((CameraCharacteristicsCompat)object2).get(key);
        Preconditions.checkNotNull(object2, "Camera HAL in bad state, unable to retrieve the LENS_FACING");
        boolean bl2 = ((Integer)object2).intValue();
        boolean bl3 = false;
        key = null;
        boolean bl4 = true;
        if (bl4 == bl2) {
            boolean bl5 = bl4;
        } else {
            boolean bl6 = false;
            object2 = null;
        }
        int n11 = (Integer)object;
        n10 = CameraOrientationUtil.getRelativeImageRotation(n10, n11, (boolean)var5_8);
        n11 = 90;
        if (n10 == n11 || n10 == (n11 = 270)) {
            bl3 = bl4;
        }
        return bl3;
    }

    private boolean isSensorLandscapeResolution() {
        int n10;
        int n11;
        CameraCharacteristicsCompat cameraCharacteristicsCompat = this.mCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE;
        cameraCharacteristicsCompat = (Size)cameraCharacteristicsCompat.get(key);
        boolean bl2 = true;
        if (cameraCharacteristicsCompat != null && (n11 = cameraCharacteristicsCompat.getWidth()) < (n10 = cameraCharacteristicsCompat.getHeight())) {
            bl2 = false;
            key = null;
        }
        return bl2;
    }

    private static boolean ratioIntersectsMod16Segment(int n10, int n11, Rational rational) {
        double d10;
        double d11;
        int n12 = n11 % 16;
        int n13 = 1;
        n12 = n12 == 0 ? n13 : 0;
        Preconditions.checkArgument(n12 != 0);
        n12 = rational.getNumerator();
        double d12 = n10 * n12;
        double d13 = rational.getDenominator();
        d12 /= d13;
        n10 = n11 + -16;
        d13 = Math.max(0, n10);
        n10 = d12 == d13 ? 0 : (d12 > d13 ? 1 : -1);
        if (n10 <= 0 || (n10 = (int)((d11 = d12 - (d10 = (double)(n11 += 16))) == 0.0 ? 0 : (d11 < 0.0 ? -1 : 1))) >= 0) {
            n13 = 0;
        }
        return n13 != 0;
    }

    private void removeSupportedSizesByTargetSize(List list, Size size) {
        int n10;
        if (list != null && (n10 = list.isEmpty()) == 0) {
            n10 = -1;
            ArrayList<Size> arrayList = new ArrayList<Size>();
            int n11 = 0;
            Size size2 = null;
            while (true) {
                int n12;
                Size size3;
                int n13;
                int n14 = n11;
                n11 = n10;
                n10 = n14;
                int n15 = list.size();
                if (n14 >= n15 || (n13 = (size3 = (Size)list.get(n14)).getWidth()) < (n12 = size.getWidth()) || (n15 = size3.getHeight()) < (n13 = size.getHeight())) break;
                if (n11 >= 0) {
                    size2 = (Size)list.get(n11);
                    arrayList.add(size2);
                }
                n11 = n10 + 1;
            }
            list.removeAll(arrayList);
        }
    }

    public boolean checkSupported(List list) {
        boolean bl2;
        Iterator iterator2 = this.mSurfaceCombinations.iterator();
        boolean bl3 = false;
        SurfaceCombination surfaceCombination = null;
        while ((bl2 = iterator2.hasNext()) && !(bl3 = (surfaceCombination = (SurfaceCombination)iterator2.next()).isSupported(list))) {
        }
        return bl3;
    }

    public List getBurstSupportedCombinationList() {
        ArrayList<SurfaceCombination> arrayList = new ArrayList<SurfaceCombination>();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        Object object = SurfaceConfig$ConfigType.PRIV;
        Object object2 = SurfaceConfig$ConfigSize.PREVIEW;
        Object object3 = SurfaceConfig.create(object, object2);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object3);
        object3 = SurfaceConfig$ConfigSize.MAXIMUM;
        SurfaceConfig surfaceConfig = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object3));
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object = SurfaceConfig.create(object, object2);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        object = SurfaceConfig$ConfigType.YUV;
        surfaceConfig = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object3));
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object2 = SurfaceConfig.create(object, object2);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object2);
        object = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object3));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        arrayList.add(surfaceCombination);
        return arrayList;
    }

    public String getCameraId() {
        return this.mCameraId;
    }

    public List getFullSupportedCombinationList() {
        ArrayList<SurfaceCombination> arrayList = new ArrayList<SurfaceCombination>();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        Object object = SurfaceConfig$ConfigType.PRIV;
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.PREVIEW;
        Object object2 = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object2);
        object2 = SurfaceConfig$ConfigSize.MAXIMUM;
        Object object3 = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object3);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object3 = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object3);
        object3 = SurfaceConfig$ConfigType.YUV;
        Object object4 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object4 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        object4 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object4 = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        object4 = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        object4 = SurfaceConfig.create(SurfaceConfig$ConfigType.JPEG, (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object4 = SurfaceConfig$ConfigSize.ANALYSIS;
        SurfaceConfig surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), (SurfaceConfig$ConfigSize)((Object)object4));
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        object = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        object = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), (SurfaceConfig$ConfigSize)((Object)object4));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        object = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        object = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        arrayList.add(surfaceCombination);
        return arrayList;
    }

    public List getLegacySupportedCombinationList() {
        ArrayList<SurfaceCombination> arrayList = new ArrayList<SurfaceCombination>();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        Object object = SurfaceConfig$ConfigType.PRIV;
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.MAXIMUM;
        Object object2 = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object2);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object2 = SurfaceConfig$ConfigType.JPEG;
        Object object3 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object2), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object3);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object3 = SurfaceConfig$ConfigType.YUV;
        Object object4 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object4 = SurfaceConfig$ConfigSize.PREVIEW;
        SurfaceConfig surfaceConfig = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object4));
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object2), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), (SurfaceConfig$ConfigSize)((Object)object4));
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object2), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        surfaceConfig = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object4));
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        surfaceConfig = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object4));
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        surfaceConfig = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object4));
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), (SurfaceConfig$ConfigSize)((Object)object4));
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object4));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        object = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), (SurfaceConfig$ConfigSize)((Object)object4));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        object = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object2), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        arrayList.add(surfaceCombination);
        return arrayList;
    }

    public List getLevel3SupportedCombinationList() {
        ArrayList<SurfaceCombination> arrayList = new ArrayList<SurfaceCombination>();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        Object object = SurfaceConfig$ConfigType.PRIV;
        Object object2 = SurfaceConfig$ConfigSize.PREVIEW;
        Object object3 = SurfaceConfig.create(object, object2);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object3);
        object3 = SurfaceConfig$ConfigSize.ANALYSIS;
        Object object4 = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object3));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        object4 = SurfaceConfig$ConfigType.YUV;
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.MAXIMUM;
        object4 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object4), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        object4 = SurfaceConfig$ConfigType.RAW;
        SurfaceConfig surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object4), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object2 = SurfaceConfig.create(object, object2);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object2);
        object = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object3));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        object = SurfaceConfig.create(SurfaceConfig$ConfigType.JPEG, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        object = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object4), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        arrayList.add(surfaceCombination);
        return arrayList;
    }

    public List getLimitedSupportedCombinationList() {
        ArrayList<SurfaceCombination> arrayList = new ArrayList<SurfaceCombination>();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        Object object = SurfaceConfig$ConfigType.PRIV;
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.PREVIEW;
        Object object2 = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object2);
        object2 = SurfaceConfig$ConfigSize.RECORD;
        Object object3 = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object3);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object3 = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object3);
        object3 = SurfaceConfig$ConfigType.YUV;
        Object object4 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object4 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        object4 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object4 = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        object4 = SurfaceConfig.create(object, (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        object4 = SurfaceConfig$ConfigType.JPEG;
        SurfaceConfig surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object4), (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        object = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        object = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object4), (SurfaceConfig$ConfigSize)((Object)object2));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        object = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object3), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        object = SurfaceConfig$ConfigSize.MAXIMUM;
        object = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object4), (SurfaceConfig$ConfigSize)((Object)object));
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        arrayList.add(surfaceCombination);
        return arrayList;
    }

    public Size getMaxOutputSizeByFormat(int n10) {
        List<Size> list = Arrays.asList(this.getAllOutputSizesByFormat(n10));
        SupportedSurfaceCombination$CompareSizesByArea supportedSurfaceCombination$CompareSizesByArea = new SupportedSurfaceCombination$CompareSizesByArea();
        return Collections.max(list, supportedSurfaceCombination$CompareSizesByArea);
    }

    public List getRAWSupportedCombinationList() {
        ArrayList<SurfaceCombination> arrayList = new ArrayList<SurfaceCombination>();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        Object object = SurfaceConfig$ConfigType.RAW;
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.MAXIMUM;
        Object object2 = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object2);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object2 = SurfaceConfig$ConfigType.PRIV;
        Object object3 = SurfaceConfig$ConfigSize.PREVIEW;
        Object object4 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object2), object3);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        object4 = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object4);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object4 = SurfaceConfig$ConfigType.YUV;
        SurfaceConfig surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object4), object3);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        surfaceConfig = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object2), object3);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object2), object3);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        surfaceConfig = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object2), object3);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object4), object3);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        surfaceConfig = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object4), object3);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object4), object3);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        surfaceConfig = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object2 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object2), object3);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object2);
        object2 = SurfaceConfig$ConfigType.JPEG;
        surfaceConfig = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object2), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        surfaceConfig = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig(surfaceConfig);
        arrayList.add(surfaceCombination);
        surfaceCombination = new SurfaceCombination();
        object3 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object4), object3);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object3);
        object2 = SurfaceConfig.create((SurfaceConfig$ConfigType)((Object)object2), surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object2);
        object = SurfaceConfig.create(object, surfaceConfig$ConfigSize);
        surfaceCombination.addSurfaceConfig((SurfaceConfig)object);
        arrayList.add(surfaceCombination);
        return arrayList;
    }

    public Map getSuggestedResolutions(List object, List list) {
        boolean bl2;
        Serializable serializable;
        int n10;
        HashMap<Object, Serializable> hashMap = new HashMap<Object, Serializable>();
        List list2 = this.getUseCasesPriorityOrder(list);
        Object object2 = new ArrayList();
        Object object3 = list2.iterator();
        while ((n10 = object3.hasNext()) != 0) {
            n10 = (Integer)object3.next();
            serializable = (UseCaseConfig)list.get(n10);
            serializable = this.getSupportedOutputSizes((UseCaseConfig)((Object)serializable));
            object2.add(serializable);
        }
        object2 = this.getAllPossibleSizeArrangements((List)object2).iterator();
        while (bl2 = object2.hasNext()) {
            boolean bl3;
            int n11;
            object3 = (List)object2.next();
            serializable = new ArrayList(object);
            for (int i10 = 0; i10 < (n11 = object3.size()); ++i10) {
                Object object4 = (Size)object3.get(i10);
                int n12 = (Integer)list2.get(i10);
                UseCaseConfig useCaseConfig = (UseCaseConfig)list.get(n12);
                n12 = useCaseConfig.getInputFormat();
                object4 = this.transformSurfaceConfig(n12, (Size)object4);
                serializable.add(object4);
            }
            n10 = this.checkSupported((List)((Object)serializable)) ? 1 : 0;
            if (n10 == 0) continue;
            object = list.iterator();
            while (bl3 = object.hasNext()) {
                object2 = (UseCaseConfig)object.next();
                serializable = Integer.valueOf(list.indexOf(object2));
                n10 = list2.indexOf(serializable);
                serializable = (Size)object3.get(n10);
                hashMap.put(object2, serializable);
            }
            break block1;
        }
        return hashMap;
    }

    public List getSupportedOutputSizes(UseCaseConfig arrayList) {
        int n10;
        int n11;
        int n12 = arrayList.getInputFormat();
        Object object = this.getCustomizedSupportSizesFromConfig(n12, (ImageOutputConfig)((Object)(arrayList = (ImageOutputConfig)((Object)arrayList))));
        if (object == null) {
            object = this.getAllOutputSizesByFormat(n12);
        }
        Object object2 = new ArrayList();
        boolean bl2 = false;
        Object object3 = null;
        Size size = arrayList.getMaxResolution(null);
        Object object4 = this.getMaxOutputSizeByFormat(n12);
        if (size == null || (n11 = SupportedSurfaceCombination.getArea(object4)) < (n10 = SupportedSurfaceCombination.getArea(size))) {
            size = object4;
        }
        n11 = 1;
        object4 = new SupportedSurfaceCombination$CompareSizesByArea(n11 != 0);
        Arrays.sort(object, object4);
        object4 = this.getTargetSize((ImageOutputConfig)((Object)arrayList));
        Size size2 = DEFAULT_SIZE;
        n10 = SupportedSurfaceCombination.getArea(size2);
        int n13 = SupportedSurfaceCombination.getArea(size);
        if (n13 < n10) {
            size2 = ZERO_SIZE;
        } else if (object4 != null && (n13 = SupportedSurfaceCombination.getArea(object4)) < n10) {
            size2 = object4;
        }
        for (Size size3 : object) {
            int n14;
            int n15 = SupportedSurfaceCombination.getArea(size3);
            if (n15 > (n14 = SupportedSurfaceCombination.getArea(size)) || (n15 = SupportedSurfaceCombination.getArea(size3)) < (n14 = SupportedSurfaceCombination.getArea(size2)) || (n15 = (int)(object2.contains(size3) ? 1 : 0)) != 0) continue;
            object2.add(size3);
        }
        boolean bl3 = object2.isEmpty();
        if (!bl3) {
            Object object5 = this.getTargetAspectRatio((ImageOutputConfig)((Object)arrayList));
            if (object4 == null) {
                object4 = arrayList.getDefaultResolution(null);
            }
            arrayList = new ArrayList<Object>();
            object = new HashMap();
            if (object5 == null) {
                arrayList.addAll((Collection<Object>)object2);
                if (object4 != null) {
                    this.removeSupportedSizesByTargetSize(arrayList, (Size)object4);
                }
            } else {
                boolean bl4;
                object = this.groupSizesByAspectRatio((List)object2);
                if (object4 != null) {
                    object2 = object.keySet().iterator();
                    while (bl2 = object2.hasNext()) {
                        object3 = (Rational)object2.next();
                        object3 = (List)object.get(object3);
                        this.removeSupportedSizesByTargetSize((List)object3, (Size)object4);
                    }
                }
                object3 = object.keySet();
                object2 = new ArrayList(object3);
                object3 = new SupportedSurfaceCombination$CompareAspectRatiosByDistanceToTargetRatio((Rational)object5);
                Collections.sort(object2, object3);
                object5 = object2.iterator();
                while (bl4 = object5.hasNext()) {
                    object2 = (Rational)object5.next();
                    object2 = ((List)object.get(object2)).iterator();
                    while (bl2 = object2.hasNext()) {
                        object3 = (Size)object2.next();
                        boolean bl5 = arrayList.contains(object3);
                        if (bl5) continue;
                        arrayList.add(object3);
                    }
                }
            }
            return arrayList;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Can not get supported output size under supported maximum for the format: ");
        ((StringBuilder)object).append(n12);
        String string2 = ((StringBuilder)object).toString();
        arrayList = new ArrayList<Object>(string2);
        throw arrayList;
    }

    public SurfaceSizeDefinition getSurfaceSizeDefinition() {
        return this.mSurfaceSizeDefinition;
    }

    public boolean isBurstCaptureSupported() {
        return this.mIsBurstCaptureSupported;
    }

    public boolean isRawSupported() {
        return this.mIsRawSupported;
    }

    public SurfaceConfig transformSurfaceConfig(int n10, Size size) {
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.NOT_SUPPORT;
        int n11 = 35;
        SurfaceConfig$ConfigType surfaceConfig$ConfigType = n10 == n11 ? SurfaceConfig$ConfigType.YUV : (n10 == (n11 = 256) ? SurfaceConfig$ConfigType.JPEG : (n10 == (n11 = 32) ? SurfaceConfig$ConfigType.RAW : SurfaceConfig$ConfigType.PRIV));
        Size size2 = this.fetchMaxSize(n10);
        int n12 = size.getWidth();
        int n13 = size.getHeight();
        n12 *= n13;
        Size size3 = this.mSurfaceSizeDefinition.getAnalysisSize();
        n13 = size3.getWidth();
        Size size4 = this.mSurfaceSizeDefinition.getAnalysisSize();
        int n14 = size4.getHeight();
        if (n12 <= (n13 *= n14)) {
            surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.ANALYSIS;
        } else {
            n12 = size.getWidth();
            n13 = size.getHeight();
            n12 *= n13;
            size3 = this.mSurfaceSizeDefinition.getPreviewSize();
            n13 = size3.getWidth();
            size4 = this.mSurfaceSizeDefinition.getPreviewSize();
            n14 = size4.getHeight();
            if (n12 <= (n13 *= n14)) {
                surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.PREVIEW;
            } else {
                n12 = size.getWidth();
                n13 = size.getHeight();
                n12 *= n13;
                size3 = this.mSurfaceSizeDefinition.getRecordSize();
                n13 = size3.getWidth();
                size4 = this.mSurfaceSizeDefinition.getRecordSize();
                n14 = size4.getHeight();
                if (n12 <= (n13 *= n14)) {
                    surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.RECORD;
                } else {
                    n12 = size.getWidth();
                    int n15 = size.getHeight();
                    n12 *= n15;
                    n15 = size2.getWidth();
                    n10 = size2.getHeight();
                    if (n12 <= (n15 *= n10)) {
                        surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.MAXIMUM;
                    }
                }
            }
        }
        return SurfaceConfig.create(surfaceConfig$ConfigType, surfaceConfig$ConfigSize);
    }
}

