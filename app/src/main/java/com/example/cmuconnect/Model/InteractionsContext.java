package com.example.cmuconnect.Model;

public class InteractionsContext {

    private PostInteractions interaction;

    public InteractionsContext(PostInteractions interaction)
    {
        this.interaction = interaction;
    }

    public Object interact()
    {
        return interaction.interact();
    }

}
