package com.jwt.hibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "MITARBEITER")
@Table(name = "MITARBEITER")
public class MitarbeiterEO implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "M_ID")
	private int m_id;

	@Column(name = "M_NAME")
	private String m_name;

	@Column(name = "M_VORNAME")
	private String m_vorname;

	@Column(name = "M_TELNR")
	private String m_telnr;

	@Column(name = "M_ADRESSE")
	private String m_adresse;

	public MitarbeiterEO(String ma_name, String ma_vorname, String ma_telnr, String ma_adresse) {
		super();
		this.m_name = ma_name;
		this.m_vorname = ma_vorname;
		this.m_telnr = ma_telnr;
		this.m_adresse = ma_adresse;
	}

	public MitarbeiterEO() {
		// TODO Auto-generated constructor stub
		super();
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_vorname() {
		return m_vorname;
	}

	public void setM_vorname(String m_vorname) {
		this.m_vorname = m_vorname;
	}

	public String getM_telnr() {
		return m_telnr;
	}

	public void setM_telnr(String m_telnr) {
		this.m_telnr = m_telnr;
	}

	public String getM_adresse() {
		return m_adresse;
	}

	public void setM_adresse(String m_adresse) {
		this.m_adresse = m_adresse;
	}

	public String toJSON() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("ID:").append(this.m_id).append(",");
		sb.append("Name:").append(this.m_name).append(",");
		sb.append("Vorname:").append(this.m_vorname).append(",");
		sb.append("Addresse:").append(this.m_adresse.replace(",", " ")).append(",");
		sb.append("TelNr:").append(this.m_telnr).append(",");
		sb.append("}");
		return sb.toString();
	}
}