/**
 * Voxxed Days Athens 2019 - Game of Life.
 */
package com.github.masterex.life;

import com.github.masterex.life.models.LifeDTO;
import com.github.masterex.life.models.Life;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Periklis Ntanasis <pntanasis@gmail.com>
 */
@RestController("life")
public class LifeController {

    @RequestMapping(name = "mutate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LifeDTO mutate(@RequestBody LifeDTO lifeDTO,
            @RequestParam(name = "iterations", defaultValue = "1", required = false) Integer iterations) {
        Life life = new Life(lifeDTO);
        while (iterations > 0) {
            life = life.mutate();
            iterations--;
        }
        return life.getLifeDTO();
    }

}
