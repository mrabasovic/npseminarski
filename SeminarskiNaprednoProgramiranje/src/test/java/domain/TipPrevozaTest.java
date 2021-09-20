package domain;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TipPrevozaTest {
	TipPrevoza tp;
	
	@BeforeEach
	public void setUp() throws Exception {
		tp = new TipPrevoza();
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testVratiListu() {
		ArrayList<AbstractDomainObject> lista = new ArrayList<>();
		TipPrevoza tp = new TipPrevoza(1L, "Autobus");
        
        lista.add(tp);
        assertEquals(tp, lista.get(0));
	}
	
	@Test
	public void testTipPrevoza() {
		tp = new TipPrevoza();
		assertNotNull(tp);
	}

	@Test
	public void testTipPrevozaLongString() {
		tp = new TipPrevoza(553L, "Autobuski prevoz");
		assertNotNull(tp);
		assertEquals(553L, tp.getTipPrevozaID());
		assertEquals("Autobuski prevoz", tp.getOpis());
	}

	@Test
	public void testSetTipPrevozaID() {
		tp.setTipPrevozaID(552L);
		assertEquals(552L, tp.getTipPrevozaID());
	}
	
	@Test
	public void testSetTipPrevozaIDNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> tp.setTipPrevozaID(null) );
	}

	@Test
	public void testSetOpis() {
		tp.setOpis("Tip prevoza je avion");
		assertEquals("Tip prevoza je avion", tp.getOpis());
	}
	
	@Test
	public void testSetOpisNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> tp.setOpis(null) );
	}

	@Test
	public void testToString() {
		tp.setOpis("Sopstveni prevoz");
		String s = tp.toString();
		assertTrue(s.contains("Sopstveni prevoz"));
	}

}
