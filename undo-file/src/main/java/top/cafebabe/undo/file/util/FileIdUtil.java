package top.cafebabe.undo.file.util;

import top.cafebabe.undo.common.util.NowUtil;

/**
 * 这看起来有点蠢，不过还是这样放着吧。
 *
 * @author cafababe
 */
public class FileIdUtil {
    public static String createId(int userId, String md5) {
        return toString(toByteArr(userId)) + md5.toUpperCase() + toString(toByteArr(NowUtil.now()));
    }

    public static boolean check(String id) {
        return id.length() == 56;
    }

    private static byte[] toByteArr(int i) {
        byte[] res = new byte[4];
        for (int j = 3; j >= 0; j--)
            res[j] = (byte) (i >> (3 - j) * 8 & 0xFF);
        return res;
    }

    private static byte[] toByteArr(long i) {
        byte[] res = new byte[8];
        for (int j = 7; j >= 0; j--)
            res[j] = (byte) (i >> (7 - j) * 8 & 0xFF);
        return res;
    }

    private static String toString(byte[] arr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : arr)
            sb.append(String.format("%02X", b));
        return sb.toString();
    }
}
