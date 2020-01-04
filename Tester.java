
public class Tester {
    public static void main(String[] args) {

        BlackJack game = new BlackJack();

        game.play();


        /*
        Deck deck = new Deck(true, true);
        Deck play = new Deck();
        play.add_card(deck.pop_top_card());
        play.add_card(deck.pop_top_card());

        play.print_deck();
        int x = play.count_deck();
        System.out.println("cards value: " + x);
        */

        /*
        Deck deck = new Deck();
        deck.load_deck(); // Init dealer deck

        Deck player = new Deck();   // Cards player has in hand

        // draw two cards:
        player.add_card(deck.pop_top_card());
        player.add_card(deck.pop_top_card());

        player.print_deck();
        */
    }

    /*
        System.out.println( deck.get_top_card() );
        //deck.shuffle_deck();
        System.out.println( deck.get_top_card() );

        System.out.println( deck.pop_top_card() );
        System.out.println( deck.pop_top_card() );
        System.out.println( deck.pop_top_card() );
        // deck.print_deck();

     */
}
