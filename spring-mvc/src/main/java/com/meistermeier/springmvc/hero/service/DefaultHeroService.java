package com.meistermeier.springmvc.hero.service;

import com.google.common.collect.Lists;
import com.meistermeier.springmvc.hero.api.HeroService;
import com.meistermeier.springmvc.hero.domain.Hero;
import com.meistermeier.springmvc.hero.domain.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultHeroService implements HeroService {

    private final HeroRepository heroRepository;

    @Autowired
    public DefaultHeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public List<Hero> findAllHeroes() {
        return Lists.newArrayList(heroRepository.findAll());
    }

    @Override
    public Hero findHeroById(Long id) {
        return heroRepository.findOne(id);
    }

    @Override
    public void save(Hero hero) {
        heroRepository.save(hero);
    }
}
