package gov.djbc.spring.fakentity;

import java.math.BigDecimal;

public class Referensi {
	private BigDecimal id;
	private String grup;
	private String kode;
	private String nama;
	private String keterangan;
	private Referensi parent;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getGrup() {
		return grup;
	}

	public void setGrup(String grup) {
		this.grup = grup;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public Referensi getParent() {
		return parent;
	}

	public void setParent(Referensi parent) {
		this.parent = parent;
	}

}
