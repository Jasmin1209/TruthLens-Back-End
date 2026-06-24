package com.truthlens.apiExterna.service;

import com.truthlens.apiExterna.dto.PostDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ApiExternaService {

    @Autowired
    private WebClient webClient;

    public List<PostDTO> buscarPosts(){

        return webClient
                .get()
                .uri(
                        "https://jsonplaceholder.typicode.com/posts"
                )
                .retrieve()
                .bodyToFlux(PostDTO.class)
                .collectList()
                .block();
    }
}