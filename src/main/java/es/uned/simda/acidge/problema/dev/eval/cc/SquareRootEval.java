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
 * SquareRootEval
 * 
 * Evaluates a square root function circuit
 * 
 */
package es.uned.simda.acidge.problema.dev.eval.cc;

import java.util.logging.Logger;
import es.uned.simda.acidge.ge.GEProperties;


public class SquareRootEval extends ComputaEval 
{
	private final static Logger logger = Logger.getLogger(SquareRootEval.class.getName());
	
	private final static double VinicialDef = 0;
	private final static double VfinalDef = 500e-3;
	public final static double TKOZA = 1e-2;		//Porcentaje

	public SquareRootEval(GEProperties geproperties) 
	{
		super(geproperties);
		logger.info("SquareRootEval");
	}
	
	double getVinicial() { return VinicialDef; }
	double getVfinal() { return VfinalDef; }
	double getUmbralError() { return TKOZA; }
	
	//Actualiza fit, hits y canFit
	@Override
	void calculaFitnessHitsPunto(double abs, int j)
	{	
		if(abs <= error[j])
			hits++;

		canFit += abs;
		
		if(abs <= error[j])
			fit += abs * TKOZAFACTOR1;
		else
			fit += abs * TKOZAFACTOR2;
	}
	/*
	@Override
	double fitnessPunto(double abs, int j)
	{
		double ret;
		
		if(abs <= error[j])
			ret = abs * TKOZAFACTOR1;
		else
			ret = abs * TKOZAFACTOR2;

		return ret;
	}
	*/
	@Override
	double funcion(double vi)
	{
		return Math.sqrt(vi);
	}
}
