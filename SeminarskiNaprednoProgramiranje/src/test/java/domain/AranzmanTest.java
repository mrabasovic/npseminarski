package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AranzmanTest {
	Aranzman a;
	@BeforeEach
	public void setUp() throws Exception {
		a = new Aranzman();
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testVratiListu() {
		ArrayList<AbstractDomainObject> lista = new ArrayList<>();
		Vodic v = new Vodic(123L, "Mladen", "Rabasovic", "0607272919", "mladen@gmail", 5);
        Hotel h = new Hotel(12L, "Iberostar", "Becici");
        ArrayList<Termin> termini = new ArrayList<>();
		a = new Aranzman(123L, "Odmor u Egiptu", v, h, termini);
        lista.add(v);
        assertEquals(v, lista.get(0));
	}

	@Test
	public void testAranzman() {
		a = new Aranzman();
		assertNotNull(a);
	}

	@Test
	public void testAranzmanLongStringVodicHotelArrayListOfTermin() {
		Vodic v = new Vodic();
		Hotel h = new Hotel();
		ArrayList<Termin> termini = new ArrayList<>();
		a = new Aranzman(123L, "Odmor u Egiptu", v, h, termini);
		assertNotNull(a);
		assertEquals(123L, a.getAranzmanID());
		assertEquals("Odmor u Egiptu", a.getOpis());
		assertEquals(v, a.getVodic());
		assertEquals(h, a.getHotel());
		assertEquals(termini, a.getTermini());
	}

	@Test
	public void testSetAranzmanID() {
		a.setAranzmanID(123L);
		assertEquals(123L, a.getAranzmanID());
	}
	
	@Test
	public void testSetAranzmanIDNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setAranzmanID(null) );
	}

	@Test
	public void testSetOpis() {
		a.setOpis("Odmor u Spaniji");
		assertEquals("Odmor u Spaniji", a.getOpis());
	}

	@Test
	public void testSetOpisNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setOpis(null) );
	}
	
	@Test
	public void testSetVodic() {
		Vodic v = new Vodic();
		a.setVodic(v);
		assertEquals(v, a.getVodic());
	}
	
	@Test
	public void testSetVodicNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setVodic(null) );
	}

	@Test
	public void testSetHotel() {
		Hotel h = new Hotel();
		a.setHotel(h);
		assertEquals(h, a.getHotel());
	}
	
	@Test
	public void testSetHotelNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setHotel(null) );
	}

	@Test
	public void testSetTermini() {
		ArrayList<Termin> termini = new ArrayList<>();
		a.setTermini(termini);
		assertEquals(termini, a.getTermini());
	}
	
	@Test
	public void testSetTerminiNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setTermini(null) );
	}
	
	

}
