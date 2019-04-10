package jp.webschool.javaweb.chapter12;

import java.util.ArrayList;

import jp.webschool.javaweb.chapter12.bean.ResBean;
import jp.webschool.javaweb.chapter12.util.Time;

public class ResList {
	private static ArrayList<ResBean> instance;

	private ResList(){};

	public static synchronized ArrayList<ResBean> getInstance(String name, String title, String contents){
		if(instance == null){
			instance = new ArrayList<ResBean>();
		}

		String time = Time.getNow();
		ResBean res = new ResBean();
		res.setTime(time);
		res.setName(name);
		res.setTitle(title);
		res.setContents(contents);
		instance.add(res);
		return instance;
	}

}
