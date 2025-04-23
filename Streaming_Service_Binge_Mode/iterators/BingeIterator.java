package Streaming_Service_Binge_Mode.iterators;

import Streaming_Service_Binge_Mode.Episode;
import Streaming_Service_Binge_Mode.Season;

import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private final List<Season> seasons;
    private int currentSeasonIndex;
    private EpisodeIterator currentEpisode;

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        if (!seasons.isEmpty()) {
            currentEpisode = new SeasonIterator(seasons.getFirst().getEpisodes());
        }
    }

    public boolean hasNext() {
        while ((currentEpisode == null || !currentEpisode.hasNext()) && currentSeasonIndex < seasons.size() - 1) {
            currentSeasonIndex++;
            currentEpisode = new SeasonIterator(seasons.get(currentSeasonIndex).getEpisodes());
        }
        return currentEpisode != null && currentEpisode.hasNext();
    }

    public Episode next() {
        return currentEpisode.next();
    }
}
