package com.meistermeier.springmvc.config;

import com.meistermeier.springmvc.hero.domain.Hero;
import com.meistermeier.springmvc.hero.domain.HeroRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

public class DummyDataProvider {
    private final HeroRepository repository;

    public DummyDataProvider(HeroRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    @Transactional
    public void setupTestData() {
        Hero hero = new Hero();
        hero.setName("Spiderman");
        hero.setRealName("Peter Parker");
        hero.setPowers("Cling on surface, Spider-Sense, web-slinging");
        repository.save(hero);
        hero = new Hero();
        hero.setName("Wolverine");
        hero.setRealName("James Howlett");
        hero.setPowers("Regeneration, claws");
        repository.save(hero);
        hero = new Hero();
        hero.setName("Iron Man");
        hero.setRealName("Anthony Edward \"Tony\" Stark");
        hero.setPowers("Nothing, but genius level intellect");
        repository.save(hero);
        hero = new Hero();
        hero.setName("Captain America");
        hero.setRealName("Steven \"Steve\" Rogers");
        hero.setPowers("Near fight, Superhuman");
        repository.save(hero);
    }
}
