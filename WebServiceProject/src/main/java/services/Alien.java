package services;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {

    private String name;
    private int points;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
