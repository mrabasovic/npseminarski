package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TerminTest {
	Termin t;
	
	@BeforeEach
	public void setUp() throws Exception {
		t = new Termin();
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testVratiListu() {
		ArrayList<AbstractDomainObject> lista = new ArrayList<>();
		Aranzman a = new Aranzman();
		Klijent k = new Klijent();
		TipPrevoza tp = new TipPrevoza();
		Date datumOd = new Date();
		Date datumDo = new Date();
		t = new Termin(a, 22, datumOd, datumDo, 500, 1, 550, k, tp);
		
        lista.add(t);
        assertEquals(t, lista.get(0));
	}

	@Test
	public void testTermin() {
		t = new Termin();
		assertNotNull(t);
	}

	@Test
	public void testTerminAranzmanIntDateDateDoubleDoubleDoubleKlijentTipPrevoza() {
		Aranzman a = new Aranzman();
		Klijent k = new Klijent();
		TipPrevoza tp = new TipPrevoza();
		Date datumOd = new Date();
		Date datumDo = new Date();
		t = new Termin(a, 22, datumOd, datumDo, 500, 1, 550, k, tp);
		
		assertNotNull(t);
		assertEquals(a, t.getAranzman());
		assertEquals(22, t.getTerminID());
		assertEquals(datumOd, t.getDatumOd());
		assertEquals(datumDo, t.getDatumDo());
		assertEquals(500, t.getCenaBezPDV());
		assertEquals(1, t.getPoreskaStopa());
		assertEquals(550, t.getCenaSaPDV());
		assertEquals(tp, t.getTipPrevoza());
	}

	@Test
	public void testSetTerminID() {
		t.setTerminID(123);
		assertEquals(123, t.getTerminID());
	}

	@Test
	public void testSetTerminIDNegativan() {
		assertThrows(java.lang.RuntimeException.class,
				() -> t.setTerminID(-2) );
	}
	
	@Test
	public void testSetDatumOd() {
		Date d = new Date();
		t.setDatumOd(d);
	}

	@Test
	public void testSetDatumOdNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> t.setDatumOd(null) );
	}
	
	@Test
	public void testSetDatumDo() {
		Date d = new Date();
		t.setDatumDo(d);
	}

	@Test
	public void testSetDatumDoNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> t.setDatumDo(null) );
	}
	
	@Test
	public void testSetCenaBezPDV() {
		t.setCenaBezPDV(500);
		assertEquals(500, t.getCenaBezPDV());
	}

	@Test
	public void testSetCenaBezPDVNegativna() {
		assertThrows(java.lang.RuntimeException.class,
				() -> t.setCenaBezPDV(-200) );
	}
	
	@Test
	public void testSetPoreskaStopa() {
		t.setPoreskaStopa(1);
		assertEquals(1, t.getPoreskaStopa());
	}

	@Test
	public void testSetPoreskaStopaNegativna() {
		assertThrows(java.lang.RuntimeException.class,
				() -> t.setPoreskaStopa(-2) );
	}
	
	@Test
	public void testSetCenaSaPDV() {
		t.setCenaSaPDV(520);
		assertEquals(520, t.getCenaSaPDV());
	}

	@Test
	public void testSetCenaSaPDVNegativna() {
		assertThrows(java.lang.RuntimeException.class,
				() -> t.setCenaSaPDV(-2) );
	}
	
	@Test
	public void testSetKlijent() {
		Klijent k = new Klijent();
		assertNotNull(k);
	}

	@Test
	public void testSetKlijentNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> t.setKlijent(null) );
	}
	
	@Test
	public void testSetTipPrevoza() {
		TipPrevoza tp = new TipPrevoza();
		assertNotNull(tp);
	}

	@Test
	public void testSetTipPrevozaNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> t.setTipPrevoza(null) );
	}
	
	@Test
	public void testSetAranzman() {
		Aranzman a = new Aranzman();
		assertNotNull(a);
	}
	
	@Test
	public void testSetAranzmanNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> t.setAranzman(null) );
	}

}
