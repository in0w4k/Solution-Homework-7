package Streaming_Service_Binge_Mode.iterators;

import Streaming_Service_Binge_Mode.Episode;

import java.util.List;

public class SeasonIterator implements EpisodeIterator {
    private final List<Episode> episodes;
    private int currentEpisodeIndex = 0;

    public SeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public boolean hasNext() {
        return currentEpisodeIndex < episodes.size();
    }

    public Episode next() {
        return episodes.get(currentEpisodeIndex++);
    }
}