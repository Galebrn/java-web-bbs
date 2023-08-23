package com.studio2h.javawebbbs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Galebrn
 */
@RestController
@RequestMapping("/posts")
@Slf4j
public class PostController {
    @GetMapping("")
}
