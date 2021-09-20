package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HotelTest {

	Hotel h;
	@BeforeEach
	public void setUp() throws Exception {
		h = new Hotel();
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testVratiListu() {
		ArrayList<AbstractDomainObject> lista = new ArrayList<>();
		Hotel h = new Hotel(77L, "Iberostar", "Becici");
        
        lista.add(h);
        assertEquals(h, lista.get(0));
	}

	@Test
	public void testHotel() {
		h = new Hotel();
		assertNotNull(h);
	}

	@Test
	public void testHotelLongStringString() {
		h = new Hotel(123L, "Hilton", "Beograd");
		assertNotNull(h);
		assertEquals(123L, h.getHotelID());
		assertEquals("Hilton", h.getNazivHotela());
		assertEquals("Beograd", h.getGrad());
	}

	@Test
	public void testSetHotelID() {
		h.setHotelID(123L);
		assertEquals(123L, h.getHotelID());
	}

	@Test
	public void testSetHotelIDNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> h.setHotelID(null) );
	}
	
	@Test
	public void testSetNazivHotela() {
		h.setNazivHotela("Hilton");
		assertEquals("Hilton", h.getNazivHotela());
	}

	@Test
	public void testSetNazivHotelaNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> h.setNazivHotela(null) );
	}
	
	@Test
	public void testSetGrad() {
		h.setGrad("Beograd");
		assertEquals("Beograd", h.getGrad());
	}

	@Test
	public void testSetGradNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> h.setGrad(null) );
	}
	
	@Test
	public void testToString() {
		h.setNazivHotela("Hilton");
		String s = h.toString();
		assertTrue(s.contains("Hilton"));
	}

}
