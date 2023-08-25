package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    Map<String,Movie> Moviedb = new HashMap<>();
    Map<String,Director> Directordb = new HashMap<>();
    Map<String,String> Pairdb = new HashMap<>();

// add movie
    public void addMovie(Movie movie) {
        Moviedb.put(movie.getName(), movie);
    }

//add director
    public void addDirector(Director director){
        Directordb.put(director.getName(), director);
    }

//    Pairing movie and director
    public void addMovieDirectorPair(String movie, String director) {
    Pairdb.put(movie,director);
}

//    Get movie by name
    public Movie getMovieByName(String name) {
        return Moviedb.get(name);
    }


//    get director my name
    public Director getDirectorByName(String name) {
            return Directordb.get(name);
    }

//    get movies by director name

    public List<String> getMoviesByDirectorName(String name) {
        List<String> MovieByDirector = new ArrayList<>();
        for(String movie : Pairdb.keySet()) {
            if ((Pairdb.get(movie).equals(name))) {
                MovieByDirector.add(movie);
            }
        }
        return MovieByDirector;
    }

//    get all movies
    public List<String> findAllMovies() {
        List<String> AllMovies = new ArrayList();
        for(String movies : Moviedb.keySet()) {
            AllMovies.add(movies);
        }
        return AllMovies;
    }

    public void deleteDirectorByName(String name) {
        if(Directordb.containsKey(name)){
            Directordb.remove(name);
        }
        for(String movies : Pairdb.keySet()) {
            if (Pairdb.get(movies).equals(name)) {
                Moviedb.remove(name);
            }
        }
    }


    public void deleteAllDirectors() {
        for(String name:Directordb.keySet()){
            for(String movie:Pairdb.keySet()){
                if(Pairdb.get(movie).equals(name)){
                    if(Moviedb.containsKey(movie)){
                        Moviedb.remove(movie);
                    }
                }
            }
        }
        Directordb.clear();
    }
}
