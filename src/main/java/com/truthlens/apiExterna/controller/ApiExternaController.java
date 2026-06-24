package com.truthlens.apiExterna.controller;

import com.truthlens.apiExterna.dto.PostDTO;

import com.truthlens.apiExterna.service.ApiExternaService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api-externa")

@RequiredArgsConstructor

public class ApiExternaController {

    private final ApiExternaService service;

    @GetMapping("/posts")

    public List<PostDTO> buscarPosts(){

        return service.buscarPosts();
    }
}