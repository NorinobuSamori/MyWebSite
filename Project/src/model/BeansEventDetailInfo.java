package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BeansEventDetailInfo {
	private int id;
	private String title;
	private String img_name;
	private String summary;
	private String event_category;
	private String schedule;
	private String local_region;
	private int fees;
	private String access;
	private String qualification;
	private String presenter;
	private String organizer;

	private int order_id;
	private int user_id;
	private int total_fees;
	private Date order_create_date;
	private String str_order_create_date;

	private int key_id;
	private int order_id_key;
	private int event_id_key;

////計12項目
	public BeansEventDetailInfo(int id, String title, String img_name, String summary, String event_category,
    		String schedule, String local_region, int fees, String access, String qualification, String presenter,
    		String organizer ) {
	this.id = id;
	this.title = title;
	this.img_name = img_name;
	this.summary = summary;
	this.event_category = event_category;
	this.schedule = schedule;
	this.local_region = local_region;
	this.fees = fees;
	this.access = access;
	this.qualification = qualification;
	this.presenter = presenter;
	this.organizer = organizer;
	}


	public BeansEventDetailInfo() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getEvent_category() {
		return event_category;
	}
	public void setEvent_category(String event_category) {
		this.event_category = event_category;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getLocal_region() {
		return local_region;
	}
	public void setLocal_region(String local_region) {
		this.local_region = local_region;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getPresenter() {
		return presenter;
	}
	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}












//	public Date getOrder_create_date() {
//	return order_create_date;
//}
	public void setOrder_create_date(Date order_create_date) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		this.str_order_create_date = sdf1.format(order_create_date);
	}
	public String getStr_order_create_date() {
		return str_order_create_date;
	}
	//public void setStr_order_create_date(String str_order_create_date) {
	//	this.str_order_create_date = str_order_create_date;
	//}











	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(order_create_date);
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTotal_fees() {
		return total_fees;
	}
	public void setTotal_fees(int total_fees) {
		this.total_fees = total_fees;
	}








	public int getKey_id() {
		return key_id;
	}
	public void setKey_id(int key_id) {
		this.key_id = key_id;
	}
	public int getOrder_id_key() {
		return order_id_key;
	}
	public void setOrder_id_key(int order_id_key) {
		this.order_id_key = order_id_key;
	}
	public int getEvent_id_key() {
		return event_id_key;
	}
	public void setEvent_id_key(int event_id_key) {
		this.event_id_key = event_id_key;
	}








}
