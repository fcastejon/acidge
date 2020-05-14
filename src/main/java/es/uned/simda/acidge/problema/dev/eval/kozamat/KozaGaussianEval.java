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
 * KozaGaussianEval
 * 
 * Evalua un circuito de función gaussiana según definición de Koza
 * 
 */
package es.uned.simda.acidge.problema.dev.eval.kozamat;

import java.util.logging.Logger;
import es.uned.simda.acidge.ge.GEProperties;

public class KozaGaussianEval extends GaussianEval 
{
	private final static Logger logger = Logger.getLogger(KozaGaussianEval.class.getName());

	public KozaGaussianEval(GEProperties geproperties) 
	{
		super(geproperties);
		logger.info("KozaGaussianEval");
	}
	
	double fitnessPunto(double abs)
	{
		double ret;
		
		if(abs <= TKOZA)
			ret = abs * TKOZAFACTOR1;
		else
			ret = abs * TKOZAFACTOR2;

		return ret;
	}
}
