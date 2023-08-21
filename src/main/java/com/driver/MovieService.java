package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movierepo;


    public String addMovie(Movie movie){
        movierepo.addMovie(movie);
        return "Movie added successfully"
    }

    public String addDirector(Director director) {
        movierepo.addDirector(director);
        return "Director added successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        movierepo.addMovieDirectorPair(movieName, directorName);
        return "movie director paired successfully";
    }

    public Movie getMovieByName(String name) {
        return movierepo.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return movierepo.getDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String name) {
        return movierepo.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies() {
        return movierepo.findAllMovies();
    }

    public String deleteDirectorByName(String name) {
        movierepo.deleteDirectorByName(name);
        return "Director deleted Successfully";
    }

    public String deleteAllDirectors() {
        movierepo.deleteAllDirectors();
        return "all directors deleted successfully";
    }
}
