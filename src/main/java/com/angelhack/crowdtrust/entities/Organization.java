package com.angelhack.crowdtrust.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by David Useche on 4/08/2018.
 */

public class Organization implements Serializable{

    String name;
    int id;
    List<Proyect> proyects;

}
