package stock.stockmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {
    Stock stock;

    @BeforeEach
    void setUp()
    {
        stock = new Stock("Intel", "INTC", 26.4, 5, 30,
                "EEUU", "Communication Services", "Dollar", 2);
    }
    @Test
    void getName() {
        assertEquals("Intel", stock.getName());
    }

    @Test
    void getTicker() {
        assertEquals("INTC", stock.getTicker());
    }

    @Test
    void getCountry() {
        assertEquals("EEUU", stock.getCountry());
    }

    @Test
    void getSector() {
        assertEquals("Comunication Services", stock.getSector());
    }

    @Test
    void getCurrency() {
        assertEquals("Dollar", stock.getCurrency());
    }

    @Test
    void getPurchasePrice() {
        assertEquals(26.4, stock.getPurchasePrice());
    }

    @Test
    void getQuantity() {
        assertEquals(5, stock.getQuantity());
    }

    @Test
    void getActualPrice() {
        assertEquals(30, stock.getActualPrice());
    }

    @Test
    void getDividend() {
        assertEquals(2, stock.getDividend());
    }
}