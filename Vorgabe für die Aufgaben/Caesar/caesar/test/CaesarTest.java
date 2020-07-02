package caesar.test;

import caesar.Caesar;

import org.junit.Test;
import static org.junit.Assert.*;

public class CaesarTest {

	@Test
	public void encrypt() {
		Caesar c = new Caesar(7);
		
		assertEquals("ALZA", c.encrypt("TEST"));
		assertEquals("HIJKLMN", c.encrypt("ABCDEFG"));
		assertEquals("JHLZHY", c.encrypt("CAESAR"));
		assertEquals("PUMV", c.encrypt("INFO"));
		assertEquals("RSHBZBYGBSHZZBUN", c.encrypt("KLAUSURZULASSUNG"));
		assertEquals("test", c.encrypt("test"));
		assertEquals("Oallo", c.encrypt("Hallo"));
		
		c = new Caesar(-7);
		
		assertEquals("MXLM", c.encrypt("TEST"));
		assertEquals("TUVWXYZ", c.encrypt("ABCDEFG"));
		assertEquals("VTXLTK", c.encrypt("CAESAR"));
		assertEquals("BGYH", c.encrypt("INFO"));
		assertEquals("DETNLNKSNETLLNGZ", c.encrypt("KLAUSURZULASSUNG"));
		assertEquals("test", c.encrypt("test"));
		assertEquals("Aallo", c.encrypt("Hallo"));
		
		c = new Caesar(19);
		
		assertEquals("MXLM", c.encrypt("TEST"));
		assertEquals("TUVWXYZ", c.encrypt("ABCDEFG"));
		assertEquals("VTXLTK", c.encrypt("CAESAR"));
		assertEquals("BGYH", c.encrypt("INFO"));
		assertEquals("DETNLNKSNETLLNGZ", c.encrypt("KLAUSURZULASSUNG"));
		assertEquals("test", c.encrypt("test"));
		assertEquals("Aallo", c.encrypt("Hallo"));
		
		c = new Caesar(0);
		
		assertEquals("TEST", c.encrypt("TEST"));
		assertEquals("ABCDEFG", c.encrypt("ABCDEFG"));
		assertEquals("CAESAR", c.encrypt("CAESAR"));
		assertEquals("INFO", c.encrypt("INFO"));
		assertEquals("KLAUSURZULASSUNG", c.encrypt("KLAUSURZULASSUNG"));
		assertEquals("test", c.encrypt("test"));
		assertEquals("Hallo", c.encrypt("Hallo"));
		
		c = new Caesar(35);
		
		assertEquals("TEST", c.encrypt("TEST"));
		assertEquals("ABCDEFG", c.encrypt("ABCDEFG"));
		assertEquals("CAESAR", c.encrypt("CAESAR"));
		assertEquals("INFO", c.encrypt("INFO"));
		assertEquals("KLAUSURZULASSUNG", c.encrypt("KLAUSURZULASSUNG"));
		assertEquals("test", c.encrypt("test"));
		assertEquals("Hallo", c.encrypt("Hallo"));
	}
	
	@Test
	public void decrypt() {
		Caesar c = new Caesar(7);
		
		assertEquals("TEST", c.decrypt("ALZA"));
		assertEquals("ABCDEFG", c.decrypt("HIJKLMN"));
		assertEquals("CAESAR", c.decrypt("JHLZHY"));
		assertEquals("INFO", c.decrypt("PUMV"));
		assertEquals("KLAUSURZULASSUNG", c.decrypt("RSHBZBYGBSHZZBUN"));
		assertEquals("test", c.decrypt("test"));
		assertEquals("Hallo", c.decrypt("Oallo"));
		
		c = new Caesar(-7);
		
		assertEquals("TEST", c.decrypt("MXLM"));
		assertEquals("ABCDEFG", c.decrypt("TUVWXYZ"));
		assertEquals("CAESAR", c.decrypt("VTXLTK"));
		assertEquals("INFO", c.decrypt("BGYH"));
		assertEquals("KLAUSURZULASSUNG", c.decrypt("DETNLNKSNETLLNGZ"));
		assertEquals("test", c.decrypt("test"));
		assertEquals("Hallo", c.decrypt("Aallo"));
		
		c = new Caesar(19);
		
		assertEquals("TEST", c.decrypt("MXLM"));
		assertEquals("ABCDEFG", c.decrypt("TUVWXYZ"));
		assertEquals("CAESAR", c.decrypt("VTXLTK"));
		assertEquals("INFO", c.decrypt("BGYH"));
		assertEquals("KLAUSURZULASSUNG", c.decrypt("DETNLNKSNETLLNGZ"));
		assertEquals("test", c.decrypt("test"));
		assertEquals("Hallo", c.decrypt("Aallo"));
		
		c = new Caesar(0);
		
		assertEquals("TEST", c.decrypt("TEST"));
		assertEquals("ABCDEFG", c.decrypt("ABCDEFG"));
		assertEquals("CAESAR", c.decrypt("CAESAR"));
		assertEquals("INFO", c.decrypt("INFO"));
		assertEquals("KLAUSURZULASSUNG", c.decrypt("KLAUSURZULASSUNG"));
		assertEquals("test", c.decrypt("test"));
		assertEquals("Hallo", c.decrypt("Hallo"));
		
		c = new Caesar(35);
		
		assertEquals("TEST", c.decrypt("TEST"));
		assertEquals("ABCDEFG", c.decrypt("ABCDEFG"));
		assertEquals("CAESAR", c.decrypt("CAESAR"));
		assertEquals("INFO", c.decrypt("INFO"));
		assertEquals("KLAUSURZULASSUNG", c.decrypt("KLAUSURZULASSUNG"));
		assertEquals("test", c.decrypt("test"));
		assertEquals("Hallo", c.decrypt("Hallo"));
	}
}