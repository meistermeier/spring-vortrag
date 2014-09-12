package com.meistermeier.springmvc.hero.web;

import com.google.common.collect.Lists;
import com.meistermeier.springmvc.config.JsonViewResolver;
import com.meistermeier.springmvc.hero.api.HeroService;
import com.meistermeier.springmvc.hero.domain.Hero;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HeroControllerTest {

    MockMvc mockMvc;

    HeroController controller = new HeroController(new HeroTestService());

    @Before
    public void setup() {
        mockMvc = standaloneSetup(controller).setViewResolvers(new JsonViewResolver()).build();
    }

    @Test
    public void listHeroesCorrect() throws Exception {
        mockMvc.perform(get("/heroes.json").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.heroes[0].name", is("TestHero")));
    }

    private static class HeroTestService implements HeroService {
        @Override
        public List<Hero> findAllHeroes() {
            return Lists.newArrayList(createHero());
        }

        @Override
        public Hero findHeroById(Long id) {
            return createHero();
        }

        @Override
        public void save(Hero hero) {

        }

        private Hero createHero() {
            Hero hero = new Hero();
            hero.setName("TestHero");
            return hero;
        }
    }

}