/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pojo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Employe {
	private int id;
	private String ad;
	private String soyad;
	private String ata_adi;
	private int maas;
	private String mail;
	private String tel;
	private String city_name;
	
	private int city_id;
	
	

	public Employe() {
	}

	public Employe(int id, String ad, String soyad, String ata_adi, int maas, String mail, String tel, String city_name) {
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.ata_adi = ata_adi;
		this.maas = maas;
		this.mail = mail;
		this.tel = tel;
		this.city_name = city_name;
	}

	public Employe(int id, String ad, String soyad, String ata_adi, int maas, String mail, String tel, int city_id) {
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.ata_adi = ata_adi;
		this.maas = maas;
		this.mail = mail;
		this.tel = tel;
		this.city_id = city_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getAta_adi() {
		return ata_adi;
	}

	public void setAta_adi(String ata_adi) {
		this.ata_adi = ata_adi;
	}

	public int getMaas() {
		return maas;
	}

	public void setMaas(int maas) {
		this.maas = maas;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	@Override
	public String toString() {
		return "Employe{" + "id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", ata_adi=" + ata_adi + ", maas=" + maas + ", mail=" + mail + ", tel=" + tel + ", city_name=" + city_name + ", city_id=" + city_id + '}';
	}

	
}