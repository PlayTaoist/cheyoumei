package cn.com.cisec.cheyoumei.server.util;
/**
 * @类名: AddressSplitUtils 
 * @描述: 地址切割
 * @作者 liuren-mail@163.com
 * @日期 2015年6月15日 下午4:08:30
 */
public class AddressSplitUtils {

	
	public static String[] addrSplit(String addr){
		String[] addrSpilt = new String[5];
		if(addr.indexOf("省") > 0){
			addrSpilt[0] = addr.substring(0, addr.indexOf("省") + 1);
			addr = addr.substring(addr.indexOf("省") + 1);
		}
		if(addr.indexOf("市") > 0){
			addrSpilt[1] = addr.substring(0, addr.indexOf("市") + 1);
			addr = addr.substring(addr.indexOf("市") + 1);
		}
		if(addr.indexOf("县") > 0){
			addrSpilt[2] = addr.substring(0, addr.indexOf("县") + 1);
			addr = addr.substring(addr.indexOf("县") + 1);
		}
		if(addr.indexOf("区") > 0){
			addrSpilt[3] = addr.substring(0, addr.indexOf("区") + 1);
			addr = addr.substring(addr.indexOf("区") + 1);
		}
//		if(addr.indexOf("镇") > 0){
//			addrSpilt[4] = addr.substring(0, addr.indexOf("镇") + 1);
//			addr = addr.substring(addr.indexOf("镇") + 1);
//		}
		addrSpilt[4] = addr.substring(addr.indexOf("区") + 1);
		return addrSpilt;
	}

}
