package com.meistermeier.springmvc.hero.web;

import com.google.common.collect.Lists;
import com.meistermeier.springmvc.hero.api.HeroService;
import com.meistermeier.springmvc.hero.domain.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/heroes")
public class HeroController {

    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listHeroes(Model model) {
        List<Hero> allHeroes = heroService.findAllHeroes();
        List<HeroOverview> overviews = createOverview(allHeroes);
        model.addAttribute("heroes", overviews);
        return "hero_list";
    }

    private List<HeroOverview> createOverview(List<Hero> allHeroes) {
        List<HeroOverview> overviews = Lists.newArrayList();
        for (Hero hero : allHeroes) {
            overviews.add(new HeroOverview(hero.getId(), hero.getName()));
        }
        return overviews;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String heroDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("hero", heroService.findHeroById(id));
        return "hero_details";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createHero(Model model) {
        model.addAttribute("hero", new Hero());
        return "hero_create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveHero(@Valid @ModelAttribute("hero") Hero hero, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "hero_create";
        }

        heroService.save(hero);
        List<HeroOverview> overviews = createOverview(heroService.findAllHeroes());
        model.addAttribute("heroes", overviews);
        return "redirect:/heroes";
    }

    @RequestMapping(value = "/fail")
    public String shouldFail() {
        if (1 == 1) {
            throw new RuntimeException();
        }
        return "does_not_matter";
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception exception) {
        return new ModelAndView("error_view", "sourceOfException", request.getRequestURI());
    }

}
