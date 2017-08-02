package com.coyne;

import java.util.Random;

public class JokeClass {

    String[] Jokes = new String[]
    {
        "I was watching the London Marathon and saw one runner dressed as a chicken and another runner dressed as an egg. I thought: 'This could be interesting'.",
            "I needed a password eight characters long so I picked Snow White and the Seven Dwarfs.",
            "I went to buy some camouflage trousers the other day but I couldn't find any.",
            "Hedgehogs – why can’t they just share the hedge?",
            "You can’t lose a homing pigeon. If your homing pigeon doesn’t come back, then what you’ve lost is a pigeon.",
            "I saw a documentary on how ships are kept together. Riveting!",
            "I never forget a face, but in your case I'll be glad to make an exception",
            "There are so many scams on the Internet these days....but for $19.95 I can show you how to avoid them",
            "I'm great at multitasking. I can waste time, be unproductive, and procrastinate all at once."
    };

    public String GetRandomJoke(){
        Random rand = new Random();
        String joke = Jokes[rand.nextInt(Jokes.length)];
        return joke;
    }
}
