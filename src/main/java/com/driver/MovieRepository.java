package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    HashMap<String,Movie>hMovies=new HashMap<>();
    HashMap<String,Director>hDirectors=new HashMap<>();
    HashMap<String,String>hMovieDirector=new HashMap<>();
    public void addMovie(Movie movie) {
        String name= movie.getName();
        hMovies.put(name,movie);
    }

    public void addDirector(Director director) {
        String name= director.getName();
        hDirectors.put(name,director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        hMovieDirector.put(movie,director);
    }

    public Movie getMovieByName(String name) {
        return hMovies.get(name);
    }

    public Director getDirectorByName(String name) {
        return hDirectors.get(name);
    }

    public List<String> getMoviesByDirectorName(String name) {
        List<String>movies=new ArrayList<>();
        for(String movie: hMovieDirector.keySet()){
            if(hMovieDirector.get(movie).equals(name)){
                movies.add(movie);
            }
        }
        return movies;
    }

    public List<String> findAllMovies() {
        List<String>movies=new ArrayList<>();
        for(String name: hMovies.keySet()){
            movies.add(name);
        }
        return movies;
    }

    public void deleteDirectorByName(String name) {
        if(hDirectors.containsKey(name)){
            hDirectors.remove((name));
        }
        for(String movie:hMovieDirector.keySet()){
            if(hMovieDirector.get(movie).equals(name)){
                hMovies.remove(movie);
            }
        }
    }

    public void deleteAllDirectors() {
        for(String name:hDirectors.keySet()){
            for(String movie:hMovieDirector.keySet()){
                if(hMovieDirector.get(movie).equals(name)){
                    if(hMovies.containsKey(movie)){
                        hMovies.remove(movie);
                    }
                }
            }
        }
        hDirectors.clear();
    }
}