package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class KlijentTest {
	Klijent k;
	@BeforeEach
	public void setUp() throws Exception {
		k = new Klijent();
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testVratiListu() {
		ArrayList<AbstractDomainObject> lista = new ArrayList<>();
		Klijent k = new Klijent(44L, "Marko", "Markovic", "0622844313", "marko@gmail.com");
        
        lista.add(k);
        assertEquals(k, lista.get(0));
	}

	@Test
	public void testKlijent() {
		k = new Klijent();
		assertNotNull(k);
	}

	@Test
	public void testKlijentLongStringStringStringString() {
		k = new Klijent(124L, "Petar", "Petric", "061223457", "petar@gmail.com");
	}

	@Test
	public void testSetKlijentID() {
		k.setKlijentID(124L);
		assertEquals(124L, k.getKlijentID());
	}

	@Test
	public void testSetKlijentIDNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> k.setKlijentID(null) );
	}
	
	@Test
	public void testSetIme() {
		k.setIme("Petar");
		assertEquals("Petar", k.getIme());
	}

	@Test
	public void testSetImeNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> k.setIme(null) );
	}
	
	@Test
	public void testSetImeNedovoljno() {
		assertThrows(java.lang.RuntimeException.class,
				() -> k.setIme("A") );
	}
	
	@Test
	public void testSetPrezime() {
		k.setPrezime("Petric");
		assertEquals("Petric", k.getPrezime());
	}

	@Test
	public void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> k.setPrezime(null) );
	}
	
	@Test
	public void testSetPrezimeNedovoljno() {
		assertThrows(java.lang.RuntimeException.class,
				() -> k.setPrezime("A") );
	}
	
	@Test
	public void testSetBrojTelefona() {
		k.setBrojTelefona("0622412332");
		assertEquals("0622412332", k.getBrojTelefona());
	}

	@Test
	public void testSetBrojTelefonaNedovoljno() {
		assertThrows(java.lang.RuntimeException.class,
				() -> k.setBrojTelefona("123456789") );
	}
	
	@Test
	public void testSetEmail() {
		k.setEmail("petar@gmail.com");
		assertEquals("petar@gmail.com", k.getEmail());
	}
	
	@Test
	public void testSetEmailNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> k.setEmail(null) );
	}
	
	@Test
	public void testSetEmailNemaAt() {
		assertThrows(java.lang.RuntimeException.class,
				() -> k.setEmail("petargmail.com") );
	}

	@ParameterizedTest
	@CsvSource({
		"Marko, Markovic, Marko, Markovic, true",
		"Milan, Milanovic, Marko, Milanovic, false",
		"Marko, Milanovic, Milan, Markovic, false",
		"Marko, Markovic, Marko, Milanovic, false"
	})
	public void testEqualsObject(String ime1, String prezime1, String ime2, String prezime2, boolean eq) {
		k.setIme(ime1);
		k.setPrezime(prezime1);
		
		Klijent k2 = new Klijent();
		k2.setIme(ime2);
		k2.setPrezime(prezime2);
		
		assertEquals(eq, k.equals(k2));
	}

	@Test
	public void testToString() {
		k.setIme("Petar");
		k.setPrezime("Petric");
		
		String s = k.toString();
		assertTrue(s.contains("Petar"));
		assertTrue(s.contains("Petric"));
	}

}
