package com.profesorp.cascade.controllers;

import com.profesorp.cascade.entities.Cliente;
import com.profesorp.cascade.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public Flux<Cliente> findAll()
    {
        var future = new CompletableFuture<List<Cliente>>();
        future.completeAsync(() -> clienteRepository.findAll(),
                CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));

        Flux<Cliente> clientes = Mono.fromFuture(future).flatMapMany(Flux::fromIterable);
        return clientes;
    }
    @PostMapping
    public Mono<Cliente> add(@RequestBody Cliente cliente)
    {
        var future = new CompletableFuture<Cliente>();
        future.completeAsync(() -> clienteRepository.save(cliente));
        return Mono.fromFuture(future );
    }
}
