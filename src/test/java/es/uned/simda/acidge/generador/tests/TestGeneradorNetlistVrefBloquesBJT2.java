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
 * TestCase para probar la clase Generador y la gramática testNetlistGrammar.ebnf
 */
package es.uned.simda.acidge.generador.tests;

//import static org.junit.Assert.*;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
//import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uned.simda.acidge.ge.GEProperties;
import es.uned.simda.acidge.ge.Genotipo;
import es.uned.simda.acidge.generador.GenException;
import es.uned.simda.acidge.generador.Generador;
import es.uned.simda.acidge.generador.GeneradorGrammar;
import es.uned.simda.acidge.generador.gramatica.Gramatica;
import es.uned.simda.acidge.generador.parser.ASTSyntax;
import es.uned.simda.acidge.generador.parser.EBNFGrammar;
import es.uned.simda.acidge.generador.parser.EBNFGrammarVisitor;
import es.uned.simda.acidge.generador.parser.EBNFGrammarVisitorAGramatica;
import es.uned.simda.acidge.generador.parser.ParseException;


public class TestGeneradorNetlistVrefBloquesBJT2 
{
	private final static Logger logger = Logger.getLogger(TestGeneradorNetlistVrefBloquesBJT2.class.getName());
	final static String newLine = String.format("%n");
	final static String GRAMMARTEST1 = "testNetlistVrefBloquesBJT2.ebnf";

	Gramatica gramatica;
	
	@BeforeClass
	public static void init()
	{
		es.uned.simda.acidge.util.Util.checkEA();
		es.uned.simda.acidge.util.LoggerStart.trivialSetup(Level.FINE);
	}
	
	@Test
	public void test1() 
	{
		logger.info("test1");
		
		InputStream is = getClass().getResourceAsStream(GRAMMARTEST1);
		GeneradorGrammar.cargaGrama(is);
				
		String expected = 
			"R 2 3 1.0e0" + newLine +
			"R 2 3 1.0e0" + newLine +
			"R 2 3 1.0e0" + newLine +
			"R 4 2 1.0e0" + newLine +
			"R 4 2 1.0e0" + newLine +
			"Q 2 3 4 Q2N3906 nulo1" + newLine +
			"Q 2 3 4 Q2N3906 nulo1" + newLine +
			"Q 2 3 4 Q2N3904 nulo1" + newLine;
		
		byte genes[] = { 
						1, 1, 2, 0, 0, 0,
						1, 1, 2, 0, 0, 0,
						1, 1, 2, 0, 0, 0,
						1, 3, 1, 0, 0, 0,
						1, 3, 1, 0, 0, 0,
						3, 1, 2, 3, 9, 0,
						3, 1, 2, 3, 9, 0,
						2, 1, 2, 3, 4, 4
						};
		
		motor(genes, 0, 100, expected);
	}
	
	@Test
	public void test2() 
	{
		logger.info("test2");
		
		InputStream is = getClass().getResourceAsStream(GRAMMARTEST1);
		GeneradorGrammar.cargaGrama(is);
				
		String expected = 
			"R 2 3 1.0e0" + newLine +
			"R 3 2 2.4e5" + newLine +
			"R 4 5 3.8e9" + newLine +
			"R 7 0 2.2e2" + newLine +
			"R 8 0 3.4e9" + newLine +
			"R 9 0 3.8e9" + newLine +
			"Q 4 2 3 Q2N3904 nulo1" + newLine +
			"Q 6 7 0 Q2N3906 nulo2" + newLine;
		
			
		byte genes[] = { 
						1, 1, 2, 0, 0, 0,
						1, 2, 1, 1, 4, 5,
						1, 3, 4, 2, 8, 9,
						1, 6, 9, 1, 2, 2,
						1, 7, 9, 2, 4, 9,
						1, 8, 9, 2, 8, 9,
						3, 3, 1, 2, 0, 0,
						2, 5, 6, 0, 1, 1
						};
		
		motor(genes, 0, 100, expected);
	}
		
	@Test
	public void test3() 
	{
		logger.info("test3");
		
		InputStream is = getClass().getResourceAsStream(GRAMMARTEST1);
		GeneradorGrammar.cargaGrama(is);
				
		String expected = 
			"R 2 3 1.0e0" + newLine +
			"Q 4 2 3 Q2N3904 nulo1" + newLine +
			"R 7 0 2.2e2" + newLine +
			"R 3 2 2.4e5" + newLine +
			"R 4 5 3.8e9" + newLine +
			"R 9 0 3.8e9" + newLine +
			"Q 6 7 0 Q2N3906 nulo2" + newLine +
			"R 8 0 3.4e9" + newLine;
		
			
		byte genes[] = { 
						1, 1, 2, 0, 0, 0,
						3, 3, 1, 2, 0, 0,
						1, 6, 9, 1, 2, 2,
						1, 2, 1, 1, 4, 5,
						1, 3, 4, 2, 8, 9,
						1, 8, 9, 2, 8, 9,
						3, 5, 6, 0, 1, 1,
						0, 7, 9, 2, 4, 9						
						};
		
		motor(genes, 0, 100, expected);
	}
	
	
	public void motor(int [] genes, int MaxWrapping, int MaxRecursionLevel, String expected)
	{	
		//Aprovechamos el constructor que ademite cadenas de int
		Genotipo dummy = new Genotipo(genes);
		
		motor(dummy.getGenes(), MaxWrapping, MaxRecursionLevel, expected);
	}
	
	
	public void motor(byte [] genes, int MaxWrapping, int MaxRecursionLevel, String expected)
	{	
		GEProperties geproperties = new GEProperties();
		geproperties.setMaxWrappingNumber(MaxWrapping);
		geproperties.setMaxRecursionLevel(MaxRecursionLevel);
		
		try
		{
			Generador gen = new GeneradorGrammar(genes, geproperties);
			String actual = gen.genera();
			logger.info("actual: " + actual);
			logger.info("expected: " + expected);
			
			assertEquals(expected, actual);
		}
		catch(GenException e)
		{
			//e.printStackTrace();
			logger.severe(e.getMessage());
			fail(e.getMessage());
		}
	}

	

}
