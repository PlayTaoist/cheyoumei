package cn.com.cisec.cheyoumei.server.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @类名: NumberValidationUtils 
 * @描述: 判断参数类型
 * @作者 liuren-mail@163.com
 * @日期 2015年6月18日 下午6:07:45
 */
public class NumberValidationUtils {
	private static boolean isMatch(String regex, String orginal){  
        if (orginal == null || orginal.trim().equals("")) {  
            return false;  
        }  
        Pattern pattern = Pattern.compile(regex);  
        Matcher isNum = pattern.matcher(orginal);  
        return isNum.matches();  
    }  
	/**
	 * @标题: inversionNum 
	 * @描述: 把int和Integer转换为字符串再判断
	 * @参数 @param orginal
	 * @返回 String    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月18日 下午6:09:39
	 */
	public static String inversionNum(int orginal){
		String Num = String.valueOf(orginal);
		return Num;
	}
	/**
	 * @标题: isPositiveInteger 
	 * @描述: 判断是否是正整数,可以带+号,第一个数字不能为0
	 * @参数 @param orginal
	 * @返回 boolean    返回类型 
	 * @作者 liuren-mail@163.com
	 * @日期 2015年6月18日 下午5:53:56
	 */
    public static boolean isPositiveInteger(String orginal) {  
        return isMatch("^\\+{0,1}[1-9]\\d*", orginal); 
    }  
    /**
     * @标题: isNegativeInteger 
     * @描述: 判断负数,必须带负号,第一个数字不能为0 
     * @参数 @param orginal
     * @返回 boolean    返回类型 
     * @作者 liuren-mail@163.com
     * @日期 2015年6月18日 下午6:02:37
     */
    public static boolean isNegativeInteger(String orginal) {  
        return isMatch("^-[1-9]\\d*", orginal);  
    }  
    /**
     * @标题: isWholeNumber 
     * @描述: 对于整数而言，实际是由0，正整数和负整数组成的，所以偷个懒用前两个方法一起判断
     * @参数 @param orginal
     * @返回 boolean    返回类型 
     * @作者 liuren-mail@163.com
     * @日期 2015年6月18日 下午6:02:37
     */
    public static boolean isWholeNumber(String orginal) {  
        return isMatch("[+-]{0,1}0", orginal) || isPositiveInteger(orginal) || isNegativeInteger(orginal);  
    }  
     /**
      * @标题: isPositiveDecimal 
      * @描述: 对于正小数而言，可以考带+号，并考虑两种情况，第一个数字为0和第一个数字不为0，第一个数字为0时，则小数点后面应该不为0，第一个数字不为0时，小数点后可以为任意数字 
      * @参数 @param orginal
      * @返回 boolean    返回类型 
      * @作者 liuren-mail@163.com
      * @日期 2015年6月18日 下午6:05:47
      */
    public static boolean isPositiveDecimal(String orginal){  
        return isMatch("\\+{0,1}[0]\\.[1-9]*|\\+{0,1}[1-9]\\d*\\.\\d*", orginal);  
    }  
      /**
       * @标题: isNegativeDecimal 
       * @描述: 对于负小数而言，必须带负号，其余都同上
       * @参数 @return    设定文件 
       * @返回 boolean    返回类型 
       * @作者 liuren-mail@163.com
       * @日期 2015年6月18日 下午6:06:21
       */
    public static boolean isNegativeDecimal(String orginal){  
        return isMatch("^-[0]\\.[1-9]*|^-[1-9]\\d*\\.\\d*", orginal);  
    }  
      /**
       * @标题: isDecimal 
       * @描述: 对于小数，可以带正负号，并且带小数点就行了，但是至少保证小数点有一边不为空，所以这里还是分左边不为空和右边不为空的情况
       * @参数 @param orginal
       * @返回 boolean    返回类型 
       * @作者 liuren-mail@163.com
       * @日期 2015年6月18日 下午6:06:50
       */
    public static boolean isDecimal(String orginal){  
        return isMatch("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", orginal);  
    }  
      /**
       * @标题: isRealNumber 
       * @描述:  实数比较简单，，要么是整数，要么是小数
       * @参数 @param orginal
       * @返回 boolean    返回类型 
       * @作者 liuren-mail@163.com
       * @日期 2015年6月18日 下午6:07:24
       */
    public static boolean isRealNumber(String orginal){  
        return isWholeNumber(orginal) || isDecimal(orginal);  
    }  
  
}  
