package org.cloud.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.cloud.model.SongModel;
import org.cloud.pojo.Songs;
import org.cloud.utilities.ApplicationLibrary;
import org.cloud.utilities.ApplicationUtil;
import org.cloud.utilities.BaseException;
import org.hibernate.service.spi.ServiceException;

public class SongsDAO implements ISongsDAO {

	private EntityManagerFactory emf;
	private EntityManager entityManager;

	public SongsDAO() {
		super();
		emf = Persistence.createEntityManagerFactory("MillionSongCloud");
		entityManager = emf.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Songs> retrieveSongsList(final SongModel songModelObj) {
		List<Songs> songsList = new ArrayList<>();
		Query query = null;
		final String methodName = "retrieveSongsList";

		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);

			if (!ApplicationUtil.isNull(songModelObj.getTitle())) {
				queryString.append(" WHERE LOWER(s.title) LIKE :title");
			}

			query = entityManager.createQuery(queryString.toString());
			query.setMaxResults(songModelObj.getSearchCount());
			if (!ApplicationUtil.isNull(songModelObj.getTitle())) {
				query.setParameter("title", "%" + songModelObj.getTitle().toLowerCase() + "%");
			}

			songsList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.FETCH_SONG_DETAILS_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return songsList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Songs> retrieveArtistsList(final SongModel songModelObj) {
		List<Songs> artistsList = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "retrieveArtistsList";

		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			if (!ApplicationUtil.isNull(songModelObj.getTitle())) {
				queryString.append(" WHERE LOWER(s.artistName) LIKE :artistName");
			}

			query = entityManager.createQuery(queryString.toString());
			query.setMaxResults(songModelObj.getSearchCount());
			if (!ApplicationUtil.isNull(songModelObj.getTitle())) {
				query.setParameter("artistName", "%" + songModelObj.getTitle().toLowerCase() + "%");
			}

			artistsList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.FETCH_ARTISTS_DETAILS_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return artistsList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Songs> showArtistInformation(final String artistId) {
		List<Songs> artistsInfoList = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "showArtistInformation";
		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			queryString.append(" WHERE s.artistId = :artistId");
			query = entityManager.createQuery(queryString.toString());
			query.setParameter("artistId", artistId);
			artistsInfoList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.SHOW_ARTIST_INFORMATION_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return artistsInfoList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Songs> showSongInformation(final String songId) {
		List<Songs> songInfoList = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "showSongInformation";
		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			queryString.append(" WHERE s.songId = :songId");
			query = entityManager.createQuery(queryString.toString());
			query.setParameter("songId", songId);
			songInfoList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.SHOW_SONG_INFORMATION_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return songInfoList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Songs> searchSongsByMood(final int songMood, final int searchCount) {
		List<Songs> songListMyMood = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "searchSongsByMood";
		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			if (songMood == 1) {
				queryString.append(ApplicationLibrary.searchAngrySongsQuery);
			} else if (songMood == 2) {
				queryString.append(ApplicationLibrary.searchExplosiveSongsQuery);
			} else if (songMood == 3) {
				queryString.append(ApplicationLibrary.searchEcstaticSongsQuery);
			} else if (songMood == 4) {
				queryString.append(ApplicationLibrary.searchSoftQuietSongsQuery);
			} else if (songMood == 5) {
				queryString.append(ApplicationLibrary.searchDarkSongsQuery);
			} else if (songMood == 6) {
				queryString.append(ApplicationLibrary.searchEcstaticSongsQuery);
			} else if (songMood == 7) {
				queryString.append(ApplicationLibrary.searchJoyousSongsQuery);
			} else if (songMood == 8) {
				queryString.append(ApplicationLibrary.searchPatrioticSongsQuery);
			}

			query = entityManager.createQuery(queryString.toString());

			if ((songMood == 1) || (songMood == 2) || (songMood == 3) || (songMood == 4)) {
				query.setParameter("songMode", 0);
				query.setParameter("avgTempo", ApplicationLibrary.avgSongTempo);
				query.setParameter("timeSignature", 4);
			} else if ((songMood == 5) || (songMood == 6) || (songMood == 7) || (songMood == 8)) {
				query.setParameter("songMode", 1);
				query.setParameter("avgTempo", ApplicationLibrary.avgSongTempo);
				query.setParameter("timeSignature", 4);
			}

			if (songMood == 1) {
				query.setFirstResult(ApplicationUtil.randInt(1,
						ApplicationLibrary.songMoodAngryCount - ApplicationLibrary.TOP_10_SEARCH_COUNT));
			} else if (songMood == 2) {
				query.setFirstResult(ApplicationUtil.randInt(1,
						ApplicationLibrary.songMoodExplosiveCount - ApplicationLibrary.TOP_10_SEARCH_COUNT));
			} else if (songMood == 3) {
				query.setFirstResult(ApplicationUtil.randInt(1,
						ApplicationLibrary.songMoodPlainCount - ApplicationLibrary.TOP_10_SEARCH_COUNT));
			} else if (songMood == 4) {
				query.setFirstResult(ApplicationUtil.randInt(1,
						ApplicationLibrary.songMoodSoftQuietCount - ApplicationLibrary.TOP_10_SEARCH_COUNT));
			} else if (songMood == 5) {
				query.setFirstResult(ApplicationUtil.randInt(1,
						ApplicationLibrary.songMoodDarkCount - ApplicationLibrary.TOP_10_SEARCH_COUNT));
			} else if (songMood == 6) {
				query.setFirstResult(ApplicationUtil.randInt(1,
						ApplicationLibrary.songMoodEcstaticCount - ApplicationLibrary.TOP_10_SEARCH_COUNT));
			} else if (songMood == 7) {
				query.setFirstResult(ApplicationUtil.randInt(1,
						ApplicationLibrary.songMoodJoyousCount - ApplicationLibrary.TOP_10_SEARCH_COUNT));
			} else if (songMood == 8) {
				query.setFirstResult(ApplicationUtil.randInt(1,
						ApplicationLibrary.songMoodPatrioticCount - ApplicationLibrary.TOP_10_SEARCH_COUNT));
			}

			query.setMaxResults(searchCount);
			songListMyMood = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.SEARCH_SONGS_BY_MOOD_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return songListMyMood;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Songs> retrieveSongsArtists(final int searchCriteria) {
		List<Songs> searchList = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "retrieveSongsArtists";
		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			if (searchCriteria == 1) {
				queryString.append(" ORDER BY s.artistFamiliarity DESC");
			} else if (searchCriteria == 2) {
				queryString.append(" ORDER BY s.artistHotness DESC");
			} else if (searchCriteria == 3) {
				queryString.append(" ORDER BY s.duration DESC");
			} else if (searchCriteria == 4) {
				queryString.append(" ORDER BY s.tempo DESC");
			}
			query = entityManager.createQuery(queryString.toString());
			query.setMaxResults(ApplicationLibrary.TOP_10_SEARCH_COUNT);
			searchList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.SEARCH_SONGS_ARTISTS_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return searchList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> retrieveAngrySongs() {
		List<Songs> angrySongsList = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "retrieveAngrySongs";
		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			queryString.append(ApplicationLibrary.searchAngrySongsQuery);
			query = entityManager.createQuery(queryString.toString());
			query.setParameter("songMode", 0);
			query.setParameter("avgTempo", ApplicationLibrary.avgSongTempo);
			query.setParameter("timeSignature", 4);
			query.setFirstResult(ApplicationUtil.randInt(1,
					ApplicationLibrary.songMoodAngryCount - ApplicationLibrary.TOP_5_SEARCH_COUNT));
			query.setMaxResults(ApplicationLibrary.TOP_5_SEARCH_COUNT);
			angrySongsList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.FETCH_ANGRY_SONGS_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return angrySongsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> retrieveExplosiveSongs() {
		List<Songs> explosiveSongsList = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "retrieveExplosiveSongs";
		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			queryString.append(ApplicationLibrary.searchExplosiveSongsQuery);
			query = entityManager.createQuery(queryString.toString());
			query.setParameter("songMode", 0);
			query.setParameter("avgTempo", ApplicationLibrary.avgSongTempo);
			query.setParameter("timeSignature", 4);
			query.setFirstResult(ApplicationUtil.randInt(1,
					ApplicationLibrary.songMoodExplosiveCount - ApplicationLibrary.TOP_5_SEARCH_COUNT));
			query.setMaxResults(ApplicationLibrary.TOP_5_SEARCH_COUNT);
			explosiveSongsList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.FETCH_EXPLOSIVE_SONGS_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return explosiveSongsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> retrievePlainSongs() {
		List<Songs> plainSongsList = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "retrievePlainSongs";
		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			queryString.append(ApplicationLibrary.searchPlainSongsQuery);
			query = entityManager.createQuery(queryString.toString());
			query.setParameter("songMode", 0);
			query.setParameter("avgTempo", ApplicationLibrary.avgSongTempo);
			query.setParameter("timeSignature", 4);
			query.setFirstResult(ApplicationUtil.randInt(1,
					ApplicationLibrary.songMoodPlainCount - ApplicationLibrary.TOP_5_SEARCH_COUNT));
			query.setMaxResults(ApplicationLibrary.TOP_5_SEARCH_COUNT);
			plainSongsList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.FETCH_PLAIN_SONGS_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return plainSongsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> retrieveSoftQuietSongs() {
		List<Songs> softQuietSongsList = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "retrieveSoftQuietSongs";
		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			queryString.append(ApplicationLibrary.searchSoftQuietSongsQuery);
			query = entityManager.createQuery(queryString.toString());
			query.setParameter("songMode", 0);
			query.setParameter("avgTempo", ApplicationLibrary.avgSongTempo);
			query.setParameter("timeSignature", 4);
			query.setFirstResult(ApplicationUtil.randInt(1,
					ApplicationLibrary.songMoodSoftQuietCount - ApplicationLibrary.TOP_5_SEARCH_COUNT));
			query.setMaxResults(ApplicationLibrary.TOP_5_SEARCH_COUNT);
			softQuietSongsList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.FETCH_SOFT_QUIET_SONGS_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return softQuietSongsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> retrieveDarkSongs() {
		List<Songs> darkSongsList = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "retrieveDarkSongs";
		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			queryString.append(ApplicationLibrary.searchDarkSongsQuery);
			query = entityManager.createQuery(queryString.toString());
			query.setParameter("songMode", 1);
			query.setParameter("avgTempo", ApplicationLibrary.avgSongTempo);
			query.setParameter("timeSignature", 4);
			query.setFirstResult(ApplicationUtil.randInt(1,
					ApplicationLibrary.songMoodDarkCount - ApplicationLibrary.TOP_5_SEARCH_COUNT));
			query.setMaxResults(ApplicationLibrary.TOP_5_SEARCH_COUNT);
			darkSongsList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.FETCH_DARK_SONGS_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return darkSongsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> retrieveEcstaticSongs() {
		List<Songs> ecstaticSongsList = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "retrieveEcstaticSongs";
		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			queryString.append(ApplicationLibrary.searchEcstaticSongsQuery);
			query = entityManager.createQuery(queryString.toString());
			query.setParameter("songMode", 1);
			query.setParameter("avgTempo", ApplicationLibrary.avgSongTempo);
			query.setParameter("timeSignature", 4);
			query.setFirstResult(ApplicationUtil.randInt(1,
					ApplicationLibrary.songMoodEcstaticCount - ApplicationLibrary.TOP_5_SEARCH_COUNT));
			query.setMaxResults(ApplicationLibrary.TOP_5_SEARCH_COUNT);
			ecstaticSongsList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.FETCH_ECSTATIC_SONGS_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return ecstaticSongsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> retrieveJoyousSongs() {
		List<Songs> joyousSongsList = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "retrieveJoyousSongs";
		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			queryString.append(ApplicationLibrary.searchJoyousSongsQuery);
			query = entityManager.createQuery(queryString.toString());
			query.setParameter("songMode", 1);
			query.setParameter("avgTempo", ApplicationLibrary.avgSongTempo);
			query.setParameter("timeSignature", 4);
			query.setFirstResult(ApplicationUtil.randInt(1,
					ApplicationLibrary.songMoodJoyousCount - ApplicationLibrary.TOP_5_SEARCH_COUNT));
			query.setMaxResults(ApplicationLibrary.TOP_5_SEARCH_COUNT);
			joyousSongsList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.FETCH_JOYOUS_SONGS_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return joyousSongsList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> retrievePatrioticSongs() {
		List<Songs> patrioticSongsList = new ArrayList<Songs>();
		Query query = null;
		final String methodName = "retrievePatrioticSongs";
		try {
			StringBuilder queryString = new StringBuilder(ApplicationLibrary.searchSongsQuery);
			queryString.append(ApplicationLibrary.searchPatrioticSongsQuery);
			query = entityManager.createQuery(queryString.toString());
			query.setParameter("songMode", 1);
			query.setParameter("avgTempo", ApplicationLibrary.avgSongTempo);
			query.setParameter("timeSignature", 4);
			query.setFirstResult(ApplicationUtil.randInt(1,
					ApplicationLibrary.songMoodPatrioticCount - ApplicationLibrary.TOP_5_SEARCH_COUNT));
			query.setMaxResults(ApplicationLibrary.TOP_5_SEARCH_COUNT);
			patrioticSongsList = query.getResultList();
		} catch (ServiceException | PersistenceException e) {
			BaseException exception = new BaseException(e, ApplicationLibrary.FETCH_PATRIOTIC_SONGS_DAO_ERROR_CODE,
					this.getClass(), methodName);
			System.out.println(exception.toString());
		}
		return patrioticSongsList;
	}

}
