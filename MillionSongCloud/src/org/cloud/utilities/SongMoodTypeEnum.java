package org.cloud.utilities;

public enum SongMoodTypeEnum {

	ANGRY(1, "ANGRY SONGS"), EXPLOSIVE(2, "EXPLOSIVE SONGS"), PLAIN(3, "PLAIN SONGS"), SOFTQUIET(4,
			"SOFT/QUIET SONGS"), DARK(5, "DARK SONGS"), ECSTATIC(6,
					"ECSTATIC SONGS"), JOYOUS(7, "JOYOUS SONGS"), PATRIOTIC(8, "PATRIOTIC SONGS"),;

	private int songMood;
	private String songMoodName;

	private SongMoodTypeEnum(int songMood, String songMoodName) {
		this.songMood = songMood;
		this.songMoodName = songMoodName;
	}

	public int getSongMood() {
		return songMood;
	}

	public String getSongMoodName() {
		return songMoodName;
	}

	public static String getValue(final int songMood) {
		for (final SongMoodTypeEnum songMoodType : values()) {
			if (songMoodType.getSongMood() == songMood) {
				return songMoodType.getSongMoodName();
			}
		}
		return "";
	}

}
