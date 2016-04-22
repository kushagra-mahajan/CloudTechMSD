package org.cloud.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SONGS_DATA")
public class Songs {

	@Id
	@Column(name = "SONGID")
	private String songId;

	@Column(name = "ARTISTFAMILIARITY")
	private BigDecimal artistFamiliarity;

	@Column(name = "ARTISTHOTNESS")
	private BigDecimal artistHotness;

	@Column(name = "ARTISTID")
	private String artistId;

	@Column(name = "ARTISTLOCATION")
	private String artistLocation;

	@Column(name = "ARTISTNAME")
	private String artistName;

	@Column(name = "ALBUMNAME")
	private String albumName;

	@Column(name = "ALBUMID")
	private String albumId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "SONGDURATION")
	private BigDecimal duration;

	@Column(name = "KEYSIGNATURE")
	private int keySignature;

	@Column(name = "KEYSIGNATURECONFIDENCE")
	private BigDecimal keySignatureConfidence;

	@Column(name = "LOUDNESS")
	private BigDecimal loudness;

	@Column(name = "SONGMODE")
	private int songMode;

	@Column(name = "TEMPO")
	private BigDecimal tempo;

	@Column(name = "TIMESIGNATURE")
	private int timeSignature;

	@Column(name = "TIMESIGNATURECONFIDENCE")
	private BigDecimal timeSignatureConfidence;

	@Column(name = "SONGYEAR")
	private int year;

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public BigDecimal getArtistFamiliarity() {
		return artistFamiliarity;
	}

	public void setArtistFamiliarity(BigDecimal artistFamiliarity) {
		this.artistFamiliarity = artistFamiliarity;
	}

	public BigDecimal getArtistHotness() {
		return artistHotness;
	}

	public void setArtistHotness(BigDecimal artistHotness) {
		this.artistHotness = artistHotness;
	}

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public String getArtistLocation() {
		return artistLocation;
	}

	public void setArtistLocation(String artistLocation) {
		this.artistLocation = artistLocation;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getDuration() {
		return duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

	public int getKeySignature() {
		return keySignature;
	}

	public void setKeySignature(int keySignature) {
		this.keySignature = keySignature;
	}

	public BigDecimal getKeySignatureConfidence() {
		return keySignatureConfidence;
	}

	public void setKeySignatureConfidence(BigDecimal keySignatureConfidence) {
		this.keySignatureConfidence = keySignatureConfidence;
	}

	public BigDecimal getLoudness() {
		return loudness;
	}

	public void setLoudness(BigDecimal loudness) {
		this.loudness = loudness;
	}

	public int getSongMode() {
		return songMode;
	}

	public void setSongMode(int songMode) {
		this.songMode = songMode;
	}

	public BigDecimal getTempo() {
		return tempo;
	}

	public void setTempo(BigDecimal tempo) {
		this.tempo = tempo;
	}

	public int getTimeSignature() {
		return timeSignature;
	}

	public void setTimeSignature(int timeSignature) {
		this.timeSignature = timeSignature;
	}

	public BigDecimal getTimeSignatureConfidence() {
		return timeSignatureConfidence;
	}

	public void setTimeSignatureConfidence(BigDecimal timeSignatureConfidence) {
		this.timeSignatureConfidence = timeSignatureConfidence;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
