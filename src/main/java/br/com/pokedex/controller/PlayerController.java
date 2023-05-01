package br.com.pokedex.controller;

import br.com.pokedex.dto.AttackDto;
import br.com.pokedex.entity.Attack;
import br.com.pokedex.entity.Player;
import br.com.pokedex.service.PlayerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Api(tags = "Players")
@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> save(@Valid @RequestBody Player player) {
        playerService.savePlayer(player);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(player.getId())
                .toUri();

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();

        response.setHeader(HttpHeaders.LOCATION, uri.toString());

        return ResponseEntity.created(uri).body(player);
    }
    @GetMapping
    public ResponseEntity<List<Player>> findAllPlayers(){
        var listAll = playerService.findAllPlayers();
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES)) //Adiciona o cache para 10mim no navegador
                .body(listAll);
    }

    @PutMapping(value = "/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void adicionarFotoPlayer(@PathVariable MultipartFile file) throws IOException {

        var arquivo = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();

        var arquivoP = Path.of("/Users/diogoemannuel/Desktop/playerphoto", arquivo);

        file.transferTo(arquivoP);
    }
}
