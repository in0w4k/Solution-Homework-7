package Streaming_Service_Binge_Mode.iterators;

import Streaming_Service_Binge_Mode.Episode;

public interface EpisodeIterator {
    boolean hasNext();
    Episode next();
}
