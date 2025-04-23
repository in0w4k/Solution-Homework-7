package Streaming_Service_Binge_Mode.iterators;

import Streaming_Service_Binge_Mode.Episode;

import java.util.List;

public class ReverseSeasonIterator implements EpisodeIterator {
    private final List<Episode> episodes;
    private int currentEpisodeIndex;

    public ReverseSeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
        this.currentEpisodeIndex = episodes.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentEpisodeIndex >= 0;
    }

    @Override
    public Episode next() {
        return episodes.get(currentEpisodeIndex--);
    }
}
