package org.cloud.dao;

import java.util.List;

import org.cloud.model.SongModel;
import org.cloud.pojo.Songs;

public interface ISongsDAO {

	List<Songs> retrieveSongsList(final SongModel songModelObj);

	List<Songs> retrieveArtistsList(final SongModel songModelObj);

	List<Songs> showArtistInformation(final String artistId);

	List<Songs> showSongInformation(final String songId);

	List<Songs> searchSongsByMood(final int songMood, final int searchCount);
	
	List<Songs> retrieveSongsArtists(final int searchCriteria);
	
	List<Songs> retrieveAngrySongs();
	
	List<Songs> retrieveExplosiveSongs();
	
	List<Songs> retrievePlainSongs();
	
	List<Songs> retrieveSoftQuietSongs();
	
	List<Songs> retrieveDarkSongs();
	
	List<Songs> retrieveEcstaticSongs();
	
	List<Songs> retrieveJoyousSongs();
	
	List<Songs> retrievePatrioticSongs();

}
