package org.cloud.utilities;

import java.math.BigDecimal;

public class ApplicationLibrary {

	/* SONG MOOD VALUES */
	public static int songMoodAngry 							= 1;
	public static int songMoodExplosive 						= 2;
	public static int songMoodPlain 							= 3;
	public static int songMoodSoftQuiet							= 4;
	public static int songMoodDark 								= 5;
	public static int songMoodEcstatic 							= 6;
	public static int songMoodJoyous 							= 7;
	public static int songMoodPatriotic 						= 8;
	/* ERROR CODES */
	public static int FETCH_SONG_DETAILS_ERROR_CODE				= 11000001;
	public static int SHOW_ARTIST_INFORMATION_ERROR_CODE		= 11000002;
	public static int SHOW_SONG_INFORMATION_ERROR_CODE			= 11000003;
	public static int SEARCH_SONGS_BY_MOOD_ERROR_CODE			= 11000004;
	public static int SEARCH_SONGS_ARTISTS_ERROR_CODE			= 11000005;
	public static int SEARCH_SONGS_ARTISTS_ERROR_CODE2			= 11000006;
	public static int EXPLORE_SONGS_BY_MOOD						= 11000007;
	public static int SAVE_USERS_QUERY							= 11000101;
	
	public static int FETCH_SONG_DETAILS_DAO_ERROR_CODE			= 11001001;
	public static int FETCH_ARTISTS_DETAILS_DAO_ERROR_CODE		= 11001002;
	public static int SHOW_SONG_INFORMATION_DAO_ERROR_CODE		= 11001003;
	public static int SHOW_ARTIST_INFORMATION_DAO_ERROR_CODE	= 11001004;
	public static int SEARCH_SONGS_BY_MOOD_DAO_ERROR_CODE		= 11001005;
	public static int SEARCH_SONGS_ARTISTS_DAO_ERROR_CODE		= 11001006;
	public static int FETCH_ANGRY_SONGS_DAO_ERROR_CODE			= 11001010;
	public static int FETCH_EXPLOSIVE_SONGS_DAO_ERROR_CODE		= 11001011;
	public static int FETCH_PLAIN_SONGS_DAO_ERROR_CODE			= 11001012;
	public static int FETCH_SOFT_QUIET_SONGS_DAO_ERROR_CODE		= 11001013;
	public static int FETCH_DARK_SONGS_DAO_ERROR_CODE			= 11001014;
	public static int FETCH_ECSTATIC_SONGS_DAO_ERROR_CODE		= 11001015;
	public static int FETCH_JOYOUS_SONGS_DAO_ERROR_CODE			= 11001016;
	public static int FETCH_PATRIOTIC_SONGS_DAO_ERROR_CODE		= 11001017;
	/* HQL QUERIES */
	public static String searchSongsQuery						= "SELECT s FROM Songs s";
	public static String searchAngrySongsQuery					= " WHERE  s.songMode = :songMode AND s.tempo > :avgTempo AND s.timeSignature > :timeSignature";
	public static String searchExplosiveSongsQuery				= " WHERE  s.songMode = :songMode AND s.tempo > :avgTempo AND s.timeSignature <= :timeSignature";
	public static String searchPlainSongsQuery					= " WHERE  s.songMode = :songMode AND s.tempo < :avgTempo AND s.timeSignature > :timeSignature";
	public static String searchSoftQuietSongsQuery				= " WHERE  s.songMode = :songMode AND s.tempo < :avgTempo AND s.timeSignature <= :timeSignature";
	public static String searchDarkSongsQuery					= " WHERE  s.songMode = :songMode AND s.tempo > :avgTempo AND s.timeSignature > :timeSignature";
	public static String searchEcstaticSongsQuery				= " WHERE  s.songMode = :songMode AND s.tempo > :avgTempo AND s.timeSignature <= :timeSignature";
	public static String searchJoyousSongsQuery					= " WHERE  s.songMode = :songMode AND s.tempo < :avgTempo AND s.timeSignature > :timeSignature";
	public static String searchPatrioticSongsQuery				= " WHERE  s.songMode = :songMode AND s.tempo < :avgTempo AND s.timeSignature <= :timeSignature";
	/* Other */
	public static int TOP_10_SEARCH_COUNT 						= 10;
	public static int TOP_5_SEARCH_COUNT 						= 5;
	public static int songMoodAngryCount 						= 108;
	public static int songMoodExplosiveCount					= 1365;
	public static int songMoodPlainCount						= 182;
	public static int songMoodSoftQuietCount					= 1433;
	public static int songMoodDarkCount 						= 233;
	public static int songMoodEcstaticCount 					= 2971;
	public static int songMoodJoyousCount 						= 346;
	public static int songMoodPatrioticCount 					= 3358;
	public static BigDecimal avgSongTempo 						= new BigDecimal(122.9);
	

}
