import java.util.ArrayList;
import java.util.Collections;


class Deck {
    /*
        Kaarten:
        Harten, ruiten, klaveren, schoppen
        2 -> 10, J, Q, K
        A = 1 of 11
        J, Q, K = 10

     */
    private ArrayList<String> card_deck;

    Deck() {
        card_deck = new ArrayList<>();
    }

    Deck(boolean load) {
        card_deck = new ArrayList<>();
        if (load) { load_deck(); }
    }

    Deck(boolean load, boolean shuffle) {
        card_deck = new ArrayList<>();
        if (load)    { load_deck(); }
        if (shuffle) { shuffle_deck(); }
    }

    void load_deck()
    {
        // H = harten, R = ruiten, K = klaveren, S = schoppen
        char[] T = {'H', 'R', 'K', 'S'};
        int kleur_size = 13; // 13 kaarten per T ^

        for (char a : T)
        {
            for (int x = 1; x <= kleur_size; x++)
            {
                if      (x == 1)    { card_deck.add(a + "_" + "A"); }
                else if (x == 11)   { card_deck.add(a + "_" + "J"); }
                else if (x == 12)   { card_deck.add(a + "_" + "Q"); }
                else if (x == 13)   { card_deck.add(a + "_" + "K"); }
                else                { card_deck.add(a + "_" + String.valueOf(x)); }
            }
        }
    }

    int count_deck()
    {
        /*
            A = 1 of 11
            K, Q, J = 10
         */
        int out = 0;
        System.out.println("Counting cards... - " + this);
        for (String card : card_deck)
        {
            String[] parts = card.split("_");

            if (parts[1].matches("[KQJ]")) {
                // System.out.println("Match: Value = 10");
                out += 10;
            }
            else if (parts[1].equals("A")) {
                // System.out.println("Match: ACE - value = 11");
                out += 11;
            }
            else {
                // System.out.println("Match: " + parts[1] + " - normal value");
                out += Integer.parseInt(parts[1]);
            }
        }
        // System.out.println("Out: "+ out);
        return out;
    }

    void shuffle_deck()
    {
        Collections.shuffle(card_deck);
    }

    void add_card(String card) {
        card_deck.add(card);
    }

    void print_deck()
    {
        for (String s : card_deck)
        {
            System.out.println("Kaart: " + s);
        }
    }

    void reset()
    {
        card_deck = new ArrayList<>();
    }

    String get_top_card()
    {
        return card_deck.get(card_deck.size() - 1);
    }

    String pop_top_card()
    {
        String out = get_top_card();
        card_deck.remove(card_deck.size() - 1);
        return out;
    }

    int deck_size()
    {
        return card_deck.size();
    }

    String get_deck() {
        StringBuilder out = new StringBuilder();

        for (String w : card_deck )
        {
            out.append(w).append(" ");
        }
        return out.toString();
    }
}
