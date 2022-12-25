package ba.unsa.etf.rpr;

/**
 * Implementacija BazaDao klase kao primjera jedne "Data Access Object" koja ce raditi s bazom.
 * Poenta Singleton patterna je u tome sto pozivanje "stvaranja" instance nece napraviti dvije instance klase koja radi
 * s bazom. U slucaju da se to desilo, u programu bi moglo doci do kraha s radom s bazom, jer bi bila otvorena s dvije instance.
 * Ovako je baza bezbijedna i moze normalno da radi sa jednom instancom.
 * Otvaranje baze i njeno regeneriranje je jako skup proces pogotovo kada je rijec o nekim realnim problemima i podacima.
 *
 */
public class BazaDao {
    private static BazaDao INSTANCE = null;

    /**
     * Dodavanjem privatnog konstruktora mi smo ogranicili onog ko zeli instancirati klasu, da to mora uraditi
     * sa metodom getInstance() u suprotnom nece moci drugacije. Ta metoda mu svakako nece dati da instancira vise
     * instanci ove klase, samim tim dobili smo singleton pattern.
     * KLJUČNO - Privatni konstruktor
     */
    private BazaDao() {}

    /**
     * Metoda getInstance() ne da pravljenje vise od jedne instance ove klase
     * Poenta svega ovoga je u tome da vam vise objekata moze raditi sa jednom instancom, vise ljudi isti posao.
     */
    public static BazaDao getInstance() {
        if(INSTANCE == null)
            INSTANCE = new BazaDao();
        return INSTANCE;
    }

    /**
     * Metoda remove instance samo uklanja instancu klase BazaDao i omogucava otvaranje baze
     * ponovo pozivom metode getInstance();
     */
    public static void removeInstance() {
        if (INSTANCE != null)
            INSTANCE = null;
    }
}
