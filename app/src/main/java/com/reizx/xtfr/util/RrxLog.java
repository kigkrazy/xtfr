package com.reizx.xtfr.util;


import android.util.Log;

/**
 * 对于XLOG的进一层封装
 * Created by Kigkrazy on 2017/6/11.
 */
public class RrxLog {
    //public static LoggerPrinter loggerPrinter = new LoggerPrinter();
    private static String attachTag = ""; //附加标签
    private static String logTag = "xcore" ;//日志标签

    /**
     * 添加日志标签，每个标签都会用：隔离开
     * @param tag
     */
    public static void addTag(String tag){
        attachTag += ":" + tag;
    }

    public static void d(String msg){
        if (!attachTag.equals("")){
            msg = attachTag + "  " + msg;
        }

        Log.d(logTag, msg);
    }

    public static void i(String msg){
        if (!attachTag.equals("")){
            msg = attachTag + "  " + msg;
        }
        Log.i(logTag, msg);
    }

    public static void e(String msg){
        if (!attachTag.equals("")){
            msg = attachTag + "  " + msg;
        }
        Log.e(logTag, msg);
    }

    public static void w(String msg){
        if (!attachTag.equals("")){
            msg = attachTag + "  " + msg;
        }
        Log.w(logTag, msg);
    }

    public static String getLogTag() {
        return logTag;
    }

    public static void setLogTag(String logTag) {
        RrxLog.logTag = logTag;
    }
}
