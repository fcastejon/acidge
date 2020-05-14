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
 * Interfaz CirConstructor
 * 
 * De ella heredan los constructores de circuitos específicos
 * por expresiones de desarrollo o por creación de netlist
 */
package es.uned.simda.acidge.problema.dev;



import es.uned.simda.acidge.problema.InviableException;


public interface CirConstructor 
{	
	public int getSimulaciones();
	public boolean creaCircuitoExp(String exp) throws InviableException;
	public void adaptaCircuitoAnalisis(int analisis, String netfile) throws InviableException;
	public String getCircuit(int analisis) throws InviableException;
	
	public int getNivelInviable();
	public void setVtran(double vtran);
}
