/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

public interface NvsARFaceContext$NvsARFaceContextDetectActionCallback {
    public static final long ACTION_TYPE_BROW_JUMP = 32L;
    public static final long ACTION_TYPE_EYE_BLINK = 2L;
    public static final long ACTION_TYPE_FACE_DETECT = 1L;
    public static final long ACTION_TYPE_FACE_LIPS_POUTED = 128L;
    public static final long ACTION_TYPE_FACE_LIPS_UPWARD = 64L;
    public static final long ACTION_TYPE_HAND_666 = 0x400000L;
    public static final long ACTION_TYPE_HAND_BLESS = 0x800000L;
    public static final long ACTION_TYPE_HAND_CONGRATULATE = 131072L;
    public static final long ACTION_TYPE_HAND_DETECT = 256L;
    public static final long ACTION_TYPE_HAND_FINGER_HEART = 262144L;
    public static final long ACTION_TYPE_HAND_FINGER_INDEX = 0x100000L;
    public static final long ACTION_TYPE_HAND_FIST = 0x200000L;
    public static final long ACTION_TYPE_HAND_GOOD = 2048L;
    public static final long ACTION_TYPE_HAND_HOLDUP = 32768L;
    public static final long ACTION_TYPE_HAND_ILOVEYOU = 0x10000000000L;
    public static final long ACTION_TYPE_HAND_LOVE = 16384L;
    public static final long ACTION_TYPE_HAND_OK = 512L;
    public static final long ACTION_TYPE_HAND_PALM = 4096L;
    public static final long ACTION_TYPE_HAND_PISTOL = 8192L;
    public static final long ACTION_TYPE_HAND_SCISSOR = 1024L;
    public static final long ACTION_TYPE_HAND_SSH = 0x400000000000L;
    public static final long ACTION_TYPE_HEAD_PITCH = 16L;
    public static final long ACTION_TYPE_HEAD_YAW = 8L;
    public static final long ACTION_TYPE_MOUTH_AH = 4L;

    public void notifyDetectedAction(long var1);
}

