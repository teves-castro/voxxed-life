/**
 * Voxxed Days Athens 2019 - Game of Life.
 */
package com.github.masterex.life.models;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author Periklis Ntanasis <pntanasis@gmail.com>
 */
@Data
public class LifeDTO {

    private Set<Cell> cells = new HashSet<>();

}
