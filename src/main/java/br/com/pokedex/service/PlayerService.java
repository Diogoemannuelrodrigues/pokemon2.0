package br.com.pokedex.service;

import br.com.pokedex.entity.Player;
import br.com.pokedex.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player savePlayer(Player player){
        var playerNew = playerRepository.save(player);
        return Optional.of(playerNew).orElseThrow();
    }
    public List<Player> findAllPlayers(){
        return playerRepository.findAll();
    }
}
