package com.meistermeier.springmvc.hero.api;

import com.meistermeier.springmvc.hero.domain.Hero;

import java.util.List;

public interface HeroService {
    List<Hero> findAllHeroes();

    Hero findHeroById(Long id);

    void save(Hero hero);
}
