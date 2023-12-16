package io.github.somethinginconspicuous.game;

public enum Location {
    HOSPITAL("[Go Back to Bed]", "[Observe Your Surroundings]", "", ""),
    HOSPITAL_ITEMS("[Sandwich]", "[Figure]", "[Door]", "[Wall]"),
    HALLWAY1("[Go Back]", "[Left]", "[Right]", ""),
    LOBBY("[Go Back]", "[Receptionist]", "[Staff Door]", "[Next Room]"),
    LARGE("[Go Back]", "[Store]", "[Quarters]", "[Emergancy Exit]"),
    STAFF("[Go Back]", "[Investigate Receptionist]", "", ""),
    ;

    private String[] choices;

    private Location(String... choices){
        this.choices = choices;
    }

    public String getChoice(int i){
        return choices[i];
    }

    public int numChoices(){
        return choices.length;
    }
}
