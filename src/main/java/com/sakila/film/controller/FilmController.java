package com.sakila.film.controller;

import com.sakila.film.service.entity.Film;
import com.sakila.film.service.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//http://localhst:8080/api/film
@RestController
@RequestMapping("/api/film")
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public Page<Film> getAllFilms(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return filmRepository.findAll(pageable);
    }
}
