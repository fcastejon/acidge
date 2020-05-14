/*
**  Analog Circuit Design using Grammatical Evolution (ACID-GE)
**
**  Copyright (c) 2018 Federico Castejon, Enrique J. Carmona
**
**  This program is free software: you can redistribute it and/or modify
**  it under the terms of the GNU General Public License as published by
**  the Free Software Foundation, either version 3 of the License, or
**  (at your option) any later version.
**
**  This program is distributed in the hope that it will be useful,
**  but WITHOUT ANY WARRANTY; without even the implied warranty of
**  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
**  GNU General Public License for more details.
**
**  You should have received a copy of the GNU General Public License
**  along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
/*
 * Selector
 * 
 * Superclase abstracta a partir de la que heredan las implementaciones de 
 * los distintos esquemas de selección de padres
 * 
 */
package es.uned.simda.acidge.ge.operadores;

import es.uned.simda.acidge.ge.Fenotipo;
import es.uned.simda.acidge.ge.GEProperties;
import es.uned.simda.acidge.ge.Poblacion;
import es.uned.simda.acidge.ge.random.RandomGenerator;

public abstract class Selector 
{
	protected Poblacion pob;
	
	protected RandomGenerator randomGenerator;

	public Selector(GEProperties geproperties, RandomGenerator randomGenerator)
	{
		this.randomGenerator = randomGenerator;
	}

	public Selector(RandomGenerator randomGenerator)
	{
		this.randomGenerator = randomGenerator;
	}
	
	public abstract void inicia(Poblacion pob);
	
	public abstract Fenotipo select();
}
