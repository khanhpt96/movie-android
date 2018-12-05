package com.pt.khanh.movie.data.repository;

import com.pt.khanh.movie.data.model.Cast;
import com.pt.khanh.movie.data.model.GenresResult;
import com.pt.khanh.movie.data.model.Movie;
import com.pt.khanh.movie.data.model.MovieResult;
import com.pt.khanh.movie.data.model.ReviewResult;
import com.pt.khanh.movie.data.source.MovieDatasource;
import com.pt.khanh.movie.data.source.local.MovieLocalDatasource;
import com.pt.khanh.movie.data.source.remote.MovieRemoteDataSource;

import java.util.List;

import io.reactivex.Observable;

public class MovieRepository implements MovieDatasource.RemoteDataSource, MovieDatasource.LocalDataSource {
    private static MovieRepository sInstance;
    private MovieRemoteDataSource mRemoteDataSource;
    private MovieLocalDatasource mLocalDatasource;

    public MovieRepository(MovieRemoteDataSource remoteDataSource,
                           MovieLocalDatasource localDatasource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDatasource = localDatasource;
    }

    public static synchronized MovieRepository getInstance(
            MovieRemoteDataSource remoteDataSource, MovieLocalDatasource localDatasource) {
        if (sInstance == null) {
            sInstance = new MovieRepository(remoteDataSource, localDatasource);
        }
        return sInstance;
    }

    @Override
    public Observable<MovieResult> searchMovie(String name, int page) {
        return mRemoteDataSource.searchMovie(name, page);
    }

    @Override
    public Observable<MovieResult> getMoviesCategory(String type, int page) {
        return mRemoteDataSource.getMoviesCategory(type, page);
    }

    @Override
    public Observable<GenresResult> getGenres() {
        return mRemoteDataSource.getGenres();
    }

    @Override
    public Observable<Movie> getMovie(int id) {
        return mRemoteDataSource.getMovie(id);
    }

    @Override
    public Observable<MovieResult> getMoviesByGenre(int page, int id) {
        return mRemoteDataSource.getMoviesByGenre(page, id);
    }

    @Override
    public Observable<MovieResult> getMoviesByGenres(int page, int... id) {
        return mRemoteDataSource.getMoviesByGenres(page, id);

    }

    @Override
    public Observable<MovieResult> getMoviesByListGenre(int page, String id) {
        return mRemoteDataSource.getMoviesByListGenre(page, id);
    }

    @Override
    public Observable<MovieResult> getMoviesByCast(int id, int page) {
        return mRemoteDataSource.getMoviesByCast(id, page);
    }

    @Override
    public Observable<MovieResult> getMoviesByCompany(int id, int page) {
        return mRemoteDataSource.getMoviesByCompany(id, page);
    }

    @Override
    public Observable<MovieResult> getMoviesTrend() {
        return mRemoteDataSource.getMoviesTrend();
    }

    @Override
    public Observable<Cast> getCastDetail(int id) {
        return mRemoteDataSource.getCastDetail(id);
    }

    @Override
    public Observable<MovieResult> getMovieRecommend(int id, int page) {
        return mRemoteDataSource.getMovieRecommend(id, page);
    }

    @Override
    public Observable<ReviewResult> getReview(int id, int page) {
        return mRemoteDataSource.getReview(id, page);
    }

    @Override
    public List<Movie> getMoviesLocal() {
        return mLocalDatasource.getMoviesLocal();
    }

    @Override
    public Movie getMovieLocal(int id) {
        return mLocalDatasource.getMovieLocal(id);
    }

    @Override
    public boolean insertMovie(Movie movie) {
        return mLocalDatasource.insertMovie(movie);
    }

    @Override
    public boolean deleteMovie(Movie movie) {
        return mLocalDatasource.deleteMovie(movie);
    }

    @Override
    public boolean isFavourite(Movie movie) {
        return mLocalDatasource.isFavourite(movie);
    }
}
