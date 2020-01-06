package com.lanou.lottery;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 姹夊瓧杞崲鎴愭嫾闊虫柟娉�
 *
 * @author 钄￠緳
 */

public class Pinyin4j {

    HanyuPinyinOutputFormat format = null;

    public static enum Type {
        UPPERCASE,              //鍏ㄩ儴澶у啓
        LOWERCASE,              //鍏ㄩ儴灏忓啓
        FIRSTUPPER            //棣栧瓧姣嶅ぇ鍐�
    }

    public Pinyin4j() {
        format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    }

    /**
     * 杞崲鍏ㄩ儴澶у啓
     *
     * @param str 瀛楃涓�
     * @return str涓洪鍜屽洯 ,return鑾峰彇鍒扮殑鏄痀HY
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    public String toPinYinUppercase(String str) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, "", Type.UPPERCASE);
    }

    /**
     * 杞崲鍏ㄩ儴澶у啓
     *
     * @param str   瀛楃涓�
     * @param spera 杞崲瀛楁瘝闂撮殧鍔犵殑瀛楃涓�,濡傛灉涓嶉渶瑕佷负""
     * @return str涓洪鍜屽洯 ,spera涓�** return鑾峰彇鍒扮殑鏄痀**H**Y
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    public String toPinYinUppercase(String str, String spera) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, spera, Type.UPPERCASE);
    }

    /**
     * 杞崲鍏ㄩ儴灏忓啓
     *
     * @param str 瀛楃涓�
     * @throws BadHanyuPinyinOutputFormatCombination
     * @return str涓洪鍜屽洯 ,return鑾峰彇鍒扮殑鏄痽hy
     */
    public String toPinYinLowercase(String str) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, "", Type.LOWERCASE);
    }

    /**
     * 杞崲鍏ㄩ儴灏忓啓
     *
     * @param str   瀛楃涓�
     * @param spera 杞崲瀛楁瘝闂撮殧鍔犵殑瀛楃涓�,濡傛灉涓嶉渶瑕佷负""
     * @throws BadHanyuPinyinOutputFormatCombination
     * @return str涓洪鍜屽洯 ,spera涓�** return鑾峰彇鍒扮殑鏄痽**h**y
     */
    public String toPinYinLowercase(String str, String spera) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, spera, Type.LOWERCASE);
    }

    /**
     * 鑾峰彇鎷奸煶棣栧瓧姣�(澶у啓)
     *
     * @param str 瀛楃涓�
     * @return str涓洪鍜屽洯 ,return鑾峰彇鍒扮殑鏄痀
     * @throws BadHanyuPinyinOutputFormatCombination 寮傚父淇℃伅
     */
    public String toPinYinUppercaseInitials(String str) throws BadHanyuPinyinOutputFormatCombination {
        String initials = null;
        String py = toPinYinUppercase(str);
        if (py.length() > 1) {
            initials = py.substring(0, 1);
        }
        if (py.length() <= 1) {
            initials = py;
        }
        return initials.trim();
    }

    /**
     * 鑾峰彇鎷奸煶棣栧瓧姣�(灏忓啓)
     *
     * @param str 瀛楃涓�
     * @return str涓洪鍜屽洯 ,return鑾峰彇鍒扮殑鏄痽
     * @throws BadHanyuPinyinOutputFormatCombination 寮傚父淇℃伅
     */
    public String toPinYinLowercaseInitials(String str) throws BadHanyuPinyinOutputFormatCombination {
        String initials = null;
        String py = toPinYinLowercase(str);
        if (py.length() > 1) {
            initials = py.substring(0, 1);
        }
        if (py.length() <= 1) {
            initials = py;
        }
        return initials.trim();
    }

    /**
     * 灏唖tr杞崲鎴愭嫾闊筹紝濡傛灉涓嶆槸姹夊瓧鎴栬�呮病鏈夊搴旂殑鎷奸煶锛屽垯涓嶄綔杞崲
     *
     * @param str   瀛楃涓�
     * @param spera 榛樿,鍙负""
     * @param type  杞崲鏍煎紡
     * @return 鎸夌収杞崲鏍煎紡杞崲鎴愬瓧绗︿覆
     * @throws BadHanyuPinyinOutputFormatCombination 寮傚父淇℃伅
     */
    public String toPinYin(String str, String spera, Type type) throws BadHanyuPinyinOutputFormatCombination {
        if (str == null || str.trim().length() == 0) {
            return "";
        }
        if (type == Type.UPPERCASE) {
            format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        } else {
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        }
        String py = "";
        String temp = "";
        String[] t;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((int) c <= 128) {
                py += c;
            } else {
                t = PinyinHelper.toHanyuPinyinStringArray(c, format);
                if (t == null) {
                    py += c;
                } else {
                    temp = t[0];
                    if (type == Type.FIRSTUPPER) {
                        temp = t[0].toUpperCase().charAt(0) + temp.substring(1);
                    }
                    if (temp.length() >= 1) {
                        temp = temp.substring(0, 1);
                    }
                    py += temp + (i == str.length() - 1 ? "" : spera);
                }
            }
        }
        return py.trim();
    }
}


