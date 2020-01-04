class BlackJack {
    private Deck deck;
    private Deck player;
    private Deck dealer;

    BlackJack() {
        deck = new Deck(true, true);     // Card deck, init (load deck), and shuffle

        player = new Deck();   // Player hand
        dealer = new Deck();   // Dealer hand
    }

    void play() {
        // Starting, draw 2 cards for dealer and player
        draw_card(deck, player);
        draw_card(deck, player);

        draw_card(deck, dealer);
        draw_card(deck, dealer);

        //System.out.println("Dealer : " + get_value(dealer));
        //dealer.print_deck();

        //System.out.println("Player : " + get_value(player));
        //player.print_deck();

    }

    void dealer_plays() {
        boolean playing = true;
        int p_val = get_value("player");
        int d_val = get_value("dealer");

        while (playing) {
            if (d_val < 17 || ( p_val > d_val && p_val <= 21) ) {
                // hit
                System.out.println("dealer - hit");
                draw_card(deck, dealer);
                d_val = get_value("dealer");
            } else {
                // stand
                playing = false;
            }
        }

        System.out.println("dealer count: " + d_val );
    }

    char check_win() {   // true -> player wins, else false
        int p_val = get_value("player");
        int d_val = get_value("dealer");
        if (p_val == d_val ) { return 'T'; }                                    // TIE
        else if (p_val > d_val && p_val <= 21 || d_val > 21) { return 'W'; }    // WIN
        else { return 'L'; }                                                    // LOSS
    }

    int get_value(String who) {
        return who.equals("player") ? player.count_deck() : dealer.count_deck();
    }

    private void draw_card(Deck source, Deck dest) {
        dest.add_card( source.pop_top_card() );
    }

    void draw_card(String who) {
        if (who.equals("player")) {
            player.add_card(deck.pop_top_card());
        } else {
            dealer.add_card(deck.pop_top_card());
        }
    }

    String show_cards(String who, int amount) {
        return who.equals("player") ? player.get_deck() : dealer.get_top_card();
    }
    String show_cards(String who) {
        return who.equals("player") ? player.get_deck() : dealer.get_top_card();
    }

    void reset() {
        deck = new Deck(true, true);
        player.reset();
        dealer.reset();
    }
}
