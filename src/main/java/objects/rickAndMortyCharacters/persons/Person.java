package objects.rickAndMortyCharacters.persons;

import objects.rickAndMortyCharacters.persons.Loc;
import objects.rickAndMortyCharacters.persons.Orig;

import java.util.ArrayList;
import java.util.Date;

public class Person{
    public int id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Orig origin;
    public Loc location;
    public String image;
    public ArrayList<String> episode;
    public String url;
    public Date created;
}