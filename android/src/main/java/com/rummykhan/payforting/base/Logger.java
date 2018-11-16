package com.rummykhan.payforting;

/**
 * Created by basselchaitani on 6/19/18
 */
public class Logger {

    private static final String TAG = Logger.class.getSimpleName();

    public static final boolean IS_DEBUG_MODE = BuildConfig.DEBUG;

    public static int v(String msg) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.v(TAG, msg);
        }
        return 0;
    }

    public static int v(String tag, String msg) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.v(tag, msg);
        }
        return 0;
    }

    public static int v(String msg, Throwable tr) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.v(TAG, msg, tr);
        }
        return 0;
    }

    public static int v(String tag, String msg, Throwable tr) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.v(tag, msg, tr);
        }
        return 0;
    }

    public static int d(String msg) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.d(TAG, msg);
        }
        return 0;
    }

    public static int d(String tag, String msg) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.d(tag, msg);
        }
        return 0;
    }

    public static int d(String msg, Throwable tr) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.d(TAG, msg, tr);
        }
        return 0;
    }

    public static int d(String tag, String msg, Throwable tr) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.d(tag, msg, tr);
        }
        return 0;
    }

    public static int i(String msg) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.i(TAG, msg);
        }
        return 0;
    }

    public static int i(String tag, String msg) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.i(tag, msg + "");
        }
        return 0;
    }

    public static int i(String msg, Throwable tr) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.i(TAG, msg, tr);
        }
        return 0;
    }

    public static int i(String tag, String msg, Throwable tr) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.i(tag, msg, tr);
        }
        return 0;
    }

    public static int w(String msg) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.w(TAG, msg);
        }
        return 0;
    }

    public static int w(String tag, String msg) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.w(tag, msg);
        }
        return 0;
    }

    public static int w(String msg, Throwable tr) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.w(TAG, msg, tr);
        }
        return 0;
    }

    public static int w(String tag, String msg, Throwable tr) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.w(tag, msg, tr);
        }
        return 0;
    }

    public static int e(String msg) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.e(TAG, msg);
        }
        return 0;
    }

    public static int e(String tag, String msg) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.e(tag, msg + "");
        }
        return 0;
    }

    public static int e(String msg, Throwable tr) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.e(TAG, msg, tr);
        }
        return 0;
    }

    public static int e(String tag, String msg, Throwable tr) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.e(tag, msg, tr);
        }
        return 0;
    }

    public static int t(String msg, Object... args) {
        if (IS_DEBUG_MODE) {
            return android.util.Log.v(TAG, String.format(msg, args));
        }
        return 0;
    }
}