package org.cloud.action;

import java.util.ArrayList;
import java.util.List;
import org.cloud.dao.SongsDAO;
import org.cloud.model.SongModel;
import org.cloud.pojo.Songs;
import org.cloud.utilities.ApplicationLibrary;
import org.cloud.utilities.ApplicationUtil;
import org.cloud.utilities.BaseException;
import org.cloud.utilities.SongMoodTypeEnum;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author Kushagra Mahajan
 * @version 1.0.0.0
 *
 */
public class SearchSongsAction extends ActionSupport implements ModelDriven<SongModel> {

	/**
	 * serialVersionUID = 312893952311953519L
	 */
	private static final long serialVersionUID = 312893952311953519L;
	private SongModel model = new SongModel();

	@Override
	public SongModel getModel() {
		return model;
	}

	public void setModel(SongModel model) {
		this.model = model;
	}

	/**
	 * 
	 * @return songDetails
	 */
	public String fetchSongDetails() {
		String resultPage = "";
		final String methodName = "fetchSongDetails";
		SongsDAO daoObj = new SongsDAO();
		List<Songs> songsList = new ArrayList<Songs>();
		List<Songs> artistsList = new ArrayList<Songs>();
		try {
			songsList = daoObj.retrieveSongsList(getModel());
			artistsList = daoObj.retrieveArtistsList(getModel());
			if (ApplicationUtil.isNull(songsList) || songsList.size() == 0) {
				addActionError("No Songs Found");
			}
			if (ApplicationUtil.isNull(artistsList) || artistsList.size() == 0) {
				addActionError("No Artists Found");
			}
			getModel().setArtistsList(artistsList);
			getModel().setSongsList(songsList);
			resultPage = "songsDetails";
		} catch (Exception e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.FETCH_SONG_DETAILS_ERROR_CODE,
					this.getClass(), methodName);
			resultPage = "exception";
			addActionError(
					"Something Went wrong while fetching Song Details, please try again later. If the problem persists drop a query in the contact us page. Exception Time: "
							+ ApplicationUtil.convertTimeWithTimeZome(exception.getExceptionTime()) + " Error Code: "
							+ exception.getErrorCode());
		}
		return resultPage;
	}

	/**
	 * 
	 * @return artistInfo
	 */
	public String showArtistInformation() {
		String resultPage = "";
		final String methodName = "showArtistInformation";
		List<Songs> artistsInfoList = new ArrayList<Songs>();
		SongsDAO daoObj = new SongsDAO();
		try {
			artistsInfoList = daoObj.showArtistInformation(getModel().getArtistId());
			getModel().setArtistName(artistsInfoList.get(0).getArtistName());
			getModel().setArtistsInfoList(artistsInfoList);
			resultPage = "artistInfo";
		} catch (Exception e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.SHOW_ARTIST_INFORMATION_ERROR_CODE,
					this.getClass(), methodName);
			resultPage = "exception";
			addActionError(
					"Something Went wrong while fetching Artist Information, please try again later. If the problem persists drop a query in the contact us page. Exception Time: "
							+ ApplicationUtil.convertTimeWithTimeZome(exception.getExceptionTime()) + " Error Code: "
							+ exception.getErrorCode());
		}
		return resultPage;
	}

	/**
	 * 
	 * @return songInfo
	 */
	public String showSongInformation() {
		String resultPage = "";
		final String methodName = "showSongInformation";
		List<Songs> songInformationList = new ArrayList<Songs>();
		try {
			SongsDAO daoObj = new SongsDAO();
			songInformationList = daoObj.showSongInformation(getModel().getSongId());
			getModel().setSongInfoList(songInformationList);
			getModel().setTitle(songInformationList.get(0).getTitle());
			resultPage = "songInfo";
		} catch (Exception e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.SHOW_SONG_INFORMATION_ERROR_CODE,
					this.getClass(), methodName);
			resultPage = "exception";
			addActionError(
					"Something Went wrong while fetching Song Information, please try again later. If the problem persists drop a query in the contact us page. Exception Time: "
							+ ApplicationUtil.convertTimeWithTimeZome(exception.getExceptionTime()) + " Error Code: "
							+ exception.getErrorCode());
		}
		return resultPage;
	}

	/**
	 * 
	 * @return explorePage
	 */
	public String searchSongsByMood() {
		String resultPage = "";
		final String methodName = "searchSongsByMood";
		List<Songs> songListMyMood = new ArrayList<Songs>();
		SongsDAO daoObj = new SongsDAO();
		try {
			songListMyMood = daoObj.searchSongsByMood(getModel().getSongMood(), getModel().getSearchCount());
			if (ApplicationUtil.isNull(songListMyMood) || songListMyMood.size() == 0) {
				addActionError("No Songs found for this criteria.");
			}
			getModel().setSongListMyMood(songListMyMood);
			getModel().setSoongMoodName(SongMoodTypeEnum.getValue(getModel().getSongMood()));
			resultPage = "songsDetails";
		} catch (Exception e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.SEARCH_SONGS_BY_MOOD_ERROR_CODE,
					this.getClass(), methodName);
			resultPage = "exception";
			addActionError(
					"Something Went wrong while fetching songs by Mood, please try again later. If the problem persists drop a query in the contact us page. Exception Time: "
							+ ApplicationUtil.convertTimeWithTimeZome(exception.getExceptionTime()) + " Error Code: "
							+ exception.getErrorCode());
		}
		return resultPage;
	}

	/**
	 * 
	 * @return explorePage
	 */
	public String searchSongsArtistsByCriteria() {
		String resultPage = "";
		final String methodName = "searchSongsArtistsByCriteria";
		List<Songs> songsList = null;
		List<Songs> artistsList = null;
		SongsDAO daoObj = new SongsDAO();
		try {
			if ((getModel().getSearchCriteria()) == 1 || (getModel().getSearchCriteria() == 2)) {
				artistsList = new ArrayList<Songs>();
				artistsList = daoObj.retrieveSongsArtists(getModel().getSearchCriteria());
				if (ApplicationUtil.isNull(artistsList) || artistsList.size() == 0) {
					addActionError("No Artists details found");
				}
				getModel().setArtistsList(artistsList);
			} else if ((getModel().getSearchCriteria()) == 3 || (getModel().getSearchCriteria() == 4)) {
				songsList = new ArrayList<Songs>();
				songsList = daoObj.retrieveSongsArtists(getModel().getSearchCriteria());
				if (ApplicationUtil.isNull(songsList) || songsList.size() == 0) {
					addActionError("No Song details found");
				}
				getModel().setSongsList(songsList);
			} else {
				addActionError("Something went wrong. Please try again later. Error Code: "
						+ ApplicationLibrary.SEARCH_SONGS_ARTISTS_ERROR_CODE2);
			}
			resultPage = "explorePage";
		} catch (Exception e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.SEARCH_SONGS_ARTISTS_ERROR_CODE,
					this.getClass(), methodName);
			resultPage = "exception";
			addActionError(
					"Something Went wrong while fetching Songs/Artists Information, please try again later. If the problem persists drop a query in the contact us page. Exception Time: "
							+ ApplicationUtil.convertTimeWithTimeZome(exception.getExceptionTime()) + " Error Code: "
							+ exception.getErrorCode());
		}
		return resultPage;
	}

	/**
	 * 
	 * @return explorePage
	 */
	public String exploreSongsbyMood() {
		String resultPage = "";
		final String methodName = "exploreSongsbyMood";
		List<Songs> songsMoodList_1 = new ArrayList<Songs>();
		List<Songs> songsMoodList_2 = new ArrayList<Songs>();
		SongsDAO daoObj = new SongsDAO();
		try {
			if (getModel().getUserMood() == ApplicationLibrary.songMoodAngry) {
				songsMoodList_1 = daoObj.retrieveExplosiveSongs();
				getModel().setMoodValueOne("Explosive Songs");
				songsMoodList_2 = daoObj.retrieveSoftQuietSongs();
				getModel().setMoodValueTwo("Soft/Quiet Songs");
			} else if (getModel().getUserMood() == ApplicationLibrary.songMoodExplosive) {
				songsMoodList_1 = daoObj.retrieveAngrySongs();
				getModel().setMoodValueOne("Angry Songs");
				songsMoodList_2 = daoObj.retrievePatrioticSongs();
				getModel().setMoodValueTwo("Patriotic Songs");
			} else if (getModel().getUserMood() == ApplicationLibrary.songMoodPlain) {
				songsMoodList_1 = daoObj.retrieveJoyousSongs();
				getModel().setMoodValueOne("Joyous Songs");
				songsMoodList_2 = daoObj.retrieveExplosiveSongs();
				getModel().setMoodValueTwo("Explosive Songs");
			} else if (getModel().getUserMood() == ApplicationLibrary.songMoodSoftQuiet) {
				songsMoodList_1 = daoObj.retrievePlainSongs();
				getModel().setMoodValueOne("Plain Songs");
				songsMoodList_2 = daoObj.retrieveDarkSongs();
				getModel().setMoodValueTwo("Dark Songs");
			} else if (getModel().getUserMood() == ApplicationLibrary.songMoodDark) {
				songsMoodList_1 = daoObj.retrievePatrioticSongs();
				getModel().setMoodValueOne("Patriotic Songs");
				songsMoodList_2 = daoObj.retrieveDarkSongs();
				getModel().setMoodValueTwo("Dark Songs");
			} else if (getModel().getUserMood() == ApplicationLibrary.songMoodEcstatic) {
				songsMoodList_1 = daoObj.retrieveExplosiveSongs();
				getModel().setMoodValueOne("Explosive Songs");
				songsMoodList_2 = daoObj.retrieveJoyousSongs();
				getModel().setMoodValueTwo("Joyous Songs");
			} else if (getModel().getUserMood() == ApplicationLibrary.songMoodJoyous) {
				songsMoodList_1 = daoObj.retrieveEcstaticSongs();
				getModel().setMoodValueOne("Ecstatic Songs");
				songsMoodList_2 = daoObj.retrievePlainSongs();
				getModel().setMoodValueTwo("Plain Songs");
			} else if (getModel().getUserMood() == ApplicationLibrary.songMoodPatriotic) {
				songsMoodList_1 = daoObj.retrieveEcstaticSongs();
				getModel().setMoodValueOne("Ecstatic Songs");
				songsMoodList_2 = daoObj.retrievePatrioticSongs();
				getModel().setMoodValueTwo("Patriotic Songs");
			}
			getModel().setSongsMoodList_1(songsMoodList_1);
			getModel().setSongsMoodList_2(songsMoodList_2);
			resultPage = "explorePage";
		} catch (Exception e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.EXPLORE_SONGS_BY_MOOD, this.getClass(),
					methodName);
			resultPage = "exception";
			addActionError(
					"Something Went wrong while fetching recommended songs, please try again later. If the problem persists drop a query in the contact us page. Exception Time: "
							+ ApplicationUtil.convertTimeWithTimeZome(exception.getExceptionTime()) + " Error Code: "
							+ exception.getErrorCode());
		}
		return resultPage;
	}

}
