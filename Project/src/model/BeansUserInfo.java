package model;

import java.util.Date;

public class BeansUserInfo {
	private int id;
	private String login_id;
	private String name;
	private Date birth_date;
	private String password;
	private String create_date;
	private String update_date;

////private Date birthDate;これを記入しただけでDate型のエラーが消えた。謎。

	// ログインセッションを保存するためのコンストラクタ
	public BeansUserInfo(String login_id, String password) {
		this.login_id = login_id;
		this.password = password;
	}

	public BeansUserInfo(int id, String login_id , String name , Date birth_date ,String password , String create_date ,
				String update_date){
	this.id = id;
	this.login_id = login_id;
	this.name = name;
	this.birth_date = birth_date;
	this.password = password;
	this.create_date = create_date;
	this.update_date = update_date;
	}

	public BeansUserInfo(int login_id, String name , Date birth_date , String create_date , String update_date){
	this.id = login_id;
	this.name = name;
	this.birth_date = birth_date;
	this.create_date = create_date;
	this.update_date = update_date;
	}


	public BeansUserInfo(String login_id, String password, String name, Date birth_date) {
		this.login_id = login_id;
		this.name = name;
		this.birth_date = birth_date;
		this.password = password;
	}

	public BeansUserInfo(String password, String name, Date birth_date) {
		this.password = password;
		this.name = name;
		this.birth_date = birth_date;
	}

	////(int id, String login_id , String name , String birth_date ,String password , String create_date ,
////	String update_date){の箇所に色がつかなくて焦ったが、下記のthis.を全て直したら光った。よかったよかった。

	public BeansUserInfo() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}



}
