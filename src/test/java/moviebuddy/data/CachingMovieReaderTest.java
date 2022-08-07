package moviebuddy.data;

import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

import java.util.ArrayList;
import java.util.List;

public class CachingMovieReaderTest {

    @Test
    void caching() {
        CacheManager cacheManager = new ConcurrentMapCacheManager();
        MovieReader target = new DummyMovieReader();

        CachingMovieReader cachingMovieReader = new CachingMovieReader(cacheManager, target);

        Assertions.assertNull(cachingMovieReader.getCachedData());

        List<Movie> movies = cachingMovieReader.loadMovies();
        Assertions.assertNotNull(cachingMovieReader.getCachedData());
        Assertions.assertEquals(cachingMovieReader.loadMovies(), movies);
    }

    class DummyMovieReader implements MovieReader {

        @Override
        public List<Movie> loadMovies() {
            return new ArrayList<>();
        }

    }

}
