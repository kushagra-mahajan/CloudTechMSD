package org.cloud.model;

import java.util.ArrayList;
import java.util.List;

import org.cloud.pojo.Songs;

public class SongModel {

	private String songId;
	private double artistFamiliarity;
	private double artistHotness;
	private String artistId;
	private String artistLocation;
	private String artistName;
	private String albumName;
	private String albumId;
	private String title;
	private double duration;
	private int keySignature;
	private double keySignatureConfidence;
	private double loudness;
	private int songMode;
	private double tempo;
	private int timeSignature;
	private double timeSignatureConfidence;
	private int year;
	private int searchCount;
	private List<Songs> songsList = new ArrayList<>();
	private List<Songs> artistsList = new ArrayList<>();
	private List<Songs> artistsInfoList = new ArrayList<>();
	private List<Songs> songInfoList = new ArrayList<>();
	private int songMood;
	private String infoType;
	private List<Songs> songListMyMood = new ArrayList<>();
	private String soongMoodName;
	private int searchCriteria;
	private int userMood;
	private List<Songs> songsMoodList_1 = new ArrayList<>();
	private List<Songs> songsMoodList_2 = new ArrayList<>();
	private String moodValueOne;
	private String moodValueTwo;

	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public double getArtistFamiliarity() {
		return artistFamiliarity;
	}

	public void setArtistFamiliarity(double artistFamiliarity) {
		this.artistFamiliarity = artistFamiliarity;
	}

	public double getArtistHotness() {
		return artistHotness;
	}

	public void setArtistHotness(double artistHotness) {
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

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getKeySignature() {
		return keySignature;
	}

	public void setKeySignature(int keySignature) {
		this.keySignature = keySignature;
	}

	public double getKeySignatureConfidence() {
		return keySignatureConfidence;
	}

	public void setKeySignatureConfidence(double keySignatureConfidence) {
		this.keySignatureConfidence = keySignatureConfidence;
	}

	public double getLoudness() {
		return loudness;
	}

	public void setLoudness(double loudness) {
		this.loudness = loudness;
	}

	public int getSongMode() {
		return songMode;
	}

	public void setSongMode(int songMode) {
		this.songMode = songMode;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public int getTimeSignature() {
		return timeSignature;
	}

	public void setTimeSignature(int timeSignature) {
		this.timeSignature = timeSignature;
	}

	public double getTimeSignatureConfidence() {
		return timeSignatureConfidence;
	}

	public void setTimeSignatureConfidence(double timeSignatureConfidence) {
		this.timeSignatureConfidence = timeSignatureConfidence;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}

	public List<Songs> getSongsList() {
		return songsList;
	}

	public void setSongsList(List<Songs> songsList) {
		this.songsList = songsList;
	}

	public int getSongMood() {
		return songMood;
	}

	public void setSongMood(int songMood) {
		this.songMood = songMood;
	}

	public List<Songs> getArtistsList() {
		return artistsList;
	}

	public void setArtistsList(List<Songs> artistsList) {
		this.artistsList = artistsList;
	}

	public List<Songs> getArtistsInfoList() {
		return artistsInfoList;
	}

	public void setArtistsInfoList(List<Songs> artistsInfoList) {
		this.artistsInfoList = artistsInfoList;
	}

	public List<Songs> getSongInfoList() {
		return songInfoList;
	}

	public void setSongInfoList(List<Songs> songInfoList) {
		this.songInfoList = songInfoList;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public List<Songs> getSongListMyMood() {
		return songListMyMood;
	}

	public void setSongListMyMood(List<Songs> songListMyMood) {
		this.songListMyMood = songListMyMood;
	}

	public String getSoongMoodName() {
		return soongMoodName;
	}

	public void setSoongMoodName(String soongMoodName) {
		this.soongMoodName = soongMoodName;
	}

	public int getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(int searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public int getUserMood() {
		return userMood;
	}

	public void setUserMood(int userMood) {
		this.userMood = userMood;
	}

	public List<Songs> getSongsMoodList_1() {
		return songsMoodList_1;
	}

	public void setSongsMoodList_1(List<Songs> songsMoodList_1) {
		this.songsMoodList_1 = songsMoodList_1;
	}

	public List<Songs> getSongsMoodList_2() {
		return songsMoodList_2;
	}

	public void setSongsMoodList_2(List<Songs> songsMoodList_2) {
		this.songsMoodList_2 = songsMoodList_2;
	}

	public String getMoodValueOne() {
		return moodValueOne;
	}

	public void setMoodValueOne(String moodValueOne) {
		this.moodValueOne = moodValueOne;
	}

	public String getMoodValueTwo() {
		return moodValueTwo;
	}

	public void setMoodValueTwo(String moodValueTwo) {
		this.moodValueTwo = moodValueTwo;
	}

}
