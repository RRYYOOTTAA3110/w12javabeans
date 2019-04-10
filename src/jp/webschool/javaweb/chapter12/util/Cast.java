package jp.webschool.javaweb.chapter12.util;

import java.util.List;

import jp.webschool.javaweb.chapter12.bean.ResBean;

public class Cast {

	@SuppressWarnings("unchecked")
	public static List<ResBean> castList(Object object){
		return (List<ResBean>)object;
	}

}
