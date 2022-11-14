package com.profesorp.cascade.controllers;

import com.profesorp.cascade.controllers.dtos.FacturaOutputDto;
import com.profesorp.cascade.controllers.dtos.LineaInputDto;
import com.profesorp.cascade.entities.CabeceraFra;
import com.profesorp.cascade.entities.Cliente;
import com.profesorp.cascade.entities.LineaFra;
import com.profesorp.cascade.repositories.CabeceraFraRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.NotActiveException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@RequestMapping("factura")
public class FacturaController {

    final CabeceraFraRepository cabeceraFraRepository;

    public FacturaController(CabeceraFraRepository cabeceraFraRepository) {
        this.cabeceraFraRepository = cabeceraFraRepository;
    }

    @GetMapping
    public Flux<FacturaOutputDto> findAll()
    {
        var future = new CompletableFuture<List<FacturaOutputDto>>();
        future.completeAsync(() -> cabeceraFraRepository.findAll().stream()
                        .map(  FacturaOutputDto::new)
                        .collect(Collectors.toList())
        );

        Flux<FacturaOutputDto> facturaOutputDtoFlux = Mono.fromFuture(future).flatMapMany(Flux::fromIterable);
        return facturaOutputDtoFlux;
    }

    @PostMapping("linea/{idFra}")
    public Mono<FacturaOutputDto> addLinea(@PathVariable  int idFra,@RequestBody LineaInputDto lineaInputDto) throws CompletionException
    {
        var future = new CompletableFuture<FacturaOutputDto>();

        future.completeAsync(() -> {
                Optional<CabeceraFra> fraOpt=cabeceraFraRepository.findById(idFra);
                if (fraOpt.isEmpty())
                    throw new CompletionException(new NotActiveException("Fra con id: "+ idFra+ " no existe"));
                var cabeceraFra= fraOpt.get();
                LineaFra lineaFra = lineaInputDto.toEntity();
                cabeceraFra.addLinea(lineaFra);
                cabeceraFraRepository.save(cabeceraFra);
                return new FacturaOutputDto(cabeceraFra);
        });
        return Mono.fromFuture(future );
    }
    @DeleteMapping("/{idFra}")
    public Mono<Void> deleteFactura(@PathVariable int idFra)
    {
        var future = new CompletableFuture<Void>();
        future.completeAsync(() ->  {
            Optional<CabeceraFra> fraOpt=cabeceraFraRepository.findById(idFra);
            if (fraOpt.isEmpty())
                throw new CompletionException(new NotActiveException("Fra con id: "+ idFra+ " no existe"));
            var cabeceraFra= fraOpt.get();
            cabeceraFraRepository.delete(cabeceraFra);
            return  null;
        });
        return Mono.fromFuture(future );
    }
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({ NotActiveException.class})
    public String handleException(NotActiveException not) {
        return "Error: "+not.getMessage();
    }
}
