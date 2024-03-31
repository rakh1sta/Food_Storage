package org.example.onlinefoodstorage.controller;

import lombok.RequiredArgsConstructor;
import org.example.onlinefoodstorage.service.BaseService;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService> implements BaseController {
    protected final S service;
}